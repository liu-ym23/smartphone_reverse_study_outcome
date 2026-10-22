package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
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
        Result r3 = (Result) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return ((ImportResult) r3.data).getResult();
    }
}
