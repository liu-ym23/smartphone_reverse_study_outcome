package com.bytedance.applog.params.extract;

import android.content.Context;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final List<String> c = null;
    public final ParamsExtractDao a;
    public final b b;

    public static final class a {
    }

    static {
        c = CollectionsKt.listOf("ParamsExtractManager");
    }

    public e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Context r4 = r3.getApplicationContext();
        this.a = new ParamsExtractDao(r4, new d(r4));
        this.b = new b();
    }
}
