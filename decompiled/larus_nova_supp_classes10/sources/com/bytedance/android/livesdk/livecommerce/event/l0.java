package com.bytedance.android.livesdk.livecommerce.event;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Deprecated(message = "直播间减少单例获取信息, 改为LiveRoomParams")
public final class l0 {
    public static String a;

    public static String d() {
        return i("enter_from_merge");
    }

    public static String e() {
        return i("enter_method");
    }

    public static String f() {
        return i("follow_status");
    }

    public static HashMap<String, String> g() {
        int r0 = RoomContextController.h;
        if (RoomContextController.a.a().x() == false) goto L5;
        HashMap<String, String> r1 = new HashMap(RoomContextController.a.a().K());
    L9:
        r1.put("room_unique_key", RoomContextController.a.a().D());
        int r2 = ECSdk.a;
        IECCommonService r3 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r3 == null) goto L16;
        Map<? extends String, ? extends String> r4 = r3.getExplainReplayCommonParams();
        if (r4 == null) goto L16;
        if (r4.size() <= 0) goto L16;
        r1.putAll(r4);
    L16:
        return r1;
    L5:
        fh2.a r5 = PromotionListController.H();
        if (r5 == null) goto L8;
        r1 = new HashMap(((LivePromotionListFragment) r5).ga0());
        goto L9
    L8:
        r1 = new HashMap();
        goto L9
    }

    public static String c() {
        HashMap<String, String> r1 = g();
        JSONObject r15 = new JSONObject();
        r15.putOpt("carrier_source", r1.get("enter_from_merge"));     // Catch: Exception -> L22
        r15.putOpt("source_method", r1.get("enter_method"));     // Catch: Exception -> L22
        r15.putOpt("ecom_group_type", "live");     // Catch: Exception -> L22
        r15.putOpt("carrier_type", "live_add_to_cart");     // Catch: Exception -> L22
        r15.putOpt("room_id", r1.get("room_id"));     // Catch: Exception -> L22
        r15.putOpt("anchor_id", r1.get("anchor_id"));     // Catch: Exception -> L22
        r15.putOpt("follow_status", r1.get("follow_status"));     // Catch: Exception -> L22
        r15.putOpt("request_id", r1.get("request_id"));     // Catch: Exception -> L22
        r15.putOpt("group_id", r1.get("group_id"));     // Catch: Exception -> L22
        r15.putOpt("enter_from_merge", r1.get("enter_from_merge"));     // Catch: Exception -> L22
        r15.putOpt("enter_method", r1.get("enter_method"));     // Catch: Exception -> L22
        r15.putOpt("action_type", r1.get("action_type"));     // Catch: Exception -> L22
        r15.putOpt("creative_id", r1.get("creative_id"));     // Catch: Exception -> L22
        r15.putOpt("is_other_channel", r1.get("is_other_channel"));     // Catch: Exception -> L22
        r15.putOpt("live_tracker_params", r1.get("live_tracker_params"));     // Catch: Exception -> L22
        r15.putOpt("add_cart_source", "live");     // Catch: Exception -> L22
        String r0 = r1.get("search_params");     // Catch: Exception -> L22
        if (r0 == null) goto L6;
        r15.putOpt("search_params", r0);     // Catch: Exception -> L22
    L13:
        r15.putOpt("log_extra", r1.get("log_extra"));     // Catch: Exception -> L22
        Lazy r2 = ExtraController.l;     // Catch: Exception -> L22
        ExtraController r3 = ControllerCenter.c(null, null).u;     // Catch: Exception -> L22
        Objects.toString(r3);     // Catch: Exception -> L22
        JSONObject r4 = r3.H();     // Catch: Exception -> L22
        if (r4 == null) goto L25;
        Iterator<String> r5 = r4.keys();     // Catch: Exception -> L22
    L16:
        if (r5.hasNext() == false) goto L25;
        String r6 = r5.next();     // Catch: Exception -> L22
        Object r7 = r4.opt(r6);     // Catch: Exception -> L22
        if (r7 == null) goto L16;
        r15.putOpt(r6, r7.toString());     // Catch: Exception -> L22
    L25:
        return r15.toString();
    L6:
        String r8 = r1.get("live_tracker_params");     // Catch: Exception -> L22
        String r9 = "";
        if (TextUtils.isEmpty(r8) == false) goto L26;
    L12:
        r15.putOpt("search_params", r9);     // Catch: Exception -> L22
        goto L13
    L26:
        r9 = new JSONObject(r8).optString("search_params", "");     // Catch: JSONException -> L10 Exception -> L22
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L25
    }

    public static String l() {
        return g().get("request_id");
    }

    public static String n() {
        HashMap<String, String> r0 = g();
        return "" + r0.get("enter_from_merge") + "_temai_" + r0.get("enter_method");
    }

    public static HashMap<String, String> o() {
        if (RoomContextController.H().x() == false) goto L5;
        ECContext r0 = RoomContextController.H().r();
    L6:
        if (r0 == null) goto L14;
        if (((Map) r0.getEnterRoomParams().getValue()).containsKey("jump_schema") == false) goto L12;
        HashMap<String, String> r1 = new HashMap((Map) r0.getEnterRoomParams().getValue());
        r1.remove("jump_schema");
        return r1;
    L12:
        return (HashMap) r0.getEnterRoomParams().getValue();
    L14:
        return new HashMap();
    L5:
        r0 = null;
        goto L6
    }

    public static JSONObject b(Map<String, String> r1) {
        String r2 = r1.get("tracker_params");
        if (r2 == null) goto L12;
        return new JSONObject(r2);
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L12:
        return null;
    }

    public static HashMap<String, String> h(RoomContextController r2) {
        if (r2.x() == false) goto L5;
        HashMap<String, String> r0 = new HashMap(r2.K());
    L9:
        int r3 = ECSdk.a;
        IECCommonService r4 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r4 == null) goto L16;
        Map<? extends String, ? extends String> r5 = r4.getExplainReplayCommonParams();
        if (r5 == null) goto L16;
        if (r5.size() <= 0) goto L16;
        r0.putAll(r5);
    L16:
        return r0;
    L5:
        String r1 = r2.B();
        String r6 = r2.D();
        PromotionListController.T.getClass();
        fh2.a r7 = PromotionListController.a.b(r1, r6);
        if (r7 == null) goto L8;
        r0 = new HashMap(((LivePromotionListFragment) r7).ga0());
        goto L9
    L8:
        r0 = new HashMap();
        goto L9
    }

    public static String i(String r1) {
        String r2 = g().get(r1);
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        return "";
    }

    public static JSONObject p(Map<String, String> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r3 = r2.get("pass_through_log_data");
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return null;
    L13:
        return new JSONObject(r3);
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public static void q(JSONObject r1) {
        r1.remove("pass_through_log_data");
        r1.remove("multi_room_data");
        r1.remove("single_room_data");
    }

    public static Uri u(Uri r5) {
        Uri.Builder r0 = r5.buildUpon();
        r0.clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r5).iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        String r2 = (String) r1.next();
        if (r2.equals("as_panel") == false) goto L7;
        r0.appendQueryParameter(r2, BDLocationException.ERROR_TIMEOUT);
        goto L4
    L7:
        Iterator r3 = UriProtector.getQueryParameters(r5, r2).iterator();
    L9:
        if (r3.hasNext() == false) goto L4;
        r0.appendQueryParameter(r2, (String) r3.next());
        goto L9
    L13:
        return r0.build();
    }

    public static String j(String r0, RoomContextController r1) {
        if (r1 == null) goto L4;
        String r2 = h(r1).get(r0);
        if (TextUtils.isEmpty(r2) == true) goto L8;
        return r2;
    L8:
        return "";
    L4:
        return i(r0);
    }

    public static String m(String r1, String r2) {
        int r0 = RoomContextController.h;
        RoomContextController r3 = RoomContextController.a.b(r1, r2);
        if (r3.x() == true) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        return BDLocationException.ERROR_TIMEOUT;
    L11:
        return "1";
    L5:
        if (r3.A().t.m == true) goto L8;
        r4 = false;
        goto L9
    }

    public static String a(String r3, String r4, String r5) {
        Uri r1 = UriProtector.parse(r3);     // Catch: Exception -> L9
        String r2 = UriProtector.getQueryParameter(r1, "url");     // Catch: Exception -> L9
        if (r2 == null) goto L8;
        return t(r1, "url", t(UriProtector.parse(r2), r4, r5).toString()).toString();
    L8:
        return t(r1, r4, r5).toString();
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r3;
    }

    public static String k(String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L30
        Iterator<Map.Entry<String, String>> r1 = g().entrySet().iterator();     // Catch: Exception -> L30
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<String, String> r2 = r1.next();     // Catch: Exception -> L30
        r0.put(r2.getKey(), r2.getValue());     // Catch: Exception -> L30
        goto L4
    L7:
        if (r6 != null) goto L33;
    L17:
        r0.put("enter_from", "live");     // Catch: Exception -> L30
        r0.put("category_name", d() + "_temai_" + i("enter_method"));     // Catch: Exception -> L30
        r0.put("carrier_type", r5);     // Catch: Exception -> L30
        HashMap<String, String> r7 = o();     // Catch: Exception -> L30
        if (r7.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();     // Catch: Exception -> L30
    L21:
        if (r8.hasNext() == false) goto L23;
        Map.Entry<String, String> r9 = r8.next();     // Catch: Exception -> L30
        r0.put(r9.getKey(), r9.getValue());     // Catch: Exception -> L30
    L23:
        r0.put("live_list_channel", r4);     // Catch: Exception -> L30
        q(r0);     // Catch: Exception -> L30
        int r10 = com.bytedance.android.livesdk.livecommerce.room.controller.w.h;     // Catch: Exception -> L30
        r0.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b());     // Catch: Exception -> L30
        RoomContextController r11 = RoomContextController.a.a();     // Catch: Exception -> L30
        r0.put("display_room_id", r11.B());     // Catch: Exception -> L30
        r0.put("display_anchor_id", r11.y());     // Catch: Exception -> L30
        r0.put("display_sec_anchor_id", r11.z());     // Catch: Exception -> L30
        r0.put("display_follow_status", r11.K().get("follow_status"));     // Catch: Exception -> L30
        com.bytedance.android.ec.model.response.n1 r12 = r11.f;     // Catch: Exception -> L30
        if (r12 != null) goto L26;
    L28:
        return Uri.encode(r0.toString());
    L26:
        if (r12.a() == null) goto L28;
        int r13 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;     // Catch: Exception -> L30
        r0.put("ecom_linkmic_room_ids", com.bytedance.android.livesdk.livecommerce.utils.m0.a.a.toJson(r12.a()));     // Catch: Exception -> L30
        goto L28
    L33:
        JSONObject r3 = new JSONObject(r6);     // Catch: Exception -> L15
        Iterator<String> r14 = r3.keys();     // Catch: Exception -> L15
    L10:
        if (r14.hasNext() == false) goto L17;
        String r15 = r14.next();     // Catch: Exception -> L15
        Object r16 = r3.opt(r15);     // Catch: Exception -> L15
        if (r16 == null) goto L10;
        r0.putOpt(r15, r16.toString());     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return "";
    }

    public static String s(String r3, String r4, Pair<String, String>... r5) {
        Uri r0 = UriProtector.parse(r3);
        String r1 = UriProtector.getQueryParameter(r0, r4);
        if (r1 != null) goto L5;
        return r3;
    L5:
        if (r1.isEmpty() == false) goto L8;
        return r3;
    L8:
        return t(r0, r4, (String) r(r1, new String[]{"entrance_info"}, 0, r5)).toString();
    }

    public static Uri t(Uri r5, String r6, String r7) {
        if (r7 == null) goto L25;
        Uri.Builder r0 = r5.buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r5, r6)) == false) goto L7;
        r0.appendQueryParameter(r6, r7);
    L18:
        return r0.build();
    L7:
        r0.clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r5).iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        String r2 = (String) r1.next();
        if (r2.equals(r6) == false) goto L12;
        r0.appendQueryParameter(r2, r7);
        goto L9
    L12:
        Iterator r3 = UriProtector.getQueryParameters(r5, r2).iterator();
    L14:
        if (r3.hasNext() == false) goto L9;
        r0.appendQueryParameter(r2, (String) r3.next());
        goto L14
    L25:
        return r5;
    }

    public static Object r(Object r4, String[] r5, int r6, Pair<String, String>... r7) {
        int r1 = 0;
        if ((r4 instanceof JSONObject) == false) goto L6;
        JSONObject r0 = (JSONObject) r4;     // Catch: Exception -> L28
        boolean r2 = true;
    L12:
        if (r6 < r5.length) goto L21;
        int r8 = r7.length;     // Catch: Exception -> L28
    L14:
        if (r1 >= r8) goto L24;
        Pair<String, String> r9 = r7[r1];     // Catch: Exception -> L28
        if (r9.getFirst() == null) goto L20;
        if (r9.getSecond() == null) goto L20;
        r0.put((String) r9.getFirst(), r9.getSecond());     // Catch: Exception -> L28
    L20:
        r1 = r1 + 1;     // Catch: Exception -> L28
    L24:
        if (r2 == false) goto L26;
        return r0;
    L26:
        return r0.toString();
    L21:
        Object r3 = r0.opt(r5[r6]);     // Catch: Exception -> L28
        if (r3 == null) goto L24;
        Object r10 = r(r3, r5, r6 + 1, r7);     // Catch: Exception -> L28
        r0.put(r5[r6], r10);     // Catch: Exception -> L28
        goto L24
    L6:
        if ((r4 instanceof String) == false) goto L37;
        String r11 = (String) r4;     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r11) == false) goto L10;
        r11 = "{}";
    L10:
        r0 = new JSONObject(r11);     // Catch: Exception -> L28
        r2 = false;
        goto L12
    L37:
        return r4;
    L28:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r4;
    }
}
