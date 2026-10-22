package com.bytedance.android.shopping.feed;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h<T, R> implements Function {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object apply(Object r2) {
        CommerceBaseResponse r3 = (CommerceBaseResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r3, "$this$isResponseSuccess");
        if (r3.getStatusCode() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r3;
    L9:
        throw new IllegalStateException("report failed");
    L5:
        r0 = false;
        goto L6
    }
}
