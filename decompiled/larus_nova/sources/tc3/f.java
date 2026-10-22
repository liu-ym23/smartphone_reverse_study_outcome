package tc3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f545400a = 0;

    public static boolean a() {
        return Intrinsics.areEqual(a.a().b(), Boolean.TRUE);
    }

    public static boolean b() {
        return Intrinsics.areEqual(a.a().d(), Boolean.TRUE);
    }

    public static Integer c() {
        return a.a().e();
    }

    public static boolean d() {
        return Intrinsics.areEqual(a.a().f(), Boolean.TRUE);
    }

    public static boolean e() {
        if (c() == null) goto L10;
        Integer r100 = c();
        if (r100 != null) goto L8;
    L9:
        return true;
    L8:
        if (r100.intValue() != 0) goto L9;
    L10:
        return false;
    }

    public static boolean f() {
        return Intrinsics.areEqual(a.a().p(), Boolean.TRUE);
    }

    static {
    }
}
