package com.ss.android.bytedcert.video.fragment.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes34.dex */
public abstract class AbsBaseFragment extends RootFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f407705e;

    public abstract int getContentViewLayoutId();

    public abstract void initActions(View r100);

    public abstract void initData();

    public abstract void initViews(View r100, Bundle r101);

    public AbsBaseFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (this.f407705e == false) goto L5;
        return;
    L5:
        initData();
        if (this.f407705e == false) goto L8;
        return;
    L8:
        initViews(r100, r101);
        if (this.f407705e == false) goto L11;
        return;
    L11:
        initActions(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        super.onCreateView(r100, r101, r102);
        this.f407705e = false;
        return r100.inflate(getContentViewLayoutId(), r101, false);
    }
}
