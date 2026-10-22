package com.bytedance.salamander.ability;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.common.utility.collection.WeakContainer;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tR(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u0013\u0010-\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u0010/\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010,R\u0013\u00100\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010,R\u0019\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002018F¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/bytedance/salamander/ability/ActivityStack;", "", "Landroid/app/Activity;", "activity", "", "isPicInPicActivity", "isLiveIndependentActivity", "curActivity", "getPreviousActivity", "Lcom/bytedance/salamander/ability/ActivityStack$a;", "listener", "", "addAppBackGroundListener", "removeAppBackGroundListener", "Ljava/util/LinkedList;", "sActivityStack", "Ljava/util/LinkedList;", "getSActivityStack", "()Ljava/util/LinkedList;", "setSActivityStack", "(Ljava/util/LinkedList;)V", "Lcom/bytedance/common/utility/collection/WeakContainer;", "sStartedActivities", "Lcom/bytedance/common/utility/collection/WeakContainer;", "getSStartedActivities", "()Lcom/bytedance/common/utility/collection/WeakContainer;", "setSStartedActivities", "(Lcom/bytedance/common/utility/collection/WeakContainer;)V", "isAppBackGround", "Z", "()Z", "setAppBackGround", "(Z)V", "Landroid/app/Application$ActivityLifecycleCallbacks;", "lifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getLifecycleCallbacks", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "setLifecycleCallbacks", "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "sAppBackgroundListeners", "getSAppBackgroundListeners", "setSAppBackgroundListeners", "getTopActivity", "()Landroid/app/Activity;", "topActivity", "getResumedActivity", "resumedActivity", "previousActivity", "", "getActivityStack", "()[Landroid/app/Activity;", "activityStack", "<init>", "()V", "a", "anniex_release"}, k = 1, mv = {1, 7, 1})
public final class ActivityStack {
    public static final ActivityStack INSTANCE = null;
    private static boolean isAppBackGround;
    private static Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private static LinkedList<Activity> sActivityStack;
    private static WeakContainer<a> sAppBackgroundListeners;
    private static WeakContainer<Activity> sStartedActivities;

    public interface a {
        void onAppBackground();

        void onAppForeground();
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            ActivityStack r0 = ActivityStack.INSTANCE;
            if (r0.isPicInPicActivity(r3) == false) goto L6;
            return;
        L6:
            monitor-enter(ActivityStack.class);
            r0.getSActivityStack().remove(r3);     // Catch: Throwable -> L10
            monitor-exit(ActivityStack.class);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            ActivityStack r0 = ActivityStack.INSTANCE;
            if (r0.isPicInPicActivity(r3) == false) goto L6;
            return;
        L6:
            monitor-enter(ActivityStack.class);
        L20:
            th = move-exception;
            throw th;
        L8:
            if (r0.isAppBackGround() == false) goto L17;
            r0.setAppBackGround(false);     // Catch: Throwable -> L20
            if (r0.getSAppBackgroundListeners().isEmpty() == true) goto L17;
            Iterator r1 = r0.getSAppBackgroundListeners().iterator();     // Catch: Throwable -> L20
        L13:
            if (r1.hasNext() == false) goto L17;
            a r2 = (a) r1.next();     // Catch: Throwable -> L20
            if (r2 == null) goto L13;
            r2.onAppForeground();     // Catch: Throwable -> L20
        L17:
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(ActivityStack.class);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            ActivityStack r0 = ActivityStack.INSTANCE;
            if (r0.isPicInPicActivity(r4) == false) goto L6;
            return;
        L6:
            monitor-enter(ActivityStack.class);
            r0.getSStartedActivities().add(r4);     // Catch: Throwable -> L15
            if (r0.isLiveIndependentActivity(r4) == true) goto L10;
        L12:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(ActivityStack.class);
            return;
        L10:
            if (r0.getSActivityStack().contains(r4) == true) goto L12;
            r0.getSActivityStack().add(r4);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            ActivityStack r0 = ActivityStack.INSTANCE;
            if (r0.isPicInPicActivity(r4) == false) goto L6;
            return;
        L6:
            monitor-enter(ActivityStack.class);
            r0.getSStartedActivities().remove(r4);     // Catch: Throwable -> L25
            if (r0.isLiveIndependentActivity(r4) == false) goto L11;
            r0.getSActivityStack().remove(r4);     // Catch: Throwable -> L25
        L11:
            if (r0.isAppBackGround() == false) goto L13;
        L22:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L25
            monitor-exit(ActivityStack.class);
            return;
        L13:
            if (r0.getSStartedActivities().isEmpty() == false) goto L22;
            r0.setAppBackGround(true);     // Catch: Throwable -> L25
            if (r0.getSAppBackgroundListeners().isEmpty() == true) goto L22;
            Iterator r6 = r0.getSAppBackgroundListeners().iterator();     // Catch: Throwable -> L25
        L18:
            if (r6.hasNext() == false) goto L22;
            a r1 = (a) r6.next();     // Catch: Throwable -> L25
            if (r1 == null) goto L18;
            r1.onAppBackground();     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            monitor-enter(ActivityStack.class);
            ActivityStack r0 = ActivityStack.INSTANCE;     // Catch: Throwable -> L11
            if (r0.isPicInPicActivity(r3) == false) goto L8;
            monitor-exit(ActivityStack.class);
            return;
        L8:
            r0.getSActivityStack().remove(r3);     // Catch: Throwable -> L11
            r0.getSActivityStack().add(r3);     // Catch: Throwable -> L11
            monitor-exit(ActivityStack.class);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    private ActivityStack() {
    }

