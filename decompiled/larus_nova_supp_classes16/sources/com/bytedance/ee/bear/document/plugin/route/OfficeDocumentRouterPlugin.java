package com.bytedance.ee.bear.document.plugin.route;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentWebClientPriority;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import i35.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeDocumentRouterPlugin extends DocumentPluginV3 {
    private static final String TAG = "DocumentRouterPlugin";
    private static final boolean TEST = false;
    private boolean clearHistoryWhenNavigate;

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeDocumentRouterPlugin(boolean r1) {
        this.clearHistoryWhenNavigate = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r5) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r5);
        if (r5 == null) goto L5;
        boolean r0 = c.a.a.g("ccm.mobile.android_doc_support_expand_page");
    L6:
        getWeb().addWebViewClientDelegate(new a(r5, this.clearHistoryWhenNavigate, r0), DocumentWebClientPriority.Router.ordinal());
        return;
    L5:
        r0 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
