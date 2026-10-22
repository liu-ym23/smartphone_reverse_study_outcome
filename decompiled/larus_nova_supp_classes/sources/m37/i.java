package m37;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.bytedance.services.apm.api.IEnsure;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.settings.SettingsConfigProviderImpl;
import g37.e;
import h37.f;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i {
    public final ConcurrentHashMap<Class<? extends ISettings>, ISettings> a;
    public final ConcurrentHashMap<Class<? extends ISettings>, Object> b;

    public i() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public static <T extends ISettings> T a(Class<T> r6, g37.d r7) {
        h37.g r0 = r7.c.b;
        Settings r1 = (Settings) r6.getAnnotation(Settings.class);     // Catch: Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
        Throwable r2 = null;
        if (r1 == null) goto L48;
        r7.c.getClass();     // Catch: Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
        boolean r4 = j37.a.i;     // Catch: RuntimeException -> L9 Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
    L11:
        r7.c.getClass();     // Catch: Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
        String r3 = r1.storageKey();     // Catch: Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
        if (r4 == false) goto L18;
        j37.a.i = false;     // Catch: RuntimeException -> L15 Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
    L18:
        if (r7.c.i == true) goto L58;
        f r8 = r0.b(r3, true);     // Catch: Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
        T r5 = (T) e.a(r6.getName(), r8);
        if (r5 == null) goto L24;
        r5.updateSettings(null);     // Catch: Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
        return r5;
    L24:
        return (T) b(r6, r8);
    L58:
        return (T) b(r6, r0.b(r3, true));
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L25 InvocationTargetException -> L27 InstantiationException -> L31 IllegalAccessException -> L35 NoSuchMethodException -> L39 ClassNotFoundException -> L43
        r4 = false;
    L48:
        if (r2 == null) goto L52;
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", r2);
    L52:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题");
    L43:
        e = move-exception;
        ClassNotFoundException r9 = e;
        r9.printStackTrace();
        IEnsure r10 = (IEnsure) ServiceManager.getService(IEnsure.class);
        r2 = r9;
        if (r10 == null) goto L48;
        r10.ensureNotReachHere(r9, "获取settings实例失败，ClassNotFoundException");
        r2 = r9;
    L35:
        e = move-exception;
        IllegalAccessException r11 = e;
        r11.printStackTrace();
        IEnsure r12 = (IEnsure) ServiceManager.getService(IEnsure.class);
        r2 = r11;
        if (r12 == null) goto L48;
        r12.ensureNotReachHere(r11, "获取settings实例失败，IllegalAccessException");
        r2 = r11;
    L31:
        e = move-exception;
        InstantiationException r13 = e;
        r13.printStackTrace();
        IEnsure r14 = (IEnsure) ServiceManager.getService(IEnsure.class);
        r2 = r13;
        if (r14 == null) goto L48;
        r14.ensureNotReachHere(r13, "获取settings实例失败，InstantiationException");
        r2 = r13;
    L39:
        e = move-exception;
        NoSuchMethodException r15 = e;
        r15.printStackTrace();
        IEnsure r16 = (IEnsure) ServiceManager.getService(IEnsure.class);
        r2 = r15;
        if (r16 == null) goto L48;
        r16.ensureNotReachHere(r15, "获取settings实例失败，NoSuchMethodException");
        r2 = r15;
    L27:
        e = move-exception;
        InvocationTargetException r17 = e;
        r17.printStackTrace();
        IEnsure r18 = (IEnsure) ServiceManager.getService(IEnsure.class);
        r2 = r17;
        if (r18 == null) goto L48;
        r18.ensureNotReachHere(r17, "获取settings实例失败，InvocationTargetException");
        r2 = r17;
    L25:
        th = move-exception;
        throw th;
    }

    public static <T extends ISettings> ISettings b(Class<T> r4, f r5) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String r0 = r4.getName().concat("$$Impl");
        ClassLoader r6 = r4.getClassLoader();
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r1 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r2 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L35;
        Class<?> r7 = Class.forName(r0, true, r6);     // Catch: Throwable -> L8
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a(r0);     // Catch: Throwable -> L8
    L30:
        ISettings r8 = (ISettings) r7.getConstructor(new Class[]{f.class}).newInstance(new Object[]{r5});
        r8.updateSettings(null);
        return r8;
    L8:
        th = move-exception;
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r0);
    L12:
        throw th;
    L35:
        r7 = Class.forName(r0, true, r6);     // Catch: Throwable -> L17
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a(r0);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r2 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r0);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r7 = MiraPluginFix.forName(r0);
        goto L30
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public final synchronized String e(JSONObject r8, g37.d r9) {
        monitor-enter(this);
        String r0 = XmlPullParser.NO_NAMESPACE;
        if (j37.a.p == null) goto L12;
        ((ft9.c) j37.a.p).getClass();     // Catch: Throwable -> L14
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L12;
        String r1 = r8.keys().next();     // Catch: Throwable -> L14
        this.a.clear();     // Catch: Throwable -> L14
        Context r2 = a.getContext();     // Catch: Throwable -> L14
        h r3 = h.a(r2);     // Catch: Throwable -> L14
        String r4 = UUID.randomUUID().toString();     // Catch: Throwable -> L14
        String r5 = r9.c.a;     // Catch: Throwable -> L14
        SharedPreferences.Editor r6 = r3.a.edit();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r5) == false) goto L10;
        String r7 = "key_latest_update_token";
    L11:
        r6.putString(r7, r4).apply();     // Catch: Throwable -> L14
        f r10 = f.b(r2);     // Catch: Throwable -> L14
        r0 = r10.d(r9.c.a).getAppSettings().optString(r1, XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L14
        r10.h(r8, r9.c.a);     // Catch: Throwable -> L14
        goto L12
    L10:
        r7 = "key_latest_update_token_" + r5;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public final <T extends ISettings> T c(Class<T> r3, g37.d r4, String r5) {
        T r0 = (T) this.a.get(r3);
        if (r0 != null) goto L35;
        Settings r1 = (Settings) r3.getAnnotation(Settings.class);
        if (r1 != null) goto L7;
        String r2 = XmlPullParser.NO_NAMESPACE;
    L9:
        if (r5.equals(r2) == false) goto L33;
        ConcurrentHashMap<Class<? extends ISettings>, Object> r6 = this.b;
        monitor-enter(r6);
    L29:
        th = move-exception;
        throw th;
    L13:
        if (this.b.containsKey(r3) == false) goto L15;
        Object r7 = this.b.get(r3);     // Catch: Throwable -> L29
    L16:
        if (r7 != null) goto L18;
        r7 = new Object();     // Catch: Throwable -> L29
        this.b.put(r3, r7);     // Catch: Throwable -> L29
    L18:
        monitor-exit(r6);     // Catch: Throwable -> L29
        monitor-enter(r7);
        ISettings r8 = this.a.get(r3);     // Catch: Throwable -> L26
        if (r8 != null) goto L23;
        ISettings r9 = a(r3, r4);     // Catch: Throwable -> L26
        this.a.put(r3, r9);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r7);     // Catch: Throwable -> L26
        return (T) r9;
    L23:
        r9 = r8;
    L26:
        th = move-exception;
        throw th;
    L15:
        r7 = null;
        goto L16
    L33:
        throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + r2 + " - ");
    L7:
        r2 = r1.settingsId();
        goto L9
    L35:
        if (this.b.containsKey(r3) == false) goto L43;
        this.b.remove(r3);
        return r0;
    L43:
        return r0;
    }

    public final synchronized void d(SettingsData r7, g37.d r8, boolean r9) {
        monitor-enter(this);
        Iterator<ISettings> r0 = this.a.values().iterator();     // Catch: Throwable -> L14
    L5:
        if (r0.hasNext() == false) goto L7;
        r0.next().updateSettings(r7);     // Catch: Throwable -> L14
        goto L5
    L7:
        Context r1 = a.getContext();     // Catch: Throwable -> L14
        h r2 = h.a(r1);     // Catch: Throwable -> L14
        String r3 = r7.getToken();     // Catch: Throwable -> L14
        String r4 = r8.c.a;     // Catch: Throwable -> L14
        SharedPreferences.Editor r5 = r2.a.edit();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r4) == false) goto L10;
        String r6 = "key_latest_update_token";
    L11:
        r5.putString(r6, r3).apply();     // Catch: Throwable -> L14
        f.b(r1).f(r7, r8, r9);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r6 = "key_latest_update_token_" + r4;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
