package com.bytedance.ee.bear.templates.recommend;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T, R> f239267a = null;

    static {
        f239267a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return new RecommendTemplates(2, new ArrayList(), r101);
    }
}
