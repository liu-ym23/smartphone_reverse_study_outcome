package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class g2 {
    public static void d(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("enter_method", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_switch_account_enter");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper click_switch_account_enter " + e.getLocalizedMessage());
        goto L7
    }

    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("reason", r100);     // Catch: JSONException -> L5
        r102.put("account_type", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("account_invalid_toast_show");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper account_invalid_toast_show " + e.getLocalizedMessage());
        goto L7
    }

    public static void e(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("click_from", r100);     // Catch: JSONException -> L7
        r103.put("current_page", "account_switch");     // Catch: JSONException -> L7
        r103.put("account_type", r101);     // Catch: JSONException -> L7
        if (r102 == null) goto L9;
        r103.put("account_id", r102);     // Catch: JSONException -> L7
    L9:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("confirm_relogin_account");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper confirm_relogin_account " + e.getLocalizedMessage());
        goto L9
    }

    public static void f(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("click_from", r100);     // Catch: JSONException -> L7
        r103.put("current_page", "account_switch");     // Catch: JSONException -> L7
        r103.put("account_type", r101);     // Catch: JSONException -> L7
        if (r102 == null) goto L9;
        r103.put("account_id", r102);     // Catch: JSONException -> L7
    L9:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("confirm_remove_account");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper confirm_remove_account " + e.getLocalizedMessage());
        goto L9
    }

    public static void b(String r100, String r101, String r102, by7.e r103, int r104) {
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
        JSONObject r105 = new JSONObject();
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = null;
    L18:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L34;
    L23:
        if (r101 == null) goto L25;
        r105.put("account_id", r101);     // Catch: JSONException -> L21
    L25:
        if (r102 == null) goto L29;
        r105.put("enter_method", r102);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.f375446a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper account_show " + e.getLocalizedMessage());
    L29:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("account_show");
        if (r103 == null) goto L32;
        r107.f21464b = r103;
    L32:
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L34:
        r105.put("account_type", r100);     // Catch: JSONException -> L21
        goto L23
    L14:
        r105 = null;
        goto L16
    }

    public static void h(String r100, String r101, String r102, String r103, int r104) {
        JSONObject r105 = null;
        if ((r104 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r104 & 32) == 0) goto L17;
        r105 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L32;
    L22:
        if (r101 == null) goto L24;
        r105.put("success", r101);     // Catch: JSONException -> L20
    L24:
        if (r102 == null) goto L26;
        r105.put("err_code", r102);     // Catch: JSONException -> L20
    L26:
        if (r103 == null) goto L30;
        r105.put("err_tips", r103);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper switch_account_result " + e.getLocalizedMessage());
    L30:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("switch_account_result");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L32:
        r105.put("enter_method", r100);     // Catch: JSONException -> L20
        goto L22
    }

    public static void g(String r100, String r101, String r102, String r103, String r104, int r105) {
        JSONObject r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r107 = null;
    L7:
        if ((r105 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r105 & 4) == 0) goto L13;
        r101 = null;
    L13:
        if ((r105 & 8) == 0) goto L16;
        r102 = null;
    L16:
        if ((r105 & 16) == 0) goto L19;
        r103 = null;
    L19:
        if ((r105 & 32) == 0) goto L22;
        r104 = null;
    L22:
        if ((r105 & 64) == 0) goto L24;
        r106 = new JSONObject();
    L24:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r107 != null) goto L43;
    L29:
        if (r100 == null) goto L31;
        r106.put("account_type", r100);     // Catch: JSONException -> L27
    L31:
        if (r101 == null) goto L33;
        r106.put("account_id", r101);     // Catch: JSONException -> L27
    L33:
        if (r102 == null) goto L35;
        r106.put("success", r102);     // Catch: JSONException -> L27
    L35:
        if (r103 == null) goto L37;
        r106.put("err_code", r103);     // Catch: JSONException -> L27
    L37:
        if (r104 == null) goto L41;
        r106.put("err_tips", r104);     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        FLogger.f375446a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper remove_account_result " + e.getLocalizedMessage());
    L41:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("remove_account_result");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L43:
        r106.put("current_page", r107);     // Catch: JSONException -> L27
        goto L29
    L5:
        r107 = "account_switch";
        goto L7
    }

    public static void c(String r100, String r101, String r102, String r103, String r104, JSONObject r105, int r106) {
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
        r105.put("click_from", r101);     // Catch: JSONException -> L23
    L27:
        if (r102 == null) goto L29;
        r105.put("switch_account_id", r102);     // Catch: JSONException -> L23
    L29:
        if (r103 == null) goto L31;
        r105.put("account_type", r103);     // Catch: JSONException -> L23
    L31:
        if (r104 == null) goto L35;
        r105.put("enter_method", r104);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.f375446a.e("MultiAccountEventHelper", "error in MultiAccountEventHelper click_switch_account " + e.getLocalizedMessage());
    L35:
        TrackParams r107 = new TrackParams().merge(r105);
        by7.a r108 = new by7.a("click_switch_account");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L37:
        r105.put("current_page", r100);     // Catch: JSONException -> L23
        goto L25
    }
}
