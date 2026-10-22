package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public final g a;
    public boolean b;

    public f(g r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        this.a = r2;
    }

    public final boolean a(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (Float.isNaN(r6.getX()) == false) goto L5;
        return false;
    L5:
        if (Float.isNaN(r6.getY()) == false) goto L7;
        return false;
    L7:
        if (x54.b.c(this.a.a) == false) goto L33;
        int r0 = (int) r6.getX();
        r6.getRawX();
        int r2 = (int) r6.getY();
        int r3 = r6.getActionMasked();
        if (r3 == 0) goto L23;
        if (r3 != 1) goto L13;
    L22:
        boolean r1 = this.b;
        this.b = false;
    L24:
        if (r1 == false) goto L31;
        boolean r4 = this.a.a.dispatchTouchEvent(r6);
        if (this.a.a.getHasTouchDelegate() == false) goto L32;
        return true;
    L32:
        return r4;
    L31:
        return false;
    L13:
        if (r3 != 2) goto L15;
    L21:
        r1 = this.b;
        goto L24
    L15:
        if (r3 == 3) goto L22;
        if (r3 == 5) goto L21;
        if (r3 == 6) goto L21;
        r1 = false;
        goto L24
    L23:
        r1 = this.a.b.contains(r0, r2);
        this.b = r1;
        goto L24
    L33:
        return false;
    }
}
