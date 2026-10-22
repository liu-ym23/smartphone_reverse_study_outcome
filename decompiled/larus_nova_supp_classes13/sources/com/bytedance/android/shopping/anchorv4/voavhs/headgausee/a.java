package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T, R> implements Function {
    public final /* synthetic */ HeadGaussItemView a;

    public a(HeadGaussItemView r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Bitmap r3 = (Bitmap) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return HeadGaussItemView.a(this.a, r3);
    }
}
