package com.larus.mirabridge.impl.lancet;

import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.core.PluginClassLoader;
import com.bytedance.mira.helper.ClassLoaderHelper;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginLoader;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.util.NeedLoadPluginUtil;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import hl9.a;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class MiraPluginFix {
    private static final String TAG = "MiraPluginFix";

    public MiraPluginFix() {
    }

    private static Class<?> findClass(String r100) throws ClassNotFoundException {
        Iterator r101 = new ConcurrentHashMap(PluginLoader.sCachedPluginClassLoader).entrySet().iterator();
        Class<?> r102 = null;
        Throwable th10 = null;
    L4:
        if (r101.hasNext() == false) goto L10;
        r102 = ((PluginClassLoader) ((Map.Entry) r101.next()).getValue()).findClassFromCurrent(r100);     // Catch: Throwable -> L8
    L9:
        if (r102 == null) goto L4;
    L8:
        th10 = th;
    L10:
        if (r102 != null) goto L27;
        Iterator<Plugin> r103 = PluginManager.getInstance().listPluginConfigs().iterator();
    L13:
        if (r103.hasNext() == false) goto L27;
        Plugin r104 = r103.next();
        if (needLoadPlugin(r104, r100) == false) goto L13;
        if (PluginLoader.sCachedPluginClassLoader.get(r104.mPackageName) != null) goto L21;
        PThreadPoolExecutor r105 = a.f485700a;
        if (a.a(r104.mPackageName) == false) goto L21;
        PluginManager.getInstance().loadPlugin(r104.mPackageName);
    L21:
        PluginClassLoader r106 = PluginLoader.sCachedPluginClassLoader.get(r104.mPackageName);
        if (r106 == null) goto L13;
        r102 = r106.findClassFromCurrent(r100);     // Catch: Throwable -> L25
    L26:
        if (r102 == null) goto L13;
    L25:
        th10 = th;
    L27:
        if (r102 != null) goto L35;
        MiraParam r107 = MiraManager.getInstance().getParam();
        if (r107 == null) goto L35;
        Map<String, String> r108 = r107.getRedirectClassMap();
        if (r108 == null) goto L35;
        if (r108.containsKey(r100) == false) goto L35;
        r102 = Class.forName(r108.get(r100));
    L35:
        if (r102 == null) goto L38;
        return r102;
    L38:
        throw new ClassNotFoundException(r100 + " ##not found in Plugin##", th10);
    }

    public static Class<?> forName(String r100) throws ClassNotFoundException {
        if (el9.a.a() == false) goto L7;
        return ClassLoaderHelper.findClass(r100);
    L7:
        return findClass(r100);
    }

    public static Class<?> loadClass(String r100) throws ClassNotFoundException {
        if (el9.a.a() == false) goto L7;
        return ClassLoaderHelper.findClass(r100);
    L7:
        return findClass(r100);
    }

    private static boolean needLoadPlugin(Plugin r100, String r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return NeedLoadPluginUtil.needLoadPlugin(r100, r101);
    }
}
