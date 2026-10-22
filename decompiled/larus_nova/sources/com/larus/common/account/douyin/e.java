package com.larus.common.account.douyin;

import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.tencent.connect.common.Constants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static void a(String r100, String r101, String r102, Long r103, Integer r104, String r105, Long r106, Long r107, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r105 = null;
    L18:
        if ((r110 & 64) == 0) goto L21;
        r106 = null;
    L21:
        if ((r110 & 128) == 0) goto L23;
        r107 = null;
    L23:
        Intrinsics.checkNotNullParameter(r100, "isSuccess");
        JSONObject r111 = new JSONObject();
        r111.put("is_success", r100);     // Catch: JSONException -> L40
        if (r101 == null) goto L27;
        r111.put(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, r101);     // Catch: JSONException -> L40
    L27:
        if (r102 == null) goto L29;
        r111.put(Constants.JumpUrlConstants.URL_KEY_OPENID, r102);     // Catch: JSONException -> L40
    L29:
        if (r103 == null) goto L31;
        r111.put("refresh_time", r103.longValue());     // Catch: JSONException -> L40
    L31:
        if (r104 == null) goto L33;
        r111.put("error_code", r104.intValue());     // Catch: JSONException -> L40
    L33:
        if (r105 == null) goto L35;
        r111.put("error_msg", r105);     // Catch: JSONException -> L40
    L35:
        if (r106 == null) goto L37;
        r111.put("expire_in", r106.longValue());     // Catch: JSONException -> L40
    L37:
        if (r107 == null) goto L42;
        r111.put("refresh_expire_in", r107.longValue());     // Catch: JSONException -> L40
    L42:
        TrackParams r108 = new TrackParams().merge(r111);
        by7.a r109 = new by7.a("refresh_act_result");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L40:
        e = move-exception;
        FLogger.f375446a.e("DouyinAuthEventHelper", "error in DouyinAuthEventHelper refreshAuthTokenResult " + e.getLocalizedMessage());
        goto L42
    }
}
