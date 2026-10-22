package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class w {
    public static void a(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("current_page", "user_case_detail");     // Catch: JSONException -> L9
        r103.put("button_name", r100);     // Catch: JSONException -> L9
        if (r101 == null) goto L6;
        r103.put("user_case_reco_request_id", r101);     // Catch: JSONException -> L9
    L6:
        if (r102 == null) goto L11;
        r103.put("user_case_item_id", r102);     // Catch: JSONException -> L9
    L11:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("CaseTraceHelper", "error in CaseTraceHelper mobCaseButtonClick " + e.getLocalizedMessage());
        goto L11
    }

    public static void b(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("current_page", "user_case_detail");     // Catch: JSONException -> L9
        r103.put("button_name", r100);     // Catch: JSONException -> L9
        if (r101 == null) goto L6;
        r103.put("user_case_reco_request_id", r101);     // Catch: JSONException -> L9
    L6:
        if (r102 == null) goto L11;
        r103.put("user_case_item_id", r102);     // Catch: JSONException -> L9
    L11:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("show_button");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("CaseTraceHelper", "error in CaseTraceHelper mobCaseButtonShow " + e.getLocalizedMessage());
        goto L11
    }

    public static void c(String r100, String r101, boolean r102, int r103, String r104, String r105) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("current_page", r100);     // Catch: JSONException -> L13
        r106.put("cell_type", "user_case");     // Catch: JSONException -> L13
        r106.put("recommend_from", r101);     // Catch: JSONException -> L13
        if (r102 == false) goto L6;
        String r107 = "1";
    L7:
        r106.put("is_set_grey", r107);     // Catch: JSONException -> L13
        r106.put("index", r103);     // Catch: JSONException -> L13
        if (r104 == null) goto L10;
        r106.put("user_case_reco_request_id", r104);     // Catch: JSONException -> L13
    L10:
        if (r105 == null) goto L15;
        r106.put("user_case_item_id", r105);     // Catch: JSONException -> L13
    L15:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("list_cell_click");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L6:
        r107 = "0";
    L13:
        e = move-exception;
        FLogger.f375446a.e("CaseTraceHelper", "error in CaseTraceHelper mobCaseListElementClick " + e.getLocalizedMessage());
        goto L15
    }

    public static void d(String r100, String r101, boolean r102, int r103, String r104, String r105) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L23;
    L7:
        r106.put("cell_type", "user_case");     // Catch: JSONException -> L5
        if (r101 == null) goto L11;
        r106.put("recommend_from", r101);     // Catch: JSONException -> L5
    L11:
        if (r102 == false) goto L13;
        String r107 = "1";
    L14:
        r106.put("is_set_grey", r107);     // Catch: JSONException -> L5
        r106.put("index", r103);     // Catch: JSONException -> L5
        if (r104 == null) goto L17;
        r106.put("user_case_reco_request_id", r104);     // Catch: JSONException -> L5
    L17:
        if (r105 == null) goto L21;
        r106.put("user_case_item_id", r105);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("CaseTraceHelper", "error in CaseTraceHelper mobCaseListElementShow " + e.getLocalizedMessage());
    L21:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("list_cell_show");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L13:
        r107 = "0";
        goto L14
    L23:
        r106.put("current_page", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
