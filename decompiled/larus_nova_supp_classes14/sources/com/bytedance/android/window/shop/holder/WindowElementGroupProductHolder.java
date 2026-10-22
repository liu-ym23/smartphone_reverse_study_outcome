package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.window.base.dynamicview.common.WindowDynamicViewCache;
import com.bytedance.android.ec.window.base.dynamicview.common.j;
import com.bytedance.android.ec.window.base.dynamicview.renderer.impl.DynamicViewCache;
import com.bytedance.android.ec.window.base.product.presenter.element.mainimage.ECWindowProductCardMainImagePresenter;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.presenter.others.ECWindowProductCardTagInfoElementPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.i;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowElementGroupProductHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/i;", "UIPresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowElementGroupProductHolder extends ShopWindowGenericHolder<i> {
    public final WindowLayoutType v;

    public static final class UIPresenter extends QPresenter {
        public final j e;
        public final Lazy f;
        public to.d g;
        public tq3.c h;
        public final Lazy i;
        public final Lazy j;

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
            this.f = LazyKt.lazy(new WindowElementGroupProductHolder$UIPresenter$eventHandler$2(this));
            this.i = LazyKt.lazy(new WindowElementGroupProductHolder$UIPresenter$viewProvider$2(this));
            this.j = LazyKt.lazy(new WindowElementGroupProductHolder$UIPresenter$vm$2(this));
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
            ((ECWindowViewModel) this.j.getValue()).setRenderDataVo(r0);
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
        fo.a<WindowLayoutType> r1 = WindowConstDef.a;
        if (((Boolean) WindowConstDef.m.getValue()).booleanValue() == true) goto L5;
        r0.d0(new ECWindowProductCardMainImagePresenter(r5));
    L5:
        r0.d0(new com.bytedance.android.window.shop.product.presenter.others.b(r5, this.v, 101));
        QGroupPresenter r2 = new QGroupPresenter();
        r2.a(r0);
        r2.a(new UIPresenter(r5));
        return r2;
    }

    public WindowElementGroupProductHolder(Fragment r5, WindowLayoutType r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        if (r6 != null) goto L5;
    L9:
        WindowDynamicViewCache r2 = WindowDynamicViewCache.g;
        Context r3 = r5.requireContext();
        r2.getClass();
        View r4 = WindowDynamicViewCache.a(r3, "window_card_101_double");
        if (r4 != null) goto L12;
        ShoppingAsyncInflater.a r7 = ShoppingAsyncInflater.e;
        Context r8 = r5.requireContext();
        r7.getClass();
        r4 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r8), 2131561025, null, 4);
    L12:
        super(r5, r4, AnonymousClass1.INSTANCE);
        this.v = r6;
        return;
    L5:
        if (r6.isSingleColumn() != true) goto L9;
        WindowDynamicViewCache r9 = WindowDynamicViewCache.g;
        Context r10 = r5.requireContext();
        r9.getClass();
        r4 = WindowDynamicViewCache.a(r10, "window_card_101_single");
        if (r4 != null) goto L12;
        ShoppingAsyncInflater.a r11 = ShoppingAsyncInflater.e;
        Context r12 = r5.requireContext();
        r11.getClass();
        r4 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r12), 2131561030, null, 4);
        goto L12
    }
}
