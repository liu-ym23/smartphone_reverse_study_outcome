package pa0;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: classes45.dex */
public final class o implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.live.revenue.common.reactive.c f528350a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.live.revenue.common.reactive.c f528351b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f528352c = null;

    public o() {
    }

    static {
        f528352c = new o();
        com.bytedance.android.live.revenue.common.reactive.c r100 = new com.bytedance.android.live.revenue.common.reactive.c(h.f528341a);
        f528350a = r100;
        f528351b = r100;
    }

    @Override // pa0.f
    public final BehaviorSubject b() {
        jy0.b.a("Incentive/UserIncomeRepository", "updateIncomeInfo begin");
        boolean r100 = va0.a.f553920a;
        int r101 = j.f528343a;
        tz0.b r102 = tz0.b.f548039a;
        uz0.c r103 = new uz0.c();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "$this$beforeConfigureRequest");
        Map<String, String> r104 = r103.f552161b;
        Intrinsics.checkNotNullParameter(r104, "queriesMap");
        if (com.bytedance.android.live.recharge.util.e.a() == 0) goto L5;
        int r105 = 1;
    L6:
        String r106 = Integer.valueOf(r105).toString();
        Intrinsics.checkNotNullParameter("exchange_type", "$this$setTo");
        if (r106 == null) goto L9;
        r104.put("exchange_type", r106);
    L9:
        x.a(r103, false);
        Intrinsics.checkNotNullParameter(r103, "$this$afterConfigureRequest");
        Observable r107 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/wallet/get_user_income/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.recharge.platform.business.model.income.b.class)), com.bytedance.android.live.recharge.platform.business.model.income.d.class, r103.f552163d, r103.f552160a, r103.f552161b, r103.f552162c).map(i.f528342a).map(n.f528349a);
        BehaviorSubject r108 = BehaviorSubject.create();
        RxUtilKt.h(r107).doOnEach(new m()).subscribe(r108);
        return r108;
    L5:
        r105 = 0;
        goto L6
    }

    @Override // pa0.f
    public final com.bytedance.android.live.revenue.common.reactive.c a() {
        return f528351b;
    }
}
