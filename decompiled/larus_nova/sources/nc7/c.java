package nc7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.impl.c0;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends c0<ua7.h> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ua7.h f518646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f518647l;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        String r101 = this.f518647l;
        com.bytedance.sdk.account.monitor.c.g("passport_auth_change_bind", r101, null, (ua7.h) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
        ua7.h r102 = new ua7.h(false, 70004);
        this.f518646k = r102;
        r102.f549259m = r101;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        ua7.h r102 = new ua7.h(true, 70004);
        this.f518646k = r102;
        r102.f549259m = r100;
        com.ss.android.account.d r103 = new com.ss.android.account.d(r100);
        r103.a();
        r102.f549279p = r103;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        if (this.f518646k != null) goto L5;
        this.f518646k = new ua7.h(r100, 70004);
    L5:
        ua7.h r102 = this.f518646k;
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
        return r102;
    }

    public c(Context r100, lb7.a r101, sa7.h<ua7.h> r102) {
        super(r100, r101, r102);
    }

    public static c p(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, boolean r107, boolean r110, Map<String, String> r111, sa7.h<ua7.h> r112) {
        lb7.a.C6671a r108 = new lb7.a.C6671a();
        r108.f508360a = ta7.d.a("/passport/auth/change_bind/");
        r108.e("platform", r101);
        r108.e("platform_app_id", r102);
        r108.f(r111);
        if (TextUtils.isEmpty(r103) == true) goto L6;
        r108.e("code", r103);
    L6:
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r108.e("access_token", r104);
    L9:
        if (TextUtils.isEmpty(r105) == true) goto L12;
        r108.e(ITwitterService.ResponseConstants.AUTH_TOKEN, r105);
    L12:
        if (TextUtils.isEmpty(r106) == true) goto L15;
        r108.e("profile_key", r106);
    L15:
        if (r107 == false) goto L17;
        r108.e("verify_type", "1");
    L17:
        if (r110 == false) goto L19;
        r108.e("verified_ticket", "1");
    L19:
        c r109 = new c(r100, r108.h(), r112);
        r109.f518647l = r101;
        return r109;
    }
}
