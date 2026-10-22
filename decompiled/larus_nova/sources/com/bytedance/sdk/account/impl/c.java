package com.bytedance.sdk.account.impl;

import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    public static class a {
        public static void b(nc7.j r100, JSONObject r101) {
            if (r101.has("error_code") == false) goto L6;
            r100.f518635a = r101.optInt("error_code", r100.f518635a);
        L8:
            r100.f518636b = r101.optString("description");
            String r102 = r101.optString("name");
            if ("connect_switch".equals(r102) == false) goto L11;
        L12:
            r100.f518661k = r101.optString("description");
            r100.f518662l = r101.optString("dialog_tips");
            r100.f518663m = r101.optString(ITwitterService.ResponseConstants.AUTH_TOKEN);
        L14:
            if (r100.f518635a != 1075) goto L17;
            r100.f518640f = r101.optLong("apply_time");
            r100.f518643i = r101.optString("avatar_url");
            r100.f518642h = r101.optString("nick_name");
            r100.f518639e = r101.optString("token");
            r100.f518641g = r101.optLong("cancel_time");
        L17:
            if (r100.f518635a != 1041) goto L20;
            r101.optString("screen_name");
            r101.optString("avatar_url");
            r101.optString("last_login_time");
            r101.optString("mobile");
            r101.optString("platform_screen_name_current");
            r101.optString("platform_screen_name_conflict");
            return;
        L20:
            return;
        L11:
            if ("connect_exist".equals(r102) == false) goto L14;
        L6:
            if (r101.has("code") == false) goto L8;
            r100.f518635a = r101.optInt("code", r100.f518635a);
            goto L8
        }

        public static com.ss.android.account.d c(JSONObject r100, JSONObject r101) throws Exception {
            com.ss.android.account.d r102 = new com.ss.android.account.d(r100, r101);
            r102.a();
            return r102;
        }

        public static ua7.h a(nc7.j r100, boolean r101, int r102) {
            ua7.h r103 = new ua7.h(r101, r102);
            r103.f549253g = r100.f518635a;
            r103.f549255i = r100.f518636b;
            r103.f549280q = r100.f518661k;
            r103.f549281r = r100.f518662l;
            r103.f549282s = r100.f518663m;
            r103.f549279p = r100.f518660j;
            return r103;
        }
    }

    public static void a(nc7.a r100, JSONObject r101) {
        if (r101.has("error_code") == false) goto L6;
        r100.f518635a = r101.optInt("error_code", r100.f518635a);
    L8:
        r100.f518636b = r101.optString("description");
        if (r100.f518635a != 1075) goto L12;
        r100.f518640f = r101.optLong("apply_time");
        r100.f518643i = r101.optString("avatar_url");
        r100.f518642h = r101.optString("nick_name");
        r100.f518639e = r101.optString("token");
        r100.f518641g = r101.optLong("cancel_time");
        return;
    L12:
        return;
    L6:
        if (r101.has("code") == false) goto L8;
        r100.f518635a = r101.optInt("code", r100.f518635a);
        goto L8
    }

    public static void c(wb7.e r100, JSONObject r101) {
        if (r101.has("error_code") == false) goto L6;
        r100.f559013a = r101.optInt("error_code", r100.f559013a);
    L8:
        r100.f559014b = r101.optString("description");
        r100.f559015c = r101.optString("captcha");
        r101.optString("alert_text");
        if (r100.f559013a != 1001) goto L14;
        if ((r100 instanceof wb7.k) == false) goto L14;
        wb7.k r102 = (wb7.k) r100;
        r101.optString("dialog_tips");
    L14:
        if (r100.f559013a != 1057) goto L19;
        if ((r100 instanceof wb7.k) == false) goto L19;
        wb7.k r103 = (wb7.k) r100;
        r101.optString("dialog_tips");
        r101.optString("next_url");
    L19:
        if (r100.f559013a != 1057) goto L24;
        if ((r100 instanceof wb7.f) == false) goto L24;
        wb7.f r104 = (wb7.f) r100;
        r104.f559018f = r101.optString("dialog_tips");
        r104.f559019g = r101.optString("next_url");
    L24:
        if (r100.f559013a != 1075) goto L27;
        r101.optLong("apply_time");
        r101.optString("avatar_url");
        r101.optString("nick_name");
        r101.optString("token");
        r101.optLong("cancel_time");
        return;
    L27:
        return;
    L6:
        if (r101.has("code") == false) goto L8;
        r100.f559013a = r101.optInt("code", r100.f559013a);
        goto L8
    }

    public static ec7.a d(xa7.g r100, String r101) {
        tb7.a.d("ApiHelper", "transformOnekeyLoginErrorResponse");
        ec7.a r102 = new ec7.a();
        r102.netType = r101;
        r102.errorType = 4;
        r102.platformErrorCode = String.valueOf(r100.f549253g);
        String r103 = r100.f549255i;
        r102.platformErrorMsg = r103;
        r102.smsCodeKey = r100.f563087u;
        r102.mDetailErrorCode = r100.f549254h;
        r102.mDetailErrorMsg = r100.f549256j;
        r102.error = r100.f549253g;
        r102.errorMsg = r103;
        JSONObject r104 = r100.f549259m;
        if (r104 == null) goto L6;
        r102.rawResult = r104.optJSONObject("data");
    L6:
        if (r100.f549253g != 1075) goto L8;
        r102.mCancelApplyTime = r100.f563083q;
        r102.mCancelAvatarUrl = r100.f563086t;
        r102.mCancelNickName = r100.f563085s;
        r102.mCancelTime = r100.f563084r;
        r102.mCancelToken = r100.f563082p;
    L8:
        return r102;
    }

    public static lb7.a.C6671a b(String r100, String r101, String r102, String r103, String r104, String r105, Map<String, String> r106) {
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r107.e("platform", r100);
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r107.e("access_token", r101);
    L9:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        r107.e("expires_in", r102);
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        r107.e("code", r103);
    L15:
        if (TextUtils.isEmpty(r104) == true) goto L18;
        r107.e("profile_key", r104);
    L18:
        if (TextUtils.isEmpty(r105) == true) goto L20;
        r107.e("platform_app_id", r105);
    L20:
        if (r106 != null) goto L22;
    L29:
        return r107;
    L22:
        if (r106.isEmpty() == true) goto L29;
        Iterator<String> r108 = r106.keySet().iterator();
    L25:
        if (r108.hasNext() == false) goto L29;
        String r109 = r108.next();
        if (TextUtils.isEmpty(r109) == true) goto L25;
        r107.e(r109, r106.get(r109));
        goto L25
    }
}
