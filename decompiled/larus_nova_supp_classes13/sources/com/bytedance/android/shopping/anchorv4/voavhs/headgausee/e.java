package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ HeadGaussItemView a;
    public final /* synthetic */ Function1 b;

    public e(HeadGaussItemView r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r2) {
        com.bytedance.android.shopping.anchorv4.voavhs.blur.c r3 = (com.bytedance.android.shopping.anchorv4.voavhs.blur.c) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        Bitmap r4 = r3.a;
        if (r4 == null) goto L9;
        Bitmap r5 = HeadGaussItemView.a(this.a, r4);
        if (r5 == null) goto L11;
        Function1 r0 = this.b;
        if (r0 == null) goto L11;
        Unit r1 = (Unit) r0.invoke(r5);
    L11:
        return new com.bytedance.android.shopping.anchorv4.voavhs.blur.c(r5);
    L9:
        r5 = null;
        goto L11
    }
}
