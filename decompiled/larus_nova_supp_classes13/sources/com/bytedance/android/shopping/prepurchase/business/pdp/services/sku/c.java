package com.bytedance.android.shopping.prepurchase.business.pdp.services.sku;

import com.bytedance.android.shopping.model.sku.SkuSchemaCategory;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.f;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.g;
import com.bytedance.android.shopping.utils.a0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final Map<String, j> a;
    public final Map<String, a0> b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final f h;
    public final d i;

    public static final class a {
    }

    static {
        Objects.toString(SkuSchemaCategory.KEY_BIZ_CONTEXT);
    }

    public c(f r2, PdpSKUService.a r3) {
        Intrinsics.checkNotNullParameter(r2, "registry");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.h = r2;
        this.i = r3;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuShowJsEventSubscriber$2(this));
        this.d = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuSpecChangeJsEventSubscriber$2(this));
        this.e = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuDismissJsEventSubscriber$2(this));
        this.f = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuBuyNowJsEventSubscriber$2(this));
        this.g = LazyKt.lazy(new PdpSchemaSkuEventCenter$skuAddCartJsEventSubscriber$2(this));
    }

    public static final boolean a(c r1, JSONObject r2) {
        return r1.b.containsKey(r2.optString("sku_session_id"));
    }

    public final void b(String r2, j r3) {
        if (this.a.containsKey(r2) == false) goto L5;
        return;
    L5:
        g.a(this.h, r2, r3);
        this.a.put(r2, r3);
    }
}
