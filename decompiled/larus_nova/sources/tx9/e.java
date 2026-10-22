package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class e {
    public static void a(String r100, String r101, int r102) {
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
        r103.put("age_verification_type", r101);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        FLogger.f375446a.e("AgeEventHelper", "error in AgeEventHelper ageBlockLoginWindowShow " + e.getLocalizedMessage());
    L20:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("age_block_login_window_show");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L22:
        r103.put("type", r100);     // Catch: JSONException -> L14
        goto L16
    }

    public static void b(long r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r102 & 4) == 0) goto L11;
        JSONObject r103 = new JSONObject();
    L12:
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("code", r100);     // Catch: JSONException -> L15
        r103.put("decision", r101);     // Catch: JSONException -> L15
    L17:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("age_check_result");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("AgeEventHelper", "error in AgeEventHelper mobAgeCheckResult " + e.getLocalizedMessage());
        goto L17
    L11:
        r103 = null;
        goto L12
    }

    public static void c(String r100, String r101, String r102, String r103, int r104) {
        JSONObject r105 = null;
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r104 & 16) == 0) goto L17;
        r105 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L32;
    L22:
        if (r101 == null) goto L24;
        r105.put("type", r101);     // Catch: JSONException -> L20
    L24:
        if (r102 == null) goto L26;
        r105.put("age_verification_type", r102);     // Catch: JSONException -> L20
    L26:
        if (r103 == null) goto L30;
        r105.put("page_hierarchy", r103);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("AgeEventHelper", "error in AgeEventHelper ageVerificationWindowClick " + e.getLocalizedMessage());
    L30:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("age_verification_window_click");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L32:
        r105.put("click_from", r100);     // Catch: JSONException -> L20
        goto L22
    }

    public static void d(String r100, String r101, String r102, String r103, int r104) {
        JSONObject r105 = null;
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r104 & 16) == 0) goto L17;
        r105 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r101 != null) goto L32;
    L22:
        if (r100 == null) goto L24;
        r105.put("type", r100);     // Catch: JSONException -> L20
    L24:
        if (r102 == null) goto L26;
        r105.put("age_verification_type", r102);     // Catch: JSONException -> L20
    L26:
        if (r103 == null) goto L30;
        r105.put("page_hierarchy", r103);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("AgeEventHelper", "error in AgeEventHelper ageVerificationWindowShow " + e.getLocalizedMessage());
    L30:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("age_verification_window_show");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L32:
        r105.put("current_page", r101);     // Catch: JSONException -> L20
        goto L22
    }
}
