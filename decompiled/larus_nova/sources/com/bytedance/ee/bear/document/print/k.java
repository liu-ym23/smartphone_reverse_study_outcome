package com.bytedance.ee.bear.document.print;

import com.bytedance.ee.bear.more.PageViewResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T, R> f221189a = null;

    static {
        f221189a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        PageViewResult r101 = (PageViewResult) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        if (r101.commentsCount <= 0) goto L5;
        boolean r102 = true;
    L7:
        return Boolean.valueOf(r102);
    L5:
        r102 = false;
        goto L7
    }
}
