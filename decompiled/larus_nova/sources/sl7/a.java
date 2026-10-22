package sl7;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import com.bytedance.ug.sdk.luckydog.base.window.ILuckyDogWindowConfig;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import il7.g;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ol7.a f542473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static nl7.a f542474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ILuckyDogWindowConfig f542475c;

    public static synchronized ol7.a b() {
        monitor-enter(a.class);
        ol7.a r100 = f542473a;     // Catch: Throwable -> L22
        if (r100 == null) goto L27;
        monitor-exit(a.class);
        return r100;
    L27:
        f542473a = (ol7.a) a("com.bytedance.ug.sdk.luckydog.business.keep.LuckyBusinessImpl").newInstance();     // Catch: Throwable -> L10
        d.d("DependManager", "getLuckyBusinessImpl() 反射调用成功");     // Catch: Throwable -> L10
    L17:
        if (f542473a == null) goto L19;
        g.e("LuckyBusinessImpl");     // Catch: Throwable -> L22
    L19:
        ol7.a r101 = f542473a;     // Catch: Throwable -> L22
        monitor-exit(a.class);
        return r101;
    L10:
        th = move-exception;
        d.c("DependManager", th.getLocalizedMessage(), th);     // Catch: Throwable -> L22
        th.printStackTrace();     // Catch: Throwable -> L22
        String r102 = ol7.a.class.getClassLoader().getClass().getName();     // Catch: Throwable -> L14
        String r103 = ol7.a.class.getClassLoader().getClass().getName();     // Catch: Throwable -> L14
        d.d("DependManager", "implClassLoaderName: ".concat(r102));     // Catch: Throwable -> L14
        d.d("DependManager", "apiClassLoaderName: ".concat(r103));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        d.c("DependManager", th.getLocalizedMessage(), th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static synchronized ILuckyDogWindowConfig c() {
        monitor-enter(a.class);
        ILuckyDogWindowConfig r100 = f542475c;     // Catch: Throwable -> L22
        if (r100 == null) goto L27;
        monitor-exit(a.class);
        return r100;
    L27:
        f542475c = (ILuckyDogWindowConfig) a("com.bytedance.ug.sdk.luckydog.window.keep.LuckyDogWindowConfig").newInstance();     // Catch: Throwable -> L10
        d.d("DependManager", "getLuckyDogWindowImpl() 反射调用成功");     // Catch: Throwable -> L10
    L17:
        if (f542475c == null) goto L19;
        g.e("LuckyDogWindowConfig");     // Catch: Throwable -> L22
    L19:
        ILuckyDogWindowConfig r101 = f542475c;     // Catch: Throwable -> L22
        monitor-exit(a.class);
        return r101;
    L10:
        th = move-exception;
        d.c("DependManager", th.getLocalizedMessage(), th);     // Catch: Throwable -> L22
        th.printStackTrace();     // Catch: Throwable -> L22
        String r102 = ILuckyDogWindowConfig.class.getClassLoader().getClass().getName();     // Catch: Throwable -> L14
        String r103 = ILuckyDogWindowConfig.class.getClassLoader().getClass().getName();     // Catch: Throwable -> L14
        d.d("DependManager", "implClassLoaderName: ".concat(r102));     // Catch: Throwable -> L14
        d.d("DependManager", "apiClassLoaderName: ".concat(r103));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        d.c("DependManager", th.getLocalizedMessage(), th);     // Catch: Throwable -> L22
    L22:
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
