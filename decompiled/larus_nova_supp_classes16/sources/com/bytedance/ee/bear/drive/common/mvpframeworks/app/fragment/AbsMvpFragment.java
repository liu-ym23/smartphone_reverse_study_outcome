package com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import m75.d;
import m75.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsMvpFragment<P extends d> extends AbsBaseFragment implements e {
    public P f;

    public abstract P V90(Context r1);

    public void onDestroyView() {
        super.onDestroyView();
        this.f.onDestroy();
        this.f.detachView();
    }

    public final void onPause() {
        super.onPause();
        this.f.onPause();
    }

    public final void onResume() {
        super.onResume();
        this.f.onResume();
    }

    public final void onStart() {
        super.onStart();
        this.f.onStart();
    }

    public final void onStop() {
        super.onStop();
        this.f.onStop();
    }

    public AbsMvpFragment() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.fragment.AbsBaseFragment
    public final void U90(Bundle r3) {
        this.f.f(this);
        this.f.e(getArguments(), r3);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (this.f != null) goto L6;
        this.f = (P) V90(getActivity());
        return;
    }

    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        this.f.h(r2);
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        this.f.onActivityResult(r2, r3, r4);
    }
}
