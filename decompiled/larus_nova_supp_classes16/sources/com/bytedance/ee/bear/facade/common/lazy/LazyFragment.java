package com.bytedance.ee.bear.facade.common.lazy;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LazyFragment extends LazyBaseFragment {
    public Bundle i;
    public FrameLayout j;
    public boolean k;
    public boolean l;
    public boolean m;

    public void V90(Bundle r1) {
    }

    public void W90() {
    }

    public void X90() {
    }

    public void Y90() {
        a.b("LazyFragment", "onResumeLazy() called with: ");
    }

    public LazyFragment() {
        this.k = false;
        this.l = true;
        this.m = false;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        if (this.k == false) goto L5;
        W90();
    L5:
        this.k = false;
    }

    public final void onPause() {
        super.onPause();
        if (this.k == false) goto L6;
        a.b("LazyFragment", "onPauseLazy() called with: ");
        return;
    }

    public final void onResume() {
        super.onResume();
        if (this.k == false) goto L6;
        Y90();
        return;
    }

    public final void onStart() {
        super.onStart();
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.m == false) goto L7;
        return;
    L7:
        if (super.getUserVisibleHint() == false) goto L12;
        this.m = true;
        X90();
        return;
    }

    public final void onStop() {
        super.onStop();
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.m == true) goto L7;
        return;
    L7:
        if (super.getUserVisibleHint() == false) goto L12;
        this.m = false;
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment
    public final void U90(Bundle r4) {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        this.l = r0.getBoolean("intent_boolean_lazyLoad", this.l);
    L6:
        if (this.l == true) goto L8;
        V90(r4);
        this.k = true;
        return;
    L8:
        if (super.getUserVisibleHint() == true) goto L10;
    L12:
        FrameLayout r5 = new FrameLayout(this.g);
        this.j = r5;
        this.f = r5;
        return;
    L10:
        if (this.k == true) goto L12;
        this.i = r4;
        V90(r4);
        this.k = true;
    }

    public final void Z90(int r4) {
        if (this.l == false) goto L9;
        View r0 = this.f;
        if (r0 == null) goto L9;
        if (r0.getParent() == null) goto L9;
        this.j.removeAllViews();
        View r5 = this.e.inflate(r4, this.j, false);
        this.j.addView(r5);
        return;
    L9:
        aa0((ViewGroup) this.e.inflate(r4, this.h, false));
    }

    public final void aa0(View r2) {
        if (this.l == false) goto L9;
        View r0 = this.f;
        if (r0 == null) goto L9;
        if (r0.getParent() == null) goto L9;
        this.j.removeAllViews();
        this.j.addView(r2);
        return;
    L9:
        this.f = r2;
    }

    public void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        a.b("LazyFragment", "setUserVisibleHint() called with: isVisibleToUser = [" + r3 + "]");
        if (r3 == false) goto L10;
        if (this.k == true) goto L10;
        if (this.f == null) goto L10;
        V90(this.i);
        this.k = true;
        Y90();
    L10:
        if (this.k == true) goto L12;
        return;
    L12:
        if (this.f == null) goto L18;
        if (r3 == false) goto L15;
        this.m = true;
        X90();
        return;
    L15:
        this.m = false;
        return;
    }
}
