package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateNotifyGiftMessageChannelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.mb;

/* JADX INFO: loaded from: classes45.dex */
public abstract class s3<P extends mb, R extends LiveUpdateNotifyGiftMessageChannelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public s3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
