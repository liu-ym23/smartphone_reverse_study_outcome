package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
public final class PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1 implements FlowCollector<PageEvent<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f363707a;

    /* JADX INFO: renamed from: com.larus.paging.PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "emit"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.larus.paging.PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1", f = "PageFetcherSnapshot.kt", i = {}, l = {134}, m = "emit", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1 this$0;

        public AnonymousClass1(PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1 r100, Continuation r101) {
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

    public PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1(b1 r100) {
        this.f363707a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(PageEvent<Object> r100, Continuation r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: ClosedSendChannelException -> L21
    L22:
        goto L20
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        PageEvent<Object> r107 = r100;
        b1 r108 = this.f363707a;     // Catch: ClosedSendChannelException -> L21
        r102.label = 1;     // Catch: ClosedSendChannelException -> L21
        if (r108.send(r107, r102) != r105) goto L22;
        return r105;
    L20:
        return Unit.INSTANCE;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
