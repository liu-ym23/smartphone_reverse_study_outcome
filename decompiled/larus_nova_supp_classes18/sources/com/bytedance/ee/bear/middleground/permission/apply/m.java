package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.contract.net.DefaultResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T, R> implements Function {
    public static final m<T, R> a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((DefaultResponse) r2, "it");
        return Boolean.TRUE;
    }
}
