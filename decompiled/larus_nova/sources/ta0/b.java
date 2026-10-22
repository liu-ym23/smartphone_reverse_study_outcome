package ta0;

import com.bytedance.android.live.incentive.exchange.d;
import com.bytedance.android.live.incentive.exchange.f;
import com.bytedance.android.live.incentive.exchange.jsb.RevenueNotifyIncomeExchangeResultResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends a<c, RevenueNotifyIncomeExchangeResultResultModel> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        c r101 = (c) r100;
        Intrinsics.checkNotNullParameter(r101, "args");
        Intrinsics.checkNotNullParameter(r110, "callContext");
        String r102 = r101.d();
        if (r102 != null) goto L5;
        String r103 = "";
    L6:
        Integer r104 = r101.e();
        if (r104 == null) goto L9;
        int r105 = r104.intValue();
    L10:
        String r106 = r101.getType();
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        Integer r107 = r101.a();
        if (r107 == null) goto L16;
        int r108 = r107.intValue();
    L17:
        Integer r109 = r101.b();
        if (r109 == null) goto L20;
        int r111 = r109.intValue();
    L21:
        String r112 = r101.c();
        if (r112 != null) goto L24;
        String r113 = "";
    L25:
        f r114 = new f(r103, r105, r106, r108, r111, r113);
        jy0.b.a("Incentive/RevenueNotifyIncomeExchangeResultMethod", r114.toString());
        qa0.a r115 = qa0.c.f532212b.getService(d.class);
        Intrinsics.checkNotNull(r115);
        ((d) r115).h(r114);
        finishWithSuccess();
        return;
    L24:
        r113 = r112;
        goto L25
    L20:
        r111 = 0;
        goto L21
    L16:
        r108 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = r102;
        goto L6
    }
}
