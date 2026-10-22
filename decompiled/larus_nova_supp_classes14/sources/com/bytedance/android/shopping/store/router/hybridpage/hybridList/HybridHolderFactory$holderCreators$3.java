package com.bytedance.android.shopping.store.router.hybridpage.hybridList;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageSliceGeneralCardHolder;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Landroid/view/ViewGroup;", "p2", "Lkm/b;", "p3", "Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageViewModel;", "p4", "Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceGeneralCardHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lkm/b;Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageViewModel;)Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceGeneralCardHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class HybridHolderFactory$holderCreators$3 extends FunctionReferenceImpl implements Function4<Fragment, ViewGroup, km.b, HybridPageViewModel, HybridPageSliceGeneralCardHolder> {
    public HybridHolderFactory$holderCreators$3(HybridPageSliceGeneralCardHolder.a r8) {
        super(4, r8, HybridPageSliceGeneralCardHolder.a.class, "makeHolder", "makeHolder(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lcom/bytedance/android/ec/store/common/typeddata/TypedDataCache;Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageViewModel;)Lcom/bytedance/android/shopping/store/router/hybridpage/holder/HybridPageSliceGeneralCardHolder;", 0);
    }

    public final HybridPageSliceGeneralCardHolder invoke(Fragment r6, ViewGroup r7, km.b r8, HybridPageViewModel r9) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        Intrinsics.checkNotNullParameter(r7, "p2");
        Intrinsics.checkNotNullParameter(r8, "p3");
        Intrinsics.checkNotNullParameter(r9, "p4");
        ((HybridPageSliceGeneralCardHolder.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        LayoutTypes r4 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "layoutType");
        QUIManager r10 = new QUIManager();
        FrameLayout r0 = new FrameLayout(r7.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        com.bytedance.android.shopping.store.router.hybridpage.holder.c r1 = new com.bytedance.android.shopping.store.router.hybridpage.holder.c();
        pn.b.a(r10, new zj3.a(r0, r9, r1, r4), r7.getContext(), r6);     // Catch: Exception -> L5
    L8:
        return new HybridPageSliceGeneralCardHolder(r10, r0, r1, r9);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return invoke((Fragment) r1, (ViewGroup) r2, (km.b) r3, (HybridPageViewModel) r4);
    }
}
