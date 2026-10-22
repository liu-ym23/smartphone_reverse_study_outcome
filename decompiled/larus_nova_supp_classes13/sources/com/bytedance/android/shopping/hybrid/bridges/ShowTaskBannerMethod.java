package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.hybrid.widgets.LynxTaskBanner;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ShowTaskBannerMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowTaskBannerMethod extends ECBaseBridgeMethod {
    public static final /* synthetic */ int e = 0;

    public static final class a {
        public static void a(Context r22, JSONObject r23, Function2 r24) {
            Intrinsics.checkNotNullParameter(r23, "params");
            Intrinsics.checkNotNullParameter(r24, "callback");
            String r4 = r23.optString("task_enter_from");
            String r6 = r23.optString("task_type");
            JSONObject r8 = r23.optJSONObject("extra");
            JSONObject r10 = r23.optJSONObject("task_request_params");
            JSONObject r12 = r23.optJSONObject("log_extra");
            if (r12 == null) goto L5;
            String r15 = r12.optString(PdpOpenThirdParam.KEY_PAGE_NAME);
        L7:
            if (r12 == null) goto L9;
            String r9 = r12.optString(PdpOpenThirdParam.KEY_SOURCE_PAGE);
        L10:
            JSONObject r1 = r23.optJSONObject("frame");
            if (r10 != null) goto L21;
            if (r6 != null) goto L14;
        L17:
            boolean r20 = true;
        L18:
            if (r20 == false) goto L21;
            r24.invoke(null, "task_request_params or task_type should not be empty");
            return;
        L14:
            if (r6.length() == 0) goto L17;
            r20 = false;
        L21:
            if (r22 == null) goto L25;
            Map r2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("frame", r1), TuplesKt.to("task_enter_from", r4), TuplesKt.to("task_type", r6), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r15), TuplesKt.to(PdpOpenThirdParam.KEY_SOURCE_PAGE, r9), TuplesKt.to("log_extra", r12), TuplesKt.to("extra", r8), TuplesKt.to("task_request_params", r10)});
            Map r3 = LynxTaskBanner.i;
            r24.invoke(LynxTaskBanner.a.a(r22, r2, null), null);
            return;
        L25:
            return;
        L9:
            r9 = null;
            goto L10
        L5:
            r15 = null;
            goto L7
        }
    }

    static {
    }

    public final String getName() {
        return "ecomShowTaskBanner";
    }

    public ShowTaskBannerMethod() {
    }

    public final void c(JSONObject r4, final ECBaseBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "iReturn");
        final JSONObject r0 = r4.optJSONObject("frame");
        a.a(getContext(), r4, new ShowTaskBannerMethod$handle$1(r5, r0));
    }
}
