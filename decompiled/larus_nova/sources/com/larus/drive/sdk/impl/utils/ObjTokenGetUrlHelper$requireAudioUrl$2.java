package com.larus.drive.sdk.impl.utils;

import com.larus.bmhome.rc.GetVideoModelParam;
import com.larus.bmhome.rc.GetVideoModelRequest;
import com.larus.bmhome.rc.GetVideoModelResults;
import com.larus.bmhome.rc.ResourceApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/rc/GetVideoModelResults;", "Lcom/larus/bmhome/rc/ResourceApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper$requireAudioUrl$2", f = "ObjTokenGetUrlHelper.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
public final class ObjTokenGetUrlHelper$requireAudioUrl$2 extends SuspendLambda implements Function2<ResourceApi, Continuation<? super BizResponse<GetVideoModelResults>>, Object> {
    final /* synthetic */ String $objToken;
    private /* synthetic */ Object L$0;
    int label;

    public ObjTokenGetUrlHelper$requireAudioUrl$2(String r100, Continuation<? super ObjTokenGetUrlHelper$requireAudioUrl$2> r101) {
        this.$objToken = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObjTokenGetUrlHelper$requireAudioUrl$2 r102 = new ObjTokenGetUrlHelper$requireAudioUrl$2(this.$objToken, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ResourceApi r100, Continuation<? super BizResponse<GetVideoModelResults>> r101) {
        return ((ObjTokenGetUrlHelper$requireAudioUrl$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ResourceApi r100, Continuation<? super BizResponse<GetVideoModelResults>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ResourceApi r103 = (ResourceApi) this.L$0;
        GetVideoModelRequest r104 = new GetVideoModelRequest(CollectionsKt.listOf(new GetVideoModelParam(this.$objToken, null, 2, null)));
        this.label = 1;
        r100 = r103.getVideoModel(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
