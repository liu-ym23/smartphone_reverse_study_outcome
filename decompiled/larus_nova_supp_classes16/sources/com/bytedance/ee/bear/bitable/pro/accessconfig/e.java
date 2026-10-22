package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.View;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.pro.BitableProViewModel;
import com.bytedance.ee.bear.bitable.pro.DefaultConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ BitableDefaultRoleFragment a;

    public e(BitableDefaultRoleFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (this.a.L == true) goto L10;
        DefaultConfig r8 = new DefaultConfig(0, "", false, 4, null);
        BitableProViewModel r0 = this.a.J;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L7:
        BitableProViewModel.d r1 = r0.getSelectStrategyListener();
        if (r1 == null) goto L11;
        r1.a(r8);
    L11:
        BitableDefaultRoleFragment r9 = this.a;
        r9.getClass();     // Catch: Exception -> L14
        BaseActionPanelFragment.da0(r9);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L21;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L21:
        return;
    L10:
        tt5.a.h("BitableDefaultRoleFragment", "select disable strategy ");
        goto L11
    }
}
