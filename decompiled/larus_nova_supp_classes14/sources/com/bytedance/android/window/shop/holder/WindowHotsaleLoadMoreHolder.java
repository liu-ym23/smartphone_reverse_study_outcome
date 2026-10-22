package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBaseFragmentPresenter;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHotsaleLoadMoreHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lsq3/e;", "a", "b", "ShopWindowLoadMorePresenter", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHotsaleLoadMoreHolder extends ShopWindowGenericHolder<sq3.e> {
    public a v;

    public static final class ShopWindowLoadMorePresenter extends ECWindowHolderBaseFragmentPresenter {
        public final Lazy i;
        public b j;
        public final Lazy k;
        public sq3.e l;
        public boolean m;
        public final Lazy n;

        public ShopWindowLoadMorePresenter(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            super(r2);
            this.i = LazyKt.lazy(new WindowHotsaleLoadMoreHolder$ShopWindowLoadMorePresenter$initClickOnce$2(this));
            this.k = LazyKt.lazy(new WindowHotsaleLoadMoreHolder$ShopWindowLoadMorePresenter$noticeView$2(this));
            this.n = LazyKt.lazy(new WindowHotsaleLoadMoreHolder$ShopWindowLoadMorePresenter$itemDuration$2(this));
        }

        public final void b0(QModel r5) {
            Unit r0 = (Unit) this.i.getValue();
            if (r5 == null) goto L11;
            sq3.e r6 = (sq3.e) r5;
            this.l = r6;
            if (this.m == true) goto L8;
            this.m = true;
            int r1 = WindowTabEventReporter.a;
            ECWindowViewModel r2 = d0();
            ECWindowParam r3 = d0().getShopParam();
            int r4 = r6.l;
            Intrinsics.checkNotNullParameter(r2, "reporter");
            Intrinsics.checkNotNullParameter(r3, "shopParam");
            WindowTabEventReporter.f(r2, r3, Integer.valueOf(r4), "live_top_list_more_show");
        L8:
            i0(r6);
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.hotsale.WindowLiveHotLoadMoreProductVO");
        }

        public final void i0(sq3.e r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            ((TextView) this.k.getValue()).setText(String.valueOf(r2.k.size()));
        }
    }

    public interface a {
        void a(int r1, sq3.e r2, List<? extends sq3.b> r3);

        void b(int r1, List<? extends sq3.b> r2);
    }

    public interface b {
        void a(List<? extends sq3.b> r1);

        void b(sq3.e r1, List<? extends sq3.b> r2);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowHotsaleLoadMoreHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = r5.requireContext();
        r0.getClass();
        super(r5, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), 2131560875, null, 4));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        ShopWindowLoadMorePresenter r0 = new ShopWindowLoadMorePresenter(r2);
        r0.j = new c(this);
        return r0;
    }
}
