package com.bytedance.ee.bear.templates.search.base;

import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T, R> implements Function {
    public static final a<T, R> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object apply(Object r13) {
        Throwable r6 = (Throwable) r13;
        Intrinsics.checkNotNullParameter(r6, "it");
        return new TemplateGroupTab(2, new ArrayList(), false, false, null, r6, null, 0, false, 476, null);
    }
}
