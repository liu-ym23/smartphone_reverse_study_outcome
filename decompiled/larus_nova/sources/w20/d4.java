package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenAnchorInputDialogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.bc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class d4<P extends bc, R extends OpenAnchorInputDialogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public d4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
