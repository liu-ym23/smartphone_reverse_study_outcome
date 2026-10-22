package ll4;

import kl4.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f509676a = 0;

    static {
    }

    public static j a() {
        fl4.a.f477732a.getClass();     // Catch: Exception -> L4
        return (j) fl4.a.C5923a.a(Reflection.getOrCreateKotlinClass(j.class));
    L4:
        return null;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        j r102 = a();
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }
}
