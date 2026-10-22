package com.bytedance.ee.bear.document.edit_toolbar;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseToolbarV2Plugin<T extends ToolbarV2> extends DocumentPluginV3 {
    public static final String TAG = "ToolbarV2";
    private Observer<Boolean> activeObserver;
    protected BaseToolbarV2PanelViewModel<T> toolbarViewModel;

    public static /* synthetic */ void a(BaseToolbarV2Plugin r0, Boolean r1) {
        r0.lambda$new$0(r1);
    }

    public abstract BaseToolbarV2PanelViewModel<T> getToolbarViewModel();

    public abstract Fragment onCreateToolbarFragment(Context r1, String r2);

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public BaseToolbarV2Plugin() {
        this.activeObserver = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void ensureToolbarFragment() {
        t r0 = getUIContainer();
        Fragment r1 = r0.l(this);
        if (r1 != null) goto L12;
        Fragment r2 = onCreateToolbarFragment(getContext(), getEditorAbility().getDocumentMetadata().getUrl());
        Bundle r3 = r2.getArguments();
        if (r3 != null) goto L8;
        r3 = new Bundle();
    L8:
        if (getEditorAbility().getDocumentMetadata().getOpenSource() == DocsOpenSource.vc) goto L10;
        boolean r4 = true;
    L11:
        r3.putBoolean("EnableExternalSelect", r4);
        r2.setArguments(r3);
        r0.i(this, r2);
        return;
    L10:
        r4 = false;
        goto L11
    L12:
        r0.i(this, r1);
        tt5.a.h("ToolbarV2", " use old fragment");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e4 getEditorAbility() {
        return (e4) getHost().getHostAbility(e4.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$new$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        tt5.a.h("ToolbarV2", "ensureToolbarFragment");
        ensureToolbarFragment();
        return;
    L5:
        tt5.a.h("ToolbarV2", "removeToolbarFragment");
        getUIContainer().d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        this.toolbarViewModel = getToolbarViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        this.toolbarViewModel.onDetachFromHost();
    }

    public final void updateToolbar(T r2) {
        BaseToolbarV2PanelViewModel<T> r0 = this.toolbarViewModel;
        if (r0 == null) goto L5;
        r0.updateToolbar(r2);
        return;
    L5:
        tt5.a.k("ToolbarV2", "updateToolbar, toolbarViewModel is null");
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r3, t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        pcb.a r5 = pcb.a.a.b(r3.getActivity());
        r5.c(this.toolbarViewModel);
        this.toolbarViewModel.onKeyboardHeightChanged(r5, r5.getVisibleKeyboardHeight(), getResources().getConfiguration().orientation);
        this.toolbarViewModel.getActive().observe(getLifecycleOwner(), this.activeObserver);
        this.toolbarViewModel.onAttachToUI(getActivity(), getWeb().getBridge());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        pcb.a.a.b(r1.getActivity()).a(this.toolbarViewModel);
        this.toolbarViewModel.onDetachFromUI();
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public <V> void callBackFunction(m r4, String r5, V r6, int r7) {
        if (r4 != null) goto L6;
        tt5.a.k("ToolbarV2", "callBackFunction == null");
        return;
    L6:
        JSONObject r1 = new JSONObject();
        r1.put("id", r5);
        r1.put("value", r6);
        r1.put("level", Integer.valueOf(r7));
        tt5.a.h("ToolbarV2", r1.toString());
        r4.b(r1);
    }
}
