package w20;

import com.bytedance.android.live.browser.jsbridge.base.StartGuestBattleResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.af;

/* JADX INFO: loaded from: classes45.dex */
public abstract class q6<P extends af, R extends StartGuestBattleResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public q6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
