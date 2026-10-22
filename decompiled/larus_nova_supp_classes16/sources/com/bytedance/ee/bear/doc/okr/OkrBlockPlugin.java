package com.bytedance.ee.bear.doc.okr;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolBarV2Type;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import g45.a;
import javax.annotation.Nullable;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OkrBlockPlugin extends DocumentPlugin implements c0<OkrToolbar> {
    private static final String TAG = "OkrBlockPlugin";

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public <V> void onToolbarItemClick(ItemIdV2 r1, V r2, int r3) {
    }

    public OkrViewModel getOkrViewModel() {
        return (OkrViewModel) viewModel(OkrViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public int getType() {
        return ToolBarV2Type.OKR.getValue();
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public a getEditPanel() {
        return getOkrViewModel();
    }

    public OkrBlockPlugin() {
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        OkrViewModel r0 = getOkrViewModel();
        r4.b().registerEditPanel(r4.getLifecycleOwner(), r0);
        pcb.a.a.b(r4.getActivity()).c(r0);
        BaseDocToolbarV2JsHandlerPlugin r5 = (BaseDocToolbarV2JsHandlerPlugin) findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r5 == null) goto L6;
        r5.registerHandler(this);
        return;
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        pcb.a.a.b(r2.getActivity()).a(getOkrViewModel());
        BaseDocToolbarV2JsHandlerPlugin r3 = (BaseDocToolbarV2JsHandlerPlugin) findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r3 == null) goto L6;
        r3.unRegisterHandler(this);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public void handle(OkrToolbar r2, m r3) {
        tt5.a.h(TAG, "OkrBlockPlugin data " + r2);
        OkrViewModel r4 = getOkrViewModel();
        if (r2 == null) goto L5;
        boolean r5 = true;
    L6:
        r4.setActive(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0, tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((OkrToolbar) r1, r2);
    }
}
