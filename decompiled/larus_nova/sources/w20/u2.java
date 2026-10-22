package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetInteractToolInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.ra;

/* JADX INFO: loaded from: classes45.dex */
public abstract class u2<P extends ra, R extends LiveGetInteractToolInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public u2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
