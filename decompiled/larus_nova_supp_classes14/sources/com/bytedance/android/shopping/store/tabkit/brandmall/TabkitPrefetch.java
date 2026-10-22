package com.bytedance.android.shopping.store.tabkit.brandmall;

import bolts.Task;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchUtil;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.h0;
import com.bytedance.android.ec.host.api.hybrid.ForestPreloadType;
import com.bytedance.android.ec.host.api.hybrid.IECForestHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.utils.h;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.utils.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import pd.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TabkitPrefetch {
    public static final Map<String, Long> a = null;
    public static final Lazy b = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/brandmall/TabkitPrefetch$a;", "", "", "Lcom/bytedance/android/shopping/store/tabkit/model/s;", "geckoPrefetch", "Ljava/util/List;", "a", "()Ljava/util/List;", "", "preConnectHost", "b", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("gecko_prefetch")
        private final List<s> geckoPrefetch;

        @SerializedName("preconnect_host")
        private final List<String> preConnectHost;

        public a() {
        }

        public final List<s> a() {
            return this.geckoPrefetch;
        }

        public final List<String> b() {
            return this.preConnectHost;
        }
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final Unit call() {
            int r0 = ECSdk.a;
            IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r1 == null) goto L7;
            e r2 = r1.getIExternaHybridService();
            if (r2 == null) goto L7;
            r2.initAnnie();
        L7:
            Map<String, Long> r3 = TabkitPrefetch.a;
            Map r4 = (Map) TabkitPrefetch.b.getValue();
            if (r4 == null) goto L25;
            a r5 = (a) r4.get(this.a);
            if (r5 == null) goto L25;
            List<s> r6 = r5.a();
            if (r6 == null) goto L25;
            Iterator<T> r7 = r6.iterator();
        L15:
            if (r7.hasNext() == false) goto L30;
            s r8 = (s) r7.next();
            ECLiveHybridUtil.a r9 = ECLiveHybridUtil.a;
            String r10 = r8.b();
            Integer r11 = r8.c();
            if (r11 != null) goto L20;
        L22:
            boolean r12 = false;
        L23:
            ECLiveHybridUtil.l(r10, r12);
            goto L15
        L20:
            if (r11.intValue() != 2) goto L22;
            r12 = true;
            goto L23
        L30:
            return Unit.INSTANCE;
        L25:
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public TabkitPrefetch() {
    }

    static {
        a = new LinkedHashMap();
        b = LazyKt.lazy(TabkitPrefetch$tabCacheConfig$2.INSTANCE);
    }

    public static void c(String r7) {
        Map r0 = (Map) b.getValue();
        if (r0 == null) goto L14;
        a r8 = (a) r0.get(r7);
        if (r8 == null) goto L20;
        List<String> r9 = r8.b();
        if (r9 == null) goto L21;
        Iterator<T> r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L22;
        String r1 = (String) r10.next();
        long r2 = System.currentTimeMillis();
        Map<String, Long> r3 = a;
        if ((r2 - k.h((Long) ((LinkedHashMap) r3).get(r1))) <= 90000) goto L10;
        r3.put(r1, Long.valueOf(System.currentTimeMillis()));
        h0.a(r1);
        goto L10
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public static void b(TabKitRouterParams r13, boolean r14, boolean r15) {
        String r0 = r13.getBizTag();
        int r1 = h.a;
        if (hk3.e.a() == 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L9;
    L29:
        if (r14 == false) goto L230;
        String r16 = r13.getAnchorUrl();
        Object r3 = null;
        if (r16 == null) goto L33;
        String r6 = n.b(r16);
    L34:
        if (r6 != null) goto L36;
    L39:
        boolean r17 = true;
    L40:
        if (r17 == false) goto L42;
    L44:
        boolean r18 = false;
    L45:
        if (r18 == false) goto L230;
        ForestPreloadType r10 = ForestPreloadType.LYNX;
        if (r6 != null) goto L49;
    L52:
        boolean r19 = true;
    L53:
        if (r19 == true) goto L230;
        int r110 = ECSdk.a;
        IECHostService r111 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r111 == null) goto L230;
        IECForestHostService r5 = r111.getECForestHostService();
        if (r5 == null) goto L230;
        int r112 = hk3.a.a;
        int r113 = com.bytedance.android.ec.base.settings.a.a;
        Object r114 = 120;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L217
        Object r8 = d.c.get("ec_tabkit_forest_max_age_default");     // Catch: Throwable -> L111
        if (r8 != null) goto L66;
    L108:
        Object r9 = null;
    L109:
        Object r11 = Result.constructor-impl(r9);     // Catch: Throwable -> L111
    L113:
        Throwable r12 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L217
        if (r12 == null) goto L117;
        EnsureManager.ensureNotReachHere(r12);     // Catch: Throwable -> L217
    L117:
        if (Result.isFailure-impl(r11) == false) goto L120;
        r11 = null;
    L120:
        if ((r11 instanceof Integer) == true) goto L122;
        r11 = null;
    L122:
        Object r20 = (Integer) r11;     // Catch: Throwable -> L217
        if (r20 != null) goto L129;
        Object r21 = d.a.get("ec_tabkit_forest_max_age_default");     // Catch: Throwable -> L217
        if ((r21 instanceof Integer) == true) goto L128;
        r21 = null;
    L128:
        r20 = (Integer) r21;     // Catch: Throwable -> L217
    L129:
        if (r20 != null) goto L226;
        int r22 = c.a;     // Catch: Throwable -> L217
        Object r23 = d.c.get("ec_tabkit_forest_max_age_default");     // Catch: Throwable -> L181
        if (r23 != null) goto L136;
    L178:
        Object r24 = null;
    L179:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L181
    L183:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L207
        if (r26 == null) goto L187;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L207
    L187:
        if (Result.isFailure-impl(r25) == false) goto L190;
        r25 = null;
    L190:
        if ((r25 instanceof Integer) == true) goto L192;
        r25 = null;
    L192:
        r20 = (Integer) r25;     // Catch: Throwable -> L207
        if (r20 != null) goto L215;
        IHybridHostService r27 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L207
        if (r27 == null) goto L198;
        Object r28 = r27.getHostABValue("ec_tabkit_forest_max_age_default", r114);     // Catch: Throwable -> L207
    L199:
        if (r28 != null) goto L201;
    L206:
        r20 = r114;
        goto L215
    L201:
        if ((r28 instanceof Integer) == false) goto L204;
        r3 = r28;
    L204:
        Object r4 = (Integer) r3;     // Catch: Throwable -> L207
        if (r4 == null) goto L206;
    L214:
        r20 = r4;
        goto L215
    L198:
        r28 = null;
    L215:
        d.d("ec_tabkit_forest_max_age_default", r20);     // Catch: Throwable -> L217
        goto L226
    L136:
        if ((r23 instanceof Integer) == true) goto L138;
        Object r29 = null;
    L139:
        r24 = (Integer) r29;     // Catch: Throwable -> L181
        if (r24 != null) goto L179;
        if ((r23 instanceof Number) == false) goto L166;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L151;
        Float r30 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L181
        if ((r30 instanceof Integer) == true) goto L149;
        r30 = null;
    L149:
        r24 = (Integer) r30;     // Catch: Throwable -> L181
        goto L179
    L151:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L157;
        Double r31 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L181
        if ((r31 instanceof Integer) == true) goto L155;
        r31 = null;
    L155:
        r24 = (Integer) r31;     // Catch: Throwable -> L181
        goto L179
    L157:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L160;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L181
        goto L179
    L160:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L166;
        Long r32 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L181
        if ((r32 instanceof Integer) == true) goto L164;
        r32 = null;
    L164:
        r24 = (Integer) r32;     // Catch: Throwable -> L181
    L166:
        if ((r23 instanceof JSONObject) == false) goto L168;
    L260:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        Object r33 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L174
        if ((r33 instanceof Integer) == true) goto L172;
        r33 = null;
    L172:
        Object r34 = Result.constructor-impl((Integer) r33);     // Catch: Throwable -> L174
    L176:
        r24 = r34;
        if (Result.isFailure-impl(r24) == false) goto L179;
    L174:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L181
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L181
        goto L176
    L168:
        if ((r23 instanceof JSONArray) == false) goto L178;
    L138:
        r29 = r23;
    L207:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L217
        r4 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L217
        Throwable r37 = Result.exceptionOrNull-impl(r4);     // Catch: Throwable -> L217
        if (r37 == null) goto L212;
        EnsureManager.ensureNotReachHere(r37);     // Catch: Throwable -> L217
    L212:
        if (Result.isFailure-impl(r4) == false) goto L214;
        r4 = r114;
    L181:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L207
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L207
    L226:
        int r115 = ((Number) r20).intValue();
        if (r10 != ForestPreloadType.LYNX) goto L229;
        r5.preloadWithProcessor(r6, null, "tabkit", null, r10, Integer.valueOf(r115), true);
        goto L230
    L229:
        r5.preload(r6, null, "tabkit", null, r10, Integer.valueOf(r115), true);
        goto L230
    L66:
        if ((r8 instanceof Integer) == true) goto L68;
        Object r39 = null;
    L69:
        r9 = (Integer) r39;     // Catch: Throwable -> L111
        if (r9 != null) goto L109;
        if ((r8 instanceof Number) == false) goto L96;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L81;
        Float r40 = Float.valueOf(((Number) r8).floatValue());     // Catch: Throwable -> L111
        if ((r40 instanceof Integer) == true) goto L79;
        r40 = null;
    L79:
        r9 = (Integer) r40;     // Catch: Throwable -> L111
        goto L109
    L81:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L87;
        Double r41 = Double.valueOf(((Number) r8).doubleValue());     // Catch: Throwable -> L111
        if ((r41 instanceof Integer) == true) goto L85;
        r41 = null;
    L85:
        r9 = (Integer) r41;     // Catch: Throwable -> L111
        goto L109
    L87:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L90;
        r9 = Integer.valueOf(((Number) r8).intValue());     // Catch: Throwable -> L111
        goto L109
    L90:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L96;
        Long r42 = Long.valueOf(((Number) r8).longValue());     // Catch: Throwable -> L111
        if ((r42 instanceof Integer) == true) goto L94;
        r42 = null;
    L94:
        r9 = (Integer) r42;     // Catch: Throwable -> L111
    L96:
        if ((r8 instanceof JSONObject) == false) goto L98;
    L258:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L104
        Object r43 = SDKSettingsCacheManager.a().fromJson(r8.toString(), Integer.class);     // Catch: Throwable -> L104
        if ((r43 instanceof Integer) == true) goto L102;
        r43 = null;
    L102:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L104
    L106:
        r9 = r44;
        if (Result.isFailure-impl(r9) == false) goto L109;
    L104:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L111
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L111
        goto L106
    L98:
        if ((r8 instanceof JSONArray) == false) goto L108;
    L68:
        r39 = r8;
    L111:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L217
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L217
    L217:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r116 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r116);
        if (r48 == null) goto L222;
        EnsureManager.ensureNotReachHere(r48);
    L222:
        if (Result.isFailure-impl(r116) == true) goto L225;
        r114 = r116;
    L225:
        r20 = r114;
        goto L226
    L49:
        if (StringsKt.isBlank(r6) == true) goto L52;
        r19 = false;
        goto L53
    L42:
        if (Intrinsics.areEqual(r13.getAnchorUrlType(), "lynx") == false) goto L44;
        r18 = true;
        goto L45
    L36:
        if (StringsKt.isBlank(r6) == true) goto L39;
        r17 = false;
        goto L40
    L33:
        r6 = null;
    L230:
        if (r15 == false) goto L232;
        return;
    L232:
        if (r0 != null) goto L234;
    L237:
        boolean r117 = true;
    L238:
        if (r117 == false) goto L240;
        return;
    L240:
        Map r118 = (Map) b.getValue();
        if (r118 == null) goto L257;
        a r119 = (a) r118.get(r0);
        if (r119 == null) goto L272;
        List<s> r120 = r119.a();
        if (r120 == null) goto L273;
        Iterator<T> r121 = r120.iterator();
    L248:
        if (r121.hasNext() == false) goto L274;
        s r122 = (s) r121.next();
        ECLiveHybridUtil.a r123 = ECLiveHybridUtil.a;
        String r124 = r122.b();
        Integer r125 = r122.c();
        if (r125 != null) goto L253;
    L255:
        boolean r126 = false;
    L256:
        ECLiveHybridUtil.l(r124, r126);
        goto L248
    L253:
        if (r125.intValue() != 2) goto L255;
        r126 = true;
        goto L256
    L274:
        return;
    L273:
        return;
    L272:
        return;
    L257:
        return;
    L234:
        if (r0.length() == 0) goto L237;
        r117 = false;
        goto L238
    L9:
        if (hk3.e.a() <= 3) goto L11;
        boolean r49 = true;
    L12:
        if (r49 == true) goto L29;
        if (hk3.e.a() <= 2) goto L16;
        boolean r50 = true;
    L17:
        if (r50 == false) goto L19;
        Task.callInBackground(new b(r0));
        goto L29
    L19:
        ECLiveHybridUtil.a r51 = ECLiveHybridUtil.a;
        int r52 = ECSdk.a;
        IAdapterService r53 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r53 == null) goto L26;
        e r54 = r53.getIExternaHybridService();
        if (r54 == null) goto L26;
        if (r54.isAnnieInit() != true) goto L26;
        boolean r55 = true;
    L27:
        if (r55 == true) goto L29;
        return;
    L26:
        r55 = false;
        goto L27
    L16:
        r50 = false;
        goto L17
    L11:
        r49 = false;
        goto L12
    L5:
        r2 = false;
        goto L7
    }

    public static pk3.a a(String r9, boolean r10, String r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r14 & 8) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r14 & 16) == 0) goto L13;
        boolean r6 = false;
    L14:
        Intrinsics.checkNotNullParameter(r9, "url");
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L24
        String r16 = UriProtector.getQueryParameter(UriProtector.parse(r9), "ec_request_id");     // Catch: Throwable -> L24
        if (r16 != null) goto L18;
    L21:
        boolean r17 = true;
    L22:
        Object r18 = Result.constructor-impl(Boolean.valueOf(r17));     // Catch: Throwable -> L24
    L26:
        Boolean r19 = Boolean.TRUE;
        if (Result.isFailure-impl(r18) == false) goto L30;
        r18 = r19;
    L30:
        if (((Boolean) r18).booleanValue() == false) goto L46;
        ConcurrentHashMap r110 = NativePrefetchUtil.a;
        if (NativePrefetchUtil.b(r9, false, 6) == false) goto L46;
        if (r10 == true) goto L50;
        HashMap r111 = NativePrefetchUtil.p(r9, new JSONObject(), r4);
        StringBuilder r112 = new StringBuilder(r9);
        if (r111 == null) goto L51;
        Set r20 = r111.keySet();
        if (r20 == null) goto L51;
        Iterator r21 = r20.iterator();
    L42:
        if (r21.hasNext() == false) goto L51;
        String r113 = (String) r21.next();
        r112.append("&" + r113 + '=' + ((String) r111.get(r113)));
    L51:
        return new pk3.a(r112.toString(), r111);
    L50:
        return new pk3.a(NativePrefetchUtil.m(r9, new JSONObject(), r4, r5, r6, false, null), null);
    L46:
        return new pk3.a(r9, null);
    L18:
        if (r16.length() == 0) goto L21;
        r17 = false;
    L24:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L13:
        r6 = r13;
        goto L14
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }
}
