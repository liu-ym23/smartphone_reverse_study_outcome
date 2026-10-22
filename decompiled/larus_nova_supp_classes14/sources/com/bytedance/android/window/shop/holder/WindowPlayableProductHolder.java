package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
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
import com.bytedance.android.window.shop.holder.presenter.ECWindowPlayableProductVideoElementPresenter;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.product.presenter.others.ECWindowProductCardTagInfoElementPresenter;
import com.bytedance.android.window.shop.product.presenter.playable.ECWindowPlayableProductCardGroupPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.f0;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0004\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowPlayableProductHolder;", "Ltp/c;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f0;", "a", "b", "UIPresenter", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowPlayableProductHolder extends ShopWindowGenericHolder<f0> implements tp.c {
    public static final boolean A = false;
    public final a v;
    public final ECWindowPlayableProductCardGroupPresenter w;
    public final com.bytedance.android.window.shop.holder.presenter.b x;
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
            this.f = LazyKt.lazy(new WindowPlayableProductHolder$UIPresenter$eventHandler$2(this));
            this.i = LazyKt.lazy(new WindowPlayableProductHolder$UIPresenter$viewProvider$2(this));
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
        public f0 i;
        public final /* synthetic */ WindowPlayableProductHolder j;

        public final void c0() {
            this.i = null;
        }

        public final void b0(QModel r2) {
            if ((r2 instanceof f0) == true) goto L5;
            r2 = null;
        L5:
            this.i = (f0) r2;
        }

        public a(WindowPlayableProductHolder r2, Fragment r3) {
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

    static {
        A = ECSettingKeys.d0();
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
        r0.b(this.w, WindowPlayableProductHolder$generatePresenter$1.INSTANCE);
        r0.b(this.x, WindowPlayableProductHolder$generatePresenter$2.INSTANCE);
        r0.a(this.v);
        r0.b(new UIPresenter(r4), WindowPlayableProductHolder$generatePresenter$3.INSTANCE);
        return r0;
    }

    public WindowPlayableProductHolder(Fragment r9, WindowLayoutType r10) {
        vp.c r0 = new vp.c();
        Intrinsics.checkNotNullParameter(r9, "fragment");
        Intrinsics.checkNotNullParameter(r0, "playableProxy");
        ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
        Context r2 = r9.requireContext();
        r1.getClass();
        ShoppingAsyncInflater r3 = ShoppingAsyncInflater.a.a(r2);
        if (r10 != null) goto L5;
    L7:
        int r4 = 2131561027;
    L8:
        super(r9, com.bytedance.android.ec.opt.asyncInflate.c.a(r3, r4, null, 4));
        this.y = r10;
        this.z = r0;
        ViewStub r5 = (ViewStub) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371359);
        boolean r6 = A;
        if (r6 == false) goto L11;
        int r7 = 2131561026;
    L12:
        r5.setLayoutResource(r7);
        r5.inflate();
        WindowViewFactory.c.getClass();
        View r8 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131387403);
        if (r8 == null) goto L25;
        ViewGroup r11 = (ViewGroup) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371322);
        if (r11 == null) goto L25;
        ro.a r12 = new ro.a(((RecyclerView.ViewHolder) this).itemView.getContext());
        if (r10 != null) goto L21;
    L23:
        String r13 = "product_bottom_recommend_double";
    L24:
        w4(r12, r13, "dynamic_view");
        w4(r8, "store_entry_group", "linear_group");
        w4(((RecyclerView.ViewHolder) this).itemView.findViewById(2131387406), "tags", "window_product_tags");
        r11.addView(r12, -1, -2);
        goto L25
    L21:
        if (r10.isSingleColumn() != true) goto L23;
        r13 = "product_bottom_recommend_single";
    L25:
        a r14 = new a(this, r9);
        this.v = r14;
        ECWindowPlayableProductCardGroupPresenter r15 = new ECWindowPlayableProductCardGroupPresenter(r9, r10, new WindowPlayableProductHolder$productGroupPresenter$1(r14), null);
        r15.d0(new com.bytedance.android.ec.window.base.product.presenter.element.title.a(r9));
        r15.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.a(r9));
        r15.d0(new ECWindowProductCardRecommendInfoElementPresenter(r9));
        r15.d0(new com.bytedance.android.ec.window.base.product.presenter.element.source.a(r9));
        r15.d0(new com.bytedance.android.ec.window.base.product.presenter.element.tags.c(r9));
        r15.d0(new ECWindowProductCardTagInfoElementPresenter(r9));
        r15.d0(new com.bytedance.android.window.shop.product.presenter.others.b(r9, r10, 208));
        r15.d0(new c(r9));
        this.w = r15;
        if (r6 == false) goto L28;
        com.bytedance.android.window.shop.holder.presenter.b r16 = new ECWindowPlayableProductOptVideoElementPresenter(r0, false);
    L29:
        this.x = r16;
        return;
    L28:
        r16 = new ECWindowPlayableProductVideoElementPresenter(r0);
        goto L29
    L11:
        r7 = 2131561029;
        goto L12
    L5:
        if (r10.isSingleColumn() != true) goto L7;
        r4 = 2131561028;
        goto L8
    }

    public final void w4(View r4, String r5, String r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        k.i.getClass();
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "type");
        r4.setTag(k.f, r5);
        r4.setId(g.a("window", r5));
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r6, "type");
        r4.setTag(k.h, r6);
    }
}
