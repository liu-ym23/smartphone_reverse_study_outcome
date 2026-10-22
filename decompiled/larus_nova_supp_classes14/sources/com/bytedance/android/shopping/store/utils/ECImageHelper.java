package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECImageHelper {
    public static final Lazy a = null;

    public ECImageHelper() {
    }

    static {
        a = LazyKt.lazy(ECImageHelper$imageCallerContext$2.INSTANCE);
    }

    public static void a(SimpleDraweeView r8, ECUrlModel r9) {
        Intrinsics.checkNotNullParameter(r8, "draweeView");
        h0.d(r8, r9, (com.bytedance.android.ec.core.imagex.r) a.getValue(), null, null, null, null, 96);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(ECDraweeView r8, ECUrlModel r9) {
        Intrinsics.checkNotNullParameter(r8, "draweeView");
        if (r9 != null) goto L5;
    L9:
        h0.d(r8, r9, (com.bytedance.android.ec.core.imagex.r) a.getValue(), null, null, null, null, 96);
        return;
    L5:
        if (r9.getHeight() <= 0) goto L9;
        if (r9.getWidth() <= 0) goto L9;
        wg.a.i(r8, o.a(Integer.valueOf(r9.getWidth())));
        wg.a.d(r8, o.a(Integer.valueOf(r9.getHeight())));
        goto L9
    }
}
