package com.bytedance.ee.bear.quoto;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ s c;

    public q(s r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        s r0 = this.c;
        r0.h = true;
        r0.b.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L9:
        View.OnClickListener r1 = this.c.k;
        if (r1 == null) goto L15;
        r1.onClick(r3);
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L9;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
