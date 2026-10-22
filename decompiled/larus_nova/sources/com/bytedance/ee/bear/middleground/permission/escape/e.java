package com.bytedance.ee.bear.middleground.permission.escape;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EscapeApprovalListFragment f233859c;

    public e(EscapeApprovalListFragment r100) {
        this.f233859c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        this.f233859c.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
