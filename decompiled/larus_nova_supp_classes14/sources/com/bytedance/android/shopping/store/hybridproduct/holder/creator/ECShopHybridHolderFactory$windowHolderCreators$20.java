package com.bytedance.android.shopping.store.hybridproduct.holder.creator;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopSlcCommonCardHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.e;
import com.bytedance.android.shopping.store.hybridproduct.module.n;
import com.bytedance.android.shopping.store.hybridproduct.n0;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import km.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Landroid/view/ViewGroup;", "p2", "Lkm/b;", "p3", "Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;", "p4", "Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;", "p5", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSlcCommonCardHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lkm/b;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSlcCommonCardHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECShopHybridHolderFactory$windowHolderCreators$20 extends FunctionReferenceImpl implements Function5<Fragment, ViewGroup, b, ECShopHybridProductViewModel, ECStoreViewModel, ECShopSlcCommonCardHolder> {
    public ECShopHybridHolderFactory$windowHolderCreators$20(ECShopSlcCommonCardHolder.a r8) {
        super(5, r8, ECShopSlcCommonCardHolder.a.class, "makeSingleHolder", "makeSingleHolder(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lcom/bytedance/android/ec/store/common/typeddata/TypedDataCache;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSlcCommonCardHolder;", 0);
    }

    public final ECShopSlcCommonCardHolder invoke(Fragment r8, ViewGroup r9, b r10, ECShopHybridProductViewModel r11, ECStoreViewModel r12) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        Intrinsics.checkNotNullParameter(r9, "p2");
        Intrinsics.checkNotNullParameter(r10, "p3");
        Intrinsics.checkNotNullParameter(r11, "p4");
        Intrinsics.checkNotNullParameter(r12, "p5");
        ((ECShopSlcCommonCardHolder.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r8, "fragment");
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "tabViewModel");
        Intrinsics.checkNotNullParameter(r12, "storeViewModel");
        LayoutTypes r4 = LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        dm.a.a("测试轻览").a("ECShopSlcCommonCardHolder.create:$");
        QUIManager r1 = new QUIManager();
        FrameLayout r2 = new FrameLayout(r9.getContext());
        r2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        e r5 = new e();
        n0 r6 = new n0();
        pn.b.a(r1, new n(r2, r12, r5, r6), r9.getContext(), r8);
        return new ECShopSlcCommonCardHolder(r1, r2, r12, r4, r5, r6);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5) {
        return invoke((Fragment) r1, (ViewGroup) r2, (b) r3, (ECShopHybridProductViewModel) r4, (ECStoreViewModel) r5);
    }
}
