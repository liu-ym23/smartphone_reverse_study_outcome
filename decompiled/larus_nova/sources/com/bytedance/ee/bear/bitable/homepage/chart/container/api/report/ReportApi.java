package com.bytedance.ee.bear.bitable.homepage.chart.container.api.report;

import com.lynx.react.bridge.Callback;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import ls4.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class ReportApi implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f212438a;

    public static final class a {
    }

    static {
    }

    public ReportApi() {
        this.f212438a = LazyKt.lazy(ReportApi$analyticService$2.INSTANCE);
    }

    @Override // ls4.b
    public final void a(ILynxBridgeContext r100, JSONObject r101, Callback r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        String r103 = r101.optString("eventName");
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L14;
        if (r102 == null) goto L21;
        int r105 = ls4.a.f510532f;
        r102.invoke(new Object[]{ls4.a.C6732a.c("report", "eventName is empty").a()});
        return;
    L21:
        return;
    L14:
        xw4.a r106 = (xw4.a) this.f212438a.getValue();
        JSONObject r107 = r101.optJSONObject("params");
        if (r107 != null) goto L17;
        r107 = new JSONObject();
    L17:
        r106.sendEvent(r103, r107);
        if (r102 == null) goto L22;
        int r108 = ls4.a.f510532f;
        r102.invoke(new Object[]{ls4.a.C6732a.a("report").a()});
        return;
    L22:
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L10
    }
}
