package hw0;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import hw0.h;
import hw0.i;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b<P extends h, R extends i> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
