package com.larus.bmhome.bigimg.download;

import com.larus.bmhome.video.IVideoDownloadLoadingMgrService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.bigimg.download.CommonDownLoadLayout$onBindData$2", f = "CommonDownLoadLayout.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
public final class CommonDownLoadLayout$onBindData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d<?> $resourceData;
    int label;
    final /* synthetic */ CommonDownLoadLayout this$0;

    public CommonDownLoadLayout$onBindData$2(d<?> r100, CommonDownLoadLayout r101, Continuation<? super CommonDownLoadLayout$onBindData$2> r102) {
        this.$resourceData = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommonDownLoadLayout$onBindData$2(this.$resourceData, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommonDownLoadLayout$onBindData$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.bmhome.bigimg.download.b] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IVideoDownloadLoadingMgrService.f315168a.getClass();
        IVideoDownloadLoadingMgrService r103 = IVideoDownloadLoadingMgrService.a.f315170b.getValue();
        if (r103 == 0) goto L14;
        nr9.g r104 = ((d.c) this.$resourceData).f295974a;
        final CommonDownLoadLayout r105 = this.this$0;
        ?? r106 = new b(r105);
        this.label = 1;
        if (r103.a(r104, r106, this) != r101) goto L14;
        return r101;
    }
}
