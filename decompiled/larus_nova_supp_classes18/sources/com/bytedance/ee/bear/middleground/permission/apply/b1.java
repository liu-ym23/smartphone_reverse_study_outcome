package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b1 implements View.OnClickListener {
    public final /* synthetic */ PermApplyFragment a;

    public b1(PermApplyFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        com.bytedance.ee.bear.middleground.permission.c.h(this.a.W90().getToken(), sbb.e.g(this.a.W90().getDocumentType()), this.a.W90().getSubType(), this.a.W90().getFromVc(), this.a.W90().isWiki(), this.a.W90().getModule(), this.a.W90().getUserPerm(), this.a.W90().getPublicPerm(), "apply_permission");
        Object r11 = org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        PermApplyFragment r0 = this.a;
        com.bytedance.ee.bear.route.h r12 = (com.bytedance.ee.bear.route.h) r11;
        String r1 = r0.W90().getOriginalBearUrlToken();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r12.D4(r1) == true) goto L11;
        FragmentActivity r13 = r0.getActivity();
        if (r13 == null) goto L12;
        r13.onBackPressed();
        return;
    L12:
        return;
    }
}
