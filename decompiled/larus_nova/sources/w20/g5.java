package w20;

import com.bytedance.android.live.browser.jsbridge.base.RegisterSendGiftEventResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class g5<P extends JsonObject, R extends RegisterSendGiftEventResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public g5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
