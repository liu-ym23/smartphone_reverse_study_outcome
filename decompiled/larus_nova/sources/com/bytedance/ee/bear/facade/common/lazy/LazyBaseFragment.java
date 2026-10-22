package com.bytedance.ee.bear.facade.common.lazy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class LazyBaseFragment extends BaseFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutInflater f226429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f226430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Context f226431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f226432h;

    public void U90(Bundle r100) {
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    L4:
        e = move-exception;
        a.d("LazyBaseFragment", "getUserVisibleHint()... e =" + e.toString());
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f226430f = null;
        this.f226432h = null;
        this.f226429e = null;
    }

    public LazyBaseFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    public final View findViewById(int r100) {
        View r101 = this.f226430f;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.findViewById(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f226431g = getActivity().getApplicationContext();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r100) {
        r100.putString("FragmentManagerImpl_Null_Bug", "FragmentManagerImpl_NULL_Bug");
        super.onSaveInstanceState(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.f226429e = r100;
        this.f226432h = r101;
        U90(r102);
        View r103 = this.f226430f;
        if (r103 == null) goto L5;
        return r103;
    L5:
        return super.onCreateView(r100, r101, r102);
    }
}
