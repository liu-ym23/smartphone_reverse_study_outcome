package com.bytedance.android.shopping.mall.homepage.tools;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w {
    public static String a(CommonEnterFromParams r8) {
        CommonEnterFromOptions r0 = new CommonEnterFromOptions(false, 1, null);
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r0, "options");
        if (r8.getOrder() == null) goto L5;
        String r1 = "order" + r8.getOrder() + '.';
    L6:
        String r2 = r8.getPageName() + '.' + (r8.getModuleKey() + r8.getModuleId()) + '.' + r1 + (r8.getComponentKey() + r8.getComponentId()) + '.' + (r8.getResourceKey() + r8.getResourceId());
        if (r0.getAddPreviousPage() == true) goto L9;
        return r2;
    L9:
        return r8.getPreviousPage() + '.' + r2;
    L5:
        r1 = "";
        goto L6
    }
}
