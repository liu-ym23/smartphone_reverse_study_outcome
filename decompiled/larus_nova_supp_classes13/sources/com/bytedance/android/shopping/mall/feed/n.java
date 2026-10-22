package com.bytedance.android.shopping.mall.feed;

import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.shopping.mall.homepage.card.loadview.LoadingViewCardVH;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public final /* synthetic */ ECMallFeed.n b;

    public static final class a implements LoadingViewCardVH.b {
        public final /* synthetic */ n a;

        @Override // com.bytedance.android.shopping.mall.homepage.card.loadview.LoadingViewCardVH.b
        public final void a() {
            Integer r0 = this.a.b.a.R;
            if (r0 == null) goto L6;
            int r2 = r0.intValue();
            ECMallFeed.t0(this.a.b.a, r2, null, null, false, null, null, null, 254);
            return;
        }

        public a(n r1) {
            this.a = r1;
        }
    }

    public final BaseViewHolder n(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        boolean r0 = LoadingViewCardVH.q;
        ECHybridListContainer r1 = this.b.a.z1;
        a r2 = new a(this);
        Intrinsics.checkNotNullParameter(r5, "container");
        o93.a r3 = new o93.a(r5, new com.bytedance.android.shopping.mall.homepage.card.loadview.a(r2));
        LoadingViewCardVH r6 = new LoadingViewCardVH(r3.d, r1, r3);
        this.b.a.getClass();
        return r6;
    }

    public n(ECMallFeed.n r1, Class r2) {
        this.b = r1;
        super(r2);
    }
}
