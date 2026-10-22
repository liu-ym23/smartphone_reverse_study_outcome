package com.bytedance.pitaya.api.mutilinstance;

import android.util.Log;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pitaya/api/mutilinstance/PreHostSetupWatcher;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "TAG", "", "isPreHostSetup", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/pitaya/api/mutilinstance/PreHostSetupListener;", "", "notifyAllListener", "", "onPreHostSetup", "registerListener", "listener", "unregisterListener", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PreHostSetupWatcher implements ReflectionCall {
    public static final PreHostSetupWatcher INSTANCE = null;
    private static final String TAG = "PTY-PreHostSetupWatcher";
    private static final AtomicBoolean isPreHostSetup = null;
    private static final CopyOnWriteArrayList<PreHostSetupListener> listeners = null;

    private PreHostSetupWatcher() {
    }

    static {
        INSTANCE = new PreHostSetupWatcher();
        listeners = new CopyOnWriteArrayList();
        isPreHostSetup = new AtomicBoolean(false);
    }

    private final void notifyAllListener() {
        CopyOnWriteArrayList<PreHostSetupListener> r100 = listeners;
        monitor-enter(r100);
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L16
    L6:
        if (r101.hasNext() == false) goto L13;
        ((PreHostSetupListener) r101.next()).onPreHostSetup(true);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Log.getStackTraceString(th);     // Catch: Throwable -> L16
        goto L6
    L13:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final boolean isPreHostSetup() {
        return isPreHostSetup.get();
    }

    public final void onPreHostSetup() {
        CopyOnWriteArrayList<PreHostSetupListener> r100 = listeners;
        monitor-enter(r100);
        isPreHostSetup.set(true);     // Catch: Throwable -> L7
        INSTANCE.notifyAllListener();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void registerListener(PreHostSetupListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<PreHostSetupListener> r101 = listeners;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isPreHostSetup.get() == false) goto L9;
        r100.onPreHostSetup(true);     // Catch: Throwable -> L12
        monitor-exit(r101);
        return;
    L9:
        r101.add(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);
    }

    public final void unregisterListener(PreHostSetupListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<PreHostSetupListener> r101 = listeners;
        monitor-enter(r101);
        r101.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
