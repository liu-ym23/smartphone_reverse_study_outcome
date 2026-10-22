package com.bytedance.ee.bear.document.setting;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocumentPermTyeActivity f221751a;

    public b(DocumentPermTyeActivity r100) {
        this.f221751a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        tt5.a.h("DocumentPermTyeActivity", "only click");
        DocumentPermTyeActivity r101 = this.f221751a;
        int r102 = DocumentPermTyeActivity.f221725i;
        r101.G1().permissionTypeClick(1);
        DocumentPermTyeActivity.C1(this.f221751a, 1);
    }
}
