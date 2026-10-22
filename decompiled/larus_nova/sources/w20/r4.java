package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenPanelInRoomResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.qc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class r4<P extends qc, R extends OpenPanelInRoomResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public r4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
