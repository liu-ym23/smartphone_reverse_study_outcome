package w20;

import com.bytedance.android.live.browser.jsbridge.base.CreateChatGroupResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.n8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class h0<P extends n8, R extends CreateChatGroupResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public h0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
