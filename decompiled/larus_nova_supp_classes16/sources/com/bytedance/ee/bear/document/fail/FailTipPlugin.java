package com.bytedance.ee.bear.document.fail;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y4;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import javax.annotation.Nullable;
import tb5.i;
import tb5.m;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FailTipPlugin extends DocumentPlugin implements i<FailEventData> {
    private static final String TAG = "FailTipPlugin";

    @Override // tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public FailTipPlugin() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r2) {
        r2.put("biz.util.failEvent", this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handle(FailEventData r2, m r3) {
        a.k(TAG, "fail" + r2);
        if (r2 == null) goto L8;
        x2 r4 = ((DocumentPluginHost) getHost()).getDocumentLoader();
        if ((r4 instanceof y4) == false) goto L9;
        ((y4) r4).c(r2.result_code, null);
        return;
    L9:
        return;
    }

    @Override // tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((FailEventData) r1, r2);
    }
}
