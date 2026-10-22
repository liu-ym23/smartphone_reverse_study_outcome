package com.bytedance.common.push;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import com.bytedance.common.push.notification.BaseBannerActivity;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.utils.f;
import com.bytedance.push.utils.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import m67.a;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityLifecycleObserver extends Observable implements Application.ActivityLifecycleCallbacks {
    private static final k<ActivityLifecycleObserver> INST = null;
    private static final List<String> activityWhitList = null;
    private static volatile boolean sIsBackGround;
    private long lastForeGroundTime;
    private Rect launchSourceBounds;
    private WeakReference<Activity> mActivityRef;
    private boolean mAppActive;
    private List<Long> mEnterBackgroundTimeStampList;
    private int mForegroundActivityNum;
    private final List<Application.ActivityLifecycleCallbacks> mListener;
    private final Runnable mRunnable;
    private final List<Runnable> runnableNeedExecuteAfterAppLaunch;
    private final WeakHandler sHandler;

    static {
        INST = new AnonymousClass1();
        activityWhitList = Arrays.asList(new String[]{"GifPermissionBootActivity", "GifPermissionDynamicActivity", "GifPermissionToastActivity"});
        sIsBackGround = true;
    }

    private Object[] collectActivityLifecycleCallbacks() {
        List<Application.ActivityLifecycleCallbacks> r100 = this.mListener;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mListener.size() <= 0) goto L7;
        Object[] r101 = this.mListener.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = null;
        goto L8
    }

    public static ActivityLifecycleObserver getIns() {
        return INST.get(new Object[0]);
    }

    private void onEnterBackground() {
        f.b("ActivityLifecycleObserver", "onEnterBackground");
        sIsBackGround = true;
        a.a().b();
        setChanged();
        notifyObservers(Boolean.valueOf(sIsBackGround));
        this.mEnterBackgroundTimeStampList.add(Long.valueOf(System.currentTimeMillis()));
    }

    private void onEnterForeground() {
        f.b("ActivityLifecycleObserver", "[onEnterForeground]runnableNeedExecuteAfterAppLaunch size:" + this.runnableNeedExecuteAfterAppLaunch.size());
        sIsBackGround = false;
        this.lastForeGroundTime = System.currentTimeMillis();
        a.a().c();
        setChanged();
        notifyObservers(Boolean.valueOf(sIsBackGround));
        if (this.runnableNeedExecuteAfterAppLaunch.size() <= 0) goto L16;
        List<Runnable> r100 = this.runnableNeedExecuteAfterAppLaunch;
        monitor-enter(r100);
        Iterator<Runnable> r101 = this.runnableNeedExecuteAfterAppLaunch.iterator();     // Catch: Throwable -> L13
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().run();     // Catch: Throwable -> L13
        goto L8
    L10:
        this.runnableNeedExecuteAfterAppLaunch.clear();     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> r100 = this.mActivityRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    private ActivityLifecycleObserver() {
        this.mRunnable = new AnonymousClass2(this);
        this.mEnterBackgroundTimeStampList = new ArrayList();
        this.sHandler = new WeakHandler(new AnonymousClass3(this));
        this.mListener = new ArrayList();
        this.runnableNeedExecuteAfterAppLaunch = new ArrayList();
    }

    public long getLastForeGroundTime() {
        return this.lastForeGroundTime;
    }

    public Rect getLaunchSourceBounds() {
        return this.launchSourceBounds;
    }

    public boolean isApplicationActive() {
        return this.mAppActive;
    }

    public boolean isBackGround() {
        return sIsBackGround;
    }

    public /* synthetic */ ActivityLifecycleObserver(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ boolean access$100(ActivityLifecycleObserver r100) {
        return r100.mAppActive;
    }

    public void addActivityLifeCycleListener(Application.ActivityLifecycleCallbacks r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<Application.ActivityLifecycleCallbacks> r101 = this.mListener;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mListener.contains(r100) == false) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L10:
        this.mListener.add(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
        f.b("ActivityLifecycleObserver", "onActivityDestroyed:".concat(r100.getClass().getName()));
        Object[] r101 = collectActivityLifecycleCallbacks();
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        ((Application.ActivityLifecycleCallbacks) r101[r103]).onActivityDestroyed(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
        if (f.f267065a == false) goto L5;
        f.b("ActivityLifecycleObserver", "onActivityPaused:".concat(r100.getClass().getName()));
    L5:
        Object[] r101 = collectActivityLifecycleCallbacks();
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L12;
        ((Application.ActivityLifecycleCallbacks) r101[r103]).onActivityPaused(r100);
        r103 = r103 + 1;
        goto L8
    L12:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        f.b("ActivityLifecycleObserver", "onActivityResumed:".concat(r100.getClass().getName()));
        this.mActivityRef = new WeakReference(r100);
        Object[] r101 = collectActivityLifecycleCallbacks();
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        ((Application.ActivityLifecycleCallbacks) r101[r103]).onActivityResumed(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r100) {
        if (f.f267065a == false) goto L5;
        f.b("ActivityLifecycleObserver", "onActivityStarted:".concat(r100.getClass().getName()));
    L5:
        Intent r101 = r100.getIntent();
        if (r101 == null) goto L12;
        Rect r102 = r101.getSourceBounds();
        if (f.f267065a == false) goto L10;
        f.b("ActivityLifecycleObserver", "[onActivityCreated]sourceBounds:" + r102);
    L10:
        if (r102 == null) goto L12;
        this.launchSourceBounds = r102;
    L12:
        Object[] r103 = collectActivityLifecycleCallbacks();
        if (r103 == null) goto L18;
        int r104 = r103.length;
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L18;
        ((Application.ActivityLifecycleCallbacks) r103[r105]).onActivityStarted(r100);
        r105 = r105 + 1;
    L18:
        if ((r100 instanceof BaseBannerActivity) == false) goto L21;
        f.b("ActivityLifecycleObserver", "on banner ActivityStarted,ignore");
        return;
    L21:
        f.b("ActivityLifecycleObserver", "activityWhitList: ".concat(r100.getClass().getSimpleName()));
        if (activityWhitList.contains(r100.getClass().getSimpleName()) == false) goto L25;
        return;
    L25:
        if (this.mForegroundActivityNum >= 0) goto L28;
        this.mForegroundActivityNum = 0;
    L28:
        if (this.mForegroundActivityNum != 0) goto L30;
        onEnterForeground();
    L30:
        this.mForegroundActivityNum++;
        if (this.mAppActive == true) goto L33;
        this.mAppActive = true;
        f.b("ActivityLifecycleObserver", "onResume sAppAlive = true");
    L33:
        this.sHandler.removeCallbacks(this.mRunnable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r100) {
        f.b("ActivityLifecycleObserver", "onActivityStopped:".concat(r100.getClass().getName()));
        if (this.mAppActive == false) goto L5;
        this.sHandler.postDelayed(this.mRunnable, 30000);
    L5:
        Object[] r101 = collectActivityLifecycleCallbacks();
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        ((Application.ActivityLifecycleCallbacks) r101[r103]).onActivityStopped(r100);
        r103 = r103 + 1;
    L10:
        f.b("ActivityLifecycleObserver", "activityWhitList: ".concat(r100.getClass().getSimpleName()));
        if (activityWhitList.contains(r100.getClass().getSimpleName()) == false) goto L13;
        return;
    L13:
        int r104 = this.mForegroundActivityNum - 1;
        this.mForegroundActivityNum = r104;
        if (r104 > 0) goto L17;
        onEnterBackground();
    L17:
        if (this.mForegroundActivityNum >= 0) goto L21;
        this.mForegroundActivityNum = 0;
        return;
    }

    public void runAfterUserLaunch(Runnable r100) {
        f.b("ActivityLifecycleObserver", "[runAfterUserLaunch]lastForeGroundTime:" + this.lastForeGroundTime);
        if (this.lastForeGroundTime <= 0) goto L6;
        r100.run();
        return;
    L6:
        List<Runnable> r101 = this.runnableNeedExecuteAfterAppLaunch;
        monitor-enter(r101);
        this.runnableNeedExecuteAfterAppLaunch.add(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean access$102(ActivityLifecycleObserver r100, boolean r101) {
        r100.mAppActive = r101;
        return r101;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
        Object[] r102 = collectActivityLifecycleCallbacks();
        if (r102 == null) goto L7;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        ((Application.ActivityLifecycleCallbacks) r102[r104]).onActivityCreated(r100, r101);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Object[] r102 = collectActivityLifecycleCallbacks();
        if (r102 == null) goto L7;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        ((Application.ActivityLifecycleCallbacks) r102[r104]).onActivitySaveInstanceState(r100, r101);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }
}
