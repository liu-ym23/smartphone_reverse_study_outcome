package com.larus.audio.call.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.call.util.FlowExtKt$withPrevious$1", f = "FlowExt.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$withPrevious$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<Object, Object>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_withPrevious;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.audio.call.util.FlowExtKt$withPrevious$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowCollector<Pair<? extends T, ? extends T>> f289640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<T> f289641b;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(FlowCollector<? super Pair<? extends T, ? extends T>> r100, Ref.ObjectRef<T> r101) {
            this.f289640a = r100;
            this.f289641b = r101;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof FlowExtKt$withPrevious$1$1$emit$1) == false) goto L7;
            FlowExtKt$withPrevious$1$1$emit$1 r102 = (FlowExtKt$withPrevious$1$1$emit$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            r100 = (T) r102.L$0;
            ResultKt.throwOnFailure(r104);
        L17:
            T r107 = r100;
            this.f289641b.element = r107;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            FlowCollector<Pair<? extends T, ? extends T>> r108 = this.f289640a;
            Pair<? extends T, ? extends T> r109 = TuplesKt.to(this.f289641b.element, r100);
            r102.L$0 = r100;
            r102.label = 1;
            if (r108.emit(r109, r102) != r105) goto L17;
            return r105;
        L7:
            r102 = new FlowExtKt$withPrevious$1$1$emit$1(this, r101);
            goto L8
        }
    }

    public FlowExtKt$withPrevious$1(Flow<Object> r100, Continuation<? super FlowExtKt$withPrevious$1> r101) {
        this.$this_withPrevious = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowExtKt$withPrevious$1 r102 = new FlowExtKt$withPrevious$1(this.$this_withPrevious, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Pair<Object, Object>> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Pair<Object, Object>> r100, Continuation<? super Unit> r101) {
        return ((FlowExtKt$withPrevious$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FlowCollector r103 = (FlowCollector) this.L$0;
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        Flow<Object> r105 = this.$this_withPrevious;
        AnonymousClass1 r106 = new AnonymousClass1(r103, r104);
        this.label = 1;
        if (r105.collect(r106, this) != r101) goto L12;
        return r101;
    }
}
