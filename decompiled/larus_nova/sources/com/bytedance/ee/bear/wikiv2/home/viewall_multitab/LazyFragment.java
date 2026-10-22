package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.facade.common.BaseFragment;

/* JADX INFO: loaded from: classes18.dex */
public abstract class LazyFragment extends BaseFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f240720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f240721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f240722g;

    public void U90() {
    }

    public void V90() {
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    L4:
        e = move-exception;
        tt5.a.f("AbsDrivePreviewFragment", e, false);
        return true;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f240721f = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f240722g == false) goto L6;
        V90();
        return;
    }

    public LazyFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (getUserVisibleHint() == false) goto L9;
        this.f240720e = true;
        if (this.f240721f == true) goto L7;
        return;
    L7:
        if (this.f240722g == true) goto L16;
        this.f240722g = true;
        U90();
        return;
    L16:
        return;
    L9:
        this.f240720e = false;
        if (this.f240721f == true) goto L12;
        return;
    L12:
        if (this.f240722g == false) goto L19;
        this.f240722g = false;
        V90();
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f240721f = true;
        if (this.f240722g == false) goto L5;
        return;
    L5:
        if (this.f240720e == false) goto L9;
        this.f240722g = true;
        U90();
        return;
    }
}
