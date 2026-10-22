package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.ec.store.search.history.HistoryBanner;
import com.bytedance.android.ec.store.search.history.HistoryChip;
import com.bytedance.android.ec.store.search.history.HistoryView;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchViewModel;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements HistoryView.a {
    public final /* synthetic */ ShopSearchHistoryPresenter a;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Integer r2 = (Integer) r1;
        }
    }

    public final void a() {
        HistoryBanner r0 = this.a.g;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.a.E().getHistoryEditing().g(Boolean.FALSE);
    }

    public final void b() {
        this.a.E().doEventAction("search_history", new Pair[]{TuplesKt.to("action_type", "clear_all"), TuplesKt.to("enter_from", "search_store")});
    }

    public final void c() {
        HistoryBanner r0 = this.a.g;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.a.E().getHistoryEditing().g(Boolean.TRUE);
    }

    public g(ShopSearchHistoryPresenter r1) {
        this.a = r1;
    }

    public final void e(HistoryChip r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "chip");
        Intrinsics.checkNotNullParameter(r6, "orderOfChip");
        sj3.h r0 = r5.getHistory();
        if (r0 == null) goto L9;
        QLiveData<String> r2 = this.a.E().getSearchContent();
        String r1 = r0.d;
        if (r1 == null) goto L8;
        r2.g(r1);
        this.a.E().getSearchParam().setHistory(true);
        this.a.F(ShopSearchBasePresenter.SearchMode.HISTORY);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L9:
        ShopSearchViewModel r3 = this.a.E();
        Pair[] r4 = new Pair[4];
        sj3.h r7 = r5.getHistory();
        if (r7 == null) goto L12;
        String r8 = r7.d;
    L13:
        r4[0] = TuplesKt.to("search_keyword", r8);
        r4[1] = TuplesKt.to("action_type", PinchEnterMethod.CLICK);
        r4[2] = TuplesKt.to("order", r6);
        r4[3] = TuplesKt.to("enter_from", "search_store");
        r3.doEventAction("search_history", r4);
        return;
    L12:
        r8 = null;
        goto L13
    }

    public final void d(HistoryChip r5, int r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "chip");
        sj3.h r0 = r5.getHistory();
        if (r0 == null) goto L9;
        rj3.a r1 = rj3.a.c.a();
        Intrinsics.checkNotNullParameter(r0, "history");
        StoreSearchHistoryDatabase r2 = r1.a;
        if (r2 == null) goto L7;
        Observable r3 = Observable.create(new rj3.c(r2, r1, r0));
    L8:
        r3.subscribeOn(Schedulers.io()).subscribe(a.a);
        goto L9
    L7:
        r3 = Observable.just(-1);
    L9:
        if (r6 != 0) goto L16;
        HistoryBanner r9 = this.a.g;
        if (r9 == null) goto L13;
        r9.setVisibility(8);
    L13:
        HistoryView r10 = this.a.f;
        if (r10 == null) goto L16;
        r10.setVisibility(8);
    L16:
        if (r7 == true) goto L23;
        ShopSearchViewModel r11 = this.a.E();
        Pair[] r12 = new Pair[4];
        sj3.h r13 = r5.getHistory();
        if (r13 == null) goto L20;
        String r14 = r13.d;
    L21:
        r12[0] = TuplesKt.to("search_keyword", r14);
        r12[1] = TuplesKt.to("action_type", "clear");
        r12[2] = TuplesKt.to("order", r8);
        r12[3] = TuplesKt.to("enter_from", "search_store");
        r11.doEventAction("search_history", r12);
        return;
    L20:
        r14 = null;
        goto L21
    }
}
