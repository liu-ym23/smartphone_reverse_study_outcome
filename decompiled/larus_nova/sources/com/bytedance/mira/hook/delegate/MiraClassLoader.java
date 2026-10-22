package com.bytedance.mira.hook.delegate;

import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.core.PluginClassLoader;
import com.bytedance.mira.hook.MiraHook;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginLoader;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.NeedLoadPluginUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public class MiraClassLoader extends ClassLoader implements MiraHook {
    private static final String TAG = "MiraClassLoader";
    private static ClassLoader sHostClassLoader;
    private Method findClassMethod;
    private Method findLoadedClassMethod;
    private Method findResourceMethod;
    private Method findResourcesMethod;
    private ClassLoader pathClassLoader;

    @Override // com.bytedance.mira.hook.MiraHook
    public void onHookInstall() {
    }

    public static MiraClassLoader installHook() {
        ClassLoader r100 = Mira.getAppContext().getClassLoader();     // Catch: Exception -> L7
        sHostClassLoader = r100;     // Catch: Exception -> L7
        ClassLoader r101 = r100.getParent();     // Catch: Exception -> L7
        if ((r101 instanceof MiraClassLoader) == true) goto L13;
        MiraClassLoader r102 = new MiraClassLoader(r101, r100);     // Catch: Exception -> L7
        Field r103 = ClassLoader.class.getDeclaredField("parent");     // Catch: Exception -> L7
        r103.setAccessible(true);     // Catch: Exception -> L7
        r103.set(r100, r102);     // Catch: Exception -> L7
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraClassLoader.hook");     // Catch: Exception -> L7
        return r102;
    L13:
        return null;
    L7:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "MiraClassLoader hook failed.", e);
        return null;
    }

    public static ClassLoader getHostClassLoader() {
        return sHostClassLoader;
    }

    @Override // java.lang.ClassLoader
    public Class<?> findClass(String r100) throws ClassNotFoundException {
        Class<?> r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (this.pathClassLoader != null) goto L8;
        this.pathClassLoader = Mira.getAppContext().getClassLoader();
    L8:
        Method r102 = this.findLoadedClassMethod;
        if (r102 != null) goto L65;
        th = null;
    L15:
        if (r101 != null) goto L21;
        Method r103 = this.findClassMethod;
        if (r103 == null) goto L21;
        r101 = (Class) r103.invoke(this.pathClassLoader, new Object[]{r100});     // Catch: Throwable -> L20
    L20:
        th = th;
    L21:
        if (r101 != null) goto L30;
        Iterator r104 = new ConcurrentHashMap(PluginLoader.sCachedPluginClassLoader).entrySet().iterator();
    L24:
        if (r104.hasNext() == false) goto L30;
        r101 = ((PluginClassLoader) ((Map.Entry) r104.next()).getValue()).findClassFromCurrent(r100);     // Catch: Throwable -> L28
    L29:
        if (r101 == null) goto L24;
    L28:
        th = th;
    L30:
        if (r101 != null) goto L45;
        Iterator<Plugin> r105 = PluginManager.getInstance().listPluginConfigs().iterator();
    L33:
        if (r105.hasNext() == false) goto L45;
        Plugin r106 = r105.next();
        if (NeedLoadPluginUtil.needLoadPlugin(r106, r100) == false) goto L33;
        if (PluginLoader.sCachedPluginClassLoader.get(r106.mPackageName) != null) goto L39;
        PluginManager.getInstance().loadPlugin(r106.mPackageName);
    L39:
        PluginClassLoader r107 = PluginLoader.sCachedPluginClassLoader.get(r106.mPackageName);
        if (r107 == null) goto L33;
        r101 = r107.findClassFromCurrent(r100);     // Catch: Throwable -> L43
    L44:
        if (r101 == null) goto L33;
    L43:
        th = th;
    L45:
        if (r101 != null) goto L53;
        MiraParam r108 = MiraManager.getInstance().getParam();
        if (r108 == null) goto L53;
        Map<String, String> r109 = r108.getRedirectClassMap();
        if (r109 == null) goto L53;
        if (r109.containsKey(r100) == false) goto L53;
        r101 = Class.forName(r109.get(r100));
    L53:
        if (r101 != null) goto L58;
        if (th == null) goto L58;
        throw new ClassNotFoundException(r100 + " not found in MiraClassloader", th);
    L58:
        return r101;
    L65:
        r101 = (Class) r102.invoke(this.pathClassLoader, new Object[]{r100});     // Catch: Throwable -> L12
        th = null;
    L12:
        th = th;
        goto L15
    }

    @Override // java.lang.ClassLoader
    public URL findResource(String r100) {
        URL r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (this.pathClassLoader != null) goto L8;
        this.pathClassLoader = Mira.getAppContext().getClassLoader();
    L8:
        Method r102 = this.findResourceMethod;
        if (r102 != null) goto L30;
    L13:
        if (r101 == null) goto L15;
    L24:
        if (r101 == null) goto L27;
        return r101;
    L27:
        return super.findResource(r100);
    L15:
        if (this.findResourceMethod == null) goto L24;
        Iterator r103 = new ConcurrentHashMap(PluginLoader.sCachedPluginClassLoader).entrySet().iterator();
    L18:
        if (r103.hasNext() == false) goto L24;
        PluginClassLoader r104 = (PluginClassLoader) ((Map.Entry) r103.next()).getValue();
        r101 = (URL) this.findResourceMethod.invoke(r104, new Object[]{r100});     // Catch: Throwable -> L22
    L23:
        if (r101 == null) goto L18;
    L30:
        r101 = (URL) r102.invoke(this.pathClassLoader, new Object[]{r100});     // Catch: Throwable -> L12
        goto L13
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> findResources(String r100) throws IOException {
        Enumeration<URL> r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (this.pathClassLoader != null) goto L8;
        this.pathClassLoader = Mira.getAppContext().getClassLoader();
    L8:
        Method r102 = this.findResourcesMethod;
        if (r102 != null) goto L30;
    L13:
        if (r101 == null) goto L15;
    L24:
        if (r101 == null) goto L27;
        return r101;
    L27:
        return super.findResources(r100);
    L15:
        if (this.findResourcesMethod == null) goto L24;
        Iterator r103 = new ConcurrentHashMap(PluginLoader.sCachedPluginClassLoader).entrySet().iterator();
    L18:
        if (r103.hasNext() == false) goto L24;
        PluginClassLoader r104 = (PluginClassLoader) ((Map.Entry) r103.next()).getValue();
        r101 = (Enumeration) this.findResourcesMethod.invoke(r104, new Object[]{r100});     // Catch: Throwable -> L22
    L23:
        if (r101 == null) goto L18;
    L30:
        r101 = (Enumeration) r102.invoke(this.pathClassLoader, new Object[]{r100});     // Catch: Throwable -> L12
        goto L13
    }

    public MiraClassLoader(ClassLoader r100, ClassLoader r101) {
        super(r100);
        this.findClassMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findClass", new Class[]{String.class});
        this.findLoadedClassMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findLoadedClass", new Class[]{String.class});
        this.findResourcesMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findResources", new Class[]{String.class});
        this.findResourceMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findResource", new Class[]{String.class});
        this.pathClassLoader = r101;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String r100, boolean r101) throws ClassNotFoundException {
        return super.loadClass(r100, r101);
    }
}
