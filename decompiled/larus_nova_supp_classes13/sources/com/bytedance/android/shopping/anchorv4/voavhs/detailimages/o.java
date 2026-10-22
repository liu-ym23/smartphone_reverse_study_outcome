package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.graphics.PointF;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends k {
    public PointF c;
    public PointF d;
    public final PointF e;
    public final p f;

    public o(LargeImageView.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f = r2;
        this.e = new PointF();
    }

    public static PointF a(MotionEvent r5) {
        int r0 = r5.getPointerCount();
        float r1 = 0.0f;
        float r2 = 0.0f;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 + r5.getX(r3);
        r2 = r2 + r5.getY(r3);
        r3 = r3 + 1;
        goto L3
    L5:
        float r6 = r0;
        return new PointF(r1 / r6, r2 / r6);
    }

    public final void b(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        MotionEvent r0 = this.b;
        if (r0 == null) goto L33;
        this.d = a(r0);
        this.c = a(r5);
        if (r0.getPointerCount() == r5.getPointerCount()) goto L7;
        boolean r6 = true;
    L8:
        PointF r1 = this.e;
        float r2 = 0.0f;
        if (r6 == false) goto L11;
        float r3 = 0.0f;
    L20:
        r1.x = r3;
        if (r6 == true) goto L31;
        PointF r7 = this.c;
        if (r7 == null) goto L26;
        float r8 = r7.y;
    L27:
        PointF r4 = this.d;
        if (r4 == null) goto L30;
        r2 = r4.y;
    L30:
        r2 = r8 - r2;
        goto L31
    L26:
        r8 = 0.0f;
    L31:
        r1.y = r2;
        return;
    L11:
        PointF r9 = this.c;
        if (r9 == null) goto L14;
        float r10 = r9.x;
    L15:
        PointF r11 = this.d;
        if (r11 == null) goto L18;
        float r12 = r11.x;
    L19:
        r3 = r10 - r12;
        goto L20
    L18:
        r12 = 0.0f;
        goto L19
    L14:
        r10 = 0.0f;
        goto L15
    L7:
        r6 = false;
        goto L8
    }
}
