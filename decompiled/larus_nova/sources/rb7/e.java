package rb7;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.sdk.account.impl.c0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends c0<xa7.e> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f536951l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public xa7.e f536952k;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("passport_auth_available_ways", null, null, (xa7.e) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        xa7.e r102 = new xa7.e(true);
        this.f536952k = r102;
        r102.f563073p = r101.optString("email");
        r102.f563074q = r101.optBoolean("has_email");
        r102.f563075r = r101.optBoolean("has_mobile");
        r102.f563076s = r101.optBoolean("has_oauth");
        r102.f563077t = r101.optBoolean("has_pwd");
        r102.f563078u = r101.optBoolean("is_most_device");
        r102.f563079v = r101.optString("mobile");
        r102.f563081x = r101.optString("token");
        ArrayList r103 = new ArrayList();
        JSONArray r104 = r101.optJSONArray("oauth_platforms");
        if (r104 != null) goto L5;
    L9:
        r102.f563080w = r103;
        return;
    L5:
        if (r104.length() <= 0) goto L9;
        int r105 = r104.length();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r103.add(JSONArrayProtectorUtils.getString(r104, r106));
        r106 = r106 + 1;
        goto L7
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        xa7.e r102 = this.f536952k;
        if (r102 == null) goto L5;
        r102.f549249c = r100;
    L6:
        if (r100 == true) goto L8;
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
    L8:
        this.f536952k = null;
        return r102;
    L5:
        r102 = new xa7.e(r100);
        goto L6
    }

    public e(Context r100, lb7.a r101, p38.e r102) {
        super(r100, r101, r102);
    }
}
