package y01;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.live.revenue.service.recharge.RechargeServiceWrapper;
import jc1.k;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements q01.a {
    public a() {
    }

    @Override // q01.a
    public final void b() {
    }

    @Override // q01.a
    public final void c() {
    }

    @Override // q01.a
    public final void d() {
    }

    @Override // q01.a
    public final void a() {
        RechargeServiceWrapper r100 = new RechargeServiceWrapper();
        k.l(IRechargeService.class, r100.getRealInstance());
        k.l(IRechargeServiceExternal.class, r100);
    }
}
