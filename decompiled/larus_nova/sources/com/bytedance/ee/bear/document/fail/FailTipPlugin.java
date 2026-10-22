package com.bytedance.ee.bear.document.fail;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y4;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.document.plugins.fail.FailEventPlugin;
import java.util.Map;
import javax.annotation.Nullable;
import tb5.i;
import tb5.m;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class FailTipPlugin extends DocumentPlugin implements i<FailEventData> {
    private static final String TAG = "FailTipPlugin";

    @Override // tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public FailTipPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        r100.put(FailEventPlugin.BIZ_FAIL_EVENT, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handle(FailEventData r100, m r101) {
        a.k(TAG, "fail" + r100);
        if (r100 == null) goto L8;
        x2 r102 = ((DocumentPluginHost) getHost()).getDocumentLoader();
        if ((r102 instanceof y4) == false) goto L9;
        ((y4) r102).c(r100.result_code, null);
        return;
    L9:
        return;
    }

    @Override // tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r100, m r101) {
        handle((FailEventData) r100, r101);
    }
}
