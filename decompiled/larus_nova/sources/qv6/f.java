package qv6;

import com.bytedance.locallife.live.experiment.m0;
import com.bytedance.locallife.live.experiment.r0;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesLynxDSLResponse;
import com.bytedance.locallife.live.goodsshelves.manager.w;
import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.s;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveLocalLifeLynxView f534906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f534907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f534908c;

    public f(LiveLocalLifeLynxView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackerView");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        this.f534906a = r100;
        this.f534907b = r101;
        if (r100.getLoadStatus() == 3) goto L7;
        if (this.f534906a.getLoadStatus() == 0) goto L7;
    L16:
        this.f534908c = m0.a();
        return;
    L7:
        if (m0.a() == false) goto L9;
        String r102 = com.bytedance.locallife.live.settings.c.h();
    L11:
        if (r102.length() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L16;
        LiveLocalLifeLynxView.a(this.f534906a, r102, null, 0, 6);
        goto L16
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = com.bytedance.locallife.live.settings.c.g();
        goto L11
    }

    public final boolean a(String r100, Object r101) {
        if (r0.a() == false) goto L6;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
        return false;
    L13:
        LiveLocalLifeLynxView r103 = this.f534906a;
        if (r101 == null) goto L16;
        List<? extends Object> r104 = CollectionsKt.listOf(r101);
    L17:
        r103.c(r100, r104);
        return true;
    L16:
        r104 = null;
        goto L17
    L6:
        if (this.f534906a.getLoadStatus() != 2) goto L10;
        if (this.f534908c == false) goto L10;
        r102 = true;
        goto L11
    }

    public final boolean b(int r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r101, "clickType");
        return a("shelfCardClick", MapsKt.mapOf(new Pair[]{TuplesKt.to("index", Integer.valueOf(r100)), TuplesKt.to("click_type", r101), TuplesKt.to("tracking_params", r102)}));
    }

    public final boolean c(int r100, int r101, int r102, List<? extends Map<String, ? extends Object>> r103) {
        Intrinsics.checkNotNullParameter(r103, "tagsContentViewSizeList");
        if (r101 >= 0) goto L6;
        return false;
    L6:
        LinkedHashMap r104 = new LinkedHashMap();
        ArrayList r105 = new ArrayList();
        int r106 = r101 + 1;
    L7:
        if (r100 >= r106) goto L9;
        r105.add(Integer.valueOf(r100));
        r100 = r100 + 1;
        goto L7
    L9:
        r104.put("index_list", r105);
        String r107 = w.f259758a;
        if (r107 != null) goto L12;
        r107 = "";
    L12:
        r104.put("shelf_cycle_uuid", r107);
        r104.put("real_card_dynamic_type", String.valueOf(r102));
        r104.put("tags_content_view_size_list", r103);
        return a("shelfCardShow", r104);
    }

    public final boolean d(LiveGoodsShelvesLynxDSLResponse r100, boolean r101, String r110, String r111, String r112, String r113) {
        if (r100 != null) goto L5;
    L34:
        return false;
    L5:
        if (this.f534906a.getLoadStatus() != 2) goto L34;
        if (r101 == false) goto L9;
    L11:
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("server_data", r100.f259573g)});
        if (r101 == false) goto L29;
        this.f534908c = true;
        r102.put("room_data", s.a(this.f534907b));
        Pair[] r103 = new Pair[9];
        r103[0] = TuplesKt.to("page_type", Integer.valueOf(r100.f259575i));
        r103[1] = TuplesKt.to("shelf_action_type", Integer.valueOf(r100.f259567a));
        r103[2] = TuplesKt.to("shelf_data_type", Integer.valueOf(r100.f259568b));
        r103[3] = TuplesKt.to("is_location_enabled", Integer.valueOf(LiveLifeSaaSUtil.v().a() ? 1 : 0));
        if (r111 != null) goto L16;
        r111 = "";
    L16:
        r103[4] = TuplesKt.to("data_cache_type", r111);
        if (r112 != null) goto L19;
        r112 = "";
    L19:
        r103[5] = TuplesKt.to("page_source", r112);
        r103[6] = TuplesKt.to("room_unique_key", this.f534907b);
        r103[7] = TuplesKt.to("shelf_id", String.valueOf(r100.f259575i));
        if (r113 != null) goto L22;
        r113 = "";
    L22:
        r103[8] = TuplesKt.to("shelf_from_position", r113);
        Map r104 = MapsKt.mutableMapOf(r103);
        if (r110 == null) goto L25;
        r104.put("btm_page_id", r110);
    L25:
        Map r114 = com.bytedance.locallife.live.settings.c.k();
        if (r114 == null) goto L28;
        r104.put("settings", r114);
    L28:
        r102.put("native_data", r104);
    L29:
        if (r101 == false) goto L31;
    L32:
        this.f534906a.c("shelfDataUpdate", CollectionsKt.listOf(r102));
    L33:
        return true;
    L31:
        if (this.f534908c == false) goto L33;
    L9:
        if (this.f534908c == true) goto L11;
        return false;
    }
}
