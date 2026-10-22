package com.github.alexzhirkevich.customqrgenerator.encoder;

import java.nio.charset.Charset;
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
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoder$encode$2", f = "QrEncoder.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
final class QrEncoder$encode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
    final /* synthetic */ Charset $charset;
    final /* synthetic */ com.github.alexzhirkevich.customqrgenerator.c $contents;
    int label;
    final /* synthetic */ b this$0;

    public QrEncoder$encode$2(com.github.alexzhirkevich.customqrgenerator.c r100, b r101, Charset r102, Continuation<? super QrEncoder$encode$2> r103) {
        this.$contents = r100;
        this.this$0 = r101;
        this.$charset = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new QrEncoder$encode$2(this.$contents, this.this$0, this.$charset, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super d> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super d> r101) {
        return ((QrEncoder$encode$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        boolean r102 = true;
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L8;
        ResultKt.throwOnFailure(r100);
        return r100;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        if (this.$contents.encode().length() > 0) goto L13;
        r102 = false;
    L13:
        if (r102 == false) goto L17;
        this.this$0.getClass();
        throw null;
    L17:
        throw new IllegalArgumentException("Found empty contents".toString());
    }
}
