package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes23.dex */
public class SimpleImmersionProxy {
    private Fragment mFragment;
    private boolean mIsActivityCreated;
    private SimpleImmersionOwner mSimpleImmersionOwner;

    private void setImmersionBar() {
        Fragment r100 = this.mFragment;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mIsActivityCreated == true) goto L7;
        return;
    L7:
        if (r100.getUserVisibleHint() == true) goto L9;
        return;
    L9:
        if (this.mSimpleImmersionOwner.immersionBarEnabled() == false) goto L15;
        this.mSimpleImmersionOwner.initImmersionBar();
        return;
    }

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
        this.mSimpleImmersionOwner = null;
        return;
    L5:
        if (r100.getActivity() == null) goto L9;
        if (this.mSimpleImmersionOwner.immersionBarEnabled() == false) goto L9;
        ImmersionBar.with(this.mFragment).destroy();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleImmersionProxy(Fragment r100) {
        this.mFragment = r100;
        if ((r100 instanceof SimpleImmersionOwner) == false) goto L7;
        this.mSimpleImmersionOwner = (SimpleImmersionOwner) r100;
        return;
    L7:
        throw new IllegalArgumentException("please implement SimpleImmersionOwner in your Fragment");
    }

    public void onActivityCreated(Bundle r100) {
        this.mIsActivityCreated = true;
        setImmersionBar();
    }

    public void onConfigurationChanged(Configuration r100) {
        setImmersionBar();
    }

    public void onHiddenChanged(boolean r100) {
        Fragment r101 = this.mFragment;
        if (r101 == null) goto L6;
        r101.setUserVisibleHint(!r100);
        return;
    }

    public void setUserVisibleHint(boolean r100) {
        setImmersionBar();
    }
}
