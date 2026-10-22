package com.bytedance.notification.supporter.impl;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.BaseJson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends BaseJson {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotificationManager f266093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f266094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f266095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f266096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f266097e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f266098f;

        public final void a() {
            if (Build.VERSION.SDK_INT < 23) goto L14;
            StatusBarNotification[] r100 = this.f266093a.getActiveNotifications();
            int r101 = r100.length;
            boolean r102 = false;
            int r103 = 0;
        L5:
            if (r103 >= r101) goto L14;
            StatusBarNotification r104 = r100[r103];
            if (r104.getId() != this.f266094b) goto L13;
            if (TextUtils.equals(r104.getTag(), this.f266095c) == false) goto L13;
            if (this.f266098f.d(r104) == true) goto L14;
        L15:
            this.f266098f.add(this.f266096d, "id", this.f266094b);
            this.f266098f.add(this.f266096d, "tag", this.f266095c);
            this.f266098f.add(this.f266096d, "clear_reason", this.f266097e);
            this.f266098f.add(this.f266096d, "clear_result", r102);
            PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_clear_notification", this.f266096d);
            return;
        L13:
            r103 = r103 + 1;
        L14:
            r102 = true;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100, NotificationManager r101, int r102, String r103, JSONObject r104, String r105) {
            this.f266098f = r100;
            this.f266093a = r101;
            this.f266094b = r102;
            this.f266095c = r103;
            this.f266096d = r104;
            this.f266097e = r105;
        }
    }

    public b() {
    }

    public final JSONObject b(Bundle r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Set<String> r102 = r100.keySet();
        if (r102 == null) goto L14;
        Iterator<String> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        Object r105 = r100.get(r104);
        if ((r105 instanceof Intent) == true) goto L12;
        add(r101, r104, String.valueOf(r105));
        goto L9
    L12:
        add(r101, r104, b(((Intent) r105).getExtras()));
    L14:
        return r101;
    }

    public final boolean d(StatusBarNotification r100) {
        String r101 = r100.getTag();
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        Notification r102 = r100.getNotification();
        if (r102 == null) goto L14;
        String r103 = r102.getGroup();
        if (TextUtils.isEmpty(r103) == true) goto L14;
        if (r103.contains("ranker_group") == false) goto L14;
        return true;
    L14:
        Bundle r104 = r100.getNotification().extras;
        if (r104 != null) goto L17;
        return false;
    L17:
        if (TextUtils.equals(r104.getString(NotificationCompat.EXTRA_TITLE), "GroupSummary") == false) goto L19;
    L20:
        return true;
    L19:
        if (TextUtils.equals(r104.getString(NotificationCompat.EXTRA_TEXT), "GroupSummary") == true) goto L20;
        return false;
    L5:
        if (r101.contains("ranker_group") == false) goto L7;
        return true;
    }

    public final void c(String r110, String r111, int r112) {
        com.bytedance.push.utils.f.b("NotificationClearServiceImpl", "[clearItemNotification]notificationId:" + r112 + " tag:" + r111);
        NotificationManager r100 = (NotificationManager) AppProvider.getApp().getSystemService("notification");
        JSONObject r101 = new JSONObject();
        if (TextUtils.isEmpty(r111) == true) goto L5;
        add(r101, "tag", r111);
        r100.cancel(r111, r112);
    L18:
        Method r102 = r100.getClass().getDeclaredMethod("cancelAsPackage", new Class[]{String.class, String.class, Integer.TYPE});     // Catch: Throwable -> L14
        if (r102 == null) goto L16;
        com.bytedance.push.utils.f.b("NotificationClearServiceImpl", "[clearItemNotification]invoke cancelAsPackage");     // Catch: Throwable -> L14
        Object[] r103 = new Object[3];     // Catch: Throwable -> L14
        r103[0] = AppProvider.getApp().getPackageName();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r111) == false) goto L11;
        String r104 = "";
    L12:
        r103[1] = r104;     // Catch: Throwable -> L14
        r103[2] = Integer.valueOf(r112);     // Catch: Throwable -> L14
        r102.invoke(r100, r103);     // Catch: Throwable -> L14
        goto L16
    L11:
        r104 = r111;
    L16:
        PushThreadHandlerManager.inst().postRunnable(new a(this, r100, r112, r111, r101, r110), 2000);
        return;
    L14:
        th = move-exception;
        com.bytedance.push.utils.f.e("NotificationClearServiceImpl", "[clearItemNotification]exception:" + th.getLocalizedMessage());
        goto L16
    L5:
        r100.cancel(r112);
        goto L18
    }
}
