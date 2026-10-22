package com.bytedance.android.shopping.store.hybridproduct.holder.creator;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopGuessLikeCardHolderNew;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import km.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Landroid/view/ViewGroup;", "p2", "Lkm/b;", "p3", "Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;", "p4", "Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;", "p5", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopGuessLikeCardHolderNew;", "invoke", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lkm/b;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopGuessLikeCardHolderNew;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECShopHybridHolderFactory$windowHolderCreators$5 extends FunctionReferenceImpl implements Function5<Fragment, ViewGroup, b, ECShopHybridProductViewModel, ECStoreViewModel, ECShopGuessLikeCardHolderNew> {
    public ECShopHybridHolderFactory$windowHolderCreators$5(ECShopGuessLikeCardHolderNew.a r8) {
        super(5, r8, ECShopGuessLikeCardHolderNew.a.class, "makeCurrentStoreProductHolder", "makeCurrentStoreProductHolder(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lcom/bytedance/android/ec/store/common/typeddata/TypedDataCache;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopGuessLikeCardHolderNew;", 0);
    }

    public final ECShopGuessLikeCardHolderNew invoke(Fragment r2, ViewGroup r3, b r4, ECShopHybridProductViewModel r5, ECStoreViewModel r6) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        Intrinsics.checkNotNullParameter(r3, "p2");
        Intrinsics.checkNotNullParameter(r4, "p3");
        Intrinsics.checkNotNullParameter(r5, "p4");
        Intrinsics.checkNotNullParameter(r6, "p5");
        ((ECShopGuessLikeCardHolderNew.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "tabViewModel");
        Intrinsics.checkNotNullParameter(r6, "storeViewModel");
        return ECShopGuessLikeCardHolderNew.a.a(r2, r3, r6, true, false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5) {
        return invoke((Fragment) r1, (ViewGroup) r2, (b) r3, (ECShopHybridProductViewModel) r4, (ECStoreViewModel) r5);
    }
}
