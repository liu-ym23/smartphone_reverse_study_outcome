package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ BitableProUpdateFragment a;

    public e0(BitableProUpdateFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        BitableProViewModel r3 = this.a.P;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        BitableProViewModel.ActionPanelListener r4 = r3.getActionPanelListener();
        if (r4 == null) goto L16;
        r4.a(BitableProViewModel.ActionPanelListener.Action.TO_UPGRADE);
    L16:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L18;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
