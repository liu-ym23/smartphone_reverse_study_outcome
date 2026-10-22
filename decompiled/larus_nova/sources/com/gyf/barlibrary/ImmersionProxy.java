package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes23.dex */
public class ImmersionProxy {
    private Fragment mFragment;
    private ImmersionOwner mImmersionOwner;
    private boolean mIsActivityCreated;
    private boolean mIsLazyAfterView;
    private boolean mIsLazyBeforeView;

    public boolean isUserVisibleHint() {
        Fragment r100 = this.mFragment;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.getUserVisibleHint();
    }

    public void onDestroy() {
        Fragment r100 = this.mFragment;
        if (r100 != null) goto L5;
    L9:
        this.mFragment = null;
        this.mImmersionOwner = null;
        return;
    L5:
        if (r100.getActivity() == null) goto L9;
        if (this.mImmersionOwner.immersionBarEnabled() == false) goto L9;
        ImmersionBar.with(this.mFragment).destroy();
        goto L9
    }

    public void onPause() {
        if (this.mFragment == null) goto L6;
        this.mImmersionOwner.onInvisible();
        return;
    }

    public void onResume() {
        Fragment r100 = this.mFragment;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getUserVisibleHint() == false) goto L9;
        this.mImmersionOwner.onVisible();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmersionProxy(Fragment r100) {
        this.mFragment = r100;
        if ((r100 instanceof ImmersionOwner) == false) goto L7;
        this.mImmersionOwner = (ImmersionOwner) r100;
        return;
    L7:
        throw new IllegalArgumentException("please implement SimpleImmersionOwner in your Fragment");
    }

    public void onActivityCreated(Bundle r100) {
        this.mIsActivityCreated = true;
        Fragment r101 = this.mFragment;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.mImmersionOwner.immersionBarEnabled() == false) goto L10;
        this.mImmersionOwner.initImmersionBar();
    L10:
        if (this.mIsLazyAfterView == true) goto L15;
        this.mImmersionOwner.onLazyAfterView();
        this.mIsLazyAfterView = true;
        return;
    }

    public void onConfigurationChanged(Configuration r100) {
        Fragment r101 = this.mFragment;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.mImmersionOwner.immersionBarEnabled() == false) goto L9;
        this.mImmersionOwner.initImmersionBar();
    L9:
        this.mImmersionOwner.onVisible();
    }

    public void onCreate(Bundle r100) {
        Fragment r101 = this.mFragment;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.mIsLazyBeforeView == true) goto L12;
        this.mImmersionOwner.onLazyBeforeView();
        this.mIsLazyBeforeView = true;
        return;
    }

    public void onHiddenChanged(boolean r100) {
        Fragment r101 = this.mFragment;
        if (r101 == null) goto L6;
        r101.setUserVisibleHint(!r100);
        return;
    }

    public void setUserVisibleHint(boolean r100) {
        Fragment r101 = this.mFragment;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUserVisibleHint() == false) goto L21;
        if (this.mIsLazyBeforeView == true) goto L10;
        this.mImmersionOwner.onLazyBeforeView();
        this.mIsLazyBeforeView = true;
    L10:
        if (this.mIsActivityCreated == true) goto L12;
        return;
    L12:
        if (this.mFragment.getUserVisibleHint() == true) goto L14;
        return;
    L14:
        if (this.mImmersionOwner.immersionBarEnabled() == false) goto L17;
        this.mImmersionOwner.initImmersionBar();
    L17:
        if (this.mIsLazyAfterView == true) goto L19;
        this.mImmersionOwner.onLazyAfterView();
        this.mIsLazyAfterView = true;
    L19:
        this.mImmersionOwner.onVisible();
        return;
    L21:
        if (this.mIsActivityCreated == false) goto L28;
        this.mImmersionOwner.onInvisible();
        return;
    }
}
