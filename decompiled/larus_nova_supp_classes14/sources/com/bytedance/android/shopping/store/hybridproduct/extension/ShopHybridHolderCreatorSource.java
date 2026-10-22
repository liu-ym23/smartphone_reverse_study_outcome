package com.bytedance.android.shopping.store.hybridproduct.extension;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopHybridHolderCreatorSource {
    public static boolean a;
    public static final Set<Integer> b = null;

    public static final class a<DTO, VO extends d> {
        public final int a;
        public final Class<DTO> b;
        public final Function2<DTO, String, VO> c;
        public final Function5<Fragment, ViewGroup, km.b, ECShopHybridProductViewModel, ECStoreViewModel, ECShopBaseHolder> d;

        public final int getType() {
            return this.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(int r2, Class<DTO> r3, Function2<? super DTO, ? super String, ? extends VO> r4, Function5<? super Fragment, ? super ViewGroup, ? super km.b, ? super ECShopHybridProductViewModel, ? super ECStoreViewModel, ? extends ECShopBaseHolder> r5) {
            Intrinsics.checkNotNullParameter(r3, "dtoClazz");
            Intrinsics.checkNotNullParameter(r4, "transformer");
            Intrinsics.checkNotNullParameter(r5, "creator");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        b = SetsKt.emptySet();
    }

    public static Map a(Map r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r5.next();
        int r2 = ((Number) r1.getKey()).intValue();
        final Function5 r3 = (Function5) r1.getValue();
        r0.put(Integer.valueOf(r2), new ShopHybridHolderCreatorSource$ensureLayoutParamsRight$1(r3));
        goto L4
    L6:
        return r0;
    }
}
