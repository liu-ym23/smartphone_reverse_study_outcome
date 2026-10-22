package w20;

import com.bytedance.android.live.browser.jsbridge.base.SetAdminPermissionResultResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.le;

/* JADX INFO: loaded from: classes45.dex */
public abstract class e6<P extends le, R extends SetAdminPermissionResultResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
