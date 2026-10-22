package e7;

import com.bytedance.android.annie.bridge.method.abs.ReportALogParamModel;
import com.bytedance.android.annie.bridge.method.abs.ReportALogResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;

/* JADX INFO: loaded from: classes43.dex */
public abstract class u<P extends ReportALogParamModel, R extends ReportALogResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public u() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
