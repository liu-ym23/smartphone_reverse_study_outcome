package com.bytedance.mira.util;

import android.R;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import com.bytedance.mira.Mira;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.log.MiraLogger;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class ResUtil {
    private static final String SPLIT_COMMA = " , ";
    private static String sWebViewApkPath;

    public ResUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static List<String> getDefaultAssetPaths() {
        AssetManager r100 = (AssetManager) AssetManager.class.newInstance();     // Catch: Exception -> L4
    L7:
        return getAssetPaths(r100);
    L4:
        e = move-exception;
        MiraLogger.e("Execute 'AssetManager.class.newInstance()' failed. ", e);
        r100 = null;
        goto L7
    }

    private static String getWebViewApkPath() {
        if (sWebViewApkPath != null) goto L9;
        Class r100 = INVOKESTATIC_com_bytedance_mira_util_ResUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.webkit.WebViewFactory");     // Catch: Exception -> L6
        MethodUtils.invokeStaticMethod(r100, "getWebViewContextAndSetProvider", new Object[0]);     // Catch: Exception -> L6
        sWebViewApkPath = ((PackageInfo) MethodUtils.invokeStaticMethod(r100, "getLoadedPackageInfo", new Object[0])).applicationInfo.sourceDir;     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        return sWebViewApkPath;
    }

    private static Resources getResourcesForTheme() {
        if (ProcessHelper.isMainProcess(Mira.getAppContext()) == true) goto L7;
        return null;
    L7:
        return Mira.getAppContext().getResources();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_util_ResUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static List<String> getAssetPaths(AssetManager r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L23;
        return r101;
    L23:
    L20:
        th = move-exception;
        MiraLogger.e("GetAssetsPaths error. ", th);
        th.printStackTrace();
    L22:
        return r101;
    L6:
        if (OSUtil.isAndroidPHigher() == false) goto L14;
        Object[] r102 = (Object[]) MethodUtils.invokeMethod(r100, "getApkAssets", new Object[0]);     // Catch: Throwable -> L20
        if (r102 == null) goto L22;
        if (r102.length <= 0) goto L22;
        int r103 = r102.length;     // Catch: Throwable -> L20
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L22;
        r101.add((String) MethodUtils.invokeMethod(r102[r104], "getAssetPath", new Object[0]));     // Catch: Throwable -> L20
        r104 = r104 + 1;     // Catch: Throwable -> L20
        goto L12
    L14:
        int r105 = ((Integer) MethodUtils.invokeMethod(r100, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L20
        int r106 = 0;
    L15:
        if (r106 >= r105) goto L22;
        r106 = r106 + 1;     // Catch: Throwable -> L20
        String r107 = (String) MethodUtils.invokeMethod(r100, "getCookieName", new Object[]{Integer.valueOf(r106)});     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r107) == true) goto L15;
        r101.add(r107);     // Catch: Throwable -> L20
        goto L15
    }

    public static String getAssetPathsStr(AssetManager r100) {
        return list2String(getAssetPaths(r100));
    }

    public static int getAssetsCount(AssetManager r100) {
    L10:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L4:
        if (OSUtil.isAndroidPHigher() == false) goto L9;
        Object[] r101 = (Object[]) MethodUtils.invokeMethod(r100, "getApkAssets", new Object[0]);     // Catch: Exception -> L10
        if (r101 != null) goto L15;
        return 0;
    L15:
        return r101.length;
    L9:
        return ((Integer) MethodUtils.invokeMethod(r100, "getStringBlockCount", new Object[0])).intValue();
    }

    public static boolean isTranslucent(ActivityInfo r100) {
        Bundle r101 = r100.metaData;
        if (r101 == null) goto L7;
        if (r101.getBoolean("isTranslucent", false) == false) goto L7;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L21;
        Resources r103 = getResourcesForTheme();
        if (r103 != null) goto L19;
        return false;
    L19:
        TypedValue r104 = new TypedValue();
        Resources.Theme r105 = r103.newTheme();
        r105.applyStyle(r100.getThemeResource(), true);
        r105.resolveAttribute(R.attr.windowIsTranslucent, r104, true);
        TypedArray r106 = r105.obtainStyledAttributes(r104.resourceId, new int[]{R.attr.windowIsTranslucent});
        boolean r107 = r106.getBoolean(0, false);
        r106.recycle();
        return r107;
    L21:
        return r102;
    L7:
        if (r100.getThemeResource() == 16973839) goto L14;
        if (r100.getThemeResource() == 16973840) goto L14;
        if (r100.getThemeResource() == 16973841) goto L14;
        r102 = false;
        goto L15
    }

    public static String list2String(List<String> r100) {
        StringBuilder r101 = new StringBuilder("[");
        if (r100 != null) goto L5;
    L11:
        r101.append("]");
        return r101.toString();
    L5:
        if (r100.size() <= 0) goto L11;
        Iterator<String> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.append(r102.next());
        r101.append(SPLIT_COMMA);
        goto L8
    L10:
        r101.delete(r101.lastIndexOf(SPLIT_COMMA), r101.length());
        goto L11
    }

    public static void presetWebViewAsset(ApplicationInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT <= 23) goto L19;
        String r101 = getWebViewApkPath();
        if (TextUtils.isEmpty(r101) == true) goto L18;
        String[] r102 = r100.sharedLibraryFiles;
        if (r102 != null) goto L11;
        int r103 = 0;
    L12:
        int r104 = r103 + 1;
        String[] r105 = new String[r104];
        if (r102 == null) goto L15;
        System.arraycopy(r102, 0, r105, 0, r104);
    L15:
        r105[r104 - 1] = r101;
        r100.sharedLibraryFiles = r105;
        return;
    L11:
        r103 = r102.length;
        goto L12
    L18:
        return;
    }

    public static boolean containsPath(AssetManager r100, String r101) {
    L20:
        th = move-exception;
        MiraLogger.e("containsPath error. ", th);
    L22:
        return false;
    L4:
        if (OSUtil.isAndroidPHigher() == false) goto L15;
        Object[] r102 = (Object[]) MethodUtils.invokeMethod(r100, "getApkAssets", new Object[0]);     // Catch: Throwable -> L20
        if (r102 == null) goto L22;
        if (r102.length <= 0) goto L22;
        int r103 = r102.length;     // Catch: Throwable -> L20
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L22;
        if (TextUtils.equals((String) MethodUtils.invokeMethod(r102[r104], "getAssetPath", new Object[0]), r101) == true) goto L13;
        r104 = r104 + 1;     // Catch: Throwable -> L20
        goto L10
    L13:
        return true;
    L15:
        int r105 = ((Integer) MethodUtils.invokeMethod(r100, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L20
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L22;
        r106 = r106 + 1;     // Catch: Throwable -> L20
        if (TextUtils.equals((String) MethodUtils.invokeMethod(r100, "getCookieName", new Object[]{Integer.valueOf(r106)}), r101) == false) goto L16;
        return true;
    }
}
