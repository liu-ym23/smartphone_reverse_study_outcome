package com.bytedance.android.shopping.store.hybridproduct.holder.creator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopEmptyHolder;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import km.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Landroid/view/ViewGroup;", "p2", "Lkm/b;", "p3", "Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;", "p4", "Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;", "p5", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopEmptyHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lkm/b;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopEmptyHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECShopHybridHolderFactory$windowHolderCreators$11 extends FunctionReferenceImpl implements Function5<Fragment, ViewGroup, b, ECShopHybridProductViewModel, ECStoreViewModel, ECShopEmptyHolder> {
    public ECShopHybridHolderFactory$windowHolderCreators$11(ECShopEmptyHolder.a r8) {
        super(5, r8, ECShopEmptyHolder.a.class, "makeHolder", "makeHolder(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lcom/bytedance/android/ec/store/common/typeddata/TypedDataCache;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopEmptyHolder;", 0);
    }

    public final ECShopEmptyHolder invoke(Fragment r4, ViewGroup r5, b r6, ECShopHybridProductViewModel r7, ECStoreViewModel r8) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        Intrinsics.checkNotNullParameter(r5, "p2");
        Intrinsics.checkNotNullParameter(r6, "p3");
        Intrinsics.checkNotNullParameter(r7, "p4");
        Intrinsics.checkNotNullParameter(r8, "p5");
        ((ECShopEmptyHolder.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r7, "tabViewModel");
        Intrinsics.checkNotNullParameter(r8, "storeViewModel");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r8, "storeViewModel");
        QUIManager r9 = new QUIManager();
        View r10 = LayoutInflater.from(r5.getContext()).inflate(2131564807, null);
        RecyclerView.LayoutParams r0 = new RecyclerView.LayoutParams(-1, -2);
        r0.setMargins(0, com.bytedance.android.shopping.extensions.b.b(12), 0, 0);
        Unit r1 = Unit.INSTANCE;
        r10.setLayoutParams(r0);
        r9.k(new com.bytedance.android.shopping.store.hybridproduct.module.b((ViewGroup) r10), r5.getContext(), r4);
        return new ECShopEmptyHolder(r9, r10, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5) {
        return invoke((Fragment) r1, (ViewGroup) r2, (b) r3, (ECShopHybridProductViewModel) r4, (ECStoreViewModel) r5);
    }
}
