package w20;

import com.bytedance.android.live.browser.jsbridge.base.CommunityOpenAnchorInteractPluginLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.l8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class f0<P extends l8, R extends CommunityOpenAnchorInteractPluginLynxContainerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
