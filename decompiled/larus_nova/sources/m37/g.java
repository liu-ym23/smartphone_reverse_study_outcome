package m37;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.settings.SettingsConfigProviderImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends ILocalSettings>, ILocalSettings> f511776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends ILocalSettings>, Object> f511777b;

    public g() {
        this.f511776a = new ConcurrentHashMap();
        this.f511777b = new ConcurrentHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100, ClassLoader r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = Class.forName(r100, true, r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r105 = Class.forName(r100, true, r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static ILocalSettings b(Class r100, g37.d r101) {
        h37.g r102 = r101.f479840c.f479853b;
        Constructor r103 = a(r100.getName().concat("$$Impl"), r100.getClassLoader()).getConstructor(new Class[]{h37.f.class});     // Catch: Throwable -> L13 InvocationTargetException -> L15 InstantiationException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21 ClassNotFoundException -> L23
        Settings r104 = (Settings) r100.getAnnotation(Settings.class);     // Catch: Throwable -> L13 InvocationTargetException -> L15 InstantiationException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21 ClassNotFoundException -> L23
        if (r104 != null) goto L6;
        Throwable r105 = null;
    L26:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", r105);
    L6:
        if (j37.a.f497127p == null) goto L10;
        ((ft9.c) j37.a.f497127p).getClass();     // Catch: Throwable -> L13 InvocationTargetException -> L15 InstantiationException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21 ClassNotFoundException -> L23
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L10;
        r101.f479840c.getClass();     // Catch: Throwable -> L13 InvocationTargetException -> L15 InstantiationException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21 ClassNotFoundException -> L23
    L10:
        return (ILocalSettings) r103.newInstance(new Object[]{r102.a(r104.storageKey(), false, r104.isSupportMultiProcess())});
    L23:
        e = move-exception;
        e.printStackTrace();
        r105 = e;
    L19:
        e = move-exception;
        e.printStackTrace();
        r105 = e;
    L17:
        e = move-exception;
        e.printStackTrace();
        r105 = e;
    L21:
        e = move-exception;
        e.printStackTrace();
        r105 = e;
    L15:
        e = move-exception;
        e.printStackTrace();
        r105 = e;
    L13:
        th = move-exception;
        throw th;
    }

    public final <T extends ILocalSettings> T c(Class<T> r100, g37.d r101, String r102) {
        T r103 = (T) this.f511776a.get(r100);
        if (r103 != null) goto L37;
        Settings r104 = (Settings) r100.getAnnotation(Settings.class);
        if (r104 != null) goto L7;
        String r105 = "";
    L9:
        if (r102.equals(r105) == false) goto L35;
        ConcurrentHashMap<Class<? extends ILocalSettings>, Object> r106 = this.f511777b;
        monitor-enter(r106);
    L31:
        th = move-exception;
        throw th;
    L13:
        if (this.f511777b.containsKey(r100) == false) goto L15;
        Object r107 = this.f511777b.get(r100);     // Catch: Throwable -> L31
    L16:
        if (r107 != null) goto L18;
        r107 = new Object();     // Catch: Throwable -> L31
        this.f511777b.put(r100, r107);     // Catch: Throwable -> L31
    L18:
        monitor-exit(r106);     // Catch: Throwable -> L31
        monitor-enter(r107);
        ILocalSettings r108 = this.f511776a.get(r100);     // Catch: Throwable -> L28
        if (r108 != null) goto L25;
        ILocalSettings r109 = b(r100, r101);     // Catch: Throwable -> L28
        if (r109 == null) goto L26;
        this.f511776a.put(r100, r109);     // Catch: Throwable -> L28
    L26:
        monitor-exit(r107);     // Catch: Throwable -> L28
        return (T) r109;
    L25:
        r109 = r108;
    L28:
        th = move-exception;
        throw th;
    L15:
        r107 = null;
        goto L16
    L35:
        throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + r105 + " - ");
    L7:
        r105 = r104.settingsId();
        goto L9
    L37:
        if (this.f511777b.containsKey(r100) == false) goto L45;
        this.f511777b.remove(r100);
        return r103;
    L45:
        return r103;
    }
}
