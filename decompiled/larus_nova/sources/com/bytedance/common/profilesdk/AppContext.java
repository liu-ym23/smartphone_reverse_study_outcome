package com.bytedance.common.profilesdk;

import android.app.Application;
import android.content.Context;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class AppContext {
    static Context sAppContext;
    static WeakReference<List<String>> sDexClassNames;
    static String sInstructionSet;
    static String sPackageDexPath;
    static String sPackageName;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static Context getContext() {
        Context r100 = sAppContext;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new RuntimeException("Please make sure Deximage.init(...) first");
    }

    public static List<String> getDexClassNames() {
        WeakReference<List<String>> r100 = sDexClassNames;
        if (r100 != null) goto L5;
        List<String> r101 = DexImageLoader.dumpClassesFromDexFile(getPackageDexPath(), false);
        sDexClassNames = new WeakReference(r101);
        return r101;
    L5:
        List<String> r102 = r100.get();
        if (r102 != null) goto L10;
        List<String> r103 = DexImageLoader.dumpClassesFromDexFile(getPackageDexPath(), false);
        sDexClassNames = new WeakReference(r103);
        return r103;
    L10:
        return r102;
    }

    public static String getInstructionSet() {
        if (sInstructionSet != null) goto L10;
        Method r100 = INVOKESTATIC_com_bytedance_common_profilesdk_AppContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]);     // Catch: Exception -> L6
        r100.setAccessible(true);     // Catch: Exception -> L6
        sInstructionSet = (String) r100.invoke(null, new Object[0]);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return "";
    L10:
        return sInstructionSet;
    }

    public static String getPackageDexPath() {
        if (sPackageDexPath != null) goto L6;
        sPackageDexPath = getContext().getPackageCodePath();
    L6:
        return sPackageDexPath;
    }

    public static String getPackageImagePath() {
        return new PolarisFileWrapper(getPackageDexPath()).getParentFile().getAbsolutePath() + "/oat/" + getInstructionSet() + "/base.art";
    }

    public static String getPackageName() {
        if (sPackageName != null) goto L6;
        sPackageName = getContext().getPackageName();
    L6:
        return sPackageName;
    }

    public static File getProfilesDir() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(getCacheDir(), "app_profiles");
        if (r100.exists() == true) goto L5;
        r100.mkdir();
    L5:
        return r100;
    }

    public static Context getApplicationContext() {
        return getContext().getApplicationContext();
    }

    public static File getCacheDir() {
        return getContext().getCodeCacheDir();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_profilesdk_AppContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void init(Context r100) {
        if (sAppContext == null) goto L5;
        return;
    L5:
        if ((r100 instanceof Application) == false) goto L8;
        sAppContext = r100;
        return;
    L8:
        if (r100.getApplicationContext() == null) goto L10;
        sAppContext = r100.getApplicationContext();
        return;
    L10:
        Logger.w("Context.getApplicationContext() return null, cache Context");
        sAppContext = r100;
    }
}
