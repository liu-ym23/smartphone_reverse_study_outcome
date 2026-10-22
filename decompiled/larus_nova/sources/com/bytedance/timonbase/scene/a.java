package com.bytedance.timonbase.scene;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f270878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f270879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function1<Boolean, Unit>> f270880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f270881d;

    /* JADX INFO: renamed from: com.bytedance.timonbase.scene.a$a, reason: collision with other inner class name */
    public static final class C3794a {
    }

    static {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    public a(Application r100) {
        this.f270878a = true;
        this.f270880c = new CopyOnWriteArrayList();
        this.f270879b = 0;
        r100.registerActivityLifecycleCallbacks(this);
    }

    public final void a(Function1<? super Boolean, Unit> r100) {
        this.f270880c.add(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        if (this.f270881d == 0) goto L5;
        return;
    L5:
        if (this.f270878a == true) goto L14;
        this.f270878a = true;
        this.f270879b = SystemClock.elapsedRealtime();
        Iterator<Function1<Boolean, Unit>> r101 = this.f270880c.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().invoke(Boolean.TRUE);
        goto L8
    L10:
        int r102 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.a("AppBackgroundReferee", "切到后台 isAppBackground:" + this.f270878a + ",appEnterBackgroundTime:" + this.f270879b);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        int r101 = this.f270881d + 1;
        this.f270881d = r101;
        if (r101 == 1) goto L5;
        return;
    L5:
        if (this.f270878a == false) goto L14;
        this.f270878a = false;
        this.f270879b = 0;
        Iterator<Function1<Boolean, Unit>> r102 = this.f270880c.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().invoke(Boolean.FALSE);
        goto L8
    L10:
        int r103 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.a("AppBackgroundReferee", "切到前台 isAppBackground:" + this.f270878a + ",appEnterBackgroundTime:" + this.f270879b);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        int r101 = this.f270881d - 1;
        this.f270881d = r101;
        if (r101 != 0) goto L11;
        this.f270878a = true;
        this.f270879b = SystemClock.elapsedRealtime();
        Iterator<Function1<Boolean, Unit>> r102 = this.f270880c.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().invoke(Boolean.TRUE);
        goto L6
    L8:
        int r103 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.a("AppBackgroundReferee", "切到后台 isAppBackground:" + this.f270878a + ",appEnterBackgroundTime:" + this.f270879b);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        if (this.f270881d == 0) goto L5;
        return;
    L5:
        if (this.f270878a == false) goto L14;
        this.f270878a = false;
        this.f270879b = 0;
        Iterator<Function1<Boolean, Unit>> r102 = this.f270880c.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().invoke(Boolean.FALSE);
        goto L8
    L10:
        int r103 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.a("AppBackgroundReferee", "切到前台 isAppBackground:" + this.f270878a + ",appEnterBackgroundTime:" + this.f270879b);
        return;
    }
}
