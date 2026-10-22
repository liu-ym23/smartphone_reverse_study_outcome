package com.bytedance.realx;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import q87.a;

/* JADX INFO: loaded from: classes21.dex */
public class RXAppStateMonitorAndroid implements Application.ActivityLifecycleCallbacks {
    private final String TAG;
    private Context mContext;
    private Handler mHandler;
    private boolean mIsBackground;
    private final Set<Integer> mPausedActivitySet;
    private final Set<Integer> mStartedActivitySet;
    private HandlerThread mThread;
    private long nativeMonitor;

    public static /* synthetic */ void a(RXAppStateMonitorAndroid r100) {
        r100.lambda$onStateChange$0();
    }

    private synchronized boolean getState() {
        monitor-enter(this);
        boolean r100 = this.mIsBackground;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onStateChange$0() {
        monitor-enter(this);
        long r100 = this.nativeMonitor;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        RXLogging.e("ASMonitorAndroid", "state monitor is reset.");     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        nativeOnStateChange(r100, this.mIsBackground);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private native void nativeOnStateChange(long r100, boolean r101);

    private synchronized void reset() {
        monitor-enter(this);
        Context r100 = this.mContext;     // Catch: Throwable -> L13
        if (r100 != null) goto L6;
    L8:
        this.nativeMonitor = 0;     // Catch: Throwable -> L13
        this.mHandler = null;     // Catch: Throwable -> L13
        HandlerThread r101 = this.mThread;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        r101.quitSafely();     // Catch: Throwable -> L13
        this.mThread = null;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L6:
        if ((r100 instanceof Application) == false) goto L8;
        ((Application) r100).unregisterActivityLifecycleCallbacks(this);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    public RXAppStateMonitorAndroid(long r100) {
        this.TAG = "ASMonitorAndroid";
        this.mIsBackground = false;
        this.mStartedActivitySet = new HashSet();
        this.mPausedActivitySet = new HashSet();
        this.nativeMonitor = 0;
        Context r101 = ContextUtils.getApplicationContext();
        this.mContext = r101;
        if (r101 != null) goto L6;
        RXLogging.e("ASMonitorAndroid", "context is null.");
        return;
    L6:
        Context r102 = r101.getApplicationContext();
        this.mContext = r102;
        this.nativeMonitor = r100;
        if ((r102 instanceof Application) == false) goto L9;
        ((Application) r102).registerActivityLifecycleCallbacks(this);
    L10:
        this.mIsBackground = checkBackground(this.mContext);
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2("appStatePoster");
        this.mThread = r103;
        ThreadMethodProxy.start(r103);
        this.mHandler = new Handler(this.mThread.getLooper());
        return;
    L9:
        RXLogging.e("ASMonitorAndroid", "context not a Application obj.");
        goto L10
    }

    private boolean checkBackground(Context r100) {
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Exception -> L21
        if (r101 != null) goto L7;
        RXLogging.e("ASMonitorAndroid", "activityManager is null.");     // Catch: Exception -> L21
        return false;
    L7:
        List<ActivityManager.RunningAppProcessInfo> r102 = r101.getRunningAppProcesses();     // Catch: Exception -> L21
        if (r102 != null) goto L11;
        RXLogging.e("ASMonitorAndroid", "processInfoList is null.");     // Catch: Exception -> L21
        return false;
    L11:
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r102.iterator();     // Catch: Exception -> L21
    L13:
        if (r103.hasNext() == false) goto L19;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();     // Catch: Exception -> L21
        if (r104.importance != 100) goto L13;
        if (r100.getPackageName().equals(r104.processName) == false) goto L13;
        return false;
    L19:
        return true;
    L21:
        e = move-exception;
        RXLogging.e("ASMonitorAndroid", "Get App background state failed. " + e);
        return false;
    }

    private synchronized void onStateChange(boolean r100) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (r100 != this.mIsBackground) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mIsBackground = r100;     // Catch: Throwable -> L19
        if (this.nativeMonitor != 0) goto L12;
        monitor-exit(this);
        return;
    L12:
        Handler r101 = this.mHandler;     // Catch: Throwable -> L19
        if (r101 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        r101.post(new a(this));     // Catch: Throwable -> L19
        monitor-exit(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
        this.mPausedActivitySet.add(Integer.valueOf(r100.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        this.mStartedActivitySet.add(Integer.valueOf(r100.hashCode()));
        onStateChange(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r100) {
        this.mStartedActivitySet.add(Integer.valueOf(r100.hashCode()));
        onStateChange(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r100) {
        int r101 = r100.hashCode();
        boolean r102 = this.mIsBackground;
        if (this.mStartedActivitySet.contains(Integer.valueOf(r101)) == false) goto L8;
        this.mStartedActivitySet.remove(Integer.valueOf(r101));
        if (this.mStartedActivitySet.size() == 0) goto L11;
    L13:
        r102 = false;
    L14:
        onStateChange(r102);
        this.mPausedActivitySet.remove(Integer.valueOf(r101));
        return;
    L11:
        r102 = true;
        goto L14
    L8:
        if (this.mStartedActivitySet.size() != 0) goto L13;
        if (this.mPausedActivitySet.contains(Integer.valueOf(r101)) == true) goto L11;
        RXLogging.w("ASMonitorAndroid", "started set not contain activity" + r100);
        goto L14
    }
}
