package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomPasswordSettingFragment f233818a;

    public j(CustomPasswordSettingFragment r100) {
        this.f233818a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L4;
        CustomPasswordSettingFragment.da0(this.f233818a, true);
        return;
    L4:
        CustomPasswordSettingFragment.da0(this.f233818a, false);
        tt5.a.h("CustomPasswordSettingFragment", "onFocusChange " + this.f233818a.f233795y);
        CustomPasswordSettingFragment r102 = this.f233818a;
        if (r102.f233795y == true) goto L7;
        CustomPasswordSettingFragment.ea0(r102, r102.A);
    L8:
        this.f233818a.A = false;
        return;
    L7:
        r102.f233795y = false;
        goto L8
    }
}
