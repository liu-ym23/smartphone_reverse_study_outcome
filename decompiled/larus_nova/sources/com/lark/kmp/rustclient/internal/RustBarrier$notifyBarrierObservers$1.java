package com.lark.kmp.rustclient.internal;

import java.lang.ref.WeakReference;
import java.util.Iterator;
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
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.RustBarrier$notifyBarrierObservers$1", f = "RustBarrier.kt", i = {0, 1, 1}, l = {109, 96}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "iterator"}, s = {"L$0", "L$0", "L$1"})
final class RustBarrier$notifyBarrierObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $currentState;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ RustBarrier this$0;

    public RustBarrier$notifyBarrierObservers$1(RustBarrier r100, boolean r101, Continuation<? super RustBarrier$notifyBarrierObservers$1> r102) {
        this.this$0 = r100;
        this.$currentState = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RustBarrier$notifyBarrierObservers$1(this.this$0, this.$currentState, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RustBarrier$notifyBarrierObservers$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L11;
        if (r102 != 2) goto L10;
        boolean r103 = this.Z$0;
        Iterator<WeakReference<com.lark.kmp.rustclient.barrier.b>> r104 = (Iterator) this.L$1;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L31
    L18:
        if (r104.hasNext() == false) goto L28;
        com.lark.kmp.rustclient.barrier.b r106 = r104.next().get();     // Catch: Throwable -> L31
        if (r106 != null) goto L21;
        r104.remove();     // Catch: Throwable -> L31
        goto L18
    L21:
        if (r103 == false) goto L23;
        boolean r107 = true;
    L24:
        this.L$0 = r105;     // Catch: Throwable -> L31
        this.L$1 = r104;     // Catch: Throwable -> L31
        this.Z$0 = r103;     // Catch: Throwable -> L31
        this.label = 2;     // Catch: Throwable -> L31
        if (r106.a(r107, this) != r101) goto L18;
        return r101;
    L23:
        r107 = false;
        goto L24
    L28:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L31
        r105.unlock(null);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r103 = this.Z$0;
        RustBarrier r109 = (RustBarrier) this.L$1;
        r105 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);
    L16:
        r104 = r109.f282513f.iterator();     // Catch: Throwable -> L31
        goto L18
    L12:
        ResultKt.throwOnFailure(r100);
        r109 = this.this$0;
        MutexImpl r110 = r109.f282512e;
        r103 = this.$currentState;
        this.L$0 = r110;
        this.L$1 = r109;
        this.Z$0 = r103;
        this.label = 1;
        if (r110.a(null, this) != r101) goto L15;
        return r101;
    L15:
        r105 = r110;
    L31:
        th = move-exception;
        r105.unlock(null);
        throw th;
    }
}
