package com.larus.reach.runtime;

import android.app.Activity;
import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes31.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f367349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile WeakReference<Activity> f367350b;

    static {
        f367349a = new AtomicBoolean(false);
    }

    public static Application a() {
        Application r100 = FlowRuntime.a().getApplication();
        if (f367349a.compareAndSet(false, true) == false) goto L6;
        r100.registerActivityLifecycleCallbacks(new s());
    L6:
        return r100;
    }

    public static Activity b() {
        Application r100 = FlowRuntime.a().getApplication();
        if (f367349a.compareAndSet(false, true) == false) goto L6;
        r100.registerActivityLifecycleCallbacks(new s());
    L6:
        WeakReference<Activity> r101 = f367350b;
        if (r101 == null) goto L11;
        Activity r102 = r101.get();
        if (r102 == null) goto L11;
        return r102;
    L11:
        return AppHost.f326268a.a().getCurrentActivity();
    }
}
