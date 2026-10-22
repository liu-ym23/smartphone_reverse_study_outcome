package com.ss.android.lark.endpoint.security.detection.location;

import com.ss.android.lark.location.dto.LarkLocation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.endpoint.security.detection.location.IEndpointLocationClient$DefaultImpls", f = "IEndpointLocationClient.kt", i = {}, l = {60}, m = "getCurrentLocationDetailed-IoAF18A", n = {}, s = {})
final class IEndpointLocationClient$getCurrentLocationDetailed$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public IEndpointLocationClient$getCurrentLocationDetailed$1(Continuation<? super IEndpointLocationClient$getCurrentLocationDetailed$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        IEndpointLocationClient$getCurrentLocationDetailed$1 r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L20;
        if (r104 != 1) goto L19;
        ResultKt.throwOnFailure(r103);
        LarkLocation r105 = (LarkLocation) r103;
        if (r105 == null) goto L12;
        Object r106 = Result.m9449constructorimpl(r105);
    L14:
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r106;
    L17:
        return Result.m9448boximpl(r106);
    L12:
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(EndpointLocationFetchError.Unknown.INSTANCE));
        goto L14
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r103);
        r102.label = 1;
        throw null;
    L5:
        r102 = new IEndpointLocationClient$getCurrentLocationDetailed$1(this);
        goto L6
    }
}
