package com.bytedance.android.shopping.mall.homepage.tools;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.mall.settings.MallStorageClearSettingKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q {
    public static Set<String> a;

    public static final long b() {
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        if (r0 == null) goto L9;
        yj.i r1 = r0.getIHybridHostAppInfo();
        if (r1 == null) goto L10;
        r1.c();
        return -1;
    L10:
        return -1;
    L9:
        return -1;
    }

    public static final String a(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        r8 = "homepage_cache";
    L12:
        String r3 = "";
        if (Intrinsics.areEqual(r8, "homepage_cache") == false) goto L33;
        int r4 = s93.c.a;
        Object r5 = 1;
        IHybridHostService r6 = com.bytedance.android.ec.hybrid.a.h();
        if (r6 == null) goto L22;
        yj.g r9 = r6.getHostAB();
        if (r9 == null) goto L22;
        Object r10 = r9.a("front_page_mall_cache_strategy", r5);
        if (r10 == null) goto L22;
        r5 = r10;
    L22:
        Lazy r11 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : front_page_mall_cache_strategy, Value: " + r5);
        if (((Number) r5).intValue() != 1) goto L33;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "originKeyCache");
        String r12 = d(r7, r8);
        if (r12 != null) goto L38;
        String r13 = d(r7, "xtab");
        if (r13 == null) goto L32;
        r3 = r13;
    L32:
        return r3;
    L38:
        return r12;
    L33:
        String r14 = d(r7, r8);
        if (r14 != null) goto L37;
        return "";
    L37:
        return r14;
    L5:
        if (r8.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public static final SharedPreferences c(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "name");
        return r1.getApplicationContext().getSharedPreferences(r2, 0);
    }

    public static final String d(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "key");
        return g(r3, c(r3, "ec_mall_cache_storage"), r4, "ec_mall_cache_storage." + r4);
    }

    public static final void f(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "result");
        c(r2, "ec_mall_cache_storage").edit().putString(r3, r4).putLong(r3 + "_create_time", b()).apply();
    }

    public static final void e(Context r17, Pair<String, HomePageDTO> r18, String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "resultOrDTO");
        Lazy r5 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.k.a r6 = com.bytedance.android.ec.hybrid.log.mall.k.a.b;
        ECMallLogUtil.c(r6, "saveHomepageApiResult start, timestamp = " + System.currentTimeMillis() + ", tag = " + r19 + ", skipTrim = " + r20);
        String r7 = (String) r18.component1();
        HomePageDTO r8 = (HomePageDTO) r18.component2();
        if (r7 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L13;
        if (r8 != null) goto L13;
        ECMallLogUtil.c(r6, "saveHomepageApiResult, result and dto are both null or empty, timestamp = " + System.currentTimeMillis() + ", tag = " + r19 + ", skipTrim = " + r20);
        return;
    L13:
        int r13 = s93.c.a;
        Object r14 = 0;
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();
        if (r15 == null) goto L21;
        yj.g r16 = r15.getHostAB();
        if (r16 == null) goto L21;
        Object r110 = r16.a("ec_mall_homepage_cache_trim_size", r14);
        if (r110 == null) goto L21;
        r14 = r110;
    L21:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_homepage_cache_trim_size, Value: " + r14);
        int r111 = ((Number) r14).intValue();
        if (r20 == true) goto L91;
        if (r111 <= 0) goto L91;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L81
        Gson r113 = new Gson();     // Catch: Throwable -> L81
        if (r8 != null) goto L27;
        HomePageDTO r114 = (HomePageDTO) r113.fromJson(r7, HomePageDTO.class);     // Catch: Throwable -> L81
    L28:
        HomePageBffDTO r115 = r114.getBff();     // Catch: Throwable -> L81
        if (r115 == null) goto L33;
        Map<String, Object> r10 = r115.getDynamicParams();     // Catch: Throwable -> L81
        if (r10 == null) goto L33;
        Object r11 = r10.get("tab_id");     // Catch: Throwable -> L81
    L35:
        if ((r11 instanceof Number) == true) goto L37;
        r11 = null;
    L37:
        Number r116 = (Number) r11;     // Catch: Throwable -> L81
        if (r116 == null) goto L40;
        String r117 = String.valueOf(r116.intValue());     // Catch: Throwable -> L81
    L134:
        if (Intrinsics.areEqual(r117, "0") == false) goto L83;
        ECMallLogUtil.c(r6, "saveHomepageApiResult, trim start, timestamp = " + System.currentTimeMillis() + ", tag = " + r19 + ", trimSize = " + r111);     // Catch: Throwable -> L81
        HomePageBffDTO r9 = r114.getBff();     // Catch: Throwable -> L81
        if (r9 == null) goto L78;
        ECHybridListDTO r21 = r9.getFeed();     // Catch: Throwable -> L81
        if (r21 == null) goto L78;
        List r22 = r21.getSections();     // Catch: Throwable -> L81
        if (r22 == null) goto L78;
        Iterator r23 = r22.iterator();     // Catch: Throwable -> L81
    L51:
        if (r23.hasNext() == false) goto L55;
        Object r118 = r23.next();     // Catch: Throwable -> L81
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r118).getSectionId(), "favorite_section") == false) goto L51;
    L56:
        ECHybridListSectionDTO r119 = (ECHybridListSectionDTO) r118;     // Catch: Throwable -> L81
        if (r119 == null) goto L78;
        ArrayList r24 = r119.getItems();     // Catch: Throwable -> L81
        if (r24 == null) goto L61;
        int r25 = r24.size();     // Catch: Throwable -> L81
    L62:
        if (r25 <= r111) goto L75;
        ArrayList r26 = r119.getItems();     // Catch: Throwable -> L81
        if (r26 == null) goto L68;
        Collection r27 = r26.subList(0, r111);     // Catch: Throwable -> L79
        if (r27 == null) goto L68;
    L69:
        if (r27 == null) goto L78;
        if ((r27 instanceof ArrayList) == false) goto L74;
        ArrayList r28 = (ArrayList) r27;     // Catch: Throwable -> L79
    L76:
        r119.setItems(r28);     // Catch: Throwable -> L79
        goto L78
    L74:
        r28 = new ArrayList(r27);     // Catch: Throwable -> L79
    L68:
        r27 = r119.getItems();     // Catch: Throwable -> L79
        goto L69
    L75:
        r28 = r119.getItems();     // Catch: Throwable -> L79
        goto L76
    L61:
        r25 = 0;
        goto L62
    L55:
        r118 = null;
    L78:
        String r29 = r113.toJson(r114);     // Catch: Throwable -> L79
        Lazy r120 = ECMallLogUtil.a;     // Catch: Throwable -> L79
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "saveHomepageApiResult, trim end, timestamp = " + System.currentTimeMillis() + ", tag = " + r19 + ", trimSize = " + r111);     // Catch: Throwable -> L79
    L84:
        Object r0 = Result.constructor-impl(r29);     // Catch: Throwable -> L79
    L88:
        if (Result.isFailure-impl(r0) == false) goto L90;
        r0 = null;
    L90:
        String r1 = (String) r0;
    L92:
        if (r1 != null) goto L94;
    L97:
        boolean r30 = true;
    L98:
        if (r30 == true) goto L100;
        r7 = r1;
    L111:
        if (r7 != null) goto L113;
    L116:
        boolean r2 = true;
    L117:
        if (r2 == false) goto L120;
        Lazy r3 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "saveHomepageApiResult, finalResult is null or empty, timestamp = " + System.currentTimeMillis() + ", tag = " + r19 + ", skipTrim = " + r20);
        return;
    L120:
        if (r19 != null) goto L122;
    L125:
        boolean r121 = true;
    L126:
        if (r121 == false) goto L128;
        String r4 = "homepage_cache";
    L129:
        String r31 = a(r17, r19);
        if (com.bytedance.forest.utils.h.a(r31) == false) goto L132;
        f(r17, "{" + r4 + "}_lasted", r31);
    L132:
        f(r17, r4, r7);
        Lazy r32 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "saveHomepageApiResult end, timestamp = " + System.currentTimeMillis() + ", tag = " + r19 + ", skipTrim = " + r20);
        return;
    L128:
        r4 = r19;
        goto L129
    L122:
        if (r19.length() == 0) goto L125;
        r121 = false;
        goto L126
    L113:
        if (r7.length() == 0) goto L116;
        r2 = false;
        goto L117
    L100:
        if (r7 != null) goto L102;
    L105:
        boolean r33 = true;
    L106:
        if (r33 == false) goto L111;
        if (r8 == null) goto L110;
        r7 = GsonProtectorUtils.toJson(new Gson(), r8);
        goto L111
    L110:
        r7 = null;
        goto L111
    L102:
        if (r7.length() == 0) goto L105;
        r33 = false;
        goto L106
    L94:
        if (r1.length() == 0) goto L97;
        r30 = false;
        goto L98
    L83:
        r29 = null;
    L79:
        th = th;
    L86:
        Result.Companion r34 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L88
    L40:
        r117 = null;
    L33:
        r11 = null;
        goto L35
    L27:
        r114 = r8;
    L81:
        th = th;
    L91:
        r1 = null;
        goto L92
    L5:
        if (r7.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    public static final String g(Context r23, SharedPreferences r24, String r25, String r26) {
        long r7 = r24.getLong(r25 + "_create_time", -1);
        String r9 = r24.getString(r25, null);
        if (r9 != null) goto L5;
        return null;
    L5:
        Lazy r10 = MallStorageClearSettingKt.a;
        Intrinsics.checkNotNullParameter(r26, "key");
        aa3.f r11 = (aa3.f) MallStorageClearSettingKt.a.getValue();
        if (r11 == null) goto L10;
        Map<String, List<aa3.g>> r12 = r11.d();
        if (r12 == null) goto L10;
        List<aa3.g> r2 = r12.get(r26);
    L11:
        boolean r13 = true;
        if (r7 > 0) goto L22;
        List<aa3.g> r14 = r2;
        if (r14 != null) goto L16;
    L19:
        boolean r15 = true;
    L20:
        if (r15 == true) goto L22;
    L76:
        boolean r3 = true;
    L79:
        if (r3 == true) goto L81;
    L86:
        Lazy r0 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.k.a r1 = com.bytedance.android.ec.hybrid.log.mall.k.a.b;
        StringBuilder r4 = new StringBuilder("mall cache get ");
        r4.append(r25);
        r4.append(", create time: ");
        r4.append(r7);
        r4.append(", cache: ");
        if (r9.length() > 0) goto L90;
        r13 = false;
    L90:
        r4.append(r13);
        ECMallLogUtil.c(r1, r4.toString());
        return r9;
    L81:
        if (r9.length() <= 0) goto L83;
        boolean r5 = true;
    L84:
        if (r5 == false) goto L86;
        Lazy r6 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "mall cache remove " + r25 + ", create time: " + r7);
        r24.edit().remove(r25 + "_create_time").remove(r25).apply();
        return null;
    L83:
        r5 = false;
        goto L84
    L16:
        if (r14.isEmpty() == true) goto L19;
        r15 = false;
    L22:
        if (r2 == null) goto L31;
        Iterator<T> r8 = r2.iterator();
    L25:
        if (r8.hasNext() == false) goto L31;
        aa3.g r16 = (aa3.g) r8.next();
        if (r7 <= r16.b()) goto L25;
        if (r7 >= r16.a()) goto L25;
    L31:
        if (r7 <= 0) goto L42;
        aa3.f r17 = (aa3.f) MallStorageClearSettingKt.a.getValue();
        if (r17 == null) goto L35;
        Integer r18 = r17.a();
    L36:
        if (r18 == null) goto L42;
        if (r18.intValue() <= 0) goto L42;
        long r19 = ((long) ((((r18.intValue() * 24) * 60) * 60) * 1000)) + r7;
        b();
        if (r19 >= (-1)) goto L42;
    L35:
        r18 = null;
    L42:
        Set<String> r20 = a;
        if (r20 != null) goto L45;
    L47:
        aa3.f r21 = (aa3.f) MallStorageClearSettingKt.a.getValue();
        if (r21 == null) goto L77;
        Integer r22 = r21.b();
        if (r22 == null) goto L77;
        int r27 = r22.intValue();
        SharedPreferences r28 = c(r23, "mall_stability_sp");
        if (a != null) goto L58;
        Set<String> r110 = r28.getStringSet("mall_crash_time", new LinkedHashSet());
        a = r110;
        if (r110 == null) goto L58;
        if (r110.size() == 0) goto L77;
    L58:
        LinkedHashSet r111 = new LinkedHashSet();
        long r112 = System.currentTimeMillis();
        Set<String> r113 = a;
        if (r113 == null) goto L72;
        Iterator<T> r114 = r113.iterator();
        int r115 = 0;
    L62:
        if (r114.hasNext() == false) goto L71;
        String r29 = (String) r114.next();
        long r116 = CastLongProtector.parseLong(r29);
        Long r117 = r21.c();
        if (r117 == null) goto L66;
        long r210 = r117.longValue();
    L68:
        if (r116 <= (r112 - r210)) goto L62;
        r111.add(r29);
        r115 = r115 + 1;
        goto L62
    L66:
        r210 = 86400000;
        goto L68
    L71:
        int r30 = r115;
    L73:
        Lazy r31 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "crash time is " + r30);
        if (r30 < r27) goto L77;
        r28.edit().remove("mall_crash_time").apply();
        goto L76
    L72:
        r30 = 0;
    L77:
        r3 = false;
        goto L79
    L45:
        if (r20.size() != 0) goto L47;
    L10:
        r2 = null;
        goto L11
    }
}
