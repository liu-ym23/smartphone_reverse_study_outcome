package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.text.TextUtils;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomPasswordSettingFragment f233812a;

    public d(CustomPasswordSettingFragment r100) {
        this.f233812a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (TextUtils.isEmpty(r101) == true) goto L6;
        this.f233812a.ga0().setText(r101);
        CustomPasswordSettingFragment r102 = this.f233812a;
        r102.B = "random";
        r102.ga0().setSelection(r101.length());
        return;
    }
}
