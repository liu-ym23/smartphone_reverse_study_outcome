package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class v<P extends JsonObject, R extends JsonObject> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public v() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
