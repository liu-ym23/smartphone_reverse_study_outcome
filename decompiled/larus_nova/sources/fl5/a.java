package fl5;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends com.bytedance.ee.bear.route.a {
    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/doc/operation/strategy/activity";
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L21;
        tt5.a.h("OperationRouteInterceptor", "route. ");
        Bundle r104 = new Bundle();
        Map<String, String> r105 = r101.f222563d;
        if (r105 != null) goto L12;
    L18:
        int r106 = 4;
    L19:
        d(r101, r102).j("operation_strategy_code", r106).h(r104).e();
        return true;
    L12:
        if (r105.isEmpty() == true) goto L18;
        String r107 = r105.get("suite_type");
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        r104.putString("SUITE_TYPE", r107);
        r106 = 10;
        goto L19
    L21:
        return false;
    L5:
        if (TextUtils.equals(r101.f222560a, "pay_operation") == false) goto L7;
        r103 = true;
        goto L8
    }
}
