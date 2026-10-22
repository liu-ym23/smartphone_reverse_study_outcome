package com.bytedance.ee.bear.middleground.docsdk.v2;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.atfinder.e;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.edit.component.document.at.AtFinderHandler;
import com.bytedance.ee.bear.edit.component.document.at.AtPanelFragment;
import com.bytedance.ee.bear.edit.component.document.at.AtPanelViewModel;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Map;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseSDKMentionPlugin extends AbsEditorSdkPlugin {
    private static final String TAG = "BaseSDKMentionPlugin";
    private AtFinderHandler atFinderHandler;
    private AtPanelViewModel atViewModel;
    private Observer<Boolean> mActiveObserver;

    public static /* synthetic */ void a(BaseSDKMentionPlugin r0, Boolean r1) {
        r0.lambda$onAttachToUIContainer$0(r1);
    }

    public String getUrl() {
        return "";
    }

    public abstract e onCreateMentionDelegate();

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public BaseSDKMentionPlugin() {
        this.atFinderHandler = new AtFinderHandler();
    }

    private void ensureAtFragment() {
        t r0 = getUIContainer();
        if (r0.l(this) != null) goto L6;
        Bundle r1 = new Bundle();
        r1.putString(ResourceData.KEY_URL, getUrl());
        r0.i(this, instantiateFragment(AtPanelFragment.class, r1));
        return;
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        ensureAtFragment();
        return;
    L5:
        f r3 = findPlugin(getClass());
        if (r3 != null) goto L8;
        return;
    L8:
        if (getUIContainer() == null) goto L13;
        getUIContainer().d(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.util.atfinder", this.atFinderHandler);
    }

    public void onAttachToHost(EditorSdkPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        AtPanelViewModel r0 = viewModel(AtPanelViewModel.class);
        this.atViewModel = r0;
        AtFinderHandler r1 = this.atFinderHandler;
        r1.c = r0;
        r0.setDataCallback(r1.d);
        this.atViewModel.setEditPanelsManager(r3.a);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((EditorSdkPluginHost) r1);
    }

    public void onAttachToUIContainer(EditorSdkPluginHost r3, t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        if (this.mActiveObserver != null) goto L5;
        this.mActiveObserver = new a(this);
        this.atViewModel.getActive().observe(getLifecycleOwner(), this.mActiveObserver);
    L5:
        r3.a.registerEditPanel(getLifecycleOwner(), this.atViewModel);
        if (this.atViewModel.getMentionDelegate() != null) goto L8;
        this.atViewModel.setMentionDelegate(onCreateMentionDelegate());
    L8:
        pcb.a.a.b(r3.getActivity()).c(this.atViewModel);
    }

    public void onDetachFromUIContainer(EditorSdkPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        pcb.a.a.b(r1.getActivity()).a(this.atViewModel);
        this.atViewModel.onDetachFromUI();
        this.atViewModel.setActive(false);
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
