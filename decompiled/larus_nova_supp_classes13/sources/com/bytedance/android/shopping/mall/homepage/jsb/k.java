package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.shopping.api.mall.IECMallAddressService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends qf3.a {

    public static final class a implements com.bytedance.android.shopping.api.mall.n {
        public final /* synthetic */ IDLXBridgeMethod.a a;

        public a(IDLXBridgeMethod.a r1) {
            this.a = r1;
        }
    }

    public final String getName() {
        return "ecSetAddress";
    }

    public k(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.a
    public final void e(IBDXBridgeContext r7, qf3.d r8, Map<String, ? extends Object> r9, IDLXBridgeMethod.a r10) {
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        JSONObject r11 = new JSONObject(r9);
        boolean r3 = r11.optBoolean("is_session");
        int r2 = r11.optInt("source_type");
        JSONObject r12 = r11.optJSONObject("address");
        if (r12 != null) goto L5;
        r12 = new JSONObject();
    L5:
        JSONObject r1 = r12;
        JSONObject r13 = r11.optJSONObject("extra_params");
        if (r13 != null) goto L8;
        r13 = new JSONObject();
    L8:
        r13.optBoolean("sync_write");
        r13.optBoolean("save_current_address");
        r13.optBoolean("without_network");
        com.bytedance.android.shopping.api.mall.o r5 = new com.bytedance.android.shopping.api.mall.o();
        IECMallAddressService r0 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
        if (r0 == null) goto L12;
        r0.setAddress(r1, r2, r3, new a(r10), r5);
        return;
    }
}
