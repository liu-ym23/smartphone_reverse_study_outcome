package sa0;

import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pa0.f;
import pa0.k;
import pa0.o;
import ra0.e;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.incentive.balance.d f541140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f541141b;

    public c(com.bytedance.android.live.incentive.balance.d r100) {
        o r101 = o.f528352c;
        Intrinsics.checkNotNullParameter(r100, "balanceRepository");
        Intrinsics.checkNotNullParameter(r101, "userIncomeRepository");
        this.f541140a = r100;
        this.f541141b = r101;
    }

    public final ra0.b a(k r100) {
        ra0.b r101 = new ra0.b();
        LinkedHashMap r102 = new LinkedHashMap();
        com.bytedance.android.live.incentive.balance.d r103 = this.f541140a;
        if (va0.a.f553920a == false) goto L5;
        com.bytedance.android.live.incentive.balance.b r104 = com.bytedance.android.live.incentive.balance.b.a.f69332a;
    L6:
        Long r105 = r103.c(r104);
        if (r105 == null) goto L9;
        r102.put("", d.a(r105.longValue()));
    L9:
        Long r106 = this.f541140a.c(com.bytedance.android.live.incentive.balance.b.a.f69332a);
        if (r106 == null) goto L12;
        r102.put("cash", d.a(r106.longValue()));
    L12:
        Long r107 = this.f541140a.c(com.bytedance.android.live.incentive.balance.b.d.f69335a);
        if (r107 == null) goto L15;
        r102.put("gold", d.a(r107.longValue()));
    L15:
        Long r108 = this.f541140a.c(com.bytedance.android.live.incentive.balance.b.C1124b.f69333a);
        if (r108 == null) goto L18;
        r102.put("equivalent_cash", d.a(r108.longValue()));
    L18:
        r101.a(r102);
        com.bytedance.android.live.recharge.platform.business.model.a r109 = r100.f528344a.getRebateData();
        if (r109 == null) goto L21;
        e r110 = new e();
        r110.c(r109.getRebateLimit());
        r110.a(r109.getGiftAmount());
        r110.b(r109.getLeftAmount());
        Unit r111 = Unit.INSTANCE;
        r101.b(r110);
    L21:
        return r101;
    L5:
        r104 = com.bytedance.android.live.incentive.balance.b.e.f69336a;
        goto L6
    }
}
