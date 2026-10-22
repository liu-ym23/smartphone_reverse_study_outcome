package com.bytedance.android.shopping.yata.init;

import com.bytedance.android.shopping.yata.frontier.YataFrontierManager;
import com.bytedance.kmp.ec.yata.b;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AndroidYataBuilderManager {
    public static final /* synthetic */ int a = 0;

    public AndroidYataBuilderManager() {
    }

    static {
    }

    public static b a(final String r8, com.bytedance.kmp.ec.yata.a r9, com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r10, YataPageInfo r11, final Function1 r12) {
        Intrinsics.checkNotNullParameter(r8, "bizCode");
        Intrinsics.checkNotNullParameter(r9, "abilityProvider");
        AndroidYataLoader.a();
        b r1 = new b(r8, r9, r10, r11, new AndroidYataBuilderManager$getBuilder$builder$1(r12, r8));
        if (((YataStoreWrapper) r1.a).c.getUseFrontier() == false) goto L29;
        Map<String, YataFrontierManager> r13 = YataFrontierManager.d;
        Intrinsics.checkNotNullParameter(r8, "bizCode");
        int r14 = r8.hashCode();
        YataFrontierManager r15 = null;
        if (r14 == (-896206182)) goto L18;
        if (r14 == (-418876333)) goto L15;
        if (r14 == 334272938) goto L12;
    L20:
        com.bytedance.android.shopping.yata.frontier.a r16 = null;
    L21:
        if (r16 == null) goto L27;
        Map<String, YataFrontierManager> r17 = YataFrontierManager.d;
        LinkedHashMap r18 = (LinkedHashMap) r17;
        if (r18.get(r16.a) != null) goto L26;
        r17.put(r16.a, new YataFrontierManager(r16));
    L26:
        r15 = (YataFrontierManager) r18.get(r16.a);
    L27:
        if (r15 == null) goto L29;
        r15.b();
        goto L29
    L12:
        if (r8.equals("yata_cart") == false) goto L20;
        r16 = new com.bytedance.android.shopping.yata.frontier.a(922548, "baf293bb2f90a449d663c666aa310245", 1039, 2089);
        goto L21
    L15:
        if (r8.equals("yata_skubuy") == false) goto L20;
    L19:
        r16 = new com.bytedance.android.shopping.yata.frontier.a(634674, "30bc237378679bd00e31b535d9a4dcfb", 1611, 2088);
        goto L21
    L18:
        if (r8.equals("yata_buynow") == false) goto L20;
    L29:
        return r1;
    }
}
