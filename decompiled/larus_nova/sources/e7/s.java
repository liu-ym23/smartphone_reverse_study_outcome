package e7;

import com.bytedance.android.annie.bridge.method.abs.ReadCalendarEventResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.q0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class s<P extends q0, R extends ReadCalendarEventResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public s() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
