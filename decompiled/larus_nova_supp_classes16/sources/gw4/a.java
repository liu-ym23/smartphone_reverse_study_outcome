package gw4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    static {
    }

    public static boolean a() {
        ce5.a r0 = new ce5.a();
        Intrinsics.checkNotNullParameter(r0, "userComponentAbility");
        boolean r1 = ex4.a.a(r0.d);
        tt5.a.h("ContentWidgetFeatureGatingV2", "isSidebarEnable()...enable = " + r1);
        return r1;
    }
}
