package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHotsaleLatestLiveInfoHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lsq3/d;", "ShopWindowHotsaleLatestLiveInfoPresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHotsaleLatestLiveInfoHolder extends ShopWindowGenericHolder<sq3.d> {

    public static final class ShopWindowHotsaleLatestLiveInfoPresenter extends QFragmentPresenter {
        public final Lazy f;
        public final Lazy g;
        public final Lazy h;
        public final Lazy i;
        public final Lazy j;
        public boolean k;

        public ShopWindowHotsaleLatestLiveInfoPresenter(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            super(r2);
            this.f = LazyKt.lazy(new WindowHotsaleLatestLiveInfoHolder$ShopWindowHotsaleLatestLiveInfoPresenter$titleView$2(this));
            this.g = LazyKt.lazy(new WindowHotsaleLatestLiveInfoHolder$ShopWindowHotsaleLatestLiveInfoPresenter$msgView$2(this));
            this.h = LazyKt.lazy(new WindowHotsaleLatestLiveInfoHolder$ShopWindowHotsaleLatestLiveInfoPresenter$watchingCountView$2(this));
            this.i = LazyKt.lazy(new WindowHotsaleLatestLiveInfoHolder$ShopWindowHotsaleLatestLiveInfoPresenter$separatorView$2(this));
            this.j = LazyKt.lazy(new WindowHotsaleLatestLiveInfoHolder$ShopWindowHotsaleLatestLiveInfoPresenter$viewModel$2(this));
        }

        public final void b0(QModel r6) {
            if (r6 == null) goto L13;
            sq3.d r7 = (sq3.d) r6;
            if (this.k == true) goto L7;
            this.k = true;
            int r0 = WindowTabEventReporter.a;
            ECWindowViewModel r1 = (ECWindowViewModel) this.j.getValue();
            ECWindowParam r2 = ((ECWindowViewModel) this.j.getValue()).getShopParam();
            int r3 = r7.m;
            Intrinsics.checkNotNullParameter(r1, "reporter");
            Intrinsics.checkNotNullParameter(r2, "shopParam");
            WindowTabEventReporter.f(r1, r2, Integer.valueOf(r3), "live_top_list_show");
        L7:
            ((TextView) this.f.getValue()).setText(r7.j);
            ((TextView) this.g.getValue()).setText(r7.k);
            if ((!StringsKt.isBlank(r7.l)) == false) goto L10;
            ((TextView) this.h.getValue()).setText(r7.l);
            ((View) this.i.getValue()).setVisibility(0);
            return;
        L10:
            ((TextView) this.h.getValue()).setText("");
            ((View) this.i.getValue()).setVisibility(8);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.hotsale.WindowLiveHotLatestLiveInfoVO");
        }
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowHotsaleLatestLiveInfoHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = r5.requireContext();
        r0.getClass();
        super(r5, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), 2131560874, null, 4));
        if (Build.VERSION.SDK_INT <= 23) goto L5;
        Drawable r6 = th.a.f(((RecyclerView.ViewHolder) this).itemView.getContext()).getDrawable(2131234734);
    L6:
        ((RecyclerView.ViewHolder) this).itemView.setBackground(r6);
        return;
    L5:
        GradientDrawable r7 = new GradientDrawable();
        float r2 = q.a(4);
        r7.setCornerRadii(new float[]{r2, r2, r2, r2, 0.0f, 0.0f, 0.0f, 0.0f});
        r6 = r7;
        goto L6
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r5) {
        if (r5 != 0) goto L5;
        int r6 = d.a(8);
    L7:
        return new Rect(d.a(12), r6, d.a(12), d.a(8));
    L5:
        r6 = 0;
        goto L7
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new ShopWindowHotsaleLatestLiveInfoPresenter(r2);
    }
}
