package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    public g(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        CustomPasswordSettingFragment r7 = this.a;
        r7.A = true;
        if (r7.na0().precheckSave() == false) goto L5;
    L6:
        CustomSettingViewModel r8 = this.a.na0();
        CustomPasswordSettingFragment r1 = this.a;
        String r2 = r1.v;
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        Integer r3 = r1.w;
        if (r3 == null) goto L12;
        int r4 = r3.intValue();
    L13:
        r8.savePassword(r2, r4, String.valueOf(this.a.ga0().getText()), this.a.B);
    L14:
        CustomPasswordSettingFragment.ea0(this.a, true);
        return;
    L12:
        r4 = -1;
        goto L13
    L5:
        if (this.a.na0().ruleLoadSuccess() == true) goto L14;
        goto L6
    }
}
