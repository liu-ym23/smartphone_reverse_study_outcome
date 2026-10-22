package d37;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements e37.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f466749a = null;

    static {
        f466749a = new i();
    }

    public i() {
    }

    public static e37.c f() {
        int r100 = w27.e.f558039a;
        e37.f r101 = w27.f.f558040a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getLogger();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        e37.c r101 = f();
        if (r101 == null) goto L6;
        ((com.larus.navigation.impl.platform.k) r101).b(r100);
        return;
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        e37.c r101 = f();
        if (r101 == null) goto L6;
        ((com.larus.navigation.impl.platform.k) r101).c("BDNavigation", r100, null);
        return;
    }

    public static void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        e37.c r101 = f();
        if (r101 == null) goto L6;
        ((com.larus.navigation.impl.platform.k) r101).d("BDNavigation", r100);
        return;
    }

    public static void e(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        e37.c r102 = f();
        if (r102 == null) goto L6;
        ((com.larus.navigation.impl.platform.k) r102).c("BDNavigation", r100, r101);
        return;
    }

    public final void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        e37.c r102 = f();
        if (r102 == null) goto L6;
        ((com.larus.navigation.impl.platform.k) r102).d(r100, r101);
        return;
    }

    public final void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        e37.c r103 = f();
        if (r103 == null) goto L6;
        ((com.larus.navigation.impl.platform.k) r103).a(r100, r101, r102);
        return;
    }

    public final void d(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        e37.c r103 = f();
        if (r103 == null) goto L6;
        ((com.larus.navigation.impl.platform.k) r103).c(r100, r101, r102);
        return;
    }

    public final void i(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        e37.c r103 = f();
        if (r103 == null) goto L6;
        ((com.larus.navigation.impl.platform.k) r103).e(r100, r101, r102);
        return;
    }

    public final void j(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        e37.c r103 = f();
        if (r103 == null) goto L6;
        ((com.larus.navigation.impl.platform.k) r103).f(r100, r101, r102);
        return;
    }
}
