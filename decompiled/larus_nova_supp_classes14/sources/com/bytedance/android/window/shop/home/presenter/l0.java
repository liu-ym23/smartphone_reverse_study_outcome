package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Bitmap;
import androidx.core.graphics.ColorUtils;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l0<T1, T2, R> implements BiFunction {
    public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter a;

    public l0(ECWindowDialogStyledBackgroundPresenter r1) {
        this.a = r1;
    }

    public final Object apply(Object r8, Object r9) {
        uq3.a r10 = (uq3.a) r8;
        int[] r11 = (int[]) r9;
        Intrinsics.checkNotNullParameter(r10, "headerResponse");
        Intrinsics.checkNotNullParameter(r11, "lastLineColors");
        this.a.getClass();
        uq3.o r0 = r10.c;
        if (r0 == null) goto L5;
        String r1 = r0.i;
    L6:
        Pair r2 = ECWindowDialogStyledBackgroundPresenter.b0(r1);
        int r3 = r11.length;
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r4 >= r3) goto L10;
        r11[r5] = ColorUtils.compositeColors(r11[r4], ((Number) r2.getSecond()).intValue());
        r4 = r4 + 1;
        r5 = r5 + 1;
        goto L7
    L10:
        return TuplesKt.to(Bitmap.createBitmap(r11, r11.length, 1, Bitmap.Config.ARGB_8888), r10);
    L5:
        r1 = null;
        goto L6
    }
}
