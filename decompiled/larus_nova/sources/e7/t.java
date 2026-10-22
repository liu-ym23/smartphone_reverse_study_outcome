package e7;

import com.bytedance.android.annie.bridge.method.abs.RemoveStorageItemResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.r0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class t<P extends r0, R extends RemoveStorageItemResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    private final String methodName;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public void onTerminate() {
    }

    public t() {
        this.methodName = "removeStorageItem";
    }

    public final String getMethodName() {
        return this.methodName;
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
