package w20;

import com.bytedance.android.live.browser.jsbridge.base.MuteLiveRoomResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.vb;

/* JADX INFO: loaded from: classes45.dex */
public abstract class z3<P extends vb, R extends MuteLiveRoomResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public z3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
