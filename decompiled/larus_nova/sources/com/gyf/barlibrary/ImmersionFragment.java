package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ImmersionFragment extends Fragment implements ImmersionOwner {
    private ImmersionProxy mImmersionProxy;

    @Override // com.gyf.barlibrary.ImmersionOwner
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onInvisible() {
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onLazyAfterView() {
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onLazyBeforeView() {
    }

    @Override // com.gyf.barlibrary.ImmersionOwner
    public void onVisible() {
    }

    public ImmersionFragment() {
        this.mImmersionProxy = new ImmersionProxy(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mImmersionProxy.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mImmersionProxy.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mImmersionProxy.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        this.mImmersionProxy.onActivityCreated(r100);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.mImmersionProxy.onConfigurationChanged(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.mImmersionProxy.onCreate(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        this.mImmersionProxy.onHiddenChanged(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        this.mImmersionProxy.setUserVisibleHint(r100);
    }
}
