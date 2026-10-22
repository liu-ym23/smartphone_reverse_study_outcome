package com.bytedance.ee.bear.facade.common.lazy;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class LazyFragment extends LazyBaseFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bundle f226433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f226434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f226435k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f226436l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f226437m;

    public void V90(Bundle r100) {
    }

    public void W90() {
    }

    public void X90() {
    }

    public void Y90() {
        a.b("LazyFragment", "onResumeLazy() called with: ");
    }

    public LazyFragment() {
        this.f226435k = false;
        this.f226436l = true;
        this.f226437m = false;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        if (this.f226435k == false) goto L5;
        W90();
    L5:
        this.f226435k = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.f226435k == false) goto L6;
        a.b("LazyFragment", "onPauseLazy() called with: ");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f226435k == false) goto L6;
        Y90();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (this.f226435k == true) goto L5;
        return;
    L5:
        if (this.f226437m == false) goto L7;
        return;
    L7:
        if (super.getUserVisibleHint() == false) goto L12;
        this.f226437m = true;
        X90();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        if (this.f226435k == true) goto L5;
        return;
    L5:
        if (this.f226437m == true) goto L7;
        return;
    L7:
        if (super.getUserVisibleHint() == false) goto L12;
        this.f226437m = false;
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment
    public final void U90(Bundle r100) {
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        this.f226436l = r101.getBoolean("intent_boolean_lazyLoad", this.f226436l);
    L6:
        if (this.f226436l == true) goto L8;
        V90(r100);
        this.f226435k = true;
        return;
    L8:
        if (super.getUserVisibleHint() == true) goto L10;
    L12:
        FrameLayout r102 = new FrameLayout(this.f226431g);
        this.f226434j = r102;
        this.f226430f = r102;
        return;
    L10:
        if (this.f226435k == true) goto L12;
        this.f226433i = r100;
        V90(r100);
        this.f226435k = true;
    }

    public final void Z90(int r100) {
        if (this.f226436l == false) goto L9;
        View r101 = this.f226430f;
        if (r101 == null) goto L9;
        if (r101.getParent() == null) goto L9;
        this.f226434j.removeAllViews();
        View r102 = this.f226429e.inflate(r100, this.f226434j, false);
        this.f226434j.addView(r102);
        return;
    L9:
        aa0((ViewGroup) this.f226429e.inflate(r100, this.f226432h, false));
    }

    public final void aa0(View r100) {
        if (this.f226436l == false) goto L9;
        View r101 = this.f226430f;
        if (r101 == null) goto L9;
        if (r101.getParent() == null) goto L9;
        this.f226434j.removeAllViews();
        this.f226434j.addView(r100);
        return;
    L9:
        this.f226430f = r100;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        a.b("LazyFragment", "setUserVisibleHint() called with: isVisibleToUser = [" + r100 + "]");
        if (r100 == false) goto L10;
        if (this.f226435k == true) goto L10;
        if (this.f226430f == null) goto L10;
        V90(this.f226433i);
        this.f226435k = true;
        Y90();
    L10:
        if (this.f226435k == true) goto L12;
        return;
    L12:
        if (this.f226430f == null) goto L18;
        if (r100 == false) goto L15;
        this.f226437m = true;
        X90();
        return;
    L15:
        this.f226437m = false;
        return;
    }
}
