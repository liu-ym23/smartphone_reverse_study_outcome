package zw0;

import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends com.bytedance.android.livesdk.revenue.network.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.android.livesdk.revenue.network.a
    public final com.bytedance.android.livesdk.revenue.network.d x(String r100, com.bytedance.android.livesdk.revenue.network.d r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "originalRequest");
        if (c.a() == true) goto L5;
        return r101;
    L5:
        Map<String, String> r102 = r101.f157206c;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r102, "<this>");     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(new JSONObject(r102));     // Catch: Throwable -> L8
    L10:
        JSONObject r105 = new JSONObject();
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = r105;
    L13:
        int r106 = com.bytedance.android.live.recharge.trace.b.f90385a;
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_diamond_list_request", (JSONObject) r104, new JSONObject());
        return r101;
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

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
        j01.d.b(r106, "data", r103);
        j01.d.b(r106, "extra", r104);
        if ((r103 instanceof List) == true) goto L8;
    L9:
        j01.d.b(r105, "data_error", 0);
    L11:
        if ((r104 instanceof com.bytedance.android.live.recharge.model.diamond.a) == true) goto L13;
        j01.d.b(r105, "extra_error", 0);
    L13:
        if (r104 == 0) goto L20;
        if (((com.bytedance.android.live.recharge.model.diamond.a) r104).f().isEmpty() == false) goto L17;
        j01.d.b(r105, "customized_diamonds_size", 0);
    L17:
        com.bytedance.android.live.recharge.trace.b.a("ttlive_recharge_api_check_diamond_list_response", r105, r106);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.model.diamond.DealSetExtra");
    L8:
        if (((List) r103).size() > 0) goto L11;
        goto L9
    }
}
