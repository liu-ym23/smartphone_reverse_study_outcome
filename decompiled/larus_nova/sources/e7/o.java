package e7;

import com.bytedance.android.annie.bridge.method.abs.OpenPermissionSettingsParamModel;
import com.bytedance.android.annie.bridge.method.abs.OpenPermissionSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes43.dex */
public abstract class o<P extends OpenPermissionSettingsParamModel, R extends OpenPermissionSettingsResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public o() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
