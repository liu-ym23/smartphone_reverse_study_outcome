package com.bytedance.android.shopping.store.router.hybridpage.view;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HybridPageCustomElementManager {
    public static void a() {
        if (i.a("ECShopTagList") == true) goto L6;
        i.b("ECShopTagList");
        SliceRender r1 = SliceRender.o;
        HybridPageCustomElementManager$registerElement$1 r2 = HybridPageCustomElementManager$registerElement$1.INSTANCE;
        r1.getClass();
        ElementTypes.b("ECShopTagList", r2);
    L6:
        if (i.a("ECShopPrice") == true) goto L9;
        i.b("ECShopPrice");
        SliceRender r3 = SliceRender.o;
        HybridPageCustomElementManager$registerElement$2 r4 = HybridPageCustomElementManager$registerElement$2.INSTANCE;
        r3.getClass();
        ElementTypes.b("ECShopPrice", r4);
    L9:
        if (i.a("ECShopScrollText") == true) goto L12;
        i.b("ECShopScrollText");
        SliceRender r5 = SliceRender.o;
        HybridPageCustomElementManager$registerElement$3 r6 = HybridPageCustomElementManager$registerElement$3.INSTANCE;
        r5.getClass();
        ElementTypes.b("ECShopScrollText", r6);
    L12:
        if (i.a("ECShopScrollTagList") == true) goto L14;
        i.b("ECShopScrollTagList");
        SliceRender r7 = SliceRender.o;
        HybridPageCustomElementManager$registerElement$4 r8 = HybridPageCustomElementManager$registerElement$4.INSTANCE;
        r7.getClass();
        ElementTypes.b("ECShopScrollTagList", r8);
    L14:
        SliceRender r0 = SliceRender.o;
        HybridPageCustomElementManager$registerElement$5 r9 = HybridPageCustomElementManager$registerElement$5.INSTANCE;
        r0.getClass();
        ElementTypes.b("ECShopHybridList", r9);
        ElementTypes.b("ECShopUILoading", HybridPageCustomElementManager$registerElement$6.INSTANCE);
    }
}
