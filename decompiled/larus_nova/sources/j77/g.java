package j77;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.push.settings.ILocalSettings;
import com.bytedance.push.settings.annotation.Settings;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends ILocalSettings>, ILocalSettings> f497632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f497633b;

    public g(a87.i r100) {
        this.f497632a = new ConcurrentHashMap();
        this.f497633b = r100;
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

    public final <T extends ILocalSettings> T b(Context r100, Class<T> r101) {
        j r102 = this.f497633b;
        Constructor r103 = a(r101.getName().concat("$$SettingImpl"), r101.getClassLoader()).getConstructor(new Class[]{Context.class, a87.k.class});     // Catch: InvocationTargetException -> L7 InstantiationException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13 ClassNotFoundException -> L15
        Settings r104 = (Settings) r101.getAnnotation(Settings.class);     // Catch: InvocationTargetException -> L7 InstantiationException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13 ClassNotFoundException -> L15
        if (r104 == null) goto L18;
        String r105 = r104.storageKey();     // Catch: InvocationTargetException -> L7 InstantiationException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13 ClassNotFoundException -> L15
        boolean r106 = r104.supportMultiProcess();     // Catch: InvocationTargetException -> L7 InstantiationException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13 ClassNotFoundException -> L15
        int r107 = q77.a.f531973a;     // Catch: InvocationTargetException -> L7 InstantiationException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13 ClassNotFoundException -> L15
        return (T) r103.newInstance(new Object[]{r100, ((a87.i) r102).a(r100, r106, r105, null)});
    L18:
        throw new IllegalStateException("get settings instance error，please check warning log");
    L15:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public final <T extends ILocalSettings> T c(Context r100, Class<T> r101) {
        T r102 = (T) this.f497632a.get(r101);
        if (r102 != null) goto L13;
        monitor-enter(this);
        r102 = (T) this.f497632a.get(r101);     // Catch: Throwable -> L10
        if (r102 != null) goto L8;
        ILocalSettings r103 = b(r100, r101);     // Catch: Throwable -> L10
        this.f497632a.put(r101, r103);     // Catch: Throwable -> L10
        r102 = (T) r103;
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r102;
    }
}
