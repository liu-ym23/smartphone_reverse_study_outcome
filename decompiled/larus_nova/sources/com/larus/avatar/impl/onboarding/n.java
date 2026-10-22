package com.larus.avatar.impl.onboarding;

import com.larus.common_ui.widget.UrlSpanTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class n implements UrlSpanTextView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DigitalAvatarOnboardingDialog f290867a;

    public n(DigitalAvatarOnboardingDialog r100) {
        this.f290867a = r100;
    }

    @Override // com.larus.common_ui.widget.UrlSpanTextView.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (Intrinsics.areEqual(r100, "pp") == false) goto L6;
        DigitalAvatarOnboardingDialog.T90(this.f290867a);
        return;
    }
}
