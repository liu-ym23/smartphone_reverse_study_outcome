package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1", f = "SimpleChannelFlow.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<b1<T>, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Channel<T> $channel;
    int label;

    /* JADX INFO: renamed from: com.larus.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.larus.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1$1", f = "SimpleChannelFlow.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<b1<T>, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Channel<T> $channel;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Channel<T> r100, Function2<? super b1<T>, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super AnonymousClass1> r102) {
            this.$channel = r100;
            this.$block = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.$channel, this.$block, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.larus.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1$1 for r4v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r4.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            kotlin.ResultKt.throwOnFailure(r5);
        L11:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE;
            return r5;
        L6:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r5;
        L8:
            kotlin.ResultKt.throwOnFailure(r5);
            java.lang.Object r5 = r4.L$0;
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5;
            kotlinx.coroutines.channels.Channel<T> r3 = r4.$channel;
            com.larus.paging.SimpleProducerScopeImpl r1 = new com.larus.paging.SimpleProducerScopeImpl(r5, r3);
            kotlin.jvm.functions.Function2<com.larus.paging.b1<T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r5 = r4.$block;
            r4.label = 1;
            com.larus.paging.SimpleProducerScopeImpl r1 = r1;
            java.lang.Object r4 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4;
            java.lang.Object r5 = r5.invoke(r1, r4);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1(Channel<T> r100, Function2<? super b1<T>, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1> r102) {
        this.$channel = r100;
        this.$block = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1(this.$channel, this.$block, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        SendChannel.a.a(this.$channel);     // Catch: Throwable -> L15
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        AnonymousClass1 r103 = new AnonymousClass1(this.$channel, this.$block, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (CoroutineScopeKt.coroutineScope(r103, this) != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        this.$channel.close(th);
        goto L18
    }
}
