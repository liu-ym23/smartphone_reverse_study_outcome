package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenFansGroupSettingDirectResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ic;

/* JADX INFO: loaded from: classes45.dex */
public abstract class j4<P extends ic, R extends OpenFansGroupSettingDirectResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public j4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
