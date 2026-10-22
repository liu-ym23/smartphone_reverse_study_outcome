package ex4;

import com.ss.android.lark.log.Log;
import jdb.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static Boolean a;

    static {
    }

    @JvmStatic
    public static final boolean a(g r1) {
        Intrinsics.checkNotNullParameter(r1, "fgService");
        if (a != null) goto L5;
        a = Boolean.valueOf(r1.isCurrentEnable("ccm.mobile.newspace"));
    L5:
        Log.i("NewDocIsEnable", "getGlobalDocState()...enable = " + a);
        Boolean r2 = a;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Boolean");
        return r2.booleanValue();
    }
}
