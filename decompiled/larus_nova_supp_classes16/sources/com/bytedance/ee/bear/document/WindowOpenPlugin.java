package com.bytedance.ee.bear.document;

import android.webkit.WebChromeClient;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WindowOpenPlugin extends DocumentPlugin {
    private static final String TAG = "WindowOpenPlugin";
    private WebChromeClient webChromeClient;

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WindowOpenPlugin() {
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        if ((getWeb() instanceof z4) == false) goto L5;
        this.webChromeClient = new a2(((z4) getWeb()).getWebViewClient());
        tt5.a.b(TAG, "addWebChromeClientDelegate ");
        getWeb().addWebChromeClientDelegate(this.webChromeClient);
        return;
    L5:
        this.webChromeClient = null;
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        if (this.webChromeClient == null) goto L6;
        getWeb().removeWebChromeClientDelegate(this.webChromeClient);
        this.webChromeClient = null;
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
}
