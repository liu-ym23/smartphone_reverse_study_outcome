package e7;

import com.bytedance.android.annie.bridge.method.abs.SendSocketDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.v0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class z<P extends v0, R extends SendSocketDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public z() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
