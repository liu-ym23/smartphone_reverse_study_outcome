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

/* JADX INFO: loaded from: classes.dex */
public class PluginClassLoader extends BaseDexClassLoader {
    private static final String TAG = "PluginClassLoader";
    protected HashSet<String> allPluginClasses;
    protected final ClassLoader hostClassLoader;
    protected final List<ClassLoader> otherPluginClassLoader;

    public ClassLoader getInnerClassLoader() {
        return this;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String r100) throws ClassNotFoundException {
        HashSet<String> r101 = this.allPluginClasses;
        Class<?> r102 = null;
        if (r101 != null) goto L5;
    L33:
        r102 = super.findClass(r100);     // Catch: ClassNotFoundException -> L10
        e = null;
    L11:
        StringBuilder r103 = new StringBuilder("loadClass from :\n");
        if (r102 != null) goto L23;
        List<ClassLoader> r104 = this.otherPluginClassLoader;
        if (r104 == null) goto L23;
        Iterator<ClassLoader> r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L23;
        r102 = INVOKEVIRTUAL_com_volcengine_zeus_PluginClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r105.next(), r100);     // Catch: ClassNotFoundException -> L21
    L21:
        e = move-exception;
        e = handleException(r103, e, e);
    L23:
        if (r102 == null) goto L35;
    L28:
        if (r102 != null) goto L32;
        if (e == null) goto L31;
        throw e;
    L31:
        throw new ClassNotFoundException(r100 + " class not found in PluginClassLoader");
    L32:
        return r102;
    L35:
        r102 = INVOKEVIRTUAL_com_volcengine_zeus_PluginClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(this.hostClassLoader, r100);     // Catch: ClassNotFoundException -> L26
    L26:
        e = move-exception;
        e = handleException(r103, e, e);
    L10:
        e = e;
        goto L11
    L5:
        if (r101.contains(r100) == true) goto L33;
        e = null;
        goto L11
    }

    public void setAllPluginClasses(HashSet<String> r100) {
        this.allPluginClasses = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_volcengine_zeus_PluginClassLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
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

    private ClassNotFoundException handleException(StringBuilder r100, ClassNotFoundException r101, ClassNotFoundException r102) {
        if (r101 == null) goto L6;
        r101.addSuppressed(r102);
        return r101;
    L6:
        return r102;
    }

    public PluginClassLoader(String r100, File r101, String r102, List<ClassLoader> r103) {
        super(r100, r101, r102, BaseDexClassLoader.getSystemClassLoader().getParent());
        this.hostClassLoader = PluginClassLoader.class.getClassLoader();
        this.otherPluginClassLoader = r103;
    }
}
