package com.bytedance.mira.helper;

import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.core.PluginClassLoader;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginLoader;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.util.NeedLoadPluginUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ClassLoaderHelper {
    private static List<Plugin> sAllPlugins;
    private static boolean sEnableUseOpt;
    private static Map<String, String> sRedirectClassMaps;

    public ClassLoaderHelper() {
    }

    public static Class<?> classForName(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    L5:
        return findClass(r100);
    }

    public static Class<?> findClass(String r100) throws ClassNotFoundException {
        if (sEnableUseOpt == false) goto L7;
        return findClassWithNew(r100);
    L7:
        return findClassWithOld(r100);
    }

    private static Class<?> findClassWithNew(String r100) throws ClassNotFoundException {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L35;
        List<Plugin> r101 = sAllPlugins;
        ArrayList r102 = new ArrayList();
        Iterator<Plugin> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        Plugin r104 = r103.next();
        if (NeedLoadPluginUtil.needLoadPlugin(r104, r100) == false) goto L8;
        r102.add(r104);
        goto L8
    L13:
        if (r102.isEmpty() == true) goto L17;
        ArrayList r105 = new ArrayList();
        Class<?> r106 = findClassByPlugins(r102, r100, false, r105);
        if (r106 != null) goto L18;
        r106 = findClassByPlugins(r105, r100, true);
    L18:
        if (r106 != null) goto L24;
        Map<String, String> r107 = sRedirectClassMaps;
        if (r107 == null) goto L24;
        if (r107.containsKey(r100) == false) goto L24;
        r106 = Class.forName(r107.get(r100));
    L24:
        if (r106 == null) goto L27;
        return r106;
    L27:
        throw new ClassNotFoundException(r100.concat(" ##not found in Plugin##"));
    L17:
        r106 = findClassByPlugins(r101, r100, false);
        goto L18
    L35:
        return null;
    }

    private static Class<?> findClassWithOld(String r100) throws ClassNotFoundException {
        Class<?> r101 = null;
        if (r100 != null) goto L5;
    L42:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L42;
        Iterator r102 = new ConcurrentHashMap(PluginLoader.sCachedPluginClassLoader).entrySet().iterator();
        Throwable th10 = null;
    L9:
        if (r102.hasNext() == false) goto L15;
        r101 = ((PluginClassLoader) ((Map.Entry) r102.next()).getValue()).findClassFromCurrent(r100);     // Catch: Throwable -> L13
    L14:
        if (r101 == null) goto L9;
    L13:
        th10 = th;
    L15:
        if (r101 != null) goto L30;
        Iterator<Plugin> r103 = PluginManager.getInstance().listPluginConfigs().iterator();
    L18:
        if (r103.hasNext() == false) goto L30;
        Plugin r104 = r103.next();
        if (NeedLoadPluginUtil.needLoadPlugin(r104, r100) == false) goto L18;
        if (PluginLoader.sCachedPluginClassLoader.get(r104.mPackageName) != null) goto L24;
        PluginManager.getInstance().loadPlugin(r104.mPackageName);
    L24:
        PluginClassLoader r105 = PluginLoader.sCachedPluginClassLoader.get(r104.mPackageName);
        if (r105 == null) goto L18;
        r101 = r105.findClassFromCurrent(r100);     // Catch: Throwable -> L28
    L29:
        if (r101 == null) goto L18;
    L28:
        th10 = th;
    L30:
        if (r101 != null) goto L38;
        MiraParam r106 = MiraManager.getInstance().getParam();
        if (r106 == null) goto L38;
        Map<String, String> r107 = r106.getRedirectClassMap();
        if (r107 == null) goto L38;
        if (r107.containsKey(r100) == false) goto L38;
        r101 = Class.forName(r107.get(r100));
    L38:
        if (r101 == null) goto L41;
        return r101;
    L41:
        throw new ClassNotFoundException(r100.concat(" ##not found in Plugin##"), th10);
    }

    public static void inject(boolean r100, Map<String, String> r101) {
        sEnableUseOpt = r100;
        sRedirectClassMaps = r101;
        sAllPlugins = PluginManager.getInstance().listPluginConfigs();
    }

    private static Class<?> findClassByPlugins(List<Plugin> r100, String r101, boolean r102) {
        return findClassByPlugins(r100, r101, r102, null);
    }

    private static Class<?> findClassByPlugins(List<Plugin> r100, String r101, boolean r102, List<Plugin> r103) {
        Map<String, PluginClassLoader> r104 = PluginLoader.sCachedPluginClassLoader;
        Iterator<Plugin> r105 = r100.iterator();
        Class<?> r106 = null;
    L4:
        if (r105.hasNext() == false) goto L17;
        Plugin r107 = r105.next();
        String r108 = r107.mPackageName;
        PluginClassLoader r109 = r104.get(r108);
        if (r109 != null) goto L11;
        if (r102 == false) goto L9;
        PluginManager.getInstance().loadPlugin(r108);
        r109 = r104.get(r108);
        goto L11
    L9:
        if (r103 == null) goto L4;
        r103.add(r107);
    L11:
        if (r109 == null) goto L4;
        r106 = r109.findClassFromCurrent(r101);     // Catch: Throwable -> L15
    L16:
        if (r106 == null) goto L4;
    L17:
        return r106;
    }
}
