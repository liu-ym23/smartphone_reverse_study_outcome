package m37;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.settings.SettingsConfigProviderImpl;
import h37.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class g {
    public final ConcurrentHashMap<Class<? extends ILocalSettings>, ILocalSettings> a;
    public final ConcurrentHashMap<Class<? extends ILocalSettings>, Object> b;

    public g() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r5 = Class.forName(r3, true, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r6 = Class.forName(r3, true, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static ILocalSettings b(Class r6, g37.d r7) {
        h37.g r1 = r7.c.b;
        Constructor r0 = a(r6.getName().concat("$$Impl"), r6.getClassLoader()).getConstructor(new Class[]{f.class});     // Catch: Throwable -> L13 InvocationTargetException -> L15 InstantiationException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21 ClassNotFoundException -> L23
        Settings r8 = (Settings) r6.getAnnotation(Settings.class);     // Catch: Throwable -> L13 InvocationTargetException -> L15 InstantiationException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21 ClassNotFoundException -> L23
        if (r8 != null) goto L6;
        Throwable r9 = null;
    L26:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", r9);
    L6:
        if (j37.a.p == null) goto L10;
        ((ft9.c) j37.a.p).getClass();     // Catch: Throwable -> L13 InvocationTargetException -> L15 InstantiationException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21 ClassNotFoundException -> L23
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L10;
        r7.c.getClass();     // Catch: Throwable -> L13 InvocationTargetException -> L15 InstantiationException -> L17 IllegalAccessException -> L19 NoSuchMethodException -> L21 ClassNotFoundException -> L23
    L10:
        return (ILocalSettings) r0.newInstance(new Object[]{r1.a(r8.storageKey(), false, r8.isSupportMultiProcess())});
    L23:
        e = move-exception;
        e.printStackTrace();
        r9 = e;
    L19:
        e = move-exception;
        e.printStackTrace();
        r9 = e;
    L17:
        e = move-exception;
        e.printStackTrace();
        r9 = e;
    L21:
        e = move-exception;
        e.printStackTrace();
        r9 = e;
    L15:
        e = move-exception;
        e.printStackTrace();
        r9 = e;
    L13:
        th = move-exception;
        throw th;
    }

    public final <T extends ILocalSettings> T c(Class<T> r3, g37.d r4, String r5) {
        T r0 = (T) this.a.get(r3);
        if (r0 != null) goto L37;
        Settings r1 = (Settings) r3.getAnnotation(Settings.class);
        if (r1 != null) goto L7;
        String r2 = XmlPullParser.NO_NAMESPACE;
    L9:
        if (r5.equals(r2) == false) goto L35;
        ConcurrentHashMap<Class<? extends ILocalSettings>, Object> r6 = this.b;
        monitor-enter(r6);
    L31:
        th = move-exception;
        throw th;
    L13:
        if (this.b.containsKey(r3) == false) goto L15;
        Object r7 = this.b.get(r3);     // Catch: Throwable -> L31
    L16:
        if (r7 != null) goto L18;
        r7 = new Object();     // Catch: Throwable -> L31
        this.b.put(r3, r7);     // Catch: Throwable -> L31
    L18:
        monitor-exit(r6);     // Catch: Throwable -> L31
        monitor-enter(r7);
        ILocalSettings r8 = this.a.get(r3);     // Catch: Throwable -> L28
        if (r8 != null) goto L25;
        ILocalSettings r9 = b(r3, r4);     // Catch: Throwable -> L28
        if (r9 == null) goto L26;
        this.a.put(r3, r9);     // Catch: Throwable -> L28
    L26:
        monitor-exit(r7);     // Catch: Throwable -> L28
        return (T) r9;
    L25:
        r9 = r8;
    L28:
        th = move-exception;
        throw th;
    L15:
        r7 = null;
        goto L16
    L35:
        throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + r2 + " - ");
    L7:
        r2 = r1.settingsId();
        goto L9
    L37:
        if (this.b.containsKey(r3) == false) goto L45;
        this.b.remove(r3);
        return r0;
    L45:
        return r0;
    }
}
