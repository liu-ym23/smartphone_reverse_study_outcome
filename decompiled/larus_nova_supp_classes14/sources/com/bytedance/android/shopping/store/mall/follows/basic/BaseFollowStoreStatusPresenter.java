package com.bytedance.android.shopping.store.mall.follows.basic;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class BaseFollowStoreStatusPresenter<T extends BaseFollowStoreViewModel> extends QFragmentPresenter {
    public LazyStatusView f;
    public final Lazy g;
    public final Class<T> h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ BaseFollowStoreStatusPresenter a;

        public a(BaseFollowStoreStatusPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            LoadStatus r3 = (LoadStatus) r2;
            if (r3 != LoadStatus.InitializeEmpty) goto L5;
        L24:
            BaseFollowStoreStatusPresenter.d0(this.a).b(com.bytedance.android.ec.store.status.b.b.a);
            ExtensionsKt.visible(BaseFollowStoreStatusPresenter.d0(this.a));
            return;
        L5:
            if (r3 == LoadStatus.InitializeError) goto L24;
            if (r3 != LoadStatus.InitializeSuccess) goto L10;
        L23:
            ExtensionsKt.gone(BaseFollowStoreStatusPresenter.d0(this.a));
            return;
        L10:
            if (r3 == LoadStatus.LoadMoreSuccess) goto L23;
            if (r3 == LoadStatus.LoadMoreEnd) goto L23;
            if (r3 != LoadStatus.Initialize) goto L17;
        L22:
            ExtensionsKt.visible(BaseFollowStoreStatusPresenter.d0(this.a));
            BaseFollowStoreStatusPresenter.d0(this.a).b(com.bytedance.android.ec.store.status.b.c.a);
            return;
        L17:
            if (r3 == LoadStatus.RefreshWhenError) goto L22;
            if (r3 != LoadStatus.RefreshError) goto L26;
            UIUtils.displayToast(this.a.Y().c(), 2131913855);
            return;
        }
    }

    public static final /* synthetic */ LazyStatusView d0(BaseFollowStoreStatusPresenter r1) {
        LazyStatusView r2 = r1.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L5:
        return r2;
    }

    public final void b0(QModel r7) {
        LazyStatusView r8 = Z().b(2131370740).f();
        this.f = r8;
        r8.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.c.a, new com.bytedance.android.ec.store.status.c(new BaseFollowStoreStatusPresenter$initStatusView$1(this), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new BaseFollowStoreStatusPresenter$initStatusView$2(this), null, 6))}));
        ((BaseFollowStoreViewModel) this.g.getValue()).getLoadStatus().b(Y().e(), new a(this));
    }

    public BaseFollowStoreStatusPresenter(Fragment r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "f");
        Intrinsics.checkNotNullParameter(r3, "vmClazz");
        super(r2);
        this.h = r3;
        this.g = LazyKt.lazy(new BaseFollowStoreStatusPresenter$viewModel$2(this));
    }
}
