package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import io.reactivex.functions.Function;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x<T, R> implements Function {
    public static final x a = null;

    static {
        a = new x();
    }

    public x() {
    }

    public final Object apply(Object r4) {
        File r5 = (File) r4;
        Intrinsics.checkNotNullParameter(r5, "file");
        w r0 = new w(r5);
        String r1 = vi2.h.a;
        String r2 = vi2.h.d(si2.g.z);
        return vi2.h.e(null, null, r2, new vi2.r(r5, r2, r0));
    }
}
