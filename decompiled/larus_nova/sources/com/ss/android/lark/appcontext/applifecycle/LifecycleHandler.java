package com.ss.android.lark.appcontext.applifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public class LifecycleHandler extends FragmentManager.FragmentLifecycleCallbacks implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<t> f408816a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<w> f408817b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Application.ActivityLifecycleCallbacks> f408818c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Application.ActivityLifecycleCallbacks f408819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f408820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentLinkedDeque<ComponentCallbacks2> f408821f = null;

    static {
        f408816a = new CopyOnWriteArrayList();
        f408817b = new CopyOnWriteArrayList();
        f408818c = new CopyOnWriteArrayList();
        f408821f = new ConcurrentLinkedDeque();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        Log.i("LifecycleHandler", "onLowMemory");
        Iterator<ComponentCallbacks2> r100 = f408821f.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onLowMemory();
        goto L4
    }

    private LifecycleHandler() {
        f408820e = 0;
    }

    public static void a(Application r100) {
        LifecycleHandler r101 = new LifecycleHandler();
        r100.registerActivityLifecycleCallbacks(r101);
        r100.registerComponentCallbacks(r101);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Log.i("LifecycleHandler", r100.getClass().getSimpleName().concat(" onActivityDestroyed"));
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        ((FragmentActivity) r100).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this);
    L5:
        Iterator r101 = ((CopyOnWriteArrayList) f408818c).iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Application.ActivityLifecycleCallbacks r102 = (Application.ActivityLifecycleCallbacks) r101.next();
        if (r102 == null) goto L7;
        r102.onActivityDestroyed(r100);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Log.i("LifecycleHandler", r100.getClass().getSimpleName().concat(" onActivityPaused"));
        Iterator r101 = ((CopyOnWriteArrayList) f408818c).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Application.ActivityLifecycleCallbacks r102 = (Application.ActivityLifecycleCallbacks) r101.next();
        if (r102 == null) goto L4;
        r102.onActivityPaused(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Log.i("LifecycleHandler", r100.getClass().getSimpleName().concat(" resumed"));
        Iterator r101 = ((CopyOnWriteArrayList) f408818c).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Application.ActivityLifecycleCallbacks r102 = (Application.ActivityLifecycleCallbacks) r101.next();
        if (r102 == null) goto L4;
        r102.onActivityResumed(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Log.i("LifecycleHandler", r100.getClass().getSimpleName().concat(" onActivityStarted"));
        c r101 = c.a.f408832a;
        r101.f408828b.add(r100);
        r101.f408829c.add(new WeakReference(r100));
        Iterator r102 = ((CopyOnWriteArrayList) r101.f408831e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        IGetDataCallback r103 = (IGetDataCallback) r102.next();
        r103.onSuccess(r100);
        ((CopyOnWriteArrayList) r101.f408831e).remove(r103);
        goto L4
    L6:
        int r104 = f408820e;
        f408820e = r104 + 1;
        c r105 = c.a.f408832a;
        if (f408820e <= 0) goto L9;
        boolean r106 = true;
    L10:
        r105.b(r106);
        if (r104 != 0) goto L19;
        Log.i("LifecycleHandler", "app change to foreground");
        CoreThreadPool.setAppFrontStats(true);
        boolean r107 = FocusHitPoint.f408807a;
        FocusHitPoint.Companion.a(1);
        Iterator r108 = ((CopyOnWriteArrayList) f408816a).iterator();
    L14:
        if (r108.hasNext() == false) goto L19;
        t r109 = (t) r108.next();
        if (r109 == null) goto L14;
        r109.a(r100);
    L19:
        Iterator r110 = ((CopyOnWriteArrayList) f408818c).iterator();
    L21:
        if (r110.hasNext() == false) goto L25;
        Application.ActivityLifecycleCallbacks r111 = (Application.ActivityLifecycleCallbacks) r110.next();
        if (r111 == null) goto L21;
        r111.onActivityStarted(r100);
        goto L21
    L25:
        c.a.f408832a.getClass();
        return;
    L9:
        r106 = false;
        goto L10
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Log.i("LifecycleHandler", r100.getClass().getSimpleName().concat(" onActivityStopped"));
        c r101 = c.a.f408832a;
        r101.f408828b.remove(r100);
    L3:
        WeakReference<Activity> r102 = r101.f408829c.peekFirst();
        if (r102 == null) goto L11;
        Activity r103 = r102.get();
        if (r103 == null) goto L10;
        if (r103.isDestroyed() == false) goto L11;
    L10:
        r101.f408829c.remove(r102);
    L11:
        boolean r104 = true;
        f408820e--;
        c r105 = c.a.f408832a;
        if (f408820e > 0) goto L15;
        r104 = false;
    L15:
        r105.b(r104);
        if (f408820e != 0) goto L24;
        Log.i("LifecycleHandler", "app change to background");
        boolean r106 = FocusHitPoint.f408807a;
        FocusHitPoint.Companion.a(2);
        Iterator r107 = ((CopyOnWriteArrayList) f408817b).iterator();
    L19:
        if (r107.hasNext() == false) goto L24;
        w r108 = (w) r107.next();
        if (r108 == null) goto L19;
        r108.a(r100.getClass());
    L24:
        Iterator r109 = ((CopyOnWriteArrayList) f408818c).iterator();
    L26:
        if (r109.hasNext() == false) goto L30;
        Application.ActivityLifecycleCallbacks r110 = (Application.ActivityLifecycleCallbacks) r109.next();
        if (r110 == null) goto L26;
        r110.onActivityStopped(r100);
        goto L26
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Log.d("LifecycleHandler", "configuration Changed Orientation = " + r100.orientation);
        Iterator<ComponentCallbacks2> r101 = f408821f.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onConfigurationChanged(r100);
        goto L4
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r100) {
        Log.i("LifecycleHandler", "onTrimMemory level=" + r100);
        Log.i("LifecycleHandler", "notifyLowMemory " + r100);
        Iterator<ComponentCallbacks2> r101 = f408821f.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onTrimMemory(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Log.i("LifecycleHandler", r100.getClass().getSimpleName().concat(" onActivityCreated"));
        if (f408820e == 0) goto L5;
    L9:
        Iterator r102 = ((CopyOnWriteArrayList) f408818c).iterator();
    L11:
        if (r102.hasNext() == false) goto L16;
        Application.ActivityLifecycleCallbacks r103 = (Application.ActivityLifecycleCallbacks) r102.next();
        if (r103 == null) goto L11;
        r103.onActivityCreated(r100, r101);
        goto L11
    L16:
        if ((r100 instanceof FragmentActivity) == false) goto L24;
        ((FragmentActivity) r100).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this, true);
        return;
    L24:
        return;
    L5:
        if (f408819d == null) goto L9;
        if (Build.VERSION.SDK_INT <= 25) goto L9;
        Log.d("LifecycleHandler", "Enter activity create notify rust front");
        f408819d.onActivityCreated(r100, r101);
        goto L9
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Log.i("LifecycleHandler", r100.getClass().getSimpleName().concat(" onActivitySaveInstanceState"));
        Iterator r102 = ((CopyOnWriteArrayList) f408818c).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Application.ActivityLifecycleCallbacks r103 = (Application.ActivityLifecycleCallbacks) r102.next();
        if (r103 == null) goto L4;
        r103.onActivitySaveInstanceState(r100, r101);
        goto L4
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentResumed(FragmentManager r100, Fragment r101) {
        if (r101.getView() == null) goto L6;
        Log.i("LifecycleHandler", r101.getClass().getSimpleName().concat(" resumed"));
        return;
    }
}
