package w20;

import com.bytedance.android.live.browser.jsbridge.base.CloseGiftWebViewResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.f8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class x<P extends f8, R extends CloseGiftWebViewResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public x() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
