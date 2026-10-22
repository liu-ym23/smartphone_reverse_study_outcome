package jw0;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.order.Order;
import io.reactivex.functions.Consumer;
import jc1.k;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Order f500662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f500663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zv0.e f500664c;

    public f(Order r100, long r101, zv0.e r102) {
        this.f500662a = r100;
        this.f500663b = r101;
        this.f500664c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Order.State r101 = (Order.State) r100;
        Order.State r102 = (Order.State) this.f500662a.getState().f90981b;
        int r103 = a.f500649c[r102.ordinal()];
        if (r103 != 1) goto L5;
        IRechargeService r104 = (IRechargeService) k.f(IRechargeService.class);
        if (r104 == null) goto L26;
        zv0.f r105 = r104.rechargeCenter();
        if (r105 == null) goto L26;
        long r106 = r105.getAvailableDiamonds();
    L27:
        long r107 = r106 + this.f500663b;
        IRechargeService r108 = (IRechargeService) k.f(IRechargeService.class);
        if (r108 == null) goto L32;
        zv0.f r109 = r108.rechargeCenter();
        if (r109 == null) goto L32;
        r109.setAvailableDiamonds(r107);
    L32:
        IRechargeService r110 = (IRechargeService) k.f(IRechargeService.class);
        if (r110 == null) goto L37;
        zv0.f r111 = r110.rechargeCenter();
        if (r111 == null) goto L37;
        r111.sync("exchange");
    L37:
        IRechargeService r112 = (IRechargeService) k.f(IRechargeService.class);
        if (r112 == null) goto L42;
        zv0.f r113 = r112.rechargeCenter();
        if (r113 == null) goto L42;
        r113.syncExchangeInfo();
    L42:
        int r114 = h.f500665a;
        h.e("live_detail", Long.valueOf(this.f500663b));
        zv0.e r115 = this.f500664c;
        if (r115 == null) goto L47;
        r115.c(null);
        return;
    L47:
        return;
    L26:
        r106 = 0;
        goto L27
    L5:
        if (r103 != 2) goto L48;
        Throwable r116 = new Throwable("下单失败");
        IRechargeService r117 = (IRechargeService) k.f(IRechargeService.class);
        if (r117 == null) goto L12;
        zv0.f r118 = r117.rechargeCenter();
        if (r118 == null) goto L12;
        r118.sync("exchange");
    L12:
        IRechargeService r119 = (IRechargeService) k.f(IRechargeService.class);
        if (r119 == null) goto L17;
        zv0.f r120 = r119.rechargeCenter();
        if (r120 == null) goto L17;
        r120.syncExchangeInfo();
    L17:
        zv0.e r121 = this.f500664c;
        if (r121 == null) goto L20;
        r121.a(r116);
    L20:
        h.a(r116);
        return;
    }
}
