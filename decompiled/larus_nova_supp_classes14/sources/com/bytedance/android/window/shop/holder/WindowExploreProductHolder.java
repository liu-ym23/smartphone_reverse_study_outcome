package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.graphics.Rect;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.window.base.product.presenter.element.mainimage.ECWindowProductCardMainImagePresenter;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.window.shop.product.presenter.discover.ECWindowGuessYouLickPCGPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.m;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowExploreProductHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/m;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowExploreProductHolder extends ShopWindowGenericHolder<m> {
    public static final a v = null;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.holder.WindowExploreProductHolder$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/m;", "p1", "Lrq3/a;", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/m;)Lrq3/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<m, rq3.a> {
        public AnonymousClass1(a r8) {
            super(1, r8, a.class, "transformer", "transformer(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowExploreFeedProductItemVO;)Lcom/bytedance/android/window/shop/repository/tab/entity/explore/WindowExploreFeedProductVO;", 0);
        }

        public final rq3.a invoke(m r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            ((a) ((CallableReference) this).receiver).getClass();
            return r2.j;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((m) r1);
        }
    }

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return false;
    }

    static {
        v = new a();
    }

    public WindowExploreProductHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = r5.requireContext();
        r0.getClass();
        super(r5, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), 2131561025, null, 4), new AnonymousClass1(v));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r8) {
        StaggeredGridLayoutManager.LayoutParams r9 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r9 == null) goto L10;
        int r10 = r9.getSpanIndex();
        int r1 = d.a(12);
        int r4 = d.a(Double.valueOf(4.5d));
        int r5 = d.a(9);
        if ((r10 % 2) != 1) goto L8;
        r4 = d.a(12);
        r1 = d.a(Double.valueOf(4.5d));
    L8:
        return new Rect(r1, 0, r4, r5);
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        int r1 = com.bytedance.android.window.shop.product.utils.a.a;
        WindowLayoutType r2 = WindowLayoutType.DOUBLECOLUMN;
        Intrinsics.checkNotNullParameter(r3, "fragment");
        ECWindowGuessYouLickPCGPresenter r0 = new ECWindowGuessYouLickPCGPresenter(r3, r2);
        r0.d0(new ECWindowProductCardMainImagePresenter(r3));
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.title.a(r3));
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.a(r3));
        r0.d0(new ECWindowProductCardRecommendInfoElementPresenter(r3));
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.source.a(r3));
        r0.d0(new com.bytedance.android.ec.window.base.product.presenter.element.tags.c(r3));
        return r0;
    }
}
