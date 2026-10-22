package com.bytedance.android.shopping.store.search.presenter;

import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.search.history.HistoryBanner;
import com.bytedance.android.ec.store.search.history.HistoryChip;
import com.bytedance.android.ec.store.search.history.HistoryView;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/search/presenter/ShopSearchHistoryPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "", "onResume", "onPause", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchHistoryPresenter extends ShopSearchBasePresenter {
    public HistoryView f;
    public HistoryBanner g;
    public final a h;

    public static final class a implements HistoryView.c {
        public a() {
        }

        public final HistoryChip.WrapCard a(HistoryChip r8) {
            Intrinsics.checkNotNullParameter(r8, "chip");
            if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 0) goto L16;
            HistoryChip.Style r0 = r8.getStyle();
            HistoryChip.Style r1 = HistoryChip.Style.TEXT;
            if (r0 != r1) goto L9;
            int r2 = ((k1.l() - (ExtensionsKt.a(16) * 2)) - ExtensionsKt.a(16)) / 2;
            TextView r3 = r8.getContentTv();
            if (r3 == null) goto L9;
            r3.setPadding(ExtensionsKt.a(10), ExtensionsKt.a(6), ExtensionsKt.a(10), ExtensionsKt.a(6));
            r3.setTextColor((int) 3205896227L);
            r3.setMaxWidth(r2);
        L9:
            HistoryChip.WrapCard r4 = new HistoryChip.WrapCard(r8.getContext(), r8, false);
            if (r8.getStyle() != r1) goto L12;
            FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        L13:
            r5.gravity = 17;
            r4.addView(r8, r5);
            r4.setElevation(0.0f);
            r4.setCardBackgroundColor(219551779);
            r4.getViewTreeObserver().addOnGlobalLayoutListener(new b(r4));
            return r4;
        L12:
            r5 = new FrameLayout.LayoutParams(ExtensionsKt.a(22), ExtensionsKt.a(22));
            goto L13
        L16:
            return HistoryChip.c(r8);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        HistoryBanner r0 = this.g;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        HistoryView r0 = this.f;
        if (r0 == null) goto L5;
        r0.removeAllViews();
        r0.b = null;
        r0.d = 3;
        r0.c = false;
    L5:
        HistoryBanner r1 = this.g;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    }

    public ShopSearchHistoryPresenter() {
        this.h = new a();
    }

    public final void A(QModel r5) {
        HistoryView r6 = w().b(2131367523).f();
        this.f = r6;
        r6.setHistoryChipInitializer(this.h);
        this.g = w().b(2131367522).f();
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 0) goto L7;
        HistoryBanner r7 = this.g;
        if (r7 == null) goto L10;
        r7.setDeleteIcon(2131248094);
    L10:
        HistoryBanner r8 = this.g;
        if (r8 == null) goto L13;
        r8.setActionPerformListener(new c(this));
    L13:
        HistoryView r9 = this.f;
        if (r9 == null) goto L16;
        r9.setActionListener(new g(this));
    L16:
        E().doEventAction("search_history", new Pair[]{TuplesKt.to("action_type", "show"), TuplesKt.to("enter_from", "search_store")});
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        E().getPostKeyword().a(ECQuickUtilKt.a(u()), new d(this), false);
        E().getStoreSearchHistories().b(ECQuickUtilKt.a(u()), new e(this));
        E().getHistoryEditing().b(ECQuickUtilKt.a(u()), new f(this));
        return;
    L7:
        HistoryBanner r10 = this.g;
        if (r10 == null) goto L10;
        r10.setDeleteIcon(2131248093);
        goto L10
    }
}
