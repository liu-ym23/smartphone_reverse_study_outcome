package e7;

import com.bytedance.android.annie.bridge.method.abs.SetStorageItemResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.w0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a0<P extends w0, R extends SetStorageItemResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    private final String methodName;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public void onTerminate() {
    }

    public a0() {
        this.methodName = "setStorageItem";
    }

    public final String getMethodName() {
        return this.methodName;
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
