package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h1 implements View.OnClickListener {
    public final /* synthetic */ PermApplyFragment a;

    public h1(PermApplyFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.Z90().setPermType(PermApplyViewModel.PermType.EDIT);
    }
}
