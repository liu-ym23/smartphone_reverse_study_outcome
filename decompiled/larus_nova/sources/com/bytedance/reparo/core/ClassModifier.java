package com.bytedance.reparo.core;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.chameleon.GeckoConst;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class ClassModifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Field f267308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Field f267309b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Field f267310c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f267311d = 0;

    /* JADX INFO: loaded from: classes3.dex */
    public static class ClassVerifingException extends Exception {
        public ClassVerifingException() {
        }

        public ClassVerifingException(String r100) {
            super(r100);
        }

        public ClassVerifingException(Throwable r100) {
            super(r100);
        }

        public ClassVerifingException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    static {
        Field r100 = Class.class.getDeclaredField("classLoader");     // Catch: Exception -> L4
        f267308a = r100;     // Catch: Exception -> L4
        r100.setAccessible(true);     // Catch: Exception -> L4
        Field r101 = Class.class.getDeclaredField("accessFlags");     // Catch: Exception -> L4
        f267309b = r101;     // Catch: Exception -> L4
        r101.setAccessible(true);     // Catch: Exception -> L4
        Field r102 = Class.class.getDeclaredField("status");     // Catch: Exception -> L4
        f267310c = r102;     // Catch: Exception -> L4
        r102.setAccessible(true);     // Catch: Exception -> L4
        a();     // Catch: Exception -> L4
        f267311d = ((Integer) r102.get(WandTrick.class)).intValue();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("com.bytedance.reparo.core.WandTrick");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("com.bytedance.reparo.core.WandTrick");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.reparo.core.WandTrick");
    L12:
        throw th;
    L34:
        Class.forName("com.bytedance.reparo.core.WandTrick");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("com.bytedance.reparo.core.WandTrick");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.reparo.core.WandTrick");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("com.bytedance.reparo.core.WandTrick");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public static void b(Class r100) throws IllegalAccessException {
        if (r100 != null) goto L4;
        return;
    L4:
        Field r101 = f267309b;
        int r102 = ((Integer) r101.get(r100)).intValue();
        if ((r102 & 1) != 0) goto L14;
        int r103 = (r102 & (-8)) | 1;
        monitor-enter(r100);
        r101.set(r100, Integer.valueOf(r103));     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void d(Class<?> r100) throws Exception {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return;
    L5:
        Method[] r101 = e97.g.f(r100).f562915b;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        Method r104 = r101[r103];
        WandTrick.e().changeMethodProtectedToPublic(r104);
        r103 = r103 + 1;
        goto L6
    }

    public static void e(Class r100) throws Exception {
        int r101 = f267309b.getInt(r100);
        if ((r101 & 524288) != 0) goto L14;
        WandTrick.e().changeClinitToPreverified(r100);
        Method[] r102 = e97.g.f(r100).f562915b;
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L7;
        Method r106 = r102[r105];
        WandTrick.e().changeMethodToPreverified(r106);
        r105 = r105 + 1;
        goto L5
    L7:
        Constructor<?>[] r107 = r100.getDeclaredConstructors();
        int r108 = r107.length;
    L8:
        if (r104 >= r108) goto L10;
        Constructor<?> r109 = r107[r104];
        WandTrick.e().changeMethodToPreverified(r109);
        r104 = r104 + 1;
        goto L8
    L10:
        f267309b.set(r100, Integer.valueOf(r101 | 524288));
        b97.a.a("ensurePreverifiedMethods:".concat(r100.getName()));
        return;
    }

    public static void c(Class r100, boolean r101) throws Exception {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 26) goto L5;
        return;
    L5:
        int r103 = f267311d;
        if (r101 == false) goto L8;
        int r104 = 0;
        int r105 = 0;
    L13:
        monitor-enter(r100);
        Field r106 = f267310c;     // Catch: Throwable -> L25
        int r107 = ((Integer) r106.get(r100)).intValue();     // Catch: Throwable -> L25
        if (r101 == true) goto L21;
        if (r107 == r104) goto L20;
        if (r107 != r105) goto L21;
    L20:
        throw new ClassVerifingException();     // Catch: Throwable -> L25
    L21:
        if (r103 <= r107) goto L23;
        r106.set(r100, Integer.valueOf(r103));     // Catch: Throwable -> L25
        e(r100);     // Catch: Throwable -> L25
        k.e(GeckoConst.HOTFIX, "status bumped to " + r103 + ", class: " + r100.getName());     // Catch: Throwable -> L25
    L23:
        monitor-exit(r100);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L8:
        if (r102 != 27) goto L10;
        r103 = r103 - 3;
    L11:
        r104 = r103 - 3;
        r105 = r103 - 1;
        goto L13
    L10:
        r103 = r103 - 2;
        goto L11
    }
}
