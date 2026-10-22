package com.bytedance.android.shopping.store.aggregate.presenter;

import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends QFragmentPresenter {
    public ShopAggregatePageProductViewModel f;

    public static final class a<T> implements Observer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            LoadStatus r3 = (LoadStatus) r2;
            if (r3 == null) goto L19;
            this.a.d0(r3);
            if (r3 != LoadStatus.LoadMoreEnd) goto L17;
            ShopAggregatePageProductViewModel r4 = this.a.f;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L11:
            if (r4.getObserveFlag() == true) goto L18;
            ShopAggregatePageProductViewModel r5 = this.a.f;
            if (r5 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L15:
            r5.setObserveFlag(true);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public d(ShopAggregateProductListFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void b0(QModel r3) {
        QContext r4 = Y();
        Fragment r1 = ((QFragmentPresenter) this).e;
        r4.getClass();
        this.f = QContext.h(ShopAggregatePageProductViewModel.class, r1);
        TextView r5 = (TextView) Z().b(2131391171).f();
        ShopAggregatePageProductViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r5.setText(r0.getPublicityText());
        ShopAggregatePageProductViewModel r6 = this.f;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        d0((LoadStatus) r6.getLoadStatus().a());
        ShopAggregatePageProductViewModel r7 = this.f;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r7.getLoadStatus().b(ECQuickUtilKt.a(Y()), new a(this));
    }

    public final void d0(LoadStatus r9) {
        if (r9 == null) goto L11;
        int r10 = com.bytedance.android.shopping.store.product.d.a[r9.ordinal()];
        if (r10 != 1) goto L8;
        Z().b(2131387793).f().setVisibility(8);
        ((TextView) Z().b(2131389441).f()).setVisibility(8);
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(0);
        ((TextView) Z().b(2131383172).f()).setText(2131913868);
        ((TextView) Z().b(2131391171).f()).setVisibility(8);
        return;
    L8:
        if (r10 != 2) goto L10;
        LoadMoreStatusView r11 = Z().b(2131387793).f();
        r11.setVisibility(0);
        r11.a();
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
    L12:
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
        return;
    L10:
        if (r10 != 3) goto L11;
        Z().b(2131387793).f().b();
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
        ECToast.showToast$default(ECToast.INSTANCE, Y().c(), 2131913855, null, 4, null);
        return;
    L11:
        Z().b(2131387793).f().b();
        goto L12
    }
}
