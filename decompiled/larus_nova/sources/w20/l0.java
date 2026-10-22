package w20;

import com.bytedance.android.live.browser.jsbridge.base.DismissLotteryIconResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.r8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l0<P extends r8, R extends DismissLotteryIconResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
