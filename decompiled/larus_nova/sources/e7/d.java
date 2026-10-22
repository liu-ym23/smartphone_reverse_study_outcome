package e7;

import com.bytedance.android.annie.bridge.method.abs.ConnectSocketResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.e0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class d<P extends e0, R extends ConnectSocketResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public d() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
