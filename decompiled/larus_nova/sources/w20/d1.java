package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetAssetsPathResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.k9;

/* JADX INFO: loaded from: classes45.dex */
public abstract class d1<P extends k9, R extends GetAssetsPathResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public d1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
