package w20;

import com.bytedance.android.live.browser.jsbridge.base.ShareTicketResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.te;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l6<P extends te, R extends ShareTicketResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
