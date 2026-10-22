package com.ss.android.lark.forseti.animation;

import android.animation.Animator;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Constructor<Animator> f424303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f424304b;

    public static Class<Animator> a(ClassLoader r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L38;
        Class r103 = r100.loadClass("android.view.RenderNodeAnimator");     // Catch: Throwable -> L8
        Class r104 = r103;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L31;
        FastClassNotFoundHandler.a("android.view.RenderNodeAnimator");     // Catch: Throwable -> L8
        r104 = r103;
    L31:
        if (Animator.class.isAssignableFrom(r104) == false) goto L34;
        return r104;
    L34:
        throw new ClassCastException(String.format("you can not cast class %s to %s.", new Object[]{r104, Animator.class}));
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.RenderNodeAnimator");
    L12:
        throw th;
    L38:
        Class r105 = r100.loadClass("android.view.RenderNodeAnimator");     // Catch: Throwable -> L17
        r104 = r105;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L31;
        FastClassNotFoundHandler.a("android.view.RenderNodeAnimator");     // Catch: Throwable -> L17
        r104 = r105;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.RenderNodeAnimator");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r104 = MiraPluginFix.loadClass("android.view.RenderNodeAnimator");
        goto L31
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public b(Constructor<Animator> r100, Method r101) {
        this.f424303a = r100;
        this.f424304b = r101;
    }
}
