package com.bytedance.android.shopping.store.product;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.utils.h;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(ECStoreViewModel r2, StoreTabConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "storeViewModel");
        ECStoreParam r0 = r2.getStoreParam();
        r2.getFirstScreenConfig().d = r3;
        Map<Long, m> r4 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r5 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r0.getLifecycleMonitorId()));
        if (r5 == null) goto L6;
        r5.e(r3);
        return;
    }

    public static void a(ECStoreViewModel r8, ECShopHybridProductViewModel r9, StoreTabConfig r10, StoreV2ProductListResponseVO r11, Context r12, FragmentActivity r13) {
        Intrinsics.checkNotNullParameter(r8, "storeViewModel");
        Intrinsics.checkNotNullParameter(r9, "hybridViewModel");
        ECStoreParam r2 = r8.getStoreParam();
        com.bytedance.android.shopping.store.viewmodel.c r0 = r8.getFirstScreenConfig();
        int r1 = h.a;
        if (r11 == null) goto L5;
        Integer r3 = r11.getLayoutType();
    L6:
        if (r11 == null) goto L8;
        Integer r4 = r11.getForceProductLayout();
    L9:
        LayoutTypes r5 = h.b(r3, r4);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.f = r5;
        if (r13 == null) goto L12;
        String r6 = hm.c.e(r13);
    L14:
        if (Intrinsics.areEqual((Boolean) r8.isBrandShop().getValue(), Boolean.TRUE) == false) goto L16;
        String r14 = "brand";
    L17:
        r9.init(r2, r11, r10, r6, r14, r12);
        return;
    L16:
        r14 = "0";
        goto L17
    L12:
        r6 = null;
        goto L14
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }
}
