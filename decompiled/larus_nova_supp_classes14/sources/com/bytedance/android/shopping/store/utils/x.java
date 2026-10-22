package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.event.ECShopApiEmptyParamsErrorEvent;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(Pair... r9) {
        ArrayList r0 = new ArrayList();
        int r1 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L23;
        Pair r4 = r9[r3];
        Object r5 = r4.component2();
        boolean r6 = true;
        if (r5 != null) goto L7;
    L19:
        if (r6 == false) goto L21;
        r0.add(r4);
    L21:
        r3 = r3 + 1;
        goto L3
    L7:
        if ((r5 instanceof String) == true) goto L9;
        r5 = null;
    L9:
        String r7 = (String) r5;
        if (r7 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L19;
        r6 = false;
        goto L19
    L12:
        if (r7.length() == 0) goto L15;
        r8 = false;
        goto L16
    L23:
        return CollectionsKt.joinToString$default(CollectionsKt.toList(r0), "-", null, null, 0, null, null, 62, null);
    }

    public static void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "secShopId");
        if (StringsKt.isBlank(r3) == true) goto L5;
        return;
    L5:
        if (ECAppInfoService.e.isDebug() == false) goto L7;
        int r4 = com.bytedance.android.ec.sdk.helper.j.a;
        com.bytedance.android.ec.sdk.helper.j.c("SHOP_API_MONITOR_HELPER_TOAST", "店铺网络接口[" + r2 + "]检验失败，secShopId为空");
        return;
    L7:
        ECShopApiEmptyParamsErrorEvent r0 = new ECShopApiEmptyParamsErrorEvent();
        r0.setApiPath(r2);
        r0.setEmptyParams(b(new Pair[]{TuplesKt.to("sec_shop_id", r3)}));
    }
}
