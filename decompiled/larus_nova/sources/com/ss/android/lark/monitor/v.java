package com.ss.android.lark.monitor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes36.dex */
public final class v implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonitorModule f432535a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    public v(MonitorModule r100) {
        this.f432535a = r100;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        this.f432535a.j(r100.getClass().getName() + "#hash" + r100.hashCode(), null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        String r101 = r100.getClass().getName();
        final MonitorModule r102 = this.f432535a;
        final String r103 = r101 + "#hash" + r100.hashCode();
        if (r102.f432322c == false) goto L6;
        Log.i("ScenePerfMonitor", "pauseScene:" + r103);
        CoreThreadPool.getNonblockingHandler().post(new r(r102, r103));
    L6:
        ScheduledFuture r104 = this.f432535a.f432324e;
        if (r104 == null) goto L9;
        r104.cancel(true);
        this.f432535a.f432324e = null;
    L9:
        ScheduledFuture r105 = this.f432535a.f432325f;
        if (r105 == null) goto L13;
        r105.cancel(true);
        this.f432535a.f432325f = null;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        this.f432535a.g(r100.getClass().getName() + "#hash" + r100.hashCode());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        this.f432535a.a();
        CoreThreadPool.getNonblockingHandler().postDelayed(new s(this), 3000);
        final WeakReference r102 = new WeakReference(r100);
        MonitorModule r103 = this.f432535a;
        ScheduledExecutorService r104 = CoreThreadPool.getDefault().getScheduleThreadPool();
        Runnable r105 = new t(this, r102);
        TimeUnit r106 = TimeUnit.SECONDS;
        r103.f432324e = r104.schedule(r105, 3, r106);
        MonitorModule r107 = this.f432535a;
        r107.f432325f = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new u(this, r102), 6, r106);
    }
}
