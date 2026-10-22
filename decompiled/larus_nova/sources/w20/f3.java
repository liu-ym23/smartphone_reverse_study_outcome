package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveReenterRoomResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.za;

/* JADX INFO: loaded from: classes45.dex */
public abstract class f3<P extends za, R extends LiveReenterRoomResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
