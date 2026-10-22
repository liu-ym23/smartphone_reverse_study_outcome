package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements TextView.OnEditorActionListener {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    public l(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 6) goto L7;
        CustomPasswordSettingFragment r4 = this.a;
        r4.A = true;
        CustomPasswordSettingFragment.ea0(r4, true);
        return false;
    L7:
        return false;
    }
}
