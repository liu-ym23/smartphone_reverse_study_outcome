package com.bytedance.ee.bear.document.route;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentWebClientPriority;
import r35.e;
import wo5.b;
import wo5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentRouterPlugin extends DocumentPlugin {
    private static final String TAG = "DocumentRouterPlugin";
    private static final boolean TEST = false;
    private boolean clearHistoryWhenNavigate;

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocumentRouterPlugin(boolean r1) {
        this.clearHistoryWhenNavigate = r1;
    }

    public void onAttachToHost(DocumentPluginHost r5) {
        super.onAttachToHost(r5);
        if (r5 == null) goto L5;
        boolean r0 = d.a(new b(r5.getUserComponent()), "ccm.mobile.android_doc_support_expand_page");
    L6:
        getWeb().addWebViewClientDelegate(new e(r5, this.clearHistoryWhenNavigate, r0), DocumentWebClientPriority.Router.ordinal());
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }
}
