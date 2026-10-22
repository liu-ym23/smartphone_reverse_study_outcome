package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.model.sku.SkuSchemaCategory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PdpSchemaSkuEventCenter {
    public final Map<String, ti.j> a;
    public final Map<String, a0> b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final AnchorV4VM h;

    public static final class a {
    }

    static {
        Objects.toString(SkuSchemaCategory.KEY_BIZ_CONTEXT);
    }

    public PdpSchemaSkuEventCenter(AnchorV4VM r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.h = r2;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuShowJsEventSubscriber$2(this));
        this.d = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuSpecChangeJsEventSubscriber$2(this));
        this.e = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuDismissJsEventSubscriber$2(this));
        this.f = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuBuyNowJsEventSubscriber$2(this));
        this.g = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuAddCartJsEventSubscriber$2(this));
    }

    public static final boolean a(PdpSchemaSkuEventCenter r1, JSONObject r2) {
        return r1.b.containsKey(r2.optString("sku_session_id"));
    }

    public final void b(String r2, ti.j r3) {
        if (this.a.containsKey(r2) == false) goto L5;
        return;
    L5:
        ECLiveHybridUtil.m(r2, r3);
        this.a.put(r2, r3);
    }
}
