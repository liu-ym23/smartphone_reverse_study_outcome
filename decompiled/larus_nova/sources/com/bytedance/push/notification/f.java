package com.bytedance.push.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.collection.SieveCacheKt;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.PushBody;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f266952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f266953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PushBody f266954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f266955d;

    public final void a() {
        v67.l r100 = this.f266955d.f266960a;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        h r101 = this.f266955d;
        Context r102 = this.f266952a;
        PushBody r103 = this.f266954c;
        r101.getClass();
        boolean r104 = false;
        NotificationManager r105 = (NotificationManager) r102.getSystemService("notification");     // Catch: Throwable -> L23
        int r106 = (int) (r103.f266734w % SieveCacheKt.NodeLinkMask);     // Catch: Throwable -> L23
        if (Build.VERSION.SDK_INT < 23) goto L20;
        StatusBarNotification[] r107 = r105.getActiveNotifications();     // Catch: Throwable -> L23
        if (r107 == null) goto L19;
        int r108 = r107.length;     // Catch: Throwable -> L23
        int r109 = 0;
    L11:
        if (r109 >= r108) goto L19;
        StatusBarNotification r110 = r107[r109];     // Catch: Throwable -> L23
        if (r110 != null) goto L16;
    L18:
        r109 = r109 + 1;     // Catch: Throwable -> L23
        goto L11
    L16:
        if (r110.getId() != r106) goto L18;
    L19:
        boolean r111 = false;
    L21:
        r105.cancel("app_notify", r106);     // Catch: Throwable -> L23
    L25:
        if (r111 == false) goto L28;
        r104 = true;
    L28:
        if (r104 == false) goto L40;
        i77.a r112 = (i77.a) rgc.b.a(i77.a.class);
        PushBody r113 = r112.y0(this.f266954c.f266734w);
        int r114 = r112.A0(r113);
        if (r114 != 0) goto L32;
        r114 = this.f266953b;
    L32:
        h r115 = this.f266955d;
        PushBody r116 = this.f266954c;
        int r117 = this.f266953b;
        r115.getClass();
        ThreadPlus.submitRunnable(new g(r113, r116, r114, r117));
        return;
    L40:
        return;
    L20:
        r111 = true;
    L23:
        th = move-exception;
        th.printStackTrace();
        r111 = false;
        goto L25
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

    public f(h r100, Context r101, int r102, PushBody r103) {
        this.f266955d = r100;
        this.f266952a = r101;
        this.f266953b = r102;
        this.f266954c = r103;
    }
}
