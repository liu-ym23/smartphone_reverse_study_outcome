package com.bytedance.ee.bear.bitable.websubpage.plugins;

import com.bytedance.ee.bear.contract.x;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f216302a = null;

    static {
        f216302a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        x r101 = (x) r100;
        Intrinsics.checkNotNullParameter(r101, "hostService");
        r101.r();
        return "";
    }
}
