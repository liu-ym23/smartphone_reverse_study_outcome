package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.utility.Logger;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public u(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.feedProductIds";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r4, IBDXBridgeContext r5, Map<String, ? extends Object> r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r4, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "result");
        if (r4.b.A1.isAttached() == false) goto L5;
        Logger.d("puffone-initListEngine()", "getProductIds");
        ECHybridListEngine r8 = r4.b.J;
        com.bytedance.android.ec.hybrid.list.entity.i r9 = null;
        Object r10 = null;
        r9 = null;
        r9 = null;
        if (r8 == null) goto L19;
        com.bytedance.android.ec.hybrid.list.entity.k r11 = r8.c.g;
        if (r11 == null) goto L19;
        ArrayList r12 = r11.c;
        if (r12 == null) goto L19;
        Iterator r13 = r12.iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r14).a, "favorite_section") == false) goto L14;
        r10 = r14;
    L18:
        r9 = (com.bytedance.android.ec.hybrid.list.entity.i) r10;
    L19:
        ArrayList r15 = new ArrayList();
        if (r9 == null) goto L33;
        ArrayList r16 = r9.i;
        if (r16 == null) goto L33;
        Iterator r17 = r16.iterator();
    L25:
        if (r17.hasNext() == false) goto L33;
        ECHybridListItemVO r18 = (ECHybridListItemVO) r17.next();
        com.bytedance.android.ec.hybrid.list.entity.n r0 = r18.o;
        if (r0 == null) goto L25;
        HashMap r1 = r0.b;
        if (r1 == null) goto L25;
        if (r1.containsKey(PdpOpenThirdParam.KEY_PRODUCT_ID) != true) goto L25;
        com.bytedance.android.ec.hybrid.list.entity.n r19 = r18.o;
        Intrinsics.checkNotNull(r19);
        HashMap r20 = r19.b;
        Intrinsics.checkNotNull(r20);
        r15.add((String) r20.get(PdpOpenThirdParam.KEY_PRODUCT_ID));
    L33:
        r7.put("ids", r15);
        return qf3.e.f(this);
    L5:
        return qf3.e.c("container is not attached");
    }
}
