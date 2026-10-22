package com.bytedance.mira.core;

import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import dalvik.system.BaseDexClassLoader;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes21.dex */
public class PluginClassLoader extends BaseDexClassLoader {
    private static final String TAG = "PluginClassLoader";

    public ClassLoader getInnerClassloader() {
        return this;
    }

    public Class<?> findClassFromCurrent(String r100) throws ClassNotFoundException {
        Class<?> r101 = findLoadedClass(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return findClass(r100);
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
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String r110) {
        String r100 = findLibraryFromCurrent(r110);
        MiraLogger.i(MiraLogger.TAG_SO, "PluginClassLoader findLibraryFromCurrent, name=" + r110 + ", libraryName=" + r100);
        boolean r101 = TextUtils.isEmpty(r100);
        ?? r102 = r100;
        if (r101 == false) goto L18;
        ClassLoader r103 = RuntimeManager.getRef().getApplicationClassLoader();     // Catch: Exception -> L16
        r102 = r100;
        if (r103 == null) goto L18;
        ?? r104 = r103 instanceof PluginClassLoader;     // Catch: Exception -> L16
        if (r104 == 0) goto L12;
        String r105 = (String) MethodUtils.invokeMethod(r103, "findLibraryFromCurrent", new Object[]{r110});     // Catch: Exception -> L16
        MiraLogger.i(MiraLogger.TAG_SO, "PluginClassLoader loader.findLibrary, name=" + r110 + ", classLoader=" + r103);     // Catch: Exception -> L15
        r104 = r105;
    L25:
        goto L14
    L12:
        String r106 = (String) MethodUtils.invokeMethod(r103, "findLibrary", new Object[]{r110});     // Catch: Exception -> L16
        MiraLogger.i(MiraLogger.TAG_SO, "PluginClassLoader loader.findLibrary, name=" + r110 + ", classLoader=" + r103);     // Catch: Exception -> L15
        r104 = r106;
    L14:
        r102 = r104;
    L16:
        r102 = r100;
    L18:
        if (TextUtils.isEmpty(r102) == false) goto L33;
        ClassLoader r107 = Mira.class.getClassLoader();     // Catch: Exception -> L24
        String r108 = (String) MethodUtils.invokeMethod(r107, "findLibrary", new Object[]{r110});     // Catch: Exception -> L24
        MiraLogger.i(MiraLogger.TAG_SO, "PluginClassLoader laster.findLibrary, name=" + r110 + ", classLoader=" + r107);     // Catch: Exception -> L23
    L22:
        return r108;
    L34:
        return r102;
    L33:
        return r102;
    }

    public String findLibraryFromCurrent(String r100) {
        return super.findLibrary(r100);
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String r100) {
        URL r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L20;
        return null;
    L20:
        r101 = findResource(r100);     // Catch: Exception -> L7
    L8:
        if (r101 != null) goto L14;
        ClassLoader r102 = Mira.class.getClassLoader();
        if (r102 == null) goto L14;
        r101 = r102.getResource(r100);     // Catch: Exception -> L13
    L14:
        if (r101 == null) goto L17;
        return r101;
    L17:
        return super.getResource(r100);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String r100) throws IOException {
        Enumeration<URL> r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L20;
        return null;
    L20:
        r101 = findResources(r100);     // Catch: Exception -> L7
    L8:
        if (r101 != null) goto L14;
        ClassLoader r102 = Mira.class.getClassLoader();
        if (r102 == null) goto L14;
        r101 = r102.getResources(r100);     // Catch: Exception -> L13
    L14:
        if (r101 == null) goto L17;
        return r101;
    L17:
        return super.getResources(r100);
    }

    @Override // java.lang.ClassLoader
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
        throw new PluginClassNotFoundException(r100 + " not found in PluginClassLoader", e);
    L19:
        return r102;
    L7:
        e = e;
        goto L8
    }

    public PluginClassLoader(String r100, String r101, String r102, ClassLoader r103) {
        if (r101 != null) goto L4;
        PolarisFileWrapper r104 = null;
    L5:
        super(r100, r104, r102, r103);
        return;
    L4:
        r104 = new PolarisFileWrapper(r101);
        goto L5
    }
}
