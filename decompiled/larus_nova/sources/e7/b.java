package e7;

import com.bytedance.android.annie.bridge.method.abs.CheckPermissionParamModel;
import com.bytedance.android.annie.bridge.method.abs.CheckPermissionResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes43.dex */
public abstract class b<P extends CheckPermissionParamModel, R extends CheckPermissionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
