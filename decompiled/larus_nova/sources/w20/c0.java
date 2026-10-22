package w20;

import com.bytedance.android.live.browser.jsbridge.base.CommunityDrawerUnfollowResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.j8;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c0<P extends j8, R extends CommunityDrawerUnfollowResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public c0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
