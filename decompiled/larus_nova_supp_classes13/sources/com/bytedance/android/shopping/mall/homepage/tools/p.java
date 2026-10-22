package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(HomePageDTO r3) {
        Intrinsics.checkNotNullParameter(r3, "dto");
        HomePageBffDTO r4 = r3.getBff();
        if (r4 == null) goto L5;
        ECHybridListDTO r5 = r4.getFeed();
    L7:
        if (r5 == null) goto L26;
        List r1 = r5.getSections();
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L27;
        Map r6 = r5.getItemConfigs();
        if (r6 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == true) goto L28;
        return true;
    L28:
        return false;
    L19:
        if (r6.isEmpty() == true) goto L22;
        r7 = false;
        goto L23
    L27:
        return false;
    L11:
        if (r1.isEmpty() == true) goto L14;
        r2 = false;
        goto L15
    L26:
        return false;
    L5:
        r5 = null;
        goto L7
    }
}
