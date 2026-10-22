package com.bytedance.android.shopping.sku.common.controller.uplink;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final List<String> a;
    public final List<c> b;

    public a(List<String> r2, List<c> r3) {
        Intrinsics.checkNotNullParameter(r2, "globalSkipTriggers");
        Intrinsics.checkNotNullParameter(r3, "moduleSkipTriggers");
        this.a = r2;
        this.b = r3;
    }
}
