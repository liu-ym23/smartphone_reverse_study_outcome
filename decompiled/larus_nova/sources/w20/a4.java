package w20;

import com.bytedance.android.live.browser.jsbridge.base.NotifyClearMountDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.wb;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a4<P extends wb, R extends NotifyClearMountDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
