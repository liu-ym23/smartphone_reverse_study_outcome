package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements View.OnTouchListener {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    public k(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        boolean r4 = false;
        if (r3 != null) goto L5;
    L7:
        if (r4 == false) goto L9;
        CustomPasswordSettingFragment r5 = this.a;
        r5.A = true;
        CustomPasswordSettingFragment.ea0(r5, true);
    L9:
        return true;
    L5:
        if (r3.getAction() != 0) goto L7;
        r4 = true;
        goto L7
    }
}
