package com.larus.dora.impl.onboarding.lite;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements com.larus.common_ui.dialog.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraLiteOnboardingConnectDialogFragment f336967a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.f336967a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public e(DoraLiteOnboardingConnectDialogFragment r100) {
        this.f336967a = r100;
    }
}
