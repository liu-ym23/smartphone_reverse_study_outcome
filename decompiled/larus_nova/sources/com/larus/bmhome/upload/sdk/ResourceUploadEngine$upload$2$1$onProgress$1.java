package com.larus.bmhome.upload.sdk;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mr9.k;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.ResourceUploadEngine$upload$2$1$onProgress$1", f = "ResourceUploadSdkIntegration.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
public final class ResourceUploadEngine$upload$2$1$onProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onProgress;
    final /* synthetic */ k $result;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceUploadEngine$upload$2$1$onProgress$1(Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> r100, k r101, Continuation<? super ResourceUploadEngine$upload$2$1$onProgress$1> r102) {
        this.$onProgress = r100;
        this.$result = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ResourceUploadEngine$upload$2$1$onProgress$1(this.$onProgress, this.$result, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ResourceUploadEngine$upload$2$1$onProgress$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function2<Integer, Continuation<? super Unit>, Object> r103 = this.$onProgress;
        Long r104 = this.$result.f515020a;
        if (r104 == null) goto L11;
        long r105 = r104.longValue();
    L12:
        Integer r106 = Boxing.boxInt((int) r105);
        this.label = 1;
        if (r103.invoke(r106, this) != r101) goto L16;
        return r101;
    L11:
        r105 = 0;
        goto L12
    }
}
