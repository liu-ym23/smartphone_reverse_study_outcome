package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ HeadGaussItemView a;
    public final /* synthetic */ Function1 b;

    public b(HeadGaussItemView r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Bitmap r3 = (Bitmap) r2;
        if (r3 == null) goto L8;
        this.a.setImageBitmap(r3);
        Function1 r0 = this.b;
        if (r0 == null) goto L9;
        Unit r4 = (Unit) r0.invoke(r3);
        return;
    L9:
        return;
    }
}
