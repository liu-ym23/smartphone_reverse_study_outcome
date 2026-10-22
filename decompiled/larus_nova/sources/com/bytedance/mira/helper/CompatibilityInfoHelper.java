package com.bytedance.mira.helper;

import android.app.LoadedApk;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import com.bytedance.mira.Mira;
import com.bytedance.mira.compat.q.DoubleReflector;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.factory.LoadedApkFactory;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class CompatibilityInfoHelper {
    private static Class sClass;
    private static Object sDefaultCompatibilityInfo;
    private static volatile Object sHostCompatibilityInfo;

    public CompatibilityInfoHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static Class clazz() {
        if (sClass != null) goto L6;
        sClass = INVOKESTATIC_com_bytedance_mira_helper_CompatibilityInfoHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.res.CompatibilityInfo");     // Catch: ClassNotFoundException -> L7
    L6:
        return sClass;
    }

    public static Object getDefaultCompatibilityInfo() {
        if (sDefaultCompatibilityInfo != null) goto L6;
        sDefaultCompatibilityInfo = FieldUtils.readStaticField(clazz(), "DEFAULT_COMPATIBILITY_INFO");     // Catch: IllegalAccessException -> L7
    L6:
        return sDefaultCompatibilityInfo;
    }

    public static Object getHostCompatibilityInfo() {
        if (sHostCompatibilityInfo != null) goto L13;
        Object r100 = ActivityThreadHelper.currentActivityThread();     // Catch: Exception -> L14
        ApplicationInfo r101 = Mira.getAppContext().getApplicationInfo();     // Catch: Exception -> L14
        if (OSUtil.isAndroidHHigher() == false) goto L8;
        Object r102 = MethodUtils.getAccessibleMethod(r100.getClass(), "getPackageInfoNoCheck", new Class[]{ApplicationInfo.class, clazz()}).invoke(r100, new Object[]{r101, null});     // Catch: Exception -> L14
    L9:
        Method r103 = DoubleReflector.getMethod(r102.getClass(), "getCompatibilityInfo", new Class[0]);     // Catch: Exception -> L14
        r103.setAccessible(true);     // Catch: Exception -> L14
        sHostCompatibilityInfo = r103.invoke(r102, new Object[0]);     // Catch: Exception -> L14
        if (sHostCompatibilityInfo != null) goto L13;
        sHostCompatibilityInfo = getDefaultCompatibilityInfo();     // Catch: Exception -> L14
        goto L13
    L8:
        r102 = MethodUtils.invokeMethod(r100, "getPackageInfoNoCheck", new Object[]{r101});     // Catch: Exception -> L14
    L13:
        return sHostCompatibilityInfo;
    }

    public static Object getHostCompatibilityInfoNew() {
        if (sHostCompatibilityInfo != null) goto L12;
        LoadedApk r100 = LoadedApkFactory.getLoadedApk(Mira.getAppContext().getApplicationInfo().packageName);     // Catch: Exception -> L13
        if (r100 != null) goto L7;
        CompatibilityInfo r101 = null;
    L8:
        sHostCompatibilityInfo = r101;     // Catch: Exception -> L13
        if (sHostCompatibilityInfo != null) goto L12;
        sHostCompatibilityInfo = getDefaultCompatibilityInfo();     // Catch: Exception -> L13
        goto L12
    L7:
        r101 = r100.getCompatibilityInfo();     // Catch: Exception -> L13
    L12:
        return sHostCompatibilityInfo;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_helper_CompatibilityInfoHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
