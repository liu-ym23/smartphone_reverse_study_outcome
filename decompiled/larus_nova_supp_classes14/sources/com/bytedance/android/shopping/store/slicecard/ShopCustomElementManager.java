package com.bytedance.android.shopping.store.slicecard;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopCustomElementManager {
    public static void a() {
        if (HybridPageConfigSetting.d == true) goto L5;
        SliceRender r0 = SliceRender.o;
        ShopCustomElementManager$registerElement$5 r5 = ShopCustomElementManager$registerElement$5.INSTANCE;
        r0.getClass();
        ElementTypes.b("ECShopTagList", r5);
        ElementTypes.b("ECShopPrice", ShopCustomElementManager$registerElement$6.INSTANCE);
        ElementTypes.b("ECShopScrollText", ShopCustomElementManager$registerElement$7.INSTANCE);
        ElementTypes.b("ECShopScrollTagList", ShopCustomElementManager$registerElement$8.INSTANCE);
    L17:
        SliceRender r1 = SliceRender.o;
        ShopCustomElementManager$registerElement$9 r2 = ShopCustomElementManager$registerElement$9.INSTANCE;
        r1.getClass();
        ElementTypes.b("ECShopLivePlayer", r2);
        ElementTypes.b("ECShopMarquee", ShopCustomElementManager$registerElement$10.INSTANCE);
        ElementTypes.b("ECShopSearchBar", ShopCustomElementManager$registerElement$11.INSTANCE);
        ElementTypes.b("ECShopProductFilterButton", ShopCustomElementManager$registerElement$12.INSTANCE);
        ElementTypes.b("ECShopVideoPlayer", ShopCustomElementManager$registerElement$13.INSTANCE);
        ElementTypes.b("ECShopReplayProgressbar", ShopCustomElementManager$registerElement$14.INSTANCE);
        ElementTypes.b("ECShopTrustFloatBarContent", ShopCustomElementManager$registerElement$15.INSTANCE);
        return;
    L5:
        if (com.bytedance.android.shopping.store.router.hybridpage.view.i.a("ECShopTagList") == true) goto L8;
        com.bytedance.android.shopping.store.router.hybridpage.view.i.b("ECShopTagList");
        SliceRender r3 = SliceRender.o;
        ShopCustomElementManager$registerElement$1 r6 = ShopCustomElementManager$registerElement$1.INSTANCE;
        r3.getClass();
        ElementTypes.b("ECShopTagList", r6);
    L8:
        if (com.bytedance.android.shopping.store.router.hybridpage.view.i.a("ECShopPrice") == true) goto L11;
        com.bytedance.android.shopping.store.router.hybridpage.view.i.b("ECShopPrice");
        SliceRender r4 = SliceRender.o;
        ShopCustomElementManager$registerElement$2 r7 = ShopCustomElementManager$registerElement$2.INSTANCE;
        r4.getClass();
        ElementTypes.b("ECShopPrice", r7);
    L11:
        if (com.bytedance.android.shopping.store.router.hybridpage.view.i.a("ECShopScrollText") == true) goto L14;
        com.bytedance.android.shopping.store.router.hybridpage.view.i.b("ECShopScrollText");
        SliceRender r8 = SliceRender.o;
        ShopCustomElementManager$registerElement$3 r9 = ShopCustomElementManager$registerElement$3.INSTANCE;
        r8.getClass();
        ElementTypes.b("ECShopScrollText", r9);
    L14:
        if (com.bytedance.android.shopping.store.router.hybridpage.view.i.a("ECShopScrollTagList") == true) goto L17;
        com.bytedance.android.shopping.store.router.hybridpage.view.i.b("ECShopScrollTagList");
        SliceRender r10 = SliceRender.o;
        ShopCustomElementManager$registerElement$4 r11 = ShopCustomElementManager$registerElement$4.INSTANCE;
        r10.getClass();
        ElementTypes.b("ECShopScrollTagList", r11);
        goto L17
    }
}
