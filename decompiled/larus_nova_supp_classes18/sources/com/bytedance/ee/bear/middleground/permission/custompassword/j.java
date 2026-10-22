package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements View.OnFocusChangeListener {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    public j(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r2, boolean r3) {
        if (r3 == false) goto L4;
        CustomPasswordSettingFragment.da0(this.a, true);
        return;
    L4:
        CustomPasswordSettingFragment.da0(this.a, false);
        tt5.a.h("CustomPasswordSettingFragment", "onFocusChange " + this.a.y);
        CustomPasswordSettingFragment r4 = this.a;
        if (r4.y == true) goto L7;
        CustomPasswordSettingFragment.ea0(r4, r4.A);
    L8:
        this.a.A = false;
        return;
    L7:
        r4.y = false;
        goto L8
    }
}
