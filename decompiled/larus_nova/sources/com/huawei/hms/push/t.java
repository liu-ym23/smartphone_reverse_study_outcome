package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class t {
    public static void a(Context r100, Intent r101) {
        if (r100 == null) goto L23;
        if (r101 == null) goto L23;
        String r102 = r101.getAction();     // Catch: Exception -> L25 RuntimeException -> L26
        if ("com.huawei.intent.action.PUSH".equals(r102) == false) goto L9;
    L12:
        byte[] r103 = r101.getByteArrayExtra("selfshow_info");     // Catch: Exception -> L25 RuntimeException -> L26
        byte[] r104 = r101.getByteArrayExtra("selfshow_token");     // Catch: Exception -> L25 RuntimeException -> L26
        if (r103 == null) goto L21;
        if (r104 == null) goto L21;
        if (r103.length == 0) goto L21;
        if (r104.length == 0) goto L21;
        a(r100, r101, r103, r104);     // Catch: Exception -> L25 RuntimeException -> L26
        return;
    L21:
        HMSLog.i("PushSelfShowLog", "self show info or token is null.");     // Catch: Exception -> L25 RuntimeException -> L26
        return;
    L9:
        if ("com.huawei.push.msg.NOTIFY_MSG".equals(r102) == true) goto L12;
        if ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(r102) == true) goto L12;
        return;
    L23:
        HMSLog.d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");     // Catch: Exception -> L25 RuntimeException -> L26
        return;
    L26:
        e = move-exception;
        HMSLog.e("PushSelfShowLog", "onReceive RuntimeException.", e);
        return;
    L25:
        HMSLog.d("PushSelfShowLog", "onReceive Exception.");
    }

    private static void a(Context r100, Intent r101, o r102) {
        HMSLog.i("PushSelfShowLog", "receive a selfshow message, the cmd type is " + r102.h());
        if (u.a(r102.h()) == true) goto L5;
        return;
    L5:
        new p(r100, r102).start();
    }

    private static void a(Context r100, Intent r101, byte[] r102, byte[] r103) {
        String r104 = r101.getStringExtra("selfshow_event_id");
        int r105 = r101.getIntExtra("selfshow_notify_id", 0);
        HMSLog.i("PushSelfShowLog", "get notifyId:" + r105);
        o r106 = new o(r102, r103);
        if (r106.y() == true) goto L6;
        HMSLog.d("PushSelfShowLog", "parseMessage failed");
        return;
    L6:
        HMSLog.i("PushSelfShowLog", "onReceive the msg id = " + r106.o() + ",and cmd is " + r106.h() + ",and the eventId is " + r104);
        if (r104 != null) goto L9;
        a(r100, r101, r106);
        return;
    L9:
        a(r100, r101, r104, r106, r105);
    }

    private static void a(Context r100, Intent r101, String r102, o r103, int r104) {
        HMSLog.d("PushSelfShowLog", "receive a selfshow user handle message eventId = " + r102);
        if ("1".equals(r102) == false) goto L6;
        new u(r100, r103).c();
        PluginUtil.onNotificationClicked(r100, r103.o(), r103.b());
        return;
    L6:
        if ("2".equals(r102) == false) goto L8;
        l.a(r100, r103.o(), r103.b(), "2");
        return;
    L8:
        HMSLog.d("PushSelfShowLog", "other event");
    }
}
