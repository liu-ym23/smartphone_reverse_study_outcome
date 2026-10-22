package zw0;

import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.android.live.recharge.l;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class d extends com.bytedance.android.livesdk.revenue.network.a {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.android.livesdk.revenue.network.a
    public final com.bytedance.android.livesdk.revenue.network.d x(String r100, com.bytedance.android.livesdk.revenue.network.d r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "originalRequest");
        if (c.a() == true) goto L5;
        return r101;
    L5:
        Map<String, String> r102 = r101.f157206c;
        JSONObject r103 = new JSONObject();
        Iterator<Map.Entry<String, String>> r104 = r102.entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        Map.Entry<String, String> r105 = r104.next();
        d60.b.a(r103, r105.getKey(), r105.getValue());
        goto L7
    L9:
        int r106 = com.bytedance.android.live.recharge.trace.b.f90385a;
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_wallet_info_request", r103, new JSONObject());
        return r101;
    }

    @Override // com.bytedance.android.livesdk.revenue.network.a
    public final void E(String r100, com.bytedance.android.livesdk.revenue.network.d r101, com.bytedance.android.live.network.response.d.b r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "response");
        if (c.a() == true) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        d60.b.a(r103, "data", r102.data);
        JSONObject r104 = new JSONObject();
        DATA r105 = r102.data;
        if ((r105 instanceof l) == false) goto L11;
        if (r105 == 0) goto L10;
        d60.b.a(r104, DyVerifyReqConstants.Value.DIAMOND, Long.valueOf(((l) r105).getDiamond()));
    L12:
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_wallet_info_response", r104, r103);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.IWalletInfo");
    L11:
        d60.b.a(r104, "data_error", 0);
        goto L12
    }
}
