package g49;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f480008a = null;

    static {
        f480008a = new d();
    }

    public d() {
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.d("DoraApp", r100 + "- " + r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.e("DoraApp", r100 + "- " + r101);
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.i("DoraApp", r100 + "- " + r101);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.w("DoraApp", r100 + "- " + r101);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.e("DoraApp", r100 + "- " + r101, r102);
    }
}
