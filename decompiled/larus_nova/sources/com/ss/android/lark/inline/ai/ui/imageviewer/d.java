package com.ss.android.lark.inline.ai.ui.imageviewer;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageViewerFragment<Object> f427558a;

    public d(ImageViewerFragment<Object> r100) {
        this.f427558a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f427558a.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L9:
        ylb.a<Object> r101 = this.f427558a.f427548p;
        if (r101 == null) goto L15;
        r101.onConfirm();
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L9;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
