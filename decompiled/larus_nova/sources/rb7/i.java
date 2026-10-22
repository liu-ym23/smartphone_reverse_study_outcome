package rb7;

import android.content.Context;
import com.bytedance.sdk.account.impl.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i extends c0<xa7.i> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f536962n = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f536963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f536964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f536965m;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("passport_shark_safe_verify", null, null, (xa7.i) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
        this.f536965m = r101;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        this.f536965m = r100;
        this.f536963k = r101.optString("ticket");
        this.f536964l = r101.optBoolean("safe");
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        xa7.i r102 = new xa7.i(r100);
        if (r100 == false) goto L5;
        r102.f563089p = this.f536963k;
        r102.f563090q = this.f536964l;
    L6:
        r102.f549259m = this.f536965m;
        return r102;
    L5:
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
        goto L6
    }

    public i(Context r100, lb7.a r101, va7.f r102) {
        super(r100, r101, r102);
    }
}
