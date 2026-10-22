package com.bytedance.ee.bear.document.export.dialog;

import android.view.View;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ SelectDownloadDialogFragment.b a;
    public final /* synthetic */ SelectDownloadDialogFragment b;
    public final /* synthetic */ int c;

    public a(SelectDownloadDialogFragment.b r1, SelectDownloadDialogFragment r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        SelectDownloadDialogFragment.b r4 = this.a;
        if (r4.c == false) goto L7;
        SelectDownloadDialogFragment.d r0 = this.b.h;
        if (r0 == null) goto L18;
        r0.a(r4, this.c);
    L18:
        this.b.dismissAllowingStateLoss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L20;
        d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L7:
        SelectDownloadDialogFragment.c r1 = this.b.i;
        if (r1 == null) goto L18;
        r1.a(r4, this.c);
        goto L18
    }
}
