package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentFinishLoadingPlugin extends DocumentPlugin implements tb5.i<Void> {
    @Override // tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dispatchFinishLoading() {
        DocumentPluginHost r0 = (DocumentPluginHost) getHost();
        if (r0 == null) goto L8;
        x2 r1 = r0.getDocumentLoader();
        if ((r1 instanceof y4) == false) goto L9;
        ((y4) r1).B();
        return;
    L9:
        return;
    }

    public DocumentFinishLoadingPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r2) {
        r2.put("biz.util.hideLoading", this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public void onDetachFromHost(DocumentPluginHost r1) {
        super.onDetachFromHost(r1);
    }

    @Override // tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, tb5.m r2) {
        handle((Void) r1, r2);
    }

    public void handle(Void r1, tb5.m r2) {
        dispatchFinishLoading();
    }
}
