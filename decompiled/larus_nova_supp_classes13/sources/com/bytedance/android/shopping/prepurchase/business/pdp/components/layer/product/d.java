package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.bytedance.android.shopping.anchorv3.widget.FixedRecyclerView;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final /* synthetic */ int q = 0;
    public ProductDetailInfoAdapter a;
    public BaseInfoServiceSnapshotTransitionController b;
    public boolean c;
    public Function1<? super List<? extends com.bytedance.android.ecom.arch.slice.adapter.b>, Unit> d;
    public final Lazy e;
    public int f;
    public final MainFeedInitializer$scrollListener$1 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final BasePdpRecyclerView k;
    public final ProductDetailInfoViewModel l;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> m;
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e n;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j o;
    public final com.bytedance.android.ec.core.async.b p;

    public static final class a {
    }

    static {
    }

    public final void a() {
        vg3.v r0 = (vg3.v) this.o.getService(vg3.v.class);
        if (r0 == null) goto L5;
        r0.J0(false);
    L5:
        BaseInfoServiceSnapshotTransitionController r1 = this.b;
        if (r1 == null) goto L8;
        r1.i = true;
        r1.h++;
        r1.k();
        r1.j();
        r1.l++;
        r1.m = null;
        r1.c();
        r1.c = null;
        r1.d = null;
        r1.b = null;
    L8:
        this.b = null;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.MainFeedInitializer$scrollListener$1] */
    public d(FixedRecyclerView r2, ProductDetailInfoViewModel r3, com.bytedance.android.shopping.prepurchase.arch.container.c r4, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r5, com.bytedance.android.shopping.prepurchase.arch.container.component.j r6, DisposableScope r7) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r7, "composableDisposable");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.p = r7;
        this.e = LazyKt.lazy(MainFeedInitializer$theLayoutManager$2.INSTANCE);
        this.g = new MainFeedInitializer$scrollListener$1(this);
        this.j = true;
    }
}
