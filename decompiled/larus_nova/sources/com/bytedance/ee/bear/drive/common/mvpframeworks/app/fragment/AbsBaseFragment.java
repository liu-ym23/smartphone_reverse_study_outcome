package com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes16.dex */
public abstract class AbsBaseFragment extends DriveRootFragment {
    public void U90(Bundle r100) {
    }

    public void bindViews(View r100) {
    }

    public abstract int getContentViewLayoutId();

    public abstract void initActions(View r100);

    public abstract void initData();

    public abstract void initViews(View r100, Bundle r101);

    public AbsBaseFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        initData();
        initViews(r100, r101);
        initActions(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        super.onCreateView(r100, r101, r102);
        View r103 = r100.inflate(getContentViewLayoutId(), r101, false);
        bindViews(r103);
        U90(r102);
        return r103;
    }
}
