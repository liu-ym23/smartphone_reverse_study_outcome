package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.k;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final List<Integer> a = null;

    static {
        a = CollectionsKt.listOf(new Integer[]{101, 201, 301});
    }

    public static boolean a(int r1, int r2, int r3) {
        cl.d r0 = k.a();
        if (r0 == null) goto L5;
        r0.b();
    L5:
        ECAppInfoService r4 = ECAppInfoService.e;
        r4.i();
        r4.i();
        if (r1 > 0) goto L8;
    L12:
        return false;
    L8:
        if (a.contains(Integer.valueOf(r2)) == false) goto L12;
        if (r3 != 1) goto L12;
        return true;
    }
}
