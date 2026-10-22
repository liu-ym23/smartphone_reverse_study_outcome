package w20;

import com.bytedance.android.live.browser.jsbridge.base.GetLinkmicStatusResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.o9;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l1<P extends o9, R extends GetLinkmicStatusResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
