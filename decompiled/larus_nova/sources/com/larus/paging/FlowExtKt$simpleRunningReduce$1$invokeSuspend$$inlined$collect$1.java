package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
public final class FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f363655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f363656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f363657c;

    /* JADX INFO: renamed from: com.larus.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "emit"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.larus.paging.FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1", f = "FlowExt.kt", i = {0}, l = {137, 140}, m = "emit", n = {"this"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1 this$0;

        public AnonymousClass1(FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1 r100, Continuation r101) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
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
    L26:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r107 = (Ref.ObjectRef) r102.L$1;
        FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1 r108 = (FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1) r102.L$0;
        ResultKt.throwOnFailure(r104);
        Ref.ObjectRef r109 = r107;
        T r110 = r104;
    L22:
        r109.element = r110;
        FlowCollector r111 = r108.f363657c;
        T r112 = r108.f363655a.element;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        if (r111.emit(r112, r102) != r105) goto L26;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        r109 = this.f363655a;
        Object r113 = r109.element;
        Object r114 = r100;
        if (r113 != FlowExtKt.f363652a) goto L19;
    L18:
        r108 = this;
        r110 = r114;
        goto L22
    L19:
        Function3 r115 = this.f363656b;
        r102.L$0 = this;
        r102.L$1 = r109;
        r102.label = 1;
        InlineMarker.mark(6);
        Object r116 = r115.invoke(r113, r100, r102);
        InlineMarker.mark(7);
        r114 = r116;
        if (r116 != r105) goto L18;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }

    public FlowExtKt$simpleRunningReduce$1$invokeSuspend$$inlined$collect$1(Ref.ObjectRef r100, Function3 r101, FlowCollector r102) {
        this.f363655a = r100;
        this.f363656b = r101;
        this.f363657c = r102;
    }
}
