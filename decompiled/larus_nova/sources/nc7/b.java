package nc7;

import android.content.Context;
import com.bytedance.sdk.account.impl.c0;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends c0<ua7.h> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f518644l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.ss.android.account.d f518645k;

    @Override // com.bytedance.sdk.account.impl.c0
    public final void i(JSONObject r100, JSONObject r101) {
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void h(ua7.b r100) {
        com.bytedance.sdk.account.monitor.c.g("passport_auth_bind_login", null, null, (ua7.h) r100, this.f268956e);
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final void k(JSONObject r100, JSONObject r101) throws Exception {
        com.ss.android.account.d r102 = new com.ss.android.account.d(r100);
        r102.a();
        this.f518645k = r102;
    }

    @Override // com.bytedance.sdk.account.impl.c0
    public final ua7.b n(boolean r100, lb7.b r101) {
        ua7.h r102 = new ua7.h(r100, TTVideoEngineInterface.GLOBAL_ENGINE_OPTION_ENABLE_DETECT_PRIVATE_FIELD);
        if (r100 == false) goto L5;
        r102.f549279p = this.f518645k;
    L6:
        return r102;
    L5:
        r102.f549253g = r101.f508366b;
        r102.f549255i = r101.f508367c;
        r102.f549256j = r101.f508369e;
        goto L6
    }

    public b(Context r100, lb7.a r101, com.larus.account.base.impl.f r102) {
        super(r100, r101, r102);
    }
}
