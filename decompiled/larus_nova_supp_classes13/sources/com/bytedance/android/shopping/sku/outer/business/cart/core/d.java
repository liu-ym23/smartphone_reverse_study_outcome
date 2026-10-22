package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T, R> implements Function {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r7) {
        SsResponse r8 = (SsResponse) r7;
        Intrinsics.checkNotNullParameter(r8, "ssResp");
        String r0 = (String) r8.body();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        r0 = "{}";
    L11:
        th3.c r2 = new th3.c(new JSONObject(r0));
        Iterator<T> r9 = r8.headers().iterator();
    L12:
        String r3 = null;
        if (r9.hasNext() == false) goto L17;
        T r4 = r9.next();
        if (Intrinsics.areEqual(((Header) r4).getName(), "X-Tt-Logid".toLowerCase(Locale.getDefault())) == false) goto L12;
    L18:
        Header r5 = (Header) r4;
        if (r5 == null) goto L21;
        r3 = r5.getValue();
    L21:
        r2.d = r3;
        return r2;
    L17:
        r4 = null;
        goto L18
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
