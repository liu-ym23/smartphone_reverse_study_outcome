package com.bytedance.ee.bear.document.toolbar2.insertblock;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;
import com.bytedance.ee.bear.edit.component.toolbar2.insertblock.AbsInsertNewBlockPlugin;
import tb5.i;
import vv4.b;

/* JADX INFO: loaded from: classes16.dex */
public class InsertNewBlockPlugin extends AbsInsertNewBlockPlugin<PluginHost> {
    @Override // com.bytedance.ee.bear.edit.component.toolbar2.insertblock.AbsInsertNewBlockPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public InsertNewBlockPlugin() {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.insertblock.AbsInsertNewBlockPlugin
    public void bindBridgeHandler(String r100, i<InsertNewBlock> r101) {
        ((b) getHostAbility(b.class)).getBridge().c(r100, r101);
    }
}
