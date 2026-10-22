package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.shopping.sku.outer.business.cart.repo.SkuOuterAddToCartResponse;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T, R> implements Function {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r7) {
        SsResponse r8 = (SsResponse) r7;
        Intrinsics.checkNotNullParameter(r8, "ssResp");
        SkuOuterAddToCartResponse r0 = (SkuOuterAddToCartResponse) r8.body();
        Iterator<T> r9 = r8.headers().iterator();
    L3:
        String r2 = null;
        if (r9.hasNext() == false) goto L8;
        T r1 = r9.next();
        if (Intrinsics.areEqual(((Header) r1).getName(), "X-Tt-Logid".toLowerCase(Locale.getDefault())) == false) goto L3;
    L9:
        Header r3 = (Header) r1;
        if (r3 == null) goto L12;
        r2 = r3.getValue();
    L12:
        r0.setLogId(r2);
        return r0;
    L8:
        r1 = null;
        goto L9
    }
}
