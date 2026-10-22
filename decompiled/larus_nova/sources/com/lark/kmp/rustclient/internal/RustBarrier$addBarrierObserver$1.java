package com.lark.kmp.rustclient.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.RustBarrier$addBarrierObserver$1", f = "RustBarrier.kt", i = {0, 1}, l = {109, 45}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class RustBarrier$addBarrierObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.lark.kmp.rustclient.barrier.b $observer;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RustBarrier this$0;

    public RustBarrier$addBarrierObserver$1(RustBarrier r100, com.lark.kmp.rustclient.barrier.b r101, Continuation<? super RustBarrier$addBarrierObserver$1> r102) {
        this.this$0 = r100;
        this.$observer = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RustBarrier$addBarrierObserver$1(this.this$0, this.$observer, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RustBarrier$addBarrierObserver$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L14;
        if (r102 == 1) goto L13;
        if (r102 != 2) goto L12;
        RustBarrier r103 = (RustBarrier) this.L$2;
        com.lark.kmp.rustclient.barrier.b r104 = (com.lark.kmp.rustclient.barrier.b) this.L$1;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L9
    L22:
        r103.f282513f.add(new WeakReference(r104));     // Catch: Throwable -> L9
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r105.unlock(null);
        return Unit.INSTANCE;
    L9:
        th = th;
        kotlinx.coroutines.sync.a r107 = r105;
    L27:
        r107.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        RustBarrier r108 = (RustBarrier) this.L$2;
        com.lark.kmp.rustclient.barrier.b r109 = (com.lark.kmp.rustclient.barrier.b) this.L$1;
        r107 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);
        RustBarrier r110 = r108;
        r104 = r109;
    L29:
        boolean r111 = r110.f282509b.c();     // Catch: Throwable -> L26
        this.L$0 = r107;     // Catch: Throwable -> L26
        this.L$1 = r104;     // Catch: Throwable -> L26
        this.L$2 = r110;     // Catch: Throwable -> L26
        this.label = 2;     // Catch: Throwable -> L26
        if (r104.a(r111, this) != r101) goto L21;
        return r101;
    L21:
        r103 = r110;
        r105 = r107;
    L26:
        th = th;
        goto L27
    L14:
        ResultKt.throwOnFailure(r100);
        r110 = this.this$0;
        MutexImpl r112 = r110.f282512e;
        com.lark.kmp.rustclient.barrier.b r113 = this.$observer;
        this.L$0 = r112;
        this.L$1 = r113;
        this.L$2 = r110;
        this.label = 1;
        if (r112.a(null, this) != r101) goto L17;
        return r101;
    L17:
        r107 = r112;
        r104 = r113;
        goto L29
    }
}
