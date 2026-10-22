package w20;

import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import w20.tc;
import w20.uc;

/* JADX INFO: loaded from: classes45.dex */
public abstract class u4<P extends tc, R extends uc> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public u4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
