package e7;

import com.bytedance.android.annie.bridge.method.abs.LoginResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.l0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class k<P extends l0, R extends LoginResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public k() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
