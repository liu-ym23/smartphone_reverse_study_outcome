package com.bytedance.locallife.biz.experiment;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {
    static {
    }

    public static e a() {
        return new e(d("life_saas_perf_1.5_high_enable"), d("life_saas_x_get_settings_enable"), d("life_saas_ab_params_enable"), d("life_saas_cube_perf_enable"), d("life_saas_preload_resource_jsb_enable"), d("life_saas_preload_gecko_resource_jsb_enable"), d("life_saas_fetch_prefetch_enable"), d("life_saas_poi_warmup_enable"), d("life_saas_prefetch_enable"), d("life_saas_poi_prefetch_enable"), d("life_saas_pdp_prefetch_enable"), d("life_saas_perf_service_complete_enable"), d("life_saas_poi_card_preload_enable"), d("life_saas_device_score_enable"), d("life_saas_font_preload_enable"), d("life_saas_jato_opt_enable"));
    }

    public static boolean b() {
        e r100 = a();
        if (r100.f256650a == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f256653d == false) goto L7;
        return true;
    }

    public static boolean c(String r100) {
        int r101 = r100.hashCode();
        if (r101 == (-162945708)) goto L23;
        if (r101 == (-118345132)) goto L20;
        if (r101 == 386079718) goto L10;
    L24:
        e r102 = a();
        if (r102.f256650a == true) goto L27;
        return false;
    L27:
        if (r102.f256658i == false) goto L41;
    L18:
        return true;
    L41:
        return false;
    L10:
        if (r100.equals("poi_detail") == false) goto L24;
        e r103 = a();
        if (r103.f256650a == true) goto L15;
        return false;
    L15:
        if (r103.f256658i == true) goto L17;
        return false;
    L17:
        if (r103.f256659j == true) goto L18;
        return false;
    L20:
        if (r100.equals("goods_detail_page") == false) goto L24;
    L29:
        e r104 = a();
        if (r104.f256650a == true) goto L32;
        return false;
    L32:
        if (r104.f256658i == true) goto L34;
        return false;
    L34:
        if (r104.f256660k == true) goto L18;
        return false;
    L23:
        if (r100.equals("goods_detail_page_dynamic") == true) goto L29;
        goto L24
    }

    public static boolean d(String r100) {
        return Intrinsics.areEqual(HostServiceUtilsKt.y().a(r100, String.class, "0"), "1");
    }
}
