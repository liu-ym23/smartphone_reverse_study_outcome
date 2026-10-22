package com.github.alexzhirkevich.customqrgenerator;

import android.graphics.Bitmap;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/Bitmap;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.QrCodeGeneratorImpl$generateQrCodeSuspend$2", f = "QrCodeGeneratorImpl.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
final class QrCodeGeneratorImpl$generateQrCodeSuspend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Charset $charset;
    final /* synthetic */ c $data;
    final /* synthetic */ e $options;
    int label;
    final /* synthetic */ b this$0;

    public QrCodeGeneratorImpl$generateQrCodeSuspend$2(b r100, c r101, e r102, Charset r103, Continuation<? super QrCodeGeneratorImpl$generateQrCodeSuspend$2> r104) {
        this.this$0 = r100;
        this.$data = r101;
        this.$options = r102;
        this.$charset = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new QrCodeGeneratorImpl$generateQrCodeSuspend$2(this.this$0, this.$data, this.$options, this.$charset, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return ((QrCodeGeneratorImpl$generateQrCodeSuspend$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl((Bitmap) r100);     // Catch: Throwable -> L15
    L17:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L21;
        return r103;
    L21:
        if ((r104 instanceof CancellationException) == false) goto L24;
        throw r104;
    L24:
        throw new QrCodeCreationException(r104, null, 2, null);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        b r105 = this.this$0;
        e r106 = this.$options;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r100 = b.a(r105, r106, this);     // Catch: Throwable -> L15
        if (r100 != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
