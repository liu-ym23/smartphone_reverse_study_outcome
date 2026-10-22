package zw0;

import com.bytedance.android.live.base.model.MinorExtra;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends com.bytedance.android.livesdk.revenue.network.a {

    /* JADX INFO: renamed from: zw0.a$a, reason: collision with other inner class name */
    public static final class C8497a {
    }

    static {
    }

    public a() {
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
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_diamond_buy_request", r103, new JSONObject());
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.revenue.network.a
    public final void E(String r100, com.bytedance.android.livesdk.revenue.network.d r101, com.bytedance.android.live.network.response.d.b r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "response");
        if (c.a() == true) goto L5;
        return;
    L5:
        DATA r103 = r102.data;
        EXTRA r104 = r102.extra;
        JSONObject r105 = new JSONObject();
        JSONObject r106 = new JSONObject();
        d60.b.a(r106, "data", r103);
        d60.b.a(r106, "extra", r104);
        boolean r107 = false;
        if ((r103 instanceof com.bytedance.android.live.wallet.model.d) == true) goto L9;
        d60.b.a(r105, "data_error", 0);
    L9:
        if ((r104 instanceof MinorExtra) == true) goto L11;
        d60.b.a(r105, "extra_error", 0);
    L11:
        if (r103 == 0) goto L32;
        com.bytedance.android.live.wallet.model.d r108 = (com.bytedance.android.live.wallet.model.d) r103;
        String r109 = r108.b();
        if (r109 != null) goto L15;
    L18:
        boolean r110 = true;
    L20:
        if (r110 == false) goto L22;
        d60.b.a(r105, "order_id", "0");
    L22:
        String r111 = r108.c();
        if (r111 != null) goto L25;
    L26:
        r107 = true;
    L27:
        if (r107 == false) goto L29;
        d60.b.a(r105, "params", "0");
    L29:
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_diamond_buy_response", r105, r106);
        return;
    L25:
        if (r111.length() != 0) goto L27;
    L15:
        if (r109.length() == 0) goto L18;
        r110 = false;
        goto L20
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.wallet.model.CJOrderInfo");
    }
}
