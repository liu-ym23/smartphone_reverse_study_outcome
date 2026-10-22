package com.bytedance.ee.bear.bitable.superagent;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.facade.common.widget.d.b {
    public final /* synthetic */ BitableSuperAgentBasePanel a;

    public b(BitableSuperAgentBasePanel r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r2) {
        if (r2 == 0) goto L4;
        return;
    L4:
        if (this.a.isAdded() == false) goto L16;
        tt5.a.h(this.a.fa0(), "onDragDismiss");
        this.a.dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L17;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    }
}
