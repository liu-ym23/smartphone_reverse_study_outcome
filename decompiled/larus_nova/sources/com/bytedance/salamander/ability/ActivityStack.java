package com.bytedance.salamander.ability;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.common.utility.collection.WeakContainer;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tR(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u0013\u0010-\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u0010/\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010,R\u0013\u00100\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010,R\u0019\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002018F¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/bytedance/salamander/ability/ActivityStack;", "", "Landroid/app/Activity;", "activity", "", "isPicInPicActivity", "isLiveIndependentActivity", "curActivity", "getPreviousActivity", "Lcom/bytedance/salamander/ability/ActivityStack$a;", "listener", "", "addAppBackGroundListener", "removeAppBackGroundListener", "Ljava/util/LinkedList;", "sActivityStack", "Ljava/util/LinkedList;", "getSActivityStack", "()Ljava/util/LinkedList;", "setSActivityStack", "(Ljava/util/LinkedList;)V", "Lcom/bytedance/common/utility/collection/WeakContainer;", "sStartedActivities", "Lcom/bytedance/common/utility/collection/WeakContainer;", "getSStartedActivities", "()Lcom/bytedance/common/utility/collection/WeakContainer;", "setSStartedActivities", "(Lcom/bytedance/common/utility/collection/WeakContainer;)V", "isAppBackGround", "Z", "()Z", "setAppBackGround", "(Z)V", "Landroid/app/Application$ActivityLifecycleCallbacks;", "lifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getLifecycleCallbacks", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "setLifecycleCallbacks", "(Landroid/app/Application$ActivityLifecycleCallbacks;)V", "sAppBackgroundListeners", "getSAppBackgroundListeners", "setSAppBackgroundListeners", "getTopActivity", "()Landroid/app/Activity;", "topActivity", "getResumedActivity", "resumedActivity", "previousActivity", "", "getActivityStack", "()[Landroid/app/Activity;", "activityStack", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 7, 1})
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
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ActivityStack r101 = ActivityStack.INSTANCE;
            if (r101.isPicInPicActivity(r100) == false) goto L6;
            return;
        L6:
            monitor-enter(ActivityStack.class);
            r101.getSActivityStack().remove(r100);     // Catch: Throwable -> L10
            monitor-exit(ActivityStack.class);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ActivityStack r101 = ActivityStack.INSTANCE;
            if (r101.isPicInPicActivity(r100) == false) goto L6;
            return;
        L6:
            monitor-enter(ActivityStack.class);
        L20:
            th = move-exception;
            throw th;
        L8:
            if (r101.isAppBackGround() == false) goto L17;
            r101.setAppBackGround(false);     // Catch: Throwable -> L20
            if (r101.getSAppBackgroundListeners().isEmpty() == true) goto L17;
            Iterator<a> r102 = r101.getSAppBackgroundListeners().iterator();     // Catch: Throwable -> L20
        L13:
            if (r102.hasNext() == false) goto L17;
            a r103 = r102.next();     // Catch: Throwable -> L20
            if (r103 == null) goto L13;
            r103.onAppForeground();     // Catch: Throwable -> L20
        L17:
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(ActivityStack.class);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ActivityStack r101 = ActivityStack.INSTANCE;
            if (r101.isPicInPicActivity(r100) == false) goto L6;
            return;
        L6:
            monitor-enter(ActivityStack.class);
            r101.getSStartedActivities().add(r100);     // Catch: Throwable -> L15
            if (r101.isLiveIndependentActivity(r100) == true) goto L10;
        L12:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(ActivityStack.class);
            return;
        L10:
            if (r101.getSActivityStack().contains(r100) == true) goto L12;
            r101.getSActivityStack().add(r100);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ActivityStack r101 = ActivityStack.INSTANCE;
            if (r101.isPicInPicActivity(r100) == false) goto L6;
            return;
        L6:
            monitor-enter(ActivityStack.class);
            r101.getSStartedActivities().remove(r100);     // Catch: Throwable -> L25
            if (r101.isLiveIndependentActivity(r100) == false) goto L11;
            r101.getSActivityStack().remove(r100);     // Catch: Throwable -> L25
        L11:
            if (r101.isAppBackGround() == false) goto L13;
        L22:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L25
            monitor-exit(ActivityStack.class);
            return;
        L13:
            if (r101.getSStartedActivities().isEmpty() == false) goto L22;
            r101.setAppBackGround(true);     // Catch: Throwable -> L25
            if (r101.getSAppBackgroundListeners().isEmpty() == true) goto L22;
            Iterator<a> r103 = r101.getSAppBackgroundListeners().iterator();     // Catch: Throwable -> L25
        L18:
            if (r103.hasNext() == false) goto L22;
            a r104 = r103.next();     // Catch: Throwable -> L25
            if (r104 == null) goto L18;
            r104.onAppBackground();     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            monitor-enter(ActivityStack.class);
            ActivityStack r102 = ActivityStack.INSTANCE;     // Catch: Throwable -> L11
            if (r102.isPicInPicActivity(r100) == false) goto L8;
            monitor-exit(ActivityStack.class);
            return;
        L8:
            r102.getSActivityStack().remove(r100);     // Catch: Throwable -> L11
            r102.getSActivityStack().add(r100);     // Catch: Throwable -> L11
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
        Activity[] r100 = new Activity[sActivityStack.size()];     // Catch: Throwable -> L6
        Activity[] r101 = (Activity[]) sActivityStack.toArray(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
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
        LinkedList<Activity> r100 = sActivityStack;     // Catch: Throwable -> L10
        Activity r101 = r100.get(r100.size() - 2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized Activity getResumedActivity() {
        monitor-enter(this);
        Iterator<Activity> r100 = sStartedActivities.iterator();     // Catch: Throwable -> L15
    L5:
        if (r100.hasNext() == false) goto L12;
        Activity r101 = r100.next();     // Catch: Throwable -> L15
        if ((r101 instanceof LifecycleOwner) == false) goto L5;
        if (((LifecycleOwner) r101).getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L5;
        monitor-exit(this);
        return r101;
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
        Activity r100 = null;
    L7:
        monitor-exit(this);
        return r100;
    L6:
        r100 = sActivityStack.getLast();     // Catch: Throwable -> L9
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

    public final synchronized void addAppBackGroundListener(a r100) {
        monitor-enter(this);
        if (r100 != null) goto L13;
    L11:
        monitor-exit(this);
        return;
    L13:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sAppBackgroundListeners.contains(r100) == true) goto L11;
        sAppBackgroundListeners.add(r100);     // Catch: Throwable -> L8
        goto L11
    }

    public final synchronized Activity getPreviousActivity(Activity r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "curActivity");     // Catch: Throwable -> L19
        LinkedList<Activity> r101 = sActivityStack;     // Catch: Throwable -> L19
        int r102 = r101.size() - 1;     // Catch: Throwable -> L19
        if (r102 < 0) goto L16;
    L5:
        int r103 = r102 - 1;     // Catch: Throwable -> L19
        Activity r104 = r101.get(r102);     // Catch: Throwable -> L19
        if (r104 != r100) goto L8;
    L9:
        int r105 = r102 - 1;     // Catch: Throwable -> L19
        if (r105 >= 0) goto L11;
    L13:
        if (r103 < 0) goto L16;
        r102 = r103;
        goto L5
    L11:
        Activity r106 = r101.get(r105);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return r106;
    L8:
        if (r104.getTaskId() == r100.getTaskId()) goto L13;
    L16:
        r106 = null;
    L19:
        th = move-exception;
        throw th;
    }

    public final boolean isLiveIndependentActivity(Activity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r100.getLocalClassName(), "LivePlayShadowActivity", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isPicInPicActivity(Activity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r100.getLocalClassName(), "PicInPicGuideActivity", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final synchronized void removeAppBackGroundListener(a r100) {
        monitor-enter(this);
        if (r100 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        sAppBackgroundListeners.remove(r100);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final void setAppBackGround(boolean r100) {
        isAppBackGround = r100;
    }

    public final void setLifecycleCallbacks(Application.ActivityLifecycleCallbacks r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        lifecycleCallbacks = r100;
    }

    public final void setSActivityStack(LinkedList<Activity> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        sActivityStack = r100;
    }

    public final void setSAppBackgroundListeners(WeakContainer<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        sAppBackgroundListeners = r100;
    }

    public final void setSStartedActivities(WeakContainer<Activity> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        sStartedActivities = r100;
    }
}
