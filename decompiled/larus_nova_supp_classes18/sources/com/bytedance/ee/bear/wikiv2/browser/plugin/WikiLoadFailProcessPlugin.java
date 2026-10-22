package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.loading.LoadingFailedPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiLoadFailProcessPlugin extends LoadingFailedPlugin {
    private static final String TAG = "WikiFailRetryPlugin";

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiLoadFailProcessPlugin() {
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onFailedRetry(int r2) {
        if (r2 != 920004002) goto L5;
        return;
    L5:
        super.onFailedRetry(r2);
    }

    public void onAttachToHost(DocumentPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
    }
}
