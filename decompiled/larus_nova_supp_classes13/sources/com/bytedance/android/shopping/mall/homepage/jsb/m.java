package com.bytedance.android.shopping.mall.homepage.jsb;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends qf3.e {
    public final String d;
    public final View e;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public m(qf3.d r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.e = r3;
        this.d = "ec.mall.showTaskBanner";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r10, IBDXBridgeContext r11, Map<String, ? extends Object> r12, Map<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r10, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "result");
        Object r14 = r12.get("taskBannerData");
        View r0 = null;
        if ((r14 instanceof Map) == true) goto L5;
        r14 = null;
    L5:
        Map r15 = (Map) r14;
        if (r15 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        JSONObject r3 = new JSONObject(r15);
        String r4 = r3.optString("task_type");
        JSONObject r5 = r3.optJSONObject("task_request_params");
        if (r5 == null) goto L45;
        if (r4 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == true) goto L45;
        JSONObject r7 = r3.optJSONObject("log_extra");
        Pair[] r8 = new Pair[8];
        r8[0] = TuplesKt.to("task_type", r4);
        r8[1] = TuplesKt.to("task_request_params", r5);
        r8[2] = TuplesKt.to("task_enter_from", r3.optString("task_enter_from"));
        r8[3] = TuplesKt.to("extra", r3.optJSONObject("extra"));
        r8[4] = TuplesKt.to("frame", r3.optJSONObject("frame"));
        r8[5] = TuplesKt.to("log_extra", r7);
        if (r7 == null) goto L28;
        String r16 = r7.optString(PdpOpenThirdParam.KEY_PAGE_NAME);
    L29:
        r8[6] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r16);
        if (r7 == null) goto L32;
        String r17 = r7.optString(PdpOpenThirdParam.KEY_SOURCE_PAGE);
    L33:
        r8[7] = TuplesKt.to(PdpOpenThirdParam.KEY_SOURCE_PAGE, r17);
        MapsKt.mapOf(r8);
        IHybridHostService r18 = com.bytedance.android.ec.hybrid.a.h();
        if (r18 == null) goto L42;
        yj.f r19 = r18.getHybridECSdkService();
        if (r19 == null) goto L42;
        Context r110 = r10.a;
        View r111 = this.e;
        if ((r111 instanceof FrameLayout) == false) goto L41;
        r0 = r111;
    L41:
        FrameLayout r1 = (FrameLayout) r0;
        r19.d();
    L42:
        r13.put("containerID", "");
        return qf3.e.f(this);
    L32:
        r17 = null;
        goto L33
    L28:
        r16 = null;
        goto L29
    L19:
        if (r4.length() == 0) goto L22;
        r6 = false;
    L45:
        return qf3.e.c("task_request_params is null or task_type is null or empty");
    L14:
        return qf3.e.c("taskBannerData is null or empty");
    L8:
        if (r15.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }
}
