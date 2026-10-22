package com.huawei.hms.framework.common;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class ActivityUtil {
    private static final int MAX_NUM = 20;
    private static final String TAG = "ActivityUtil";
    private static volatile ActivityUtil instance;
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
    private boolean isForeground;
    private List<OnAppStatusListener> onAppStatusListeners;

    public interface OnAppStatusListener {
        void onBack();

        void onFront();
    }

    public static ActivityUtil getInstance() {
        if (instance != null) goto L15;
        monitor-enter(ActivityUtil.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new ActivityUtil();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ActivityUtil.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private ActivityUtil() {
        this.onAppStatusListeners = new ArrayList();
        this.activityLifecycleCallbacks = new AnonymousClass1(this);
    }

    public void register() {
        Context r100 = ContextHolder.getAppContext();
        if ((r100 instanceof Application) == false) goto L5;
        ((Application) r100).registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        return;
    L5:
        Logger.w(TAG, "context is not application, register background fail");
    }

    public void unRegister() {
        Context r100 = ContextHolder.getAppContext();
        if ((r100 instanceof Application) == false) goto L5;
        ((Application) r100).unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        return;
    L5:
        Logger.w(TAG, "context is not application, unRegister background fail");
    }

    public boolean isForeground() {
        return this.isForeground;
    }

    public static /* synthetic */ List access$100(ActivityUtil r100) {
        return r100.onAppStatusListeners;
    }

    public static boolean isForeground(Context r100) {
        return getInstance().isForeground();
    }

    public void setOnAppStatusListener(OnAppStatusListener r100) {
        if (r100 != null) goto L7;
        Logger.w(TAG, "onAppStatusListener is null");
        return;
    L7:
        if (this.onAppStatusListeners.size() < 20) goto L10;
        Logger.w(TAG, "onAppStatusListener of count is max");
        return;
    L10:
        this.onAppStatusListeners.add(r100);
    }

    public static /* synthetic */ boolean access$002(ActivityUtil r100, boolean r101) {
        r100.isForeground = r101;
        return r101;
    }

    public static PendingIntent getActivities(Context r100, int r101, Intent[] r102, int r103) {
        if (r100 != null) goto L11;
        Logger.w(TAG, "context is null");
        return null;
    L11:
        return PendingIntent.getActivities(r100, r101, r102, r103);
    L8:
        e = move-exception;
        Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
        return null;
    }
}
