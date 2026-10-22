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
@DebugMetadata(c = "com.ss.android.ainote.AINoteImageUploadCoordinator$startPendingUploads$1$onSuccess$1", f = "AINoteImageUploadCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AINoteImageUploadCoordinator$startPendingUploads$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $draftStore;
    final /* synthetic */ AINoteImageUploadCoordinator.c $listener;
    final /* synthetic */ String $remoteKey;
    final /* synthetic */ j.f $task;
    final /* synthetic */ Function0<List<j.f>> $taskProvider;
    final /* synthetic */ String $uploadToken;
    int label;
    final /* synthetic */ AINoteImageUploadCoordinator this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AINoteImageUploadCoordinator$startPendingUploads$1$onSuccess$1(AINoteImageUploadCoordinator r100, j.f r101, AINoteImageUploadCoordinator.c r102, String r103, String r104, Function0<? extends List<j.f>> r105, j r106, Continuation<? super AINoteImageUploadCoordinator$startPendingUploads$1$onSuccess$1> r107) {
        this.this$0 = r100;
        this.$task = r101;
        this.$listener = r102;
        this.$uploadToken = r103;
        this.$remoteKey = r104;
        this.$taskProvider = r105;
        this.$draftStore = r106;
        super(2, r107);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new AINoteImageUploadCoordinator$startPendingUploads$1$onSuccess$1(this.this$0, this.$task, this.$listener, this.$uploadToken, this.$remoteKey, this.$taskProvider, this.$draftStore, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AINoteImageUploadCoordinator$startPendingUploads$1$onSuccess$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        this.this$0.f406512b.remove(this.$task.f406817d);
        if (this.this$0.f406513c.remove(this.$task.f406817d) == true) goto L7;
        AINoteImageUploadCoordinator.c r101 = this.$listener;
        j.f r102 = this.$task;
        r101.b(r102.f406814a, r102.f406817d, this.$uploadToken, this.$remoteKey);
        this.this$0.b(this.$taskProvider, this.$draftStore, this.$listener);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
