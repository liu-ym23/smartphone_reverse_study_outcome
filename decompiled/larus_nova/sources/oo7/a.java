package oo7;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    public a() {
        new ConcurrentHashMap();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        b.f524618a.remove(r100);     // Catch: Throwable -> L4
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        com.bytedance.ug.sdk.share.impl.manager.h r101 = com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a;
        r101.getClass();
        if (r100 == null) goto L33;
        eo7.a r102 = eo7.a.b.f473353a;
        if (((Boolean) r102.c("enable_token", Boolean.TRUE)).booleanValue() == false) goto L34;
        String r103 = r100.getClass().getName();
        if (r102.j(r103) == true) goto L35;
        k.a("ShareSdkManager", "continue".concat(r103));
        if (r101.f272328c > 0) goto L28;
        r101.f272328c = 0;
        if (r101.f272329d == true) goto L28;
        k.a("ShareSdkManager", "handleAppForeground".concat(r103));
        if (Build.VERSION.SDK_INT >= 29) goto L31;
        com.bytedance.ug.sdk.share.impl.manager.j.c.f272350a.a();
    L27:
        r101.f272329d = true;
        goto L28
    L31:
        String r104 = r100.getClass().getName();     // Catch: Throwable -> L24
        if (r100.getWindow() != null) goto L20;
    L22:
        Looper.getMainLooper().getQueue().addIdleHandler(new com.bytedance.ug.sdk.share.impl.manager.g());     // Catch: Throwable -> L24
    L30:
        goto L27
    L20:
        if (com.bytedance.ug.sdk.share.impl.manager.h.a(r100.getWindow()) == null) goto L22;
        com.bytedance.ug.sdk.share.impl.manager.f r105 = new com.bytedance.ug.sdk.share.impl.manager.f();     // Catch: Throwable -> L24
        com.bytedance.ug.sdk.share.impl.manager.h.a(r100.getWindow()).post(r105);     // Catch: Throwable -> L24
        r101.f272327b.put(r104, r105);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        k.b(th.toString());
    L28:
        r101.f272328c++;
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        com.bytedance.ug.sdk.share.impl.manager.h r101 = com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a;
        r101.getClass();
        if (r100 == null) goto L36;
        eo7.a r102 = eo7.a.b.f473353a;
        if (((Boolean) r102.c("enable_token", Boolean.TRUE)).booleanValue() == true) goto L9;
        return;
    L9:
        if (r102.j(r100.getClass().getName()) == true) goto L38;
        int r103 = r101.f272328c - 1;
        r101.f272328c = r103;
        if (r103 > 0) goto L34;
        r101.f272328c = 0;
        if (r101.f272329d == false) goto L35;
        jn7.f r104 = eo7.a.e();
        if (r104 == null) goto L19;
        r104.handleAppBackground();
    L19:
        if (Build.VERSION.SDK_INT >= 29) goto L32;
    L30:
        r101.f272329d = false;
        return;
    L32:
    L28:
        th = move-exception;
        k.b(th.toString());
        goto L30
    L21:
        if (r100.getWindow() == null) goto L30;
        if (com.bytedance.ug.sdk.share.impl.manager.h.a(r100.getWindow()) == null) goto L30;
        String r105 = r100.getClass().getName();     // Catch: Throwable -> L28
        if (r101.f272327b.containsKey(r105) == false) goto L30;
        com.bytedance.ug.sdk.share.impl.manager.h.a(r100.getWindow()).removeCallbacks(r101.f272327b.get(r105));     // Catch: Throwable -> L28
        r101.f272327b.remove(r105);     // Catch: Throwable -> L28
        goto L30
    L35:
        return;
    L34:
        return;
    L38:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        LinkedList<Activity> r102 = b.f524618a;     // Catch: Throwable -> L4
        r102.remove(r100);     // Catch: Throwable -> L4
        r102.add(r100);     // Catch: Throwable -> L4
        return;
    }
}
