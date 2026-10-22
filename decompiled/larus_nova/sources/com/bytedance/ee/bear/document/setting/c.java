package com.bytedance.ee.bear.document.setting;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocumentPermTyeActivity f221752a;

    public c(DocumentPermTyeActivity r100) {
        this.f221752a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DocumentPermTyeActivity r101 = this.f221752a;
        int r102 = DocumentPermTyeActivity.f221725i;
        r101.G1().permissionTypeClick(2);
        DocumentPermTyeActivity.C1(this.f221752a, 2);
    }
}
