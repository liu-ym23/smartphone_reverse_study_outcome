package com.ss.android.ttvecamera.framework;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ttvecamera.TELogUtils;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class TEReflectUtil {
    private static final String TAG = "TEReflectUtil";

    public TEReflectUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_ttvecamera_framework_TEReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    private static boolean matches(Class<?>[] r100, Object[] r101) {
        if (r100 != null) goto L5;
    L22:
        if (r101 != null) goto L24;
        return true;
    L24:
        if (r101.length == 0) goto L33;
        return false;
    L33:
        return true;
    L5:
        if (r100.length == 0) goto L22;
        if (r101 != null) goto L9;
    L21:
        return false;
    L9:
        if (r100.length != r101.length) goto L21;
        int r102 = 0;
    L13:
        if (r102 >= r100.length) goto L20;
        Object r103 = r101[r102];
        if (r103 == null) goto L19;
        if (r100[r102].isAssignableFrom(r103.getClass()) == true) goto L19;
        return false;
    L19:
        r102 = r102 + 1;
        goto L13
    L20:
        return true;
    }

    private static Method findMethod(Class<? extends Object> r100, String r101, Object[] r102) {
        Method[] r103 = r100.getDeclaredMethods();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L10;
        Method r106 = r103[r105];
        if (r106.getName().equals(r101) == false) goto L9;
        if (matches(r106.getParameterTypes(), r102) == false) goto L9;
        return r106;
    L9:
        r105 = r105 + 1;
        goto L3
    L10:
        Class<? super Object> r107 = r100.getSuperclass();
        if (r107 != null) goto L13;
        return null;
    L13:
        return findMethod(r107, r101, r102);
    }

    public static <T> T invoke(Object r100, String r101, Object[] r102) {
        Method r103 = findMethod(r100.getClass(), r101, r102);     // Catch: Exception -> L4
        r103.setAccessible(true);     // Catch: Exception -> L4
        return (T) r103.invoke(r100, r102);
    L4:
        e = move-exception;
        TELogUtils.w(TAG, "couldn't invoke " + r101 + " on " + r100 + ", " + e);
        return null;
    }

    public static <T> T invokeStatic(String r100, String r101, Object[] r102) {
        Method r103 = findMethod(INVOKESTATIC_com_ss_android_ttvecamera_framework_TEReflectUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100), r101, r102);     // Catch: Exception -> L5
        r103.setAccessible(true);     // Catch: Exception -> L5
        return (T) r103.invoke(null, r102);
    L5:
        e = move-exception;
        TELogUtils.w(TAG, "couldn't invoke " + r101 + ", " + e);
        return null;
    }
}
