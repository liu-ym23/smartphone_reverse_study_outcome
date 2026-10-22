package jta;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.common.applog.c0;
import com.ss.android.common.applog.d0;
import java.util.concurrent.ConcurrentHashMap;
import kta.u;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile g f500367a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f500368b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f500369c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f500370d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f500371e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f500372f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile j f500373g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f500374h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m f500375i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static l f500376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f500377k = null;

    /* JADX INFO: loaded from: classes6.dex */
    public interface a {
        void onDeviceRegistrationInfoChanged(String r100, String r101);

        void onDidLoadLocally(boolean r100);

        void onRemoteConfigUpdate(boolean r100, boolean r101);
    }

    static {
        m r100 = new m();
        f500375i = r100;
        f500376j = r100;
        f500377k = new b();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.deviceregister.newuser.NewUserModeManager");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.deviceregister.newuser.NewUserModeManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.deviceregister.newuser.NewUserModeManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.deviceregister.newuser.NewUserModeManager");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.deviceregister.newuser.NewUserModeManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.deviceregister.newuser.NewUserModeManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.deviceregister.newuser.NewUserModeManager");
    }

    public static int c() {
        return f500376j.getAppId();
    }

    public static String d() {
        return f500376j.getDeviceId();
    }

    public static String e() {
        return f500376j.getInstallId();
    }

    public static boolean f() {
        if (f500370d >= 0) goto L6;
        ita.j.c("DeviceRegisterManager SwitchToBdtracker has not been set!", null);
    L6:
        if (f500370d <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static void b(a r100) {
        f500376j.p(r100);
    }

    public static boolean g(Context r100) {
        return f500376j.r(r100);
    }

    public static void h(eta.b r100) {
        f500376j.b(r100);
        if (f() == false) goto L5;
        f500375i.getClass();
        u.f506138b = r100;
    L5:
        c0.f408079a = r100;
        if (f() == false) goto L8;
        f500377k.b(r100);
        return;
    L8:
        d0.f408095d = r100;
    }

    public g(boolean r100, boolean r101) {
        f500376j.d(f500369c, r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
