package w20;

import com.bytedance.android.live.browser.jsbridge.base.RequestPinWidgetResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.kd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class k5<P extends kd, R extends RequestPinWidgetResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public k5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
