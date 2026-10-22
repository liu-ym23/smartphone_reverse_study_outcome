package h4a;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.e_commerce.api.IECommerceService;
import com.larus.platform.service.o;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements hx7.a {
    public a() {
    }

    @Override // hx7.a
    public final void putCommonParams(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L6;
        r100.put(WsConstants.KEY_INSTALL_ID, o.f365780a.getInstallId());
        return;
    }

    @Override // hx7.a
    public final void onEventV3Map(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r101 == null) goto L5;
        JSONObject r102 = new JSONObject(r101);
    L6:
        IECommerceService r103 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r103 == null) goto L9;
        r103.t(r100, r102);
    L9:
        o.f365780a.reportEvent(r100, r102);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
