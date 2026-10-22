package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q extends vv4.a {

    public static class a implements tb5.i<String> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            String r3 = (String) r1;
            int r4 = l35.k.c;
            if (r4 <= 0) goto L5;
            l35.k.c = r4 - 1;
        L5:
            tt5.a.h("CommonWebService", "Notify Clear done and sNeedClearDoneCount=" + l35.k.c);
        }
    }

    public q() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(vv4.k r2) {
        super.onAttachToWeb(r2);
        bindBridgeHandlerAutoUnbind("biz.notify.clearDone", new a());
    }
}
