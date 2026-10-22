package w20;

import com.bytedance.android.live.browser.jsbridge.base.PreloadReplayResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.bd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a5<P extends bd, R extends PreloadReplayResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
