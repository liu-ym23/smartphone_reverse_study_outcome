package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f223047a = null;

    static {
        f223047a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Result r101 = (Result) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return ((ImportResult) r101.data).getResult();
    }
}
