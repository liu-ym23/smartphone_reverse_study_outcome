package com.bytedance.ee.bear.bitable.websubpage.plugins;

import com.bytedance.ee.bear.contract.x;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f216301a = null;

    static {
        f216301a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        return (x) org.koin.java.a.c(x.class, null, null, 6);
    }
}
