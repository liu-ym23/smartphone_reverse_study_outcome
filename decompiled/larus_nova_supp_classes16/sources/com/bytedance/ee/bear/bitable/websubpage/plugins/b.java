package com.bytedance.ee.bear.bitable.websubpage.plugins;

import com.bytedance.ee.bear.contract.x;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r2) {
        x r3 = (x) r2;
        Intrinsics.checkNotNullParameter(r3, "hostService");
        r3.r();
        return "";
    }
}
