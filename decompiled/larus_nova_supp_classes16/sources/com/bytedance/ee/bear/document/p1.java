package com.bytedance.ee.bear.document;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p1 implements tb5.i<String> {
    public final /* synthetic */ DocBridgeWebViewV2 a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public p1(DocBridgeWebViewV2 r1) {
        this.a = r1;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r1, tb5.m r2) {
        Boolean r3 = (Boolean) JSON.parseObject((String) r1, Boolean.class);
        DocBridgeWebViewV2 r4 = this.a;
        if (r3 != null) goto L5;
        boolean r5 = false;
    L6:
        r4.T1 = r5;
        return;
    L5:
        r5 = r3.booleanValue();
        goto L6
    }
}
