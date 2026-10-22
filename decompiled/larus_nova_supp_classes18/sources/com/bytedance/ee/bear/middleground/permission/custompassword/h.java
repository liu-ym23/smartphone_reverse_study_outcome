package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    public h(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        CustomPasswordSettingFragment r3 = this.a;
        r3.A = false;
        r3.na0().createRandomPassword();
        CustomPasswordSettingFragment.ea0(this.a, false);
    }
}
