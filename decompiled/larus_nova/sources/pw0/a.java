package pw0;

import com.bytedance.android.live.recharge.jsbridge.LiveCloseRechargeBannerResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import pw0.c;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a<P extends c, R extends LiveCloseRechargeBannerResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
