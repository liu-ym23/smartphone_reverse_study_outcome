package w20;

import com.bytedance.android.live.browser.jsbridge.base.ShareImageUrlToPanelResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.qe;

/* JADX INFO: loaded from: classes45.dex */
public abstract class i6<P extends qe, R extends ShareImageUrlToPanelResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public i6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
