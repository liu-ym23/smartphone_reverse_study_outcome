package w20;

import com.bytedance.android.live.browser.jsbridge.base.GameGetExplainCardEnterDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.z8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class t0<P extends z8, R extends GameGetExplainCardEnterDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public t0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
