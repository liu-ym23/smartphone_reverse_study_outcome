package rk7;

import android.app.Application;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ek7.a f538337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static bl7.b f538338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static qk7.a f538339c;

    public static synchronized qk7.a b() {
        monitor-enter(f.class);
        Application r100 = m.f538347a;     // Catch: Throwable -> L19
        qk7.a r101 = f538339c;     // Catch: Throwable -> L19
        if (r101 == null) goto L26;
        monitor-exit(f.class);
        return r101;
    L26:
        f538339c = (qk7.a) a("com.bytedance.ug.sdk.luckydog.link.keep.LuckyDogLinkConfig").newInstance();     // Catch: Throwable -> L10
        com.bytedance.ug.sdk.luckydog.api.log.d.d("DependManager", "getLuckyDogLinkImpl() 反射调用成功");     // Catch: Throwable -> L10
    L16:
        qk7.a r102 = f538339c;     // Catch: Throwable -> L19
        monitor-exit(f.class);
        return r102;
    L10:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("DependManager", th.getLocalizedMessage(), th);     // Catch: Throwable -> L19
        th.printStackTrace();     // Catch: Throwable -> L19
        String r103 = qk7.a.class.getClassLoader().getClass().getName();     // Catch: Throwable -> L14
        String r104 = qk7.a.class.getClassLoader().getClass().getName();     // Catch: Throwable -> L14
        com.bytedance.ug.sdk.luckydog.api.log.d.d("DependManager", "implClassLoaderName: ".concat(r103));     // Catch: Throwable -> L14
        com.bytedance.ug.sdk.luckydog.api.log.d.d("DependManager", "apiClassLoaderName: ".concat(r104));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("DependManager", th.getLocalizedMessage(), th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static synchronized ek7.a c() {
        monitor-enter(f.class);
        ek7.a r100 = f538337a;     // Catch: Throwable -> L23
        if (r100 == null) goto L8;
        monitor-exit(f.class);
        return r100;
    L8:
        AtomicBoolean r101 = u.f538372v;     // Catch: Throwable -> L23
        u.c.f538395a.getClass();     // Catch: Throwable -> L23
        if (u.d() == true) goto L26;
        ek7.a r102 = f538337a;     // Catch: Throwable -> L23
        monitor-exit(f.class);
        return r102;
    L26:
        f538337a = (ek7.a) a("com.bytedance.ug.sdk.luckydog.base.keep.LuckyDogSDKImpl").newInstance();     // Catch: Throwable -> L15
    L18:
        if (f538337a == null) goto L20;
        il7.g.e("LuckyDogSDKImpl");     // Catch: Throwable -> L23
    L20:
        ek7.a r103 = f538337a;     // Catch: Throwable -> L23
        monitor-exit(f.class);
        return r103;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public static synchronized bl7.b d() {
        monitor-enter(f.class);
        Application r100 = m.f538347a;     // Catch: Throwable -> L19
        bl7.b r101 = f538338b;     // Catch: Throwable -> L19
        if (r101 == null) goto L26;
        monitor-exit(f.class);
        return r101;
    L26:
        f538338b = (bl7.b) a("com.bytedance.ug.sdk.luckydog.task.keep.LuckyDogTaskConfig").newInstance();     // Catch: Throwable -> L10
        com.bytedance.ug.sdk.luckydog.api.log.d.d("DependManager", "getLuckyDogWindowImpl() 反射调用成功");     // Catch: Throwable -> L10
    L16:
        bl7.b r102 = f538338b;     // Catch: Throwable -> L19
        monitor-exit(f.class);
        return r102;
    L10:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("DependManager", th.getLocalizedMessage(), th);     // Catch: Throwable -> L19
        th.printStackTrace();     // Catch: Throwable -> L19
        String r103 = bl7.b.class.getClassLoader().getClass().getName();     // Catch: Throwable -> L14
        String r104 = bl7.b.class.getClassLoader().getClass().getName();     // Catch: Throwable -> L14
        com.bytedance.ug.sdk.luckydog.api.log.d.d("DependManager", "implClassLoaderName: ".concat(r103));     // Catch: Throwable -> L14
        com.bytedance.ug.sdk.luckydog.api.log.d.d("DependManager", "apiClassLoaderName: ".concat(r104));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("DependManager", th.getLocalizedMessage(), th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }
}
