package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes29.dex */
public final class CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<IndexedValue<? extends PageEvent<Object>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f363639a;

    /* JADX INFO: renamed from: com.larus.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "emit"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.larus.paging.CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1", f = "CachedPageEventFlow.kt", i = {0, 0}, l = {133, 134}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1 this$0;

        public AnonymousClass1(CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1 r100, Continuation r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1(f r100) {
        this.f363639a = r100;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(IndexedValue<? extends PageEvent<Object>> r100, Continuation r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L24:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        IndexedValue<? extends PageEvent<Object>> r107 = (IndexedValue) r102.L$1;
        CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1 r108 = (CachedPageEventFlow$job$1$invokeSuspend$$inlined$collect$1) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        FlattenedPageController<T> r109 = r108.f363639a.f363830a;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        if (r109.b((IndexedValue<? extends PageEvent<T>>) r107, r102) != r105) goto L24;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        r107 = r100;
        MutableSharedFlow<IndexedValue<PageEvent<T>>> r110 = this.f363639a.f363831b;
        r102.L$0 = this;
        r102.L$1 = r107;
        r102.label = 1;
        if (r110.emit((IndexedValue<PageEvent<T>>) r107, r102) != r105) goto L19;
        return r105;
    L19:
        r108 = this;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
