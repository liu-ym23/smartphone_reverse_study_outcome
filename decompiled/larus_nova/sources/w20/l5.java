package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;
import w20.ld;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l5<P extends JsonObject, R extends ld> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public l5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
