package com.bytedance.mira.helper;

import android.app.ActivityThread;
import android.app.Application;
import android.app.LoadedApk;
import android.content.Context;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.UserHandle;
import android.view.Display;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class ContextImplHelper {
    private static final String TAG = "ContextImplHelper";
    private static Class<?> sContextImplClazz;
    private static volatile Constructor sContextImplConstructor;

    public ContextImplHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static boolean isActivityThreadDisplayDefault() {
        Object r100 = ActivityThreadHelper.currentActivityThread();     // Catch: Throwable -> L11
        Object r101 = FieldUtils.getField(ActivityThread.class, "mDisplayId").get(r100);     // Catch: Throwable -> L11
        if (r101 != null) goto L6;
        int r102 = 0;
    L7:
        if (r102 == 0) goto L16;
        return false;
    L16:
        return true;
    L6:
        r102 = ((Integer) r101).intValue();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ContextImplHelper isActivityThreadDisplayDefault Fail.", th);
        return true;
    }

    private static boolean isApplicationDisplayDefault() {
        Field r100 = FieldUtils.getField(sContextImplClazz, "mDisplay");     // Catch: Throwable -> L14
        if (r100 != null) goto L6;
        return true;
    L6:
        Object r101 = r100.get(FieldUtils.readField(Mira.getAppContext(), "mBase"));     // Catch: Throwable -> L14
        if (r101 != null) goto L9;
        return true;
    L9:
        if (((Display) r101).getDisplayId() == 0) goto L19;
        return false;
    L19:
        return true;
    L14:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ContextImplHelper isApplicationDisplayDefault Fail.", th);
        return true;
    }

    static {
        sContextImplClazz = INVOKESTATIC_com_bytedance_mira_helper_ContextImplHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ContextImpl");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ContextImplHelper ContextImpl Class Init Fail.", th);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_helper_ContextImplHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static Context createAppContext(Object r100) {
        MiraParam r101 = MiraManager.getInstance().getParam();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        return newCreateAppContext(r100);
    L12:
        return oldCreateAppContext(r100);
    L5:
        if (r101.isEnableOptCreateContextImpl() == false) goto L7;
        r102 = true;
        goto L8
    }

    public static void hackContextImplExternalDirs(Context r110) {
        Mira.getAppContext().getExternalFilesDir(null);     // Catch: Exception -> L26
        Context r100 = (Context) FieldUtils.readField(Mira.getAppContext(), "mBase");     // Catch: Exception -> L26
        if (OSUtil.isAndroidI_MR1Higher() == false) goto L12;
        if (OSUtil.isAndroidKLower() == false) goto L12;
        File r101 = (File) FieldUtils.readField(r100, "mExternalFilesDir");     // Catch: Exception -> L26
        if (r101 == null) goto L33;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, String.format("plugins/%s/files", new Object[]{r110.getPackageName()}));     // Catch: Exception -> L26
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101, String.format("plugins/%s/cache", new Object[]{r110.getPackageName()}));     // Catch: Exception -> L26
        FieldUtils.writeField(r110, "mExternalFilesDir", r102);     // Catch: Exception -> L26
        FieldUtils.writeField(r110, "mExternalCacheDir", r103);     // Catch: Exception -> L26
        MiraLogger.i(TAG, "hackExternalDirsInContextImpl, baseContext.mExternalFilesDir and baseContext.mExternalCacheDir");     // Catch: Exception -> L26
        return;
    L33:
        return;
    L12:
        if (OSUtil.isAndroidKHigher() == false) goto L35;
        File[] r104 = (File[]) FieldUtils.readField(r100, "mExternalFilesDirs");     // Catch: Exception -> L26
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.length <= 0) goto L37;
        File[] r105 = new File[r104.length];     // Catch: Exception -> L26
        File[] r106 = new File[r104.length];     // Catch: Exception -> L26
        int r111 = 0;
    L19:
        if (r111 >= r104.length) goto L24;
        File r112 = r104[r111];     // Catch: Exception -> L26
        if (r112 == null) goto L23;
        r105[r111] = new PolarisFileWrapper(r112, String.format("plugins/%s/files", new Object[]{r110.getPackageName()}));     // Catch: Exception -> L26
        r106[r111] = new PolarisFileWrapper(r112, String.format("plugins/%s/cache", new Object[]{r110.getPackageName()}));     // Catch: Exception -> L26
    L23:
        r111 = r111 + 1;     // Catch: Exception -> L26
        goto L19
    L24:
        FieldUtils.writeField(r110, "mExternalFilesDirs", r105);     // Catch: Exception -> L26
        FieldUtils.writeField(r110, "mExternalCacheDirs", r106);     // Catch: Exception -> L26
        MiraLogger.i(TAG, "hackExternalDirsInContextImpl, baseContext.mExternalFilesDir and baseContext.mExternalCacheDir");     // Catch: Exception -> L26
        return;
    L37:
        return;
    L35:
        return;
    L26:
        e = move-exception;
        MiraLogger.e(TAG, "hackExternalDirsInContextImpl failed.", e);
    }

    private static Context newCreateAppContext(Object r100) {
        if (OSUtil.isAndroidQ() == true) goto L5;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L16;
        return newCreateAppContextForHWMode(r100);
    L16:
        return oldCreateAppContext(r100);
    L5:
        if (OSUtil.isHuawei() == false) goto L11;
        if (isActivityThreadDisplayDefault() == false) goto L11;
        if (isApplicationDisplayDefault() == false) goto L11;
        r101 = true;
        goto L12
    }

    private static Context newCreateAppContextForHWMode(Object r110) {
    L8:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ContextImplHelper newCreateAppContextForHWMode Fail.", th);
        return null;
    L4:
        if (sContextImplConstructor != null) goto L6;
        Class<?> r100 = sContextImplClazz;     // Catch: Throwable -> L8
        sContextImplConstructor = r100.getDeclaredConstructor(new Class[]{r100, ActivityThread.class, LoadedApk.class, String.class, IBinder.class, UserHandle.class, Integer.TYPE, ClassLoader.class, String.class});     // Catch: Throwable -> L8
        sContextImplConstructor.setAccessible(true);     // Catch: Throwable -> L8
    L6:
        Context r101 = (Context) sContextImplConstructor.newInstance(new Object[]{null, ActivityThreadHelper.currentActivityThread(), r110, null, null, null, 0, null, null});     // Catch: Throwable -> L8
        setResources(r101, ((LoadedApk) r110).getResources());     // Catch: Throwable -> L8
        return r101;
    }

    private static Context oldCreateAppContext(Object r100) {
        Object r101 = ActivityThreadHelper.currentActivityThread();     // Catch: Throwable -> L5
        return (Context) MethodUtils.getAccessibleMethod(sContextImplClazz, "createAppContext", new Class[]{ActivityThread.class, LoadedApk.class}).invoke(null, new Object[]{r101, r100});
    L5:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ContextImplHelper oldCreateAppContext Fail.", th);
        return null;
    }

    public static void setOuterContext(Object r100, Application r101) {
        MethodUtils.getAccessibleMethod(sContextImplClazz, "setOuterContext", new Class[]{Context.class}).invoke(r100, new Object[]{r101});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ContextImplHelper setOuterContext Fail.", th);
    }

    private static void setResources(Object r100, Resources r101) {
        MethodUtils.getAccessibleMethod(sContextImplClazz, "setResources", new Class[]{Resources.class}).invoke(r100, new Object[]{r101});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ContextImplHelper setResources Fail.", th);
    }
}
