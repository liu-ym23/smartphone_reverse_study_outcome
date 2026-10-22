package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveOperateInteractPluginResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ya;

/* JADX INFO: loaded from: classes45.dex */
public abstract class e3<P extends ya, R extends LiveOperateInteractPluginResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
