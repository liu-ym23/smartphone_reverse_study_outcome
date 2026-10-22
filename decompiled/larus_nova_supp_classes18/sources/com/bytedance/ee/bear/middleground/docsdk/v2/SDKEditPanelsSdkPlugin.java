package com.bytedance.ee.bear.middleground.docsdk.v2;

import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import java.util.Map;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SDKEditPanelsSdkPlugin extends AbsEditorSdkPlugin {
    private static final String TAG = "EditPanelsSdkPlugin";
    private EditPanelsManager panelsSdkViewModel;

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public void getBridgeHandlers(Map<String, i<?>> r1) {
    }

    @Override // com.bytedance.ee.bear.middleground.docsdk.v2.core.AbsEditorSdkPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SDKEditPanelsSdkPlugin() {
    }

    public void onAttachToHost(EditorSdkPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        EditPanelsManager r0 = r2.a;
        this.panelsSdkViewModel = r0;
        r0.attachBridge(r2.getWeb().getBridge());
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((EditorSdkPluginHost) r1);
    }

    public void onAttachToUIContainer(EditorSdkPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        this.panelsSdkViewModel.setContentView(getWeb().getWebView());
        pcb.a.a.b(r2.getActivity()).c(this.panelsSdkViewModel);
        tt5.a.b(TAG, "onAttachToUIContainer " + this.panelsSdkViewModel.hashCode());
    }

    public void onDetachFromUIContainer(EditorSdkPluginHost r2, t r3) {
        super.onDetachFromUIContainer(r2, r3);
        pcb.a.a.b(r2.getActivity()).a(this.panelsSdkViewModel);
        this.panelsSdkViewModel.detachBridge(r2.getWeb().getBridge());
        tt5.a.b(TAG, "onDetachFromUIContainer " + this.panelsSdkViewModel.hashCode());
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
