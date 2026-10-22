package ce5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    static {
    }

    public static boolean a(String r4) {
        a r1 = new a();     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r1, "<this>");     // Catch: Exception -> L5
        boolean r2 = r1.d.isEnable(r4);     // Catch: Exception -> L5
        tt5.a.h("UserComponentAbilityExtensions", "isEnable: " + r4 + " = " + r2);     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        tt5.a.d("UserComponentAbilityExtensions", "isEnable fail, component run error: " + e);
        return false;
    }
}
