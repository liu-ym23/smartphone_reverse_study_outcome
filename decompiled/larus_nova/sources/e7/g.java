package e7;

import com.bytedance.android.annie.bridge.method.abs.GetCurrentTimeResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes43.dex */
public abstract class g<P extends JsonObject, R extends GetCurrentTimeResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public g() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
