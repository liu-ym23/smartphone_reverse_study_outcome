package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.f7;
import w20.g7;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<P extends f7, R extends g7> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
