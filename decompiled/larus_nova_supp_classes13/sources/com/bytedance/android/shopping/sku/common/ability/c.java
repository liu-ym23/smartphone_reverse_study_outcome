package com.bytedance.android.shopping.sku.common.ability;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Map;
import ul.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface c {
    SkuParams a();

    void b(Context r1, PageFinder r2, Map<String, ? extends Object> r3, String r4);

    void c(Context r1, Map<String, ? extends Object> r2, f r3, SkuAbilityType r4);

    void d(Context r1, Map<String, ? extends Object> r2);

    void e(SkuParams r1);

    void f(Context r1, PageFinder r2, String r3, String r4, Map<String, ? extends Object> r5, boolean r6);

    void g(Context r1, f r2);

    void h(Context r1, PageFinder r2, Map<String, ? extends Object> r3);

    void i(Context r1, PageFinder r2, Map<String, ? extends Object> r3);

    void j(Context r1, View r2, PageFinder r3, com.bytedance.android.shopping.sku.inner.container.b r4, Map r5, com.bytedance.android.shopping.sku.inner.function.business.a r6, float[] r7);
}
