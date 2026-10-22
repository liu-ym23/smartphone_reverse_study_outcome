package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.geckox.GeckoGlobalConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class NativeMallGeckoHelper implements com.bytedance.android.shopping.api.mall.h {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(NativeMallGeckoHelper$isGeckoProdEnv$2.INSTANCE);
    }

    public static String a() {
        if (((Boolean) a.getValue()).booleanValue() == false) goto L5;
        return "5fb33cde3ebff01c8433ddc22aac0816";
    L5:
        return "36723dc3e85a23e701d1697d57de07ed";
    }

    public static String b() {
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.j() == false) goto L7;
        return "ecom_mall_cards_dylite";
    L7:
        if (HybridAppInfoService.l() == false) goto L11;
        return "ecom_mall_cards_legou";
    L11:
        if (HybridAppInfoService.n() == false) goto L15;
        return "ecom_mall_cards_toutiao";
    L15:
        if (((Boolean) HybridAppInfoService.k.getValue()).booleanValue() == false) goto L19;
        return "ecom_mall_cards_novelfm";
    L19:
        if (((Boolean) HybridAppInfoService.l.getValue()).booleanValue() == false) goto L23;
        return "ecom_mall_cards_noveldr";
    L23:
        if (((Boolean) HybridAppInfoService.m.getValue()).booleanValue() == false) goto L27;
        return "ecom_mall_cards_novelhg";
    L27:
        if (HybridAppInfoService.k() == false) goto L31;
        return "ecom_mall_cards_huoshan";
    L31:
        if (((Boolean) HybridAppInfoService.n.getValue()).booleanValue() == false) goto L35;
        return "ecom_mall_cards_xigua";
    L35:
        if (((Boolean) HybridAppInfoService.f.getValue()).booleanValue() == false) goto L39;
        return "ecom_mall_cards";
    L39:
        if (((Boolean) HybridAppInfoService.o.getValue()).booleanValue() == false) goto L42;
        return "ecom_mall_cards_novelhm";
    L42:
        return "ecom_mall_cards_saas";
    }

    public static String c() {
        Lazy r0 = HybridAppInfoService.a;
        GeckoGlobalConfig.ENVType r1 = null;
        if (HybridAppInfoService.j() == false) goto L12;
        com.bytedance.geckox.b r2 = com.bytedance.geckox.b.a.a;
        GeckoGlobalConfig r3 = com.bytedance.geckox.b.a();
        if (r3 == null) goto L8;
        r1 = r3.getEnv();
    L8:
        if (r1 == GeckoGlobalConfig.ENVType.PROD) goto L10;
        return "https://tosv.byted.org/obj/gecko-internal/10180/gecko/resource/ecom_mall_cards_dylite/config.json";
    L10:
        return "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_mall_cards_dylite/config.json";
    L12:
        if (HybridAppInfoService.k() == false) goto L20;
        com.bytedance.geckox.b r4 = com.bytedance.geckox.b.a.a;
        GeckoGlobalConfig r5 = com.bytedance.geckox.b.a();
        if (r5 == null) goto L17;
        r1 = r5.getEnv();
    L17:
        if (r1 == GeckoGlobalConfig.ENVType.PROD) goto L42;
        return "https://tosv.byted.org/obj/gecko-internal/10180/gecko/resource/ecom_mall_cards_huoshan/config.json";
    L42:
        return "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/mall/saas/8663/ecom_mall_cards_huoshan/config.json";
    L20:
        if (HybridAppInfoService.n() == false) goto L29;
        com.bytedance.geckox.b r6 = com.bytedance.geckox.b.a.a;
        GeckoGlobalConfig r7 = com.bytedance.geckox.b.a();
        if (r7 == null) goto L25;
        r1 = r7.getEnv();
    L25:
        if (r1 == GeckoGlobalConfig.ENVType.PROD) goto L27;
        return "https://tosv.byted.org/obj/gecko-internal/10180/gecko/resource/ecom_mall_cards_toutiao/config.json";
    L27:
        return "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_mall_cards_toutiao/config.json";
    L29:
        if (((Boolean) HybridAppInfoService.l.getValue()).booleanValue() == false) goto L32;
        return "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/mall/saas/1967/ecom_mall_cards_noveldr/config.json";
    L32:
        if (((Boolean) HybridAppInfoService.m.getValue()).booleanValue() == false) goto L35;
        return "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/mall/saas/8662/ecom_mall_cards_novelhg/config.json";
    L35:
        if (((Boolean) HybridAppInfoService.o.getValue()).booleanValue() == false) goto L38;
        return "https://lf-normal-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/mall/saas/8704/ecom_mall_cards_novelhm/config.json";
    L38:
        if (((Boolean) HybridAppInfoService.k.getValue()).booleanValue() == false) goto L41;
        return "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/mall/saas/3040/ecom_mall_cards_novelfm/config.json";
    L41:
        if (HybridAppInfoService.k() == true) goto L42;
        if (((Boolean) HybridAppInfoService.n.getValue()).booleanValue() == false) goto L47;
        return "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/mall/saas/32/ecom_mall_cards_xigua/config.json";
    L47:
        if (HybridAppInfoService.l() == false) goto L50;
        return "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/ecom/lynx/ecom_mall_cards_legou/config.json";
    L50:
        if (((Boolean) HybridAppInfoService.f.getValue()).booleanValue() == false) goto L52;
        return "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/ecom/lynx/ecom_mall_cards/config.json";
    L52:
        return "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/ecom/lynx/ecom_mall_cards_saas/config.json";
    }

    public static String d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "pageName");
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.j() == false) goto L13;
        com.bytedance.geckox.b r1 = com.bytedance.geckox.b.a.a;
        GeckoGlobalConfig r2 = com.bytedance.geckox.b.a();
        if (r2 == null) goto L7;
        GeckoGlobalConfig.ENVType r3 = r2.getEnv();
    L9:
        if (r3 == GeckoGlobalConfig.ENVType.PROD) goto L15;
        return "https://tosv.byted.org/obj/gecko-internal/10180/gecko/resource/ecom_mall_cards_dylite/" + r4 + "_config.json";
    L15:
        return "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_mall_cards_dylite/" + r4 + "_config.json";
    L7:
        r3 = null;
        goto L9
    L13:
        return "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/ecom/lynx/" + b() + '/' + r4 + "_config.json";
    }
}
