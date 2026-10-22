package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.j;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.hybridproduct.module.n;
import com.bytedance.android.shopping.store.hybridproduct.n0;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSlcCommonCardHolder;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "Lln/c;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSlcCommonCardHolder extends ECShopBaseHolder implements ln.c {
    public static final a w = null;
    public final QUIManager q;
    public final ViewGroup r;
    public final ECStoreViewModel s;
    public final LayoutTypes t;
    public final e u;
    public final n0 v;

    public static final class a {
        public a() {
        }
    }

    public final void B() {
        this.v.B();
    }

    public final List<ln.c> L(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "visibleArea");
        return this.v.L(r2);
    }

    public final void R() {
        this.v.R();
    }

    public final boolean isPlaying() {
        return this.v.isPlaying();
    }

    public final void k1(nn.e.a r2) {
        this.v.k1(r2);
    }

    public final Rect r() {
        this.v.getClass();
        return null;
    }

    public final void v() {
        this.v.v();
    }

    static {
        w = new a();
    }

    public final void M() {
        n0 r0 = this.v;
        r0.getClass();
        ln.c.a.a(r0);
    }

    public final PlayAbleType P() {
        this.v.getClass();
        return PlayAbleType.OTHER;
    }

    public final ln.b m() {
        return ((nn.a) this.v).a;
    }

    public final void pausePlay() {
        n0 r0 = this.v;
        r0.getClass();
        ln.c.a.d(r0);
    }

    public final void startPlay() {
        n0 r0 = this.v;
        r0.getClass();
        ln.c.a.e(r0);
    }

    public final void stopPlay() {
        n0 r0 = this.v;
        r0.getClass();
        ln.c.a.f(r0);
    }

    public final void x() {
        n0 r0 = this.v;
        r0.getClass();
        ln.c.a.b(r0);
    }

    public final void z() {
        n0 r0 = this.v;
        r0.getClass();
        ln.c.a.c(r0);
    }

    public final void o() {
        super.o();
        this.q.r(n.class);
    }

    public final void onRelease() {
        super.onRelease();
        this.q.r(n.class);
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "itemId");
        dm.a.a("测试轻览").a("ECShopSlcCommonCardHolder.bind:$");
        if ((r8 instanceof j) == true) goto L5;
        r8 = null;
    L5:
        j r10 = (j) r8;
        if (r10 != null) goto L9;
        return;
    L9:
        if (this.t != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L11;
        int r0 = 2;
    L12:
        int r4 = 0;
        if (this.u.a != null) goto L31;
        String r2 = r10.h;
        if (r2 == null) goto L18;
        r r1 = this.s.getSliceCardFactory().a(r2, r0);
    L19:
        dm.a.b r11 = dm.a.a("测试轻览");
        StringBuilder r3 = new StringBuilder("ECShopSlcCommonCardHolder.bind2:");
        if (r1 != null) goto L22;
        boolean r5 = true;
    L23:
        r3.append(r5);
        r11.a(r3.toString());
        if (r1 == null) goto L28;
        View r12 = r1.c;
        if (r12 == null) goto L28;
        this.r.addView(r12, new FrameLayout.LayoutParams(-1, -2));
    L28:
        if (r1 != null) goto L30;
        dm.a.a("ECShopSlcCommonCardHolder").b("bind:viewInfo is null", null);
    L30:
        this.u.a = r1;
        goto L31
    L22:
        r5 = false;
        goto L23
    L18:
        r1 = null;
    L31:
        int r13 = getAdapterPosition();
        if (r13 < 0) goto L42;
        int r6 = 0;
    L34:
        ECHybridListAdapter r7 = ((BaseViewHolder) this).g;
        if (r7 != null) goto L37;
    L39:
        if (r4 == r13) goto L41;
        r4 = r4 + 1;
        goto L34
    L41:
        r4 = r6;
        goto L42
    L37:
        if (r7.getItemViewType(r4) != ECHybridListItemType.SHOP_SLICE_CLOTHES_PREVIEW.getType()) goto L39;
        r6 = r6 + 1;
    L42:
        r10.j = r4 - 1;
        this.q.c(n.class, r10);
        return;
    L11:
        r0 = 1;
        goto L12
    }

    public ECShopSlcCommonCardHolder(QUIManager r2, ViewGroup r3, ECStoreViewModel r4, LayoutTypes r5, e r6, n0 r7) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemViewO");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        Intrinsics.checkNotNullParameter(r5, "layoutType");
        Intrinsics.checkNotNullParameter(r6, "viewInfoProxy");
        Intrinsics.checkNotNullParameter(r7, "playableProxy");
        super(r3, r4);
        this.q = r2;
        this.r = r3;
        this.s = r4;
        this.t = r5;
        this.u = r6;
        this.v = r7;
    }
}
