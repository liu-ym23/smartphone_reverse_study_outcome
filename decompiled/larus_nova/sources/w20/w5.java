package w20;

import com.bytedance.android.live.browser.jsbridge.base.SendEffectMessageResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ce;

/* JADX INFO: loaded from: classes45.dex */
public abstract class w5<P extends ce, R extends SendEffectMessageResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public w5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
