package com.bytedance.ee.bear.document.plugin.upload;

import com.bytedance.ee.bear.document.offline.file.upload.CancelUploadModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements tb5.i<CancelUploadModel> {
    public d() {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r3, final tb5.m r4) {
        final CancelUploadModel r5 = (CancelUploadModel) r3;
        Flowable.just(r5.getFileUrl()).observeOn(fo5.d.c()).map(new a(r5)).observeOn(fo5.d.d()).subscribe(new b(r4), new c(r4));
    }
}
