package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar2.insertblock;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;
import com.bytedance.ee.bear.edit.component.toolbar2.insertblock.AbsInsertNewBlockPlugin;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import tb5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SDKInsertNewBlockPlugin extends AbsInsertNewBlockPlugin<EditorSdkPluginHost> {
    private static final String TAG = "SDKInsertNewBlockPlugin";

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SDKInsertNewBlockPlugin() {
    }

    public void bindBridgeHandler(String r2, i<InsertNewBlock> r3) {
        getHost().getWeb().h(r2, r3);
    }
}
