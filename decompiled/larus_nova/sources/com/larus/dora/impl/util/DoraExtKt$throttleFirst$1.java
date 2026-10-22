package com.larus.dora.impl.util;

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

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.util.DoraExtKt$throttleFirst$1", f = "DoraExt.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
final class DoraExtKt$throttleFirst$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_throttleFirst;
    final /* synthetic */ long $windowDuration;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f338106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f338107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FlowCollector<T> f338108c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Ref.LongRef r100, long r101, FlowCollector<? super T> r102) {
            this.f338106a = r100;
            this.f338107b = r101;
            this.f338108c = r102;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r100, Continuation<? super Unit> r110) {
            long r101 = System.currentTimeMillis();
            Ref.LongRef r102 = this.f338106a;
            if ((r101 - r102.element) < this.f338107b) goto L10;
            r102.element = r101;
            Object r103 = this.f338108c.emit(r100, r110);
            if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r103;
        L8:
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        }
    }

    public DoraExtKt$throttleFirst$1(Flow<Object> r100, long r101, Continuation<? super DoraExtKt$throttleFirst$1> r102) {
        this.$this_throttleFirst = r100;
        this.$windowDuration = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraExtKt$throttleFirst$1 r102 = new DoraExtKt$throttleFirst$1(this.$this_throttleFirst, this.$windowDuration, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<Object> r100, Continuation<? super Unit> r101) {
        return ((DoraExtKt$throttleFirst$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        Ref.LongRef r104 = new Ref.LongRef();
        Flow<Object> r105 = this.$this_throttleFirst;
        a r106 = new a(r104, this.$windowDuration, r103);
        this.label = 1;
        if (r105.collect(r106, this) != r101) goto L12;
        return r101;
    }
}
