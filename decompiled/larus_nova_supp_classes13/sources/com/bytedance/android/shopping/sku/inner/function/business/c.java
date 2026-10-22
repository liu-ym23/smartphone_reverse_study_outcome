package com.bytedance.android.shopping.sku.inner.function.business;

import android.net.Uri;
import com.bytedance.android.shopping.sku.inner.repo.SkuYataQueryFetcher;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public c(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Map r0 = r7.q();
        if (r0 == null) goto L5;
        Object r1 = r0.get("schema");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (com.bytedance.android.shopping.extensions.k.c(r2) == false) goto L22;
        Pair[] r3 = new Pair[2];
        SkuYataQueryFetcher r4 = this.a.qn().getQueryFetcher();
        if (r4 == null) goto L14;
        String r5 = r4.i;
    L15:
        r3[0] = TuplesKt.to("session_id", r5);
        r3[1] = TuplesKt.to("node_id", r7.d.c);
        String r8 = com.bytedance.android.ec.hybrid.list.util.k.d(MapsKt.mapOf(r3));
        if (r2 == null) goto L20;
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter("session_params", "key");
        Intrinsics.checkNotNullParameter(r8, "params");
        Uri.Builder r6 = UriProtector.parse(r2).buildUpon();
        r6.appendQueryParameter("session_params", r8);
        Uri r9 = r6.build();
        if (r9 == null) goto L20;
        String r10 = r9.toString();
    L21:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("final_schema", r10)), null, 5);
    L20:
        r10 = null;
        goto L21
    L14:
        r5 = null;
        goto L15
    L22:
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "schema is null", null, null, 57);
    L5:
        r1 = null;
        goto L7
    }
}
