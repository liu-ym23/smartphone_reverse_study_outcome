package xb7;

import android.content.Context;
import com.bytedance.sdk.account.impl.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class k extends c0<ua7.e<wb7.k>> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f563152l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final wb7.k f563153k;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        String r101 = this.f268953b.a("type");
        com.bytedance.sdk.account.monitor.c.g("passport_mobile_sendcode", "mobile", r101, (ua7.e) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
        com.bytedance.sdk.account.impl.c.c(this.f563153k, r100);
        this.f563153k.f559016d = r101;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        wb7.k r102 = this.f563153k;
        r101.optInt("retry_time", 30);
        r102.getClass();
        this.f563153k.f559016d = r100;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        if (r100 == false) goto L5;
        wb7.k r102 = this.f563153k;
        r102.f559013a = 0;
        r102.f559014b = "";
    L5:
        return new ua7.e(r100, 1002, this.f563153k);
    }

    public k(Context r100, lb7.a r101, wb7.k r102, yb7.j r103) {
        super(r100, r101, r103);
        this.f563153k = r102;
    }
}
