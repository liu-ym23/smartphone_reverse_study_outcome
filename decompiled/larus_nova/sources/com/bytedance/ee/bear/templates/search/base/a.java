package com.bytedance.ee.bear.templates.search.base;

import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T, R> f239384a = null;

    static {
        f239384a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        Throwable r100 = (Throwable) r110;
        Intrinsics.checkNotNullParameter(r100, "it");
        return new TemplateGroupTab(2, new ArrayList(), false, false, null, r100, null, 0, false, 476, null);
    }
}
