package com.bytedance.android.shopping.sku.common.data;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final List<String> a;
    public final Map<String, String> b;
    public final List<String> c;

    public b(List<String> r2, Map<String, String> r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "specItemIdList");
        Intrinsics.checkNotNullParameter(r3, "specItemIdToNameMap");
        Intrinsics.checkNotNullParameter(r4, "otherSpecSelectedItemIdList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
