package com.bytedance.android.shopping.store.hybridproduct.holder.creator;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.view.ECShopMiddleCouponFilterView;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopMiddleCouponFilterHolder;
import com.bytedance.android.shopping.store.hybridproduct.module.h;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import km.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Landroid/view/ViewGroup;", "p2", "Lkm/b;", "p3", "Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;", "p4", "Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;", "p5", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopMiddleCouponFilterHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lkm/b;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopMiddleCouponFilterHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECShopHybridHolderFactory$windowHolderCreators$21 extends FunctionReferenceImpl implements Function5<Fragment, ViewGroup, b, ECShopHybridProductViewModel, ECStoreViewModel, ECShopMiddleCouponFilterHolder> {
    public ECShopHybridHolderFactory$windowHolderCreators$21(ECShopMiddleCouponFilterHolder.a r8) {
        super(5, r8, ECShopMiddleCouponFilterHolder.a.class, "makeHolder", "makeHolder(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lcom/bytedance/android/ec/store/common/typeddata/TypedDataCache;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopMiddleCouponFilterHolder;", 0);
    }

    public final ECShopMiddleCouponFilterHolder invoke(Fragment r3, ViewGroup r4, b r5, ECShopHybridProductViewModel r6, ECStoreViewModel r7) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        Intrinsics.checkNotNullParameter(r4, "p2");
        Intrinsics.checkNotNullParameter(r5, "p3");
        Intrinsics.checkNotNullParameter(r6, "p4");
        Intrinsics.checkNotNullParameter(r7, "p5");
        ((ECShopMiddleCouponFilterHolder.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "tabViewModel");
        Intrinsics.checkNotNullParameter(r7, "storeViewModel");
        Context r8 = r3.requireContext();
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Intrinsics.checkNotNullParameter(r7, "storeViewModel");
        QUIManager r9 = new QUIManager();
        pn.b.a(r9, new h(new ECShopMiddleCouponFilterView(r8), r6, r7), r8, r3);
        return new ECShopMiddleCouponFilterHolder(r9, r9.p(), r6, r7);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5) {
        return invoke((Fragment) r1, (ViewGroup) r2, (b) r3, (ECShopHybridProductViewModel) r4, (ECStoreViewModel) r5);
    }
}
