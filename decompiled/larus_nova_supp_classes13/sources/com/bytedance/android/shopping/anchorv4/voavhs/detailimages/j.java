package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements View.OnTouchListener {
    public long a;
    public float b;
    public float c;
    public float d;
    public float e;
    public final /* synthetic */ AnchorV4DetailLargeImageVH f;

    public j(AnchorV4DetailLargeImageVH r1) {
        this.f = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r7, MotionEvent r8) {
        if (r8 == null) goto L43;
        this.f.b.getParent().requestDisallowInterceptTouchEvent(true);
        o r0 = this.f.b.getMDetector();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "event");
        if (r0.a == true) goto L15;
        Intrinsics.checkNotNullParameter(r8, "event");
        int r1 = r8.getAction() & 255;
        if (r1 == 0) goto L11;
        if (r1 != 2) goto L27;
        r0.f.b(r0);
        r0.a = true;
    L27:
        int r2 = r8.getAction();
        if (r2 == 0) goto L42;
        if (r2 == 1) goto L34;
        if (r2 != 2) goto L43;
        this.d += Math.abs(r8.getX() - this.b);
        this.e += Math.abs(r8.getY() - this.c);
        this.b = r8.getX();
        this.c = r8.getY();
        goto L43
    L34:
        if ((System.currentTimeMillis() - this.a) >= 150) goto L43;
        float r3 = 20;
        if (this.d >= r3) goto L38;
    L39:
        n r9 = this.f.a;
        if (r9 == null) goto L43;
        r9.c();
        goto L43
    L38:
        if (this.e >= r3) goto L43;
    L42:
        this.b = r8.getX();
        this.c = r8.getY();
        this.d = 0.0f;
        this.e = 0.0f;
        this.a = System.currentTimeMillis();
        goto L43
    L11:
        MotionEvent r4 = r0.b;
        if (r4 == null) goto L14;
        r4.recycle();
    L14:
        r0.b = null;
        r0.a = false;
        r0.b = MotionEvent.obtain(r8);
        r0.b(r8);
        goto L27
    L15:
        Intrinsics.checkNotNullParameter(r8, "event");
        int r5 = r8.getAction() & 255;
        if (r5 == 1) goto L23;
        if (r5 != 2) goto L27;
        r0.b(r8);
        r0.f.a(r0);
        MotionEvent r6 = r0.b;
        if (r6 == null) goto L22;
        r6.recycle();
    L22:
        r0.b = MotionEvent.obtain(r8);
        goto L27
    L23:
        r0.f.c(r0);
        MotionEvent r10 = r0.b;
        if (r10 == null) goto L26;
        r10.recycle();
    L26:
        r0.b = null;
        r0.a = false;
    L43:
        return true;
    }
}
