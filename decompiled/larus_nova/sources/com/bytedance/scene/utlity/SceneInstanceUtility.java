package com.bytedance.scene.utlity;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.SimpleArrayMap;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.scene.Scene;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class SceneInstanceUtility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleArrayMap<String, Class<?>> f268861a = null;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String r100, Exception r101) {
            super(r100, r101);
        }
    }

    static {
        f268861a = new SimpleArrayMap();
    }

    public static boolean d(Scene r100) {
        Class<?> r101 = r100.getClass();
        if (r101.isAnonymousClass() == false) goto L5;
    L23:
        return false;
    L5:
        if (r101.isLocalClass() == true) goto L23;
        int r102 = r101.getModifiers();
        if (Modifier.isPublic(r102) == true) goto L11;
        return false;
    L11:
        if (r101.isMemberClass() == true) goto L13;
    L15:
        Constructor<?>[] r103 = r101.getConstructors();
        int r104 = r103.length;
        int r105 = 0;
    L16:
        if (r105 >= r104) goto L21;
        if (r103[r105].getParameterTypes().length > 0) goto L19;
        r105 = r105 + 1;
        goto L16
    L19:
        return false;
    L21:
        return true;
    L13:
        if (Modifier.isStatic(r102) == true) goto L15;
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static Scene b(Class<?> r100, Bundle r101) {
        Scene r102 = (Scene) r100.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        if (r101 == null) goto L6;
        r101.setClassLoader(r102.getClass().getClassLoader());     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
        r102.f268592j = r101;     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 java.lang.InstantiationException -> L16
    L6:
        return r102;
    L13:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate scene " + r100 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L16:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate scene " + r100 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L10:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate scene " + r100 + ": could not find Scene constructor", e);
    L7:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate scene " + r100 + ": calling Scene constructor caused an exception", e);
    }

    public static Scene c(Context r100, String r101, Bundle r102) {
        SimpleArrayMap<String, Class<?>> r103 = f268861a;
        Class<?> r104 = r103.get(r101);
        if (r104 == null) goto L10;
    L5:
        return b(r104, r102);
    L7:
        e = move-exception;
        throw new InstantiationException("Unable to instantiate scene " + r101 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L10:
        r104 = a(r100.getClassLoader(), r101);     // Catch: ClassNotFoundException -> L7
        r103.put(r101, r104);     // Catch: ClassNotFoundException -> L7
        goto L5
    }
}
