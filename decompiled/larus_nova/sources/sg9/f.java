package sg9;

import com.bytedance.lynx.webview.internal.AppInfo;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.o;
import com.larus.utils.q0;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements com.bytedance.lynx.webview.internal.a {
    public f() {
    }

    @Override // com.bytedance.lynx.webview.internal.a
    public final AppInfo a() {
        AppInfo r100 = new AppInfo();
        AppHost.Companion r101 = AppHost.f326268a;
        r100.setAppId(String.valueOf(r101.getAppId()));
        r100.setDeviceId(o.f365780a.getDeviceId());
        r100.setUpdateVersionCode(String.valueOf(r101.getUpdateVersionCode()));
        r100.setChannel(r101.getBuildChannel());
        if (q0.c(r101.getApplication()) == false) goto L5;
        r100.setIsMainProcess("1");
    L5:
        return r100;
    }

    @Override // com.bytedance.lynx.webview.internal.a
    public final AppInfo getAppInfo() {
        return new AppInfo();
    }
}
