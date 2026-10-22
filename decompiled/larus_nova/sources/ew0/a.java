package ew0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements dw0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f474524a = null;

    public a() {
    }

    static {
        f474524a = new a();
    }

    @Override // dw0.a
    public final void a(String r100, Map<String, String> r101, Collection<? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventProperties");
        Intrinsics.checkNotNullParameter(r102, "eventContext");
        com.bytedance.android.live.recharge.panel.context.c r103 = com.bytedance.android.live.recharge.panel.g.a();
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.g().getValue().b() == true) goto L8;
        return;
    L8:
        boolean r104 = com.bytedance.android.live.recharge.combinedpay.a.a();
        if (r104 == false) goto L11;
        String r105 = "1";
    L12:
        r101.put("if_deduction", r105);
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r102.iterator();
    L14:
        if (r107.hasNext() == false) goto L18;
        Object r108 = r107.next();
        if ((r108 instanceof com.bytedance.android.live.recharge.deal.f) == false) goto L14;
        r106.add(r108);
        goto L14
    L18:
        com.bytedance.android.live.recharge.deal.f r109 = (com.bytedance.android.live.recharge.deal.f) CollectionsKt.firstOrNull(r106);
        if (r104 == false) goto L36;
        if (r109 == null) goto L37;
        long r110 = r109.g();
        qa0.a r111 = qa0.c.f532212b.getService(com.bytedance.android.live.incentive.exchange.d.class);
        Intrinsics.checkNotNull(r111);
        com.bytedance.android.live.incentive.exchange.d r112 = (com.bytedance.android.live.incentive.exchange.d) r111;
        if (va0.a.f553920a == false) goto L24;
        com.bytedance.android.live.incentive.balance.b r113 = com.bytedance.android.live.incentive.balance.b.a.f69332a;
    L25:
        long r114 = r112.c(r113);
        if (r114 < r110) goto L28;
        String r115 = String.valueOf(r110 / ((long) 10));
    L29:
        r101.put("deduction_amt", r115);
        return;
    L28:
        r115 = String.valueOf(r114 / ((long) 10));
        goto L29
    L24:
        r113 = com.bytedance.android.live.incentive.balance.b.e.f69336a;
        goto L25
    L37:
        return;
    L36:
        return;
    L11:
        r105 = "0";
        goto L12
    }
}
