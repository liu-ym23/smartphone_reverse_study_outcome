package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomPasswordSettingFragment f233820a;

    public l(CustomPasswordSettingFragment r100) {
        this.f233820a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 6) goto L7;
        CustomPasswordSettingFragment r103 = this.f233820a;
        r103.A = true;
        CustomPasswordSettingFragment.ea0(r103, true);
        return false;
    L7:
        return false;
    }
}
