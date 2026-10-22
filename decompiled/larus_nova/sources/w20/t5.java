package w20;

import com.bytedance.android.live.browser.jsbridge.base.SelectMediaResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.wd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class t5<P extends wd, R extends SelectMediaResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public t5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
