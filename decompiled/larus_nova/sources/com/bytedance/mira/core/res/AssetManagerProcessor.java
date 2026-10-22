package com.bytedance.mira.core.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mira.util.ResUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class AssetManagerProcessor {
    private static final String TAG = "AssetManagerProcessor";
    private static Map<String, Integer> sDefaultAssetPathMap;
    private LinkedHashMap<String, Integer> mAssetPathMapCache;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sDefaultAssetPathMap = new HashMap();
        List<String> r100 = ResUtil.getDefaultAssetPaths();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L12;
        Iterator<String> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();
        sDefaultAssetPathMap.put(r102, 0);
        goto L8
    L13:
        return;
    }

    public String getAssetPathCachesStr() {
        StringBuilder r100 = new StringBuilder();
        LinkedHashMap<String, Integer> r101 = this.mAssetPathMapCache;
        monitor-enter(r101);
        Iterator<Map.Entry<String, Integer>> r102 = this.mAssetPathMapCache.entrySet().iterator();     // Catch: Throwable -> L16
    L6:
        if (r102.hasNext() == false) goto L9;
        r100.append(r102.next());     // Catch: Throwable -> L16
        r100.append(",");     // Catch: Throwable -> L16
        goto L6
    L9:
        if (r100.length() <= 0) goto L13;
        String r103 = r100.substring(0, r100.length() - 1);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r103;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r100.toString();
    L16:
        th = move-exception;
        throw th;
    }

    public AssetManagerProcessor() {
        LinkedHashMap<String, Integer> r100 = new LinkedHashMap();
        this.mAssetPathMapCache = r100;
        r100.put(Mira.getAppContext().getApplicationInfo().sourceDir, 0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_core_res_AssetManagerProcessor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public boolean updateAssetManagerCachePath(String r100) {
        LinkedHashMap<String, Integer> r101 = this.mAssetPathMapCache;
        monitor-enter(r101);
        this.mAssetPathMapCache.put(r100, 0);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    private AssetManager appendAssetPath(AssetManager r100, String r110) {
        Method r101 = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", new Class[]{String.class});
        if (r101 == null) goto L14;
        int r102 = 3;
    L5:
        int r103 = r102 - 1;
        if (r102 < 0) goto L15;
        int r104 = ((Integer) r101.invoke(r100, new Object[]{r110})).intValue();     // Catch: Exception -> L12
        if (r104 == 0) goto L10;
        MiraLogger.i(MiraLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + r104 + ", path = " + r110);     // Catch: Exception -> L12
        goto L15
    L10:
        MiraLogger.e(MiraLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + r104);     // Catch: Exception -> L12
    L13:
        r102 = r103;
    L12:
        MiraLogger.e(MiraLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed.");
    L15:
        return r100;
    L14:
        MiraLogger.e(MiraLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed.");
        goto L15
    }

    private AssetManager appendAssetPathSafely(AssetManager r110, String r111) {
        int r100 = 3;
    L3:
        int r101 = r100 - 1;
        if (r100 < 0) goto L41;
        monitor-enter(r110);     // Catch: Exception -> L39
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r102 >= 3) goto L20;
    L18:
        th = move-exception;
        throw th;     // Catch: Exception -> L39
    L10:
        if (OSUtil.isAndroidLM() == false) goto L13;
        r103 = ((Integer) MethodUtils.invokeMethod(r110, "addAssetPathNative", new Object[]{r111}, new Class[]{String.class})).intValue();     // Catch: Throwable -> L18
    L15:
        if (r103 != 0) goto L20;
        r102 = r102 + 1;     // Catch: Throwable -> L18
        goto L8
    L13:
        if (OSUtil.isAndroidNMR1() == false) goto L15;
        r103 = ((Integer) MethodUtils.invokeMethod(r110, "addAssetPathNative", new Object[]{r111, Boolean.FALSE}, new Class[]{String.class, Boolean.TYPE})).intValue();     // Catch: Throwable -> L18
    L20:
        if (r103 != 0) goto L23;
        monitor-exit(r110);     // Catch: Throwable -> L18
        goto L41
    L23:
        Object r104 = FieldUtils.readField(r110, "mStringBlocks");     // Catch: Throwable -> L18
        if (r104 == null) goto L26;
        int r105 = Array.getLength(r104);     // Catch: Throwable -> L18
    L27:
        int r106 = ((Integer) MethodUtils.invokeMethod(r110, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L18
        Object r112 = Array.newInstance(r104.getClass().getComponentType(), r106);     // Catch: Throwable -> L18
        int r113 = 0;
    L28:
        if (r113 >= r106) goto L33;
        if (r113 >= r105) goto L31;
        Array.set(r112, r113, Array.get(r104, r113));     // Catch: Throwable -> L18
    L32:
        r113 = r113 + 1;     // Catch: Throwable -> L18
        goto L28
    L31:
        Array.set(r112, r113, MethodUtils.invokeConstructor(r104.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(r110, "getNativeStringBlock", new Object[]{Integer.valueOf(r113)}, new Class[]{Integer.TYPE})).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));     // Catch: Throwable -> L18
        goto L32
    L33:
        FieldUtils.writeField(r110, "mStringBlocks", r112);     // Catch: Throwable -> L18
        monitor-exit(r110);     // Catch: Throwable -> L18
        MiraLogger.w(MiraLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = " + r111);     // Catch: Exception -> L39
        goto L41
    L26:
        r105 = 0;
    L39:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = " + r111, e);
        r100 = r101;
    L41:
        return r110;
    }

    private AssetManager newAssetManager(AssetManager r110, String r111) {
        List<String> r100 = ResUtil.getAssetPaths(r110);
        ArrayList r101 = new ArrayList();
        StringBuilder r102 = new StringBuilder();
        Iterator<String> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        String r104 = r103.next();
        if (sDefaultAssetPathMap.containsKey(r104) == true) goto L4;
        if (this.mAssetPathMapCache.containsKey(r104) == true) goto L4;
        if (r104.equals(r111) == true) goto L4;
        r101.add(r104);
        goto L4
    L12:
        MiraLogger.d(MiraLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets");
    L49:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e);
        appendAssetPath(r110, r111);
    L61:
        MethodUtils.invokeMethod(r110, "ensureStringBlocks", new Object[0]);     // Catch: Exception -> L53
        MiraLogger.i(MiraLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");     // Catch: Exception -> L53
    L55:
        return r110;
    L53:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e);
        goto L55
    L14:
        if (r110.getClass().getName().equals("android.content.res.BaiduAssetManager") == false) goto L16;
        AssetManager r105 = (AssetManager) INVOKESTATIC_com_bytedance_mira_core_res_AssetManagerProcessor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L49
    L17:
        MiraLogger.i(MiraLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = " + r105);     // Catch: Exception -> L49
        LinkedHashMap<String, Integer> r106 = this.mAssetPathMapCache;     // Catch: Exception -> L49
        monitor-enter(r106);     // Catch: Exception -> L49
        Iterator<Map.Entry<String, Integer>> r107 = this.mAssetPathMapCache.entrySet().iterator();     // Catch: Throwable -> L46
    L21:
        if (r107.hasNext() == false) goto L25;
        Map.Entry<String, Integer> r108 = r107.next();     // Catch: Throwable -> L46
        if (sDefaultAssetPathMap.containsKey(r108.getKey()) == true) goto L21;
        r102.append(r108.getKey());     // Catch: Throwable -> L46
        appendAssetPath(r105, r108.getKey());     // Catch: Throwable -> L46
        goto L21
    L25:
        monitor-exit(r106);     // Catch: Throwable -> L46
    L27:
        if (r102.toString().contains(Mira.getAppContext().getApplicationInfo().sourceDir) == true) goto L29;
        appendAssetPath(r105, Mira.getAppContext().getApplicationInfo().sourceDir);     // Catch: Exception -> L49
        MiraLogger.e(MiraLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + sDefaultAssetPathMap.containsKey(Mira.getAppContext().getApplicationInfo().sourceDir));     // Catch: Exception -> L49
    L29:
        r102.append(r111);     // Catch: Exception -> L49
        appendAssetPath(r105, r111);     // Catch: Exception -> L49
        if (r101.isEmpty() == true) goto L36;
        Iterator r109 = r101.iterator();     // Catch: Exception -> L49
    L33:
        if (r109.hasNext() == false) goto L36;
        String r112 = (String) r109.next();     // Catch: Exception -> L49
        r102.append(r112);     // Catch: Exception -> L49
        appendAssetPath(r105, r112);     // Catch: Exception -> L49
    L36:
        if (OSUtil.isAndroidL_M() == true) goto L38;
    L45:
        r110 = r105;
        goto L61
    L38:
        if (r102.toString().toLowerCase().contains("webview") == true) goto L45;
        Resources r113 = Mira.getAppContext().getResources();     // Catch: Exception -> L43
        String r114 = Mira.getAppContext().createPackageContext(r113.getString(r113.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir;     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r114) == true) goto L45;
        appendAssetPath(r105, r114);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e);     // Catch: Exception -> L49
    L46:
        th = move-exception;
        throw th;     // Catch: Exception -> L49
    L16:
        r105 = (AssetManager) AssetManager.class.newInstance();     // Catch: Exception -> L49
        goto L17
    }

    public AssetManager updateAssetManager(AssetManager r100, String r101) {
        if (OSUtil.isAndroidLHigher() == true) goto L5;
        AssetManager r102 = newAssetManager(r100, r101);
    L11:
        updateAssetManagerCachePath(r101);
        MiraLogger.i(MiraLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager, newAssetManager=" + r102 + ", assets=" + ResUtil.getAssetPathsStr(r102));
        return r102;
    L5:
        if (OSUtil.isAndroidLN() == false) goto L9;
        r102 = appendAssetPathSafely(r100, r101);
        if (ResUtil.containsPath(r102, r101) == true) goto L11;
        r102 = appendAssetPath(r100, r101);
        goto L11
    L9:
        r102 = appendAssetPath(r100, r101);
        goto L11
    }
}
