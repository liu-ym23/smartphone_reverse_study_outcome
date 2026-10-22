package com.bytedance.android.shopping.store.hybridproduct.holder.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.opt.asyncInflate.c;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopSortBarAndFilterHolder;
import com.bytedance.android.shopping.store.hybridproduct.module.o;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import km.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Landroid/view/ViewGroup;", "p2", "Lkm/b;", "p3", "Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;", "p4", "Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;", "p5", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSortBarAndFilterHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lkm/b;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSortBarAndFilterHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECShopHybridHolderFactory$windowHolderCreators$1 extends FunctionReferenceImpl implements Function5<Fragment, ViewGroup, b, ECShopHybridProductViewModel, ECStoreViewModel, ECShopSortBarAndFilterHolder> {
    public ECShopHybridHolderFactory$windowHolderCreators$1(ECShopSortBarAndFilterHolder.a r8) {
        super(5, r8, ECShopSortBarAndFilterHolder.a.class, "makeHolder", "makeHolder(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lcom/bytedance/android/ec/store/common/typeddata/TypedDataCache;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSortBarAndFilterHolder;", 0);
    }

    public final ECShopSortBarAndFilterHolder invoke(Fragment r5, ViewGroup r6, b r7, ECShopHybridProductViewModel r8, ECStoreViewModel r9) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        Intrinsics.checkNotNullParameter(r6, "p2");
        Intrinsics.checkNotNullParameter(r7, "p3");
        Intrinsics.checkNotNullParameter(r8, "p4");
        Intrinsics.checkNotNullParameter(r9, "p5");
        ((ECShopSortBarAndFilterHolder.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "tabViewModel");
        Intrinsics.checkNotNullParameter(r9, "storeViewModel");
        Context r10 = r5.requireContext();
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r8, "viewModel");
        Intrinsics.checkNotNullParameter(r9, "storeViewModel");
        QUIManager r11 = new QUIManager();
        ShoppingAsyncInflater.e.getClass();
        View r0 = c.a(ShoppingAsyncInflater.a.a(r10), 2131560899, null, 4);
        if (r0 == null) goto L7;
        pn.b.a(r11, new o((ViewGroup) r0, r9), r10, r5);
        return new ECShopSortBarAndFilterHolder(r11, r11.p(), r8, r9);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5) {
        return invoke((Fragment) r1, (ViewGroup) r2, (b) r3, (ECShopHybridProductViewModel) r4, (ECStoreViewModel) r5);
    }
}
