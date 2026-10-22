package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiDeleteConfirmDialog f242452a;

    public d(WikiDeleteConfirmDialog r100) {
        this.f242452a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WikiDeleteConfirmDialog r101 = this.f242452a;
        int r102 = WikiDeleteConfirmDialog.f242439o;
        WikiDeleteConfirmDialog.ParamsViewModel r103 = r101.ca0();
        if (r103 == null) goto L15;
        WikiDeleteConfirmDialog.b r104 = r103.getDelegate();
        if (r104 == null) goto L15;
        r104.onCancel();
    L15:
        this.f242452a.dismissAllowingStateLoss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L17;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
