package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.secret.SecretLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements SecretLevelAdapter.a {
    public final /* synthetic */ SecretLevelFragment a;

    public y(SecretLevelFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.secret.SecretLevelAdapter.a
    public final void a(SecretLevel r11) {
        Intrinsics.checkNotNullParameter(r11, "item");
        SecretLevelFragment r0 = this.a;
        int r1 = SecretLevelFragment.v;
        if (r0.ka0().getSecretModelData().getValue() == null) goto L6;
        Object r2 = this.a.ka0().getSecretModelData().getValue();
        Intrinsics.checkNotNull(r2);
        SecretReviewModel r12 = b0.a(((di5.a) r2).c, r11);
        int r3 = ApprovalRecordFragment.o;
        ApprovalRecordFragment.b.b(this.a.requireActivity(), r12, "from_security_setting_view", this.a.l);
        String r5 = du5.b.g(this.a.m.getSecretLevel().getId());
        SecretLevelFragment r13 = this.a;
        com.bytedance.ee.bear.middleground.permission.c.R("checking", "ccm_permission_security_resubmit_toast_view", r5, r13.q, r13.r, r13.o, SecretLevelFragment.ea0(r13));
        return;
    }
}
