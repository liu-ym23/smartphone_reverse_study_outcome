package com.bytedance.android.shopping.sku.inner.slice;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataTemplateManager {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean(false);
    }

    public static void a() {
        if (a.compareAndSet(false, true) == true) goto L6;
        SkuCommonLog.c("SkuTemplateManager", "injectCustomWidget  已经注册过，return");
        return;
    L6:
        SkuCommonLog.c("SkuTemplateManager", "injectCustomWidget  注册自定义组件");
        SliceRender r0 = SliceRender.o;
        List r1 = CollectionsKt.listOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new a(), new b(), new c()});
        r0.getClass();
        ElementTypes.c("yata_sku", r1);
    }

    public static void b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "yata_sku", "ecom_sku_pannel_template", wh.a.b(r4), SkuYataTemplateManager$preload$1.INSTANCE);
    }
}
