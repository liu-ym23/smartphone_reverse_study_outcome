package com.bytedance.android.shopping.new_cart.container;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements View.OnTouchListener {
    public final /* synthetic */ CartDialogFragment a;

    public h(CartDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        int r0 = 0;
        if (r4.getVisibility() == 0) goto L6;
        return false;
    L6:
        if (this.a.L.onTouchEvent(r5) == true) goto L33;
        CartDialogFragment r6 = this.a;
        r6.getClass();
        int r2 = r5.getAction();
        if (r2 == 0) goto L32;
        if (r2 != 1) goto L33;
        int r7 = ((int) r5.getRawY()) - r6.M;
        int r3 = com.bytedance.android.shopping.new_cart.utils.c.a;
        CartParams r8 = r6.X90();
        if (r8 == null) goto L14;
        String r9 = r8.getSplitActivityScene();
    L16:
        if (com.bytedance.android.shopping.new_cart.utils.c.a(r9) == false) goto L20;
        nj.d r10 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r10 == null) goto L22;
        r10.getScreenHeight();
    L22:
        if (r7 <= (r0 / 2)) goto L30;
        r6.dismissAllowingStateLoss();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L33;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L33
    L30:
        if (r7 <= r6.e) goto L33;
        r6.ea0();
        goto L33
    L20:
        r0 = k1.j(r6.requireContext());
        goto L22
    L14:
        r9 = null;
        goto L16
    L32:
        r6.M = (int) r5.getRawY();
    L33:
        return true;
    }
}
