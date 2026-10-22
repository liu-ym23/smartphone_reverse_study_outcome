package com.bytedance.android.shopping.sku.inner.repo.composer;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataExParamsComposer {
    public final SkuParams a;
    public final String b;
    public final SkuSchemaParams c;
    public final WeakReference<Object> d;

    public final List<SkuPassThroughItem> a() {
        if (Intrinsics.areEqual(this.b, "forDiff") == true) goto L5;
        String r0 = (String) this.a.getEventParams().get("entrance_info");
        this.a.getEventParams();
        LinkedHashMap r1 = new LinkedHashMap();
        Lazy r2 = SkuPerformanceOpt.a;
        BuyNowPerformanceOpt.l();
        if (this.a.getActionType() != 2) goto L9;
    L10:
        Function0<String> r3 = new SkuYataExParamsComposer$getPassThrough$1(this);
        SkuSchemaParams r4 = this.c;
        if (r4 != null) goto L13;
    L14:
        r1.put("api.add.extra", r3.invoke());
    L15:
        Function0<String> r5 = new SkuYataExParamsComposer$getPassThrough$2(this);
        SkuSchemaParams r6 = this.c;
        if (r6 != null) goto L18;
    L19:
        r1.put("api.sku.entrance_info", r5.invoke());
    L20:
        ArrayList r7 = new ArrayList(r1.size());
        Iterator r8 = r1.entrySet().iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.add(new SkuPassThroughItem(CollectionsKt.listOf(r9.getKey()), (String) r9.getValue(), null, 4, null));
        goto L22
    L24:
        return r7;
    L18:
        if (r6.getPassThroughToKeys().contains("api.sku.entrance_info") == false) goto L20;
    L13:
        if (r4.getPassThroughToKeys().contains("api.add.extra") == false) goto L15;
    L9:
        if (this.a.getActionType() != 4) goto L15;
    L5:
        return CollectionsKt.emptyList();
    }

    public SkuYataExParamsComposer(SkuParams r2, String r3, SkuSchemaParams r4, WeakReference<Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        Intrinsics.checkNotNullParameter(r3, "skuUniqueId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
