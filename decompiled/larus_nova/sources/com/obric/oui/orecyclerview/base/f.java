package com.obric.oui.orecyclerview.base;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VelocityTracker f401551a;

    public final void b() {
        this.f401551a.clear();
    }

    public f() {
        this.f401551a = VelocityTracker.obtain();
    }

    public final void a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f401551a.addMovement(r100);
    }

    public final void c(float r100) {
        this.f401551a.computeCurrentVelocity(1000, r100);
    }

    public final float d(int r100) {
        return this.f401551a.getXVelocity(r100);
    }

    public final float e(int r100) {
        return this.f401551a.getYVelocity(r100);
    }
}
