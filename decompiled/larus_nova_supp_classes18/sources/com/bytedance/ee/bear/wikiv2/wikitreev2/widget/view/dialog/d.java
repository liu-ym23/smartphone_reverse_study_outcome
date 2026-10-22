package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ WikiDeleteConfirmDialog a;

    public d(WikiDeleteConfirmDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        WikiDeleteConfirmDialog r3 = this.a;
        int r0 = WikiDeleteConfirmDialog.o;
        WikiDeleteConfirmDialog.ParamsViewModel r4 = r3.ca0();
        if (r4 == null) goto L15;
        WikiDeleteConfirmDialog.b r5 = r4.getDelegate();
        if (r5 == null) goto L15;
        r5.onCancel();
    L15:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L17;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
