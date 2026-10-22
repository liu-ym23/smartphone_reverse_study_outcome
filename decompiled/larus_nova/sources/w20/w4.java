package w20;

import com.bytedance.android.live.browser.jsbridge.base.OpenXPlayRealNameAuthResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.wc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class w4<P extends wc, R extends OpenXPlayRealNameAuthResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public w4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
