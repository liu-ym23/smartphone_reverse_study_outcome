package com.bytedance.android.shopping.store.router.hybridpage.hybridList;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageSliceBaseProductCardHolder;
import com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageSliceGeneralCardHolder;
import com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageSliceProductCardHolder;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HybridHolderFactory extends a {
    public static final Map<Integer, Function4<Fragment, ViewGroup, km.b, HybridPageViewModel, HybridPageSliceBaseProductCardHolder>> a = null;

    static {
        Integer r1 = Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_NEW.getType());
        HybridPageSliceProductCardHolder.a r3 = HybridPageSliceProductCardHolder.p;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r1, new HybridHolderFactory$holderCreators$1(r3)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType()), new HybridHolderFactory$holderCreators$2(r3)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SEARCH_RESULT_GENERAL_CARD.getType()), new HybridHolderFactory$holderCreators$3(HybridPageSliceGeneralCardHolder.s))});
    }
}
