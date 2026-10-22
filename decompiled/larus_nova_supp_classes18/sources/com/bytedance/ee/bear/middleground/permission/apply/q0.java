package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q0 implements View.OnClickListener {
    public final /* synthetic */ OfficeBitableApplyPermissionFragment a;

    public q0(OfficeBitableApplyPermissionFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        FragmentActivity r2 = this.a.getActivity();
        if (r2 == null) goto L6;
        r2.onBackPressed();
        return;
    }
}
