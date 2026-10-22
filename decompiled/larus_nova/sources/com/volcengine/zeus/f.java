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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class f extends PluginClassLoader {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f462696c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f462697d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f462698e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f462699f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f462700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PathClassLoader f462701b;

    static {
        f462696c = MethodUtils.getAccessibleMethod(ClassLoader.class, "findClass", new Class[]{String.class});
        f462697d = MethodUtils.getAccessibleMethod(ClassLoader.class, "findLoadedClass", new Class[]{String.class});
        f462698e = MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "findResources", new Class[]{String.class});
        f462699f = MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "findResource", new Class[]{String.class});
    }

    @Override // com.volcengine.zeus.PluginClassLoader
    public final ClassLoader getInnerClassLoader() {
        return this.f462701b;
    }

    @Override // com.volcengine.zeus.PluginClassLoader, dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Class<?> findClass(String r100) throws ClassNotFoundException {
        ClassNotFoundException r101 = null;
        Class<?> r102 = (Class) f462697d.invoke(this.f462701b, new Object[]{r100});     // Catch: Throwable -> L5
    L6:
        if (r102 != null) goto L15;
        r102 = (Class) f462696c.invoke(this.f462701b, new Object[]{r100});     // Catch: Throwable -> L9
    L9:
        th = move-exception;
    L12:
        e = move-exception;
        r101 = e;
        goto L15
    L11:
        throw new ClassNotFoundException("Class Not In FindClass By Inner", th);     // Catch: ClassNotFoundException -> L12
    L15:
        if (r102 != null) goto L26;
        List<ClassLoader> r103 = this.otherPluginClassLoader;
        if (r103 == null) goto L26;
        Iterator<ClassLoader> r104 = r103.iterator();
    L20:
        if (r104.hasNext() == false) goto L26;
        r102 = a(r104.next(), r100);     // Catch: ClassNotFoundException -> L24
    L24:
        e = move-exception;
        r101 = b(r101, e);
    L26:
        if (r102 == null) goto L44;
    L31:
        if (r102 != null) goto L35;
        if (r101 == null) goto L34;
        throw r101;
    L34:
        throw new ClassNotFoundException(r100 + " class not found in SpeedPluginClassLoader");
    L35:
        return r102;
    L44:
        r102 = a(this.f462700a, r100);     // Catch: ClassNotFoundException -> L29
    L29:
        e = move-exception;
        r101 = b(r101, e);
    L5:
        r102 = null;
        goto L6
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String r100) {
        PathClassLoader r101 = this.f462701b;
        if (r101 != null) goto L6;
        return super.findLibrary(r100);
    L6:
        return r101.findLibrary(r100);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final URL findResource(String r100) {
        PathClassLoader r101 = this.f462701b;     // Catch: Throwable -> L7
        if (r101 != null) goto L6;
        return super.findResource(r100);
    L6:
        return (URL) f462699f.invoke(r101, new Object[]{r100});
    L7:
        return null;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Enumeration<URL> findResources(String r100) {
        PathClassLoader r101 = this.f462701b;     // Catch: Throwable -> L7
        if (r101 != null) goto L6;
        return super.findResources(r100);
    L6:
        return (Enumeration) f462698e.invoke(r101, new Object[]{r100});
    L7:
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r100, String r101) throws ClassNotFoundException {
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

    public static ClassNotFoundException b(ClassNotFoundException r100, ClassNotFoundException r101) {
        if (r100 == null) goto L6;
        r100.addSuppressed(r101);
        return r100;
    L6:
        return r101;
    }

    public f(String r100, File r101, String r102) {
        super("", null, "", null);
        this.f462700a = f.class.getClassLoader();
        PathClassLoader r103 = b.a("SpeedPluginClassLoader", r100, r101, r102, BaseDexClassLoader.getSystemClassLoader().getParent());
        this.f462701b = r103;
        Field r104 = FieldUtils.getField(ClassLoader.class, "parent");     // Catch: Exception -> L7
        if (r104 == null) goto L10;
        r104.set(r103, this);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }
}
