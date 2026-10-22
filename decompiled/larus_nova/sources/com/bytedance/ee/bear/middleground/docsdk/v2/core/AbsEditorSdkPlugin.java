package com.bytedance.ee.bear.middleground.docsdk.v2.core;

import com.bytedance.ee.bear.browser.BaseWebPlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import java.util.Map;
import tb5.i;
import yv4.a;

/* JADX INFO: loaded from: classes18.dex */
public abstract class AbsEditorSdkPlugin extends BaseWebPlugin<EditorSdkPluginHost> implements a {
    public abstract /* synthetic */ void getBridgeHandlers(Map<String, i<?>> r100);

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public AbsEditorSdkPlugin() {
    }
}
