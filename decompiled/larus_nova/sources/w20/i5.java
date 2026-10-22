package w20;

import com.bytedance.android.live.browser.jsbridge.base.ReportLinkmicStatusResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.id;

/* JADX INFO: loaded from: classes45.dex */
public abstract class i5<P extends id, R extends ReportLinkmicStatusResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public i5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
