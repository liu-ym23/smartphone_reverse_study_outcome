package com.larus.bmhome.upload.sdk;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.ResourceCenterTokenCredentialProvider", f = "ResourceUploadSdkIntegration.kt", i = {0, 0, 0, 0, 0}, l = {86}, m = "fetch", n = {"request", CloudControlInf.ROUTE, "originParam", "resourceType", "scene"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class ResourceCenterTokenCredentialProvider$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceCenterTokenCredentialProvider this$0;

    public ResourceCenterTokenCredentialProvider$fetch$1(ResourceCenterTokenCredentialProvider r100, Continuation<? super ResourceCenterTokenCredentialProvider$fetch$1> r101) {
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
