package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetConcertStatusResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.qa;

/* JADX INFO: loaded from: classes45.dex */
public abstract class r2<P extends qa, R extends LiveGetConcertStatusResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public r2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
