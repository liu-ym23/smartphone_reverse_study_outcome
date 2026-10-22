package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ WikiDeleteConfirmDialog a;

    public e(WikiDeleteConfirmDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        WikiDeleteConfirmDialog r6 = this.a;
        int r0 = WikiDeleteConfirmDialog.o;
        WikiDeleteConfirmDialog.ParamsViewModel r1 = r6.ca0();
        if (r1 == null) goto L25;
        WikiDeleteConfirmDialog.b r2 = r1.getDelegate();
        if (r2 == null) goto L25;
        if (r6.aa0().isSelected() == false) goto L10;
        byte r7 = 2131368778;
    L13:
        if (r7 != 2131368778) goto L15;
        r2.a();
        goto L25
    L15:
        if (r7 != 2131368781) goto L25;
        r2.b();
        goto L25
    L10:
        if (r6.ba0().isSelected() == false) goto L12;
        r7 = 2131368781;
        goto L13
    L12:
        r7 = -1;
    L25:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L27;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
