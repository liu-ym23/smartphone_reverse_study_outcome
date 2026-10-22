package com.bytedance.android.shopping.new_cart.components;

import android.view.ViewStub;
import com.bytedance.android.shopping.new_cart.container.CartDialogFragment;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends a implements ECCartErrorView.a {
    public ECCartErrorView b;
    public boolean c;
    public final ViewStub d;

    @Override // com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView.a
    public final void a() {
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.g(this.a.d, "ErrorView-onRetry", "", MapsKt.emptyMap());
        CartViewModel.doQuery$default(this.a.d, true, "reload", null, 4, null);
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView.a
    public final void b() {
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.g(this.a.d, "ErrorView-onAdvice", "", MapsKt.emptyMap());
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        if (this.b != null) goto L8;
        com.bytedance.android.shopping.new_cart.utils.a.c.d("initErrorView", new c(this));
        ECCartErrorView r0 = this.b;
        if (r0 == null) goto L9;
        r0.setCallback(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView.a
    public final void onBack() {
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.g(this.a.d, "ErrorView-onBack", "", MapsKt.emptyMap());
        Object r1 = e();
        CartDialogFragment r2 = null;
        if ((r1 instanceof NewCartActivity) == true) goto L5;
        r1 = null;
    L5:
        NewCartActivity r3 = (NewCartActivity) r1;
        if (r3 == null) goto L8;
        r3.finish();
    L8:
        CartDialogFragment r4 = this.a.f;
        if ((r4 instanceof CartDialogFragment) == false) goto L12;
        r2 = r4;
    L12:
        CartDialogFragment r5 = r2;
        if (r5 == null) goto L23;
        r5.dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L24;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L24:
        return;
    }

    public d(CartObjectContainer r2, ViewStub r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        super(r2);
        this.d = r3;
    }
}
