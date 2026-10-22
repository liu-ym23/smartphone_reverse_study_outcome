package com.larus.camera.impl.ui.viewmodel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$3", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $imagePath;
    int label;

    public CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$3(String r100, Continuation<? super CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$3> r101) {
        this.$imagePath = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$3(this.$imagePath, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return ((CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$imagePath;
        if (r101 != null) goto L11;
        return null;
    L11:
        return BitmapFactory.decodeFile(r101);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
