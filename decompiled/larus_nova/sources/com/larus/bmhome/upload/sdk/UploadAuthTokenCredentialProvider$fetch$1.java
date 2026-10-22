package com.larus.bmhome.upload.sdk;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.UploadAuthTokenCredentialProvider", f = "ResourceUploadSdkIntegration.kt", i = {0, 0, 0}, l = {155}, m = "fetch", n = {"request", CloudControlInf.ROUTE, "originParam"}, s = {"L$0", "L$1", "L$2"})
public final class UploadAuthTokenCredentialProvider$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadAuthTokenCredentialProvider this$0;

    public UploadAuthTokenCredentialProvider$fetch$1(UploadAuthTokenCredentialProvider r100, Continuation<? super UploadAuthTokenCredentialProvider$fetch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
