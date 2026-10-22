package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenExplainCardSettingDialogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.hc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class i4<P extends hc, R extends OpenExplainCardSettingDialogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public i4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
