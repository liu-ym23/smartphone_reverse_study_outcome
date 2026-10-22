package com.bytedance.android.shopping.sku.common.jsb;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.CarModelSelectInfo;
import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.e1;
import com.bytedance.android.ec.core.utils.f1;
import com.bytedance.android.ec.core.utils.f2;
import com.bytedance.android.ec.core.utils.k;
import com.bytedance.android.ec.core.utils.m;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonOnceInTimeHelper;
import hl.n;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonEventCenter {
    public final List<Pair<String, j>> a;
    public final SkuCommonOnceInTimeHelper b;
    public final com.bytedance.android.ec.core.async.b c;
    public final com.bytedance.android.shopping.sku.common.jsb.a d;

    public static final class a implements j {
        public final /* synthetic */ SkuCommonEventCenter a;

        public a(SkuCommonEventCenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.d.e(r2);
        }
    }

    public static final class b implements j {
        public final /* synthetic */ SkuCommonEventCenter a;

        public b(SkuCommonEventCenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.d.g(r2);
        }
    }

    public final void a() {
        s0.c(this);
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Pair r1 = (Pair) r0.next();
        ECLiveHybridUtil.m((String) r1.getFirst(), (j) r1.getSecond());
        goto L4
    L6:
        Function1 r2 = f2.a;
        f2.a = new SkuCommonEventCenter$register$2(this);
        f2.a r3 = f2.b;
        ECLiveHybridUtil.m("prescribeIMPageClose", r3);
        ECLiveHybridUtil.m("reloadSKUPanel", r3);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onCarModelEvent(f1 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        CarModelSelectInfo r3 = r2.a;
        this.d.a(r3);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onChartEvent(e1 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.b.a(new AnonymousClass1(this));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onPoiInfoEvent(n r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.d.c(r2.a);
    }

    public SkuCommonEventCenter(com.bytedance.android.ec.core.async.b r6, com.bytedance.android.shopping.sku.common.jsb.a r7) {
        Intrinsics.checkNotNullParameter(r6, "disposable");
        Intrinsics.checkNotNullParameter(r7, "callback");
        this.c = r6;
        this.d = r7;
        a r8 = new a(this);
        b r1 = new b(this);
        Function1<com.bytedance.android.shopping.sku.common.jsb.b, Unit> r3 = new SkuCommonEventCenter$jsList$1(this);
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = CollectionsKt.listOf(new Pair[]{TuplesKt.to("updateSelectedShop", d1.c), TuplesKt.to("updateSelectedCarModel", k.a), TuplesKt.to("CLIENT_SHOULD_UPDATE_RECOMMEND_SIZE", m.a), TuplesKt.to("next_page_event", new c(r3)), TuplesKt.to("ecom.buynow.dismiss", r8), TuplesKt.to("ecom.buynow.show", r1)});
        this.b = new SkuCommonOnceInTimeHelper(r6, 200);
    }
}
