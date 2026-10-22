package com.larus.video.impl.sdk.prefetch;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.platform.api.w4;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f375904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f375905b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f375906c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f375907d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, g> f375908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ConcurrentHashMap<String, c> f375909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ConcurrentHashMap<String, w4> f375910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ConcurrentHashMap<String, g> f375911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f375912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ConcurrentHashMap<String, d> f375913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f375914k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f375915l = null;

    static {
        f375904a = LazyKt.lazy(new m0());
        f375905b = LazyKt.lazy(new n0());
        f375906c = LazyKt.lazy(new o0());
        f375907d = LazyKt.lazy(new p0());
        f375914k = LazyKt.lazy(new q0());
        f375915l = LazyKt.lazy(new r0());
    }

    public static ConcurrentHashMap a() {
        if (f375908e != null) goto L12;
        String r100 = h().getString("preload_item_ids_refine", "");
        h r101 = (h) g().fromJson(r100, h.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new h(0);     // Catch: Exception -> L9
    L10:
        f375908e = r101.f375867a;
    L9:
        r101 = new h(0);
    L12:
        return f375908e;
    }

    public static ConcurrentHashMap b() {
        if (f375912i != null) goto L12;
        String r100 = h().getString("user_first_bind_preload_refine", "");
        b r101 = (b) g().fromJson(r100, b.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new b(0);     // Catch: Exception -> L9
    L10:
        f375912i = r101.f375848a;
    L9:
        r101 = new b(0);
    L12:
        return f375912i;
    }

    public static ConcurrentHashMap c() {
        if (f375913j != null) goto L12;
        String r100 = h().getString("user_first_screen_data_refine", "");
        e r101 = (e) g().fromJson(r100, e.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new e(0);     // Catch: Exception -> L9
    L10:
        f375913j = r101.f375854a;
    L9:
        r101 = new e(0);
    L12:
        return f375913j;
    }

    public static ConcurrentHashMap d() {
        if (f375909f != null) goto L12;
        String r100 = h().getString("user_is_first_click_message_video_refine", "");
        j r101 = (j) g().fromJson(r100, j.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new j(0);     // Catch: Exception -> L9
    L10:
        f375909f = r101.f375883a;
    L9:
        r101 = new j(0);
    L12:
        return f375909f;
    }

    public static int e() {
        return ((Number) f375915l.getValue()).intValue();
    }

    public static Gson g() {
        return (Gson) f375904a.getValue();
    }

    public static Keva h() {
        return (Keva) f375905b.getValue();
    }

    public static int i() {
        return ((Number) f375914k.getValue()).intValue();
    }

    public static ConcurrentHashMap j() {
        if (f375910g != null) goto L12;
        String r100 = h().getString("user_preload_error_reason_refine", "");
        f r101 = (f) g().fromJson(r100, f.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new f(0);     // Catch: Exception -> L9
    L10:
        f375910g = r101.f375856a;
    L9:
        r101 = new f(0);
    L12:
        return f375910g;
    }

    public static void p() {
        ConcurrentHashMap r100 = d();
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.size();
    L6:
        String r103 = null;
        if (r102 <= i()) goto L28;
        if (r100 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        ConcurrentHashMap r105 = null;
    L26:
        if (r105 == null) goto L28;
        m(r105);
        goto L28
    L16:
        List r106 = CollectionsKt.sortedWith(r100.entrySet(), new u0());
        List r107 = CollectionsKt.take(r106, e());
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L18:
        if (r109.hasNext() == false) goto L20;
        r108.add((String) ((Map.Entry) r109.next()).getKey());
        goto L18
    L20:
        Set r110 = CollectionsKt.toSet(r108);
        r105 = new ConcurrentHashMap();
        Iterator r111 = r106.iterator();
    L22:
        if (r111.hasNext() == false) goto L26;
        Map.Entry r112 = (Map.Entry) r111.next();
        if (r110.contains(r112.getKey()) == false) goto L22;
        r105.put(r112.getKey(), r112.getValue());
        goto L22
    L10:
        if (r100.isEmpty() == true) goto L13;
        r104 = false;
    L28:
        ConcurrentHashMap r113 = j();
        if (r113 == null) goto L31;
        int r114 = r113.size();
    L33:
        if (r114 <= i()) goto L54;
        if (r113 != null) goto L36;
    L39:
        boolean r115 = true;
    L40:
        if (r115 == false) goto L42;
        ConcurrentHashMap r116 = null;
    L52:
        if (r116 == null) goto L54;
        n(r116);
        goto L54
    L42:
        List r117 = CollectionsKt.sortedWith(r113.entrySet(), new v0());
        List r118 = CollectionsKt.take(r117, e());
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r120 = r118.iterator();
    L44:
        if (r120.hasNext() == false) goto L46;
        r119.add((String) ((Map.Entry) r120.next()).getKey());
        goto L44
    L46:
        Set r121 = CollectionsKt.toSet(r119);
        r116 = new ConcurrentHashMap();
        Iterator r122 = r117.iterator();
    L48:
        if (r122.hasNext() == false) goto L52;
        Map.Entry r123 = (Map.Entry) r122.next();
        if (r121.contains(r123.getKey()) == false) goto L48;
        r116.put(r123.getKey(), r123.getValue());
        goto L48
    L36:
        if (r113.isEmpty() == true) goto L39;
        r115 = false;
    L54:
        ConcurrentHashMap r124 = b();
        if (r124 == null) goto L57;
        int r125 = r124.size();
    L59:
        if (r125 <= i()) goto L80;
        if (r124 != null) goto L62;
    L65:
        boolean r126 = true;
    L66:
        if (r126 == false) goto L68;
        ConcurrentHashMap r127 = null;
    L78:
        if (r127 == null) goto L80;
        l(r127);
        goto L80
    L68:
        List r128 = CollectionsKt.take(CollectionsKt.sortedWith(r124.entrySet(), new t0()), e());
        ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r128, 10));
        Iterator r130 = r128.iterator();
    L70:
        if (r130.hasNext() == false) goto L72;
        r129.add((String) ((Map.Entry) r130.next()).getKey());
        goto L70
    L72:
        r127 = new ConcurrentHashMap();
        Iterator r131 = r124.entrySet().iterator();
    L74:
        if (r131.hasNext() == false) goto L78;
        Map.Entry r132 = (Map.Entry) r131.next();
        String r133 = (String) r132.getKey();
        a r134 = (a) r132.getValue();
        if (r129.contains(r133) == false) goto L74;
        r127.put(r133, r134);
        goto L74
    L62:
        if (r124.isEmpty() == true) goto L65;
        r126 = false;
    L80:
        FLogger r135 = FLogger.f375446a;
        r135.i("RelatedVideoFlowCacheItemsListManager_Cache", "tryClearAllCache, clearExceedMaxSaveItemCountCache");
        ConcurrentHashMap r136 = a();
        StringBuilder r137 = new StringBuilder("clearExceedMaxSaveItemCountCache, map.size: ");
        if (r136 == null) goto L83;
        Integer r138 = Integer.valueOf(r136.size());
    L84:
        r137.append(r138);
        r137.append("===MAX_SAVE_ITEM_COUNT:");
        r137.append(i());
        r135.i("RelatedVideoFlowCacheItemsListManager_Cache", r137.toString());
        if (r136 == null) goto L87;
        int r139 = r136.size();
    L89:
        if (r139 <= i()) goto L141;
        if (r136 != null) goto L92;
    L93:
        r101 = true;
    L94:
        if (r101 == false) goto L96;
        ConcurrentHashMap<String, g> r140 = null;
    L106:
        f375908e = r140;
        if (r140 != null) goto L109;
        ConcurrentHashMap<String, g> r141 = new ConcurrentHashMap();
    L110:
        String r142 = GsonProtectorUtils.toJson(g(), new h(r141), h.class);
        FLogger r143 = FLogger.f375446a;
        StringBuilder r144 = new StringBuilder("saveCachedPreloadItemIdsDataMap, kyes: ");
        if (r140 == null) goto L115;
        Set<String> r145 = r140.keySet();
        if (r145 == null) goto L115;
        r103 = CollectionsKt.joinToString$default(r145, null, null, null, 0, null, null, 63, null);
    L115:
        r144.append(r103);
        r143.i("RelatedVideoFlowCacheItemsListManager_Cache", r144.toString());
        h().storeString("preload_item_ids_refine", r142);
        return;
    L109:
        r141 = r140;
        goto L110
    L96:
        List r146 = CollectionsKt.take(CollectionsKt.sortedWith(r136.entrySet(), new s0()), e());
        ArrayList r147 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r146, 10));
        Iterator r148 = r146.iterator();
    L98:
        if (r148.hasNext() == false) goto L100;
        r147.add((String) ((Map.Entry) r148.next()).getKey());
        goto L98
    L100:
        FLogger.f375446a.i("RelatedVideoFlowCacheItemsListManager_Cache", "trimCachedPreloadItemIdsDataMap, reserve keys: " + r147);
        r140 = new ConcurrentHashMap();
        Iterator r149 = r136.entrySet().iterator();
    L102:
        if (r149.hasNext() == false) goto L106;
        Map.Entry r150 = (Map.Entry) r149.next();
        String r151 = (String) r150.getKey();
        g r152 = (g) r150.getValue();
        if (r147.contains(r151) == false) goto L102;
        r140.put(r151, r152);
        goto L102
    L92:
        if (r136.isEmpty() == false) goto L94;
    L141:
        return;
    L87:
        r139 = 0;
        goto L89
    L83:
        r138 = null;
        goto L84
    L57:
        r125 = 0;
        goto L59
    L31:
        r114 = 0;
        goto L33
    L5:
        r102 = 0;
        goto L6
    }

    public static void k(g r100) {
        Intrinsics.checkNotNullParameter(r100, "cachedPreloadItemIdsData");
        ConcurrentHashMap r101 = a();
        if (r101 == null) goto L6;
        g r102 = (g) r101.put(f(r100.f375858a, r100.f375864g), r100);
    L6:
        if (r101 != null) goto L8;
        r101 = new ConcurrentHashMap();
    L8:
        h r103 = new h(r101);
        String r104 = GsonProtectorUtils.toJson(g(), r103, h.class);
        h().storeString("preload_item_ids_refine", r104);
    }

    public static void l(ConcurrentHashMap r100) {
        b r101 = new b(r100);
        String r102 = GsonProtectorUtils.toJson(g(), r101, b.class);
        h().storeString("user_first_bind_preload_refine", r102);
    }

    public static void m(ConcurrentHashMap r100) {
        if (r100 != null) goto L5;
        r100 = new ConcurrentHashMap();
    L5:
        j r101 = new j(r100);
        String r102 = GsonProtectorUtils.toJson(g(), r101, j.class);
        h().storeString("user_is_first_click_message_video_refine", r102);
    }

    public static void n(ConcurrentHashMap r100) {
        f r101 = new f(r100);
        String r102 = GsonProtectorUtils.toJson(g(), r101, f.class);
        h().storeString("user_preload_error_reason_refine", r102);
    }

    public static String f(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append('_');
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        r102.append(r103);
        return r102.toString();
    L5:
        r103 = null;
        goto L6
    }

    public static void o(String r100, w4 r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "reason");
        ConcurrentHashMap r102 = j();
        if (r102 == null) goto L5;
        w4 r103 = (w4) r102.put(r100, r101);
    L5:
        if (r102 == null) goto L8;
        n(r102);
        return;
    }
}
