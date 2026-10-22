package com.bytedance.android.shopping.store.aggregate.datasource;

import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.p;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.shopping.extensions.k;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final List<StoreV2ProductItemVO> a(StoreV2ProductListResponseVO r2, jm.a<List<q>> r3, jm.a<List<r>> r4, jm.a<String> r5, jm.a<p> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "response");
        p r0 = null;
        if (r3 == null) goto L5;
        List r1 = (List) r3.getValue();
    L6:
        if (r1 != null) goto L9;
        if (r3 == null) goto L9;
        r3.c(r2.getGoodTypes());
    L9:
        if (r4 == null) goto L11;
        List r8 = (List) r4.getValue();
    L12:
        if (r8 != null) goto L16;
        if (r4 == null) goto L16;
        r4.c(r2.getSortTypes());
    L16:
        if (k.c(r2.getMaterialTitle()) == false) goto L23;
        if (r5 == null) goto L19;
        String r9 = (String) r5.getValue();
    L20:
        if (r9 != null) goto L23;
        if (r5 == null) goto L23;
        r5.c(r2.getMaterialTitle());
        goto L23
    L19:
        r9 = null;
    L23:
        if (r6 == null) goto L25;
        r0 = (p) r6.getValue();
    L25:
        if (r0 != null) goto L32;
        if (r7 == false) goto L28;
    L29:
        if (r6 == null) goto L32;
        r6.c(r2.getCartsInfo());
        goto L32
    L28:
        if (r2.getCartsInfo() != null) goto L29;
    L32:
        return CollectionsKt.toMutableList(r2.getProducts());
    L11:
        r8 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
