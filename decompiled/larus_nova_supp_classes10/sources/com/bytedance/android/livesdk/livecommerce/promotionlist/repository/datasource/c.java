package com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource;

import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ com.bytedance.android.ec.core.async.b e;
    public final /* synthetic */ Function2 f;
    public final /* synthetic */ Function0 g;

    public c(b r1, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r2, int r3, int r4, com.bytedance.android.ec.core.async.b r5, Function2 r6, Function0 r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final void accept(Object r9) {
        final vj2.b r10 = (vj2.b) r9;
        if (((g) r10).statusCode == 0) goto L5;
        this.g.invoke();
        return;
    L5:
        if (r10.v() == true) goto L7;
    L11:
        int r0 = zg2.a.a;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1 = this.b;
        zg2.a.a(r1.h, r1.j, Action.SHOP_LIST_DATA_FROM, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data_from", String.valueOf(2))}));
        this.f.invoke(Integer.valueOf(this.c), r10);
        return;
    L7:
        if (r10.i() <= 0) goto L11;
        if (EComABUtils.getAdaptProductBlockSwitch() == false) goto L11;
        this.a.e(this.b, r10.i(), this.c, this.d, this.e, new LivePromotionListRemoteDataSource$requestFirstPageDataWithProductBlockingCheck$1$1(this, r10));
    }
}
