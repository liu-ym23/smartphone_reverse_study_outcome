package e7;

import com.bytedance.android.annie.bridge.method.abs.GetStorageItemResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.i0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class i<P extends i0, R extends GetStorageItemResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    private final String methodName;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public void onTerminate() {
    }

    public i() {
        this.methodName = "getStorageItem";
    }

    public final String getMethodName() {
        return this.methodName;
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
