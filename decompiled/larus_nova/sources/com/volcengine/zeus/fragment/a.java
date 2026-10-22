package com.volcengine.zeus.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("androidx.fragment.app.FragmentFactory");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("androidx.fragment.app.FragmentFactory");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("androidx.fragment.app.FragmentFactory");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("androidx.fragment.app.FragmentFactory");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("androidx.fragment.app.FragmentFactory");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("androidx.fragment.app.FragmentFactory");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("androidx.fragment.app.FragmentFactory");
    }

    public static void c(Class r100) {
    L23:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (Fragment.class.getName().contains("support") == false) goto L6;
        ((SimpleArrayMap) b(Fragment.class, "sClassMap").get(null)).put(r100.getName(), r100);     // Catch: Exception -> L23
        return;
    L6:
        Field r101 = b(Fragment.class, "sClassMap");     // Catch: Exception -> L23
        if (r101 == null) goto L27;
        ((SimpleArrayMap) r101.get(null)).put(r100.getName(), r100);     // Catch: Exception -> L23
        return;
    L27:
        Class r102 = a();     // Catch: ClassNotFoundException -> L12 Exception -> L23
    L13:
        if (r102 != null) goto L15;
        return;
    L15:
        Field r103 = b(r102, "sClassMap");     // Catch: Exception -> L23
        if (r103 == null) goto L19;
        ((SimpleArrayMap) r103.get(null)).put(r100.getName(), r100);     // Catch: Exception -> L23
        return;
    L19:
        Field r104 = b(r102, "sClassCacheMap");     // Catch: Exception -> L23
        if (r104 == null) goto L30;
        SimpleArrayMap r105 = (SimpleArrayMap) r104.get(null);     // Catch: Exception -> L23
        SimpleArrayMap r106 = new SimpleArrayMap();     // Catch: Exception -> L23
        r106.put(r100.getName(), r100);     // Catch: Exception -> L23
        r105.put(r100.getClassLoader(), r106);     // Catch: Exception -> L23
        return;
    L30:
        return;
    L12:
        r102 = null;
        goto L13
    }

    public static Field b(Class r100, String r101) {
        Field r102 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L6
        if (r102 == null) goto L5;
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L6
    L5:
        return r102;
    L6:
        return null;
    }
}
