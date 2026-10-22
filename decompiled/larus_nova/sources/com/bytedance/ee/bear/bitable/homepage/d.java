package com.bytedance.ee.bear.bitable.homepage;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableCreatePanelFragment f212715a;

    public d(BitableCreatePanelFragment r100) {
        this.f212715a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableCreatePanelFragment.b r101 = this.f212715a.f212150m;
        if (r101 == null) goto L13;
        r101.a();
    L13:
        this.f212715a.dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L15;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
