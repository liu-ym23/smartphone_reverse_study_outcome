package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.text.TextUtils;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    public d(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        String r4 = (String) r3;
        if (TextUtils.isEmpty(r4) == true) goto L6;
        this.a.ga0().setText(r4);
        CustomPasswordSettingFragment r0 = this.a;
        r0.B = "random";
        r0.ga0().setSelection(r4.length());
        return;
    }
}
