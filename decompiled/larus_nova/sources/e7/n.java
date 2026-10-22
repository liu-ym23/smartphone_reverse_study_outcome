package e7;

import com.bytedance.android.annie.bridge.method.abs.OpenResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.n0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class n<P extends n0, R extends OpenResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public n() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
