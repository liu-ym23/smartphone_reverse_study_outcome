package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ AnchorV4VideoView a;

    public s(AnchorV4VideoView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Bitmap r3 = ((com.bytedance.android.shopping.anchorv4.voavhs.blur.c) r2).a;
        if (r3 == null) goto L6;
        AnchorV4VideoView.g(this.a, r3);
        return;
    }
}
