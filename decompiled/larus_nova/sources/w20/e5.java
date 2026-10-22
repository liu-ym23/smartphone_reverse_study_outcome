package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;
import w20.fd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class e5<P extends JsonObject, R extends fd> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
