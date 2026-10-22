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
public final class FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f363658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f363659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f363660c;

    /* JADX INFO: renamed from: com.larus.paging.FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "emit"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.larus.paging.FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1", f = "FlowExt.kt", i = {0}, l = {133, 134}, m = "emit", n = {"this"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1 this$0;

        public AnonymousClass1(FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1 r100, Continuation r101) {
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
    L24:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r107 = (Ref.ObjectRef) r102.L$1;
        FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1 r108 = (FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1) r102.L$0;
        ResultKt.throwOnFailure(r104);
        T r109 = r104;
    L20:
        r107.element = r109;
        FlowCollector r110 = r108.f363660c;
        T r111 = r108.f363658a.element;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        if (r110.emit(r111, r102) != r105) goto L24;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        Ref.ObjectRef r112 = this.f363658a;
        Function3 r113 = this.f363659b;
        T r114 = r112.element;
        r102.L$0 = this;
        r102.L$1 = r112;
        r102.label = 1;
        InlineMarker.mark(6);
        Object r115 = r113.invoke(r114, r100, r102);
        InlineMarker.mark(7);
        if (r115 != r105) goto L19;
        return r105;
    L19:
        r108 = this;
        r109 = r115;
        r107 = r112;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }

    public FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1(Ref.ObjectRef r100, Function3 r101, FlowCollector r102) {
        this.f363658a = r100;
        this.f363659b = r101;
        this.f363660c = r102;
    }
}