    public final synchronized Activity[] getActivityStack() {
        monitor-enter(this);
        Activity[] r0 = new Activity[sActivityStack.size()];     // Catch: Throwable -> L6
        Activity[] r1 = (Activity[]) sActivityStack.toArray(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Activity getPreviousActivity() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (sActivityStack.size() < 2) goto L7;
        LinkedList<Activity> r0 = sActivityStack;     // Catch: Throwable -> L10
        Activity r1 = r0.get(r0.size() - 2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r1;
    L7:
        r1 = null;
        goto L8
    }

    public final synchronized Activity getResumedActivity() {
        monitor-enter(this);
        Iterator r0 = sStartedActivities.iterator();     // Catch: Throwable -> L15
    L5:
        if (r0.hasNext() == false) goto L12;
        LifecycleOwner r1 = (Activity) r0.next();     // Catch: Throwable -> L15
        if ((r1 instanceof LifecycleOwner) == false) goto L5;
        if (r1.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L5;
        monitor-exit(this);
        return r1;
    L12:
        monitor-exit(this);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized Activity getTopActivity() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (sActivityStack.isEmpty() == false) goto L6;
        Activity r0 = null;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = sActivityStack.getLast();     // Catch: Throwable -> L9
        goto L7
    }

    static {
        INSTANCE = new ActivityStack();
        sActivityStack = new LinkedList();
        sStartedActivities = new WeakContainer();
        isAppBackGround = true;
        lifecycleCallbacks = new b();
        sAppBackgroundListeners = new WeakContainer();
    }

    public final Application.ActivityLifecycleCallbacks getLifecycleCallbacks() {
        return lifecycleCallbacks;
    }

    public final LinkedList<Activity> getSActivityStack() {
        return sActivityStack;
    }

    public final WeakContainer<a> getSAppBackgroundListeners() {
        return sAppBackgroundListeners;
    }

    public final WeakContainer<Activity> getSStartedActivities() {
        return sStartedActivities;
    }

    public final boolean isAppBackGround() {
        return isAppBackGround;
    }

    public final synchronized void addAppBackGroundListener(a r2) {
        monitor-enter(this);
        if (r2 != null) goto L13;
    L11:
        monitor-exit(this);
        return;
    L13:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sAppBackgroundListeners.contains(r2) == true) goto L11;
        sAppBackgroundListeners.add(r2);     // Catch: Throwable -> L8
        goto L11
    }

    public final synchronized Activity getPreviousActivity(Activity r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "curActivity");     // Catch: Throwable -> L19
        LinkedList<Activity> r0 = sActivityStack;     // Catch: Throwable -> L19
        int r1 = r0.size() - 1;     // Catch: Throwable -> L19
        if (r1 < 0) goto L16;
    L5:
        int r2 = r1 - 1;     // Catch: Throwable -> L19
        Activity r3 = r0.get(r1);     // Catch: Throwable -> L19
        if (r3 != r6) goto L8;
    L9:
        int r4 = r1 - 1;     // Catch: Throwable -> L19
        if (r4 >= 0) goto L11;
    L13:
        if (r2 < 0) goto L16;
        r1 = r2;
        goto L5
    L11:
        Activity r7 = r0.get(r4);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return r7;
    L8:
        if (r3.getTaskId() == r6.getTaskId()) goto L13;
    L16:
        r7 = null;
    L19:
        th = move-exception;
        throw th;
    }

    public final boolean isLiveIndependentActivity(Activity r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r5.getLocalClassName(), "LivePlayShadowActivity", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isPicInPicActivity(Activity r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r5.getLocalClassName(), "PicInPicGuideActivity", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final synchronized void removeAppBackGroundListener(a r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        sAppBackgroundListeners.remove(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final void setAppBackGround(boolean r1) {
        isAppBackGround = r1;
    }

    public final void setLifecycleCallbacks(Application.ActivityLifecycleCallbacks r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        lifecycleCallbacks = r2;
    }

    public final void setSActivityStack(LinkedList<Activity> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        sActivityStack = r2;
    }

    public final void setSAppBackgroundListeners(WeakContainer<a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        sAppBackgroundListeners = r2;
    }

    public final void setSStartedActivities(WeakContainer<Activity> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        sStartedActivities = r2;
    }
}
