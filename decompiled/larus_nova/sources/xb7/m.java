package xb7;

import android.content.Context;
import com.bytedance.sdk.account.impl.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class m extends c0<ua7.i> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f563156l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f563157k;

    public static class a extends nc7.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f563158j;

        public a(String r100) {
        }
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("passport_mobile_validate_code_v1", null, null, (ua7.i) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
        com.bytedance.sdk.account.impl.c.a(this.f563157k, r100);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        if (r101 == null) goto L5;
        a r102 = this.f563157k;
        r102.f563158j = r101.optString("ticket", "");
        return;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        ua7.i r102 = new ua7.i(r100);
        if (r100 == false) goto L5;
        r102.f549289p = this.f563157k.f563158j;
    L6:
        return r102;
    L5:
        a r103 = this.f563157k;
        r102.f549253g = r103.f518635a;
        r102.f549255i = r103.f518636b;
        goto L6
    }

    public m(Context r100, lb7.a r101, a r102, com.larus.account.base.impl.i r103) {
        super(r100, r101, r103);
        this.f563157k = r102;
    }
}
