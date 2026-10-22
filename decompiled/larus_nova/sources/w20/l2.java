package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveCloseLinkResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ma;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l2<P extends ma, R extends LiveCloseLinkResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
