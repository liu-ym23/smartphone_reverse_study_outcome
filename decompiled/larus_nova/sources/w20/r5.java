package w20;

import com.bytedance.android.live.browser.jsbridge.base.SearchFriendResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ud;

/* JADX INFO: loaded from: classes45.dex */
public abstract class r5<P extends ud, R extends SearchFriendResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public r5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
