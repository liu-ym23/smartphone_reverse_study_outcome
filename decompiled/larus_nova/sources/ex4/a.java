package ex4;

import com.ss.android.lark.log.Log;
import jdb.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f474715a;

    static {
    }

    @JvmStatic
    public static final boolean a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "fgService");
        if (f474715a != null) goto L5;
        f474715a = Boolean.valueOf(r100.isCurrentEnable("ccm.mobile.newspace"));
    L5:
        Log.i("NewDocIsEnable", "getGlobalDocState()...enable = " + f474715a);
        Boolean r101 = f474715a;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Boolean");
        return r101.booleanValue();
    }
}
