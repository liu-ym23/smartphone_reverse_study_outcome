package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenChooseGuestPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ec;

/* JADX INFO: loaded from: classes45.dex */
public abstract class f4<P extends ec, R extends OpenChooseGuestPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
