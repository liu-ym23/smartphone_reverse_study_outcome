package w20;

import com.bytedance.android.live.browser.jsbridge.base.SendQuickInteractResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ie;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c6<P extends ie, R extends SendQuickInteractResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public c6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
