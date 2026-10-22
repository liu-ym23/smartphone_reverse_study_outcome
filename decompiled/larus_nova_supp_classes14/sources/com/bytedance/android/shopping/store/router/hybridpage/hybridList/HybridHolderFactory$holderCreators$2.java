package com.bytedance.android.shopping.store.router.hybridpage.hybridList;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageSliceProductCardHolder;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Landroid/view/ViewGroup;", "p2", "Lkm/b;", "p3", "Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageViewModel;", "p4", "Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceProductCardHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lkm/b;Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageViewModel;)Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceProductCardHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class HybridHolderFactory$holderCreators$2 extends FunctionReferenceImpl implements Function4<Fragment, ViewGroup, km.b, HybridPageViewModel, HybridPageSliceProductCardHolder> {
    public HybridHolderFactory$holderCreators$2(HybridPageSliceProductCardHolder.a r8) {
        super(4, r8, HybridPageSliceProductCardHolder.a.class, "makeSingleHolder", "makeSingleHolder(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lcom/bytedance/android/ec/store/common/typeddata/TypedDataCache;Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageViewModel;)Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceProductCardHolder;", 0);
    }

    public final HybridPageSliceProductCardHolder invoke(Fragment r2, ViewGroup r3, km.b r4, HybridPageViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        Intrinsics.checkNotNullParameter(r3, "p2");
        Intrinsics.checkNotNullParameter(r4, "p3");
        Intrinsics.checkNotNullParameter(r5, "p4");
        ((HybridPageSliceProductCardHolder.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        return HybridPageSliceProductCardHolder.a.a(r2, r3, r5, LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return invoke((Fragment) r1, (ViewGroup) r2, (km.b) r3, (HybridPageViewModel) r4);
    }
}
