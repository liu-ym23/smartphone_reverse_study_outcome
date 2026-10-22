package w20;

import com.bytedance.android.live.browser.jsbridge.base.UrgeGiftSendResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.of;

/* JADX INFO: loaded from: classes45.dex */
public abstract class d7<P extends of, R extends UrgeGiftSendResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public d7() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
