package com.bytedance.android.shopping.store.mall.follows.basic;

import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class BaseFollowStoreLoadMorePresenter<T extends BaseFollowStoreViewModel> extends QFragmentPresenter implements IHybridListViewHolder {
    public final Lazy f;
    public final Class<T> g;

    public static final class a<T> implements Observer {
        public final /* synthetic */ BaseFollowStoreLoadMorePresenter a;

        public a(BaseFollowStoreLoadMorePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            LoadStatus r3 = (LoadStatus) r2;
            if (r3 == null) goto L7;
            this.a.d0(r3);
            return;
        }
    }

    public final boolean C3() {
        return false;
    }

    public final void D() {
    }

    public final void D1(Long r1) {
    }

    public final void K() {
    }

    public final void g1(int r1, int r2, double r3) {
    }

    public final void m1(int r1, double r2) {
    }

    public final void o() {
    }

    public final void onHide() {
    }

    public final void onRelease() {
    }

    public final void onShow() {
    }

    public final void b0(QModel r3) {
        d0((LoadStatus) ((BaseFollowStoreViewModel) this.f.getValue()).getLoadStatus().a());
        ((BaseFollowStoreViewModel) this.f.getValue()).getLoadStatus().b(ECQuickUtilKt.a(Y()), new a(this));
    }

    public final void d0(LoadStatus r5) {
        if (r5 == null) goto L11;
        int r6 = f.a[r5.ordinal()];
        if (r6 != 1) goto L8;
        Z().b(2131387793).f().setVisibility(8);
        ((LinearLayout) Z().b(2131384703).f()).setVisibility(0);
        return;
    L8:
        if (r6 != 2) goto L10;
        Z().b(2131387793).f().a();
        ((LinearLayout) Z().b(2131384703).f()).setVisibility(8);
        ((LinearLayout) Z().b(2131384703).f()).setVisibility(8);
        return;
    L10:
        if (r6 != 3) goto L11;
        Z().b(2131387793).f().b();
        ((LinearLayout) Z().b(2131384703).f()).setVisibility(8);
        UIUtils.displayToast(Y().c(), 2131913855);
        return;
    L11:
        Z().b(2131387793).f().b();
        ((LinearLayout) Z().b(2131384703).f()).setVisibility(8);
    }

    public BaseFollowStoreLoadMorePresenter(final Fragment r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "vmClazz");
        super(r2);
        this.g = r3;
        this.f = LazyKt.lazy(new BaseFollowStoreLoadMorePresenter$viewModel$2(this, r2));
    }
}
