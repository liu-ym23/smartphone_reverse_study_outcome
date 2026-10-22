package e7;

import com.bytedance.android.annie.bridge.method.abs.PreloadResourceResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.p0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class q<P extends p0, R extends PreloadResourceResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public q() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
