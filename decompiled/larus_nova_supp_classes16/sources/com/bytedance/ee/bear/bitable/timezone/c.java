package com.bytedance.ee.bear.bitable.timezone;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements com.bytedance.ee.bear.facade.common.widget.d.b {
    public final /* synthetic */ BitableTimeZoneListFragment a;
    public final /* synthetic */ Ref.IntRef b;

    public c(BitableTimeZoneListFragment r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r3) {
        if (r3 == 0) goto L12;
    L10:
        this.b.element = r3;
        return;
    L12:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L10;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
