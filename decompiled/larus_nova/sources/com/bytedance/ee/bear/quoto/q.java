package com.bytedance.ee.bear.quoto;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class q extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f236426c;

    public q(s r100) {
        this.f236426c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        s r101 = this.f236426c;
        r101.f236434h = true;
        r101.f236428b.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L9:
        View.OnClickListener r102 = this.f236426c.f236437k;
        if (r102 == null) goto L15;
        r102.onClick(r100);
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L9;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
