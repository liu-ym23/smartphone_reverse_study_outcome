package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes23.dex */
public abstract class SimpleImmersionFragment extends Fragment implements SimpleImmersionOwner {
    private SimpleImmersionProxy mSimpleImmersionProxy;

    @Override // com.gyf.barlibrary.SimpleImmersionOwner
    public boolean immersionBarEnabled() {
        return true;
    }

    public SimpleImmersionFragment() {
        this.mSimpleImmersionProxy = new SimpleImmersionProxy(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mSimpleImmersionProxy.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        this.mSimpleImmersionProxy.onActivityCreated(r100);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.mSimpleImmersionProxy.onConfigurationChanged(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        this.mSimpleImmersionProxy.onHiddenChanged(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        this.mSimpleImmersionProxy.setUserVisibleHint(r100);
    }
}
