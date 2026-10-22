package com.volcengine.zeus;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.MethodUtils;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class NativePluginClassLoader extends PluginClassLoader {
    private static final String TAG = "NativePluginClassLoader";
    private static final Method findClassMethod = null;
    private static final Method findLoadedClassMethod = null;
    private static final Method findResListMethod = null;
    private static final Method findResMethod = null;
    private final ClassLoader hostClassLoader;
    private final PathClassLoader mInnerClassLoader;

    static {
        findClassMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findClass", new Class[]{String.class});
        findLoadedClassMethod = MethodUtils.getAccessibleMethod(ClassLoader.class, "findLoadedClass", new Class[]{String.class});
        findResListMethod = MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "findResources", new Class[]{String.class});
        findResMethod = MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "findResource", new Class[]{String.class});
    }

    @Override // com.volcengine.zeus.PluginClassLoader
    public ClassLoader getInnerClassLoader() {
        return this.mInnerClassLoader;
    }

    private Class<?> findClassByInner(String r100) throws ClassNotFoundException {
        return (Class) findClassMethod.invoke(this.mInnerClassLoader, new Object[]{r100});
    L4:
        th = move-exception;
        throw new ClassNotFoundException("Class Not In FindClass By Inner", th);
    }

    private Class<?> findLoadedClassByInner(String r100) {
        return (Class) findLoadedClassMethod.invoke(this.mInnerClassLoader, new Object[]{r100});
    L4:
        return null;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String r100) {
        PathClassLoader r101 = this.mInnerClassLoader;
        if (r101 != null) goto L6;
        return super.findLibrary(r100);
    L6:
        return r101.findLibrary(r100);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String r100) {
        PathClassLoader r101 = this.mInnerClassLoader;     // Catch: Throwable -> L7
        if (r101 != null) goto L6;
        return super.findResource(r100);
    L6:
        return (URL) findResMethod.invoke(r101, new Object[]{r100});
    L7:
        return null;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String r100) {
        PathClassLoader r101 = this.mInnerClassLoader;     // Catch: Throwable -> L7
        if (r101 != null) goto L6;
        return super.findResources(r100);
    L6:
        return (Enumeration) findResListMethod.invoke(r101, new Object[]{r100});
    L7:
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_NativePluginClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
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

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String r100, boolean r101) throws ClassNotFoundException {
        HashSet<String> r102 = this.allPluginClasses;
        ClassNotFoundException e100 = null;
        Class<?> r103 = null;
        e100 = null;
        if (r102 != null) goto L5;
    L45:
        Class<?> r104 = findLoadedClassByInner(r100);     // Catch: ClassNotFoundException -> L14
        if (r104 == null) goto L39;
    L16:
        ClassNotFoundException r105 = e100;
        r103 = r104;
        ClassNotFoundException r106 = r105;
    L17:
        StringBuilder r107 = new StringBuilder("loadClass from :\n");
        if (r103 != null) goto L29;
        List<ClassLoader> r108 = this.otherPluginClassLoader;
        if (r108 == null) goto L29;
        Iterator<ClassLoader> r109 = r108.iterator();
    L23:
        if (r109.hasNext() == false) goto L29;
        r103 = INVOKEVIRTUAL_com_volcengine_zeus_NativePluginClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r109.next(), r100);     // Catch: ClassNotFoundException -> L27
    L27:
        e = move-exception;
        r106 = handleException(r107, r106, e);
    L29:
        if (r103 == null) goto L41;
    L34:
        if (r103 != null) goto L38;
        if (r106 == null) goto L37;
        throw r106;
    L37:
        throw new ClassNotFoundException(r100 + " class not found in PluginClassLoader");
    L38:
        return r103;
    L41:
        r103 = INVOKEVIRTUAL_com_volcengine_zeus_NativePluginClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.hostClassLoader, r100);     // Catch: ClassNotFoundException -> L32
    L32:
        e = move-exception;
        r106 = handleException(r107, r106, e);
        goto L34
    L39:
        r104 = findClassByInner(r100);     // Catch: ClassNotFoundException -> L12
    L12:
        e100 = e;
    L14:
        e = move-exception;
        e100 = e;
        r104 = null;
        goto L16
    L5:
        if (r102.contains(r100) == true) goto L45;
        r106 = null;
        goto L17
    }

    private ClassNotFoundException handleException(StringBuilder r100, ClassNotFoundException r101, ClassNotFoundException r102) {
        if (r101 == null) goto L6;
        r101.addSuppressed(r102);
        return r101;
    L6:
        return r102;
    }

    public NativePluginClassLoader(String r100, File r101, String r102, List<ClassLoader> r103) {
        super("", null, "", r103);
        this.hostClassLoader = NativePluginClassLoader.class.getClassLoader();
        PathClassLoader r104 = b.a(TAG, r100, r101, r102, BaseDexClassLoader.getSystemClassLoader().getParent());
        this.mInnerClassLoader = r104;
        Field r105 = FieldUtils.getField(ClassLoader.class, "parent");     // Catch: Exception -> L7
        if (r105 == null) goto L10;
        r105.set(r104, this);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }
}
