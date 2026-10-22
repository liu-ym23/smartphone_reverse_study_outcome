package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes16.dex */
public class DocumentFinishLoadingPlugin extends DocumentPlugin implements tb5.i<Void> {
    @Override // tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dispatchFinishLoading() {
        DocumentPluginHost r100 = (DocumentPluginHost) getHost();
        if (r100 == null) goto L8;
        x2 r101 = r100.getDocumentLoader();
        if ((r101 instanceof y4) == false) goto L9;
        ((y4) r101).B();
        return;
    L9:
        return;
    }

    public DocumentFinishLoadingPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        r100.put(JsBridgeConstants.BIZ_UTIL_HIDELOADING, this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DocumentPluginHost) r100);
    }

    public void onDetachFromHost(DocumentPluginHost r100) {
        super.onDetachFromHost(r100);
    }

    @Override // tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r100, tb5.m r101) {
        handle((Void) r100, r101);
    }

    public void handle(Void r100, tb5.m r101) {
        dispatchFinishLoading();
    }
}
