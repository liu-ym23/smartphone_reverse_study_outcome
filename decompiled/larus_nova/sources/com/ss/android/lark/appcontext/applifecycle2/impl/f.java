package com.ss.android.lark.appcontext.applifecycle2.impl;

import android.app.Activity;
import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f408894a;

    public f(g r100) {
        this.f408894a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r110) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        g r100 = this.f408894a;
        int r101 = r100.f408897c;
        r100.f408897c = r101 + 1;
        if (r101 != 0) goto L6;
        jva.d.b r102 = new jva.d.b(r100.f408895a, true, SystemClock.elapsedRealtime(), r110);
        g.c(this.f408894a, r102);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        g r101 = this.f408894a;
        int r102 = r101.f408897c - 1;
        r101.f408897c = r102;
        if (r102 != 0) goto L6;
        g.c(this.f408894a, new jva.d.b(r101.f408895a, false, SystemClock.elapsedRealtime(), r100));
        return;
    }
}
