package com.bytedance.android.shopping.store.utils;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Observable a(String r7, String r8) {
        Intrinsics.checkNotNullParameter("shop_share", "blockCode");
        Intrinsics.checkNotNullParameter(r7, "secShopId");
        Map r9 = MapsKt.mutableMapOf(new Pair[]{new Pair("sec_shop_id", r7)});
        ECStoreApi.a.getClass();
        ECStoreApi r0 = ECStoreApi.a.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBlockInfo("shop_share", com.bytedance.android.ec.hybrid.list.util.k.d(r9), r8, com.bytedance.android.ec.hybrid.list.util.k.d(ECShopABSettings.k.b()), null, null);
    }

    public static Observable b(String r10, View r11) {
        ECStoreApi.a.getClass();
        ECStoreApi r0 = ECStoreApi.a.a;
        String r1 = null;
        if (r0 == null) goto L9;
        Pair[] r2 = new Pair[2];
        r2[0] = TuplesKt.to("sec_shop_id", r10);
        kc.a r12 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, PageFinder.via(r11), 0, false, 6, null);
        if (r12 == null) goto L7;
        r1 = r12.a().toString();
    L7:
        r2[1] = TuplesKt.to("bcm_chain", com.bytedance.android.shopping.extensions.k.j(r1));
        return r0.getImCardInfo("commodity_msg_shop_store", com.bytedance.android.ec.hybrid.list.util.k.d(MapsKt.mutableMapOf(r2)));
    L9:
        return null;
    }
}
