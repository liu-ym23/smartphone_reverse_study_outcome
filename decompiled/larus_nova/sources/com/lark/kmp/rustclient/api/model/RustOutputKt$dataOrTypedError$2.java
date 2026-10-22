package com.lark.kmp.rustclient.api.model;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "", "RAW", "DATA", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/lark/kmp/rustclient/api/model/RustOutput;", "cause", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.lark.kmp.rustclient.api.model.RustOutputKt$dataOrTypedError$2", f = "RustOutput.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RustOutputKt$dataOrTypedError$2 extends SuspendLambda implements Function3<FlowCollector<? super g<Object, Object>>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Throwable, Unit> $onOtherError;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RustOutputKt$dataOrTypedError$2(Function1<? super Throwable, Unit> r100, Continuation<? super RustOutputKt$dataOrTypedError$2> r101) {
        this.$onOtherError = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super g<Object, Object>> r100, Throwable r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super g<Object, Object>> r100, Throwable r101, Continuation<? super Unit> r102) {
        RustOutputKt$dataOrTypedError$2 r103 = new RustOutputKt$dataOrTypedError$2(this.$onOtherError, r102);
        r103.L$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        Throwable r101 = (Throwable) this.L$0;
        this.$onOtherError.invoke(r101);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
