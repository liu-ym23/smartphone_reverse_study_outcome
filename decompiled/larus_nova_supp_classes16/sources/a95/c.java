package a95;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final boolean a(a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        boolean r4 = r2.c.isEnable(r3);
        tt5.a.h("DriveUserComponentAbilityExtensions", "isEnable: " + r3 + " = " + r4);
        return r4;
    }
}
