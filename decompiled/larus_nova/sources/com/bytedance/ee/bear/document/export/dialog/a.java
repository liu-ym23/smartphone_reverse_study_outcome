package com.bytedance.ee.bear.document.export.dialog;

import android.view.View;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectDownloadDialogFragment.b f219737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SelectDownloadDialogFragment f219738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f219739c;

    public a(SelectDownloadDialogFragment.b r100, SelectDownloadDialogFragment r101, int r102) {
        this.f219737a = r100;
        this.f219738b = r101;
        this.f219739c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SelectDownloadDialogFragment.b r101 = this.f219737a;
        if (r101.f219733c == false) goto L7;
        SelectDownloadDialogFragment.d r102 = this.f219738b.f219725h;
        if (r102 == null) goto L18;
        r102.a(r101, this.f219739c);
    L18:
        this.f219738b.dismissAllowingStateLoss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L20;
        d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L7:
        SelectDownloadDialogFragment.c r104 = this.f219738b.f219726i;
        if (r104 == null) goto L18;
        r104.a(r101, this.f219739c);
        goto L18
    }
}
