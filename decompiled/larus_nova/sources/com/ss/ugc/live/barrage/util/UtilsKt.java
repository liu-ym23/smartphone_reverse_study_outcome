package com.ss.ugc.live.barrage.util;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes36.dex */
public final class UtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f458141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f458142b = null;

    static {
        f458141a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(UtilsKt.class, "barrage_release"), "mainThreadHandler", "getMainThreadHandler()Landroid/os/Handler;"))};
        f458142b = LazyKt.lazy(UtilsKt$mainThreadHandler$2.INSTANCE);
        new ReentrantLock();
    }

    public static void a() {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Main thread ONLY!".toString());
    }

    public static final void b(View r100) {
        r100.forceLayout();
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        b(r101.getChildAt(r103));
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }
}
