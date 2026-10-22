package e7;

import com.bytedance.android.annie.bridge.method.abs.SaveTemplateResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.t0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class x<P extends t0, R extends SaveTemplateResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public x() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
