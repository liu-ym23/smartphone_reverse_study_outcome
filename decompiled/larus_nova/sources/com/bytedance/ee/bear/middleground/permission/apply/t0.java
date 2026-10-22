package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes18.dex */
public final class t0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBitableApplyPermissionFragment f233074a;

    public t0(OfficeBitableApplyPermissionFragment r100) {
        this.f233074a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OfficeBitableApplyPermissionFragment r101 = this.f233074a;
        int r102 = OfficeBitableApplyPermissionFragment.f232937r;
        SpaceEditText r103 = r101.f232944k;
        if (r103 == null) goto L7;
        r103.clearFocus();
        KeyboardUtils.hideKeyboard(r103.getContext(), r103);
        return;
    }
}
