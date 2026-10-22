package com.bytedance.ee.bear.middleground.permission.transfer.executor;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f234299a = null;

    static {
        f234299a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((SimpleRequestResult) r100, "it");
        return Boolean.TRUE;
    }
}
