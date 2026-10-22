package com.bytedance.ee.bear.facade.common.lazy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LazyBaseFragment extends BaseFragment {
    public LayoutInflater e;
    public View f;
    public Context g;
    public ViewGroup h;

    public void U90(Bundle r1) {
    }

    public final boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    L4:
        e = move-exception;
        a.d("LazyBaseFragment", "getUserVisibleHint()... e =" + e.toString());
        return true;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f = null;
        this.h = null;
        this.e = null;
    }

    public LazyBaseFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public void onDetach() {
        super.onDetach();
    }

    public final View findViewById(int r2) {
        View r0 = this.f;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.findViewById(r2);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.g = getActivity().getApplicationContext();
    }

    public void onSaveInstanceState(Bundle r3) {
        r3.putString("FragmentManagerImpl_Null_Bug", "FragmentManagerImpl_NULL_Bug");
        super.onSaveInstanceState(r3);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.e = r2;
        this.h = r3;
        U90(r4);
        View r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.onCreateView(r2, r3, r4);
    }
}
