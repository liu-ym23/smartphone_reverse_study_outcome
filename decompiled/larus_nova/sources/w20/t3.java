package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateViewInLiveBgResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ob;

/* JADX INFO: loaded from: classes45.dex */
public abstract class t3<P extends ob, R extends LiveUpdateViewInLiveBgResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public t3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
