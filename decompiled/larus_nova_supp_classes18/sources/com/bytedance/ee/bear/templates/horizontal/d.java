package com.bytedance.ee.bear.templates.horizontal;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T, R> implements Function {
    public static final d<T, R> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r5) {
        Throwable r6 = (Throwable) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        return new HorizontalTemplates(1, new ArrayList(), r6, false);
    }
}
