package com.bytedance.android.shopping.skubuy.cache;

import b43.c;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.sku.UltimateBuyCacheConfig;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.abscontainer.ISchemaModel;
import com.bytedance.android.shopping.abscontainer.arch.core.cache.b;
import com.bytedance.android.shopping.sku.common.controller.SkuCommonBigPicCacheController;
import com.bytedance.android.shopping.skubuy.platform.helper.PlatformYataProtocolCrop$cropProtocolForCache$newYataData$1;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import j43.d;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuBuyResponseCacheHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.NONE, SkuBuyResponseCacheHelper$skuBuyCacheConfig$2.INSTANCE);
        b = LazyKt.lazy(SkuBuyResponseCacheHelper$lruCache$2.INSTANCE);
    }

    public static a a(ISchemaModel r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaModel");
        String r0 = r5.getQueryParam("default_spec_id");
        c r1 = c.a;
        String r2 = null;
        if (r0 != null) goto L27;
    L7:
        List r3 = null;
    L8:
        boolean r4 = false;
        if (r3 == null) goto L11;
        Object r6 = CollectionsKt.getOrNull(r3, 0);
    L13:
        if ((r6 instanceof String) == true) goto L15;
        r6 = null;
    L15:
        String r7 = (String) r6;
        if (r7 == null) goto L26;
        if (r7.length() != 0) goto L20;
        r4 = true;
    L20:
        if (r4 == true) goto L26;
        if (Intrinsics.areEqual(r7, "null") == true) goto L26;
        r2 = r7;
    L26:
        return new a(r5.getQueryParam("sku_promotion_id"), r5.getQueryParam("id"), r5.getQueryParam("scene_type"), r2);
    L11:
        r6 = null;
        goto L13
    L27:
        int r8 = t0.a;     // Catch: Exception -> L6
        r3 = (List) t0.a.a.fromJson(r0, new b43.a().getType());     // Catch: Exception -> L6
        goto L8
    }

    public static com.bytedance.android.shopping.abscontainer.arch.core.cache.a b(a r4) {
        Intrinsics.checkNotNullParameter(r4, "cacheKey");
        b r1 = (b) b.getValue();
        String r2 = r4.a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
        com.bytedance.android.shopping.abscontainer.arch.core.cache.a r0 = (com.bytedance.android.shopping.abscontainer.arch.core.cache.a) r1.a.b(r2);
        Object r3 = null;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (c(r0) == true) goto L8;
        return null;
    L8:
        SkuCommonBigPicCacheController.a r5 = SkuCommonBigPicCacheController.a;
        String r6 = r4.b;
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        com.bytedance.android.shopping.sku.common.controller.b r7 = SkuCommonBigPicCacheController.a(r6);
        if (r7 != null) goto L14;
    L43:
        return r0;
    L14:
        if (Boolean.valueOf(r7.a).booleanValue() == false) goto L16;
        String r8 = "big_pic";
    L17:
        com.bytedance.kmp.ec.yata.common.protocol.data.c r9 = r0.a.g();
        if (r9 == null) goto L26;
        Map r10 = r9.getData();
        if (r10 == null) goto L26;
        p r11 = (p) r10.get("specs_1");
        if (r11 == null) goto L26;
        Map r12 = r11.h();
        if (r12 == null) goto L26;
        Object r13 = r12.get("specs_state");
    L28:
        if ((r13 instanceof Map) == true) goto L30;
        r13 = null;
    L30:
        Map r14 = (Map) r13;
        if (r14 == null) goto L33;
        Object r15 = r14.get("0");
    L35:
        if (TypeIntrinsics.isMutableMap(r15) == false) goto L38;
        r3 = r15;
    L38:
        Map r16 = (Map) r3;
        if (r16 == null) goto L41;
        r16.get("cur_show_mode");
    L41:
        if (r16 == null) goto L43;
        r16.put("cur_show_mode", r8);
        goto L43
    L33:
        r15 = null;
    L26:
        r13 = null;
        goto L28
    L16:
        r8 = "small_pic";
        goto L17
    }

    public static boolean c(com.bytedance.android.shopping.abscontainer.arch.core.cache.a r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        int r1 = d.a;
        if ((System.currentTimeMillis() - r7.b) > (((UltimateBuyCacheConfig) a.getValue()).getExpireTime() * ((long) 1000))) goto L9;
        return true;
    L9:
        return false;
    }

    public static void d(a r6, n33.a r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "cacheKey");
        Intrinsics.checkNotNullParameter(r7, "response");
        String r1 = r6.b;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        return;
    L12:
        if (BuyNowPerformanceOpt.d() == true) goto L14;
        return;
    L14:
        com.bytedance.kmp.ec.yata.common.protocol.data.c r4 = r7.g();
        Object r5 = null;
        if (r4 == null) goto L19;
        Map r9 = r4.g();
        if (r9 == null) goto L19;
        Object r10 = r9.get("tracker_common_params");
    L21:
        if ((r10 instanceof Map) == true) goto L24;
        r10 = null;
    L24:
        if (mq.b.c((Map) r10, "all_forbidden", false) == false) goto L26;
        return;
    L26:
        String r11 = r6.d;
        if (r8 == false) goto L63;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r12 = r7.g();
        if (r12 == null) goto L35;
        Map r13 = r12.getData();
        if (r13 == null) goto L35;
        p r14 = (p) r13.get("specs_1");
        if (r14 == null) goto L35;
        Map r15 = r14.h();
    L36:
        if (r15 == null) goto L38;
        Object r16 = r15.get("specs_state");
    L40:
        if ((r16 instanceof Map) == true) goto L42;
        r16 = null;
    L42:
        Map r17 = (Map) r16;
        if (r17 == null) goto L45;
        Object r18 = r17.get("0");
    L47:
        if ((r18 instanceof Map) == true) goto L49;
        r18 = null;
    L49:
        Map r19 = (Map) r18;
        if (r19 == null) goto L52;
        Object r20 = r19.get("selected_spec_item_id");
    L54:
        if ((r20 instanceof String) == true) goto L56;
    L62:
        r11 = String.valueOf(r5);
        goto L63
    L56:
        if (((CharSequence) r20).length() == 0) goto L59;
        r2 = false;
    L59:
        if (r2 == true) goto L62;
        r5 = r20;
        goto L62
    L52:
        r20 = null;
        goto L54
    L45:
        r18 = null;
        goto L47
    L38:
        r16 = null;
    L35:
        r15 = null;
    L63:
        String r21 = r6.b;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r22 = r7.g();
        if (r22 == null) goto L67;
        int r23 = com.bytedance.android.shopping.skubuy.platform.helper.c.a;
        Intrinsics.checkNotNullParameter(r22, "yataData");
        Intrinsics.checkNotNullParameter(r21, "productId");
        r7 = new n33.a(new com.bytedance.kmp.ec.yata.common.protocol.utils.d(r22, new PlatformYataProtocolCrop$cropProtocolForCache$newYataData$1()).a(), 2);
    L67:
        b r24 = (b) b.getValue();
        String r25 = new a(r6.a, r6.b, r6.c, r11).a();
        int r26 = d.a;
        com.bytedance.android.shopping.abscontainer.arch.core.cache.a r27 = new com.bytedance.android.shopping.abscontainer.arch.core.cache.a(r7, System.currentTimeMillis());
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "cacheKey");
        Intrinsics.checkNotNullParameter(r27, "cache");
        r24.a.g(r25, r27);
        return;
    L19:
        r10 = null;
        goto L21
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
