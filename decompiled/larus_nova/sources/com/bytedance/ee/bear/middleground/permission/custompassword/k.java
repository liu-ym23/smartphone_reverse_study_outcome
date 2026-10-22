package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomPasswordSettingFragment f233819a;

    public k(CustomPasswordSettingFragment r100) {
        this.f233819a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L9;
        CustomPasswordSettingFragment r103 = this.f233819a;
        r103.A = true;
        CustomPasswordSettingFragment.ea0(r103, true);
    L9:
        return true;
    L5:
        if (r101.getAction() != 0) goto L7;
        r102 = true;
        goto L7
    }
}
