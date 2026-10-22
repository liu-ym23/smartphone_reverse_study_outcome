package com.ss.android.lark.compose.groupqrcode.ui;

import android.graphics.Bitmap;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.ui.AndroidGroupQrCodePlatformHost$QrCodeImage$2$1", f = "AndroidGroupQrCodePlatformHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidGroupQrCodePlatformHost$QrCodeImage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Bitmap> $bitmap$delegate;
    final /* synthetic */ Function0<Unit> $onReady;
    int label;

    public AndroidGroupQrCodePlatformHost$QrCodeImage$2$1(Function0<Unit> r100, MutableState<Bitmap> r101, Continuation<? super AndroidGroupQrCodePlatformHost$QrCodeImage$2$1> r102) {
        this.$onReady = r100;
        this.$bitmap$delegate = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AndroidGroupQrCodePlatformHost$QrCodeImage$2$1(this.$onReady, this.$bitmap$delegate, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AndroidGroupQrCodePlatformHost$QrCodeImage$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        if (this.$bitmap$delegate.getValue() == null) goto L8;
        this.$onReady.invoke();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
