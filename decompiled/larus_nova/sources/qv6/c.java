package qv6;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.live.goodsshelves.bean.ServerTimeExtra;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static final void a(Map<String, String> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "etExtra");
        Intrinsics.checkNotNullParameter(r101, "roomData");
        Object r102 = r101.get("room_unique_key");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.String");
        r100.put("room_unique_key", (String) r102);
        Object r103 = r101.get("is_ad_live_event");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");
        r100.put("is_ad_live_event", (String) r103);
        r100.put("local_life_log_info", com.bytedance.locallife.common.utils.f.b(r101.get("local_life_log_info")));
        Object r104 = r101.get("delivery_status_start");
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.String");
        r100.put("delivery_status_start", (String) r104);
        Object r105 = r101.get(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.String");
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LOCALLIFE_LIVE_PARAMS, (String) r105);
        Object r106 = r101.get("log_pb");
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.String");
        r100.put("log_pb", (String) r106);
        Object r107 = r101.get("is_life");
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.String");
        r100.put("is_life", (String) r107);
        Object r108 = r101.get(ILiveRoomPlayFragmentConstant.EXTRA_LIFE_REFLUX_INFO);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.String");
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LIFE_REFLUX_INFO, (String) r108);
        Object r109 = r101.get("live_life_enter_params");
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.String");
        r100.put("live_life_enter_params", (String) r109);
    }

    public static final void c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("set_list", "refreshType");
        Intrinsics.checkNotNullParameter(r101, "shelfIsEmpty");
        Intrinsics.checkNotNullParameter(r102, "updateListEmpty");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("refresh_type", "set_list");
        r103.put("shelf_list_empty", r101);
        r103.put("update_list_empty", r102);
        int r104 = e.f534905a;
        e.a("live_local_life_refresh_shelf_list", r103, true, r100);
    }

    public static final void h(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "status");
        Map r103 = MapsKt.mapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(r101)), TuplesKt.to("status", r102), TuplesKt.to("location", "live_shelf")});
        int r104 = e.f534905a;
        e.b("live_life_performance_picture_net_request", r103, true, r100);
    }

    public static /* synthetic */ void e(String r100, boolean r101, int r102, String r103) {
        d(r100, r101, r102, r103, null, null);
    }

    public static final void g(String r100, long r101, String r102, f r103) {
        Intrinsics.checkNotNullParameter(r102, "toPosition");
        Pair r104 = TuplesKt.to("to_position", r102);
        boolean r105 = true;
        Map r106 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration_time", String.valueOf(r101 / 1000.0f)), r104});
        if (r103 == null) goto L7;
        Intrinsics.checkNotNullParameter(r106, "data");
        if (r103.a("shelfDidDisappear", r106) != true) goto L7;
    L8:
        if (r105 == true) goto L11;
        int r107 = e.f534905a;
        e.a("live_life_shelf_duration", r106, false, r100);
        return;
    L11:
        return;
    L7:
        r105 = false;
        goto L8
    }

    public static final void b(String r100, String r101, String r102, String r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "location");
        Intrinsics.checkNotNullParameter(r101, "totalTime");
        Intrinsics.checkNotNullParameter(r102, "innerTime");
        Intrinsics.checkNotNullParameter(r103, "linkTime");
        Intrinsics.checkNotNullParameter(r104, "extraMap");
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("location", r100);
        r105.put("total_time", r101);
        r105.put("inner_time", r102);
        r105.put("link_time", r103);
        r105.putAll(r104);
        e.b("live_life_performance_network_timing", r105, true, null);
    }

    public static final void d(String r100, boolean r101, int r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r103, "url");
        LinkedHashMap r106 = new LinkedHashMap();
        if (r101 == false) goto L5;
        r106.put("need_retry", "1");
    L6:
        if (r104 == null) goto L8;
        r106.put("select_tab_id", r104);
    L8:
        if (r105 == null) goto L10;
        r106.put(ChameleonOpenTracker.ParamKey.LOAD_TYPE, r105);
    L10:
        r106.put("status_code", String.valueOf(r102));
        r106.put(BdpAppEventConstant.PARAMS_REQUEST_URL, r103);
        int r107 = e.f534905a;
        e.a("live_life_shelf_api_request_time", r106, true, r100);
        return;
    L5:
        r106.put("need_retry", "0");
        goto L6
    }

    public static void f(String r110, long r111, String r112, int r210, String r211, boolean r212, String r213, String r214, String r215, ServerTimeExtra r216, String r217, String r218, Map r219, int r310) {
        if ((r310 & 16) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r310 & 32) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r310 & 64) == 0) goto L13;
        String r102 = "icon";
    L14:
        Map r103 = null;
        if ((r310 & 512) == 0) goto L17;
        ServerTimeExtra r104 = null;
    L19:
        if ((r310 & 1024) == 0) goto L21;
        String r113 = null;
    L23:
        if ((r310 & 2048) == 0) goto L25;
        String r114 = null;
    L27:
        if ((r310 & 4096) != 0) goto L30;
        r103 = r219;
    L30:
        Intrinsics.checkNotNullParameter(r112, "status");
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        Intrinsics.checkNotNullParameter(r214, "location");
        Intrinsics.checkNotNullParameter(r215, "time");
        Pair[] r115 = new Pair[6];
        Map r220 = r103;
        r115[0] = TuplesKt.to("duration", String.valueOf(r111));
        r115[1] = TuplesKt.to("status", r112);
        r115[2] = TuplesKt.to("location", r214);
        r115[3] = TuplesKt.to("time", r215);
        if (r101 == false) goto L33;
        String r105 = "1";
    L34:
        r115[4] = TuplesKt.to("use_cache", r105);
        r115[5] = TuplesKt.to("page_source", r102);
        Map r106 = MapsKt.mutableMapOf(r115);
        if (r104 == null) goto L37;
        long r107 = r104.getServerEndTime() - r104.getServerStartTime();
        r106.put("server_inner_time", String.valueOf(r107));
        r106.put("link_time", String.valueOf(r111 - r107));
    L37:
        if (r113 == null) goto L39;
        r106.put("select_tab_id", r113);
    L39:
        if (r114 == null) goto L42;
        r106.put(ChameleonOpenTracker.ParamKey.LOAD_TYPE, r114);
    L42:
        if (Intrinsics.areEqual(r112, "fail") == false) goto L44;
        r106.put("error_code", String.valueOf(r210));
        r106.put("error_msg", r100);
    L44:
        if (r220 == null) goto L46;
        r106.putAll(r220);
    L46:
        int r108 = e.f534905a;
        e.b("live_life_performance_net_request", r106, true, r110);
        return;
    L33:
        r105 = "0";
        goto L34
    L25:
        r114 = r218;
        goto L27
    L21:
        r113 = r217;
        goto L23
    L17:
        r104 = r216;
        goto L19
    L13:
        r102 = r213;
        goto L14
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
