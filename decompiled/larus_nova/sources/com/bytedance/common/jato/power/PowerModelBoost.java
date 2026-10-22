package com.bytedance.common.jato.power;

import android.app.Activity;
import android.app.ActivityThread;
import android.app.ActivityThreadCompat;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
public class PowerModelBoost {
    private static Object sActivityThread;
    private static Field sField;
    private static Handler sHandler;

    /* JADX INFO: renamed from: com.bytedance.common.jato.power.PowerModelBoost$1, reason: invalid class name */
    public class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        public AnonymousClass1() {
        }

        public static /* synthetic */ void a() {
            lambda$onActivityResumed$0();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r100) {
        }

        private static /* synthetic */ void lambda$onActivityResumed$0() {
            PowerModelBoost.access$200();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r100) {
            PowerModelBoost.access$100().post(new a());
        }
    }

    public static final class NotifyArrayList extends ArrayList {
        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object r100) {
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return super.size();
        }

        private NotifyArrayList() {
        }

        public /* synthetic */ NotifyArrayList(AnonymousClass1 r100) {
            this();
        }
    }

    private static void setNewActivitiesNull() {
        Object r100 = sActivityThread;
        if (r100 != null) goto L5;
        return;
    L5:
        Field r101 = sField;
        if (r101 != null) goto L11;
        return;
    L11:
        r101.set(r100, null);     // Catch: IllegalAccessException -> L10
        return;
    }

    public static /* synthetic */ Handler access$100() {
        return sHandler;
    }

    public static /* synthetic */ void access$200() {
        setNewActivitiesNull();
    }

    public static boolean initNewActivitys(Application r100) {
        return initNewActivitysInner(r100);
    L4:
        return false;
    }

    private static boolean initNewActivitysInner(Application r100) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        ActivityThread r101 = ActivityThreadCompat.currentActivityThread();
        if (r101 != null) goto L6;
        return false;
    L6:
        sActivityThread = r101;
        Field r102 = ActivityThread.class.getDeclaredField("mNewActivities");
        r102.setAccessible(true);
        sField = r102;
        if (r102.getType() != ArrayList.class) goto L10;
        r102.set(r101, new NotifyArrayList(null));
        return true;
    L10:
        sHandler = new Handler(Looper.getMainLooper());
        r100.registerActivityLifecycleCallbacks(new AnonymousClass1());
        return true;
    }
}
