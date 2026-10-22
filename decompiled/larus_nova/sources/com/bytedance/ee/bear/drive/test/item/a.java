package com.bytedance.ee.bear.drive.test.item;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f224667a = null;

    static {
        f224667a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Result r101 = (Result) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        return (AuthCodeRequester.AuthCodeResult) r101.getData();
    }
}
