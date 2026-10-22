package com.bytedance.android.shopping.verify;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ LawHintDialogFragment a;

    public e(LawHintDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        CheckBox r5 = this.a.h;
        if (r5 != null) goto L5;
    L13:
        Context r6 = this.a.getContext();
        if (r6 == null) goto L21;
        int r0 = g1.a;
        UIUtils.displayToast(r6, g1.a.c(r6, 2131895824, new Object[0]));
        return;
    L21:
        return;
    L5:
        if (r5.isChecked() != true) goto L13;
        LawHintDialogFragment r7 = this.a;
        r7.k = true;
        int r1 = AuthUtils.a;
        AuthUtils.b(r7.n, r7.m, 4);
        this.a.S90("confirm");
        this.a.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L19;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
