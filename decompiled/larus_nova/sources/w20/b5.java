package w20;

import com.bytedance.android.live.browser.jsbridge.base.RechargeScreenShieldResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.cd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b5<P extends cd, R extends RechargeScreenShieldResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
