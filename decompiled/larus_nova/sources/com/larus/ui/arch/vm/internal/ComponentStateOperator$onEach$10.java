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
import kotlin.jvm.functions.Function6;

/* JADX INFO: Add missing generic type declarations: [A, B, C, D, E] */
/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u00062$\u0010\u0007\u001a \u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\bH\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "<destruct>", "Lcom/larus/ui/arch/vm/internal/Tuple5;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$onEach$10", f = "ComponentStateOperator.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$onEach$10<A, B, C, D, E> extends SuspendLambda implements Function2<s<A, B, C, D, E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function6<A, B, C, D, E, Continuation<? super Unit>, Object> $action;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$onEach$10(Function6<? super A, ? super B, ? super C, ? super D, ? super E, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super ComponentStateOperator$onEach$10> r101) {
        this.$action = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ComponentStateOperator$onEach$10 r102 = new ComponentStateOperator$onEach$10(this.$action, r101);
        r102.L$0 = r100;
        return r102;
    }

    public final Object invoke(s<A, B, C, D, E> r100, Continuation<? super Unit> r101) {
        return ((ComponentStateOperator$onEach$10) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
        return invoke((s) r100, r101);
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
        s r111 = (s) this.L$0;
        A r102 = r111.f375280a;
        B r103 = r111.f375281b;
        C r104 = r111.f375282c;
        D r105 = r111.f375283d;
        E r106 = r111.f375284e;
        Function6<A, B, C, D, E, Continuation<? super Unit>, Object> r107 = this.$action;
        this.label = 1;
        if (r107.invoke(r102, r103, r104, r105, r106, this) != r100) goto L12;
        return r100;
    }
}
