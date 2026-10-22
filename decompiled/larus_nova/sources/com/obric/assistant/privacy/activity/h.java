package com.obric.assistant.privacy.activity;

import com.larus.network.HttpConst;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h implements com.obric.oui.privacy.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricPrivacyAgreeActivity f391093a;

    @Override // com.obric.oui.privacy.i
    public final void a() {
        FLogger.f375446a.i("ObricPrivacyActivity", "click disagree");
        ObricPrivacyAgreeActivity.O1(this.f391093a);
    }

    @Override // com.obric.oui.privacy.i
    public final void b() {
        FLogger.f375446a.i("ObricPrivacyActivity", "click agree");
        ObricPrivacyAgreeActivity r100 = this.f391093a;
        int r101 = ObricPrivacyAgreeActivity.f391075n;
        r100.Q1();
    }

    @Override // com.obric.oui.privacy.i
    public final void onBackPressed() {
        FLogger.f375446a.i("ObricPrivacyActivity", "click onBackPressed");
        ObricPrivacyAgreeActivity.O1(this.f391093a);
    }

    @Override // com.obric.oui.privacy.i
    public final void onDismiss() {
        Intrinsics.checkNotNullParameter(this, "this");
    }

    public h(ObricPrivacyAgreeActivity r100) {
        this.f391093a = r100;
    }

    @Override // com.obric.oui.privacy.i
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkText");
        if (Intrinsics.areEqual(r100, this.f391093a.getString(R.string.obric_privacy_policy_link)) == false) goto L6;
        ObricPrivacyAgreeActivity r101 = this.f391093a;
        HttpConst.f359979a.getClass();
        ObricPrivacyAgreeActivity.N1(r101, HttpConst.M);
        return;
    L6:
        if (Intrinsics.areEqual(r100, this.f391093a.getString(R.string.obric_privacy_doubao_assistant_special_term_link)) == false) goto L9;
        ObricPrivacyAgreeActivity.N1(this.f391093a, "https://www.doubao.com/ocean_legal/terms");
        return;
    L9:
        if (Intrinsics.areEqual(r100, this.f391093a.getString(R.string.obric_privacy_doubao_term_link)) == false) goto L14;
        ObricPrivacyAgreeActivity r102 = this.f391093a;
        HttpConst.f359979a.getClass();
        ObricPrivacyAgreeActivity.N1(r102, HttpConst.L);
        return;
    }
}
