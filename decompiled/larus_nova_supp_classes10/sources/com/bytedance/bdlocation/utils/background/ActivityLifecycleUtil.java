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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ActivityLifecycleUtil implements GenericLifecycleObserver {
    private static List<ActivityNotification> sNotifications;

    public interface ActivityNotification {
        void onAppBackgroundNotify(boolean r1);
    }

    static {
        sNotifications = new ArrayList();
    }

    public static void init() {
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1());
    }

    private ActivityLifecycleUtil() {
    }

    public /* synthetic */ ActivityLifecycleUtil(AnonymousClass1 r1) {
        this();
    }

    private static void notifySwitch(boolean r3) {
        monitor-enter(ActivityLifecycleUtil.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (CollectionUtil.isEmpty(sNotifications) == true) goto L10;
        Iterator<ActivityNotification> r1 = sNotifications.iterator();     // Catch: Throwable -> L12
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().onAppBackgroundNotify(r3);     // Catch: Throwable -> L12
    L10:
        monitor-exit(ActivityLifecycleUtil.class);     // Catch: Throwable -> L12
    }

    public static void register(ActivityNotification r2) {
        monitor-enter(ActivityLifecycleUtil.class);
        sNotifications.add(r2);     // Catch: Throwable -> L7
        monitor-exit(ActivityLifecycleUtil.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void unregister(ActivityNotification r2) {
        monitor-enter(ActivityNotification.class);
        sNotifications.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(ActivityNotification.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Logger.d("onStateChanged", "onStateChanged: event =" + r3);
        if (r3 != Lifecycle.Event.ON_START) goto L6;
        Logger.i("LifecycleObserver onAppForeground");
        notifySwitch(false);
        return;
    L6:
        if (r3 != Lifecycle.Event.ON_STOP) goto L10;
        Logger.i("LifecycleObserver onAppBackground");
        notifySwitch(true);
        return;
    }
}
