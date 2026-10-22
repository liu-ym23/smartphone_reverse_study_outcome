package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomPasswordSettingFragment f233816a;

    public h(CustomPasswordSettingFragment r100) {
        this.f233816a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CustomPasswordSettingFragment r101 = this.f233816a;
        r101.A = false;
        r101.na0().createRandomPassword();
        CustomPasswordSettingFragment.ea0(this.f233816a, false);
    }
}
