package w20;

import com.bytedance.android.live.browser.jsbridge.base.StartPrivateVIPLiveResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.cf;

/* JADX INFO: loaded from: classes45.dex */
public abstract class s6<P extends cf, R extends StartPrivateVIPLiveResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public s6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
