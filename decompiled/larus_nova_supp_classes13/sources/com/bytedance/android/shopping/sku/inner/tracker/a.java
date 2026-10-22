package com.bytedance.android.shopping.sku.inner.tracker;

import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final String a;
    public final String b;
    public final PageFinder c;
    public final Map<String, String> d;

    public a(String r2, String r3, PageFinder r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
