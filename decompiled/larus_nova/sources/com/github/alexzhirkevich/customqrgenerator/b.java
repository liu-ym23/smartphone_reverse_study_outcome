package com.github.alexzhirkevich.customqrgenerator;

import android.graphics.Bitmap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static final Object a(b r110, e r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof QrCodeGeneratorImpl$createQrCodeInternal$1) == false) goto L7;
        QrCodeGeneratorImpl$createQrCodeInternal$1 r100 = (QrCodeGeneratorImpl$createQrCodeInternal$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 != 0) goto L11;
        ResultKt.throwOnFailure(r113);
        r111.getClass();
        throw null;
    L11:
        if (r102 == 1) goto L16;
        if (r102 != 2) goto L15;
        Bitmap r115 = (Bitmap) r100.L$0;
        ResultKt.throwOnFailure(r113);
        return r115;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        e r103 = (e) r100.L$1;
        b r104 = (b) r100.L$0;
        ResultKt.throwOnFailure(r113);
        com.github.alexzhirkevich.customqrgenerator.encoder.d r105 = (com.github.alexzhirkevich.customqrgenerator.encoder.d) r113;
        r103.getClass();
        r103.getClass();
        Bitmap r116 = Bitmap.createBitmap(0, 0, Bitmap.Config.ARGB_8888);
        r100.L$0 = r116;
        r100.L$1 = null;
        r100.label = 2;
        r104.getClass();
        Object r117 = CoroutineScopeKt.coroutineScope(new QrCodeGeneratorImpl$drawCode$2(r104, r105, r103, r116, true, true, null), r100);
        if (r117 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        r117 = Unit.INSTANCE;
    L20:
        if (r117 != r114) goto L23;
        return r114;
    L23:
        return r116;
    L7:
        r100 = new QrCodeGeneratorImpl$createQrCodeInternal$1(r110, r112);
        goto L8
    }
}
