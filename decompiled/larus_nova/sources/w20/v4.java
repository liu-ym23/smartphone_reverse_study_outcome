package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenVSMessageBoardInputPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.vc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class v4<P extends vc, R extends OpenVSMessageBoardInputPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public v4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
