package com.bytedance.mira.core;

import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.factory.InnerClassLoaderFactory;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.MethodUtils;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes21.dex */
public class ImagePluginClassLoader extends PluginClassLoader {
    private static final String TAG = "ImagePluginClassLoader";
    private static Method findClassMethod;
    private static Method findLoadedClassMethod;
    private static Method findResListMethod;
    private static Method findResMethod;
    private PathClassLoader innerClassloader;

    static {
        findClassMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findClass", new Class[]{String.class});
        findLoadedClassMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findLoadedClass", new Class[]{String.class});
        findResListMethod = MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "findResources", new Class[]{String.class});
        findResMethod = MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "findResource", new Class[]{String.class});
    }

    @Override // com.bytedance.mira.core.PluginClassLoader
    public ClassLoader getInnerClassloader() {
        return this.innerClassloader;
    }

    private Class<?> findClassByInner(String r100) {
        return (Class) findClassMethod.invoke(this.innerClassloader, new Object[]{r100});
    L4:
        return null;
    }

    private Class<?> findLoadedClassByInner(String r100) {
        return (Class) findLoadedClassMethod.invoke(this.innerClassloader, new Object[]{r100});
    L4:
        return null;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String r100) throws ClassNotFoundException {
        return findClassByInner(r100);
    }

    @Override // com.bytedance.mira.core.PluginClassLoader
    public Class<?> findClassFromCurrent(String r100) throws ClassNotFoundException {
        Class<?> r101 = findLoadedClassByInner(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return findClassByInner(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v6 */
    @Override // com.bytedance.mira.core.PluginClassLoader, dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String r110) {
        String r100 = findLibraryFromCurrent(r110);
        MiraLogger.i(MiraLogger.TAG_SO, "ImagePluginClassLoader findLibraryFromCurrent, name=" + r110 + ", libraryName=" + r100);
        boolean r101 = TextUtils.isEmpty(r100);
        ?? r102 = r100;
        if (r101 == false) goto L18;
        ClassLoader r103 = RuntimeManager.getRef().getApplicationClassLoader();     // Catch: Exception -> L16
        r102 = r100;
        if (r103 == null) goto L18;
        ?? r104 = r103 instanceof PluginClassLoader;     // Catch: Exception -> L16
        if (r104 == 0) goto L12;
        String r105 = (String) MethodUtils.invokeMethod(r103, "findLibraryFromCurrent", new Object[]{r110});     // Catch: Exception -> L16
        MiraLogger.i(MiraLogger.TAG_SO, "ImagePluginClassLoader loader.findLibrary, name=" + r110 + ", classLoader=" + r103);     // Catch: Exception -> L15
        r104 = r105;
    L25:
        goto L14
    L12:
        String r106 = (String) MethodUtils.invokeMethod(r103, "findLibrary", new Object[]{r110});     // Catch: Exception -> L16
        MiraLogger.i(MiraLogger.TAG_SO, "ImagePluginClassLoader loader.findLibrary, name=" + r110 + ", classLoader=" + r103);     // Catch: Exception -> L15
        r104 = r106;
    L14:
        r102 = r104;
    L16:
        r102 = r100;
    L18:
        if (TextUtils.isEmpty(r102) == false) goto L33;
        ClassLoader r107 = Mira.class.getClassLoader();     // Catch: Exception -> L24
        String r108 = (String) MethodUtils.invokeMethod(r107, "findLibrary", new Object[]{r110});     // Catch: Exception -> L24
        MiraLogger.i(MiraLogger.TAG_SO, "ImagePluginClassLoader laster.findLibrary, name=" + r110 + ", classLoader=" + r107);     // Catch: Exception -> L23
    L22:
        return r108;
    L34:
        return r102;
    L33:
        return r102;
    }

    @Override // com.bytedance.mira.core.PluginClassLoader
    public String findLibraryFromCurrent(String r100) {
        PathClassLoader r101 = this.innerClassloader;
        if (r101 != null) goto L6;
        return super.findLibrary(r100);
    L6:
        return r101.findLibrary(r100);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String r100) {
        PathClassLoader r101 = this.innerClassloader;     // Catch: Exception -> L7
        if (r101 != null) goto L6;
        return super.findResource(r100);
    L6:
        return (URL) findResMethod.invoke(r101, new Object[]{r100});
    L7:
        return null;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String r100) {
        PathClassLoader r101 = this.innerClassloader;     // Catch: Exception -> L7
        if (r101 != null) goto L6;
        return super.findResources(r100);
    L6:
        return (Enumeration) findResListMethod.invoke(r101, new Object[]{r100});
    L7:
        return null;
    }

    @Override // com.bytedance.mira.core.PluginClassLoader, java.lang.ClassLoader
    public Class<?> loadClass(String r100, boolean r101) throws ClassNotFoundException {
        Class<?> r102 = null;
        if (TextUtils.isEmpty(r100) == false) goto L22;
        return null;
    L22:
        r102 = findClassFromCurrent(r100);     // Catch: ClassNotFoundException -> L7
        e = null;
    L8:
        if (r102 != null) goto L14;
        ClassLoader r103 = Mira.class.getClassLoader();
        if (r103 == null) goto L14;
        r102 = r103.loadClass(r100);     // Catch: ClassNotFoundException -> L13
    L13:
        e = e;
    L14:
        if (r102 != null) goto L19;
        if (e == null) goto L19;
        throw new ClassNotFoundException(r100 + " not found in PluginClassLoader", e);
    L19:
        return r102;
    L7:
        e = e;
        goto L8
    }

    public ImagePluginClassLoader(String r100, String r101, String r102, ClassLoader r103) {
        super("", null, "", r103);
        PathClassLoader r104 = InnerClassLoaderFactory.buildInnerClassLoader(TAG, r100, r101, r102, r103);
        this.innerClassloader = r104;
        InnerClassLoaderFactory.safeUpdateClassLoaderParent(r104, this);
    }
}
