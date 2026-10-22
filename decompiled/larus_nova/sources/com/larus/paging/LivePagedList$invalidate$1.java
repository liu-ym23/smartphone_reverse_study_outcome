package com.larus.paging;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.LivePagedList$invalidate$1", f = "LivePagedList.kt", i = {0, 1, 1}, l = {81, 89}, m = "invokeSuspend", n = {"pagingSource", "pagingSource", "lastKey"}, s = {"L$0", "L$0", "L$1"})
public final class LivePagedList$invalidate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LivePagedList<Key, Value> this$0;

    /* JADX INFO: renamed from: com.larus.paging.LivePagedList$invalidate$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.larus.paging.LivePagedList$invalidate$1$1", f = "LivePagedList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LivePagedList<Key, Value> this$0;

        public AnonymousClass1(LivePagedList<Key, Value> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            this.this$0.getClass();
            LoadType r101 = LoadType.REFRESH;
            u.b r102 = u.b.f363921b;
            throw null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LivePagedList$invalidate$1(LivePagedList<Key, Value> r100, Continuation<? super LivePagedList$invalidate$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LivePagedList$invalidate$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LivePagedList$invalidate$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        this.this$0.getClass();
        throw null;
    L5:
        if (r101 != 1) goto L7;
        PagingSource r102 = (PagingSource) this.L$0;
        ResultKt.throwOnFailure(r100);
        this.this$0.getClass();
        throw null;
    L7:
        if (r101 != 2) goto L27;
        PagingSource r103 = (PagingSource) this.L$0;
        ResultKt.throwOnFailure(r100);
        PagingSource.b r104 = (PagingSource.b) r100;
        if ((r104 instanceof PagingSource.b.C4455b) == false) goto L11;
        this.this$0.getClass();
        LoadType r105 = LoadType.REFRESH;
        throw null;
    L11:
        if ((r104 instanceof PagingSource.b.a) == false) goto L13;
        this.this$0.getClass();
        LoadType r106 = LoadType.REFRESH;
        Intrinsics.checkNotNullParameter(((PagingSource.b.a) r104).f363728a, "error");
        throw null;
    L13:
        if ((r104 instanceof PagingSource.b.c) == false) goto L21;
        int r107 = g0.f363848c;
        PagingSource.b.c r108 = (PagingSource.b.c) r104;
        LiveData r109 = this.this$0;
        int r110 = LivePagedList.f363662b;
        r109.getClass();
        this.this$0.getClass();
        this.this$0.getClass();
        this.this$0.getClass();
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r103, "pagingSource");
        Intrinsics.checkNotNullParameter(null, "coroutineScope");
        Intrinsics.checkNotNullParameter(null, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(null, "fetchDispatcher");
        Intrinsics.checkNotNullParameter(null, "config");
        if (r108 == null) goto L17;
        new k(r103, r108);
        throw null;
    L17:
        throw null;
    L21:
        return Unit.INSTANCE;
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
