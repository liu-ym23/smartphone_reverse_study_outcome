package w20;

import com.bytedance.android.live.browser.jsbridge.base.TryOpenInvitePanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.Cif;

/* JADX INFO: loaded from: classes45.dex */
public abstract class y6<P extends Cif, R extends TryOpenInvitePanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public y6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
