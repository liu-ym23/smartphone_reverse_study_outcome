package com.bytedance.android.window.shop.search.presenter;

import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchGroupPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchGroupPresenter extends QPresenter implements LifecycleObserver {
    public WindowSearchViewModel e;

    public WindowSearchGroupPresenter() {
    }

    public final void A(QModel r5) {
        this.e = ECQuickUtilKt.c(u(), WindowSearchViewModel.class);
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        LinearLayout r6 = (LinearLayout) w().b(2131385538).f();
        RecyclerView r0 = w().b(2131385603).f();
        WindowSearchViewModel r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r1.getSearchContent().b(ECQuickUtilKt.a(u()), new b(this, r6, r0));
    }
}
