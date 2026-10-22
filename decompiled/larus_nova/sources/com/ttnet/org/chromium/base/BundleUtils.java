package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraMonitor;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public class BundleUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LOADED_SPLITS_KEY = "split_compat_loaded_splits";
    private static final String TAG = "BundleUtils";
    private static final SimpleArrayMap<String, ClassLoader> sCachedClassLoaders = null;
    private static final Map<String, ClassLoader> sInflationClassLoaders = null;
    private static Boolean sIsBundle;
    private static SplitCompatClassLoader sSplitCompatClassLoaderInstance;
    private static final Object sSplitLock = null;
    private static ArrayList<String> sSplitsToRestore;

    /* JADX INFO: loaded from: classes41.dex */
    public static class SplitCompatClassLoader extends ClassLoader {
        public SplitCompatClassLoader() {
            super(ContextUtils.getApplicationContext().getClassLoader());
        }

        private void restoreSplitsClassLoaders() {
            Iterator r100 = BundleUtils.access$100().iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            String r101 = (String) r100.next();
            if (BundleUtils.access$000().containsKey(r101) == true) goto L4;
            BundleUtils.registerSplitClassLoaderForInflation(r101);
            goto L4
        L8:
            BundleUtils.access$102(null);
        }

        private Class<?> checkSplitsClassLoaders(String r100) throws ClassNotFoundException {
            Iterator r101 = BundleUtils.access$000().values().iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            return INVOKEVIRTUAL_com_ttnet_org_chromium_base_BundleUtils$SplitCompatClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass((ClassLoader) r101.next(), r100);
        L9:
            return null;
        }

        @Override // java.lang.ClassLoader
        public Class<?> findClass(String r100) throws ClassNotFoundException {
            Class<?> r101 = checkSplitsClassLoaders(r100);
            if (r101 == null) goto L6;
            return r101;
        L6:
            if (BundleUtils.access$100() == null) goto L13;
            if (r100.startsWith("android.") == true) goto L13;
            restoreSplitsClassLoaders();
            Class<?> r102 = checkSplitsClassLoaders(r100);
            if (r102 == null) goto L13;
            return r102;
        L13:
            throw new ClassNotFoundException(r100);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKEVIRTUAL_com_ttnet_org_chromium_base_BundleUtils$SplitCompatClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.loadClass(r101);
        }
    }

    public BundleUtils() {
    }

    public static /* synthetic */ Class access$001(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static Context createIsolatedSplitContext(Context r100, String r101) {
        return r100;
    }

    public static String getNativeLibraryPath(String r100, String r101) {
        return "";
    }

    static {
        sSplitLock = new Object();
        sCachedClassLoaders = new SimpleArrayMap();
        sInflationClassLoaders = Collections.synchronizedMap(new ArrayMap());
    }

    public static ClassLoader getSplitCompatClassLoader() {
        if (sSplitCompatClassLoaderInstance != null) goto L6;
        sSplitCompatClassLoaderInstance = new SplitCompatClassLoader();
    L6:
        return sSplitCompatClassLoaderInstance;
    }

    public static boolean isBundle() {
        if (BuildConfig.BUNDLES_SUPPORTED == true) goto L7;
        return false;
    L7:
        return sIsBundle.booleanValue();
    }

    public static boolean isBundleForNative() {
        return isBundle();
    }

    public static /* synthetic */ Map access$000() {
        return sInflationClassLoaders;
    }

    public static /* synthetic */ ArrayList access$100() {
        return sSplitsToRestore;
    }

    public static Object getSplitContextLock() {
        return sSplitLock;
    }

    public static boolean isolatedSplitsEnabled() {
        return BuildConfig.ISOLATED_SPLITS_ENABLED;
    }

    public static /* synthetic */ ArrayList access$102(ArrayList r100) {
        sSplitsToRestore = r100;
        return r100;
    }

    public static String getNativeLibraryPath(String r100) {
        return getNativeLibraryPath(r100, "");
    }

    private static boolean isApplicationContext(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Application) == true) goto L6;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static ClassLoader registerSplitClassLoaderForInflation(String r100) {
        Map<String, ClassLoader> r101 = sInflationClassLoaders;
        ClassLoader r102 = r101.get(r100);
        if (r102 != null) goto L6;
        ClassLoader r103 = createIsolatedSplitContext(ContextUtils.getApplicationContext(), r100).getClassLoader();
        r101.put(r100, r103);
        return r103;
    L6:
        return r102;
    }

    public static void restoreLoadedSplits(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        sSplitsToRestore = r100.getStringArrayList(LOADED_SPLITS_KEY);
    }

    public static void saveLoadedSplits(Bundle r100) {
        r100.putStringArrayList(LOADED_SPLITS_KEY, new ArrayList(sInflationClassLoaders.keySet()));
    }

    public static void setIsBundle(boolean r100) {
        sIsBundle = Boolean.valueOf(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_ttnet_org_chromium_base_BundleUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static boolean canLoadClass(ClassLoader r100, String r101) {
        INVOKESTATIC_com_ttnet_org_chromium_base_BundleUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101, false, r100);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        return false;
    }

    public static void checkContextClassLoader(Context r100, Activity r101) {
        ClassLoader r102 = r101.getClass().getClassLoader();
        if (r102 == r100.getClassLoader()) goto L6;
        Log.w(TAG, "Mismatched ClassLoaders between Activity and context (fixing): %s", new Object[]{r101.getClass()});
        replaceClassLoader(r100, r102);
        return;
    }

    public static Context createContextForInflation(final Context r100, String r101) {
        if (isIsolatedSplitInstalled(r100, r101) == true) goto L5;
        return r100;
    L5:
        final ClassLoader r102 = registerSplitClassLoaderForInflation(r101);
        return new AnonymousClass1(r100, r102);
    }

    private static String getSplitApkLibraryPath(String r100, String r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        ApplicationInfo r102 = ContextUtils.getApplicationContext().getApplicationInfo();
        String[] r103 = ApiHelperForO.getSplitNames(r102);
        if (r103 != null) goto L8;
        return null;
    L8:
        int r104 = Arrays.binarySearch(r103, r101);
        if (r104 >= 0) goto L16;
        return null;
    L16:
        return r102.splitSourceDirs[r104] + "!/lib/" + ((String) r102.getClass().getField(MiraMonitor.KEY_PRIMARY_CPU_ABI).get(r102)) + HTTP.URL_DEFAULT + System.mapLibraryName(r100);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean isIsolatedSplitInstalled(Context r100, String r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        String[] r102 = ApiHelperForO.getSplitNames(r100.getApplicationInfo());
        if (r102 != null) goto L8;
        return false;
    L8:
        if (Arrays.asList(r102).contains(r101) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static Object newInstance(Context r100, String r101) {
        Context r102 = ContextUtils.getApplicationContext();
        if (r102 != null) goto L5;
    L12:
        return INVOKEVIRTUAL_com_ttnet_org_chromium_base_BundleUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClassLoader(), r101).newInstance();
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if (canLoadClass(r102.getClassLoader(), r101) == false) goto L12;
        r100 = r102;
        goto L12
    }

    public static void replaceClassLoader(Context r100, ClassLoader r101) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L10:
        Field r102 = r100.getClass().getDeclaredField("mClassLoader");     // Catch: ReflectiveOperationException -> L7
        r102.setAccessible(true);     // Catch: ReflectiveOperationException -> L7
        r102.set(r100, r101);     // Catch: ReflectiveOperationException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("Error setting ClassLoader.", e);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_base_BundleUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$001(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$001(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
