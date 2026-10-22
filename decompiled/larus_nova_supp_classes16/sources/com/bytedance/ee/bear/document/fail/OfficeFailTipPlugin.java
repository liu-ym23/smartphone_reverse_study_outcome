package com.bytedance.ee.bear.document.fail;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import tb5.i;
import tb5.m;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeFailTipPlugin extends DocumentPluginV3 implements i<FailEventData> {
    private static final String TAG = "FailTipPlugin";

    @Override // tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeFailTipPlugin() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r2) {
        r2.put("biz.util.failEvent", this);
    }

    public void handle(FailEventData r4, m r5) {
        a.k(TAG, "fail" + r4);
        if (r4 == null) goto L8;
        x2 r6 = getDocumentLoader();
        if ((r6 instanceof DocumentLoaderV3) == false) goto L9;
        ((DocumentLoaderV3) r6).d(r4.result_code, new DocException(r4.result_code, "fail tips"), new HashMap());
        return;
    L9:
        return;
    }

    @Override // tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((FailEventData) r1, r2);
    }
}
