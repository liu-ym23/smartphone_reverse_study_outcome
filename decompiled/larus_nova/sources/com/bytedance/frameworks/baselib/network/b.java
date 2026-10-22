package com.bytedance.frameworks.baselib.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f244636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHandler f244637c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AbstractC3499b> f244638a;

    public class a implements WeakHandler.IHandler {
        public a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class AbstractC3499b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f244639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f244640b;

        /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.b$b$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AbstractC3499b f244641a;

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if (b.f244636b == false) goto L9;
                b.f244636b = false;     // Catch: Throwable -> L6
                this.f244641a.a();     // Catch: Throwable -> L6
                return;
            }

            public a(AbstractC3499b r100) {
                this.f244641a = r100;
            }
        }

        public abstract void a();

        public abstract void b();

        public AbstractC3499b() {
            this.f244639a = 30000;
            this.f244640b = new a(this);
        }

        public AbstractC3499b(int r100) {
            this.f244640b = new a(this);
            this.f244639a = 30000;
        }
    }

    private static Activity getActivity() {
        Class r100 = a();     // Catch: Throwable -> L14
        Object r101 = r100.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r102 = r100.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r102.setAccessible(true);     // Catch: Throwable -> L14
        Map r103 = (Map) r102.get(r101);     // Catch: Throwable -> L14
        if (r103 != null) goto L6;
        return null;
    L6:
        Iterator r104 = r103.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();     // Catch: Throwable -> L14
        Class<?> r106 = r105.getClass();     // Catch: Throwable -> L14
        Field r107 = r106.getDeclaredField("paused");     // Catch: Throwable -> L14
        r107.setAccessible(true);     // Catch: Throwable -> L14
        if (r107.getBoolean(r105) == true) goto L8;
        Field r108 = r106.getDeclaredField("activity");     // Catch: Throwable -> L14
        r108.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) r108.get(r105);
    L13:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    static {
        f244637c = new WeakHandler(Looper.getMainLooper(), new a());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public b() {
        this.f244638a = new CopyOnWriteArrayList();
        if (getActivity() == null) goto L6;
        f244636b = true;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        if (f244636b == false) goto L8;
        Iterator r101 = ((CopyOnWriteArrayList) this.f244638a).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        AbstractC3499b r102 = (AbstractC3499b) r101.next();
        f244637c.postDelayed(r102.f244640b, r102.f244639a);
        goto L6
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        if (f244636b == true) goto L8;
        f244636b = true;
        Iterator r101 = ((CopyOnWriteArrayList) this.f244638a).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((AbstractC3499b) r101.next()).b();
    L8:
        f244637c.removeCallbacksAndMessages(null);
    }
}
