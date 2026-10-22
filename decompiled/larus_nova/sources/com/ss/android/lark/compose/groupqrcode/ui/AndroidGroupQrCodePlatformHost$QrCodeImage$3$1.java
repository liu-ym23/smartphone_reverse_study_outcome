package com.ss.android.lark.compose.groupqrcode.ui;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.ui.AndroidGroupQrCodePlatformHost$QrCodeImage$3$1", f = "AndroidGroupQrCodePlatformHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidGroupQrCodePlatformHost$QrCodeImage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Throwable> $error$delegate;
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidGroupQrCodePlatformHost$QrCodeImage$3$1(Function1<? super Throwable, Unit> r100, MutableState<Throwable> r101, Continuation<? super AndroidGroupQrCodePlatformHost$QrCodeImage$3$1> r102) {
        this.$onError = r100;
        this.$error$delegate = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AndroidGroupQrCodePlatformHost$QrCodeImage$3$1(this.$onError, this.$error$delegate, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AndroidGroupQrCodePlatformHost$QrCodeImage$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        Throwable r101 = this.$error$delegate.getValue();
        if (r101 == null) goto L8;
        this.$onError.invoke(r101);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
