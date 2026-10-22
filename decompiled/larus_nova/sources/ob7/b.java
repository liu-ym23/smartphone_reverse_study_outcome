package ob7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.impl.c0;
import com.bytedance.sdk.account.platform.PlatformProfileAdapter;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import ta7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends c0<c> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f522613k;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("user_get_oauth_profile", null, null, (c) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
        this.f522613k = r101;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        r101.optString("name");
        r101.optString("avatar_url");
        r101.optJSONObject("extraInfo");
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        c r102 = new c(r100);
        r102.f549259m = this.f522613k;
        if (r100 == true) goto L6;
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
    L6:
        return r102;
    }

    public b(Context r100, lb7.a r101, PlatformProfileAdapter.ProfileCallback r102) {
        super(r100, r101, r102);
    }

    public static b p(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, Map r110, PlatformProfileAdapter.ProfileCallback r111) {
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        r107.f508360a = d.a("/user/get/oauth_profile/");
        HashMap r108 = new HashMap();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r108.put("platform_app_id", r101);
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r108.put("platform", r102);
    L9:
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r108.put("code", r103);
    L12:
        if (TextUtils.isEmpty(r104) == true) goto L15;
        r108.put("access_token", r104);
    L15:
        if (TextUtils.isEmpty(r105) == true) goto L18;
        r108.put("access_token_secret", r105);
    L18:
        if (TextUtils.isEmpty(r106) == true) goto L20;
        r108.put("expires_in", r106);
    L20:
        r107.g(r108, r110);
        r107.f508361b = MonitorConstants.CONNECT_TYPE_GET;
        return new b(r100, r107.c(), r111);
    }
}
