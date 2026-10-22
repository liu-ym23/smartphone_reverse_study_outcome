package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class TTMultiNetwork {
    private static final String HEADER_ACTIVE_RESULT = "ActiveResult";
    private static final String HOST_MULTINET = "multinet";
    private static final String PATH_ACTIVATE_CELL = "/activatecell";
    private static final String TAG = "TTMultiNetwork";
    private static volatile ActiveResult sActiveResult;
    private static volatile State sCurrentState;
    private static Map<Observer, Handler> sObservers;

    public TTMultiNetwork() {
    }

    static {
        sCurrentState = State.STOPPED;
        sActiveResult = ActiveResult.DEFAULT;
        sObservers = new HashMap();
    }

    public static void tryActivateAlternativeNet() {
        TTNetProtocolUtil.sendTTNetProtocolRequestAsync(HOST_MULTINET, PATH_ACTIVATE_CELL, null, null, new 1());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void triggerSwitchingToCellular() {
        TTWiFiCellSwitcher.inst().triggerSwitchingToNetwork(TTWiFiCellSwitcher.NetworkType.CELL);
    }

    public static ActiveResult getActiveResult() {
        return sActiveResult;
    }

    public static State getCurrentState() {
        return sCurrentState;
    }

    public static /* synthetic */ ActiveResult access$002(ActiveResult r0) {
        sActiveResult = r0;
        return r0;
    }

    public static /* synthetic */ void access$100(boolean r0) {
        notifyUserSpecifiedNetworkEnabled(r0);
    }

    private static void notifyUserSpecifiedNetworkEnabled(boolean r7) {
        long r0 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<Observer, Handler>> r3 = sObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<Observer, Handler> r4 = r3.next();     // Catch: Throwable -> L12
        Observer r5 = r4.getKey();     // Catch: Throwable -> L12
        Handler r6 = r4.getValue();     // Catch: Throwable -> L12
        if (r6 == null) goto L6;
        r6.post(new 3(r5, r7, r0));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void unregisterMultiNetObserver(Observer r2) {
        if (r2 == null) goto L12;
        monitor-enter(TTMultiNetwork.class);
        sObservers.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new NullPointerException("observer == null");
    }

    private static void notifyMultiNetworkState(int r12, int r13) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "notifyMultiNetworkState, prev: " + r12 + ", curr: " + r13);
    L5:
        sCurrentState = State.convertToState(r13);
        long r7 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<Observer, Handler>> r9 = sObservers.entrySet().iterator();     // Catch: Throwable -> L15
    L9:
        if (r9.hasNext() == false) goto L13;
        Map.Entry<Observer, Handler> r1 = r9.next();     // Catch: Throwable -> L15
        Observer r2 = r1.getKey();     // Catch: Throwable -> L15
        Handler r10 = r1.getValue();     // Catch: Throwable -> L15
        if (r10 == null) goto L9;
        r10.post(new 2(r2, r12, r13, r7));     // Catch: Throwable -> L15
        goto L9
    L13:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static void registerMultiNetObserver(Observer r3, Handler r4) {
        if (r3 == null) goto L16;
        monitor-enter(TTMultiNetwork.class);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (sObservers.containsKey(r3) == true) goto L10;
        if (r4 != null) goto L9;
        sObservers.put(r3, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L12
        goto L10
    L9:
        sObservers.put(r3, r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L12
        return;
    L16:
        throw new NullPointerException("observer == null");
    }
}
