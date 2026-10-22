package com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import m75.d;
import m75.e;

/* JADX INFO: loaded from: classes16.dex */
public abstract class AbsMvpFragment<P extends d> extends AbsBaseFragment implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public P f224080f;

    public abstract P V90(Context r100);

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f224080f.onDestroy();
        this.f224080f.detachView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f224080f.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f224080f.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f224080f.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f224080f.onStop();
    }

    public AbsMvpFragment() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void U90(Bundle r100) {
        this.f224080f.f(this);
        this.f224080f.e(getArguments(), r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f224080f != null) goto L6;
        this.f224080f = (P) V90(getActivity());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        this.f224080f.h(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        this.f224080f.onActivityResult(r100, r101, r102);
    }
}
