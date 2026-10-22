package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetLiveEffectInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.sa;

/* JADX INFO: loaded from: classes45.dex */
public abstract class v2<P extends sa, R extends LiveGetLiveEffectInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public v2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
