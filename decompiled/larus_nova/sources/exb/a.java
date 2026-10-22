package exb;

import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f474733a;

    public a() {
        this.f474733a = "";
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r102 = c.f474739a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        j.b("PlatformViewLog-" + r100, r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r102 = c.f474739a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        j.e("PlatformViewLog-" + r100, r101);
    }

    public static void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r102 = c.f474739a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        j.f("PlatformViewLog-".concat(r100), r101);
    }

    public final String e(String r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        return this.f474733a + r100;
    L11:
        return this.f474733a + r101 + '-' + r100;
    L4:
        if (r101.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public static void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        int r103 = c.f474739a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        j.c("PlatformViewLog-" + r100, r101, r102);
    }

    public final void d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        c(e(r100, r101), r102);
    }
}
