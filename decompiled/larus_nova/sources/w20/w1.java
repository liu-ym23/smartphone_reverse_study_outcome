package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetVipPanelCustomBackgroundResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.t9;

/* JADX INFO: loaded from: classes45.dex */
public abstract class w1<P extends t9, R extends GetVipPanelCustomBackgroundResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public w1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
