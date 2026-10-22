package com.larus.video.impl.sdk.prefetch;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.PrefetchVideoProcessStage;
import com.larus.platform.api.w4;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f375872a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f375873b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f375874c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f375875d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, g> f375876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ConcurrentHashMap<String, c> f375877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ConcurrentHashMap<String, i> f375878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ConcurrentHashMap<String, w4> f375879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f375880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f375881j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f375882k = null;

    static {
        f375872a = LazyKt.lazy(new x0());
        f375873b = LazyKt.lazy(new y0());
        f375874c = LazyKt.lazy(new z0());
        f375875d = LazyKt.lazy(new a1());
        f375881j = LazyKt.lazy(new b1());
        f375882k = LazyKt.lazy(new c1());
    }

    public static ConcurrentHashMap a() {
        if (f375876e != null) goto L12;
        String r100 = h().getString("preload_item_ids_refine", "");
        h r101 = (h) g().fromJson(r100, h.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new h(0);     // Catch: Exception -> L9
    L10:
        f375876e = r101.f375867a;
    L9:
        r101 = new h(0);
    L12:
        return f375876e;
    }

    public static ConcurrentHashMap b() {
        if (f375880i != null) goto L12;
        String r100 = h().getString("user_first_bind_preload_refine", "");
        b r101 = (b) g().fromJson(r100, b.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new b(0);     // Catch: Exception -> L9
    L10:
        f375880i = r101.f375848a;
    L9:
        r101 = new b(0);
    L12:
        return f375880i;
    }

    public static ConcurrentHashMap c() {
        if (f375877f != null) goto L12;
        String r100 = h().getString("user_is_first_click_message_video_refine", "");
        j r101 = (j) g().fromJson(r100, j.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new j(0);     // Catch: Exception -> L9
    L10:
        f375877f = r101.f375883a;
    L9:
        r101 = new j(0);
    L12:
        return f375877f;
    }

    public static int d() {
        return ((Number) f375882k.getValue()).intValue();
    }

    public static ConcurrentHashMap e() {
        if (f375878g != null) goto L12;
        String r100 = h().getString("user_refresh_count_refine", "");
        k r101 = (k) g().fromJson(r100, k.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new k(0);     // Catch: Exception -> L9
    L10:
        f375878g = r101.f375884a;
    L9:
        r101 = new k(0);
    L12:
        return f375878g;
    }

    public static Gson g() {
        return (Gson) f375872a.getValue();
    }

    public static Keva h() {
        return (Keva) f375873b.getValue();
    }

    public static int i() {
        return ((Number) f375881j.getValue()).intValue();
    }

    public static ConcurrentHashMap j() {
        if (f375879h != null) goto L12;
        String r100 = h().getString("user_preload_error_reason_refine", "");
        f r101 = (f) g().fromJson(r100, f.class);     // Catch: Exception -> L9
        if (r101 != null) goto L10;
        r101 = new f(0);     // Catch: Exception -> L9
    L10:
        f375879h = r101.f375856a;
    L9:
        r101 = new f(0);
    L12:
        return f375879h;
    }

    public static g f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        ConcurrentHashMap r101 = a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (g) r101.get(r100);
    }

    public static void k(g r100) {
        Intrinsics.checkNotNullParameter(r100, "cachedPreloadItemIdsData");
        ConcurrentHashMap r101 = a();
        if (r101 == null) goto L5;
        g r102 = (g) r101.put(r100.f375858a, r100);
    L5:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("putCacheVideoData, messageId: ");
        r104.append(r100.f375858a);
        r104.append("===success===currentSize:");
        if (r101 == null) goto L8;
        Integer r105 = Integer.valueOf(r101.size());
    L9:
        r104.append(r105);
        r103.i("InnerVideoListPreloadManager_Cache", r104.toString());
        if (r101 != null) goto L12;
        r101 = new ConcurrentHashMap();
    L12:
        h r106 = new h(r101);
        String r107 = GsonProtectorUtils.toJson(g(), r106, h.class);
        h().storeString("preload_item_ids_refine", r107);
        return;
    L8:
        r105 = null;
        goto L9
    }

    public static void l(ConcurrentHashMap r100) {
        if (r100 != null) goto L5;
        r100 = new ConcurrentHashMap();
    L5:
        k r101 = new k(r100);
        String r102 = GsonProtectorUtils.toJson(g(), r101, k.class);
        h().storeString("user_refresh_count_refine", r102);
    }

    public static void m(ConcurrentHashMap r110) {
        if (r110 != null) goto L5;
        ConcurrentHashMap r100 = new ConcurrentHashMap();
    L6:
        h r101 = new h(r100);
        String r102 = GsonProtectorUtils.toJson(g(), r101, h.class);
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("saveCachedPreloadItemIdsDataMap, kyes: ");
        if (r110 == null) goto L11;
        Set r111 = r110.keySet();
        if (r111 == null) goto L11;
        String r112 = CollectionsKt.joinToString$default(r111, null, null, null, 0, null, null, 63, null);
    L12:
        r104.append(r112);
        r103.i("InnerVideoListPreloadManager_Cache", r104.toString());
        h().storeString("preload_item_ids_refine", r102);
        return;
    L11:
        r112 = null;
        goto L12
    L5:
        r100 = r110;
        goto L6
    }

    public static void n(ConcurrentHashMap r100) {
        b r101 = new b(r100);
        String r102 = GsonProtectorUtils.toJson(g(), r101, b.class);
        h().storeString("user_first_bind_preload_refine", r102);
    }

    public static void o(ConcurrentHashMap r100) {
        if (r100 != null) goto L5;
        r100 = new ConcurrentHashMap();
    L5:
        j r101 = new j(r100);
        String r102 = GsonProtectorUtils.toJson(g(), r101, j.class);
        h().storeString("user_is_first_click_message_video_refine", r102);
    }

    public static void p(ConcurrentHashMap r100) {
        if (r100 != null) goto L5;
        r100 = new ConcurrentHashMap();
    L5:
        f r101 = new f(r100);
        String r102 = GsonProtectorUtils.toJson(g(), r101, f.class);
        h().storeString("user_preload_error_reason_refine", r102);
    }

    public static void r(String r110) {
        FLogger.f375446a.i("InnerVideoListPreloadManager_Cache", "tryClearAllCache, lastMessageId: " + r110);
        ConcurrentHashMap<String, g> r100 = a();
        ConcurrentHashMap<String, g> r101 = null;
        boolean r102 = true;
        if (r100 == null) goto L14;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, g>> r104 = r100.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        Map.Entry<String, g> r105 = r104.next();
        if (Math.abs(AppHost.f326268a.getAppClock().currentTimeMillis() - r105.getValue().f375861d) <= ((Number) f375875d.getValue()).intValue()) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L6;
        r103.put(r105.getKey(), r105.getValue());
        goto L6
    L10:
        r106 = false;
        goto L11
    L13:
        Set r107 = r103.keySet();
    L15:
        if (r107 != null) goto L17;
        Set r108 = SetsKt.emptySet();
    L19:
        if (r108.isEmpty() == true) goto L28;
        ConcurrentHashMap r109 = j();
        Iterator r111 = r108.iterator();
    L23:
        if (r111.hasNext() == false) goto L27;
        String r112 = (String) r111.next();
        if (r109 == null) goto L23;
        r109.put(r112, new w4(PrefetchVideoProcessStage.EXPIRATION_PROCESS.getValue(), AppHost.f326268a.getAppClock().currentTimeMillis(), 0));
        goto L23
    L27:
        p(r109);
    L28:
        if (r107 == null) goto L35;
        Iterator r113 = r107.iterator();
        boolean r114 = false;
    L31:
        if (r113.hasNext() == false) goto L36;
        String r115 = (String) r113.next();
        if (Intrinsics.areEqual(r115, r110) == false) goto L31;
        r100.remove(r115);
        FLogger.f375446a.i("InnerVideoListPreloadManager_Cache", "clearExpireCache, remove key: " + r115);
        r114 = true;
    L36:
        if (r114 == false) goto L38;
        f375876e = r100;
        m(r100);
    L38:
        ConcurrentHashMap r116 = c();
        if (r116 == null) goto L41;
        int r117 = r116.size();
    L43:
        if (r117 <= i()) goto L64;
        if (r116 != null) goto L46;
    L49:
        boolean r118 = true;
    L50:
        if (r118 == false) goto L52;
        ConcurrentHashMap r119 = null;
    L62:
        if (r119 == null) goto L64;
        o(r119);
        goto L64
    L52:
        List r120 = CollectionsKt.sortedWith(r116.entrySet(), new f1());
        List r121 = CollectionsKt.take(r120, d());
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator r123 = r121.iterator();
    L54:
        if (r123.hasNext() == false) goto L56;
        r122.add((String) ((Map.Entry) r123.next()).getKey());
        goto L54
    L56:
        Set r124 = CollectionsKt.toSet(r122);
        r119 = new ConcurrentHashMap();
        Iterator r125 = r120.iterator();
    L58:
        if (r125.hasNext() == false) goto L62;
        Map.Entry r126 = (Map.Entry) r125.next();
        if (r124.contains(r126.getKey()) == false) goto L58;
        r119.put(r126.getKey(), r126.getValue());
        goto L58
    L46:
        if (r116.isEmpty() == true) goto L49;
        r118 = false;
    L64:
        ConcurrentHashMap r127 = e();
        if (r127 == null) goto L67;
        int r128 = r127.size();
    L69:
        if (r128 <= i()) goto L90;
        if (r127 != null) goto L72;
    L75:
        boolean r129 = true;
    L76:
        if (r129 == false) goto L78;
        ConcurrentHashMap r130 = null;
    L88:
        if (r130 == null) goto L90;
        l(r130);
        goto L90
    L78:
        List r131 = CollectionsKt.sortedWith(r127.entrySet(), new h1());
        List r132 = CollectionsKt.take(r131, d());
        ArrayList r133 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r132, 10));
        Iterator r134 = r132.iterator();
    L80:
        if (r134.hasNext() == false) goto L82;
        r133.add((String) ((Map.Entry) r134.next()).getKey());
        goto L80
    L82:
        Set r135 = CollectionsKt.toSet(r133);
        r130 = new ConcurrentHashMap();
        Iterator r136 = r131.iterator();
    L84:
        if (r136.hasNext() == false) goto L88;
        Map.Entry r137 = (Map.Entry) r136.next();
        if (r135.contains(r137.getKey()) == false) goto L84;
        r130.put(r137.getKey(), r137.getValue());
        goto L84
    L72:
        if (r127.isEmpty() == true) goto L75;
        r129 = false;
    L90:
        ConcurrentHashMap r138 = j();
        if (r138 == null) goto L93;
        int r139 = r138.size();
    L95:
        if (r139 <= i()) goto L116;
        if (r138 != null) goto L98;
    L101:
        boolean r140 = true;
    L102:
        if (r140 == false) goto L104;
        ConcurrentHashMap r141 = null;
    L114:
        if (r141 == null) goto L116;
        p(r141);
        goto L116
    L104:
        List r142 = CollectionsKt.sortedWith(r138.entrySet(), new g1());
        List r143 = CollectionsKt.take(r142, d());
        ArrayList r144 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r143, 10));
        Iterator r145 = r143.iterator();
    L106:
        if (r145.hasNext() == false) goto L108;
        r144.add((String) ((Map.Entry) r145.next()).getKey());
        goto L106
    L108:
        Set r146 = CollectionsKt.toSet(r144);
        r141 = new ConcurrentHashMap();
        Iterator r147 = r142.iterator();
    L110:
        if (r147.hasNext() == false) goto L114;
        Map.Entry r148 = (Map.Entry) r147.next();
        if (r146.contains(r148.getKey()) == false) goto L110;
        r141.put(r148.getKey(), r148.getValue());
        goto L110
    L98:
        if (r138.isEmpty() == true) goto L101;
        r140 = false;
    L116:
        ConcurrentHashMap r149 = b();
        if (r149 == null) goto L119;
        int r150 = r149.size();
    L121:
        if (r150 <= i()) goto L142;
        if (r149 != null) goto L124;
    L127:
        boolean r151 = true;
    L128:
        if (r151 == false) goto L130;
        ConcurrentHashMap r152 = null;
    L140:
        if (r152 == null) goto L142;
        n(r152);
        goto L142
    L130:
        List r153 = CollectionsKt.take(CollectionsKt.sortedWith(r149.entrySet(), new e1()), d());
        ArrayList r154 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r153, 10));
        Iterator r155 = r153.iterator();
    L132:
        if (r155.hasNext() == false) goto L134;
        r154.add((String) ((Map.Entry) r155.next()).getKey());
        goto L132
    L134:
        r152 = new ConcurrentHashMap();
        Iterator r156 = r149.entrySet().iterator();
    L136:
        if (r156.hasNext() == false) goto L140;
        Map.Entry r157 = (Map.Entry) r156.next();
        String r158 = (String) r157.getKey();
        a r159 = (a) r157.getValue();
        if (r154.contains(r158) == false) goto L136;
        r152.put(r158, r159);
        goto L136
    L124:
        if (r149.isEmpty() == true) goto L127;
        r151 = false;
    L142:
        ConcurrentHashMap r160 = a();
        FLogger r161 = FLogger.f375446a;
        StringBuilder r162 = new StringBuilder("clearExceedMaxSaveItemCountCache, map.size: ");
        if (r160 == null) goto L145;
        Integer r163 = Integer.valueOf(r160.size());
    L146:
        r162.append(r163);
        r162.append("===MAX_SAVE_ITEM_COUNT:");
        r162.append(i());
        r161.i("InnerVideoListPreloadManager_Cache", r162.toString());
        if (r160 == null) goto L149;
        int r164 = r160.size();
    L151:
        if (r164 <= i()) goto L217;
        if (r160 != null) goto L154;
    L157:
        if (r102 == true) goto L170;
        List r165 = CollectionsKt.take(CollectionsKt.sortedWith(r160.entrySet(), new d1()), d());
        ArrayList r166 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r165, 10));
        Iterator r167 = r165.iterator();
    L161:
        if (r167.hasNext() == false) goto L163;
        r166.add((String) ((Map.Entry) r167.next()).getKey());
        goto L161
    L163:
        FLogger.f375446a.i("InnerVideoListPreloadManager_Cache", "trimCachedPreloadItemIdsDataMap, reserve keys: " + r166);
        ConcurrentHashMap<String, g> r168 = new ConcurrentHashMap();
        Iterator r169 = r160.entrySet().iterator();
    L165:
        if (r169.hasNext() == false) goto L169;
        Map.Entry r170 = (Map.Entry) r169.next();
        String r171 = (String) r170.getKey();
        g r172 = (g) r170.getValue();
        if (r166.contains(r171) == false) goto L165;
        r168.put(r171, r172);
        goto L165
    L169:
        r101 = r168;
    L170:
        f375876e = r101;
        m(r101);
        return;
    L154:
        if (r160.isEmpty() == true) goto L157;
        r102 = false;
        goto L157
    L217:
        return;
    L149:
        r164 = 0;
        goto L151
    L145:
        r163 = null;
        goto L146
    L119:
        r150 = 0;
        goto L121
    L93:
        r139 = 0;
        goto L95
    L67:
        r128 = 0;
        goto L69
    L41:
        r117 = 0;
        goto L43
    L35:
        r114 = false;
        goto L36
    L17:
        r108 = r107;
        goto L19
    L14:
        r107 = null;
        goto L15
    }

    public static void q(String r100, w4 r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "reason");
        ConcurrentHashMap r102 = j();
        if (r102 == null) goto L5;
        w4 r103 = (w4) r102.put(r100, r101);
    L5:
        if (r102 == null) goto L8;
        p(r102);
        return;
    }
}
