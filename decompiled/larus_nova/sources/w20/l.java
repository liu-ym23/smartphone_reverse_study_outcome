package w20;

import com.bytedance.android.live.browser.jsbridge.base.CanLoadFromLokiResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.t7;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l<P extends t7, R extends CanLoadFromLokiResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
