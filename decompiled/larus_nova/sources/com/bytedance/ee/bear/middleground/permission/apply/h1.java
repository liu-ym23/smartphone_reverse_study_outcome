package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class h1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermApplyFragment f233026a;

    public h1(PermApplyFragment r100) {
        this.f233026a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f233026a.Z90().setPermType(PermApplyViewModel.PermType.EDIT);
    }
}
