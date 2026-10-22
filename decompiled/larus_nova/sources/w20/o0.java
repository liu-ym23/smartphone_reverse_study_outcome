package w20;

import com.bytedance.android.live.browser.jsbridge.base.EndInteractItemResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.u8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class o0<P extends u8, R extends EndInteractItemResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public o0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
