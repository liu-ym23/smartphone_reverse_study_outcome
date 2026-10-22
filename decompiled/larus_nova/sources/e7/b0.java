package e7;

import com.bytedance.android.annie.bridge.method.abs.ShowLoadingResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.ss.android.dypay.api.DyPayConstant;
import e7.x0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class b0<P extends x0, R extends ShowLoadingResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    private final String methodName;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public void onTerminate() {
    }

    public b0() {
        this.methodName = DyPayConstant.KEY_SHOW_LOADING;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
