package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.loading.LoadingFailedPlugin;

/* JADX INFO: loaded from: classes18.dex */
public class WikiLoadFailProcessPlugin extends LoadingFailedPlugin {
    private static final String TAG = "WikiFailRetryPlugin";

    @Override // com.bytedance.ee.bear.document.loading.LoadingFailedPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public WikiLoadFailProcessPlugin() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.document.loading.LoadingFailedPlugin, com.bytedance.ee.bear.document.loading.LoadingLayout.c
    public void onFailedRetry(int r100) {
        if (r100 != 920004002) goto L5;
        return;
    L5:
        super.onFailedRetry(r100);
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
    }
}
