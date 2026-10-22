package com.github.alexzhirkevich.customqrgenerator;

import android.graphics.Bitmap;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.QrCodeGeneratorImpl$drawCode$2", f = "QrCodeGeneratorImpl.kt", i = {0, 0, 0, 0, 0}, l = {93}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$invokeSuspend_u24lambda_u2d4", "array", "offsetX", "offsetY"}, s = {"L$0", "L$3", "L$4", "I$0", "I$1"})
final class QrCodeGeneratorImpl$drawCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $drawBg;
    final /* synthetic */ boolean $drawLogo;
    final /* synthetic */ e $options;
    final /* synthetic */ com.github.alexzhirkevich.customqrgenerator.encoder.d $result;
    final /* synthetic */ Bitmap $this_drawCode;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    final /* synthetic */ b this$0;

    public QrCodeGeneratorImpl$drawCode$2(b r100, com.github.alexzhirkevich.customqrgenerator.encoder.d r101, e r102, Bitmap r103, boolean r104, boolean r105, Continuation<? super QrCodeGeneratorImpl$drawCode$2> r106) {
        this.this$0 = r100;
        this.$result = r101;
        this.$options = r102;
        this.$this_drawCode = r103;
        this.$drawLogo = r104;
        this.$drawBg = r105;
        super(2, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        QrCodeGeneratorImpl$drawCode$2 r100 = new QrCodeGeneratorImpl$drawCode$2(this.this$0, this.$result, this.$options, this.$this_drawCode, this.$drawLogo, this.$drawBg, r111);
        r100.L$0 = r110;
        return r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((QrCodeGeneratorImpl$drawCode$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r100 = this.label;
        if (r100 != 0) goto L5;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        this.this$0.getClass();
        throw null;
    L5:
        if (r100 != 1) goto L13;
        boolean r101 = this.Z$0;
        int[] r102 = (int[]) this.L$4;
        com.github.alexzhirkevich.customqrgenerator.encoder.d r103 = (com.github.alexzhirkevich.customqrgenerator.encoder.d) this.L$3;
        Bitmap r104 = (Bitmap) this.L$2;
        e r105 = (e) this.L$1;
        CoroutineScope r106 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r110);
        if (r101 == true) goto L10;
        r104.setPixels(r102, 0, r104.getWidth(), 0, 0, r104.getWidth(), r104.getHeight());
        return Unit.INSTANCE;
    L10:
        r105.getClass();
        throw null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
