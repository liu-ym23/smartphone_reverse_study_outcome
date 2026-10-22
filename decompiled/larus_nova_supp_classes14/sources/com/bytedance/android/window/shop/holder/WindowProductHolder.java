package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.window.base.dynamicview.common.WindowViewFactory;
import com.bytedance.android.ec.window.base.dynamicview.common.g;
import com.bytedance.android.ec.window.base.dynamicview.common.j;
import com.bytedance.android.ec.window.base.dynamicview.renderer.impl.DynamicViewCache;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import com.bytedance.android.ec.window.base.product.presenter.element.extmodule.ECWindowProductExtModuleElementPresenter;
import com.bytedance.android.ec.window.base.product.presenter.element.mainimage.ECWindowProductCardMainImagePresenter;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.product.presenter.others.ECWindowProductCardTagInfoElementPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.b0;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowProductHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/b0;", "a", "UIPresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductHolder extends ShopWindowGenericHolder<b0> {
    public static final boolean w = false;
    public final WindowLayoutType v;

    public static final class UIPresenter extends i<tq3.c> {
        public final j l;
        public final Lazy m;
        public to.d n;
        public tq3.c o;
        public final Lazy p;

        public final void c0() {
            mo.b r0 = (mo.b) this.m.getValue();
            so.d r1 = (so.d) this.p.getValue();
            tq3.c r2 = this.o;
            if (r2 == null) goto L5;
            to.b r3 = r2.R;
        L6:
            r0.getClass();
            mo.b.b(r1, r3);
            to.d r4 = this.n;
            if (r4 != null) goto L9;
            return;
        L9:
            this.l.c((so.d) this.p.getValue(), r4);
            return;
        L5:
            r3 = null;
            goto L6
        }

        public UIPresenter(Fragment r4) {
            Intrinsics.checkNotNullParameter(r4, "fragment");
            super(r4);
            ArrayList r1 = new ArrayList();
            fo.a<WindowLayoutType> r2 = WindowConstDef.a;
            if (WindowConstDef.s == false) goto L5;
            DynamicViewCache r5 = DynamicViewCache.d.a(r4);
        L6:
            this.l = new j(r1, r5);
            this.m = LazyKt.lazy(new WindowProductHolder$UIPresenter$eventHandler$2(this));
            this.p = LazyKt.lazy(new WindowProductHolder$UIPresenter$viewProvider$2(this));
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void d0(WindowV2ProductItemVO r5) {
            tq3.c r6 = (tq3.c) r5;
            this.o = r6;
            to.b r0 = null;
            if (r6 == null) goto L5;
            to.d r1 = r6.Q;
        L6:
            this.n = r1;
            if (r1 == null) goto L14;
            this.l.b((so.d) this.p.getValue(), r1);
            mo.b r2 = (mo.b) this.m.getValue();
            so.d r3 = (so.d) this.p.getValue();
            if (r6 == null) goto L12;
            r0 = r6.R;
        L12:
            r2.a(r3, r0);
            return;
        L14:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class a {
    }

    static {
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == false) goto L17;
        Lazy r1 = ECSettingKeys.a;
        int r2 = p.a;
        Object r3 = Boolean.FALSE;
        boolean r4 = false;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r6 = jj4.b.b;     // Catch: Throwable -> L9
        Object r7 = jj4.a.a("window_product_use_ext_module", Boolean.class, r3, false);     // Catch: Throwable -> L9
        if (r7 != null) goto L16;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L16:
        if (((Boolean) r7).booleanValue() == true) goto L17;
    L18:
        w = r4;
        return;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Object r9 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r9) == true) goto L14;
        r3 = r9;
    L14:
        r7 = r3;
    L17:
        r4 = true;
        goto L18
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        WindowLayoutType r0 = this.v;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isSingleColumn() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r7) {
        StaggeredGridLayoutManager.LayoutParams r8 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r8 == null) goto L15;
        int r9 = r8.getSpanIndex();
        WindowLayoutType r0 = this.v;
        if (r0 == null) goto L13;
        if (r0.isDoubleColumn() != true) goto L13;
        if ((r9 % 2) != 1) goto L17;
        return new Rect(d.a(Double.valueOf(4.5d)), 0, d.a(8), d.a(9));
    L17:
        return new Rect(d.a(8), 0, d.a(Double.valueOf(4.5d)), d.a(9));
    L13:
        return new Rect(d.a(8), 0, d.a(8), d.a(8));
    L15:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        com.bytedance.android.window.shop.product.presenter.group.b r0 = new com.bytedance.android.window.shop.product.presenter.group.b(r5, this.v);
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.title.a(r5));
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.a(r5));
        r0.d0(new ECWindowProductCardRecommendInfoElementPresenter(r5));
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.source.a(r5));
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.tags.c(r5));
        r0.d0(new ECWindowProductCardTagInfoElementPresenter(r5));
        r0.d0(new ECWindowProductCardMainImagePresenter(r5));
        r0.d0(new com.bytedance.android.window.shop.product.presenter.others.c(r5, this.v));
        r0.d0(new com.bytedance.android.window.shop.product.presenter.others.b(r5, this.v, 101));
        r0.d0(new UIPresenter(r5));
        if (w == false) goto L5;
        r0.d0(new ECWindowProductExtModuleElementPresenter(r5));
    L5:
        return r0;
    }

    public WindowProductHolder(Fragment r6, WindowLayoutType r7) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = th.a.e(r6.requireContext(), true);
        r0.getClass();
        ShoppingAsyncInflater r2 = ShoppingAsyncInflater.a.a(r1);
        if (r7 != null) goto L5;
    L10:
        int r3 = 2131561025;
    L11:
        ViewGroup.LayoutParams r4 = null;
        super(r6, com.bytedance.android.ec.opt.asyncInflate.c.a(r2, r3, null, 4), AnonymousClass1.INSTANCE);
        this.v = r7;
        WindowViewFactory.c.getClass();
        ViewGroup r8 = (ViewGroup) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371322);
        if (r8 == null) goto L29;
        View r5 = new ro.a(((RecyclerView.ViewHolder) this).itemView.getContext());
        if (r7 != null) goto L17;
    L19:
        String r9 = "product_bottom_recommend_double";
    L20:
        w4(r5, r9, "dynamic_view");
        w4(((RecyclerView.ViewHolder) this).itemView.findViewById(2131387403), "store_entry_group", "linear_group");
        w4(((RecyclerView.ViewHolder) this).itemView.findViewById(2131387406), "tags", "window_product_tags");
        r8.addView(r5, -1, -2);
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        r4 = r10;
    L24:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r4;
        if (r11 == null) goto L28;
        r11.topMargin = vf4.a.b(6);
        r5.setLayoutParams(r11);
        return;
    L28:
        return;
    L17:
        if (r7.isSingleColumn() != true) goto L19;
        r9 = "product_bottom_recommend_single";
        goto L20
    L29:
        return;
    L5:
        if (r7.isSingleColumn() != true) goto L10;
        if (w == false) goto L9;
        r3 = 2131561030;
        goto L11
    L9:
        r3 = 2131561031;
        goto L11
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
