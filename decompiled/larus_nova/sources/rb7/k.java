package rb7;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.impl.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class k extends c0<xa7.k> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f536968n = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public xa7.k f536969k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f536970l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f536971m;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        String r101 = this.f536970l;
        com.bytedance.sdk.account.monitor.c.g("update_authorize_info", r101, null, (xa7.k) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
        xa7.k r102 = new xa7.k(false, this.f536970l, this.f536971m);
        this.f536969k = r102;
        r102.f549277y = r100.optString("captcha");
        r102.f549278z = r100.optString("desc_url");
        r102.f549259m = r101;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        xa7.k r102 = new xa7.k(true, this.f536970l, this.f536971m);
        this.f536969k = r102;
        r102.a(r100, r101);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        xa7.k r102 = this.f536969k;
        if (r102 != null) goto L5;
        r102 = new xa7.k(r100, this.f536970l, this.f536971m);
    L6:
        if (r100 == true) goto L8;
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
    L8:
        return r102;
    L5:
        r102.f549249c = r100;
        goto L6
    }

    public k(Context r100, lb7.a r101, String r102, String r103, ua7.a r104) {
        super(r100, r101, r104);
        this.f536971m = -1;
        this.f536970l = r102;
        this.f536971m = CastIntegerProtector.parseInt(r103);     // Catch: Throwable -> L5
        return;
    }
}
