package com.ss.android.lark.active.user.bridge;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l<T, R> f408573a = null;

    static {
        f408573a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "error");
        String r102 = r101.getMessage();
        if (r102 != null) goto L6;
        r102 = "user component not found";
    L6:
        return new a(10001, r102, r101);
    }
}
