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

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "asyncValue", "Lcom/larus/ui/arch/vm/external/Async;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$onAsync$1", f = "ComponentStateOperator.kt", i = {}, l = {121, 123}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$onAsync$1<T> extends SuspendLambda implements Function2<w1a.a<? extends T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Throwable, Continuation<? super Unit>, Object> $onFail;
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $onSuccess;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$onAsync$1(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r100, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super ComponentStateOperator$onAsync$1> r102) {
        this.$onSuccess = r100;
        this.$onFail = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ComponentStateOperator$onAsync$1 r102 = new ComponentStateOperator$onAsync$1(this.$onSuccess, this.$onFail, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
        return invoke((w1a.a) r100, r101);
    }

    public final Object invoke(w1a.a<? extends T> r100, Continuation<? super Unit> r101) {
        return ((ComponentStateOperator$onAsync$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L25:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r100);
        w1a.a r103 = (w1a.a) this.L$0;
        Function2<T, Continuation<? super Unit>, Object> r104 = this.$onSuccess;
        if (r104 != null) goto L13;
    L17:
        Function2<Throwable, Continuation<? super Unit>, Object> r105 = this.$onFail;
        if (r105 == null) goto L25;
        if ((r103 instanceof w1a.e) == false) goto L25;
        ((w1a.e) r103).getClass();
        this.label = 2;
        if (r105.invoke(null, this) != r101) goto L25;
        return r101;
    L13:
        if ((r103 instanceof w1a.g) == false) goto L17;
        ((w1a.g) r103).getClass();
        this.label = 1;
        if (r104.invoke(null, this) != r101) goto L25;
        return r101;
    }
}
