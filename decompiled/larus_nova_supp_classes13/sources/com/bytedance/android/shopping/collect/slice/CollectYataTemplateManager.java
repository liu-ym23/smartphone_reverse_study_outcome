package com.bytedance.android.shopping.collect.slice;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.collect.slice.widgets.ProductCardContainerView;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectYataTemplateManager {
    public static ProductCardContainerView a;
    public static ProductCardContainerView b;
    public static final a c = null;
    public static final AtomicBoolean d = null;

    static {
        c = new a(CollectYataTemplateManager$actions$1.INSTANCE, CollectYataTemplateManager$actions$2.INSTANCE, CollectYataTemplateManager$actions$3.INSTANCE, CollectYataTemplateManager$actions$4.INSTANCE);
        d = new AtomicBoolean(false);
    }

    public static void a() {
        if (d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        SliceRender r0 = SliceRender.o;
        CollectYataTemplateManager$injectCustomWidget$1 r3 = CollectYataTemplateManager$injectCustomWidget$1.INSTANCE;
        r0.getClass();
        ElementTypes.b("ECCollectSlideContainer", r3);
        ElementTypes.c("yata_collects", CollectionsKt.listOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new b(), new c(), new d()}));
    }

    public static void b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "yata_collects", "ecom_collect_card_template", wh.a.b(r4), CollectYataTemplateManager$preload$1.INSTANCE);
    }
}
