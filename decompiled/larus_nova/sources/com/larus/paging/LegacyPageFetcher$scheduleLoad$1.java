package com.larus.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "K", "V", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.LegacyPageFetcher$scheduleLoad$1", f = "LegacyPageFetcher.kt", i = {0}, l = {53}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class LegacyPageFetcher$scheduleLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagingSource.a<Object> $params;
    final /* synthetic */ LoadType $type;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ t<Object, Object> this$0;

    /* JADX INFO: renamed from: com.larus.paging.LegacyPageFetcher$scheduleLoad$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "K", "V", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.larus.paging.LegacyPageFetcher$scheduleLoad$1$1", f = "LegacyPageFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadType $type;
        final /* synthetic */ PagingSource.b<Object, Object> $value;
        int label;
        final /* synthetic */ t<Object, Object> this$0;

        public AnonymousClass1(PagingSource.b<Object, Object> r100, t<Object, Object> r101, LoadType r102, Continuation<? super AnonymousClass1> r103) {
            this.$value = r100;
            this.this$0 = r101;
            this.$type = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$value, this.this$0, this.$type, r101);
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
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r100);
            PagingSource.b<Object, Object> r101 = this.$value;
            if ((r101 instanceof PagingSource.b.c) == false) goto L7;
            PagingSource.b.c r102 = (PagingSource.b.c) r101;
            throw null;
        L7:
            if ((r101 instanceof PagingSource.b.a) == false) goto L9;
            Throwable r103 = ((PagingSource.b.a) r101).f363728a;
            throw null;
        L9:
            if ((r101 instanceof PagingSource.b.C4455b) == false) goto L11;
            throw null;
        L11:
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LegacyPageFetcher$scheduleLoad$1(t<Object, Object> r100, PagingSource.a<Object> r101, LoadType r102, Continuation<? super LegacyPageFetcher$scheduleLoad$1> r103) {
        this.this$0 = r100;
        this.$params = r101;
        this.$type = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        LegacyPageFetcher$scheduleLoad$1 r102 = new LegacyPageFetcher$scheduleLoad$1(this.this$0, this.$params, this.$type, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LegacyPageFetcher$scheduleLoad$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r102 = (CoroutineScope) this.L$0;
        throw null;
    L5:
        if (r101 != 1) goto L7;
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);
        PagingSource.b r104 = (PagingSource.b) r100;
        throw null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
