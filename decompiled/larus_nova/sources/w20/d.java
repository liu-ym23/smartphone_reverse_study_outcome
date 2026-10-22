package w20;

import com.bytedance.android.live.browser.jsbridge.base.AddAnchorResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class d<P extends JsonObject, R extends AddAnchorResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public d() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
