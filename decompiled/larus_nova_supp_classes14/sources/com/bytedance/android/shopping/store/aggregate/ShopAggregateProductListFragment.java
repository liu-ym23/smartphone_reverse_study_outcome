package com.bytedance.android.shopping.store.aggregate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateProductListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregateProductListFragment extends Fragment implements QViewModelOwner {
    public static final /* synthetic */ int g = 0;
    public final QUIManager d;
    public final Lazy e;
    public final com.bytedance.android.ec.core.arch.viewmodel.c f;

    public static final class a {
    }

    static {
    }

    public final ViewModelProvider.Factory o6() {
        return (ViewModelProvider.Factory) this.e.getValue();
    }

    public ShopAggregateProductListFragment() {
        this.d = new QUIManager();
        this.e = LazyKt.lazy(ShopAggregateProductListFragment$factory$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new ShopAggregateProductListFragment$productViewModel$2(this);
        final Function0<Fragment> r1 = new ShopAggregateProductListFragment$$special$$inlined$viewModels$1(this);
        this.f = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(ShopAggregatePageProductViewModel.class), new ShopAggregateProductListFragment$$special$$inlined$viewModels$2(r1), r0);
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("store_param");
    L7:
        if ((r5 instanceof ShopAggregateParam) == true) goto L9;
        r5 = null;
    L9:
        ShopAggregateParam r6 = (ShopAggregateParam) r5;
        if (r6 != null) goto L12;
        return;
    L12:
        ((ShopAggregatePageProductViewModel) this.f.getValue()).init(r6, null);
        return;
    L5:
        r5 = null;
        goto L7
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.d.c(ri3.c.class, null);
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        QUIManager r7 = this.d;
        View r8 = th.a.c(requireContext(), 2131561068, null, false);
        if (r8 == null) goto L7;
        r7.k(new ri3.c((ViewGroup) r8, ((ShopAggregatePageProductViewModel) this.f.getValue()).getStoreParam().getPageType()), requireContext(), this);
        return this.d.p();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
