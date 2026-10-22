package w20;

import com.bytedance.android.live.browser.jsbridge.base.CaptureAssemblyGiftResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.u7;

/* JADX INFO: loaded from: classes45.dex */
public abstract class m<P extends u7, R extends CaptureAssemblyGiftResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public m() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
