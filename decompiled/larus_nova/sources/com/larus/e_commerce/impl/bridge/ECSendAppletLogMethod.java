package com.larus.e_commerce.impl.bridge;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o89.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/larus/e_commerce/impl/bridge/ECSendAppletLogMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "params", "Lorg/json/JSONObject;", "iReturn", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod$IReturn;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECSendAppletLogMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f342401e;

    public ECSendAppletLogMethod() {
        this.f342401e = "flow.ecSendAppletLog";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f342401e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("name", "");
        JSONObject r103 = r100.optJSONObject("extra");
        r r104 = r.f522422a;
        Intrinsics.checkNotNull(r102);
        r104.getClass();
        r.a(r102, r103);
        r101.onSuccess(null);
    }
}
