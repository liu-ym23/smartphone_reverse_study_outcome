package j77;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.push.settings.ISettings;
import com.bytedance.push.settings.annotation.Settings;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends ISettings>, ISettings> f497634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends ISettings>, Object> f497635b;

    public h() {
        this.f497634a = new ConcurrentHashMap();
        this.f497635b = new ConcurrentHashMap();
    }

    public static <T extends ISettings> T a(Context r100, Class<T> r101) {
        a87.i r102 = i.f497636a;
        Settings r103 = (Settings) r101.getAnnotation(Settings.class);     // Catch: InvocationTargetException -> L7 InstantiationException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13 ClassNotFoundException -> L15
        Throwable r104 = null;
        if (r103 == null) goto L18;
        String r105 = r103.storageKey();     // Catch: InvocationTargetException -> L7 InstantiationException -> L9 IllegalAccessException -> L11 NoSuchMethodException -> L13 ClassNotFoundException -> L15
        return (T) b(r100, r101, r102.a(r100, r103.supportMultiProcess(), r105, null));
    L18:
        if (r104 == null) goto L22;
        throw new IllegalStateException("get settings instance error，please check warning log", r104);
    L22:
        throw new IllegalStateException("get settings instance error，please check warning log");
    L15:
        e = move-exception;
        ClassNotFoundException r106 = e;
        r106.printStackTrace();
        r104 = r106;
    L11:
        e = move-exception;
        IllegalAccessException r107 = e;
        r107.printStackTrace();
        r104 = r107;
    L9:
        e = move-exception;
        InstantiationException r108 = e;
        r108.printStackTrace();
        r104 = r108;
    L13:
        e = move-exception;
        NoSuchMethodException r109 = e;
        r109.printStackTrace();
        r104 = r109;
    L7:
        e = move-exception;
        InvocationTargetException r110 = e;
        r110.printStackTrace();
        r104 = r110;
        goto L18
    }

    public static <T extends ISettings> ISettings b(Context r100, Class<T> r101, a87.k r102) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String r103 = r101.getName().concat("$$SettingImpl");
        ClassLoader r104 = r101.getClassLoader();
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r105 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r106 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L35;
        Class<?> r107 = Class.forName(r103, true, r104);     // Catch: Throwable -> L8
        if (r106 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a(r103);     // Catch: Throwable -> L8
    L30:
        ISettings r108 = (ISettings) r107.getConstructor(new Class[]{a87.k.class}).newInstance(new Object[]{r102});
        r108.updateSettings(r100, null);
        return r108;
    L8:
        th = move-exception;
        if (r106 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r103);
    L12:
        throw th;
    L35:
        r107 = Class.forName(r103, true, r104);     // Catch: Throwable -> L17
        if (r106 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a(r103);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r106 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r103);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r107 = MiraPluginFix.forName(r103);
        goto L30
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
