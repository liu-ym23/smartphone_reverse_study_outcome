package com.bytedance.ee.bear.browser.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;

/* JADX INFO: loaded from: classes16.dex */
public class BasePlugin<H extends PluginHost> implements f<H> {
    private static final String TAG = "BasePlugin";
    private H host;

    public BasePlugin() {
    }

    public PluginMountStrategy getMountStrategy() {
        return null;
    }

    public String getPluginId() {
        return "";
    }

    public Enum<?> getUILevel() {
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public boolean isViewImmersive() {
        return false;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(H r100, t r101) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(H r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(H r100, t r101) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public void onResume(H r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public void onStart(H r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public void onStop(H r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public void setUserVisibleHint(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public H getHost() {
        if (this.host != null) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.c(TAG, "", new IllegalStateException("getHost when plugin not attached or already detached !"));
    L6:
        return this.host;
    }

    public t getUIContainer() throws IllegalStateException {
        t r100 = this.host.getUIContainer();
        if (r100 != null) goto L5;
        com.ss.android.lark.officesdk.utils.di.j.c(TAG, "", new IllegalStateException("GetUiContainer when plugin not attached to UI or already detached from UI! Call isUIContainerAttached first."));
    L5:
        return r100;
    }

    public boolean isUIContainerAttached() {
        H r100 = this.host;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getUIContainer() == null) goto L7;
        return true;
    }

    public boolean isUIContainerDetached() {
        H r100 = this.host;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.getUIContainer() == null) goto L8;
        return false;
    }

    public boolean isVisibleToUser() {
        H r100 = this.host;
        if (r100 != null) goto L5;
        return false;
    L5:
        FragmentActivity r101 = r100.getActivity();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L12;
        return true;
    L12:
        return false;
    }

    public FragmentActivity getActivity() {
        return getHost().getActivity();
    }

    public Context getContext() {
        return getActivity();
    }

    public FragmentManager getFragmentManager() {
        return getUIContainer().getFragmentManager();
    }

    public LifecycleOwner getLifecycleOwner() {
        return getHost().getLifecycleOwner();
    }

    public Resources getResources() {
        return getContext().getResources();
    }

    public TitleBar getTitleBar() {
        if (isUIContainerAttached() == true) goto L5;
        return null;
    L5:
        return getUIContainer().getTitleBar();
    }

    public void removeFragment() {
        getUIContainer().d(this);
    }

    public void addOrReplaceFragment(Class<? extends Fragment> r100) {
        addOrReplaceFragment(r100, null);
    }

    public <P extends f> P findPlugin(Class<P> r100) {
        return (P) getHost().findPlugin(r100);
    }

    public ViewGroup getContainer(int r100) {
        return this.host.getContainer(r100);
    }

    public <T extends i> T getHostAbility(Class<T> r100) {
        return (T) getHost().getHostAbility(r100);
    }

    public <T extends i> T getHostAbilityOrNull(Class<T> r100) {
        return (T) getHost().getHostAbilityOrNull(r100);
    }

    public String getString(int r100) {
        return getContext().getString(r100);
    }

    public <F extends Fragment> F instantiateFragment(Class<F> r100) {
        return (F) instantiateFragment(r100, null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(H r100) {
        setHost(r100);
    }

    public final void setHost(H r100) {
        this.host = r100;
    }

    public <T extends ViewModel> T viewModel(Class<T> r100) {
        return (T) q.c(getHost(), r100, null);
    }

    public void addOrReplaceFragment(Class<? extends Fragment> r100, Bundle r101) {
        addOrReplaceFragment(r100, r101, null);
    }

    public <F extends Fragment> F instantiateFragment(Class<F> r100, Bundle r101) {
        if (r101 != null) goto L4;
        r101 = new Bundle();
    L4:
        PluginHost.writePluginHostToBundle(r101, this);
        return (F) Fragment.instantiate(getContext(), r100.getName(), r101);
    }

    public <T extends ViewModel> T viewModel(Class<T> r100, ViewModelProvider.Factory r101) {
        return (T) q.c(getHost(), r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addOrReplaceFragment(Class<? extends Fragment> r100, Bundle r101, s r102) {
        t r103 = getUIContainer();
        if (r103.l(this) != null) goto L6;
        r103.e(this, instantiateFragment(r100, r101), r102);
        return;
    }
}
