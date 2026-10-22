package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveVirtualLiveUpdateResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.qb;

/* JADX INFO: loaded from: classes45.dex */
public abstract class v3<P extends qb, R extends LiveVirtualLiveUpdateResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public v3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
