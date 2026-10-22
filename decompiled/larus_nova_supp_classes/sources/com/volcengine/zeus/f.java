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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f extends PluginClassLoader {
    public static final Method c = null;
    public static final Method d = null;
    public static final Method e = null;
    public static final Method f = null;
    public final ClassLoader a;
    public final PathClassLoader b;

    static {
        c = MethodUtils.getAccessibleMethod(ClassLoader.class, "findClass", new Class[]{String.class});
        d = MethodUtils.getAccessibleMethod(ClassLoader.class, "findLoadedClass", new Class[]{String.class});
        e = MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "findResources", new Class[]{String.class});
        f = MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "findResource", new Class[]{String.class});
    }

    @Override // com.volcengine.zeus.PluginClassLoader
    public final ClassLoader getInnerClassLoader() {
        return this.b;
    }

    @Override // com.volcengine.zeus.PluginClassLoader, dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Class<?> findClass(String r7) throws ClassNotFoundException {
        ClassNotFoundException r2 = null;
        Class<?> r3 = (Class) d.invoke(this.b, new Object[]{r7});     // Catch: Throwable -> L5
    L6:
        if (r3 != null) goto L15;
        r3 = (Class) c.invoke(this.b, new Object[]{r7});     // Catch: Throwable -> L9
    L9:
        th = move-exception;
    L12:
        e = move-exception;
        r2 = e;
        goto L15
    L11:
        throw new ClassNotFoundException("Class Not In FindClass By Inner", th);     // Catch: ClassNotFoundException -> L12
    L15:
        if (r3 != null) goto L26;
        List<ClassLoader> r0 = this.otherPluginClassLoader;
        if (r0 == null) goto L26;
        Iterator<ClassLoader> r1 = r0.iterator();
    L20:
        if (r1.hasNext() == false) goto L26;
        r3 = a(r1.next(), r7);     // Catch: ClassNotFoundException -> L24
    L24:
        e = move-exception;
        r2 = b(r2, e);
    L26:
        if (r3 == null) goto L44;
    L31:
        if (r3 != null) goto L35;
        if (r2 == null) goto L34;
        throw r2;
    L34:
        throw new ClassNotFoundException(r7 + " class not found in SpeedPluginClassLoader");
    L35:
        return r3;
    L44:
        r3 = a(this.a, r7);     // Catch: ClassNotFoundException -> L29
    L29:
        e = move-exception;
        r2 = b(r2, e);
    L5:
        r3 = null;
        goto L6
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String r2) {
        PathClassLoader r0 = this.b;
        if (r0 != null) goto L6;
        return super.findLibrary(r2);
    L6:
        return r0.findLibrary(r2);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final URL findResource(String r5) {
        PathClassLoader r0 = this.b;     // Catch: Throwable -> L7
        if (r0 != null) goto L6;
        return super.findResource(r5);
    L6:
        return (URL) f.invoke(r0, new Object[]{r5});
    L7:
        return null;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Enumeration<URL> findResources(String r5) {
        PathClassLoader r0 = this.b;     // Catch: Throwable -> L7
        if (r0 != null) goto L6;
        return super.findResources(r5);
    L6:
        return (Enumeration) e.invoke(r0, new Object[]{r5});
    L7:
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    public static ClassNotFoundException b(ClassNotFoundException r0, ClassNotFoundException r1) {
        if (r0 == null) goto L6;
        r0.addSuppressed(r1);
        return r0;
    L6:
        return r1;
    }

    public f(String r3, File r4, String r5) {
        super(XmlPullParser.NO_NAMESPACE, null, XmlPullParser.NO_NAMESPACE, null);
        this.a = f.class.getClassLoader();
        PathClassLoader r6 = b.a("SpeedPluginClassLoader", r3, r4, r5, BaseDexClassLoader.getSystemClassLoader().getParent());
        this.b = r6;
        Field r7 = FieldUtils.getField(ClassLoader.class, "parent");     // Catch: Exception -> L7
        if (r7 == null) goto L10;
        r7.set(r6, this);     // Catch: Exception -> L7
        return;
    L10:
        return;
    }
}
