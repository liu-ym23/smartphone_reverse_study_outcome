package tx9;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class r0 {
    public static void f(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "clickFrom");
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.putOpt("click_from", r101);     // Catch: JSONException -> L5
        r102.putOpt("current_page", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("replica_management_function_click");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("mobReplicaManagementFunctionClick", "error is " + e.getLocalizedMessage());
        goto L7
    }

    public static void h(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "replicaCreateId");
        Intrinsics.checkNotNullParameter(r101, "clickFrom");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.putOpt("replica_create_id", r100);     // Catch: JSONException -> L7
        r104.putOpt("click_from", r101);     // Catch: JSONException -> L7
        r104.putOpt("scene", r102);     // Catch: JSONException -> L7
        if (r103 == null) goto L9;
        r104.putOpt("enter_method", r103);     // Catch: JSONException -> L7
    L9:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("upload_replica_pic");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("mobUploadReplicaPic", "error is " + e.getLocalizedMessage());
        goto L9
    }

    public static void e(String r100, String r101, String r102, long r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "leaveReason");
        Intrinsics.checkNotNullParameter(r102, "replicaCreateId");
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.putOpt("scene", r100);     // Catch: JSONException -> L5
        r105.putOpt("replica_create_id", r102);     // Catch: JSONException -> L5
        r105.putOpt("leave_reason", r101);     // Catch: JSONException -> L5
        r105.putOpt("stay_duration", Long.valueOf(r103));     // Catch: JSONException -> L5
        r105.putOpt("enter_method", r104);     // Catch: JSONException -> L5
    L7:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("leave_create_replica_page");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("mobLeaveCreateReplicaPage", "error is " + e.getLocalizedMessage());
        goto L7
    }

    public static void g(TraceFragment r100, String r101, String r102, boolean r103, int r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter("replica_video_record_page", "currentPage");
        Intrinsics.checkNotNullParameter(r101, "recordingStep");
        Intrinsics.checkNotNullParameter(r102, "replicaCreateId");
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.putOpt("current_page", "replica_video_record_page");     // Catch: JSONException -> L9
        r105.putOpt("replica_create_id", r102);     // Catch: JSONException -> L9
        if (r103 == false) goto L6;
        int r106 = 1;
    L7:
        r105.putOpt("is_has_replica", Integer.valueOf(r106));     // Catch: JSONException -> L9
        r105.putOpt("beauty_filter_level", Integer.valueOf(r104));     // Catch: JSONException -> L9
        r105.putOpt("recording_step", r101);     // Catch: JSONException -> L9
    L11:
        TrackParams r107 = new TrackParams().merge(r105);
        by7.a r108 = new by7.a("replica_video_record_step");
        if (r100 == null) goto L14;
        r108.f21464b = r100;
    L14:
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L6:
        r106 = 0;
    L9:
        e = move-exception;
        FLogger.f375446a.e("mobReplicaVideoRecordStep", "error is " + e.getLocalizedMessage());
        goto L11
    }

    public static void i(String r100, String r101, boolean r102, long r103, String r104, String r105, int r106) {
        JSONObject r107 = null;
        if ((r106 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r106 & 16) == 0) goto L9;
        r104 = null;
    L9:
        if ((r106 & 32) == 0) goto L12;
        r105 = null;
    L12:
        if ((r106 & 64) == 0) goto L14;
        r107 = new JSONObject();
    L14:
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r107, "params");
        r107.putOpt("scene", r100);     // Catch: JSONException -> L25
        r107.putOpt("duration", Long.valueOf(r103));     // Catch: JSONException -> L25
        r107.putOpt("replica_create_id", r101);     // Catch: JSONException -> L25
        if (r102 == false) goto L18;
        int r108 = 1;
    L19:
        r107.putOpt("success", Integer.valueOf(r108));     // Catch: JSONException -> L25
        r107.putOpt("pic_id", "");     // Catch: JSONException -> L25
        if (r104 == null) goto L22;
        r107.putOpt(MapMonitorConst.ERROR_INFO, r104);     // Catch: JSONException -> L25
    L22:
        if (r105 == null) goto L27;
        r107.putOpt("enter_method", r105);     // Catch: JSONException -> L25
    L27:
        TrackParams r109 = new TrackParams().merge(r107);
        by7.a r110 = new by7.a("upload_replica_pic_result");
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L18:
        r108 = 0;
    L25:
        e = move-exception;
        FLogger.f375446a.e("mobUploadReplicaPicResult", "error is " + e.getLocalizedMessage());
        goto L27
    }

    public static final void c(String r100, int r101, int r102, Boolean r103, String r104, JSONObject r105, String r106, by7.e r107) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.putOpt("pic_cnt", Integer.valueOf(r101));     // Catch: JSONException -> L12
        r105.putOpt("video_cnt", Integer.valueOf(r102));     // Catch: JSONException -> L12
        if (r103 == null) goto L10;
        r103.booleanValue();     // Catch: JSONException -> L12
        if (r103.booleanValue() == false) goto L8;
        int r108 = 1;
    L9:
        r105.putOpt("is_replica_same_person", Integer.valueOf(r108));     // Catch: JSONException -> L12
        goto L10
    L8:
        r108 = 0;
    L10:
        r105.putOpt("scene", r100);     // Catch: JSONException -> L12
        r105.putOpt("replica_create_id", r104);     // Catch: JSONException -> L12
        r105.putOpt("enter_method", r106);     // Catch: JSONException -> L12
    L14:
        TrackParams r109 = new TrackParams().merge(r105);
        by7.a r110 = new by7.a("complete_create_replica");
        if (r107 == null) goto L17;
        r110.f21464b = r107;
    L17:
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L12:
        e = move-exception;
        FLogger.f375446a.e("mobClickCompleteCreateReplica", "error is " + e.getLocalizedMessage());
        goto L14
    }

    public static void a(String r100, int r101, int r102, String r103, String r104, String r105, String r106, Integer r110, String r111, TraceFragment r112, int r113) {
        if ((r113 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r113 & 16) == 0) goto L9;
        r104 = null;
    L9:
        if ((r113 & 32) == 0) goto L12;
        r105 = null;
    L12:
        if ((r113 & 64) == 0) goto L15;
        r106 = null;
    L15:
        if ((r113 & 128) == 0) goto L18;
        r110 = null;
    L18:
        if ((r113 & 256) == 0) goto L20;
        JSONObject r107 = new JSONObject();
    L22:
        if ((r113 & 512) == 0) goto L25;
        r111 = "";
    L25:
        if ((r113 & 1024) == 0) goto L27;
        r112 = null;
    L27:
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r107, "params");
        r107.putOpt("ai_generate_tab_id", r104);     // Catch: JSONException -> L30
        r107.putOpt("ai_generate_tab_name", r106);     // Catch: JSONException -> L30
        r107.putOpt("ai_generate_tab_type", r105);     // Catch: JSONException -> L30
        r107.putOpt("scene", r100);     // Catch: JSONException -> L30
        r107.putOpt("replica_create_id", r103);     // Catch: JSONException -> L30
        r107.putOpt("pic_cnt", Integer.valueOf(r101));     // Catch: JSONException -> L30
        r107.putOpt("video_cnt", Integer.valueOf(r102));     // Catch: JSONException -> L30
        r107.putOpt("enter_method", r111);     // Catch: JSONException -> L30
        r107.putOpt("beauty_filter_level", r110);     // Catch: JSONException -> L30
    L32:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("click_complete_create_replica");
        if (r112 == null) goto L35;
        r109.f21464b = r112;
    L35:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L30:
        e = move-exception;
        FLogger.f375446a.e("mobClickCompleteCreateReplica", "error is " + e.getLocalizedMessage());
        goto L32
    L20:
        r107 = null;
        goto L22
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, Boolean r112, int r113) {
        JSONObject r108 = null;
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r113 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r113 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r113 & 1024) == 0) goto L36;
        r112 = null;
    L36:
        if ((r113 & 2048) == 0) goto L38;
        r108 = new JSONObject();
    L38:
        Intrinsics.checkNotNullParameter(r108, "params");
        r108.putOpt("ai_generate_tab_id", r104);     // Catch: JSONException -> L45
        r108.putOpt("ai_generate_tab_name", r106);     // Catch: JSONException -> L45
        r108.putOpt("ai_generate_tab_type", r105);     // Catch: JSONException -> L45
        r108.putOpt("replica_create_id", r100);     // Catch: JSONException -> L45
        r108.putOpt("enter_method", r101);     // Catch: JSONException -> L45
        r108.putOpt("is_from_template", r102);     // Catch: JSONException -> L45
        r108.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r103);     // Catch: JSONException -> L45
        r108.putOpt("current_page", r107);     // Catch: JSONException -> L45
        r108.putOpt("from_template_type", r110);     // Catch: JSONException -> L45
        r108.putOpt("click_from", r111);     // Catch: JSONException -> L45
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == false) goto L42;
        int r109 = 1;
    L43:
        r108.putOpt("is_has_replica", Integer.valueOf(r109));     // Catch: JSONException -> L45
    L47:
        TrackParams r114 = new TrackParams().merge(r108);
        by7.a r115 = new by7.a("click_create_replica");
        r115.f21463a.merge(r114);
        r115.b();
        return;
    L42:
        r109 = 0;
    L45:
        e = move-exception;
        FLogger.f375446a.e("mobClickCreateReplica", "error in click_create_replica " + e.getLocalizedMessage());
        goto L47
    }

    public static void d(String r110, int r111, int r210, String r211, boolean r212, long r213, String r214, String r215, String r216, String r217, String r218, String r310, String r311, String r312, String r313, String r314, String r315, String r316, Boolean r317, int r318) {
        JSONObject r100 = null;
        if ((r318 & 8) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r318 & 64) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r318 & 128) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r318 & 256) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r318 & 512) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r318 & 1024) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r318 & 2048) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r318 & 4096) == 0) goto L33;
        String r112 = null;
    L35:
        if ((r318 & 8192) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r318 & 16384) == 0) goto L41;
        String r114 = null;
    L43:
        if ((32768 & r318) == 0) goto L45;
        String r115 = null;
    L47:
        if ((65536 & r318) == 0) goto L49;
        String r116 = null;
    L51:
        if ((131072 & r318) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r318 & 262144) == 0) goto L57;
        Boolean r118 = null;
    L59:
        if ((r318 & 524288) == 0) goto L61;
        r100 = new JSONObject();
    L61:
        Intrinsics.checkNotNullParameter(r110, "scene");
        String r219 = r117;
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.putOpt("ai_generate_tab_id", r106);     // Catch: JSONException -> L82
        r100.putOpt("ai_generate_tab_name", r112);     // Catch: JSONException -> L82
        r100.putOpt("ai_generate_tab_type", r107);     // Catch: JSONException -> L82
        r100.putOpt("is_from_template", r104);     // Catch: JSONException -> L82
        r100.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r105);     // Catch: JSONException -> L82
        r100.putOpt("scene", r110);     // Catch: JSONException -> L82
        r100.putOpt("duration", Long.valueOf(r213));     // Catch: JSONException -> L82
        r100.putOpt("replica_create_id", r101);     // Catch: JSONException -> L82
        r100.putOpt("pic_cnt", Integer.valueOf(r111));     // Catch: JSONException -> L82
        r100.putOpt("video_cnt", Integer.valueOf(r210));     // Catch: JSONException -> L82
        r100.putOpt("enter_method", r103);     // Catch: JSONException -> L82
        if (r212 == false) goto L65;
        int r108 = 1;
    L66:
        r100.putOpt("success", Integer.valueOf(r108));     // Catch: JSONException -> L82
        if (r118 == null) goto L69;
        r118.booleanValue();     // Catch: JSONException -> L82
        r100.putOpt("is_replica_same_person", Integer.valueOf(r118.booleanValue() ? 1 : 0));     // Catch: JSONException -> L82
    L69:
        if (r102 == null) goto L71;
        r100.putOpt(MapMonitorConst.ERROR_INFO, r102);     // Catch: JSONException -> L82
    L71:
        if (r113 == null) goto L73;
        r100.put("ai_creation_recommend_from", r113);     // Catch: JSONException -> L82
    L73:
        if (r114 == null) goto L75;
        r100.put("previous_page", r114);     // Catch: JSONException -> L82
    L75:
        if (r115 == null) goto L77;
        r100.put("current_page", r115);     // Catch: JSONException -> L82
    L77:
        if (r116 == null) goto L79;
        r100.put("chat_type", r116);     // Catch: JSONException -> L82
    L79:
        if (r219 == null) goto L84;
        r100.put("bot_id", r219);     // Catch: JSONException -> L82
    L84:
        TrackParams r109 = new TrackParams().merge(r100);
        by7.a r119 = new by7.a("create_replica_result");
        r119.f21463a.merge(r109);
        r119.b();
        return;
    L65:
        r108 = 0;
    L82:
        e = move-exception;
        FLogger.f375446a.e("mobClickCompleteCreateReplica", "error is " + e.getLocalizedMessage());
        goto L84
    L57:
        r118 = r317;
        goto L59
    L53:
        r117 = r316;
        goto L55
    L49:
        r116 = r315;
        goto L51
    L45:
        r115 = r314;
        goto L47
    L41:
        r114 = r313;
        goto L43
    L37:
        r113 = r312;
        goto L39
    L33:
        r112 = r311;
        goto L35
    L29:
        r107 = r310;
        goto L31
    L25:
        r106 = r218;
        goto L27
    L21:
        r105 = r217;
        goto L23
    L17:
        r104 = r216;
        goto L19
    L13:
        r103 = r215;
        goto L15
    L9:
        r102 = r214;
        goto L11
    L5:
        r101 = r211;
        goto L7
    }
}
