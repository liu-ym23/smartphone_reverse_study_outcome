package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m0<T> implements Consumer {
    public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter a;

    public m0(ECWindowDialogStyledBackgroundPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Pair r4 = (Pair) r3;
        Bitmap r0 = (Bitmap) r4.component1();
        uq3.a r5 = (uq3.a) r4.component2();
        ECWindowDialogStyledBackgroundPresenter r1 = this.a;
        uq3.o r6 = r5.c;
        if (r6 == null) goto L5;
        String r7 = r6.i;
    L6:
        r1.getClass();
        Pair r8 = ECWindowDialogStyledBackgroundPresenter.b0(r7);
        ECWindowDialogStyledBackgroundPresenter.a0(this.a, r8, r0);
        return;
    L5:
        r7 = null;
        goto L6
    }
}
