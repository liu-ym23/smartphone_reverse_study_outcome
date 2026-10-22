package nc7;

import android.content.Context;
import com.bytedance.sdk.account.impl.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i extends c0<ua7.b> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f518657l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f518658k;

    public static class a extends nc7.a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public JSONObject f518659j;

        public a() {
        }
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("passport_oauth_unbind_click", this.f268953b.a("platform"), "auth_unbind", r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
        com.bytedance.sdk.account.impl.c.a(this.f518658k, r100);
        this.f518658k.f518659j = r101;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        this.f518658k.f518659j = r100;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        ua7.b r102 = new ua7.b(r100, 2);
        if (r100 == true) goto L6;
        a r103 = this.f518658k;
        r102.f549253g = r103.f518635a;
        r102.f549255i = r103.f518636b;
    L6:
        r102.f549259m = this.f518658k.f518659j;
        return r102;
    }

    public i(Context r100, lb7.a r101, ua7.a<ua7.b> r102) {
        super(r100, r101, r102);
        this.f518658k = new a();
    }
}
