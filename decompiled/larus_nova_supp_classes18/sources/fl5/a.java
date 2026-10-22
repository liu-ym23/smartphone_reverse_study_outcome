package fl5;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ee.bear.route.a {
    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return "/doc/operation/strategy/activity";
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r4, BearUrl r5, RouteBean r6) {
        if (r5 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L21;
        tt5.a.h("OperationRouteInterceptor", "route. ");
        Bundle r0 = new Bundle();
        Map r2 = r5.d;
        if (r2 != null) goto L12;
    L18:
        int r3 = 4;
    L19:
        d(r5, r6).j("operation_strategy_code", r3).h(r0).e();
        return true;
    L12:
        if (r2.isEmpty() == true) goto L18;
        String r7 = (String) r2.get("suite_type");
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        r0.putString("SUITE_TYPE", r7);
        r3 = 10;
        goto L19
    L21:
        return false;
    L5:
        if (TextUtils.equals(r5.a, "pay_operation") == false) goto L7;
        r1 = true;
        goto L8
    }
}
