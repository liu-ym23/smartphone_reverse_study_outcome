package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenLiveEffectPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.kc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l4<P extends kc, R extends OpenLiveEffectPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
