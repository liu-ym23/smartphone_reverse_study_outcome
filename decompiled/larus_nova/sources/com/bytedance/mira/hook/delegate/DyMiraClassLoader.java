package com.bytedance.mira.hook.delegate;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.core.PluginClassLoader;
import com.bytedance.mira.helper.ClassLoaderHelper;
import com.bytedance.mira.hook.MiraHook;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.PluginLoader;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.ReflectUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DyMiraClassLoader extends PathClassLoader implements MiraHook {
    private static final String TAG = "DyMiraClassLoader";
    private static final DyMiraClassLoader sInstance = null;
    private Method findResourceMethod;
    private Method findResourcesMethod;
    private ClassLoader pathClassLoader;

    @Override // com.bytedance.mira.hook.MiraHook
    public void onHookInstall() {
    }

    static {
        sInstance = new DyMiraClassLoader(Mira.class.getClassLoader());
    }

    public static synchronized ClassLoader getHostClassLoader() {
        monitor-enter(DyMiraClassLoader.class);
        DyMiraClassLoader r100 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(DyMiraClassLoader.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public DyMiraClassLoader(ClassLoader r100) {
        super("", "", r100);
        this.findResourcesMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findResources", new Class[]{String.class});
        this.findResourceMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findResource", new Class[]{String.class});
        this.pathClassLoader = r100;
    }

    public static synchronized boolean installHook(Application r100) {
        monitor-enter(DyMiraClassLoader.class);
        Context r101 = r100.getBaseContext();     // Catch: Throwable -> L31
        if (r101 != null) goto L10;
        MiraLogger.e(MiraLogger.TAG_INIT, "DyMiraClassLoader mBase is null");     // Catch: Throwable -> L31
        monitor-exit(DyMiraClassLoader.class);
        return false;
    L10:
        Object r102 = FieldUtils.readField(r101, "mPackageInfo");     // Catch: Throwable -> L31
        if (r102 != null) goto L15;
        MiraLogger.e(MiraLogger.TAG_INIT, "DyMiraClassLoader cl=" + r101.getClass());     // Catch: Throwable -> L31
        monitor-exit(DyMiraClassLoader.class);
        return false;
    L15:
        MiraLogger.d(MiraLogger.TAG_INIT, "DyMiraClassLoader patch: mBase cl=" + r101.getClass() + "; mPackageInfo cl=" + r102.getClass());     // Catch: Throwable -> L31
        ClassLoader r103 = (ClassLoader) FieldUtils.readField(r102, "mClassLoader");     // Catch: Throwable -> L31
        if (r103 != null) goto L22;
        MiraLogger.e(MiraLogger.TAG_INIT, "DyMiraClassLoader cl=" + r101.getClass() + "; mpi cl=" + r102.getClass());     // Catch: Throwable -> L31
        monitor-exit(DyMiraClassLoader.class);
        return false;
    L22:
        if ((r103 instanceof DyMiraClassLoader) == false) goto L25;
        monitor-exit(DyMiraClassLoader.class);
        return true;
    L25:
        DyMiraClassLoader r104 = sInstance;     // Catch: Throwable -> L31
        if (r104.getParent() == r103) goto L28;
        r104.setPathClassLoader(r103);     // Catch: Throwable -> L31
        ReflectUtils.updateClassLoaderParent(r104, r103);     // Catch: Throwable -> L31
        MiraLogger.d(MiraLogger.TAG_INIT, "DyMiraClassLoader patch: update instance parent classloader~");     // Catch: Throwable -> L31
    L28:
        FieldUtils.writeField(r102, "mClassLoader", r104);     // Catch: Throwable -> L31
        ThreadMethodProxy.currentThread().setContextClassLoader(r104);     // Catch: Throwable -> L31
        MiraLogger.d(MiraLogger.TAG_INIT, "DyMiraClassLoader patch: patch mClassLoader ok");     // Catch: Throwable -> L31
        monitor-exit(DyMiraClassLoader.class);
        return true;
    L31:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L35
        return false;
    L35:
        th = move-exception;
        throw th;
    }

    private void setPathClassLoader(ClassLoader r100) {
        this.pathClassLoader = r100;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String r100) throws ClassNotFoundException {
        return ClassLoaderHelper.findClass(r100);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String r100) {
        String r101 = super.findLibrary(r100);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        return r101;
    L5:
        Iterator r102 = new ConcurrentHashMap(PluginLoader.sCachedPluginClassLoader).entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        PluginClassLoader r103 = (PluginClassLoader) ((Map.Entry) r102.next()).getValue();
        String r104 = (String) MethodUtils.invokeMethod(r103, "findLibraryFromCurrent", new Object[]{r100});     // Catch: Exception -> L13
        MiraLogger.i(MiraLogger.TAG_SO, "DyMiraClassLoader laster.findLibrary, name=" + r100 + ", classLoader=" + r103);     // Catch: Exception -> L12
    L11:
        r101 = r104;
    L15:
        if (TextUtils.isEmpty(r101) == true) goto L7;
    L16:
        return r101;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String r100) {
        URL r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (this.pathClassLoader != null) goto L8;
        this.pathClassLoader = Mira.getAppContext().getClass().getClassLoader();
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

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String r100) {
        Enumeration<URL> r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (this.pathClassLoader != null) goto L8;
        this.pathClassLoader = Mira.getAppContext().getClass().getClassLoader();
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

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String r100, boolean r101) throws ClassNotFoundException {
        return super.loadClass(r100, r101);
    }
}
