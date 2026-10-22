package com.bytedance.ee.bear.drive.test.item;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T, R> implements Function {
    public static final a<T, R> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object apply(Object r2) {
        Result r3 = (Result) r2;
        Intrinsics.checkNotNullParameter(r3, "t");
        return (AuthCodeRequester.AuthCodeResult) r3.getData();
    }
}
