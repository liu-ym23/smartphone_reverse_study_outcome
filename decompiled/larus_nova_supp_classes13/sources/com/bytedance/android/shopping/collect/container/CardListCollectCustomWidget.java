package com.bytedance.android.shopping.collect.container;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListCollectCustomWidget {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean(false);
    }

    public static void a(int r4, int r5, int r6) {
        if (a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        SliceRender r0 = SliceRender.o;
        CardListCollectCustomWidget$injectCustomWidget$1 r3 = CardListCollectCustomWidget$injectCustomWidget$1.INSTANCE;
        r0.getClass();
        ElementTypes.b("ECCollectSlideContainer", r3);
        ElementTypes.c("yata_collects", CollectionsKt.listOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new fb3.a(r6), new fb3.c(r4), new fb3.b(r5)}));
    }
}
