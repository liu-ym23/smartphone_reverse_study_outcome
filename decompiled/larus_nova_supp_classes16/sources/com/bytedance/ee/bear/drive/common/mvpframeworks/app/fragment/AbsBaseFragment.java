package com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsBaseFragment extends DriveRootFragment {
    public void U90(Bundle r1) {
    }

    public void bindViews(View r1) {
    }

    public abstract int getContentViewLayoutId();

    public abstract void initActions(View r1);

    public abstract void initData();

    public abstract void initViews(View r1, Bundle r2);

    public AbsBaseFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        initData();
        initViews(r1, r2);
        initActions(r1);
    }

    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        super.onCreateView(r3, r4, r5);
        View r6 = r3.inflate(getContentViewLayoutId(), r4, false);
        bindViews(r6);
        U90(r5);
        return r6;
    }
}
