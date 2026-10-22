package w20;

import com.bytedance.android.live.browser.jsbridge.base.CommunityUpdateAnchorInteractPluginLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.m8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class g0<P extends m8, R extends CommunityUpdateAnchorInteractPluginLynxContainerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public g0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
