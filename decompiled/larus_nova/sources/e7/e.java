package e7;

import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import e7.f0;

/* JADX INFO: loaded from: classes43.dex */
public abstract class e<P extends f0, R extends CreateCalendarEventResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
