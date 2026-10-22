package e7;

import com.bytedance.android.annie.bridge.method.abs.RequestPermissionParamModel;
import com.bytedance.android.annie.bridge.method.abs.RequestPermissionResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes43.dex */
public abstract class w<P extends RequestPermissionParamModel, R extends RequestPermissionResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public w() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
