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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class DocSDKBaseToolbarPlugin<T extends Toolbar> extends AbsEditorSdkPlugin {
    private static final String TAG = "BaseToolbarPlugin";
    private Observer<Boolean> activeObserver;
    private int toolbarHideAnimation;
    private a<T> toolbarJSHandler;
    private int toolbarShowAnimation;
    protected BaseToolbarPanelViewModel<T> toolbarViewModel;

    public interface a<T> extends i<T> {
        @Nullable
        /* bridge */ /* synthetic */ BridgeAuthType authType();

        void b(ItemId r1, String r2);

        /* synthetic */ void handle(T r1, m r2);
    }

    public static /* synthetic */ void a(DocSDKBaseToolbarPlugin r0, Boolean r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void c(DocSDKBaseToolbarPlugin r0, ItemId r1, String r2) {
        r0.lambda$onAttachToUIContainer$1(r1, r2);
    }

    private String getUrl() {
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public abstract /* synthetic */ void getBridgeHandlers(Map<String, i<?>> r1);

    public abstract String getToolbarJSBinderName();

    public abstract BaseToolbarPanelViewModel<T> getToolbarViewModel(ViewModelStoreOwner r1);

    public abstract Fragment onCreateToolbarFragment(Context r1, String r2);

    public abstract a<T> onCreateToolbarJSHandler();

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocSDKBaseToolbarPlugin() {
        this.activeObserver = new com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar.a(this);
    }

    private /* synthetic */ void lambda$new$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        ensureToolbarFragment(false);
        return;
    L5:
        tt5.a.h(TAG, "removeFragment");
        if (getUIContainer() == null) goto L10;
        getUIContainer().d(this);
        return;
    }

    public void ensureToolbarFragment(boolean r5) {
        t r0 = getUIContainer();
        Fragment r1 = getUIContainer().l(this);
        tt5.a.h(TAG, "ensureToolbarFragment force:" + r5 + ",current:" + r1);
        if (r1 == null) goto L5;
        if (r5 == true) goto L5;
        return;
    L5:
        Fragment r6 = onCreateToolbarFragment(getContext(), getUrl());
        Bundle r2 = r6.getArguments();
        if (r2 != null) goto L8;
        r2 = new Bundle();
    L8:
        r2.putBoolean("EnableExternalSelect", true);
        r6.setArguments(r2);
        int r3 = this.toolbarShowAnimation;
        if (r3 == 0) goto L11;
    L14:
        s r4 = s.a(r3, this.toolbarHideAnimation, 0, 0);
    L15:
        r0.e(this, r6, r4);
        return;
    L11:
        if (this.toolbarHideAnimation != 0) goto L14;
        r4 = null;
        goto L15
    }

    public void onAttachToHost(EditorSdkPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        this.toolbarViewModel = getToolbarViewModel(getActivity());
    }

    public final void updateToolbar(T r2) {
        this.toolbarViewModel.configToolbar(r2);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((EditorSdkPluginHost) r1);
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$1(ItemId r2, String r3) {
        this.toolbarJSHandler.b(r2, r3);
    }

    public void onAttachToUIContainer(EditorSdkPluginHost r3, t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        this.toolbarJSHandler = onCreateToolbarJSHandler();
        bindBridgeHandlerAutoUnbind(getToolbarJSBinderName(), this.toolbarJSHandler);
        this.toolbarViewModel.setDelegate(new b(this));
        this.toolbarViewModel.getActive().observe(getLifecycleOwner(), this.activeObserver);
        r3.a.registerEditPanel(getLifecycleOwner(), this.toolbarViewModel);
        this.toolbarViewModel.onAttachToUI(r3, getWeb());
        pcb.a.a.b(r3.getActivity()).c(this.toolbarViewModel);
    }

    public void onDetachFromUIContainer(EditorSdkPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        pcb.a.a.b(r1.getActivity()).a(this.toolbarViewModel);
        this.toolbarViewModel.onDetachFromUI();
    }

    public void setToolbarAnimation(int r1, int r2) {
        this.toolbarShowAnimation = r1;
        this.toolbarHideAnimation = r2;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((EditorSdkPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((EditorSdkPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((EditorSdkPluginHost) r1, r2);
    }
}
