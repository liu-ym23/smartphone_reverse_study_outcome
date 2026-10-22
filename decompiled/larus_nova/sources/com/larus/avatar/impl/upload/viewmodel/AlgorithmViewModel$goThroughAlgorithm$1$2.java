package com.larus.avatar.impl.upload.viewmodel;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.upload.viewmodel.AlgorithmViewModel$goThroughAlgorithm$1$2", f = "AlgorithmViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AlgorithmViewModel$goThroughAlgorithm$1$2 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<? extends Uri>, Unit> $asyncCallback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AlgorithmViewModel$goThroughAlgorithm$1$2(Function1<? super List<? extends Uri>, Unit> r100, Continuation<? super AlgorithmViewModel$goThroughAlgorithm$1$2> r101) {
        this.$asyncCallback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AlgorithmViewModel$goThroughAlgorithm$1$2 r102 = new AlgorithmViewModel$goThroughAlgorithm$1$2(this.$asyncCallback, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Throwable r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Throwable r100, Continuation<? super Unit> r101) {
        return ((AlgorithmViewModel$goThroughAlgorithm$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        ((Throwable) this.L$0).printStackTrace();
        Function1<List<? extends Uri>, Unit> r101 = this.$asyncCallback;
        if (r101 == null) goto L8;
        r101.invoke(CollectionsKt.emptyList());
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
