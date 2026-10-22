package com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import l75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class DriveRootFragment extends BaseFragment {
    public a e;

    public DriveRootFragment() {
    }

    public final void onAttach(Context r2) {
        super.onAttach(r2);
        a r0 = this.e;
        if (r0 != null) goto L5;
    L6:
        this.e = new a(r2, this);
        return;
    L5:
        if (r0.getBaseContext() != r2) goto L6;
    }
}
