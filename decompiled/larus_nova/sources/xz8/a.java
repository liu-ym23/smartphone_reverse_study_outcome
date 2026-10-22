package xz8;

import com.ixigua.lib.track.TrackParams;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final void b(String r100, String r101, String r102, String r103) {
        IApplog.Companion r104 = IApplog.f287053a;
        JSONObject r105 = new JSONObject();
        r105.put("current_page", "login_with_doubao");
        r105.put("trigger_app", r100);
        r105.put("click_from", r101);
        r105.put("account_type", r102);
        r105.put("switch_account_id", r103);
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("login_with_doubao_switch_account", r105);
    }

    public static final void c(String r100, String r101, String r102, String r103) {
        IApplog.Companion r104 = IApplog.f287053a;
        JSONObject r105 = new JSONObject();
        r105.put("current_page", "login_with_doubao");
        r105.put("trigger_app", r100);
        r105.put("account_type", r101);
        r105.put("switch_account_id", r102);
        r105.put("result", r103);
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("login_with_doubao_switch_account_result", r105);
    }

    public static void a(Boolean r100, String r101, String r102, String r103, String r104, int r105) {
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
    L47:
        e = move-exception;
        FLogger.f375446a.e("AuthorizeTraceHelper", "error in AuthorizeTraceHelper enterAddFriendPage " + e.getLocalizedMessage());
    L49:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("login_with_doubao_result");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L26:
        if (o0.d(r107) == false) goto L28;
        r106.put("current_page", r107);     // Catch: JSONException -> L47
    L28:
        if (r100 == null) goto L35;
        if (r100.booleanValue() == false) goto L32;
        int r110 = 1;
    L33:
        r106.put("success", r110);     // Catch: JSONException -> L47
        goto L35
    L32:
        r110 = 0;
    L35:
        if (o0.d(r101) == false) goto L38;
        r106.put("trigger_app", r101);     // Catch: JSONException -> L47
    L38:
        if (o0.d(r102) == false) goto L41;
        r106.put("error_code", r102);     // Catch: JSONException -> L47
    L41:
        if (o0.d(r103) == false) goto L44;
        r106.put("origin_error_code", r103);     // Catch: JSONException -> L47
    L44:
        if (o0.d(r104) == false) goto L49;
        r106.put("error_msg", r104);     // Catch: JSONException -> L47
        goto L49
    L5:
        r107 = "login_with_doubao";
        goto L7
    }
}
