package nz9;

import by7.e;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c {
    public static void a(Integer r100, String r101, String r102, Boolean r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.putOpt(BdpAppEventConstant.PARAMS_CLICK_POSITION, r100);     // Catch: JSONException -> L7
        r104.putOpt("current_page", r101);     // Catch: JSONException -> L7
        r104.putOpt("click_from", r102);     // Catch: JSONException -> L7
        r104.putOpt(ShareConstants.KEY_PANEL_TYPE, "create_button_panel");     // Catch: JSONException -> L7
        if (r103 == null) goto L9;
        r104.putOpt("is_function_available", Integer.valueOf(r103.booleanValue() ? 1 : 0));     // Catch: JSONException -> L7
    L9:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("click_create_panel");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("InstructionHitPoints", "error in mobImageEditFunctionClick " + e.getLocalizedMessage());
        goto L9
    }

    public static void d(Integer r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = "";
    L15:
        if ((r104 & 16) == 0) goto L17;
        JSONObject r105 = new JSONObject();
    L18:
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.putOpt("position", r100);     // Catch: JSONException -> L21
        r105.putOpt("current_page", r101);     // Catch: JSONException -> L21
        r105.putOpt("schema_name", r102);     // Catch: JSONException -> L21
        r105.putOpt(ShareConstants.KEY_PANEL_TYPE, r103);     // Catch: JSONException -> L21
    L23:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("show_create_panel_cell");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L21:
        e = move-exception;
        FLogger.f375446a.e("InstructionHitPoints", "error in mobImageEditFunctionClick " + e.getLocalizedMessage());
        goto L23
    L17:
        r105 = null;
        goto L18
    }

    public static /* synthetic */ void c(String r110, Integer r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118) {
        b(r110, r111, r112, r113, r114, r115, r116, r117, new JSONObject(), null, r118);
    }

    public static final void b(String r100, Integer r101, String r102, String r103, String r104, String r105, String r106, String r107, JSONObject r108, e r110, String r111) {
        Intrinsics.checkNotNullParameter(r108, "params");
        r108.putOpt("ai_generate_tab_id", r105);     // Catch: JSONException -> L7
        r108.putOpt("ai_generate_tab_name", r107);     // Catch: JSONException -> L7
        r108.putOpt("ai_generate_tab_type", r106);     // Catch: JSONException -> L7
        r108.putOpt("bot_id", r111);     // Catch: JSONException -> L7
        r108.putOpt("leave_reason", r100);     // Catch: JSONException -> L7
        r108.putOpt("stay_duration", r101);     // Catch: JSONException -> L7
        r108.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r103);     // Catch: JSONException -> L7
        r108.putOpt("action_bar_template_type", r104);     // Catch: JSONException -> L7
        if (r102 == null) goto L9;
        r108.put("enter_method", r102);     // Catch: JSONException -> L7
    L9:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r112 = new by7.a("leave_image_generate_page");
        if (r110 == null) goto L12;
        r112.f21464b = r110;
    L12:
        r112.f21463a.merge(r109);
        r112.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("InstructionHitPoints", "error in mobLeaveImageGeneratePage " + e.getLocalizedMessage());
        goto L9
    }
}
