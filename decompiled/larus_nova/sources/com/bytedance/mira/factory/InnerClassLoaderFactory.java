package com.bytedance.mira.factory;

import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
public class InnerClassLoaderFactory {
    private static SharedPreferences sPreferences;

    public InnerClassLoaderFactory() {
    }

    private static String SafeGet(String r100) {
        if (sPreferences != null) goto L6;
        sPreferences = Mira.getAppContext().getSharedPreferences("plugin_oat_file_info", 0);
    L6:
        return sPreferences.getString(r100, null);
    }

    private static void SafePut(String r100, String r101) {
        if (sPreferences != null) goto L5;
        sPreferences = Mira.getAppContext().getSharedPreferences("plugin_oat_file_info", 0);
    L5:
        sPreferences.edit().putString(r100, r101).apply();
    }

    public static void safeUpdateClassLoaderParent(ClassLoader r100, ClassLoader r101) {
        Field r102 = FieldUtils.getField(ClassLoader.class, "parent");     // Catch: Exception -> L6
        if (r102 == null) goto L9;
        r102.set(r100, r101);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    private static void clearMark(String r100, String r101, String r102) {
        if (OSUtil.isAndroidS() == true) goto L5;
        return;
    L5:
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == false) goto L10;
        SafePut(r101, null);
        MiraLogger.i(MiraLogger.TAG_LOAD, r100 + " clearMark do for apk:" + r101);
        return;
    }

    private static void markAndClearBuildProduct(String r100, String r101, String r110) {
        if (OSUtil.isAndroidS() == true) goto L5;
        return;
    L5:
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == false) goto L31;
        MiraParam r102 = MiraManager.getInstance().getParam();
        if (SafeGet(r101) != null) goto L10;
        boolean r103 = true;
    L12:
        if (r102 != null) goto L14;
    L15:
        if (r103 == false) goto L17;
        MiraLogger.i(MiraLogger.TAG_LOAD, r100 + " markAndClearBuildProduct do nothing for apk:" + r101);
    L28:
        SafePut(r101, r110);
        return;
    L17:
        if (Build.VERSION.SDK_INT < 26) goto L19;
        String r104 = Dex2OatHelper.ODEX_SUFFIX;
    L20:
        String r105 = r110 + File.separator + Dex2OatHelper.getOatFileName(r101);
        String r106 = r105.replace(r104, Dex2OatHelper.VDEX_SUFFIX);
        PolarisFileWrapper r107 = new PolarisFileWrapper(r105);
        PolarisFileWrapper r108 = new PolarisFileWrapper(r106);
        if (r107.exists() == false) goto L24;
        MiraLogger.i(MiraLogger.TAG_LOAD, r100 + " markAndClearBuildProduct do del odex:" + r105 + " >>> " + r107.delete());
    L24:
        if (r108.exists() == false) goto L26;
        MiraLogger.i(MiraLogger.TAG_LOAD, r100 + " markAndClearBuildProduct do del vdex:" + r106 + " >>> " + r108.delete());
    L26:
        MiraLogger.i(MiraLogger.TAG_LOAD, r100 + " markAndClearBuildProduct do del for apk:" + r101);
        goto L28
    L19:
        r104 = Dex2OatHelper.DEX_SUFFIX;
        goto L20
    L14:
        if (r102.withForceClear() == true) goto L17;
    L10:
        r103 = false;
        goto L12
    }

    public static PathClassLoader buildInnerClassLoader(String r110, String r111, String r112, String r113, ClassLoader r114) {
        if (OSUtil.isAndroidLM() == false) goto L10;
        PathClassLoader r100 = new PathClassLoader("", r113, r114);     // Catch: Exception -> L6
        Object r101 = FieldUtils.getField(BaseDexClassLoader.class, "pathList").get(r100);     // Catch: Exception -> L6
        Method r102 = MethodUtils.getAccessibleMethod(r101.getClass(), "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class});     // Catch: Exception -> L6
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L6
        r103.add(new PolarisFileWrapper(r111));     // Catch: Exception -> L6
        FieldUtils.getField(r101.getClass(), "dexElements").set(r101, (Object[]) r102.invoke(r101, new Object[]{r103, new PolarisFileWrapper(r112), new ArrayList()}));     // Catch: Exception -> L6
        MiraLogger.i(MiraLogger.TAG_LOAD, r110 + " buildInnerClassLoader isAndroidLM, create PathClassLoader by makeDexElements success~");     // Catch: Exception -> L6
        return r100;
    L6:
        e = move-exception;
        MiraLogger.i(MiraLogger.TAG_LOAD, r110 + " buildInnerClassLoader isAndroidLM, create PathClassLoader by makeDexElements fail! >>> " + Log.getStackTraceString(e));
        return new PathClassLoader(r111, r113, r114);
    L10:
        if (OSUtil.isAndroidN() == false) goto L12;
    L23:
        markAndClearBuildProduct(r110, r111, r112);     // Catch: Exception -> L18
        PathClassLoader r115 = new PathClassLoader("", r113, null);     // Catch: Exception -> L18
        Object r104 = FieldUtils.getField(BaseDexClassLoader.class, "pathList").get(r115);     // Catch: Exception -> L18
        MethodUtils.getAccessibleMethod(r104.getClass(), "addDexPath", new Class[]{String.class, File.class}).invoke(r104, new Object[]{r111, new PolarisFileWrapper(r112)});     // Catch: Exception -> L18
        clearMark(r110, r111, r112);     // Catch: Exception -> L18
        MiraLogger.i(MiraLogger.TAG_LOAD, r110 + " buildInnerClassLoader isAndroidN or isAndroidS, create PathClassLoader by addDexPath success~");     // Catch: Exception -> L18
        return r115;
    L18:
        e = move-exception;
        MiraLogger.i(MiraLogger.TAG_LOAD, r110 + " buildInnerClassLoader isAndroidN or isAndroidS, create PathClassLoader by addDexPath fail! >>> " + Log.getStackTraceString(e));
        return new PathClassLoader(r111, r113, null);
    L12:
        if (OSUtil.isAndroidSHigher() == true) goto L23;
        MiraLogger.i(MiraLogger.TAG_LOAD, r110 + " buildInnerClassLoader isNotAndroidN, create PathClassLoader by new success~");
        return new PathClassLoader(r111, r113, null);
    }
}
