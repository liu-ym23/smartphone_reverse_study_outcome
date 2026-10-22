package com.bytedance.android.shopping.slice.elements.scrollx;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.bytedance.android.ecom.arch.slice.render.elements.list.SlcListElementView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends SlcListElementView {
    public boolean e;
    public final b f;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.f = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        b r0 = this.f;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "event");
        if (r0.e == false) goto L33;
        int r1 = r8.getActionMasked();
        if (r1 == 0) goto L29;
        boolean r4 = false;
        if (r1 != 1) goto L10;
    L25:
        ViewParent r2 = r0.f.getParent();
        if (r2 == null) goto L28;
        r2.requestDisallowInterceptTouchEvent(false);
    L28:
        r0.d = null;
        goto L33
    L10:
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L25;
    L15:
        if (r0.d != null) goto L22;
        float r3 = Math.abs(r8.getX() - r0.b);
        float r5 = Math.abs(r8.getY() - r0.c);
        float r6 = (r3 * r3) + (r5 * r5);
        float r7 = r0.a;
        if (r6 <= (r7 * r7)) goto L22;
        if (r5 > (r3 * 1.28f)) goto L21;
        r4 = true;
    L21:
        r0.d = Boolean.valueOf(r4);
    L22:
        ViewParent r9 = r0.f.getParent();
        if (r9 == null) goto L33;
        r9.requestDisallowInterceptTouchEvent(!Intrinsics.areEqual(r0.d, Boolean.FALSE));
        goto L33
    L29:
        r0.b = r8.getX();
        r0.c = r8.getY();
        r0.d = null;
        ViewParent r10 = r0.f.getParent();
        if (r10 == null) goto L33;
        r10.requestDisallowInterceptTouchEvent(true);
    L33:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r8);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        if (this.e == false) goto L5;
        if (r3 == null) goto L8;
        Integer r0 = Integer.valueOf(r3.getActionMasked());
    L9:
        if (r0 == null) goto L15;
        if (r0.intValue() != 2) goto L15;
        return false;
    L15:
        return super.onInterceptTouchEvent(r3);
    L8:
        r0 = null;
        goto L9
    L5:
        return super.onInterceptTouchEvent(r3);
    }
}
