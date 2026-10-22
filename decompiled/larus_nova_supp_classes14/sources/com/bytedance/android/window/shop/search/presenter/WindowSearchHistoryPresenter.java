package com.bytedance.android.window.shop.search.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryView;
import com.bytedance.android.ec.window.base.search.history.WindowHistoryBanner;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchHistoryPresenter;", "Lcom/bytedance/android/window/shop/search/presenter/WindowSearchBasePresenter;", "", "onResume", "onPause", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchHistoryPresenter extends WindowSearchBasePresenter {
    public WindowSearchViewModel f;
    public ECWindowHistoryView g;
    public WindowHistoryBanner h;

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        WindowHistoryBanner r0 = this.h;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        ECWindowHistoryView r0 = this.g;
        if (r0 == null) goto L5;
        r0.removeAllViews();
        r0.b = null;
        r0.d = 3;
        r0.c = false;
    L5:
        WindowHistoryBanner r1 = this.h;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    }

    public WindowSearchHistoryPresenter() {
    }

    public static final /* synthetic */ WindowSearchViewModel E(WindowSearchHistoryPresenter r1) {
        WindowSearchViewModel r2 = r1.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    @Override // com.bytedance.android.window.shop.search.presenter.WindowSearchBasePresenter
    public final void A(QModel r6) {
        super.A(r6);
        this.f = ECQuickUtilKt.c(u(), WindowSearchViewModel.class);
        this.g = w().b(2131367523).f();
        WindowHistoryBanner r7 = w().b(2131367522).f();
        this.h = r7;
        r7.setActionPerformListener(new c(this));
        ECWindowHistoryView r8 = this.g;
        if (r8 == null) goto L5;
        r8.setActionListener(new g(this));
    L5:
        WindowSearchViewModel r9 = this.f;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r9.doEventAction("search_history", new Pair[]{TuplesKt.to("action_type", "show"), TuplesKt.to("enter_from", "search_window")});
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        WindowSearchViewModel r10 = this.f;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r10.getPostKeyword().a(ECQuickUtilKt.a(u()), new d(this), false);
        WindowSearchViewModel r11 = this.f;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r11.getStoreSearchHistories().b(ECQuickUtilKt.a(u()), new e(this));
        WindowSearchViewModel r12 = this.f;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r12.getHistoryEditing().b(ECQuickUtilKt.a(u()), new f(this));
    }
}
