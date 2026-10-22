package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveVirtualLiveGetResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.pb;

/* JADX INFO: loaded from: classes45.dex */
public abstract class u3<P extends pb, R extends LiveVirtualLiveGetResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public u3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
