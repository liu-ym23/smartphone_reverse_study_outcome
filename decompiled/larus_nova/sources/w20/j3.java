package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveRunAiServiceResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.db;

/* JADX INFO: loaded from: classes45.dex */
public abstract class j3<P extends db, R extends LiveRunAiServiceResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public j3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
