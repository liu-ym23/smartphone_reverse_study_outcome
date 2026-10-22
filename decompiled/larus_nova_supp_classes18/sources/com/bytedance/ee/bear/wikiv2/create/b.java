package com.bytedance.ee.bear.wikiv2.create;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements WikiCreateSelectView.c {
    public final /* synthetic */ WikiCreateSelectPanelDialog a;

    @Override // com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectView.c
    public final void onCancelClick() {
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public b(WikiCreateSelectPanelDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectView.c
    public final void a(int r3) {
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L9:
        WikiCreateSelectPanelDialog r0 = this.a;
        int r1 = WikiCreateSelectPanelDialog.m;
        WikiCreateSelectPanelDialog._ViewModel r2 = (WikiCreateSelectPanelDialog._ViewModel) r0.j.getValue();
        if (r2 == null) goto L20;
        WikiCreateSelectPanelDialog.b r4 = r2.getDelegate();
        if (r4 == null) goto L21;
        WikiCreateSelectPanelDialog._ViewModel r5 = (WikiCreateSelectPanelDialog._ViewModel) this.a.j.getValue();
        if (r5 == null) goto L16;
        r5.getNode();
    L16:
        r4.a(r3);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L9;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
