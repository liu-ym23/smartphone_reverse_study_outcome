package tb7;

import com.bytedance.sdk.account.log.internal.LogWrapper;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile LogWrapper f545271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f545272b;

    static {
        f545271a = new LogWrapper(new vb7.a(), true);
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        f545271a.b(3, r100, r101, null);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        f545271a.b(6, r100, r101, null);
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        f545271a.b(4, r100, r101, null);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        f545271a.b(5, r100, r101, null);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        f545271a.b(6, r100, r101, r102);
    }

    @JvmStatic
    public static final void f(String r100, String r101, Throwable r102) {
        f545271a.b(5, r100, r101, r102);
    }
}
