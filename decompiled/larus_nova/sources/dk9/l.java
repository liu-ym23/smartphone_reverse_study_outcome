package dk9;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements bn7.d {
    public l() {
    }

    @Override // bn7.d
    public final void b() {
    }

    @Override // bn7.d
    public final tk7.b a() {
        tk7.b r100 = new tk7.b();
        tk7.c r101 = new tk7.c();
        AppHost.Companion r102 = AppHost.f326268a;
        r102.getAppName();
        r101.f546557b = String.valueOf(r102.getAppId());
        r101.f546556a = r102.getBuildChannel();
        r102.getVersionCode();
        r102.getUpdateVersionCode();
        r102.getVersionName();
        r100.f546553a = r101;
        r100.f546554b = true;
        return r100;
    }
}
