package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.shopping.anchorv4.widgets.TopRoundFrameLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;
import vg3.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ e a;
    public final /* synthetic */ BottomSheetBehavior b;
    public final /* synthetic */ ToggleBottomSheetBehavior c;
    public final /* synthetic */ View d;
    public final /* synthetic */ boolean e;

    public final void onSlide(View r19, float r20) {
        Intrinsics.checkNotNullParameter(r19, FreqActions.ACTION_VIEW);
        if (Float.isNaN(r20) == false) goto L5;
        return;
    L5:
        e r2 = this.a;
        BottomSheetBehavior r3 = this.b;
        ToggleBottomSheetBehavior r4 = this.c;
        View r5 = this.d;
        boolean r6 = this.e;
        if (r2.b == true) goto L18;
        if (r2.c >= 0.4f) goto L13;
        if (r20 < 0.4f) goto L13;
        r3.setState(3);
        r2.d = 3;
        r5.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
    L13:
        if (r2.c < 0.4f) goto L18;
        if (r20 >= 0.4f) goto L18;
        r3.setState(4);
        r2.d = 4;
        r5.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
    L18:
        if (r2.b == false) goto L20;
    L25:
        boolean r7 = false;
    L26:
        if (r4 != null) goto L28;
    L30:
        if (r4 != null) goto L33;
        if (r7 == false) goto L33;
        r3.setState(5);
        r2.d = 5;
        r5.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
    L33:
        r2.c = r20;
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.e)).b.c.g(Float.valueOf(r20));
        return;
    L28:
        if (r4.b == true) goto L30;
        r4.a = r7;
        goto L30
    L20:
        if (r2.d != 4) goto L25;
        if (r20 >= (-0.1f)) goto L25;
        if (r6 == false) goto L25;
        r7 = true;
        goto L26
    }

    public final void onStateChanged(View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        if (r5 != 5) goto L6;
        e r6 = this.a;
        r6.d = r5;
        r6.f.v0(new k0(false, false, 7));
    L6:
        if (r5 != 3) goto L9;
        e r7 = this.a;
        r7.d = r5;
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r7.e)).b.d.g(Boolean.TRUE);
    L9:
        if (r5 != 4) goto L12;
        e r8 = this.a;
        r8.d = r5;
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r8.e)).b.d.g(Boolean.FALSE);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(e r1, BottomSheetBehavior r2, ToggleBottomSheetBehavior r3, TopRoundFrameLayout r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
