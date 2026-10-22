package com.ss.android.message;

import android.app.Application;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.utils.f;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class AppProvider {

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private static volatile Application f449119app;
    private static final AtomicBoolean sRegisteredActivityLifecycleCallback = null;

    public AppProvider() {
    }

    static {
        sRegisteredActivityLifecycleCallback = new AtomicBoolean(false);
    }

    public static int getTargetSdkVersion() {
        return f449119app.getApplicationInfo().targetSdkVersion;
    }

    public static Application getApp() {
        return f449119app;
    }

    public static void initApp(Application r100) {
        if (r100 != null) goto L6;
        f.f("AppProvider", "AppProvider.initApp: application is null！！", new Throwable());
        return;
    L6:
        if (sRegisteredActivityLifecycleCallback.getAndSet(true) == false) goto L8;
        return;
    L8:
        f449119app = r100;
        f449119app.registerActivityLifecycleCallbacks(ActivityLifecycleObserver.getIns());
    }
}
