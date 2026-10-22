package zc1;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.wallet.monitor.WalletMonitorService;
import com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.wallet.model.i f571240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f571241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f571242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f571243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f571244e;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Throwable r101 = r100;
        if (v.a() == false) goto L5;
        String r102 = Arrays.toString(r101.getStackTrace());
        f2.c(r102, 0);
        int r103 = com.bytedance.android.live.revenue.common.v.f91009a;
        com.bytedance.android.live.revenue.common.v.b("wallet_pay_alog_tag", r102, r101);
    L5:
        HashMap<String, Object> r104 = this.f571244e.d("check_order_fail");
        r104.put("order_id", this.f571240a.a());
        r104.put("pay_type", this.f571241b);
        com.bytedance.android.live.recharge.trace.f.c(false, r101, r104);
        int r105 = fd1.b.f476458a;
        fd1.b.c(WalletMonitorService.WALLET_CHECK_ORDER_FAIL, r104, r101);
        int r106 = com.bytedance.android.live.revenue.common.v.f91009a;
        com.bytedance.android.live.revenue.common.v.f("wallet_pay_alog_tag", r104);
        r.d(1, this.f571242c.f571233a, this.f571240a, r101, this.f571243d);
        h.b(this.f571244e, r101);
    }

    public g(h r100, com.bytedance.android.live.wallet.model.i r101, String r102, d r103, DetailChargeDeal r104, String r105) {
        this.f571244e = r100;
        this.f571240a = r101;
        this.f571241b = r102;
        this.f571242c = r103;
        this.f571243d = r105;
    }
}
