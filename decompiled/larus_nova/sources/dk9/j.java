package dk9;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements bn7.b {
    public j() {
    }

    @Override // bn7.b
    public final ti7.a a() {
        ti7.a r100 = new ti7.a();
        ti7.b r101 = new ti7.b();
        AppHost.Companion r102 = AppHost.f326268a;
        r101.f546216a = r102.getAppName();
        r101.f546221f = String.valueOf(r102.getAppId());
        r101.f546217b = r102.getBuildChannel();
        r101.f546219d = Long.valueOf(r102.getVersionCode());
        r101.f546220e = Long.valueOf(r102.getUpdateVersionCode());
        r101.f546218c = r102.getVersionName();
        r100.f546206a = r101;
        return r100;
    }
}
