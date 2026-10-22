package e7;

import com.bytedance.android.annie.bridge.method.abs.DeleteCalendarEventResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.g0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class f<P extends g0, R extends DeleteCalendarEventResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
