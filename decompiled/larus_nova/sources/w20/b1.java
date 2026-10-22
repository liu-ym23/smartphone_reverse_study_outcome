package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.h9;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b1<P extends h9, JsonObject> extends com.bytedance.ies.web.jsbridge2.f<P, JsonObject> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
