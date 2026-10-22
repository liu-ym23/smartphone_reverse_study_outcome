package w20;

import com.bytedance.android.live.browser.jsbridge.base.TryApplyLinkResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.hf;

/* JADX INFO: loaded from: classes45.dex */
public abstract class x6<P extends hf, R extends TryApplyLinkResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public x6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
