package com.larus.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
@DebugMetadata(c = "com.larus.paging.PageFetcherSnapshotState$Holder", f = "PageFetcherSnapshotState.kt", i = {0, 0, 0}, l = {403}, m = "withLock", n = {"this", "block", "$this$withLock$iv"}, s = {"L$0", "L$1", "L$2"})
final class PageFetcherSnapshotState$Holder$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e0.a<Object, Object> this$0;

    public PageFetcherSnapshotState$Holder$withLock$1(e0.a<Object, Object> r100, Continuation<? super PageFetcherSnapshotState$Holder$withLock$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        e0.a<Object, Object> r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        PageFetcherSnapshotState$Holder$withLock$1<T> r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r103.L$2;
        Function1 r108 = (Function1) r103.L$1;
        e0.a<Object, Object> r109 = (e0.a) r103.L$0;
        ResultKt.throwOnFailure(r104);
        kotlinx.coroutines.sync.a r110 = r107;
        r101 = r109;
    L22:
        r105 = r108.invoke(r101.f363828b);     // Catch: Throwable -> L19
        InlineMarker.finallyStart(1);
        r110.unlock(null);
        InlineMarker.finallyEnd(1);
    L18:
        return r105;
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r110.unlock(null);
        InlineMarker.finallyEnd(1);
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        r110 = r101.f363827a;
        r103.L$0 = r101;
        r103.L$1 = null;
        r103.L$2 = r110;
        r103.label = 1;
        if (r110.a(null, r103) == r105) goto L18;
        r108 = null;
        goto L22
    L5:
        r103 = new PageFetcherSnapshotState$Holder$withLock$1(r101, this);
        goto L6
    }
}
