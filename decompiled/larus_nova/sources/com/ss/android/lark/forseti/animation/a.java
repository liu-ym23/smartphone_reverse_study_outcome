package com.ss.android.lark.forseti.animation;

import android.animation.Animator;
import android.view.View;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes36.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f424301b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animator f424302a;

    /* JADX INFO: renamed from: com.ss.android.lark.forseti.animation.a$a, reason: collision with other inner class name */
    public static final class C5017a {
    }

    static {
        Class<Animator> r100 = b.a(b.class.getClassLoader());     // Catch: Exception -> L5
        Constructor<Animator> r101 = r100.getConstructor(new Class[]{Integer.TYPE, Float.TYPE});     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        Method r102 = r100.getMethod("setTarget", new Class[]{View.class});     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        b r103 = new b(r101, r102);     // Catch: Exception -> L5
    L6:
        f424301b = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public a(Animator r100) {
        this.f424302a = r100;
        new WeakReference(null);
    }
}
