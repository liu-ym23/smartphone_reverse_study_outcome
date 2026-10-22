package com.bytedance.ee.bear.more.protocol3.panel;

import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y {
    public static final boolean a = false;

    static {
        a = !DowngradeSettingUtil.a("downgradeOfficeMorePanel");
    }

    @JvmStatic
    public static final boolean a() {
        boolean r0 = DowngradeSettingUtil.a("downgradeMoreItemPermissionAlignment");
        if (r0 == false) goto L6;
        tt5.a.h("MorePanelHelper", "More item permission alignment downgrade hit, key=downgradeMoreItemPermissionAlignment");
    L6:
        return !r0;
    }

    @JvmStatic
    public static final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "itemId");
        tt5.a.h("MorePanelHelper", "More item permission alignment downgrade applied, source=" + r2 + ", itemId=" + r3 + ", key=downgradeMoreItemPermissionAlignment");
    }

    @JvmStatic
    public static final void b(String r2, String r3, boolean r4, boolean r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "itemId");
        Intrinsics.checkNotNullParameter(r6, "disableReason");
        Intrinsics.checkNotNullParameter(r7, "permissionSource");
        tt5.a.h("MorePanelHelper", "More item permission decision, source=" + r2 + ", itemId=" + r3 + ", visible=" + r4 + ", enabled=" + r5 + ", disableReason=" + r6 + ", permissionSource=" + r7);
    }
}
