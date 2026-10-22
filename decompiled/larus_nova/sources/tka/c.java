package tka;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f546598a;

    static {
        f546598a = new b(false);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter("ContextAwareness", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        f546598a.a(r100);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f546598a.c(r100, r101);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f546598a.d(r100, r101);
    }

    public static void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f546598a.b(r100, r101);
    }
}
