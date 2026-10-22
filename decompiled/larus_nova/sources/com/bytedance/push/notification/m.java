package com.bytedance.push.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.push.c.b f266981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f266982b;

    public final void a() {
        com.bytedance.push.c.b r100 = this.f266981a;
        String r101 = this.f266982b.getString(R.string.push_notification_channel_name);
        if (r100 != null) goto L6;
        r100 = new com.bytedance.push.c.b(r101);
    L18:
        String r102 = r100.f266815b;
        String r103 = r100.f266814a;
        NotificationManager r104 = (NotificationManager) this.f266982b.getSystemService("notification");
        if (r104 != null) goto L22;
        return;
    L22:
        if (r104.getNotificationChannel(r102) != null) goto L25;
        NotificationChannel r105 = new NotificationChannel(r102, r103, 4);
        r105.setShowBadge(true);
        r105.enableVibration(true);
        r105.enableLights(true);
        r104.createNotificationChannel(r105);
        return;
    L25:
        return;
    L6:
        if (TextUtils.isEmpty(r100.f266815b) == false) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == true) goto L18;
        if (TextUtils.isEmpty(r100.f266815b) == false) goto L16;
        r100.f266815b = "push";
    L16:
        if (TextUtils.isEmpty(r100.f266814a) == false) goto L18;
        r100.f266814a = r101;
        goto L18
    L8:
        if (TextUtils.isEmpty(r100.f266814a) == true) goto L10;
        r106 = true;
        goto L11
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

    public m(com.bytedance.push.c.b r100, Context r101) {
        this.f266981a = r100;
        this.f266982b = r101;
    }
}
