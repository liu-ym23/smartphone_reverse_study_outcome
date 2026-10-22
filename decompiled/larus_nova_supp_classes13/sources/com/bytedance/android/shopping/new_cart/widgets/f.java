package com.bytedance.android.shopping.new_cart.widgets;

import android.view.View;
import com.bytedance.android.shopping.new_cart.container.CartDialogFragment;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ECCartLoadingView b;

    public f(View r1, ECCartLoadingView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        CartViewModel r5 = this.b.getCartObjectContainer().d;
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.g(r5, "LOADING_VIEW_EXIT", "", MapsKt.emptyMap());
        Object r6 = this.a.getContext();
        CartDialogFragment r1 = null;
        if ((r6 instanceof NewCartActivity) == true) goto L5;
        r6 = null;
    L5:
        NewCartActivity r7 = (NewCartActivity) r6;
        if (r7 == null) goto L8;
        r7.finish();
    L8:
        CartDialogFragment r8 = this.b.getCartObjectContainer().f;
        if ((r8 instanceof CartDialogFragment) == false) goto L12;
        r1 = r8;
    L12:
        CartDialogFragment r2 = r1;
        if (r2 == null) goto L23;
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L24;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L24:
        return;
    }
}
