package com.ss.android.ainote;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.ainote.AINoteImageDownloadCoordinator$startPendingDownloads$1$onSuccess$1", f = "AINoteImageDownloadCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AINoteImageDownloadCoordinator$startPendingDownloads$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AINoteImageDownloadCoordinator.b $listener;
    final /* synthetic */ String $localUri;
    final /* synthetic */ j.e $task;
    final /* synthetic */ Function0<List<j.e>> $taskProvider;
    int label;
    final /* synthetic */ AINoteImageDownloadCoordinator this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AINoteImageDownloadCoordinator$startPendingDownloads$1$onSuccess$1(AINoteImageDownloadCoordinator r100, j.e r101, AINoteImageDownloadCoordinator.b r102, String r103, Function0<? extends List<j.e>> r104, Continuation<? super AINoteImageDownloadCoordinator$startPendingDownloads$1$onSuccess$1> r105) {
        this.this$0 = r100;
        this.$task = r101;
        this.$localUri = r103;
        this.$taskProvider = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AINoteImageDownloadCoordinator$startPendingDownloads$1$onSuccess$1(this.this$0, this.$task, null, this.$localUri, this.$taskProvider, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AINoteImageDownloadCoordinator$startPendingDownloads$1$onSuccess$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        this.this$0.f406510b.remove(this.$task.a());
        j.e r101 = this.$task;
        long r102 = r101.f406806a;
        String r103 = r101.f406809d;
        boolean r104 = r101.f406811f;
        throw null;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
