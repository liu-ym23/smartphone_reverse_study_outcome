package com.larus.bot.impl.common.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.FlowExtKt$throttleFirst$1", f = "FlowExt.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$throttleFirst$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $intervalMs;
    final /* synthetic */ Flow<Object> $this_throttleFirst;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bot.impl.common.util.FlowExtKt$throttleFirst$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f317667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f317668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f317669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FlowCollector<T> f317670d;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.LongRef r100, long r101, Ref.BooleanRef r102, FlowCollector<? super T> r103) {
            this.f317667a = r100;
            this.f317668b = r101;
            this.f317669c = r102;
            this.f317670d = r103;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r110, Continuation<? super Unit> r111) {
            if ((r111 instanceof FlowExtKt$throttleFirst$1$1$emit$1) == false) goto L7;
            FlowExtKt$throttleFirst$1$1$emit$1 r100 = (FlowExtKt$throttleFirst$1$1$emit$1) r111;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r112 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            if (r103 == 0) goto L14;
            if (r103 != 1) goto L13;
            ResultKt.throwOnFailure(r112);
        L22:
            this.f317669c.element = true;
        L24:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r112);
            long r104 = System.currentTimeMillis();
            Ref.LongRef r113 = this.f317667a;
            long r105 = r113.element;
            long r106 = r104 - r105;
            long r107 = this.f317668b;
            if (r106 < r107) goto L18;
            r113.element = r105 + ((r106 / r107) * r107);
            this.f317669c.element = false;
        L18:
            if (this.f317669c.element == true) goto L24;
            FlowCollector<T> r114 = this.f317670d;
            r100.label = 1;
            if (r114.emit(r110, r100) != r102) goto L22;
            return r102;
        L7:
            r100 = new FlowExtKt$throttleFirst$1$1$emit$1(this, r111);
            goto L8
        }
    }

    public FlowExtKt$throttleFirst$1(Flow<Object> r100, long r101, Continuation<? super FlowExtKt$throttleFirst$1> r102) {
        this.$this_throttleFirst = r100;
        this.$intervalMs = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowExtKt$throttleFirst$1 r102 = new FlowExtKt$throttleFirst$1(this.$this_throttleFirst, this.$intervalMs, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<Object> r100, Continuation<? super Unit> r101) {
        return ((FlowExtKt$throttleFirst$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        FlowCollector r102 = (FlowCollector) this.L$0;
        Ref.LongRef r103 = new Ref.LongRef();
        r103.element = System.currentTimeMillis();
        Ref.BooleanRef r104 = new Ref.BooleanRef();
        Flow<Object> r111 = this.$this_throttleFirst;
        AnonymousClass1 r105 = new AnonymousClass1(r103, this.$intervalMs, r104, r102);
        this.label = 1;
        if (r111.collect(r105, this) != r100) goto L12;
        return r100;
    }
}
