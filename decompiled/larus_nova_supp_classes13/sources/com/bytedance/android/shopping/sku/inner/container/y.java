package com.bytedance.android.shopping.sku.inner.container;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y implements View.OnClickListener {
    public final /* synthetic */ SkuYataFragment a;

    public y(SkuYataFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        SkuYataFragment r3 = this.a;
        com.bytedance.android.shopping.buynow.controller.q r0 = r3.h;
        if (r0 == null) goto L8;
        if (r0.b == true) goto L8;
        return;
    L8:
        if (SkuYataFragment.V90(r3) == false) goto L18;
        return;
    L18:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L20;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
