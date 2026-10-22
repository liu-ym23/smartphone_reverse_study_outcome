package com.bytedance.map.api.lifecycle;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.map.api.logger.MapLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p17.a;

/* JADX INFO: loaded from: classes21.dex */
public final class MapLifecycleObserver implements GenericLifecycleObserver {
    private static final String TAG = "MapLifecycleObserver";
    private static boolean sInit;
    private static Handler sMainHandler;
    private static List<LifecycleNotification> sNotifications;
    private static MapLifecycleObserver sObserver;

    public interface LifecycleNotification {
        void onAppBackgroundNotify(boolean r100);
    }

    public static /* synthetic */ void a() {
        lambda$register$0();
    }

    static {
        sObserver = new MapLifecycleObserver();
        sMainHandler = new Handler(Looper.getMainLooper());
        sNotifications = new ArrayList();
    }

    public static synchronized void register() {
        monitor-enter(MapLifecycleObserver.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sInit == false) goto L8;
        monitor-exit(MapLifecycleObserver.class);
        return;
    L8:
        sMainHandler.post(new a());     // Catch: Throwable -> L11
        sInit = true;     // Catch: Throwable -> L11
        monitor-exit(MapLifecycleObserver.class);
    }

    private static /* synthetic */ void lambda$register$0() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(sObserver);
    }

    private MapLifecycleObserver() {
    }

    public static synchronized void addNotification(LifecycleNotification r100) {
        monitor-enter(MapLifecycleObserver.class);
        if (r100 != null) goto L13;
        monitor-exit(MapLifecycleObserver.class);
        return;
    L13:
        sNotifications.add(r100);     // Catch: Throwable -> L10
        monitor-exit(MapLifecycleObserver.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static synchronized void notifySwitch(boolean r100) {
        monitor-enter(MapLifecycleObserver.class);
        List<LifecycleNotification> r101 = sNotifications;     // Catch: Throwable -> L15
        if (r101 != null) goto L7;
    L13:
        monitor-exit(MapLifecycleObserver.class);
        return;
    L7:
        if (r101.size() <= 0) goto L13;
        Iterator<LifecycleNotification> r102 = sNotifications.iterator();     // Catch: Throwable -> L15
    L10:
        if (r102.hasNext() == false) goto L13;
        r102.next().onAppBackgroundNotify(r100);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized void removeNotification(LifecycleNotification r100) {
        monitor-enter(MapLifecycleObserver.class);
        if (r100 != null) goto L13;
        monitor-exit(MapLifecycleObserver.class);
        return;
    L13:
        sNotifications.remove(r100);     // Catch: Throwable -> L10
        monitor-exit(MapLifecycleObserver.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        MapLogger.i(TAG, "MyLifecycleObserver onStateChanged: event = " + r101);
        if (r101 != Lifecycle.Event.ON_START) goto L6;
        MapLogger.i(TAG, "MyLifecycleObserver onAppForeground");
        notifySwitch(false);
        return;
    L6:
        if (r101 != Lifecycle.Event.ON_STOP) goto L10;
        MapLogger.i(TAG, "MyLifecycleObserver onAppBackground");
        notifySwitch(true);
        return;
    }
}
