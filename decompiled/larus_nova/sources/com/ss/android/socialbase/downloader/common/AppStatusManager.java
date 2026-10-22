package com.ss.android.socialbase.downloader.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class AppStatusManager {
    private static final int STATUS_BACKGROUND = 0;
    private static final int STATUS_FOREGROUND = 1;
    private static final int STATUS_UNKNOWN = -1;
    private volatile boolean isActivityOnPause;
    private volatile int mAppStatus;
    private final List<AppStatusChangeListener> mAppStatusChangeListeners;
    private Application mApplication;
    private final Application.ActivityLifecycleCallbacks mCallbacks;
    private WeakReference<Activity> mTopActivity;
    private int mTopActivityHashCode;

    /* JADX INFO: loaded from: classes38.dex */
    public interface AppStatusChangeListener {
        void onAppBackground();

        void onAppForeground();
    }

    public static class Holder {
        private static final AppStatusManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new AppStatusManager(null);
        }

        public static /* synthetic */ AppStatusManager access$000() {
            return INSTANCE;
        }
    }

    /* JADX INFO: loaded from: classes38.dex */
    public interface InnerAppStatusChangeCaller {
        boolean isAppInBackground();
    }

    private boolean checkAppForeground() {
        Application r100 = this.mApplication;     // Catch: Throwable -> L20
        if (r100 != null) goto L6;
        return false;
    L6:
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L20
        String r102 = r100.getPackageName();     // Catch: Throwable -> L20
        List<ActivityManager.RunningAppProcessInfo> r103 = r101.getRunningAppProcesses();     // Catch: Throwable -> L20
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r103.isEmpty() == true) goto L32;
        Iterator<ActivityManager.RunningAppProcessInfo> r104 = r103.iterator();     // Catch: Throwable -> L20
    L13:
        if (r104.hasNext() == false) goto L33;
        ActivityManager.RunningAppProcessInfo r105 = r104.next();     // Catch: Throwable -> L20
        if (r105.importance != 100) goto L13;
        if (TextUtils.equals(r105.processName, r102) == false) goto L13;
        return true;
    L33:
        return false;
    L32:
        return false;
    L20:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    private void dispatchAppBackground() {
        int r100 = 0;
        this.mAppStatus = 0;
        Object[] r101 = collectAppSwitchListeners();
        if (r101 == null) goto L7;
        int r102 = r101.length;
    L5:
        if (r100 >= r102) goto L9;
        ((AppStatusChangeListener) r101[r100]).onAppBackground();
        r100 = r100 + 1;
        goto L5
    L9:
        return;
    }

    private void dispatchAppForeground() {
        this.mAppStatus = 1;
        Object[] r100 = collectAppSwitchListeners();
        if (r100 == null) goto L7;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L9;
        ((AppStatusChangeListener) r100[r102]).onAppForeground();
        r102 = r102 + 1;
        goto L5
    L9:
        return;
    }

    public void setInnerAppStatusChangeCaller(InnerAppStatusChangeCaller r100) {
    }

    private Object[] collectAppSwitchListeners() {
        List<AppStatusChangeListener> r100 = this.mAppStatusChangeListeners;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mAppStatusChangeListeners.size() <= 0) goto L7;
        Object[] r101 = this.mAppStatusChangeListeners.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = null;
        goto L8
    }

    private int getRealStatus() {
        int r100 = this.mAppStatus;
        if (r100 != (-1)) goto L6;
        boolean r101 = checkAppForeground();
        this.mAppStatus = r101 ? 1 : 0;
        return r101 ? 1 : 0;
    L6:
        return r100;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> r100 = this.mTopActivity;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.get();
    }

    private AppStatusManager() {
        this.mAppStatusChangeListeners = new ArrayList();
        this.mAppStatus = -1;
        this.isActivityOnPause = false;
        this.mCallbacks = new AnonymousClass1(this);
    }

    public static AppStatusManager getInstance() {
        return Holder.access$000();
    }

    public boolean isAppBackground() {
        if (getRealStatus() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAppFocus() {
        if (isAppForeground() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isActivityOnPause == true) goto L7;
        return true;
    }

    public boolean isAppForeground() {
        if (getRealStatus() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public /* synthetic */ AppStatusManager(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ int access$300(AppStatusManager r100) {
        return r100.mTopActivityHashCode;
    }

    public static /* synthetic */ void access$500(AppStatusManager r100) {
        r100.dispatchAppForeground();
    }

    public static /* synthetic */ void access$600(AppStatusManager r100) {
        r100.dispatchAppBackground();
    }

    public void init(Context r100) {
        if (this.mApplication == null) goto L5;
        return;
    L5:
        if ((r100 instanceof Application) == false) goto L18;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mApplication != null) goto L10;
        Application r101 = (Application) r100;     // Catch: Throwable -> L12
        this.mApplication = r101;     // Catch: Throwable -> L12
        r101.registerActivityLifecycleCallbacks(this.mCallbacks);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    }

    public void registerAppSwitchListener(AppStatusChangeListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<AppStatusChangeListener> r101 = this.mAppStatusChangeListeners;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mAppStatusChangeListeners.contains(r100) == true) goto L9;
        this.mAppStatusChangeListeners.add(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public void unregisterAppSwitchListener(AppStatusChangeListener r100) {
        List<AppStatusChangeListener> r101 = this.mAppStatusChangeListeners;
        monitor-enter(r101);
        this.mAppStatusChangeListeners.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ WeakReference access$202(AppStatusManager r100, WeakReference r101) {
        r100.mTopActivity = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(AppStatusManager r100, int r101) {
        r100.mTopActivityHashCode = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(AppStatusManager r100, boolean r101) {
        r100.isActivityOnPause = r101;
        return r101;
    }
}
