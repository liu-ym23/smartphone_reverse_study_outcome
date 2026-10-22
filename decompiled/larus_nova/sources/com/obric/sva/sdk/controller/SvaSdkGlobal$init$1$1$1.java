package com.obric.sva.sdk.controller;

import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.sva.sdk.controller.SvaSdkGlobal$init$1$1$1", f = "SvaSdkGlobal.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
public final class SvaSdkGlobal$init$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<Integer> $configDeferred;
    final /* synthetic */ Function1<String, Unit> $effectInitedTask;
    final /* synthetic */ String $tag;
    int label;

    /* JADX INFO: renamed from: com.obric.sva.sdk.controller.SvaSdkGlobal$init$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.sva.sdk.controller.SvaSdkGlobal$init$1$1$1$1", f = "SvaSdkGlobal.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ CompletableDeferred<Integer> $configDeferred;
        int label;

        public AnonymousClass1(CompletableDeferred<Integer> r100, Continuation<? super AnonymousClass1> r101) {
            this.$configDeferred = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$configDeferred, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Integer> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Integer> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            CompletableDeferred<Integer> r103 = this.$configDeferred;
            this.label = 1;
            r100 = r103.await(this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SvaSdkGlobal$init$1$1$1(Function1<? super String, Unit> r100, String r101, CompletableDeferred<Integer> r102, Continuation<? super SvaSdkGlobal$init$1$1$1> r103) {
        this.$effectInitedTask = r100;
        this.$tag = r101;
        this.$configDeferred = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SvaSdkGlobal$init$1$1$1(this.$effectInitedTask, this.$tag, this.$configDeferred, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SvaSdkGlobal$init$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        LogUtils.d(SvaSdkGlobal.TAG, "initEffectPlatformProvider wait done", new Object[0]);
        this.$effectInitedTask.invoke(this.$tag);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        LogUtils.d(SvaSdkGlobal.TAG, "initEffectPlatformProvider wait 5secs for the config inited", new Object[0]);
        AnonymousClass1 r103 = new AnonymousClass1(this.$configDeferred, null);
        this.label = 1;
        if (TimeoutKt.c(5000, r103, this) != r101) goto L11;
        return r101;
    }
}
