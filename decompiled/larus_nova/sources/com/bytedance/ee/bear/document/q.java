package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;

/* JADX INFO: loaded from: classes16.dex */
public final class q extends vv4.a {

    public static class a implements tb5.i<String> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            String r102 = (String) r100;
            int r103 = l35.k.f507257c;
            if (r103 <= 0) goto L5;
            l35.k.f507257c = r103 - 1;
        L5:
            tt5.a.h("CommonWebService", "Notify Clear done and sNeedClearDoneCount=" + l35.k.f507257c);
        }
    }

    public q() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(vv4.k r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind("biz.notify.clearDone", new a());
    }
}
