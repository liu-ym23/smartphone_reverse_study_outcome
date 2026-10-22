package com.larus.avatar.impl.upload.viewmodel;

import android.graphics.Bitmap;
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

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.upload.viewmodel.AlgorithmViewModel$goThroughAlgorithm$1$1", f = "AlgorithmViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AlgorithmViewModel$goThroughAlgorithm$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<? extends Uri>, Unit> $asyncCallback;
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ List<Uri> $uris;
    int label;
    final /* synthetic */ AlgorithmViewModel this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AlgorithmViewModel$goThroughAlgorithm$1$1(AlgorithmViewModel r100, List<? extends Uri> r101, Bitmap r102, Function1<? super List<? extends Uri>, Unit> r103, Continuation<? super AlgorithmViewModel$goThroughAlgorithm$1$1> r104) {
        this.this$0 = r100;
        this.$uris = r101;
        this.$bitmap = r102;
        this.$asyncCallback = r103;
        super(1, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new AlgorithmViewModel$goThroughAlgorithm$1$1(this.this$0, this.$uris, this.$bitmap, this.$asyncCallback, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((AlgorithmViewModel$goThroughAlgorithm$1$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        AlgorithmViewModel.access$innerGoThroughAlgorithm(this.this$0, this.$uris, this.$bitmap);
        Function1<List<? extends Uri>, Unit> r101 = this.$asyncCallback;
        if (r101 == null) goto L11;
        List<Uri> r102 = this.$uris;
        if (r102 != null) goto L9;
        r102 = CollectionsKt.emptyList();
    L9:
        r101.invoke(r102);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
