package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class s1 {
    public static void c(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        if (com.larus.utils.o0.d(r100) == false) goto L5;
        r101.put("current_page", r100);
    L5:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("login_error_toast");
        r103.f21463a.merge(r102);
        r103.b();
    }

    public static void e(String r100, String r101, String r102, by7.e r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.put("current_page", r100);     // Catch: JSONException -> L5
        r104.put("previous_page", r101);     // Catch: JSONException -> L5
        r104.put("guide_type", r102);     // Catch: JSONException -> L5
    L7:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("show_login_guide");
        if (r103 == null) goto L10;
        r106.f21464b = r103;
    L10:
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("LoginEventHelper", "error in LoginEventHelper showLoginGuide " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r100, String r101, String r102, String r103, by7.e r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        JSONObject r106 = new JSONObject();
    L19:
        if ((r105 & 32) == 0) goto L21;
        r104 = null;
    L21:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L39;
    L26:
        if (r101 == null) goto L28;
        r106.put("previous_page", r101);     // Catch: JSONException -> L24
    L28:
        if (r102 == null) goto L30;
        r106.put("guide_type", r102);     // Catch: JSONException -> L24
    L30:
        if (r103 == null) goto L34;
        r106.put("click_from", r103);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.f375446a.e("LoginEventHelper", "error in LoginEventHelper clickLoginGuide " + e.getLocalizedMessage());
    L34:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("click_login_guide");
        if (r104 == null) goto L37;
        r108.f21464b = r104;
    L37:
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L39:
        r106.put("current_page", r100);     // Catch: JSONException -> L24
        goto L26
    L17:
        r106 = null;
        goto L19
    }

    public static void d(String r100, String r101, Long r102, String r103, JSONObject r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r100 != null) goto L32;
    L22:
        if (r101 == null) goto L24;
        r104.put("previous_page", r101);     // Catch: JSONException -> L20
    L24:
        if (r102 == null) goto L26;
        r104.put("position", r102.longValue());     // Catch: JSONException -> L20
    L26:
        if (r103 == null) goto L30;
        r104.put("type", r103);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("LoginEventHelper", "error in LoginEventHelper loginTypeShow " + e.getLocalizedMessage());
    L30:
        TrackParams r106 = new TrackParams().merge(r104);
        by7.a r107 = new by7.a("login_type_show");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L32:
        r104.put("current_page", r100);     // Catch: JSONException -> L20
        goto L22
    }

    public static void a(String r100, String r101, boolean r102, String r103, String r104, String r105, String r106, by7.e r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r111 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r111 & 128) == 0) goto L17;
        JSONObject r107 = new JSONObject();
    L19:
        if ((r111 & 256) == 0) goto L21;
        r110 = null;
    L21:
        Intrinsics.checkNotNullParameter(r105, "type");
        Intrinsics.checkNotNullParameter(r106, "scene");
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r100 != null) goto L45;
    L26:
        if (r101 == null) goto L29;
        r107.put("previous_page", r101);     // Catch: JSONException -> L24
    L29:
        if (r102 == false) goto L31;
        int r108 = 1;
    L32:
        r107.put("success", String.valueOf(r108));     // Catch: JSONException -> L24
        if (r103 == null) goto L35;
        r107.put("result", r103);     // Catch: JSONException -> L24
    L35:
        if (r104 == null) goto L37;
        r107.put("bind_fail_step", r104);     // Catch: JSONException -> L24
    L37:
        r107.put("type", r105);     // Catch: JSONException -> L24
        r107.put("scene", r106);     // Catch: JSONException -> L24
    L40:
        TrackParams r109 = new TrackParams().merge(r107);
        by7.a r112 = new by7.a("bind_with_account");
        if (r110 == null) goto L43;
        r112.f21464b = r110;
    L43:
        r112.f21463a.merge(r109);
        r112.b();
        return;
    L24:
        e = move-exception;
        FLogger.f375446a.e("LoginEventHelper", "error in LoginEventHelper clickLoginGuide " + e.getLocalizedMessage());
        goto L40
    L31:
        r108 = 0;
        goto L32
    L45:
        r107.put("current_page", r100);     // Catch: JSONException -> L24
        goto L26
    L17:
        r107 = null;
        goto L19
    }
}
