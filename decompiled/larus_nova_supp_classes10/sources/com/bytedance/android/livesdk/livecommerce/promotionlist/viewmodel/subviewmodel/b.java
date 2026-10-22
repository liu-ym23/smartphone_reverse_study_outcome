package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel;

import cf.x;
import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.model.buynow.BuyNowPrefetchType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tf3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.b {
    public final Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a, Unit> c;
    public final Function0<List<ql.a>> d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.b
    public final void a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a, Unit> r2, Function0<? extends List<? extends ql.a>> r3) {
        Intrinsics.checkNotNullParameter(r2, "sendEvent");
        Intrinsics.checkNotNullParameter(r3, "currentPromotion");
        super(0);
        this.c = r2;
        this.d = r3;
    }

    public static void k(ql.a r3, BuyNowPrefetchType r4) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TYPE);
        if (r3 != null) goto L5;
        return;
    L5:
        PrefetchOrder r0 = r3.getPrefetchOrder();
        if (r0 != null) goto L8;
    L9:
        int r1 = ECSdk.a;
        IEShoppingService r2 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r2 == null) goto L16;
        sc3.c r5 = r2.getBuyNowService();
        if (r5 == null) goto L17;
        r5.l(r3, new l(null), r4);
        return;
    L17:
        return;
    L16:
        return;
    L8:
        if (r0.isFetchModel() != true) goto L9;
    }

    public final void l(int r13, int r14) {
        List r0 = (List) this.d.invoke();
        if (r0 == null) goto L22;
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L30;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ql.a r5 = (ql.a) r3;
        if (r13 > r2) goto L21;
        if (r14 < r2) goto L21;
        ECUrlModel r6 = r5.getDetailCover();
        if (r6 == null) goto L21;
        List r7 = r6.getUrlList();
        if (r7 == null) goto L21;
        String r8 = (String) CollectionsKt.getOrNull(r7, 0);
        if (r8 == null) goto L21;
        ImageExtensionsKt.f(r8, new r("ec_live", "list_goods_detail_preload"), null, null, null, null, 120);
    L21:
        r2 = r4;
        goto L6
    L30:
        return;
    }

    public final void m(List<String> r6, boolean r7, UpdateLocalViewType r8) {
        Intrinsics.checkNotNullParameter(r8, "updateType");
        if (r6 != null) goto L5;
        this.c.invoke(new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.q());
        return;
    L5:
        ArrayList r0 = new ArrayList();
        List r1 = (List) this.d.invoke();
        if (r1 == null) goto L21;
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L21;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        ql.a r9 = (ql.a) r4;
        if (r7 == false) goto L16;
        String r10 = r9.getProductId();
    L18:
        if (r6.contains(r10) == false) goto L20;
        r0.add(Integer.valueOf(r3));
    L20:
        r3 = r5;
        goto L9
    L16:
        r10 = r9.getPromotionId();
    L21:
        Function1<com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a, Unit> r11 = this.c;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r13 = r0.iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        r12.add(new x(((Number) r13.next()).intValue(), r8));
        goto L23
    L25:
        r11.invoke(new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.t(r12));
    }
}
