package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenPaidRightsFullViewResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.pc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class q4<P extends pc, R extends OpenPaidRightsFullViewResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public q4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
