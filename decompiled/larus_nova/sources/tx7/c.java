package tx7;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IReportADLogResultCallback;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class c implements IHostLogDependV2 {
    public c() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final void handleReportADLog(IBDXBridgeContext r100, String r101, re7.g r102, IReportADLogResultCallback r103) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
    }

    public static hx7.a a() {
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r100 = com.ivy.ivykit.api.bridge.b.f278301a;
        return (hx7.a) com.ivy.ivykit.api.bridge.b.a(hx7.a.class);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final void onEventV3Map(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (a() == null) goto L7;
        hx7.a r102 = a();
        if (r102 == null) goto L14;
        r102.onEventV3Map(r100, r101);
        return;
    L14:
        return;
    L7:
        if (r101 == null) goto L9;
        JSONObject r103 = new JSONObject(r101);
    L10:
        nx7.b r104 = nx7.a.f521062a;
        Intrinsics.checkNotNullParameter(r100, "event");
        nx7.b r105 = nx7.a.f521062a;
        if (r105 == null) goto L16;
        r105.reportEvent(r100, r103);
        return;
    L16:
        return;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final void putCommonParams(Map<String, String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        hx7.a r102 = a();
        if (r102 == null) goto L6;
        r102.putCommonParams(r100);
        return;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final Unit reportJSBError(IBDXBridgeContext r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r101, "params");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend
    public final Unit reportJSBFetchError(IBDXBridgeContext r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r101, "params");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2
    public final void onEventV3Map(String r100, Map<String, String> r101, IBDXBridgeContext r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "bridgeContext");
        if (a() == null) goto L7;
        hx7.a r103 = a();
        if (r103 == null) goto L14;
        r103.onEventV3Map(r100, r101);
        return;
    L14:
        return;
    L7:
        if (r101 == null) goto L9;
        JSONObject r104 = new JSONObject(r101);
    L10:
        nx7.b r105 = nx7.a.f521062a;
        Intrinsics.checkNotNullParameter(r100, "event");
        nx7.b r106 = nx7.a.f521062a;
        if (r106 == null) goto L16;
        r106.reportEvent(r100, r104);
        return;
    L16:
        return;
    L9:
        r104 = null;
        goto L10
    }
}
