package com.bytedance.android.shopping.sku.common.data;

import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static h a(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        int r0 = t0.a;
        return (h) GsonProtectorUtils.fromJson(t0.a.a, k.b(r2).toString(), h.class);
    }
}
