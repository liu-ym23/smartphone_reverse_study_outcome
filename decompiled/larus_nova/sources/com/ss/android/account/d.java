package com.ss.android.account;

import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class d extends a {
    public String A;
    public String B;
    public String C;
    public int D;
    public int E;
    public int F;
    public int G;
    public long H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f406240J;
    public int K;
    public boolean L;
    public String M;
    public String N;
    public String O;
    public int P;
    public int Q;
    public boolean R;
    public JSONObject S;
    public int T;
    public boolean U;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f406241u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f406242v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f406243w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f406244x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f406245y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f406246z;

    public final void a() throws Exception {
        JSONObject r100 = this.f541376q;
        com.bytedance.sdk.account.settings.common.a.a();
        long r101 = 0;
        String r102 = "user_id";
        if (com.bytedance.sdk.account.settings.common.a.f269398v == true) goto L89;
        this.f541360a = r100.optLong("user_id", 0);
    L8:
        this.f541361b = r100.optInt("odin_user_type", 0);
        String r103 = "";
        this.f541364e = r100.optString("sec_user_id", "");
        this.f541367h = r100.optString("session_key", "");
        if (r100.optInt("new_user") == 0) goto L11;
        boolean r104 = true;
    L12:
        this.f541366g = r104;
        this.f541368i = r100.optString("mobile", "");
        if (r100.optInt("has_password") == 0) goto L15;
        boolean r110 = true;
    L16:
        this.f541371l = r110;
        this.f541370k = r100.optString("sec_user_id", "");
        this.f541372m = r100.optBoolean("is_visitor_account", false);
        this.f541369j = r100.optString("email", "");
        cra.a r111 = new cra.a("mobile");
        cra.a r112 = new cra.a("email");
        String r113 = this.f541369j;
        r112.f465121c = r113;
        if (TextUtils.isEmpty(r113) == true) goto L19;
        ((HashMap) this.f541362c).put("email", r112);
    L19:
        String r105 = this.f541368i;
        r111.f465121c = r105;
        if (TextUtils.isEmpty(r105) == true) goto L22;
        ((HashMap) this.f541362c).put("mobile", r111);
    L22:
        com.bytedance.sdk.account.settings.common.a.a();
        int r106 = com.bytedance.sdk.account.settings.common.a.T;
        JSONArray r107 = r100.optJSONArray("connects");
        if (r107 == null) goto L70;
        int r114 = r107.length();
        System.currentTimeMillis();
        int r115 = 0;
    L25:
        if (r115 >= r114) goto L70;
        JSONObject r116 = JSONArrayProtectorUtils.getJSONObject(r107, r115);
        String r117 = JSONObjectProtectorUtils.getString(r116, "platform");
        if (r117 != null) goto L29;
    L68:
        long r118 = r101;
        String r119 = r103;
        JSONArray r120 = r107;
        String r108 = r102;
    L69:
        r115 = r115 + 1;
        r102 = r108;
        r107 = r120;
        r103 = r119;
        r101 = r118;
        goto L25
    L29:
        if (r117.length() == 0) goto L68;
        cra.a r109 = new cra.a(r117);
        r119 = r103;
        r109.f465129k = r100.optLong(r102, r101);
        if (r116.has("screen_name") == false) goto L35;
        r109.f465121c = r116.optString("screen_name");
    L37:
        r109.f465122d = r116.optString("profile_image_url");
        r109.f465123e = r116.optString("platform_uid");
        r109.f465124f = r116.optString("sec_platform_uid");
        r109.f465126h = r116.optLong("modify_time");
        r109.f465125g = r116.optString("create_time");
        r109.f465130l = r116.optInt("platform_app_id", 0);
        r109.f465120b = true;
        r109.f465134p = r116.optString("extra");
        if (r106 == 0) goto L40;
        r109.f465132n = r116.optString(Constants.JumpUrlConstants.URL_KEY_OPENID);
    L40:
        sc7.a r121 = com.bytedance.sdk.account.impl.h.a().l();
        if (r121 == null) goto L55;
        r120 = r107;
        if (r121.f541360a != this.f541360a) goto L56;
        Map r122 = (Map) ((HashMap) r121.f541363d).get(r117);
        if (r122 == null) goto L56;
        cra.a r123 = (cra.a) r122.get(String.valueOf(r109.f465130l));
        if (r123 == null) goto L56;
        r109.f465131m = r123.f465131m;
        if (r106 != 0) goto L51;
        r109.f465132n = r123.f465132n;
    L54:
        r109.f465133o = r123.f465133o;
        r109.f465128j = r123.f465128j;
        r109.f465127i = r123.f465127i;
        r109.f465136r = r123.f465136r;
        r109.f465135q = r123.f465135q;
        goto L56
    L51:
        if (TextUtils.isEmpty(r109.f465132n) == false) goto L54;
        r109.f465132n = r123.f465132n;
    L56:
        Map r124 = (Map) ((HashMap) this.f541363d).get(r117);
        if (r124 != null) goto L59;
        r124 = new HashMap();
        ((HashMap) this.f541363d).put(r117, r124);
    L59:
        cra.a r125 = (cra.a) r124.get(String.valueOf(r109.f465130l));
        if (r125 == null) goto L66;
        long r126 = r125.f465126h;
        r118 = 0;
        r108 = r102;
        if (r126 > 0) goto L64;
    L67:
        ((HashMap) this.f541362c).put(r117, r109.b());
        r124.put(String.valueOf(r109.f465130l), r109);
        goto L69
    L64:
        if (r126 <= r109.f465126h) goto L67;
    L66:
        r108 = r102;
        r118 = 0;
        goto L67
    L55:
        r120 = r107;
        goto L56
    L35:
        if (r116.has("platform_screen_name") == false) goto L37;
        r109.f465121c = r116.optString("platform_screen_name");
    L70:
        String r127 = r103;
        this.f541365f = r100.optInt("country_code", -1);
        if (r100.optInt("is_kids_mode") != 1) goto L73;
        boolean r128 = true;
    L74:
        this.f541373n = r128;
        r100.optString("lite_user_info_string", r127);
        r100.optInt("lite_user_info_demotion", 0);
        JSONObject r129 = this.f541376q;
        if (r129.has("name") == false) goto L78;
        this.f406230r = r129.optString("name");
    L80:
        this.f406232t = r129.optString("avatar_url");
        this.f406231s = r129.optString("description");
        JSONObject r130 = this.f541376q;
        this.D = r130.optInt("can_be_found_by_phone");
        this.E = r130.optInt("share_to_repost", -1);
        this.F = r130.optInt("user_privacy_extend") & 1;
        this.G = r130.optInt("user_privacy_extend");
        this.K = r130.optInt("gender");
        this.f406241u = r130.optString("screen_name");
        this.f406242v = r130.optString("verified_content");
        r130.optBoolean("is_generated");
        this.L = r130.optBoolean("user_verified");
        if (r130.optInt("is_recommend_allowed") == 0) goto L83;
        boolean r131 = true;
    L84:
        this.f406246z = r131;
        this.A = r130.optString("recommend_hint_message");
        this.B = r130.optString("user_decoration");
        this.C = r130.optString("user_auth_info");
        this.M = r130.optString("birthday");
        this.N = r130.optString("area");
        this.O = r130.optString("industry");
        this.Q = r130.optInt("is_blocked");
        this.P = r130.optInt("is_blocking");
        this.R = r130.optBoolean("is_toutiao");
        r130.optInt("has_password");
        JSONObject r132 = r130.optJSONObject("media");
        if (r132 == null) goto L87;
        this.f406244x = r132.optString("avatar_url");
        this.f406243w = r132.optLong("id");
        this.f406245y = r132.optString("name");
        this.f406240J = r132.optInt("display_app_ocr_entrance", 0);
    L87:
        r130.optInt("followings_count");
        r130.optInt("followers_count");
        r130.optInt("visit_count_recent");
        this.H = r130.optLong(AppConstants.BUNDLE_MEDIA_ID);
        this.I = r130.optString("bg_img_url");
        r130.optInt("app_id");
        this.S = r130.optJSONObject("expend_attrs");
        this.T = r130.optInt("hm_region");
        this.U = r130.optBoolean("use_hm_region", false);
        return;
    L83:
        r131 = false;
        goto L84
    L78:
        if (r129.has(HintConstants.AUTOFILL_HINT_USERNAME) == false) goto L80;
        this.f406230r = r129.optString(HintConstants.AUTOFILL_HINT_USERNAME);
        goto L80
    L73:
        r128 = false;
        goto L74
    L15:
        r110 = false;
        goto L16
    L11:
        r104 = false;
        goto L12
    L89:
        this.f541360a = CastLongProtector.parseLong(r100.optString("user_id_str", null));     // Catch: Exception -> L6
    L6:
        this.f541360a = r100.optLong("user_id", 0);
        goto L8
    }

    public d() {
        this.f406240J = 0;
        this.T = 0;
    }

    public d(JSONObject r100) {
        super(r100);
        this.f406240J = 0;
        this.T = 0;
    }

    public d(JSONObject r100, JSONObject r101) {
        super(r100, r101);
        this.f406240J = 0;
        this.T = 0;
    }
}
