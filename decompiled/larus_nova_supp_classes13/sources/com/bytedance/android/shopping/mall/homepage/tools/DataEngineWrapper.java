package com.bytedance.android.shopping.mall.homepage.tools;

import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECMallAddressService;
import com.bytedance.android.shopping.api.mall.common.homepage.card.BigFontAdapter;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import com.bytedance.android.shopping.api.mall.common.tools.StorageItemDataProvider;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.bytedance.common.utility.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DataEngineWrapper implements com.bytedance.android.shopping.api.mall.f {
    public ECHybridDataEngine a;
    public y93.a b;
    public Map<String, ? extends Object> c;
    public final String d;
    public final String e;
    public com.bytedance.android.ec.hybrid.list.util.d f;
    public final ConcurrentHashMap<String, Object> g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public com.bytedance.android.ec.hybrid.tools.b<String> q;
    public volatile String r;
    public volatile boolean s;
    public volatile HomePageDTO t;
    public volatile HomePageDTO u;
    public Integer v;
    public volatile Function1<? super Long, ? extends JSONObject> w;

    public final class a implements com.bytedance.android.ec.hybrid.data.g {
        public final /* synthetic */ DataEngineWrapper a;

        public a(DataEngineWrapper r1) {
            this.a = r1;
        }

        public final Map<String, Object> a(String r13) {
            Intrinsics.checkNotNullParameter(r13, "apiKey");
            HashMap r0 = new HashMap();
            r0.put("page_num", "1");
            r0.put("cursor", "0");
            r0.put("recommend_back_up_offset", "0");
            Map<String, ? extends Object> r1 = this.a.c;
            if (r1 == null) goto L10;
            Iterator<Map.Entry<String, ? extends Object>> r2 = r1.entrySet().iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            Map.Entry<String, ? extends Object> r3 = r2.next();
            String r4 = r3.getKey();
            Object r5 = r3.getValue();
            if (r0.containsKey(r4) == true) goto L6;
            r0.put(r4, r5.toString());
        L10:
            v93.a.c.getClass();
            String r6 = v93.a.b;
            if (r6.length() <= 0) goto L13;
            boolean r7 = true;
        L14:
            if (r7 == false) goto L16;
            r0.put("pitaya_info", r6);
        L16:
            Object r8 = null;
            if (r0.get("log_extra") != null) goto L35;
            Object r9 = r0.get("tab_id");
            JSONObject r10 = new JSONObject();
            if (r0.containsKey(this.a.d) == false) goto L25;
            DataEngineWrapper r11 = this.a;
            String r12 = r11.d;
            Object r14 = r0.get(r12);
            if ((r14 instanceof String) == true) goto L23;
            r14 = null;
        L23:
            DataEngineWrapper.b(r11, r10, r12, (String) r14);
        L25:
            if (r0.containsKey(this.a.e) == false) goto L30;
            DataEngineWrapper r15 = this.a;
            String r16 = r15.e;
            Object r17 = r0.get(r16);
            if ((r17 instanceof String) == true) goto L29;
            r17 = null;
        L29:
            DataEngineWrapper.b(r15, r10, r16, (String) r17);
        L30:
            if (r9 == null) goto L34;
            DataEngineWrapper.b(this.a, r10, "tab_id", r9.toString());
            Object r18 = r0.get("tab_name");
            if (r18 == null) goto L34;
            DataEngineWrapper.b(this.a, r10, "tab_name", r18.toString());
        L34:
            Unit r19 = Unit.INSTANCE;
            r0.put("log_extra", r10.toString());
        L35:
            DataEngineWrapper r20 = this.a;
            if (r20.v != null) goto L38;
            r20.v = com.bytedance.android.shopping.api.mall.common.tools.h.b.getLocationPermissionParam();
        L38:
            Integer r21 = this.a.v;
            if (r21 != null) goto L161;
        L54:
            int r22 = com.bytedance.android.ec.hybrid.tools.f.a;
            Object r23 = 0;
            int r24 = com.bytedance.android.ec.base.settings.c.a;
            Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L130
            Object r26 = com.bytedance.android.ec.base.settings.d.c.get("ec_mall_legou_preload_ec_hybrid_config_opt");     // Catch: Throwable -> L105
            if (r26 != null) goto L60;
        L102:
            Object r27 = null;
        L103:
            Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L105
        L107:
            Throwable r29 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L130
            if (r29 == null) goto L111;
            EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L130
        L111:
            if (Result.isFailure-impl(r28) == false) goto L114;
            r28 = null;
        L114:
            if ((r28 instanceof Integer) == true) goto L116;
            r28 = null;
        L116:
            Object r30 = (Integer) r28;     // Catch: Throwable -> L130
            if (r30 == null) goto L119;
            r23 = r30;
        L139:
            if (((Number) r23).intValue() > 0) goto L141;
            this.a.v = null;
        L141:
            g(r0, r13);
            Map<String, ? extends Object> r110 = this.a.c;
            if (r110 == null) goto L144;
            Object r111 = r110.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        L146:
            if ((r111 instanceof String) == false) goto L149;
            r8 = r111;
        L149:
            String r31 = (String) r8;
            if (r31 != null) goto L152;
            r31 = "";
        L152:
            Lazy r112 = BigFontAdapter.a;
            if (BigFontAdapter.b(r31) == false) goto L155;
            r0.put("big_font_enabled", 1);
            BigFontAdapter.FontType.Companion.getClass();
            r0.put("font_size_pref", Integer.valueOf(BigFontAdapter.FontType.a.a()));
        L155:
            ECMallFavoriteSectionHelper.K.getClass();
            if (Intrinsics.areEqual(ECMallFavoriteSectionHelper.a.a().a(), Boolean.TRUE) == false) goto L158;
            r0.put("is_active_refresh", Boolean.FALSE);
        L158:
            r0.put("can_client_nest_channel", Integer.valueOf(((Number) this.a.o.getValue()).intValue()));
            return r0;
        L144:
            r111 = null;
            goto L146
        L119:
            IHybridHostService r32 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L130
            if (r32 == null) goto L122;
            Object r33 = r32.getHostABValue("ec_mall_legou_preload_ec_hybrid_config_opt", r23);     // Catch: Throwable -> L130
        L123:
            if (r33 == null) goto L139;
            if ((r33 instanceof Integer) == true) goto L127;
            r33 = null;
        L127:
            Object r34 = (Integer) r33;     // Catch: Throwable -> L130
            if (r34 == null) goto L139;
        L137:
            r23 = r34;
            goto L139
        L122:
            r33 = null;
            goto L123
        L60:
            if ((r26 instanceof Integer) == true) goto L62;
            Object r35 = null;
        L63:
            r27 = (Integer) r35;     // Catch: Throwable -> L105
            if (r27 != null) goto L103;
            if ((r26 instanceof Number) == false) goto L90;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L75;
            Float r36 = Float.valueOf(((Number) r26).floatValue());     // Catch: Throwable -> L105
            if ((r36 instanceof Integer) == true) goto L73;
            r36 = null;
        L73:
            r27 = (Integer) r36;     // Catch: Throwable -> L105
            goto L103
        L75:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L81;
            Double r37 = Double.valueOf(((Number) r26).doubleValue());     // Catch: Throwable -> L105
            if ((r37 instanceof Integer) == true) goto L79;
            r37 = null;
        L79:
            r27 = (Integer) r37;     // Catch: Throwable -> L105
            goto L103
        L81:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L84;
            r27 = Integer.valueOf(((Number) r26).intValue());     // Catch: Throwable -> L105
            goto L103
        L84:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L90;
            Long r38 = Long.valueOf(((Number) r26).longValue());     // Catch: Throwable -> L105
            if ((r38 instanceof Integer) == true) goto L88;
            r38 = null;
        L88:
            r27 = (Integer) r38;     // Catch: Throwable -> L105
        L90:
            if ((r26 instanceof JSONObject) == false) goto L92;
        L167:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L98
            Object r39 = SDKSettingsCacheManager.a().fromJson(r26.toString(), Integer.class);     // Catch: Throwable -> L98
            if ((r39 instanceof Integer) == true) goto L96;
            r39 = null;
        L96:
            Object r40 = Result.constructor-impl((Integer) r39);     // Catch: Throwable -> L98
        L100:
            r27 = r40;
            if (Result.isFailure-impl(r27) == false) goto L103;
        L98:
            th = move-exception;
            Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L105
            r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L105
            goto L100
        L92:
            if ((r26 instanceof JSONArray) == false) goto L102;
        L62:
            r35 = r26;
        L105:
            th = move-exception;
            Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L130
            r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        L130:
            th = move-exception;
            Result.Companion r43 = Result.Companion;
            r34 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r44 = Result.exceptionOrNull-impl(r34);
            if (r44 == null) goto L135;
            EnsureManager.ensureNotReachHere(r44);
        L135:
            if (Result.isFailure-impl(r34) == false) goto L137;
        L161:
            int r45 = r21.intValue();     // Catch: Throwable -> L160
            Context r46 = com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostAppInfo().getApplicationContext();     // Catch: Throwable -> L160
            if (r46 == null) goto L43;
            Object r47 = r46.getSystemService("location");     // Catch: Throwable -> L160
        L45:
            if ((r47 instanceof LocationManager) == true) goto L47;
            r47 = null;
        L47:
            LocationManager r48 = (LocationManager) r47;     // Catch: Throwable -> L160
            if (r48 != null) goto L50;
        L52:
            String r49 = "2";
        L53:
            r0.put("webcast_gps_access", r49);     // Catch: Throwable -> L160
            goto L54
        L50:
            if (r48.isProviderEnabled("gps") != true) goto L52;
            r49 = String.valueOf(r45);     // Catch: Throwable -> L160
            goto L53
        L43:
            r47 = null;
            goto L45
        L13:
            r7 = false;
            goto L14
        }

        public final Map<String, Object> c(List<String> r3) {
            Intrinsics.checkNotNullParameter(r3, "keys");
            return new StorageItemDataProvider(com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostAppInfo().getApplicationContext()).a(r3);
        }

        public final Map<String, String> d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "apiKey");
            return MapsKt.emptyMap();
        }

        public final Map e(String r1, String r2) {
            return new HashMap();
        }

        public final Map f(String r1, Map r2) {
            return new HashMap();
        }

        public final void g(Map<String, Object> r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "extraParams");
            Intrinsics.checkNotNullParameter(r7, "apiKey");
            if (r6.containsKey("ec_address_data") == false) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r7, "homepage") == false) goto L7;
        L12:
            int r8 = k93.a.a;
            boolean r2 = true;
            if ("".length() <= 0) goto L15;
            boolean r1 = true;
        L16:
            if (r1 == false) goto L41;
            String r3 = this.a.d();
            if (r3 != null) goto L20;
        L23:
            boolean r4 = true;
        L24:
            if (r4 == false) goto L37;
            IECMallAddressService r5 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
            if (r5 == null) goto L42;
            String r9 = null;
            String r10 = r5.getAddress(null, "");
            if (r10 != null) goto L30;
            return;
        L30:
            if (r10.length() > 0) goto L33;
            r2 = false;
        L33:
            if (r2 == false) goto L35;
            r9 = r10;
        L35:
            if (r9 == null) goto L44;
            this.a.r = r9;
            Unit r11 = Unit.INSTANCE;
            r6.put("ec_address_data", r9);
            return;
        L44:
            return;
        L42:
            return;
        L37:
            r6.put("ec_address_data", r3);
            return;
        L20:
            if (r3.length() == 0) goto L23;
            r4 = false;
            goto L24
        L41:
            return;
        L15:
            r1 = false;
            goto L16
        L7:
            if (Intrinsics.areEqual(r7, "favorite_feed") == true) goto L12;
            if (Intrinsics.areEqual(r7, "popup_get") == true) goto L12;
            if (Intrinsics.areEqual(r7, "homepage_refresh") == true) goto L12;
        }

        public final Map b(String r1, String r2, Map r3) {
            return new HashMap();
        }
    }

    public final class b implements ECHybridNetworkTask.a {
    }

    public final void B() {
        if (this.b.r() != null) goto L6;
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, false, -1, -1, -1, -1, 126);
    L6:
        if (this.w != null) goto L8;
        return;
    L8:
        if (this.b.b != null) goto L24;
        Function1<? super Long, ? extends JSONObject> r1 = this.w;
        if (r1 == null) goto L16;
        Long r3 = this.b.o();
        if (r3 == null) goto L14;
        long r4 = r3.longValue();
    L15:
        JSONObject r70 = (JSONObject) r1.invoke(Long.valueOf(r4));
    L17:
        this.w = null;
        if (r70 != null) goto L21;
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, false, -1, -1, -1, -1, 126);
        return;
    L21:
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2, null, null, null, null, r70, false, -1, -1, -1, -1, 94);
        return;
    L14:
        r4 = -1;
        goto L15
    L16:
        r70 = null;
        goto L17
    }

    public final void H() {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "DataEngineWrapper#resetChunkedState()@" + hashCode());
        this.s = false;
        this.t = null;
    }

    public final void I() {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "DataEngineWrapper#resetPrefetchState()@" + hashCode());
        this.s = false;
        this.t = null;
    }

    public final void J() {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "DataEngineWrapper#resetPrefetchedImages()@" + hashCode() + ", previousSize = " + Integer.valueOf(e().size()));
        this.q = new com.bytedance.android.ec.hybrid.tools.b(((Number) this.l.getValue()).intValue());
    }

    public final String d() {
        if (((Boolean) this.n.getValue()).booleanValue() == true) goto L6;
        return null;
    L6:
        return this.r;
    }

    public final com.bytedance.android.ec.hybrid.tools.b<String> e() {
        com.bytedance.android.ec.hybrid.tools.b<String> r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.android.ec.hybrid.tools.b<String> r1 = new com.bytedance.android.ec.hybrid.tools.b(((Number) this.l.getValue()).intValue());
        this.q = r1;
        return r1;
    }

    public final void n() {
        Integer r1 = this.b.h();
        if (r1 != null) goto L6;
    L8:
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -268435457, -1, -1, -1, 127);
        return;
    L6:
        if (r1.intValue() != 1) goto L8;
    }

    public final void z() {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -262145, -1, -1, 127);
    }

    public DataEngineWrapper() {
        this.b = new y93.a(null, -1);
        this.d = "xtab_toast_info";
        this.e = "video_guide_mall";
        this.g = new ConcurrentHashMap();
        this.h = LazyKt.lazy(DataEngineWrapper$jsonParseOptEnable$2.INSTANCE);
        this.i = LazyKt.lazy(DataEngineWrapper$firstScreenImageOptEnable$2.INSTANCE);
        this.j = LazyKt.lazy(DataEngineWrapper$ioDispatchOptEnable$2.INSTANCE);
        this.k = LazyKt.lazy(DataEngineWrapper$domainConnectConfig$2.INSTANCE);
        this.l = LazyKt.lazy(DataEngineWrapper$prefetchedImageSetMaxSize$2.INSTANCE);
        this.m = LazyKt.lazy(DataEngineWrapper$aiPrefetchExpiredDataReuseStrategy$2.INSTANCE);
        this.n = LazyKt.lazy(DataEngineWrapper$addressDataCacheEnable$2.INSTANCE);
        this.o = LazyKt.lazy(DataEngineWrapper$supportNestedScrollChannel$2.INSTANCE);
        this.p = LazyKt.lazy(DataEngineWrapper$categoryTabConvertConfig$2.INSTANCE);
    }

    public static final String a(DataEngineWrapper r1) {
        Map<String, ? extends Object> r2 = r1.c;
        if (r2 == null) goto L8;
        Object r3 = r2.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r3 == null) goto L8;
        String r4 = r3.toString();
        if (r4 == null) goto L8;
        return r4;
    L8:
        return "";
    }

    public final void A(long r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -524289, -1, -1, 127);
    }

    public final void D(final ECNAMallCardExtra r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        final com.bytedance.android.ec.hybrid.tools.b<String> r0 = e();
        ((Number) kk.d.a(0, new DataEngineWrapper$prefetchIdleImagesFrom$1(r4, r0))).intValue();
    }

    public final int E(final ECNAMallCardExtra r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        final com.bytedance.android.ec.hybrid.tools.b<String> r0 = e();
        if (r0 != null) goto L6;
        return 0;
    L6:
        return ((Number) kk.d.a(0, new DataEngineWrapper$prefetchImagesFrom$2(this, r4, r0))).intValue();
    }

    public final void G(Integer r77) {
        if (this.b.b() == null) goto L5;
        return;
    L5:
        if (r77 == null) goto L7;
        int r1 = r77.intValue();
        this.b = y93.a.a(this.b, Integer.valueOf(r1), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -2, -1, -1, -1, 127);
    L7:
        boolean r2 = com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostUserService().isLogin();
        this.b = y93.a.a(this.b, null, Integer.valueOf(r2 ? 1 : 0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -3, -1, -1, -1, 127);
    }

    public final void K(Map<String, ? extends Object> r76) {
        Intrinsics.checkNotNullParameter(r76, "map");
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r76, null, false, -1, -1, -1, -1, 111);
    }

    public final void L(Function1<? super y93.a, y93.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "operator");
        this.b = (y93.a) r2.invoke(this.b);
    }

    public final void c(int r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1, -129, -1, 127);
    }

    public final void i(long r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -131073, -1, -1, -1, 127);
    }

    public final void j(long r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -134217729, -1, -1, 127);
    }

    public final void k(long r77) {
        y93.a r0 = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r77), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -67108865, -1, -1, -1, 127);
        this.b = r0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        if (r0.A() != null) goto L6;
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r77), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1, -4097, -1, 127);     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void m(long r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -9, -1, -1, 127);
    }

    public final void o(long r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134217729, -1, -1, -1, 127);
    }

    public final void p(long r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -33554433, -1, -1, -1, 127);
    }

    public final void q(long r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -2097153, -1, -1, 127);
    }

    public final void r(long r77) {
        if (this.b.n() == null) goto L5;
        return;
    L5:
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, Long.valueOf(r77), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -2097153, -1, -1, -1, 127);
    }

    public final void t(long r77) {
        if (this.b.p() == null) goto L5;
        return;
    L5:
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, Long.valueOf(r77), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1048577, -1, -1, -1, 127);
    }

    public final void u(long r77) {
        if (this.b.q() == null) goto L5;
        return;
    L5:
        this.b = y93.a.a(this.b, null, null, Long.valueOf(r77), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -513, -1, -1, -1, 127);
    }

    public final void v(int r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, -536870913, -1, -1, -1, 63);
    }

    public final void w(long r77) {
        y93.a r1 = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, Long.valueOf(r77), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1048577, -1, -1, 127);
        this.b = r1;
        if (r1.A() != null) goto L6;
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r77), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1, -4097, -1, 127);
        return;
    }

    public final void x(long r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -8388609, -1, -1, 127);
    }

    public final void y(long r76) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -4194305, -1, -1, 127);
    }

    public final void f(String r3, Map<String, ? extends Object> r4) {
        if (r4 == null) goto L4;
        Map<String, ? extends Object> r5 = MapsKt.toMap(r4);
    L5:
        this.c = r5;
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L8:
        if (this.a == null) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (r3 != null) goto L13;
        r3 = NativeMallGeckoHelper.c();     // Catch: Throwable -> L24
    L13:
        Lazy r0 = ECMallLogUtil.a;     // Catch: Throwable -> L24
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "use config url is ".concat(r3));     // Catch: Throwable -> L24
        if (HybridAppInfoService.p.isLocalTest() == false) goto L18;
        IVerseService r6 = (IVerseService) com.bytedance.android.ec.hybrid.a.f().getService(IVerseService.class);     // Catch: Throwable -> L24
        if (r6 == null) goto L18;
        r6.getMallDebugService();     // Catch: Throwable -> L24
    L18:
        ECHybridDataEngine.a r7 = new ECHybridDataEngine.a();     // Catch: Throwable -> L24
        String r1 = com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostAppInfo().getAppVersionName();     // Catch: Throwable -> L24
        if (r1 != null) goto L21;
        r1 = "";
    L21:
        Intrinsics.checkNotNullParameter(r1, "v");     // Catch: Throwable -> L24
        r7.d = r1;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r3, "path");     // Catch: Throwable -> L24
        r7.a = r3;     // Catch: Throwable -> L24
        a r8 = new a(this);     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r8, "applier");     // Catch: Throwable -> L24
        r7.c = r8;     // Catch: Throwable -> L24
        this.a = r7.a();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public final void g(long r76, String r78) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, Long.valueOf(r76), r78, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -786433, -1, -1, -1, 127);
    }

    public final void h(long r76, Integer r78) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, null, null, null, r78, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1074003969, -1, -1, -1, 127);
    }

    public final void l(long r76, int r78) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r76), Integer.valueOf(r78), null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -49, -1, -1, 127);
    }

    public static void F(final DataEngineWrapper r2, final HomePageDTO r3, final int r4) {
        Intrinsics.checkNotNullParameter(r3, "homepage");
        final boolean r1 = true;
        kk.d.c(new DataEngineWrapper$prefetchImagesFrom$1(r2, r4, r3, r1));
    }

    public final void s(long r76, Integer r78, String r79) {
        this.b = y93.a.a(this.b, null, null, null, null, null, null, null, null, null, Long.valueOf(r76), null, null, null, null, null, null, null, null, r78, r79, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 1071644671, -1, -1, -1, 127);
    }

    public static void C(DataEngineWrapper r2, HomePageDTO r3, boolean r4, int r5) {
        if ((r5 & 2) == 0) goto L5;
        r4 = true;
    L5:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "homepage");
        if (r.a.c() != 0) goto L9;
        kk.d.c(new DataEngineWrapper$prefetchImageInner$1(r2, r3, null, r4));
        return;
    L9:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
        ThreadPoolHelper.c().submit(new e(r2, r3, r4, null));
        return;
    L11:
        kk.d.c(new DataEngineWrapper$prefetchImageInner$1(r2, r3, null, r4));
    }

    public static final void b(DataEngineWrapper r0, JSONObject r1, String r2, String r3) {
        r0.getClass();
        r1.put(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        Logger.d("puffone-DataEngineWrapper.insertToJson()", "err");
    }
}
