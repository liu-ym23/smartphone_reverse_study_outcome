package com.bytedance.unitm.util;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class SystemProperties {
    private static Method sysPropGet;
    private static Method sysPropGetInt;
    private static Method sysPropGetLong;
    private static Method sysPropSet;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        Method[] r100 = INVOKESTATIC_com_bytedance_unitm_util_SystemProperties_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethods();     // Catch: ClassNotFoundException -> L17
        int r101 = r100.length;     // Catch: ClassNotFoundException -> L17
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L28;
        Method r103 = r100[r102];     // Catch: ClassNotFoundException -> L17
        String r104 = r103.getName();     // Catch: ClassNotFoundException -> L17
        if (r104.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L8;
        sysPropGet = r103;     // Catch: ClassNotFoundException -> L17
    L16:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r104.equals("set") == false) goto L11;
        sysPropSet = r103;     // Catch: ClassNotFoundException -> L17
        goto L16
    L11:
        if (r104.equals("getLong") == false) goto L14;
        sysPropGetLong = r103;     // Catch: ClassNotFoundException -> L17
        goto L16
    L14:
        if (r104.equals("getInt") == false) goto L16;
        sysPropGetInt = r103;     // Catch: ClassNotFoundException -> L17
        goto L16
    L28:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    private SystemProperties() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_unitm_util_SystemProperties_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String get(String r100, String r101) {
        Method r102 = sysPropGet;
        if (r102 != null) goto L15;
        return r101;
    L15:
        return (String) r102.invoke(null, new Object[]{r100, r101});
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static int getInt(String r100, int r101) {
        Method r102 = sysPropGetInt;
        if (r102 != null) goto L15;
        return r101;
    L15:
        return ((Integer) r102.invoke(null, new Object[]{r100, Integer.valueOf(r101)})).intValue();
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static long getLong(String r100, long r101) {
        Method r102 = sysPropGetLong;
        if (r102 != null) goto L15;
        return r101;
    L15:
        return ((Long) r102.invoke(null, new Object[]{r100, Long.valueOf(r101)})).longValue();
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void set(String r100, String r101) {
        sysPropSet.invoke(null, new Object[]{r100, r101});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6 IllegalArgumentException -> L8
    L15:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
