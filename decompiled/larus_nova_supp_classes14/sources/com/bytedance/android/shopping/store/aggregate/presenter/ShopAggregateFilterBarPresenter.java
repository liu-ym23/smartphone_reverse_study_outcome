package com.bytedance.android.shopping.store.aggregate.presenter;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.repository.vo.t;
import com.bytedance.android.ec.store.sortbar.ShopCustomAdapter;
import com.bytedance.android.ec.store.sortbar.ShopItemDecoration;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopAggregateFilterBarPresenter extends QFragmentPresenter {
    public final Lazy f;
    public final Lazy g;

    public final ShopAggregatePageProductViewModel d0() {
        return (ShopAggregatePageProductViewModel) this.g.getValue();
    }

    public ShopAggregateFilterBarPresenter(final ShopAggregateProductListFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ShopAggregateFilterBarPresenter$recyclerView$2(this));
        this.g = LazyKt.lazy(new ShopAggregateFilterBarPresenter$viewModel$2(this, r2));
    }

    public final void b0(QModel r7) {
        ShopAggregatePageProductViewModel r8 = d0();
        if (r8 == null) goto L14;
        ShopAggregateParam r9 = r8.getStoreParam();
        if (r9 == null) goto L14;
        String r10 = r9.getTagData();
        if (r10 == null) goto L14;
        Type r1 = new a().getType();     // Catch: Exception -> L28
        Object r11 = new Gson().fromJson(r10, r1);     // Catch: Exception -> L28
        t r2 = (t) CollectionsKt.getOrNull((List) r11, d0().getStoreParam().getSelectIndex());     // Catch: Exception -> L28
        if (r2 == null) goto L12;
        r2.a = true;     // Catch: Exception -> L28
        e0(r2, CommentConstants$CmtLongPanelStrategy.DEFAULT);     // Catch: Exception -> L28
    L12:
        final List r12 = (List) r11;     // Catch: Exception -> L28
    L15:
        List r3 = r12;
        if (r3 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
        return;
    L24:
        if (r12.size() <= 1) goto L32;
        a0().setPadding(com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(0));
        wg.a.d((RecyclerView) this.f.getValue(), com.bytedance.android.shopping.extensions.b.b(42));
        final RecyclerView r5 = (RecyclerView) this.f.getValue();
        r5.setVisibility(0);
        final Context r6 = Y().c();
        LinearLayoutManager r13 = new ShopAggregateFilterBarPresenter$initFilter$$inlined$apply$lambda$1(r6, r12);
        r13.setOrientation(0);
        Unit r14 = Unit.INSTANCE;
        r5.setLayoutManager(r13);
        r5.setHorizontalFadingEdgeEnabled(true);
        r5.setFadingEdgeLength(com.bytedance.android.shopping.extensions.b.b(20));
        r5.setAdapter(new ShopCustomAdapter(((QFragmentPresenter) this).e, r12, new ShopAggregateFilterBarPresenter$initFilter$$inlined$apply$lambda$2(r5, this, r12)));
        r5.addItemDecoration(new ShopItemDecoration());
        return;
    L32:
        return;
    L18:
        if (r3.isEmpty() == true) goto L21;
        r4 = false;
    L14:
        r12 = null;
        goto L15
    }

    public final void e0(t r7, String r8) {
        String r0 = new BtmItemBuilder("a1.b741019.c902181", null, 2, null).withPageFinder(PageFinder.via(a0())).obtainEventBtmParams();
        d0().doEventAction("store_discount_filter_button_click", new Pair[]{TuplesKt.to("activity_id", r7.b()), TuplesKt.to("name", r7.c()), TuplesKt.to("btm_id", r0), TuplesKt.to("click_type", r8)});
    }
}
