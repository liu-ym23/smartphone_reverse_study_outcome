package com.bytedance.android.shopping.new_cart.components;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.bytedance.android.shopping.new_cart.eventcenter.event.ScrollMode;
import com.bytedance.android.shopping.new_cart.widgets.CartGULView;
import com.bytedance.android.shopping.new_cart.widgets.CartRefreshHeadView;
import com.bytedance.android.shopping.new_cart.widgets.LoadMoreFooterView;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartSwipeNestRefreshLayoutV2;
import com.bytedance.android.shopping.utils.t;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartBodyComponent extends com.bytedance.android.shopping.new_cart.components.a {
    public final CartLinkedScrollViewV2 b;
    public final List<t> c;
    public final CartSwipeNestRefreshLayoutV2 d;
    public final CartObjectContainer e;

    public static final class a implements Runnable {
        public final /* synthetic */ CartBodyComponent a;

        public a(CartBodyComponent r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartLinkedScrollViewV2 r0 = this.a.b;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            CartGULView r1 = r0.getGul();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.h(false);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        CartLinkedScrollViewV2 r0 = this.b;
        if (r0 == null) goto L6;
        r0.setCartObjectContainer(this.e);
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void i() {
        CartLinkedScrollViewV2 r0 = this.b;
        if (r0 == null) goto L10;
        CartGULView r1 = r0.getGul();
        if (r1 == null) goto L11;
        ti.l r2 = r1.g;
        if (r2 == null) goto L12;
        r2.release();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void j() {
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(this.a.d, "onPause", new a(this), null);
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void k() {
        CartLinkedScrollViewV2 r0 = this.b;
        if (r0 == null) goto L8;
        CartGULView r1 = r0.getGul();
        if (r1 == null) goto L9;
        r1.h(true);
        return;
    L9:
        return;
    }

    public final void n() {
        CartSwipeNestRefreshLayoutV2 r0 = this.d;
        if (r0 == null) goto L11;
        r0.h = false;
        NestedScrollView r2 = r0.e;
        if (r2 == null) goto L7;
        int r3 = (int) r2.getTranslationY();
    L8:
        if (r3 <= 0) goto L12;
        r0.f(false);
        return;
    L12:
        return;
    L7:
        r3 = 0;
        goto L8
    }

    public final LoadMoreFooterView o() {
        CartLinkedScrollViewV2 r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLoadingFooter();
    }

    public final CartLinkedScrollViewV2 p() {
        CartLinkedScrollViewV2 r0 = this.b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.new_cart.widgets.ICartLinkedScrollViewBase");
    }

    public final RecyclerView q() {
        CartLinkedScrollViewV2 r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getYataBody();
    }

    public final void s() {
        CartLinkedScrollViewV2 r0 = this.b;
        if (r0 == null) goto L12;
        r0.p.stopScroll();
        RecyclerView r1 = r0.q.getGULRecyclerView();
        if (r1 == null) goto L7;
        r1.stopScroll();
    L7:
        r0.scrollTo(0, 0);
        RecyclerView r2 = r0.q.getGULRecyclerView();
        if (r2 == null) goto L10;
        r2.scrollToPosition(0);
    L10:
        r0.p.scrollToPosition(0);
        r0.p.post(new com.bytedance.android.shopping.new_cart.widgets.nest.d(r0));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.widget.FrameLayout, com.bytedance.android.shopping.new_cart.widgets.nest.CartSwipeNestRefreshLayoutV2] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public CartBodyComponent(CartObjectContainer r4) {
        Intrinsics.checkNotNullParameter(r4, "objectContainer");
        super(r4);
        this.e = r4;
        NewCartActivity r5 = c();
        CartSwipeNestRefreshLayoutV2 r1 = 0;
        if (r5 == null) goto L6;
        CartLinkedScrollViewV2 r6 = (CartLinkedScrollViewV2) r5.findViewById(2131378045);
        if (r6 == null) goto L6;
    L12:
        this.b = r6;
        this.c = new ArrayList();
        NewCartActivity r0 = c();
        if (r0 == null) goto L16;
        CartSwipeNestRefreshLayoutV2 r2 = (CartSwipeNestRefreshLayoutV2) r0.findViewById(2131365248);
        ?? r3 = r2;
        if (r2 == null) goto L16;
    L22:
        if (r3 == 0) goto L24;
        r3.setHeaderView((CartRefreshHeadView) r3.findViewById(2131383443));
        r3.setBodyView(r6);
        r3.setOnRefreshListener(new CartBodyComponent$$special$$inlined$apply$lambda$1(this));
        Unit r7 = Unit.INSTANCE;
        r1 = r3;
    L24:
        this.d = r1;
        return;
    L16:
        Fragment r8 = this.a.f;
        if (r8 == null) goto L21;
        View r9 = r8.getView();
        if (r9 == null) goto L21;
        r3 = (CartSwipeNestRefreshLayoutV2) r9.findViewById(2131365248);
    L21:
        r3 = 0;
    L6:
        Fragment r10 = this.a.f;
        if (r10 == null) goto L11;
        View r11 = r10.getView();
        if (r11 == null) goto L11;
        r6 = (CartLinkedScrollViewV2) r11.findViewById(2131378045);
    L11:
        r6 = null;
        goto L12
    }

    public final void r(int r4, ScrollMode r5) {
        Intrinsics.checkNotNullParameter(r5, "scrollMode");
        CartLinkedScrollViewV2 r1 = this.b;
        if (r1 == null) goto L27;
        Intrinsics.checkNotNullParameter(r5, "scrollMode");
        r1.c();
        int r6 = com.bytedance.android.shopping.new_cart.widgets.nest.b.a[r5.ordinal()];
        LinearLayoutManager r2 = null;
        if (r6 != 1) goto L7;
        LinearLayoutManager r7 = r1.p.getLayoutManager();
        if ((r7 instanceof LinearLayoutManager) == false) goto L23;
        r2 = r7;
    L23:
        LinearLayoutManager r3 = r2;
        if (r3 == null) goto L31;
        r3.scrollToPositionWithOffset(r4, 10);
        return;
    L31:
        return;
    L7:
        if (r6 != 2) goto L9;
        LinearLayoutManager r8 = r1.p.getLayoutManager();
        if ((r8 instanceof LinearLayoutManager) == false) goto L16;
        r2 = r8;
    L16:
        LinearLayoutManager r9 = r2;
        if (r9 == null) goto L29;
        r9.scrollToPositionWithOffset(r4, 300);
        return;
    L29:
        return;
    L9:
        if (r6 != 3) goto L32;
        r1.p.scrollToPosition(r4);
        return;
    L32:
        return;
    }
}
