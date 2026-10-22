package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateConcertStatusResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.jb;

/* JADX INFO: loaded from: classes45.dex */
public abstract class p3<P extends jb, R extends LiveUpdateConcertStatusResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public p3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
