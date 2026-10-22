package rb7;

import android.content.Context;
import com.bytedance.sdk.account.impl.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends c0<xa7.b> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f536940o = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f536941k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f536942l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f536943m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f536944n;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("passport_mobile_check_unusable", null, null, (xa7.b) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        this.f536941k = r101.optBoolean("is_unusable");
        this.f536942l = r101.optBoolean("is_verified");
        this.f536943m = r101.optBoolean("mno_support");
        this.f536944n = r101.optString("ticket");
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        xa7.b r102 = new xa7.b(r100);
        if (r100 == false) goto L5;
        r102.f563068p = this.f536941k;
        r102.f563069q = this.f536942l;
        r102.f563070r = this.f536943m;
        r102.f563071s = this.f536944n;
    L6:
        return r102;
    L5:
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
        goto L6
    }

    public b(Context r100, lb7.a r101, p38.a r102) {
        super(r100, r101, r102);
    }
}
