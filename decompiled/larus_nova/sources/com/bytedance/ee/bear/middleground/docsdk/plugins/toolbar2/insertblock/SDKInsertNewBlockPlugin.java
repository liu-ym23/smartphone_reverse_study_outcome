package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar2.insertblock;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;
import com.bytedance.ee.bear.edit.component.toolbar2.insertblock.AbsInsertNewBlockPlugin;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import tb5.i;

/* JADX INFO: loaded from: classes18.dex */
public class SDKInsertNewBlockPlugin extends AbsInsertNewBlockPlugin<EditorSdkPluginHost> {
    private static final String TAG = "SDKInsertNewBlockPlugin";

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.insertblock.AbsInsertNewBlockPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public SDKInsertNewBlockPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.edit.component.toolbar2.insertblock.AbsInsertNewBlockPlugin
    public void bindBridgeHandler(String r100, i<InsertNewBlock> r101) {
        ((EditorSdkPluginHost) getHost()).getWeb().h(r100, r101);
    }
}
