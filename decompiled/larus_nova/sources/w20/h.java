package w20;

import com.bytedance.android.live.browser.jsbridge.base.AlertResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.m7;

/* JADX INFO: loaded from: classes45.dex */
public abstract class h<P extends m7, R extends AlertResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public h() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
