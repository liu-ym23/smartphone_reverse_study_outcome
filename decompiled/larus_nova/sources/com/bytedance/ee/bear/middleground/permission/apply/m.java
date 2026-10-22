package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.contract.net.DefaultResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T, R> f233044a = null;

    static {
        f233044a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((DefaultResponse) r100, "it");
        return Boolean.TRUE;
    }
}
