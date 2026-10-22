package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.window.base.dynamicview.common.WindowViewFactory;
import com.bytedance.android.ec.window.base.dynamicview.common.g;
import com.bytedance.android.ec.window.base.dynamicview.common.j;
import com.bytedance.android.ec.window.base.dynamicview.renderer.impl.DynamicViewCache;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBaseFragmentPresenter;
import com.bytedance.android.window.shop.holder.presenter.ECWindowPlayableProductOptVideoElementPresenter;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.product.presenter.others.ECWindowProductCardTagInfoElementPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.l;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0004\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowExplainRecommendProductHolder;", "Ltp/c;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/l;", "a", "b", "UIPresenter", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowExplainRecommendProductHolder extends ShopWindowGenericHolder<l> implements tp.c {
    public static final /* synthetic */ int A = 0;
    public final a v;
    public final com.bytedance.android.window.shop.product.presenter.playable.a w;
    public final ECWindowPlayableProductOptVideoElementPresenter x;
    public final WindowLayoutType y;
    public final vp.c z;

    public static final class UIPresenter extends QPresenter {
        public final j e;
        public final Lazy f;
        public to.d g;
        public tq3.c h;
        public final Lazy i;

        public final void C() {
            mo.b r0 = (mo.b) this.f.getValue();
            so.d r1 = (so.d) this.i.getValue();
            tq3.c r2 = this.h;
            if (r2 == null) goto L5;
            to.b r3 = r2.R;
        L6:
            r0.getClass();
            mo.b.b(r1, r3);
            to.d r4 = this.g;
            if (r4 != null) goto L9;
            return;
        L9:
            this.e.c((so.d) this.i.getValue(), r4);
            return;
        L5:
            r3 = null;
            goto L6
        }

        public UIPresenter(Fragment r4) {
            Intrinsics.checkNotNullParameter(r4, "fragment");
            ArrayList r1 = new ArrayList();
            fo.a<WindowLayoutType> r2 = WindowConstDef.a;
            if (WindowConstDef.s == false) goto L5;
            DynamicViewCache r5 = DynamicViewCache.d.a(r4);
        L6:
            this.e = new j(r1, r5);
            this.f = LazyKt.lazy(new WindowExplainRecommendProductHolder$UIPresenter$eventHandler$2(this));
            this.i = LazyKt.lazy(new WindowExplainRecommendProductHolder$UIPresenter$viewProvider$2(this));
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void A(QModel r5) {
            to.b r1 = null;
            if ((r5 instanceof tq3.c) == true) goto L5;
            r5 = null;
        L5:
            tq3.c r6 = (tq3.c) r5;
            this.h = r6;
            if (r6 == null) goto L8;
            to.d r0 = r6.Q;
        L9:
            this.g = r0;
            if (r0 != null) goto L12;
            return;
        L12:
            this.e.b((so.d) this.i.getValue(), r0);
            mo.b r2 = (mo.b) this.f.getValue();
            so.d r3 = (so.d) this.i.getValue();
            if (r6 == null) goto L15;
            r1 = r6.R;
        L15:
            r2.a(r3, r1);
            return;
        L8:
            r0 = null;
            goto L9
        }
    }

    public final class a extends ECWindowHolderBaseFragmentPresenter {
        public l i;
        public final /* synthetic */ WindowExplainRecommendProductHolder j;

        public final void c0() {
            this.i = null;
        }

        public final void b0(QModel r2) {
            if ((r2 instanceof l) == true) goto L5;
            r2 = null;
        L5:
            this.i = (l) r2;
        }

        public a(WindowExplainRecommendProductHolder r2, Fragment r3) {
            Intrinsics.checkNotNullParameter(r3, "fragment");
            this.j = r2;
            super(r3);
        }
    }

    public static final class b {
    }

    public static final class c extends i<WindowV2ProductItemVO> {
        public c(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            super(r2);
        }

        public final void d0(WindowV2ProductItemVO r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            ((i) this).g.g(r2);
        }
    }

    static {
    }

    public final void B() {
        this.z.B();
    }

    public final boolean D3() {
        return this.z.D3();
    }

    public final void R() {
        this.z.R();
    }

    public final boolean g0() {
        return this.z.g0();
    }

    public final boolean isPlaying() {
        return this.z.isPlaying();
    }

    public final tp.b m() {
        return this.z.m();
    }

    public final void o2(tp.b r2) {
        this.z.o2(r2);
    }

    public final Rect r() {
        this.z.getClass();
        return null;
    }

    public final void startPlay() {
        this.z.startPlay();
    }

    public final void stopPlay() {
        this.z.stopPlay();
    }

    public final void v() {
        this.z.v();
    }

    public final void M() {
        vp.c r0 = this.z;
        r0.getClass();
        tp.c.a.a(r0);
    }

    public final WindowPlayAbleType P() {
        this.z.getClass();
        return WindowPlayAbleType.OTHER;
    }

    public final void U0() {
        vp.c r0 = this.z;
        r0.getClass();
        tp.c.a.b(r0);
    }

    public final void pausePlay() {
        vp.c r0 = this.z;
        r0.getClass();
        tp.c.a.e(r0);
    }

    public final boolean resumePlay() {
        vp.c r0 = this.z;
        r0.getClass();
        return tp.c.a.f(r0);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        WindowLayoutType r0 = this.y;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isSingleColumn() != true) goto L7;
        return true;
    }

    public final void x() {
        vp.c r0 = this.z;
        r0.getClass();
        tp.c.a.c(r0);
    }

    public final void z() {
        vp.c r0 = this.z;
        r0.getClass();
        tp.c.a.d(r0);
    }

    public final List<tp.c> L(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "visibleArea");
        return this.x.L(r2);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r7) {
        StaggeredGridLayoutManager.LayoutParams r8 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r8 == null) goto L10;
        if ((r8.getSpanIndex() % 2) != 1) goto L8;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(8), d.a(9));
    L8:
        return new Rect(d.a(8), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        com.bytedance.android.ec.window.base.utils.quick.b r0 = new com.bytedance.android.ec.window.base.utils.quick.b();
        r0.b(this.w, WindowExplainRecommendProductHolder$generatePresenter$1.INSTANCE);
        r0.b(this.x, WindowExplainRecommendProductHolder$generatePresenter$2.INSTANCE);
        r0.a(this.v);
        r0.b(new UIPresenter(r4), WindowExplainRecommendProductHolder$generatePresenter$3.INSTANCE);
        r0.a(new op3.i(this.y));
        return r0;
    }

    public WindowExplainRecommendProductHolder(Fragment r13, WindowLayoutType r14) {
        vp.c r0 = new vp.c();
        Intrinsics.checkNotNullParameter(r13, "fragment");
        Intrinsics.checkNotNullParameter(r0, "playableProxy");
        ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
        Context r2 = r13.requireContext();
        r1.getClass();
        ShoppingAsyncInflater r3 = ShoppingAsyncInflater.a.a(r2);
        boolean r4 = true;
        if (r14 != null) goto L5;
    L7:
        int r5 = 2131561019;
    L8:
        super(r13, com.bytedance.android.ec.opt.asyncInflate.c.a(r3, r5, null, 4));
        this.y = r14;
        this.z = r0;
        WindowViewFactory.c.getClass();
        ViewGroup r6 = (ViewGroup) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371322);
        if (r6 == null) goto L22;
        View r7 = new ro.a(((RecyclerView.ViewHolder) this).itemView.getContext());
        if (r14 != null) goto L14;
    L16:
        String r8 = "product_bottom_recommend_double";
    L17:
        k.a r9 = k.i;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "type");
        int r10 = k.f;
        r7.setTag(r10, r8);
        r7.setId(g.a("window", r8));
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter("dynamic_view", "type");
        int r11 = k.h;
        r7.setTag(r11, "dynamic_view");
        View r12 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131387406);
        if (r12 == null) goto L21;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter("tags", "type");
        r12.setTag(r10, "tags");
        r12.setId(g.a("window", "tags"));
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter("window_product_tags", "type");
        r12.setTag(r11, "window_product_tags");
    L21:
        r6.addView(r7, -1, -2);
        goto L22
    L14:
        if (r14.isSingleColumn() != true) goto L16;
        r8 = "product_bottom_recommend_single";
    L22:
        a r15 = new a(this, r13);
        this.v = r15;
        com.bytedance.android.window.shop.product.presenter.playable.a r16 = new com.bytedance.android.window.shop.product.presenter.playable.a(r13, r14, new WindowExplainRecommendProductHolder$productGroupPresenter$1(r15));
        r16.d0(new com.bytedance.android.window.shop.product.presenter.playable.c(r13));
        r16.d0(new com.bytedance.android.window.shop.product.presenter.playable.b(r13, r14));
        r16.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.a(r13));
        r16.d0(new ECWindowProductCardRecommendInfoElementPresenter(r13));
        r16.d0(new com.bytedance.android.ec.window.base.product.presenter.element.tags.c(r13));
        r16.d0(new ECWindowProductCardTagInfoElementPresenter(r13));
        r16.d0(new com.bytedance.android.window.shop.product.presenter.others.b(r13, r14, 210));
        r16.d0(new c(r13));
        this.w = r16;
        if (r14 != null) goto L25;
    L27:
        r4 = false;
    L28:
        this.x = new ECWindowPlayableProductOptVideoElementPresenter(r0, r4);
        return;
    L25:
        if (r14.isSingleColumn() != true) goto L27;
    L5:
        if (r14.isSingleColumn() != true) goto L7;
        r5 = 2131561020;
        goto L8
    }
}
