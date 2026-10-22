package com.larus.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "K", "V", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.ContiguousPagedList$tryDispatchBoundaryCallbacks$1", f = "ContiguousPagedList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ContiguousPagedList$tryDispatchBoundaryCallbacks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $dispatchBegin;
    final /* synthetic */ boolean $dispatchEnd;
    int label;
    final /* synthetic */ k<Object, Object> this$0;

    public ContiguousPagedList$tryDispatchBoundaryCallbacks$1(k<Object, Object> r100, boolean r101, boolean r102, Continuation<? super ContiguousPagedList$tryDispatchBoundaryCallbacks$1> r103) {
        this.this$0 = r100;
        this.$dispatchBegin = r101;
        this.$dispatchEnd = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ContiguousPagedList$tryDispatchBoundaryCallbacks$1(this.this$0, this.$dispatchBegin, this.$dispatchEnd, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ContiguousPagedList$tryDispatchBoundaryCallbacks$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        k<Object, Object> r101 = this.this$0;
        boolean r102 = this.$dispatchBegin;
        boolean r103 = this.$dispatchEnd;
        int r104 = k.f363871f;
        r101.getClass();
        if (r102 == true) goto L11;
        if (r103 == false) goto L8;
        Intrinsics.checkNotNull(null);
        CollectionsKt.last(((PagingSource.b.c) CollectionsKt.last(r101.f363850b.f363856a)).f363729a);
        throw null;
    L8:
        return Unit.INSTANCE;
    L11:
        Intrinsics.checkNotNull(null);
        CollectionsKt.first(((PagingSource.b.c) CollectionsKt.first(r101.f363850b.f363856a)).f363729a);
        throw null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
