package w20;

import com.bytedance.android.live.browser.jsbridge.base.UpdateGiftDynamicOperationInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.kf;

/* JADX INFO: loaded from: classes45.dex */
public abstract class z6<P extends kf, R extends UpdateGiftDynamicOperationInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public z6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
