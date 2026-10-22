package y16;

import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "该类已经废弃，请使用HybridLogger进行日志打印")
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f565659a;

    static {
        f565659a = new a();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        f565659a.d("[ResourceLoader] " + r100);
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        f565659a.e("[ResourceLoader] " + r100);
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        f565659a.w("[ResourceLoader] " + r100);
    }

    public static void c(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "tr");
        f565659a.e("[ResourceLoader] ".concat(r100), r101);
    }
}
