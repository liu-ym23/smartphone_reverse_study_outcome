package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ HeadGaussItemView a;

    public f(HeadGaussItemView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Bitmap r3 = ((com.bytedance.android.shopping.anchorv4.voavhs.blur.c) r2).a;
        if (r3 == null) goto L6;
        this.a.setImageBitmap(r3);
        return;
    }
}
