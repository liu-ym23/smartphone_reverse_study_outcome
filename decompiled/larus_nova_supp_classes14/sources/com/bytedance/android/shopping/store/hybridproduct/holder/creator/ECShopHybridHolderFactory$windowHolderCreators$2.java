package com.bytedance.android.shopping.store.hybridproduct.holder.creator;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopSliceSortBarAndFilterHolder;
import com.bytedance.android.shopping.store.hybridproduct.module.w;
import com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory;
import com.bytedance.android.shopping.store.slicecard.ShopSlcTemplateManager;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.Iterator;
import km.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/fragment/app/Fragment;", "p1", "Landroid/view/ViewGroup;", "p2", "Lkm/b;", "p3", "Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;", "p4", "Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;", "p5", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSliceSortBarAndFilterHolder;", "invoke", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lkm/b;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSliceSortBarAndFilterHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECShopHybridHolderFactory$windowHolderCreators$2 extends FunctionReferenceImpl implements Function5<Fragment, ViewGroup, b, ECShopHybridProductViewModel, ECStoreViewModel, ECShopSliceSortBarAndFilterHolder> {
    public ECShopHybridHolderFactory$windowHolderCreators$2(ECShopSliceSortBarAndFilterHolder.a r8) {
        super(5, r8, ECShopSliceSortBarAndFilterHolder.a.class, "makeHolder", "makeHolder(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Lcom/bytedance/android/ec/store/common/typeddata/TypedDataCache;Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductViewModel;Lcom/bytedance/android/shopping/store/viewmodel/ECStoreViewModel;)Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopSliceSortBarAndFilterHolder;", 0);
    }

    public final ECShopSliceSortBarAndFilterHolder invoke(Fragment r10, ViewGroup r11, b r12, ECShopHybridProductViewModel r13, ECStoreViewModel r14) {
        Intrinsics.checkNotNullParameter(r10, "p1");
        Intrinsics.checkNotNullParameter(r11, "p2");
        Intrinsics.checkNotNullParameter(r12, "p3");
        Intrinsics.checkNotNullParameter(r13, "p4");
        Intrinsics.checkNotNullParameter(r14, "p5");
        ((ECShopSliceSortBarAndFilterHolder.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "viewGroup");
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r13, "tabViewModel");
        Intrinsics.checkNotNullParameter(r14, "storeViewModel");
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r13, "tabViewModel");
        Intrinsics.checkNotNullParameter(r14, "storeViewModel");
        QUIManager r15 = new QUIManager();
        FrameLayout r0 = new FrameLayout(r11.getContext());
        r0.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        ShopSlcCardFactory r1 = r14.getSliceCardFactory();
        r1.getClass();
        ShopSliceItemConfig r4 = ShopSlcTemplateManager.i.get(SliceItemType.SHOP_FILTER.getType());
        if (r4 == null) goto L12;
        Iterator<T> r5 = r4.getTemplates().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((SliceTemplate) r6).getName(), "shop_product_filter") == false) goto L6;
    L11:
        SliceTemplate r7 = (SliceTemplate) r6;
    L13:
        r r8 = r1.f(r7);
        if (r8 != null) goto L20;
        dm.a.b r9 = dm.a.a("ShopSlcProductCardFactory");
        StringBuilder r16 = new StringBuilder("createProductFilterViewInfo, viewInfo is null, context is null = ");
        if (r1.a != null) goto L18;
        boolean r2 = true;
    L19:
        r16.append(r2);
        r9.b(r16.toString(), null);
        goto L20
    L18:
        r2 = false;
    L20:
        if (r8 == null) goto L30;
        View r3 = r8.c;
        if (r3 == null) goto L30;
        r0.addView(r3, new FrameLayout.LayoutParams(-1, -2));
    L30:
        pn.b.a(r15, new w(r0, r14, r8), r11.getContext(), r10);     // Catch: Exception -> L26
    L29:
        return new ECShopSliceSortBarAndFilterHolder(r15, r15.p(), r13, r14);
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L10:
        r6 = null;
        goto L11
    L12:
        r7 = null;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5) {
        return invoke((Fragment) r1, (ViewGroup) r2, (b) r3, (ECShopHybridProductViewModel) r4, (ECStoreViewModel) r5);
    }
}
