package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ AuditControlApplyFragment a;

    public w(AuditControlApplyFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        com.bytedance.ee.bear.middleground.permission.c.h(this.a.W90().getToken(), sbb.e.g(this.a.W90().getDocumentType()), this.a.W90().getSubType(), this.a.W90().getFromVc(), this.a.W90().isWiki(), this.a.W90().getModule(), this.a.W90().getUserPerm(), this.a.W90().getPublicPerm(), "admin_forbidden");
        FragmentActivity r11 = this.a.getActivity();
        if (r11 == null) goto L6;
        r11.onBackPressed();
        return;
    }
}
