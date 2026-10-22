package com.ss.android.newmedia.redbadge;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.PushThreadHandlerManager;
import kfc.d;

/* JADX INFO: loaded from: classes38.dex */
public class RedBadgePushProcessService extends Service {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f449141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ zfc.a.b f449142b;

        public final void a() {
            if (this.f449141a != null) goto L5;
            return;
        L5:
            zfc.a.b r100 = this.f449142b;
            if (r100 != null) goto L9;
            f.b("RedbadgeService", "PushThreadHandlerManager#run return START_NOT_STICKY because MessageAppHooks.getPushHook() is null");
            return;
        L9:
            r100.W2();
            w67.a r101 = w67.a.C8076a.f558434a;
            if (this.f449141a.getBoolean("app_entrance") == false) goto L21;
            if (f.f267065a == false) goto L14;
            f.b("RedbadgeService", "BUNDLE_APP_ENTRANCE");
        L14:
            d r102 = d.d(r101);
            if (r102.f503319e == true) goto L17;
            return;
        L17:
            if (r102.f503331q == true) goto L36;
            r102.f503318d.sendEmptyMessage(1);
            return;
        L36:
            return;
        L21:
            if (this.f449141a.getBoolean("app_exit") == true) goto L23;
            return;
        L23:
            if (f.f267065a == false) goto L25;
            f.b("RedbadgeService", "BUNDLE_APP_EXIT");
        L25:
            d r103 = d.d(r101);
            if (r103.f503319e == true) goto L28;
            return;
        L28:
            if (r103.f503331q == true) goto L37;
            r103.f503318d.sendEmptyMessage(2);
            return;
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

        public a(Bundle r100, zfc.a.b r101) {
            this.f449141a = r100;
            this.f449142b = r101;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return null;
    }

    public RedBadgePushProcessService() {
        d.f503314u = true;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        if (r100 == null) goto L4;
        Bundle r103 = r100.getExtras();
    L5:
        zfc.a.b r104 = zfc.a.a();
        PushThreadHandlerManager.inst().postRunnable(new a(r103, r104));
        int r105 = super.onStartCommand(r100, r101, r102);
        if (r104 != null) goto L10;
        f.b("RedbadgeService", "RedBadgePushProcessService#onStartCommand return START_NOT_STICKY because MessageAppHooks.getPushHook() is null");
        return 2;
    L10:
        if (r104.f() == false) goto L12;
        return 2;
    L12:
        return r105;
    L4:
        r103 = null;
        goto L5
    }
}
