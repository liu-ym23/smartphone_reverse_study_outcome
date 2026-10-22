package xf7;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements SDKMonitor.IGetExtendParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f563495a;

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final String getSessionId() {
        return null;
    }

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final Map<String, String> getCommonParams() {
        Map<String, String> r100 = this.f563495a.f563455b.getCommonParams();
        if (this.f563495a.f563462i == false) goto L5;
        String r101 = "1";
    L6:
        r100.put("oversea", r101);
        r100.remove("aid");
        r100.put("host_aid", this.f563495a.f563454a);
        return r100;
    L5:
        r101 = "0";
        goto L6
    }

    public s(g r100) {
        this.f563495a = r100;
    }
}
