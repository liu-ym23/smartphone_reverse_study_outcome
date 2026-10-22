package tx9;

import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class w0 {
    public static final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("current_page", "chat");     // Catch: JSONException -> L5
    L7:
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("account_risk_toast");
        r102.f21463a.merge(r101);
        r102.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper mobSdkVideoAuthStatus " + e.getLocalizedMessage());
        goto L7
    }

    public static final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        JSONObject r101 = new JSONObject();
        r101.put("status", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("sdk_video_auth_status");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper mobSdkVideoAuthStatus " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r101 != null) goto L19;
    L7:
        if (r102 == null) goto L9;
        r105.put("scene", r102);     // Catch: JSONException -> L5
    L9:
        if (r100 == null) goto L11;
        r105.put("enter_method", r100);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r105.put(MusicAppletPage.KEY_MESSAGE_ID, r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L17;
        r105.put("sec_enter_method", r104);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper showDouyinAuthorizeWindow " + e.getLocalizedMessage());
    L17:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("authorize_dialog_show");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L19:
        r105.put("content_type", r101);     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r101 != null) goto L20;
    L7:
        if (r102 == null) goto L9;
        r106.put("scene", r102);     // Catch: JSONException -> L5
    L9:
        if (r100 == null) goto L11;
        r106.put("enter_method", r100);     // Catch: JSONException -> L5
    L11:
        r106.put("content_action", r103);     // Catch: JSONException -> L5
        if (r104 == null) goto L14;
        r106.put(MusicAppletPage.KEY_MESSAGE_ID, r104);     // Catch: JSONException -> L5
    L14:
        if (r105 == null) goto L18;
        r106.put("sec_enter_method", r105);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper showDouyinAuthorizeWindow " + e.getLocalizedMessage());
    L18:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("authorize_dialog_click");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L20:
        r106.put("content_type", r101);     // Catch: JSONException -> L5
        goto L7
    }

    public static void f(String r100, String r101, String r102, String r103, String r104, String r105, String r106, JSONObject r107, int r110) {
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
        if ((r110 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r110 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r110 & 128) == 0) goto L26;
        r107 = new JSONObject();
    L26:
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r100 != null) goto L50;
    L31:
        if (r101 == null) goto L33;
        r107.put("page_type", r101);     // Catch: JSONException -> L29
    L33:
        if (r102 == null) goto L35;
        r107.put("enter_method", r102);     // Catch: JSONException -> L29
    L35:
        if (r103 == null) goto L37;
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r103);     // Catch: JSONException -> L29
    L37:
        if (r104 == null) goto L39;
        r107.put("sec_enter_method", r104);     // Catch: JSONException -> L29
    L39:
        if (r106 == null) goto L41;
        r107.put("action", r106);     // Catch: JSONException -> L29
    L41:
        if (r105 == null) goto L46;
        r107.put("bot_id", r105);     // Catch: JSONException -> L29
    L29:
        e = move-exception;
        FLogger.f375446a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper showDouyinAuthorizeWindow " + e.getLocalizedMessage());
    L46:
        if (r107.has("scene") == true) goto L48;
        r107.put("scene", "unknown");
    L48:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("show_douyin_authorize_window");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L50:
        r107.put("scene", r100);     // Catch: JSONException -> L29
        goto L31
    }

    public static void d(String r100, String r101, String r102, int r103, String r104, String r105, String r106, String r107, String r110, String r111, JSONObject r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r113 & 32) == 0) goto L18;
        r105 = null;
    L18:
        if ((r113 & 64) == 0) goto L21;
        r106 = null;
    L21:
        if ((r113 & 128) == 0) goto L24;
        r107 = null;
    L24:
        if ((r113 & 256) == 0) goto L27;
        r110 = null;
    L27:
        if ((r113 & 512) == 0) goto L30;
        r111 = null;
    L30:
        if ((r113 & 1024) == 0) goto L32;
        r112 = new JSONObject();
    L32:
        Intrinsics.checkNotNullParameter(r112, "params");
        if (r100 != null) goto L67;
    L37:
        if (r101 == null) goto L39;
        r112.put("page_type", r101);     // Catch: JSONException -> L35
    L39:
        if (r102 == null) goto L41;
        r112.put("enter_method", r102);     // Catch: JSONException -> L35
    L41:
        r112.put("is_success", r103);     // Catch: JSONException -> L35
        if (r104 != null) goto L44;
    L47:
        boolean r108 = true;
    L48:
        if (r108 == true) goto L50;
        r112.put(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, r104);     // Catch: JSONException -> L35
    L50:
        if (r105 == null) goto L52;
        r112.put(MusicAppletPage.KEY_MESSAGE_ID, r105);     // Catch: JSONException -> L35
    L52:
        if (r106 == null) goto L54;
        r112.put("sec_enter_method", r106);     // Catch: JSONException -> L35
    L54:
        if (r111 == null) goto L56;
        r112.put("action", r111);     // Catch: JSONException -> L35
    L56:
        if (r110 == null) goto L58;
        r112.put("bot_id", r110);     // Catch: JSONException -> L35
    L58:
        if (r107 == null) goto L63;
        r112.put("authorize_scopes", r107);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.f375446a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper douyinAuthorizeWindowResult " + e.getLocalizedMessage());
    L63:
        if (r112.has("scene") == true) goto L65;
        r112.put("scene", "unknown");
    L65:
        TrackParams r109 = new TrackParams().merge(r112);
        by7.a r114 = new by7.a("douyin_authorize_window_result");
        r114.f21463a.merge(r109);
        r114.b();
        return;
    L44:
        if (StringsKt.isBlank(r104) == true) goto L47;
        r108 = false;
        goto L48
    L67:
        r112.put("scene", r100);     // Catch: JSONException -> L35
        goto L37
    }
}
