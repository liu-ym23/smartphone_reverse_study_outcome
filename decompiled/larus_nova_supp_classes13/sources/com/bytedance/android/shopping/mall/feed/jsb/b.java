package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public b(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.bffDataUpdate";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        if (r2.b.A1.isAttached() == false) goto L22;
        if (r4.isEmpty() == true) goto L22;
        if (r4.get("data") == null) goto L22;
        String r6 = GsonProtectorUtils.toJson(new Gson(), r4.get("data"));
        if (r6 == null) goto L23;
        HomePageDTO r7 = (HomePageDTO) GsonProtectorUtils.fromJson(new Gson(), r6, HomePageDTO.class);
        ECHybridListEngine r8 = r2.b.J;
        if (r7 == null) goto L16;
        HomePageBffDTO r9 = r7.getBff();
        if (r9 == null) goto L16;
        ECHybridListDTO r10 = r9.getFeed();
    L17:
        if (r10 == null) goto L23;
        if (r8 == null) goto L23;
        ECHybridListDTO.Companion.getClass();
        r8.r(ECHybridListDTO.a.d(r10, false, null));
    L16:
        r10 = null;
    L23:
        return qf3.e.f(this);
    L22:
        return qf3.e.c("container is not attached or params is empty or data is null");
    }
}
