package com.bytedance.apm.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.services.apm.api.IActivityLifeManager;
import gs3.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ActivityLifeObserver implements Application.ActivityLifecycleCallbacks, IActivityLifeManager {
    private static final long CHECK_DELAY = 600;
    private static final String TAG = "ActivityLifeObserver";
    private static final ActivityLifeObserver mInstance = null;
    private boolean mChangingConfigActivity;
    private String mCurActivityHash;
    private int mFrontActivityCount;
    private volatile boolean mIsFrontV2;
    private ArrayList<c> mLifecycleObservers;
    private ArrayList<ff7.c> mObservers;
    private String mTopActivityClassName;
    private WeakReference<Activity> mTopActivityRef;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    static {
        mInstance = new ActivityLifeObserver();
    }

    private Object[] collectObservers() {
        ArrayList<ff7.c> r0 = this.mObservers;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.size() <= 0) goto L7;
        Object[] r1 = this.mObservers.toArray();     // Catch: Throwable -> L13
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        return r1;
    L11:
        return new Object[0];
    L7:
        r1 = null;
        goto L8
    }

    public String getTopActivityClassName() {
        WeakReference<Activity> r0 = this.mTopActivityRef;
        String r1 = XmlPullParser.NO_NAMESPACE;
        if (r0 != null) goto L5;
        return XmlPullParser.NO_NAMESPACE;
    L5:
        Activity r2 = r0.get();
        if (r2 == null) goto L11;
        r1 = this.mTopActivityClassName;
        if (r1 != null) goto L11;
        return r2.getClass().getName();
    L11:
        return r1;
    }

    private ActivityLifeObserver() {
        this.mObservers = new ArrayList(8);
        this.mLifecycleObservers = new ArrayList(8);
        this.mTopActivityClassName = null;
    }

    public static ActivityLifeObserver getInstance() {
        return mInstance;
    }

    public WeakReference<Activity> getTopActivityRef() {
        return this.mTopActivityRef;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public boolean isForeground() {
        return this.mIsFrontV2;
    }

    public boolean isV2Foreground() {
        return this.mIsFrontV2;
    }

    private String getActivityHash(Activity r3) {
        return r3.getClass().getName() + r3.hashCode();
    }

    public static void init(Application r1) {
        mInstance.initWithApp(r1);
    }

    private void initWithApp(Application r1) {
        if (r1 == null) goto L5;
        r1.unregisterActivityLifecycleCallbacks(this);
        r1.registerActivityLifecycleCallbacks(this);
        return;
    }

    private void notifyBackground(Activity r5) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ((ff7.c) r0[r2]).onBackground(r5);
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator<c> r6 = this.mLifecycleObservers.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r6.next().onBackground();
        goto L7
    }

    private void notifyFront(Activity r5) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ((ff7.c) r0[r2]).onFront(r5);
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator<c> r6 = this.mLifecycleObservers.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r6.next().onFront();
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r3) {
        if (getActivityHash(r3).equals(this.mCurActivityHash) == false) goto L5;
        this.mCurActivityHash = null;
    L5:
        Iterator<c> r0 = this.mLifecycleObservers.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().onActivityDestroyed(r3);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r5) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ((ff7.c) r0[r2]).onActivityPause(r5);
        r2 = r2 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r7) {
        this.mTopActivityRef = new WeakReference(r7);
        this.mTopActivityClassName = null;
        Object[] r1 = collectObservers();
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        ((ff7.c) r1[r4]).onActivityResume(r7);
        r4 = r4 + 1;
        goto L3
    L5:
        Iterator<c> r5 = this.mLifecycleObservers.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r5.next().onActivityResumed(r7);
        goto L7
    L9:
        String r6 = getActivityHash(r7);
        if (r6.equals(this.mCurActivityHash) == true) goto L19;
        int r8 = r1.length;
    L12:
        if (r3 >= r8) goto L14;
        ((ff7.c) r1[r3]).onChange(r7, null);
        r3 = r3 + 1;
        goto L12
    L14:
        this.mCurActivityHash = r6;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r6) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        ((ff7.c) r0[r3]).onActivityStarted(r6);
        r3 = r3 + 1;
        goto L3
    L6:
        if (this.mChangingConfigActivity == false) goto L9;
        this.mChangingConfigActivity = false;
        return;
    L9:
        int r2 = this.mFrontActivityCount + 1;
        this.mFrontActivityCount = r2;
        if (r2 != 1) goto L14;
        this.mIsFrontV2 = true;
        notifyFront(r6);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        if (r3.isChangingConfigurations() == false) goto L6;
        this.mChangingConfigActivity = true;
        return;
    L6:
        int r0 = this.mFrontActivityCount - 1;
        this.mFrontActivityCount = r0;
        if (r0 != 0) goto L10;
        this.mIsFrontV2 = false;
        notifyBackground(r3);
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void register(ff7.c r3) {
        ArrayList<ff7.c> r0 = this.mObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mObservers.add(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void unregister(ff7.c r3) {
        ArrayList<ff7.c> r0 = this.mObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mObservers.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void register(c r3) {
        ArrayList<c> r0 = this.mLifecycleObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mLifecycleObservers.add(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregister(c r3) {
        ArrayList<c> r0 = this.mLifecycleObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mLifecycleObservers.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r5, Bundle r6) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ((ff7.c) r0[r2]).onActivityCreated(r5, r6);
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator<c> r7 = this.mLifecycleObservers.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r7.next().onActivityCreated(r5);
        goto L7
    }
}
