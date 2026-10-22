package com.bytedance.locallife.live.goodsshelves.bean;

import com.bytedance.locallife.live.goodsshelves.manager.ShelfDefaultTabManager;
import com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class LiveGoodsShelvesDSLPagingResponse implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.locallife.live.goodsshelves.manager.i f259552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f259553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f259554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveGoodsShelvesResponse f259555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f259556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f259557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, Object> f259558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f259559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile List<Map<String, Object>> f259560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<LiveGoodsShelvesCard> f259561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<Map<String, Object>> f259562l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<ev6.d> f259563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<com.bytedance.locallife.live.goodsshelves.bean.b> f259564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f259565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f259566p;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesDSLPagingResponse$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/LynxDataType;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    static {
    }

    public final LiveGoodsShelvesDSLPagingResponse a() {
        LiveGoodsShelvesDSLPagingResponse r100 = new LiveGoodsShelvesDSLPagingResponse(this.f259551a, this.f259552b, this.f259553c, this.f259554d, this.f259555e, this.f259556f);
        Map<String, Object> r101 = c();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f259558h = r101;
        r100.f259562l = this.f259562l;
        r100.f259560j = this.f259560j;
        r100.f259561k = this.f259561k;
        r100.f259563m = this.f259563m;
        r100.f259564n = this.f259564n;
        r100.f259565o = true;
        return r100;
    }

    public final Map<String, Object> c() {
        Map<String, Object> r100 = this.f259558h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("originServerData");
        return null;
    }

    public final void e() {
        if (this.f259562l.size() <= 0) goto L33;
        LiveGoodsShelvesResponse r100 = this.f259555e;
        boolean r101 = false;
        if (r100 != null) goto L7;
    L9:
        if (r101 == false) goto L35;
        Iterator<T> r102 = this.f259562l.iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((Map) r103).get("is_showing"), Boolean.TRUE) == false) goto L13;
    L18:
        Map r104 = (Map) r103;
        if (r104 == null) goto L34;
        Map<String, Object> r105 = com.bytedance.locallife.live.util.w.e(r104, "native_data");
        if (r105 == null) goto L23;
        r105.put("is_top_item", Boolean.TRUE);
    L23:
        Object r106 = r104.get("card_atmosphere");
        if (r106 == null) goto L28;
        Map<String, Object> r107 = com.bytedance.locallife.live.util.w.e(r104, "card_data");
        if (r107 == null) goto L28;
        r107.put("card_atmosphere", r106);
    L28:
        r104.remove("card_atmosphere");
        return;
    L34:
        return;
    L17:
        r103 = null;
        goto L18
    L35:
        return;
    L7:
        if (r100.getOffset() != 0) goto L9;
        r101 = true;
        goto L9
    }

    public final void f() {
        this.f259564n.clear();
        List<Map<String, Object>> r100 = b();
        if (r100 == null) goto L11;
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L15;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        List<com.bytedance.locallife.live.goodsshelves.bean.b> r105 = this.f259564n;
        LiveGoodsShelvesCard r106 = (LiveGoodsShelvesCard) ListProtector.get(this.f259561k, r102);
        r105.add(new com.bytedance.locallife.live.goodsshelves.bean.b(r106, (Map) r103, (Map) CollectionsKt.getOrNull(this.f259560j, r102), (ev6.d) CollectionsKt.getOrNull(this.f259563m, r102)));
        r102 = r104;
        goto L6
    L15:
        return;
    }

    public final List<Map<String, Object>> b() {
        Object r100 = c().get("card_list");
        if (TypeIntrinsics.isMutableList(r100) == true) goto L7;
        return null;
    L7:
        return (List) r100;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public final void d(int r110, boolean r210) {
        if (this.f259565o == false) goto L5;
        return;
    L5:
        int r100 = 1;
        this.f259565o = true;
        if (this.f259551a.length() != 0) goto L8;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        LinkedHashMap r102 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f259558h = r102;
        return;
    L12:
        LiveGoodsShelvesResponse r103 = this.f259555e;
        Map<String, Object> r104 = null;
        if (r103 == null) goto L15;
        int r105 = r103.getSelectedTabId();
    L20:
        Gson r106 = LiveLifeSaaSUtil.r();
        Type r107 = new b().getType();
        Map<String, Object> r108 = (Map) com.bytedance.locallife.live.util.h.a(r106, this.f259551a, r107, new LinkedHashMap(), "LiveGoodsShelvesLynxDSLResponse#originServerData");
        if (r108 != null) goto L23;
        r108 = new LinkedHashMap();
    L23:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f259558h = r108;
        long r109 = System.currentTimeMillis() / ((long) 1000);
        List<Map<String, Object>> r111 = b();
        if (r111 == null) goto L66;
        Iterator<T> r112 = r111.iterator();
        int r113 = 0;
    L27:
        if (r112.hasNext() == false) goto L66;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        Map r116 = (Map) r114;
        this.f259562l.add((Map<String, Object>) r116);
        String r117 = com.bytedance.locallife.live.util.w.f(r116, "card_data");
        LiveGoodsShelvesResponse r118 = this.f259555e;
        if (r118 == null) goto L34;
        int r119 = r118.getOffset();
    L35:
        int r120 = (r119 + r113) + 1;
        if (r117 != null) goto L38;
    L41:
        boolean r121 = true;
    L42:
        if (r121 == true) goto L47;
        Map r122 = (Map) com.bytedance.locallife.live.util.h.a(r106, r117, r107, new LinkedHashMap(), "LiveGoodsShelvesLynxDSLResponse#init_card_data");
        Map r123 = r122;
        if (r122 != null) goto L46;
        r123 = new LinkedHashMap();
    L46:
        r116.put("card_data", r123);
    L47:
        LinkedHashMap r124 = new LinkedHashMap();
        r124.put("origin_index", Integer.valueOf(r120));
        Long r125 = com.bytedance.locallife.live.util.w.c(c(), "server_time");
        if (r125 == null) goto L50;
        long r126 = r125.longValue();
    L51:
        r124.put("server_time", Long.valueOf(r126));
        Integer r127 = com.bytedance.locallife.live.util.w.b(c(), "live_room_type");
        if (r127 == null) goto L54;
        int r128 = r127.intValue();
    L55:
        r124.put("live_room_type", Integer.valueOf(r128));
        r124.put("native_time", Long.valueOf(r109));
        r124.put("page_type", Integer.valueOf(this.f259559i));
        r124.put("track_data", LiveLocalLifeUtil.h(this.f259556f));
        r124.put("shelf_action_type", Integer.valueOf(this.f259553c));
        r124.put("shelf_data_type", Integer.valueOf(this.f259554d));
        r124.put("shelf_id", String.valueOf(this.f259559i));
        r124.put("is_location_enabled", Integer.valueOf(LiveLifeSaaSUtil.v().a() ? 1 : 0));
        LiveLocalLifeViewModel.Companion r129 = LiveLocalLifeViewModel.Companion;
        String r130 = this.f259556f;
        r129.getClass();
        LiveLocalLifeViewModel r131 = LiveLocalLifeViewModel.Companion.a(r130);
        if (r131 == null) goto L61;
        LiveGoodsShelvesViewModel r132 = LiveLocalLifeViewModel.getGoodsShelvesViewModel$default(r131, null, 1, null);
        if (r132 == null) goto L61;
        String r133 = r132.getBtmPageId();
        if (r133 == null) goto L61;
    L62:
        r124.put("btm_page_id", r133);
        r124.put("tab_id", Integer.valueOf(r105));
        r124.put("room_unique_key", this.f259556f);
        r124.put("is_search_result", Integer.valueOf(r210 ? 1 : 0));
        r116.put("native_data", r124);
        Map<String, Object> r134 = com.bytedance.locallife.live.util.w.d(c(), "lynx_common_data");
        if (r134 == null) goto L65;
        r116.put("lynx_common_data", r134);
    L65:
        r116.put("native_list_index", Integer.valueOf(r120 - 1));
        r113 = r115;
    L61:
        r133 = "";
        goto L62
    L54:
        r128 = 0;
        goto L55
    L50:
        r126 = 0;
        goto L51
    L38:
        if (r117.length() == 0) goto L41;
        r121 = false;
        goto L42
    L34:
        r119 = 0;
    L66:
        LiveGoodsShelvesResponse r135 = this.f259555e;
        if (r135 != null) goto L69;
    L71:
        boolean r136 = false;
    L72:
        LiveGoodsShelvesResponse r137 = this.f259555e;
        if (r137 == null) goto L81;
        Map<String, Object> r138 = r137.getLynxCommonData();
        if (r138 == null) goto L81;
        String r139 = com.bytedance.locallife.live.util.w.f(r138, "fe_config");
        if (r139 == null) goto L81;
        l0 r140 = (l0) com.bytedance.locallife.live.util.h.b(LiveLifeSaaSUtil.r(), r139, l0.class, "LiveGoodsShelvesDSLPagingResponse#init#parseFeConfig");
        if (r140 == null) goto L81;
        this.f259555e.setParsedFeConfig(r140);
    L82:
        LiveGoodsShelvesResponse r141 = this.f259555e;
        if (r141 == null) goto L129;
        List<LiveGoodsShelvesCard> r142 = r141.getCard_list();
        if (r142 == null) goto L130;
        Iterator<T> r143 = r142.iterator();
        int r144 = 0;
        boolean r145 = false;
    L88:
        if (r143.hasNext() == false) goto L131;
        Object r146 = r143.next();
        int r147 = r144 + 1;
        if (r144 >= 0) goto L92;
        CollectionsKt.throwIndexOverflow();
    L92:
        LiveGoodsShelvesCard r148 = (LiveGoodsShelvesCard) r146;
        r148.setLocalOrder((this.f259555e.getOffset() + r144) + r100);
        r148.setRequest_id(this.f259555e.getRequest_id());
        if (r136 == false) goto L98;
        if (r145 == true) goto L98;
        if (r148.is_showing() == false) goto L98;
        r145 = true;
        int r149 = 1;
    L99:
        if (r149 != r100) goto L101;
        boolean r150 = true;
    L102:
        r148.setTopShowing(Boolean.valueOf(r150));
        r148.setParsedFeConfig(r140);
        this.f259561k.add(r148);
        if (com.bytedance.locallife.live.experiment.r0.a() == false) goto L121;
        Map<String, Object> r151 = com.bytedance.locallife.live.util.w.d((Map) CollectionsKt.getOrNull(this.f259562l, r144), "card_data");
        if (r151 == null) goto L107;
        Map<String, Object> r152 = com.bytedance.locallife.live.util.w.d(r151, "element");
    L108:
        i0 r153 = (i0) GsonProtectorUtils.fromJson(r106, GsonProtectorUtils.toJson(r106, r152), i0.class);
        LiveLocalLifeCardData r154 = r148.getCard_data();
        if (r154 == null) goto L112;
        r154.setBffCardData(r153);
    L112:
        LiveLocalLifeCardData r155 = r148.getCard_data();
        if (r155 == null) goto L121;
        i0 r156 = r155.getBffCardData();
        if (r156 == null) goto L121;
        List<ev6.d> r157 = this.f259563m;
        com.bytedance.locallife.live.goodsshelves.processor.d r158 = (com.bytedance.locallife.live.goodsshelves.processor.d) this.f259566p.getValue();
        HashMap r159 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("local_order", Integer.valueOf(r148.getLocalOrder())), TuplesKt.to("unique_key", this.f259556f), TuplesKt.to("is_top_explain", Integer.valueOf(r149))});
        if (r140 == null) goto L119;
        r159.put("fe_config", r140);
    L119:
        Unit r160 = Unit.INSTANCE;
        r157.add(r158.b(r156, r159));
        goto L121
    L107:
        r152 = r104;
    L121:
        r144 = r147;
        r100 = 1;
        r104 = null;
        goto L88
    L101:
        r150 = false;
    L98:
        r149 = -1;
        goto L99
    L131:
        return;
    L130:
        return;
    L129:
        return;
    L81:
        r140 = null;
        goto L82
    L69:
        if (r135.getOffset() != 0) goto L71;
        r136 = true;
        goto L72
    L15:
        Lazy r161 = ShelfDefaultTabManager.f259680a;
        if (r103 == null) goto L18;
        LynxTopbarData r162 = r103.getLynxTopbarData();
    L19:
        r105 = ShelfDefaultTabManager.a(r162);
        goto L20
    L18:
        r162 = null;
        goto L19
    L8:
        r101 = false;
        goto L10
    }

    public LiveGoodsShelvesDSLPagingResponse(String r100, com.bytedance.locallife.live.goodsshelves.manager.i r101, int r102, int r103, LiveGoodsShelvesResponse r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "liveGoodsShelvesRawData");
        Intrinsics.checkNotNullParameter(r101, "couponMigrationInfo");
        Intrinsics.checkNotNullParameter(r105, "uniqueKey");
        this.f259551a = r100;
        this.f259552b = r101;
        this.f259553c = r102;
        this.f259554d = r103;
        this.f259555e = r104;
        this.f259556f = r105;
        this.f259557g = -1;
        int r106 = 2;
        if (Intrinsics.areEqual(r101.f259724b, 2) == true) goto L9;
        r106 = 3;
        if (Intrinsics.areEqual(r101.f259724b, 3) == true) goto L9;
        r106 = 1;
    L9:
        this.f259559i = r106;
        this.f259560j = new ArrayList();
        this.f259561k = new ArrayList();
        this.f259562l = new ArrayList();
        this.f259563m = new ArrayList();
        this.f259564n = new ArrayList();
        this.f259566p = LazyKt.lazy(LiveGoodsShelvesDSLPagingResponse$nativeUIDataProcessor$2.INSTANCE);
    }
}
