package e7;

import com.bytedance.android.annie.bridge.method.abs.AppInfoResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a<P extends JSONObject, R extends AppInfoResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
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
