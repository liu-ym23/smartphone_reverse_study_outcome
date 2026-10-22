package w20;

import com.bytedance.android.live.browser.jsbridge.base.GcpLoadPerfFinishLoadWithErrorResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.f9;

/* JADX INFO: loaded from: classes45.dex */
public abstract class z0<P extends f9, R extends GcpLoadPerfFinishLoadWithErrorResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public z0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
