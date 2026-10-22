package zpc;

import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Field> f573284a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Method> f573285b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Constructor> f573286c = null;

    static {
        f573284a = new HashMap();
        f573285b = new HashMap();
        f573286c = new HashMap();
        new HashMap();
        FieldUtils.writeField(b.class, "classLoader", null);     // Catch: Exception -> L5
        ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
    }

    public static Constructor a(Class<?> r100, Class<?>... r101) {
        String r102 = d(r100, "clinit", r101);
        Map<String, Constructor> r103 = f573286c;
        monitor-enter(r103);
        Constructor r104 = (Constructor) ((HashMap) r103).get(r102);     // Catch: Throwable -> L29
        monitor-exit(r103);     // Catch: Throwable -> L29
        if (r104 != null) goto L9;
        Constructor<?> r105 = r100.getDeclaredConstructor(r101);     // Catch: Throwable -> L26
        if (r105 != null) goto L15;
    L17:
        if (r105 == null) goto L25;
        monitor-enter(r103);     // Catch: Throwable -> L26
        ((HashMap) r103).put(r102, r105);     // Catch: Throwable -> L22
        monitor-exit(r103);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L25:
        return r105;
    L15:
        if (r105.isAccessible() == true) goto L17;
        r105.setAccessible(true);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", new Object[]{r100.getName()}), th);
        return null;
    L9:
        if (r104.isAccessible() == true) goto L11;
        r104.setAccessible(true);
    L11:
        return r104;
    L29:
        th = move-exception;
        throw th;
    }

    public static Field b(Class<?> r100, String r101) {
        String r102 = r100.getName() + "#" + r101;
        Map<String, Field> r103 = f573284a;
        monitor-enter(r103);
        Field r104 = (Field) ((HashMap) r103).get(r102);     // Catch: Throwable -> L29
        monitor-exit(r103);     // Catch: Throwable -> L29
        if (r104 != null) goto L9;
        Field r105 = r100.getDeclaredField(r101);     // Catch: Throwable -> L26
        if (r105 != null) goto L15;
    L17:
        if (r105 == null) goto L25;
        monitor-enter(r103);     // Catch: Throwable -> L26
        ((HashMap) r103).put(r102, r105);     // Catch: Throwable -> L22
        monitor-exit(r103);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L25:
        return r105;
    L15:
        if (r105.isAccessible() == true) goto L17;
        r105.setAccessible(true);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", new Object[]{r100.getName(), r101}), th);
        return null;
    L9:
        if (r104.isAccessible() == true) goto L11;
        r104.setAccessible(true);
    L11:
        return r104;
    L29:
        th = move-exception;
        throw th;
    }

    public static Method c(Class<?> r100, String r101, Class<?>... r102) {
        String r103 = d(r100, r101, r102);
        Map<String, Method> r104 = f573285b;
        monitor-enter(r104);
        Method r105 = (Method) ((HashMap) r104).get(r103);     // Catch: Throwable -> L29
        monitor-exit(r104);     // Catch: Throwable -> L29
        if (r105 != null) goto L9;
        Method r106 = r100.getDeclaredMethod(r101, r102);     // Catch: Throwable -> L26
        if (r106 != null) goto L15;
    L17:
        if (r106 == null) goto L25;
        monitor-enter(r104);     // Catch: Throwable -> L26
        ((HashMap) r104).put(r103, r106);     // Catch: Throwable -> L22
        monitor-exit(r104);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L25:
        return r106;
    L15:
        if (r106.isAccessible() == true) goto L17;
        r106.setAccessible(true);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", new Object[]{r100.getName(), r101}), th);
        return null;
    L9:
        if (r105.isAccessible() == true) goto L11;
        r105.setAccessible(true);
    L11:
        return r105;
    L29:
        th = move-exception;
        throw th;
    }

    public static String d(Class<?> r100, String r101, Class<?>... r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.getName());
        r103.append("#");
        r103.append(r101);
        if (r102.length <= 0) goto L7;
        int r104 = r102.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L9;
        r103.append(r102[r105].getName());
        r103.append("#");
        r105 = r105 + 1;
    L9:
        return r103.toString();
    L7:
        r103.append(Void.class.getName());
        goto L9
    }
}
