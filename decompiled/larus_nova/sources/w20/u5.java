package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.xd;
import w20.yd;

/* JADX INFO: loaded from: classes45.dex */
public abstract class u5<P extends xd, R extends yd> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public u5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
