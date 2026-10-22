package com.bytedance.locallife.live.goodsshelves.bean;

import android.os.SystemClock;
import com.bytedance.locallife.live.dsl.shelf.LiveLocalLifeShelfDSLEngine;
import com.bytedance.locallife.live.experiment.LiveLocalLifeMultiThreadOPT;
import com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel;
import com.bytedance.locallife.live.msgcenter.MsgCenter;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class LiveGoodsShelvesLynxDSLResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f259567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f259568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveLocalLifeShelfDSLEngine f259569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveGoodsShelvesResponse f259570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f259571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f259572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f259573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Map<String, Object>> f259574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f259575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile List<Map<String, Object>> f259576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile String f259577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, Function0<Unit>> f259578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Long> f259579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f259580n;

    public static final class a {
    }

    public static final class b implements LiveLocalLifeShelfDSLEngine.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGoodsShelvesLynxDSLResponse f259581a;

        @Override // com.bytedance.locallife.live.dsl.shelf.LiveLocalLifeShelfDSLEngine.a
        public final boolean b() {
            if (LiveLocalLifeMultiThreadOPT.b() == true) goto L7;
            return false;
        L7:
            return !this.f259581a.f259578l.isEmpty();
        }

        public b(LiveGoodsShelvesLynxDSLResponse r100) {
            this.f259581a = r100;
        }

        @Override // com.bytedance.locallife.live.dsl.shelf.LiveLocalLifeShelfDSLEngine.a
        public final void a(Object r210) {
            Object r100 = "error_code";
            String r101 = "LiveGoodsShelvesDSLResponse";
            if (TypeIntrinsics.isMutableMap(r210) == true) goto L5;
            return;
        L5:
            Object r110 = ((Map) r210).get("call_id");
            Object r111 = ((Map) r210).get("card_list");     // Catch: Exception -> L121
            if (TypeIntrinsics.isMutableList(r111) == false) goto L9;
            List<Map<String, Object>> r112 = (List) r111;     // Catch: Exception -> L121
        L10:
            LiveLifeSaaSUtil.t().i("LiveGoodsShelvesDSLResponse", "start processing data " + r110);     // Catch: Exception -> L119
            if (LiveLocalLifeMultiThreadOPT.b() == true) goto L16;
        L26:
            List<Map<String, Object>> r102 = r112;     // Catch: Exception -> L119
            if (r102 != null) goto L29;
        L32:
            boolean r103 = true;
        L34:
            if (r103 == false) goto L129;
            LiveLifeSaaSUtil.t().e("LiveGoodsShelvesDSLResponse", "从 lynxModule 返回结果不包含数据列表 " + r210);     // Catch: Exception -> L119
            Map<String, Function0<Unit>> r104 = this.f259581a.f259578l;     // Catch: Exception -> L119
            if (r104 == null) goto L42;
            Function0 r105 = (Function0) TypeIntrinsics.asMutableMap(r104).remove(r110);     // Catch: Exception -> L119
            if (r105 == null) goto L141;
            r105.invoke();     // Catch: Exception -> L119
            return;
        L141:
            return;
        L42:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");     // Catch: Exception -> L119
        L129:
            if (Intrinsics.areEqual("all", ((Map) r210).get("data_update_type")) == false) goto L136;
            LiveGoodsShelvesLynxDSLResponse r106 = this.f259581a;     // Catch: Exception -> L117
            r106.getClass();     // Catch: Exception -> L117
            Intrinsics.checkNotNullParameter(r112, "<set-?>");     // Catch: Exception -> L117
            r106.f259576j = r112;     // Catch: Exception -> L117
            qs6.b r107 = LiveLifeSaaSUtil.t();     // Catch: Exception -> L117
            StringBuilder r108 = new StringBuilder("lynxModule 返回结果 ");     // Catch: Exception -> L117
            r108.append(this.f259581a.c().size());     // Catch: Exception -> L117
            r108.append(" newUUid:");     // Catch: Exception -> L117
            r108.append(r110);     // Catch: Exception -> L117
            r108.append(" isHit:");     // Catch: Exception -> L117
            Map<String, Function0<Unit>> r109 = this.f259581a.f259578l;     // Catch: Exception -> L117
            if (r109 == null) goto L64;
            r108.append(r109.containsKey(r110));     // Catch: Exception -> L117
            r107.i("LiveGoodsShelvesDSLResponse", r108.toString());     // Catch: Exception -> L117
            Map<String, Function0<Unit>> r113 = this.f259581a.f259578l;     // Catch: Exception -> L117
            if (r113 == null) goto L62;
            Function0 r114 = (Function0) TypeIntrinsics.asMutableMap(r113).remove(r110);     // Catch: Exception -> L117
            if (r114 == null) goto L53;
            r114.invoke();     // Catch: Exception -> L117
        L53:
            Map<String, Long> r115 = this.f259581a.f259579m;     // Catch: Exception -> L117
            if (r115 == null) goto L60;
            Long r116 = (Long) TypeIntrinsics.asMutableMap(r115).remove(r110);     // Catch: Exception -> L117
            if (r116 == null) goto L142;
            LiveGoodsShelvesLynxDSLResponse r117 = this.f259581a;     // Catch: Exception -> L117
            Map r118 = MapsKt.mapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(SystemClock.elapsedRealtime() - r116.longValue())), TuplesKt.to("count", String.valueOf(r117.c().size())), TuplesKt.to("location", "shelf")});     // Catch: Exception -> L117
            int r119 = qv6.e.f534905a;     // Catch: Exception -> L117
            qv6.e.a("live_life_dsl_process", r118, true, r117.f259571e);     // Catch: Exception -> L117
            return;
        L142:
            return;
        L60:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");     // Catch: Exception -> L117
        L62:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");     // Catch: Exception -> L117
        L64:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");     // Catch: Exception -> L117
        L136:
            if (Intrinsics.areEqual("message", ((Map) r210).get("data_update_type")) == true) goto L70;
            if (Intrinsics.areEqual("part", ((Map) r210).get("data_update_type")) == true) goto L70;
        L92:
            String r120 = "从 lynxModule 解析数据错误 ";
            String r121 = "LiveGoodsShelvesDSLResponse";
            LiveLifeSaaSUtil.t().e(r121, r120 + r210 + ' ' + this.f259581a.f(false));     // Catch: Exception -> L109
            Pair[] r122 = new Pair[2];     // Catch: Exception -> L109
            r100 = "error_code";
            Object r123 = "-85";
            r122[0] = TuplesKt.to(r100, r123);     // Catch: Exception -> L107
            Object r124 = "error_msg";
            r122[1] = TuplesKt.to(r124, "data_update_type 无法识别 或 尚未全量刷新过dsl数据。可能是因为全量刷新出现错误");     // Catch: Exception -> L105
            Map r125 = MapsKt.mapOf(r122);     // Catch: Exception -> L105
            int r126 = qv6.e.f534905a;     // Catch: Exception -> L105
            String r127 = "live_life_dsl_shelf_error";
            qv6.e.a(r127, r125, true, this.f259581a.f259571e);     // Catch: Exception -> L103
            return;
        L103:
            e = e;
        L123:
            LiveLifeSaaSUtil.t().e(r121, r120 + r210 + ' ' + this.f259581a.f(false), e);
            Map r128 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, r123), TuplesKt.to(r124, String.valueOf(e.getMessage()))});
            int r129 = qv6.e.f534905a;
            qv6.e.a(r127, r128, true, this.f259581a.f259571e);
            return;
        L105:
            e = e;
            r127 = "live_life_dsl_shelf_error";
        L107:
            e = e;
            r127 = "live_life_dsl_shelf_error";
            r124 = "error_msg";
        L109:
            e = e;
            r100 = "error_code";
        L111:
            r127 = "live_life_dsl_shelf_error";
            r124 = "error_msg";
            r123 = "-85";
        L112:
            e = e;
            r100 = "error_code";
        L114:
            r127 = "live_life_dsl_shelf_error";
            r124 = "error_msg";
            r123 = "-85";
            r121 = "LiveGoodsShelvesDSLResponse";
        L70:
            if (this.f259581a.f(false) == false) goto L92;
            LiveGoodsShelvesLynxDSLResponse r130 = this.f259581a;     // Catch: Exception -> L117
            Iterator<T> r131 = r112.iterator();     // Catch: Exception -> L117
        L73:
            if (r131.hasNext() == false) goto L77;
            Map r132 = (Map) r131.next();     // Catch: Exception -> L117
            Object r133 = r132.get("native_list_index");     // Catch: Exception -> L117
            Intrinsics.checkNotNull(r133, "null cannot be cast to non-null type kotlin.Double");     // Catch: Exception -> L117
            Object r134 = r100;
            String r211 = r101;
            ListProtector.set(r130.c(), (int) ((Double) r133).doubleValue(), r132);     // Catch: Exception -> L115
            r100 = r134;
            r101 = r211;
            goto L73
        L77:
            Map<String, Function0<Unit>> r135 = this.f259581a.f259578l;     // Catch: Exception -> L115
            if (r135 == null) goto L90;
            Function0 r136 = (Function0) TypeIntrinsics.asMutableMap(r135).remove(r110);     // Catch: Exception -> L115
            if (r136 == null) goto L82;
            r136.invoke();     // Catch: Exception -> L115
        L82:
            Map<String, Long> r137 = this.f259581a.f259579m;     // Catch: Exception -> L115
            if (r137 == null) goto L88;
            Long r138 = (Long) TypeIntrinsics.asMutableMap(r137).remove(r110);     // Catch: Exception -> L115
            if (r138 == null) goto L143;
            LiveGoodsShelvesLynxDSLResponse r139 = this.f259581a;     // Catch: Exception -> L115
            Map r140 = MapsKt.mapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(SystemClock.elapsedRealtime() - r138.longValue())), TuplesKt.to("count", String.valueOf(r139.c().size())), TuplesKt.to("location", "shelf")});     // Catch: Exception -> L115
            int r141 = qv6.e.f534905a;     // Catch: Exception -> L115
            qv6.e.a("live_life_dsl_process", r140, true, r139.f259571e);     // Catch: Exception -> L115
            return;
        L143:
            return;
        L88:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");     // Catch: Exception -> L115
        L90:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");     // Catch: Exception -> L115
        L115:
            e = e;
            r100 = r112;
            r120 = "从 lynxModule 解析数据错误 ";
        L117:
            e = e;
            r121 = "LiveGoodsShelvesDSLResponse";
            r120 = "从 lynxModule 解析数据错误 ";
            goto L111
        L29:
            if (r102.isEmpty() == true) goto L32;
            r103 = false;
            goto L34
        L16:
            if (Intrinsics.areEqual(r110, "") == true) goto L26;
            if (r110 == null) goto L26;
            Map<String, Function0<Unit>> r142 = this.f259581a.f259578l;     // Catch: Exception -> L119
            if (r142 == null) goto L25;
            if (r142.containsKey(r110) == true) goto L26;
            LiveLifeSaaSUtil.t().e("LiveGoodsShelvesDSLResponse", "callbackMap 不包含回调 lastUuid: " + this.f259581a.f259577k + " newUuid: " + r110 + " hashCode: " + hashCode());     // Catch: Exception -> L119
            Map r143 = MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", "-85"), TuplesKt.to("error_msg", "callbackMap 不包含回调")});     // Catch: Exception -> L119
            int r144 = qv6.e.f534905a;     // Catch: Exception -> L119
            qv6.e.a("live_life_dsl_shelf_error", r143, false, this.f259581a.f259571e);     // Catch: Exception -> L119
            return;
        L25:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");     // Catch: Exception -> L119
        L119:
            e = e;
            r127 = "live_life_dsl_shelf_error";
            r124 = "error_msg";
            r123 = "-85";
            r121 = "LiveGoodsShelvesDSLResponse";
            r120 = "从 lynxModule 解析数据错误 ";
            goto L123
        L9:
            r112 = null;
        L121:
            e = e;
            r127 = "live_life_dsl_shelf_error";
            r123 = "-85";
            r121 = "LiveGoodsShelvesDSLResponse";
            r124 = "error_msg";
            r120 = "从 lynxModule 解析数据错误 ";
            goto L123
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesLynxDSLResponse$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/LynxDataType;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class c extends TypeToken<Map<String, Object>> {
        public c() {
        }
    }

    static {
    }

    public final List<Map<String, Object>> b() {
        Object r100 = this.f259573g.get("card_list");
        if (TypeIntrinsics.isMutableList(r100) == true) goto L7;
        return null;
    L7:
        return (List) r100;
    }

    public final List<Map<String, Object>> c() {
        List<Map<String, Object>> r100 = this.f259576j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dslCardList");
        return null;
    }

    public final List<Map<String, Object>> d() {
        List<Map<String, Object>> r100 = this.f259574h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return b();
    }

    public final void e(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        int r101 = 0;
        if (d() == null) goto L23;
        List<Map<String, Object>> r102 = this.f259574h;
        if (r102 != null) goto L9;
    L13:
        List<Map<String, Object>> r103 = this.f259574h;
        if (r103 == null) goto L23;
        Map r104 = (Map) ListProtector.get(r103, 0);
        if (r104 == null) goto L23;
        Object r105 = r104.get("card_atmosphere");
        if (r105 == null) goto L22;
        Map<String, Object> r106 = com.bytedance.locallife.live.util.w.e(r104, "card_data");
        if (r106 == null) goto L22;
        r106.put("card_atmosphere", r105);
    L22:
        r104.remove("card_atmosphere");
        goto L23
    L9:
        if (r100 > CollectionsKt.getLastIndex(r102)) goto L13;
        Map<String, Object> r107 = com.bytedance.locallife.live.util.w.e((Map) ListProtector.get(r102, r100), "native_data");
        if (r107 == null) goto L13;
        r107.put("is_top_item", Boolean.TRUE);
    L23:
        List<Map<String, Object>> r108 = this.f259574h;
        if (r108 == null) goto L32;
        Iterator<T> r109 = r108.iterator();
    L27:
        if (r109.hasNext() == false) goto L36;
        Object r110 = r109.next();
        int r111 = r101 + 1;
        if (r101 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        ((Map) r110).put("native_list_index", Integer.valueOf(r101));
        r101 = r111;
        goto L27
    L36:
        return;
    }

    public final boolean f(boolean r100) {
        if (r100 == false) goto L12;
        if (this.f259576j != null) goto L12;
        Pair[] r101 = new Pair[3];
        if (this.f259576j == null) goto L9;
        boolean r102 = true;
    L10:
        r101[0] = TuplesKt.to("is_dsl_shelf_data_ready", String.valueOf(r102));
        r101[1] = TuplesKt.to("error_code", "-90");
        r101[2] = TuplesKt.to("reason", "dsl_data_failed");
        Map r103 = MapsKt.mapOf(r101);
        int r104 = qv6.e.f534905a;
        qv6.e.a("live_life_dsl_shelf_error", r103, true, this.f259571e);
        goto L12
    L9:
        r102 = false;
    L12:
        if (this.f259576j == null) goto L15;
        return true;
    L15:
        return false;
    }

    public static final String a(LiveGoodsShelvesLynxDSLResponse r100, Map r101) {
        r100.getClass();
        String r102 = com.bytedance.locallife.live.util.w.f(r101, "card_id");
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        Object r104 = r101.get("clone_flag");
        if (r104 == null) goto L12;
        String r105 = r104.toString();
        if (r105 == null) goto L12;
        r103 = r105;
    L12:
        return r102.concat(r103);
    }

    public final void g(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        List<Map<String, Object>> r102 = null;
        switch(r100.hashCode()) {
            case -450766506: goto L28;
            case -245278611: goto L21;
            case -42218558: goto L17;
            case 816725123: goto L13;
            case 1313026319: goto L6;
            default: goto L31;
        };
    L31:
        h(this, r100, r101);
        return;
    L6:
        if (r100.equals("card_list_by_clone_flag_card_id") == false) goto L31;
        if (TypeIntrinsics.isMutableList(r101) == false) goto L11;
        r102 = (List) r101;
    L11:
        l(r102, new LiveGoodsShelvesLynxDSLResponse$modifyResponseData$1(this));
        return;
    L13:
        if (r100.equals("lynx_topbar_data") == false) goto L31;
        LiveGoodsShelvesResponse r103 = this.f259570d;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        r103.setLynx_topbar_data((Map) r101);
        this.f259570d.setLynxTopbarData(null);
        h(this, r100, r101);
        return;
    L17:
        if (r100.equals("lynx_bottom_bar_data") == false) goto L31;
        LiveGoodsShelvesResponse r104 = this.f259570d;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        r104.setLynxBottomBarData((Map) r101);
        h(this, r100, r101);
        return;
    L21:
        if (r100.equals("card_list") == false) goto L31;
        if (TypeIntrinsics.isMutableList(r101) == false) goto L26;
        r102 = (List) r101;
    L26:
        l(r102, LiveGoodsShelvesLynxDSLResponse$modifyResponseData$2.INSTANCE);
        return;
    L28:
        if (r100.equals("lynx_common_data") == false) goto L31;
        LiveGoodsShelvesResponse r105 = this.f259570d;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        r105.setLynxCommonData((Map) r101);
        h(this, r100, r101);
    }

    public final void j(Integer r100, Function0<Unit> r101) {
        List<Map<String, Object>> r102 = d();
        if (r102 == null) goto L11;
        Iterator<T> r103 = r102.iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L11;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ((Map) r105).put("native_list_index", Integer.valueOf(r104));
        r104 = r106;
    L11:
        List<Map<String, Object>> r107 = d();
        if (r107 != null) goto L14;
        return;
    L14:
        if (r100 == null) goto L16;
        i(r107.subList(0, Math.min(r100.intValue(), r107.size())), "all", null, r101);
        return;
    L16:
        i(r107, "all", null, r101);
    }

    public final void l(List<Map<String, Object>> r110, Function2<? super Map<String, Object>, ? super Map<String, Object>, Boolean> r111) {
        List<Map<String, Object>> r100 = this.f259574h;
        int r101 = 0;
        int r102 = -1;
        if (r100 == null) goto L30;
        Iterator r103 = ((ArrayList) r100).iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L30;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Map r107 = (Map) r105;
        if (r110 == null) goto L20;
        Iterator<T> r108 = r110.iterator();
    L14:
        if (r108.hasNext() == false) goto L18;
        Object r109 = r108.next();
        if (r111.invoke((Map) r109, r107).booleanValue() == false) goto L14;
    L19:
        Map r112 = (Map) r109;
    L21:
        if (r112 == null) goto L29;
        Map<String, Object> r113 = com.bytedance.locallife.live.util.w.d(r107, "native_data");
        if (r113 == null) goto L25;
        r112.put("native_data", r113);
    L25:
        List<Map<String, Object>> r114 = this.f259574h;
        if (r114 == null) goto L28;
        Map r115 = (Map) ListProtector.set(r114, r104, r112);
    L28:
        r102 = r104;
    L29:
        r104 = r106;
        goto L6
    L18:
        r109 = null;
        goto L19
    L20:
        r112 = null;
    L30:
        Object r116 = this.f259573g.get("card_list");
        if (TypeIntrinsics.isMutableList(r116) == false) goto L33;
        List r117 = (List) r116;
    L34:
        if (r117 == null) goto L58;
        Iterator r118 = r117.iterator();
        int r119 = 0;
    L37:
        if (r118.hasNext() == false) goto L58;
        Object r120 = r118.next();
        int r121 = r119 + 1;
        if (r119 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        Map r122 = (Map) r120;
        if (r110 == null) goto L51;
        Iterator<T> r123 = r110.iterator();
    L45:
        if (r123.hasNext() == false) goto L49;
        Object r124 = r123.next();
        if (r111.invoke((Map) r124, r122).booleanValue() == false) goto L45;
    L50:
        Map r125 = (Map) r124;
    L52:
        if (r125 == null) goto L57;
        Map<String, Object> r126 = com.bytedance.locallife.live.util.w.d(r122, "native_data");
        if (r126 == null) goto L56;
        r125.put("native_data", r126);
    L56:
        ListProtector.set(r117, r119, r125);
    L57:
        r119 = r121;
        goto L37
    L49:
        r124 = null;
        goto L50
    L51:
        r125 = null;
    L58:
        if (r102 >= 0) goto L60;
        return;
    L60:
        if (r110 != null) goto L62;
    L64:
        boolean r127 = false;
    L66:
        if (r127 == false) goto L68;
        Lazy r128 = MsgCenter.f260620a;
        LinkedHashMap r129 = new LinkedHashMap();
        r129.put("shelf_id", String.valueOf(this.f259575i));
        r129.put("refresh_index", Integer.valueOf(r102));
        Unit r130 = Unit.INSTANCE;
        MsgCenter.f(new com.bytedance.locallife.live.msgcenter.a("event_live_reload_shelf", r129, null, 4));
        return;
    L68:
        if (r110 == null) goto L70;
        r101 = r110.size();
    L70:
        if (r101 <= 1) goto L87;
        Lazy r131 = MsgCenter.f260620a;
        LinkedHashMap r132 = new LinkedHashMap();
        r132.put("shelf_id", String.valueOf(this.f259575i));
        Unit r133 = Unit.INSTANCE;
        MsgCenter.f(new com.bytedance.locallife.live.msgcenter.a("event_live_reload_shelf", r132, null, 4));
        return;
    L87:
        return;
    L62:
        if (r110.size() != 1) goto L64;
        r127 = true;
        goto L66
    L33:
        r117 = null;
        goto L34
    }

    public static final void h(LiveGoodsShelvesLynxDSLResponse r100, String r101, Object r102) {
        r100.f259573g.put(r101, r102);
        Lazy r103 = MsgCenter.f260620a;
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("shelf_id", String.valueOf(r100.f259575i));
        r104.put("data_name", r101);
        r104.put("data", r102);
        Unit r105 = Unit.INSTANCE;
        MsgCenter.f(new com.bytedance.locallife.live.msgcenter.a("event_live_shelf_data_changed", r104, null, 4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(LiveGoodsShelvesLynxDSLResponse r100, Integer r101, Function0 r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.j(r101, r102);
    }

    public final void i(List<Map<String, Object>> r100, String r101, Map<String, Object> r102, Function0<Unit> r103) {
        if (com.bytedance.locallife.live.experiment.a0.a() == true) goto L8;
        if (r103 == null) goto L28;
        r103.invoke();
        return;
    L28:
        return;
    L8:
        if (Intrinsics.areEqual(r101, "all") == false) goto L10;
    L20:
        this.f259577k = UUID.randomUUID().toString();
        LiveLifeSaaSUtil.t().i("LiveGoodsShelvesDSLResponse", "sendDataUpdateEventToJS " + this.f259577k + ' ' + hashCode());
        if (r103 == null) goto L23;
        this.f259578l.put(this.f259577k, r103);
    L23:
        this.f259579m.put(this.f259577k, Long.valueOf(SystemClock.elapsedRealtime()));
        LiveLocalLifeShelfDSLEngine r104 = this.f259569c;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("call_id", this.f259577k);
        r105.put("data_update_type", r101);
        r105.put("card_list", r100);
        r105.put("message_info", r102);
        Unit r106 = Unit.INSTANCE;
        if (r104.c("shelfDataUpdate", CollectionsKt.listOf(r105)) == true) goto L29;
        if (r103 == null) goto L30;
        r103.invoke();
        return;
    L30:
        return;
    L29:
        return;
    L10:
        if (f(false) == false) goto L18;
        List<Map<String, Object>> r107 = d();
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == true) goto L20;
    L14:
        if (c().size() != r107.size()) goto L16;
        r108 = true;
    L18:
        LiveLifeSaaSUtil.t().i("LiveGoodsShelvesDSLResponse", "数据ready之前，收到了消息 ".concat(r101));
        Map r109 = MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", "-88"), TuplesKt.to("errr_msg", "数据完全刷新前收到了消息")});
        int r110 = qv6.e.f534905a;
        qv6.e.a("live_life_dsl_shelf_error", r109, true, this.f259571e);
    }

    public LiveGoodsShelvesLynxDSLResponse(String r110, com.bytedance.locallife.live.goodsshelves.manager.i r111, int r210, int r211, LiveLocalLifeShelfDSLEngine r212, LiveGoodsShelvesResponse r213, String r214, int r215) {
        Intrinsics.checkNotNullParameter(r110, "liveGoodsShelvesRawData");
        Intrinsics.checkNotNullParameter(r111, "couponMigrationInfo");
        Intrinsics.checkNotNullParameter(r212, "dslCardEngine");
        Intrinsics.checkNotNullParameter(r213, "nativeParsedData");
        Intrinsics.checkNotNullParameter(r214, "uniqueKey");
        this.f259567a = r210;
        this.f259568b = r211;
        this.f259569c = r212;
        this.f259570d = r213;
        this.f259571e = r214;
        this.f259572f = r215;
        int r100 = 2;
        if (Intrinsics.areEqual(r111.f259724b, 2) == true) goto L9;
        r100 = 3;
        if (Intrinsics.areEqual(r111.f259724b, 3) == true) goto L9;
        r100 = 1;
    L9:
        this.f259575i = r100;
        this.f259577k = "";
        this.f259578l = new LinkedHashMap();
        this.f259579m = new LinkedHashMap();
        this.f259580n = new b(this);
        if (r110.length() != 0) goto L12;
        boolean r101 = true;
    L13:
        if (r101 == false) goto L15;
        this.f259573g = new LinkedHashMap();
    L73:
        LiveLocalLifeShelfDSLEngine r102 = this.f259569c;
        b r103 = this.f259580n;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "dataReceiver");
        if (com.bytedance.locallife.live.experiment.a0.a() == false) goto L81;
        r102.f259480m.add(r103);
        return;
    L81:
        return;
    L15:
        Gson r104 = LiveLifeSaaSUtil.r();
        Type r105 = new c().getType();
        Map<String, Object> r106 = (Map) com.bytedance.locallife.live.util.h.a(r104, r110, r105, new LinkedHashMap(), "LiveGoodsShelvesLynxDSLResponse#originServerData");
        if (r106 != null) goto L18;
        r106 = new LinkedHashMap();
    L18:
        this.f259573g = r106;
        long r107 = System.currentTimeMillis() / ((long) 1000);
        if (com.bytedance.locallife.live.settings.c.i() == false) goto L21;
        Map<String, Object> r108 = com.bytedance.locallife.live.util.s.a(r214);
    L23:
        if (com.bytedance.locallife.live.settings.c.i() == false) goto L25;
        Map<String, Object> r109 = LiveLocalLifeUtil.h(r214);
    L26:
        List<Map<String, Object>> r112 = b();
        if (r112 == null) goto L73;
        Iterator<T> r113 = r112.iterator();
        int r114 = 0;
    L30:
        if (r113.hasNext() == false) goto L73;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        Map r117 = (Map) r115;
        String r118 = com.bytedance.locallife.live.util.w.f(r117, "card_data");
        if (r118 != null) goto L37;
    L40:
        boolean r119 = true;
    L41:
        if (r119 == true) goto L46;
        Map r120 = (Map) com.bytedance.locallife.live.util.h.a(r104, r118, r105, new LinkedHashMap(), "LiveGoodsShelvesLynxDSLResponse#init_card_data");
        Map r121 = r120;
        if (r120 != null) goto L45;
        r121 = new LinkedHashMap();
    L45:
        r117.put("card_data", r121);
    L46:
        LinkedHashMap r122 = new LinkedHashMap();
        r122.put("origin_index", Integer.valueOf(r116));
        Long r123 = com.bytedance.locallife.live.util.w.c(this.f259573g, "server_time");
        if (r123 == null) goto L49;
        long r124 = r123.longValue();
    L50:
        r122.put("server_time", Long.valueOf(r124));
        Integer r125 = com.bytedance.locallife.live.util.w.b(this.f259573g, "live_room_type");
        if (r125 == null) goto L53;
        int r126 = r125.intValue();
    L54:
        r122.put("live_room_type", Integer.valueOf(r126));
        r122.put("native_time", Long.valueOf(r107));
        r122.put("page_type", Integer.valueOf(this.f259575i));
        if (com.bytedance.locallife.live.settings.c.i() == false) goto L57;
        Map<String, Object> r127 = r109;
    L58:
        r122.put("track_data", r127);
        r122.put("shelf_action_type", Integer.valueOf(this.f259567a));
        r122.put("shelf_data_type", Integer.valueOf(this.f259568b));
        r122.put("shelf_id", String.valueOf(this.f259575i));
        r122.put("is_location_enabled", Integer.valueOf(LiveLifeSaaSUtil.v().a() ? 1 : 0));
        LiveLocalLifeViewModel.Companion r128 = LiveLocalLifeViewModel.Companion;
        String r129 = this.f259571e;
        r128.getClass();
        LiveLocalLifeViewModel r130 = LiveLocalLifeViewModel.Companion.a(r129);
        if (r130 == null) goto L64;
        LiveGoodsShelvesViewModel r131 = LiveLocalLifeViewModel.getGoodsShelvesViewModel$default(r130, null, 1, null);
        if (r131 == null) goto L64;
        String r132 = r131.getBtmPageId();
        if (r132 == null) goto L64;
    L65:
        r122.put("btm_page_id", r132);
        r122.put("tab_id", Integer.valueOf(this.f259572f));
        r122.put("room_unique_key", this.f259571e);
        r117.put("native_data", r122);
        Map<String, Object> r133 = com.bytedance.locallife.live.util.w.d(this.f259573g, "lynx_common_data");
        if (r133 == null) goto L69;
        r117.put("lynx_common_data", r133);
    L69:
        if (com.bytedance.locallife.live.settings.c.i() == false) goto L71;
        Map<String, Object> r134 = r108;
    L72:
        r117.put("room_data", r134);
        r114 = r116;
        goto L30
    L71:
        r134 = com.bytedance.locallife.live.util.s.a(this.f259571e);
    L64:
        r132 = "";
        goto L65
    L57:
        r127 = LiveLocalLifeUtil.h(this.f259571e);
        goto L58
    L53:
        r126 = 0;
        goto L54
    L49:
        r124 = 0;
        goto L50
    L37:
        if (r118.length() == 0) goto L40;
        r119 = false;
        goto L41
    L25:
        r109 = new LinkedHashMap();
        goto L26
    L21:
        r108 = new LinkedHashMap();
        goto L23
    L12:
        r101 = false;
        goto L13
    }
}
