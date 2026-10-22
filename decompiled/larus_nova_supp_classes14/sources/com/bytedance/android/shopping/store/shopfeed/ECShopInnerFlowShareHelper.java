package com.bytedance.android.shopping.store.shopfeed;

import com.bytedance.android.shopping.store.home.entity.ToolType;
import com.bytedance.android.shopping.store.home.f0;
import com.bytedance.android.shopping.store.shopfeed.fragment.AbsShopFeedFragment;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopInnerFlowShareHelper extends com.bytedance.android.shopping.store.home.d {
    public final Lazy g;
    public final b h;
    public final a i;

    public static final class a implements com.bytedance.android.shopping.store.home.a {
        public a() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void a() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void b() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void c() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void d() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void e() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void f() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void g() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void h(ToolType r2) {
            Intrinsics.checkNotNullParameter(r2, "toolType");
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void i() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void j() {
        }

        @Override // com.bytedance.android.shopping.store.home.a
        public final void k() {
        }
    }

    public static final class b implements f0 {
        public final /* synthetic */ ECShopInnerFlowShareHelper a;

        @Override // com.bytedance.android.shopping.store.home.f0
        public final String getPassThroughApi() {
            return null;
        }

        @Override // com.bytedance.android.shopping.store.home.f0
        public final String getShopId() {
            return "";
        }

        @Override // com.bytedance.android.shopping.store.home.f0
        public final String b() {
            ShopFeedParam r0 = ((ECShopFeedViewModel) this.a.g.getValue()).getShopFeedParam();
            if (r0 == null) goto L5;
            String r1 = r0.getSecShopId();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        public b(ECShopInnerFlowShareHelper r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.shopping.store.home.d
    public final com.bytedance.android.shopping.store.home.a c() {
        return this.i;
    }

    @Override // com.bytedance.android.shopping.store.home.d
    public final f0 d() {
        return this.h;
    }

    public ECShopInnerFlowShareHelper(final AbsShopFeedFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.g = LazyKt.lazy(new ECShopInnerFlowShareHelper$viewModel$2(r2));
        this.h = new b(this);
        this.i = new a();
    }
}
