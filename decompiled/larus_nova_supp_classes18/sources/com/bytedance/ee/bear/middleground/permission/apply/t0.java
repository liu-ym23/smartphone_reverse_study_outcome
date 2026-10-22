package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t0 implements View.OnClickListener {
    public final /* synthetic */ OfficeBitableApplyPermissionFragment a;

    public t0(OfficeBitableApplyPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        OfficeBitableApplyPermissionFragment r3 = this.a;
        int r0 = OfficeBitableApplyPermissionFragment.r;
        UDEditText r4 = r3.k;
        if (r4 == null) goto L7;
        r4.clearFocus();
        KeyboardUtils.hideKeyboard(r4.getContext(), r4);
        return;
    }
}
