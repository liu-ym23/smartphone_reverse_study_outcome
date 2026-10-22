package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f193658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f193659b;

    public f(g r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        this.f193658a = r100;
    }

    public final boolean a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Float.isNaN(r100.getX()) == false) goto L5;
        return false;
    L5:
        if (Float.isNaN(r100.getY()) == false) goto L7;
        return false;
    L7:
        if (x54.b.c(this.f193658a.f193660a) == false) goto L33;
        int r101 = (int) r100.getX();
        r100.getRawX();
        int r102 = (int) r100.getY();
        int r103 = r100.getActionMasked();
        if (r103 == 0) goto L23;
        if (r103 != 1) goto L13;
    L22:
        boolean r104 = this.f193659b;
        this.f193659b = false;
    L24:
        if (r104 == false) goto L31;
        boolean r105 = this.f193658a.f193660a.dispatchTouchEvent(r100);
        if (this.f193658a.f193660a.getHasTouchDelegate() == false) goto L32;
        return true;
    L32:
        return r105;
    L31:
        return false;
    L13:
        if (r103 != 2) goto L15;
    L21:
        r104 = this.f193659b;
        goto L24
    L15:
        if (r103 == 3) goto L22;
        if (r103 == 5) goto L21;
        if (r103 == 6) goto L21;
        r104 = false;
        goto L24
    L23:
        r104 = this.f193658a.f193661b.contains(r101, r102);
        this.f193659b = r104;
        goto L24
    L33:
        return false;
    }
}
