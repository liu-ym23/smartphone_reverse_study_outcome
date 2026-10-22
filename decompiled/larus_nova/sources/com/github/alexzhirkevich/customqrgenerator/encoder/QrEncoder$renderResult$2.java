package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.google.zxing.qrcode.encoder.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/d;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$renderResult$2", f = "QrEncoder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class QrEncoder$renderResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
    final /* synthetic */ f $code;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ b this$0;

    public QrEncoder$renderResult$2(f r100, b r101, Continuation<? super QrEncoder$renderResult$2> r102) {
        this.$code = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        QrEncoder$renderResult$2 r102 = new QrEncoder$renderResult$2(this.$code, this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super d> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super d> r101) {
        return ((QrEncoder$renderResult$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        com.google.zxing.qrcode.encoder.b r102 = this.$code.f276010e;
        if (r102 == null) goto L9;
        c.a(r102);
        this.this$0.getClass();
        throw null;
    L9:
        throw new IllegalStateException();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
