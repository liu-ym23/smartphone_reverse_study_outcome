package com.volcengine.zeus;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PluginClassLoader extends BaseDexClassLoader {
    private static final String TAG = "PluginClassLoader";
    protected HashSet<String> allPluginClasses;
    protected final ClassLoader hostClassLoader;
    protected final List<ClassLoader> otherPluginClassLoader;

    public ClassLoader getInnerClassLoader() {
        return this;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String r7) throws ClassNotFoundException {
        HashSet<String> r0 = this.allPluginClasses;
        Class<?> r1 = null;
        if (r0 != null) goto L5;
    L33:
        r1 = super.findClass(r7);     // Catch: ClassNotFoundException -> L10
        e = null;
    L11:
        StringBuilder r2 = new StringBuilder("loadClass from :\n");
        if (r1 != null) goto L23;
        List<ClassLoader> r3 = this.otherPluginClassLoader;
        if (r3 == null) goto L23;
        Iterator<ClassLoader> r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L23;
        r1 = INVOKEVIRTUAL_com_volcengine_zeus_PluginClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r4.next(), r7);     // Catch: ClassNotFoundException -> L21
    L21:
        e = move-exception;
        e = handleException(r2, e, e);
    L23:
        if (r1 == null) goto L35;
    L28:
        if (r1 != null) goto L32;
        if (e == null) goto L31;
        throw e;
    L31:
        throw new ClassNotFoundException(r7 + " class not found in PluginClassLoader");
    L32:
        return r1;
    L35:
        r1 = INVOKEVIRTUAL_com_volcengine_zeus_PluginClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.hostClassLoader, r7);     // Catch: ClassNotFoundException -> L26
    L26:
        e = move-exception;
        e = handleException(r2, e, e);
    L10:
        e = e;
        goto L11
    L5:
        if (r0.contains(r7) == true) goto L33;
        e = null;
        goto L11
    }

    public void setAllPluginClasses(HashSet<String> r1) {
        this.allPluginClasses = r1;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_PluginClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r2, String r3) throws ClassNotFoundException {
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

    private ClassNotFoundException handleException(StringBuilder r1, ClassNotFoundException r2, ClassNotFoundException r3) {
        if (r2 == null) goto L6;
        r2.addSuppressed(r3);
        return r2;
    L6:
        return r3;
    }

    public PluginClassLoader(String r2, File r3, String r4, List<ClassLoader> r5) {
        super(r2, r3, r4, BaseDexClassLoader.getSystemClassLoader().getParent());
        this.hostClassLoader = PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = r5;
    }
}
