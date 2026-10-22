package w20;

import com.bytedance.android.live.browser.jsbridge.base.AdLiveUpdateFeedResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.h7;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b<P extends h7, R extends AdLiveUpdateFeedResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
