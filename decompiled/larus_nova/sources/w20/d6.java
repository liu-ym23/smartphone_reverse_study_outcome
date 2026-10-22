package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.je;
import w20.ke;

/* JADX INFO: loaded from: classes45.dex */
public abstract class d6<P extends je, R extends ke> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public d6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
