package com.larus.im.internal.core.message.utils.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.utils.sync.AbsMessageSyncLooper$stop$2", f = "AbsMessageSyncLooper.kt", i = {}, l = {60, 62}, m = "invokeSuspend", n = {}, s = {})
final class AbsMessageSyncLooper$stop$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $status;
    int label;
    final /* synthetic */ c this$0;

    public AbsMessageSyncLooper$stop$2(c r100, Integer r101, Continuation<? super AbsMessageSyncLooper$stop$2> r102) {
        this.this$0 = r100;
        this.$status = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AbsMessageSyncLooper$stop$2(this.this$0, this.$status, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AbsMessageSyncLooper$stop$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L18:
        c r103 = this.this$0;
        Job r104 = r103.f347902c;
        if (r104 == null) goto L21;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L21:
        r103.f347902c = null;
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        Integer r105 = this.$status;
        if (r105 == null) goto L18;
        c r106 = this.this$0;
        int r107 = r105.intValue();
        this.label = 2;
        if (r106.g(r107, this) != r101) goto L18;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        c r108 = this.this$0;
        this.label = 1;
        if (r108.f(this) != r101) goto L13;
        return r101;
    }
}
