package com.volcengine.zeus.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.util.FieldUtils;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f462703a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.FragmentState");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.FragmentState");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.FragmentState");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.FragmentState");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.FragmentState");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.FragmentState");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.FragmentState");
    }

    public c(Fragment r100) {
        this.f462703a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostSaveInstanceState(Activity r100, Bundle r110) {
        if (this.f462703a.getActivity() == r100) goto L38;
        return;
    L38:
        Parcelable r101 = r110.getParcelable("android:fragments");     // Catch: Throwable -> L35
        if (r101 != null) goto L8;
        return;
    L8:
        Object[] r111 = (Object[]) FieldUtils.readField(r101, "mActive");     // Catch: Throwable -> L35
        if (r111 != null) goto L11;
        return;
    L11:
        int r102 = r111.length;     // Catch: Throwable -> L35
        int r103 = 0;
        int r104 = 0;
    L12:
        if (r104 >= r102) goto L24;
        Object r105 = r111[r104];     // Catch: Throwable -> L35
        Object r106 = FieldUtils.readField(r105, "mTag");     // Catch: Throwable -> L35
        if ("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(r106) == true) goto L25;
        if ((r106 instanceof String) == false) goto L23;
        if (((String) r106).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_zeus") == true) goto L25;
        if (((String) r106).contains("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag_zeus") == true) goto L25;
    L23:
        r104 = r104 + 1;     // Catch: Throwable -> L35
    L25:
        if (r105 == null) goto L49;
        Object[] r107 = (Object[]) Array.newInstance(a(), r111.length - 1);     // Catch: Throwable -> L35
        int[] r108 = new int[r111.length - 1];     // Catch: Throwable -> L35
        int r109 = 0;
    L28:
        if (r103 >= r111.length) goto L33;
        Object r112 = r111[r103];     // Catch: Throwable -> L35
        if (r112 == r105) goto L32;
        r107[r109] = r112;     // Catch: Throwable -> L35
        r108[r109] = r103;     // Catch: Throwable -> L35
        r109 = r109 + 1;     // Catch: Throwable -> L35
    L32:
        r103 = r103 + 1;     // Catch: Throwable -> L35
        goto L28
    L33:
        FieldUtils.writeField(r101, "mActive", r107);     // Catch: Throwable -> L35
        FieldUtils.writeField(r101, "mAdded", r108);     // Catch: Throwable -> L35
        return;
    L49:
        return;
    L24:
        r105 = null;
    L35:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r110) {
        if (this.f462703a.getActivity() == r100) goto L38;
        return;
    L38:
        Parcelable r101 = r110.getParcelable("android:fragments");     // Catch: Throwable -> L35
        if (r101 != null) goto L8;
        return;
    L8:
        Object[] r111 = (Object[]) FieldUtils.readField(r101, "mActive");     // Catch: Throwable -> L35
        if (r111 != null) goto L11;
        return;
    L11:
        int r102 = r111.length;     // Catch: Throwable -> L35
        int r103 = 0;
        int r104 = 0;
    L12:
        if (r104 >= r102) goto L24;
        Object r105 = r111[r104];     // Catch: Throwable -> L35
        Object r106 = FieldUtils.readField(r105, "mTag");     // Catch: Throwable -> L35
        if ("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(r106) == true) goto L25;
        if ((r106 instanceof String) == false) goto L23;
        if (((String) r106).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_zeus") == true) goto L25;
        if (((String) r106).contains("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag_zeus") == true) goto L25;
    L23:
        r104 = r104 + 1;     // Catch: Throwable -> L35
    L25:
        if (r105 == null) goto L49;
        Object[] r107 = (Object[]) Array.newInstance(a(), r111.length - 1);     // Catch: Throwable -> L35
        int[] r108 = new int[r111.length - 1];     // Catch: Throwable -> L35
        int r109 = 0;
    L28:
        if (r103 >= r111.length) goto L33;
        Object r112 = r111[r103];     // Catch: Throwable -> L35
        if (r112 == r105) goto L32;
        r107[r109] = r112;     // Catch: Throwable -> L35
        r108[r109] = r103;     // Catch: Throwable -> L35
        r109 = r109 + 1;     // Catch: Throwable -> L35
    L32:
        r103 = r103 + 1;     // Catch: Throwable -> L35
        goto L28
    L33:
        FieldUtils.writeField(r101, "mActive", r107);     // Catch: Throwable -> L35
        FieldUtils.writeField(r101, "mAdded", r108);     // Catch: Throwable -> L35
        return;
    L49:
        return;
    L24:
        r105 = null;
    L35:
        th = move-exception;
        th.printStackTrace();
    }
}
