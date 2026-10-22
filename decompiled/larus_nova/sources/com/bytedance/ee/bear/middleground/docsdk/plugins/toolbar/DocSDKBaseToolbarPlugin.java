package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import java.util.Map;
import javax.annotation.Nullable;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes18.dex */
public abstract class DocSDKBaseToolbarPlugin<T extends Toolbar> extends AbsEditorSdkPlugin {
    private static final String TAG = "BaseToolbarPlugin";
    private Observer<Boolean> activeObserver;
    private int toolbarHideAnimation;
    private a<T> toolbarJSHandler;
    private int toolbarShowAnimation;
    protected BaseToolbarPanelViewModel<T> toolbarViewModel;

    public interface a<T> extends i<T> {
        @Override // tb5.i, tb5.o
        @Nullable
        /* bridge */ /* synthetic */ BridgeAuthType authType();

        void b(ItemId r100, String r101);

        @Override // tb5.i, tb5.o
        /* synthetic */ void handle(T r100, m r101);
    }

    public static /* synthetic */ void a(DocSDKBaseToolbarPlugin r100, Boolean r101) {
        r100.lambda$new$0(r101);
    }

    public static /* synthetic */ void c(DocSDKBaseToolbarPlugin r100, ItemId r101, String r102) {
        r100.lambda$onAttachToUIContainer$1(r101, r102);
    }

    private String getUrl() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin, yv4.a
    public abstract /* synthetic */ void getBridgeHandlers(Map<String, i<?>> r100);

    public abstract String getToolbarJSBinderName();

    public abstract BaseToolbarPanelViewModel<T> getToolbarViewModel(ViewModelStoreOwner r100);

    public abstract Fragment onCreateToolbarFragment(Context r100, String r101);

    public abstract a<T> onCreateToolbarJSHandler();

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public DocSDKBaseToolbarPlugin() {
        this.activeObserver = new com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.a(this);
    }

    private /* synthetic */ void lambda$new$0(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L5;
        ensureToolbarFragment(false);
        return;
    L5:
        tt5.a.h(TAG, "removeFragment");
        if (getUIContainer() == null) goto L10;
        getUIContainer().d(this);
        return;
    }

    public void ensureToolbarFragment(boolean r100) {
        t r101 = getUIContainer();
        Fragment r102 = getUIContainer().l(this);
        tt5.a.h(TAG, "ensureToolbarFragment force:" + r100 + ",current:" + r102);
        if (r102 == null) goto L5;
        if (r100 == true) goto L5;
        return;
    L5:
        Fragment r103 = onCreateToolbarFragment(getContext(), getUrl());
        Bundle r104 = r103.getArguments();
        if (r104 != null) goto L8;
        r104 = new Bundle();
    L8:
        r104.putBoolean("EnableExternalSelect", true);
        r103.setArguments(r104);
        int r105 = this.toolbarShowAnimation;
        if (r105 == 0) goto L11;
    L14:
        s r106 = s.a(r105, this.toolbarHideAnimation, 0, 0);
    L15:
        r101.e(this, r103, r106);
        return;
    L11:
        if (this.toolbarHideAnimation != 0) goto L14;
        r106 = null;
        goto L15
    }

    public void onAttachToHost(EditorSdkPluginHost r100) {
        super.onAttachToHost(r100);
        this.toolbarViewModel = getToolbarViewModel(getActivity());
    }

    public final void updateToolbar(T r100) {
        this.toolbarViewModel.configToolbar(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((EditorSdkPluginHost) r100);
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$1(ItemId r100, String r101) {
        this.toolbarJSHandler.b(r100, r101);
    }

    public void onAttachToUIContainer(EditorSdkPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        this.toolbarJSHandler = onCreateToolbarJSHandler();
        bindBridgeHandlerAutoUnbind(getToolbarJSBinderName(), this.toolbarJSHandler);
        this.toolbarViewModel.setDelegate(new b(this));
        this.toolbarViewModel.getActive().observe(getLifecycleOwner(), this.activeObserver);
        r100.f232401a.registerEditPanel(getLifecycleOwner(), this.toolbarViewModel);
        this.toolbarViewModel.onAttachToUI(r100, getWeb());
        pcb.a.AbstractC7181a.b(r100.getActivity()).c(this.toolbarViewModel);
    }

    public void onDetachFromUIContainer(EditorSdkPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        pcb.a.AbstractC7181a.b(r100.getActivity()).a(this.toolbarViewModel);
        this.toolbarViewModel.onDetachFromUI();
    }

    public void setToolbarAnimation(int r100, int r101) {
        this.toolbarShowAnimation = r100;
        this.toolbarHideAnimation = r101;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((EditorSdkPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((EditorSdkPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((EditorSdkPluginHost) r100, r101);
    }
}
