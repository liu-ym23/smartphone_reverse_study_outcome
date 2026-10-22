package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateFansclubInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.lb;

/* JADX INFO: loaded from: classes45.dex */
public abstract class r3<P extends lb, R extends LiveUpdateFansclubInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public r3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
