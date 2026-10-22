package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public q(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mall.getCardType";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r3, IBDXBridgeContext r4, Map<String, ? extends Object> r5, Map<String, Object> r6) {
        Intrinsics.checkNotNullParameter(r3, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "result");
        Object r7 = r5.get("sectionID");
        Integer r1 = null;
        if ((r7 instanceof String) == true) goto L5;
        r7 = null;
    L5:
        String r8 = (String) r7;
        Object r9 = r5.get("itemID");
        if ((r9 instanceof String) == true) goto L8;
        r9 = null;
    L8:
        String r10 = (String) r9;
        if (r10 == null) goto L11;
        ECHybridListEngine r11 = r3.b.J;
        if (r11 == null) goto L17;
        BaseViewHolder r12 = r11.e(r8, r10);
        if (r12 == null) goto L17;
        r1 = Integer.valueOf(r12.getItemViewType());
    L17:
        r6.put("cardType", r1);
        return qf3.e.f(this);
    L11:
        return qf3.e.c("itemID is nil.");
    }
}
