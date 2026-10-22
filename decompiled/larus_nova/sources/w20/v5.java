package w20;

import com.bytedance.android.live.browser.jsbridge.base.SendCommerceEventResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.zd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class v5<P extends zd, R extends SendCommerceEventResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public v5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
