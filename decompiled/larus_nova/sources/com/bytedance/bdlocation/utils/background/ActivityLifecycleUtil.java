package com.bytedance.bdlocation.utils.background;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class ActivityLifecycleUtil implements GenericLifecycleObserver {
    private static List<ActivityNotification> sNotifications;

    public interface ActivityNotification {
        void onAppBackgroundNotify(boolean r100);
    }

    static {
        sNotifications = new ArrayList();
    }

    public static void init() {
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1());
    }

    private ActivityLifecycleUtil() {
    }

    public /* synthetic */ ActivityLifecycleUtil(AnonymousClass1 r100) {
        this();
    }

    private static void notifySwitch(boolean r100) {
        monitor-enter(ActivityLifecycleUtil.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (CollectionUtil.isEmpty(sNotifications) == true) goto L10;
        Iterator<ActivityNotification> r101 = sNotifications.iterator();     // Catch: Throwable -> L12
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().onAppBackgroundNotify(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(ActivityLifecycleUtil.class);     // Catch: Throwable -> L12
    }

    public static void register(ActivityNotification r100) {
        monitor-enter(ActivityLifecycleUtil.class);
        sNotifications.add(r100);     // Catch: Throwable -> L7
        monitor-exit(ActivityLifecycleUtil.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void unregister(ActivityNotification r100) {
        monitor-enter(ActivityNotification.class);
        sNotifications.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(ActivityNotification.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Logger.d("onStateChanged", "onStateChanged: event =" + r101);
        if (r101 != Lifecycle.Event.ON_START) goto L6;
        Logger.i("LifecycleObserver onAppForeground");
        notifySwitch(false);
        return;
    L6:
        if (r101 != Lifecycle.Event.ON_STOP) goto L10;
        Logger.i("LifecycleObserver onAppBackground");
        notifySwitch(true);
        return;
    }
}
