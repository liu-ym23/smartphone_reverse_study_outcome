package com.bytedance.notification;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.notification.helper.c;
import com.bytedance.push.utils.f;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class NotificationDeleteBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f266019a;

    public static synchronized void c() {
        monitor-enter(NotificationDeleteBroadcastReceiver.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f266019a == false) goto L8;
        monitor-exit(NotificationDeleteBroadcastReceiver.class);
        return;
    L8:
        Application r100 = AppProvider.getApp();     // Catch: Throwable -> L15
        IntentFilter r101 = new IntentFilter(r100.getPackageName() + a());     // Catch: Throwable -> L15
        if (ToolUtils.isSmpProcess(AppProvider.getApp()) == false) goto L11;
        BroadcastReceiver r102 = new SmpNotificationDeleteBroadcastReceiver();     // Catch: Throwable -> L15
    L12:
        f.b("NotificationDeleteBroadcastReceiver", "register " + a() + " -->" + r102);     // Catch: Throwable -> L15
        PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(r100, r102, r101);     // Catch: Throwable -> L15
        f266019a = true;     // Catch: Throwable -> L15
        monitor-exit(NotificationDeleteBroadcastReceiver.class);
        return;
    L11:
        r102 = new NotificationDeleteBroadcastReceiver();     // Catch: Throwable -> L15
        goto L12
    }

    public static String a() {
        if (ToolUtils.isSmpProcess(AppProvider.getApp()) == false) goto L6;
        return ".pushsdk.notification.delete.action.smp";
    L6:
        return ".pushsdk.notification.delete.action";
    }

    public NotificationDeleteBroadcastReceiver() {
    }

    public boolean b(String r100, Context r101) {
        return TextUtils.equals(r100, r101.getPackageName() + ".pushsdk.notification.delete.action");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (b(r101.getAction(), r100) == false) goto L46;
        Bundle r102 = r101.getExtras();
        if (r102 != null) goto L7;
        return;
    L7:
        String r103 = r102.getString(SeiMessageConst.MSG_TYPE, "notification");
        if (TextUtils.equals(r103, "notification") == false) goto L36;
        String r104 = r101.getStringExtra("group");
        if (TextUtils.isEmpty(r104) == true) goto L27;
        c r105 = c.a();
        r105.getClass();
        if (TextUtils.isEmpty(r104) == true) goto L27;
        f.b("NotificationGroupHelper", "on notification delete , group is " + r104);
        Map<String, Integer> r106 = r105.f266076b;
        monitor-enter(r106);
        Integer r107 = (Integer) ((ConcurrentHashMap) r105.f266076b).get(r104);     // Catch: Throwable -> L24
        if (r107 != null) goto L19;
    L20:
        r107 = 1;     // Catch: Throwable -> L24
    L21:
        ((ConcurrentHashMap) r105.f266076b).put(r104, Integer.valueOf(r107.intValue() - 1));     // Catch: Throwable -> L24
        monitor-exit(r106);     // Catch: Throwable -> L24
        goto L27
    L19:
        if (r107.intValue() != 0) goto L21;
    L24:
        th = move-exception;
        throw th;
    L27:
        long r108 = r101.getLongExtra("msg_id", -1);
        JSONObject r109 = null;
        String r110 = r101.getStringExtra("extra");     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r110) == true) goto L34;
        r109 = new JSONObject(r110);     // Catch: Throwable -> L32
    L34:
        f.b("NotificationDeleteBroadcastReceiver", "on notification delete , msgId is " + r108);
        PushServiceManager.get().getPushExternalService().onNotificationDelete(r108, r109);
        return;
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L36:
        if (TextUtils.equals(r103, "summary_notification") == false) goto L48;
        String r111 = r101.getStringExtra("group");
        f.b("NotificationDeleteBroadcastReceiver", "on summary notification delete , group is " + r111);
        c r112 = c.a();
        r112.getClass();
        if (TextUtils.isEmpty(r111) == true) goto L49;
        f.b("NotificationGroupHelper", "on summary notification delete , group is " + r111);
        ((ConcurrentHashMap) r112.f266075a).put(r111, Boolean.FALSE);
        return;
    L49:
        return;
    L48:
        return;
    }
}
