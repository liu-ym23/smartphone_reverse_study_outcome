package w20;

import com.bytedance.android.live.browser.jsbridge.base.AddTopicToPublishResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.k7;

/* JADX INFO: loaded from: classes45.dex */
public abstract class f<P extends k7, R extends AddTopicToPublishResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
