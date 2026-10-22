package com.bytedance.ee.bear.more.protocol3.panel;

import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f235006a = false;

    static {
        f235006a = !DowngradeSettingUtil.a("downgradeOfficeMorePanel");
    }

    @JvmStatic
    public static final boolean a() {
        boolean r100 = DowngradeSettingUtil.a("downgradeMoreItemPermissionAlignment");
        if (r100 == false) goto L6;
        tt5.a.h("MorePanelHelper", "More item permission alignment downgrade hit, key=downgradeMoreItemPermissionAlignment");
    L6:
        return !r100;
    }

    @JvmStatic
    public static final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        tt5.a.h("MorePanelHelper", "More item permission alignment downgrade applied, source=" + r100 + ", itemId=" + r101 + ", key=downgradeMoreItemPermissionAlignment");
    }

    @JvmStatic
    public static final void b(String r100, String r101, boolean r102, boolean r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        Intrinsics.checkNotNullParameter(r104, "disableReason");
        Intrinsics.checkNotNullParameter(r105, "permissionSource");
        tt5.a.h("MorePanelHelper", "More item permission decision, source=" + r100 + ", itemId=" + r101 + ", visible=" + r102 + ", enabled=" + r103 + ", disableReason=" + r104 + ", permissionSource=" + r105);
    }
}
