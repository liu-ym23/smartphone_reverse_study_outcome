package com.bytedance.ee.bear.document.setting;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ DocumentPermTyeActivity a;

    public c(DocumentPermTyeActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        DocumentPermTyeActivity r3 = this.a;
        int r0 = DocumentPermTyeActivity.i;
        r3.G1().permissionTypeClick(2);
        DocumentPermTyeActivity.C1(this.a, 2);
    }
}
