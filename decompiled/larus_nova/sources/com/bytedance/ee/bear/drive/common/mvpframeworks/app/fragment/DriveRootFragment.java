package com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import l75.a;

/* JADX INFO: loaded from: classes16.dex */
public abstract class DriveRootFragment extends BaseFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f224081e;

    public DriveRootFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        a r101 = this.f224081e;
        if (r101 != null) goto L5;
    L6:
        this.f224081e = new a(r100, this);
        return;
    L5:
        if (r101.getBaseContext() != r100) goto L6;
    }
}
