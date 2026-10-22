package com.larus.ui.arch.vm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;

/* JADX INFO: Add missing generic type declarations: [A, B, C, D] */
/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", "<destruct>", "Lcom/larus/ui/arch/vm/internal/Tuple4;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$onEach$8", f = "ComponentStateOperator.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$onEach$8<A, B, C, D> extends SuspendLambda implements Function2<r<A, B, C, D>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function5<A, B, C, D, Continuation<? super Unit>, Object> $action;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$onEach$8(Function5<? super A, ? super B, ? super C, ? super D, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super ComponentStateOperator$onEach$8> r101) {
        this.$action = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ComponentStateOperator$onEach$8 r102 = new ComponentStateOperator$onEach$8(this.$action, r101);
        r102.L$0 = r100;
        return r102;
    }

    public final Object invoke(r<A, B, C, D> r100, Continuation<? super Unit> r101) {
        return ((ComponentStateOperator$onEach$8) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
        return invoke((r) r100, r101);
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
        r r111 = (r) this.L$0;
        A r102 = r111.f375276a;
        B r103 = r111.f375277b;
        C r104 = r111.f375278c;
        D r105 = r111.f375279d;
        Function5<A, B, C, D, Continuation<? super Unit>, Object> r106 = this.$action;
        this.label = 1;
        if (r106.invoke(r102, r103, r104, r105, this) != r100) goto L12;
        return r100;
    }
}
