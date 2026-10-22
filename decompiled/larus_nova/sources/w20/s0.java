package w20;

import com.bytedance.android.live.browser.jsbridge.base.GameDismissExplainCardLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.y8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class s0<P extends y8, R extends GameDismissExplainCardLynxContainerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public s0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
