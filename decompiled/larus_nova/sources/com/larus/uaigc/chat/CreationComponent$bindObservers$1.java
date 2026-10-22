package com.larus.uaigc.chat;

import com.larus.bmhome.chat.component.list.u7;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.chat.CreationComponent$bindObservers$1", f = "CreationComponent.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
final class CreationComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.chat.CreationComponent$bindObservers$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationComponent f370374a;

        public AnonymousClass1(CreationComponent r100) {
            this.f370374a = r100;
        }

        public final Object a(Pair<Boolean, Integer> r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof CreationComponent$bindObservers$1$1$emit$1) == false) goto L7;
            CreationComponent$bindObservers$1$1$emit$1 r102 = (CreationComponent$bindObservers$1$1$emit$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L18;
            if (r106 == 1) goto L17;
            if (r106 == 2) goto L16;
            if (r106 != 3) goto L15;
            ResultKt.throwOnFailure(r104);
        L34:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r104);
        L29:
            return Unit.INSTANCE;
        L17:
            ResultKt.throwOnFailure(r104);
        L25:
            CreationComponent r107 = this.f370374a;
            int r108 = CreationComponent.f370366n;
            CreationVideoManagerViewModel r109 = ((CreationViewModel) r107.f370368i.getValue()).getVideoManagerViewModel();
            r102.label = 2;
            if (r109.f(r102) != r105) goto L29;
            return r105;
        L18:
            ResultKt.throwOnFailure(r104);
            if (r100.getSecond().intValue() != 0) goto L36;
            if (r100.getFirst().booleanValue() == false) goto L30;
            r102.label = 1;
            if (DelayKt.delay(50, r102) != r105) goto L25;
            return r105;
        L30:
            CreationComponent r110 = this.f370374a;
            int r111 = CreationComponent.f370366n;
            CreationVideoManagerViewModel r112 = ((CreationViewModel) r110.f370368i.getValue()).getVideoManagerViewModel();
            r102.label = 3;
            if (r112.f(r102) != r105) goto L34;
            return r105;
        L36:
            return Unit.INSTANCE;
        L7:
            r102 = new CreationComponent$bindObservers$1$1$emit$1(this, r101);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((Pair) r100, r101);
        }
    }

    public CreationComponent$bindObservers$1(CreationComponent r100, Continuation<? super CreationComponent$bindObservers$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CreationComponent$bindObservers$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CreationComponent$bindObservers$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CreationComponent r103 = this.this$0;
        int r104 = CreationComponent.f370366n;
        u7 r105 = (u7) r103.f370369j.getValue();
        if (r105 == null) goto L18;
        MutableSharedFlow r106 = r105.m30();
        if (r106 == null) goto L18;
        AnonymousClass1 r107 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r106.collect(r107, this) != r101) goto L16;
        return r101;
    L18:
        return Unit.INSTANCE;
    }
}
