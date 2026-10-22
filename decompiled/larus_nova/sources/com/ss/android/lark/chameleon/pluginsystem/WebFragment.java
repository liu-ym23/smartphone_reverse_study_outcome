package com.ss.android.lark.chameleon.pluginsystem;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.ActivityResultHandler;
import com.ss.android.lark.chameleon.pluginsystem.plugin.BackPressHandler;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginRuntime;
import com.ss.android.lark.chameleon.pluginsystem.plugin.SimpleUIContainer;
import com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public abstract class WebFragment extends Fragment implements PluginHost.Delegate, ActivityResultHandler, BackPressHandler {
    private static final String TAG = "WebFragment";
    private WebPluginHost pluginHost;
    private PluginRuntime pluginRuntime;
    private TitleBar titleBar;
    private UIContainer uiContainer;

    public static /* synthetic */ PluginHost S90(WebFragment r100) {
        return r100.lambda$onCreate$0();
    }

    public void ensureInitUiContainer(View r100) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost.Delegate
    public Fragment getHostFragment() {
        return this;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost.Delegate
    public LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public abstract WebPluginHost onCreatePluginHost();

    public abstract TitleBar onCreateTitleBar();

    public final TitleBar getTitleBar() {
        TitleBar r100 = this.titleBar;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("getTitleBar before onViewCreated");
    }

    public UIContainer getUIContainer() {
        if (this.uiContainer != null) goto L6;
        Log.e(TAG, new IllegalStateException("getUIContainer while not created yet !").toString());
    L6:
        return this.uiContainer;
    }

    private /* synthetic */ PluginHost lambda$onCreate$0() {
        WebPluginHost r100 = onCreatePluginHost();
        this.pluginHost = r100;
        return r100;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BackPressHandler
    public boolean onBackPressed() {
        List<Fragment> r100 = getChildFragmentManager().getFragments();
        if (r100 == null) goto L14;
        int r101 = r100.size() - 1;
    L5:
        if (r101 < 0) goto L14;
        Object r102 = (Fragment) ListProtector.get(r100, r101);
        if ((r102 instanceof BackPressHandler) == false) goto L12;
        if (((BackPressHandler) r102).onBackPressed() == false) goto L12;
        Log.i(TAG, "Back press consumed by :" + r102);
        return true;
    L12:
        r101 = r101 - 1;
    L14:
        return this.pluginHost.onDispatchBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.pluginRuntime.destroyHost(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.pluginRuntime.dispatchUIDetach(this, this.uiContainer);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.pluginRuntime.dispatchOnPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Web r100 = this.pluginHost.getWeb();
        if (r100 == null) goto L7;
        WebView r101 = r100.getWebView();
        if (r101 == null) goto L7;
        r101.resumeTimers();
    L7:
        this.pluginRuntime.dispatchOnResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.pluginRuntime.dispatchOnStart(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.pluginRuntime.dispatchOnStop(this);
    }

    public WebFragment() {
    }

    public WebPluginHost getPluginHost() {
        return this.pluginHost;
    }

    public void hideTitleBar(boolean r100) {
        UIContainer r101 = getUIContainer();
        if (r101 == null) goto L6;
        r101.getTitleBar().hide(r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.pluginRuntime.dispatchConfigurationChanged(this, r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        PluginReport.mWebFragmentOnCreate = System.currentTimeMillis();
        this.pluginRuntime = PluginRuntime.getInstance();
        this.pluginRuntime.createHost(new b(this), this);
        final boolean r101 = true;
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new AnonymousClass1(this, r101));
    }

    public UIContainer onCreateUIContainer(View r100) {
        Context r101 = getContext();
        Objects.requireNonNull(r101);
        return new SimpleUIContainer(r101, r100, getChildFragmentManager(), getTitleBar());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        PluginRuntime r101 = this.pluginRuntime;
        if (r101 == null) goto L6;
        r101.dispatchUserVisibleHint(this, r100);
        return;
    }

    public void showTitleBar(boolean r100) {
        UIContainer r101 = getUIContainer();
        if (r101 == null) goto L6;
        r101.getTitleBar().show(r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (this.titleBar != null) goto L6;
        this.titleBar = onCreateTitleBar();
    L6:
        if (this.uiContainer != null) goto L8;
        this.uiContainer = onCreateUIContainer(r100);
    L8:
        this.pluginRuntime.dispatchUIAttach(this, this.uiContainer);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        this.pluginHost.onDispatchActivityResult(r100, r101, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return new View(getContext());
    }
}
