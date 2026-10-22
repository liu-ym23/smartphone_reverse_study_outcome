package w20;

import com.bytedance.android.live.browser.jsbridge.base.SelectGiftDynamicCardResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.vd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class s5<P extends vd, R extends SelectGiftDynamicCardResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public s5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
