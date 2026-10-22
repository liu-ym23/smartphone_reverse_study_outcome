package x8;

import com.bytedance.android.annie.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f562881a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b(r100, r101, false);
    }

    public static void b(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b8.a r103 = b8.a.f17992a;
        b8.a.a(new b8.b("Annie_" + r100, LogLevel.ERROR, null, r101, 4), r102);
    }

    public static void c(String r100, Throwable r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        b8.a r103 = b8.a.f17992a;
        b8.a.a(new b8.b("Annie_" + r100, LogLevel.ERROR, r101, null, 8), r102);
    }

    public static void d(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b8.a r103 = b8.a.f17992a;
        b8.a.a(new b8.b("Annie_" + r100, LogLevel.INFO, null, r101, 4), r102);
    }
}
