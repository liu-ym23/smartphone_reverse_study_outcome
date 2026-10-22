package tx9;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class w2 {
    public static void d(String r100, String r101, int r102) {
        JSONObject r103 = null;
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 4) == 0) goto L11;
        r103 = new JSONObject();
    L11:
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L22;
    L16:
        if (r101 == null) goto L20;
        r103.put("to_status", r101);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        FLogger.f375446a.e("PopupEventHelper", "error in PopupEventHelper popupVoiceEditFunctionClick " + e.getLocalizedMessage());
    L20:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("popup_voice_edit_function_click");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L22:
        r103.put("click_from", r100);     // Catch: JSONException -> L14
        goto L16
    }

    public static void c(String r100, String r101, JSONObject r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new JSONObject();
    L11:
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L23;
    L16:
        if (r101 == null) goto L18;
        r102.put("enter_method", r101);     // Catch: JSONException -> L14
    L18:
        r102.put("voice_create_id", b4.f547846a);     // Catch: JSONException -> L14
    L21:
        TrackParams r104 = new TrackParams().merge(r102);
        by7.a r105 = new by7.a("popup_voice_create_confirm_show");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L14:
        e = move-exception;
        FLogger.f375446a.e("PopupEventHelper", "error in PopupEventHelper popupVoiceCreateConfirmShow " + e.getLocalizedMessage());
        goto L21
    L23:
        r102.put("previous_page", r100);     // Catch: JSONException -> L14
        goto L16
    }

    public static void b(String r100, String r101, String r102, JSONObject r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new JSONObject();
    L14:
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L28;
    L19:
        if (r101 == null) goto L21;
        r103.put("previous_page", r101);     // Catch: JSONException -> L17
    L21:
        if (r102 == null) goto L23;
        r103.put("enter_method", r102);     // Catch: JSONException -> L17
    L23:
        r103.put("voice_create_id", b4.f547846a);     // Catch: JSONException -> L17
    L26:
        TrackParams r105 = new TrackParams().merge(r103);
        by7.a r106 = new by7.a("popup_record_test_show");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L17:
        e = move-exception;
        FLogger.f375446a.e("PopupEventHelper", "error in PopupEventHelper popupRecordTestShow " + e.getLocalizedMessage());
        goto L26
    L28:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_STATUS, r100);     // Catch: JSONException -> L17
        goto L19
    }

    public static void a(String r100, Long r101, String r102, String r103, String r104, JSONObject r105, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 32) == 0) goto L20;
        r105 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L38;
    L25:
        if (r101 == null) goto L27;
        r105.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r101.longValue());     // Catch: JSONException -> L23
    L27:
        if (r102 == null) goto L29;
        r105.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_STATUS, r102);     // Catch: JSONException -> L23
    L29:
        if (r103 == null) goto L31;
        r105.put("previous_page", r103);     // Catch: JSONException -> L23
    L31:
        if (r104 == null) goto L33;
        r105.put("enter_method", r104);     // Catch: JSONException -> L23
    L33:
        r105.put("voice_create_id", b4.f547846a);     // Catch: JSONException -> L23
    L36:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("popup_record_test_function_click");
        r107.f21463a.merge(r106);
        r107.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("popup_record_test_function_click", r107.c(), null, null);
        return;
    L23:
        e = move-exception;
        FLogger.f375446a.e("PopupEventHelper", "error in PopupEventHelper popupRecordTestFunctionClick " + e.getLocalizedMessage());
        goto L36
    L38:
        r105.put("click_from", r100);     // Catch: JSONException -> L23
        goto L25
    }

    public static void e(String r100, Long r101, String r102, String r103, String r104, JSONObject r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L37;
    L25:
        if (r101 == null) goto L27;
        r105.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r101.longValue());     // Catch: JSONException -> L23
    L27:
        if (r102 == null) goto L29;
        r105.put("previous_page", r102);     // Catch: JSONException -> L23
    L29:
        if (r103 == null) goto L31;
        r105.put("enter_method", r103);     // Catch: JSONException -> L23
    L31:
        if (r104 == null) goto L35;
        r105.put("voice_create_id", r104);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.f375446a.e("PopupEventHelper", "error in PopupEventHelper popupVoiceRecordFunctionClick " + e.getLocalizedMessage());
    L35:
        TrackParams r107 = new TrackParams().merge(r105);
        by7.a r108 = new by7.a("popup_voice_record_function_click");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L37:
        r105.put("click_from", r100);     // Catch: JSONException -> L23
        goto L25
    }
}
