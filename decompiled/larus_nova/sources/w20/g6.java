package w20;

import com.bytedance.android.live.browser.jsbridge.base.SetEffectEnableResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ne;

/* JADX INFO: loaded from: classes45.dex */
public abstract class g6<P extends ne, R extends SetEffectEnableResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public g6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
