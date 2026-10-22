package hw0;

import com.bytedance.android.live.recharge.exchange.jsbridge.GetMemAutoExchangeStatusResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a<P extends JsonObject, R extends GetMemAutoExchangeStatusResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
