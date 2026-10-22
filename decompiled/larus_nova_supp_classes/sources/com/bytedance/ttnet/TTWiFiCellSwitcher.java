package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class TTWiFiCellSwitcher {
    private static final String ACTION_NAME = "wifi-to-cell";
    private static final String ACTION_PATH_NOTIFY_SWITCH = "/notify-switch";
    private static final String ACTION_PATH_START = "/start";
    private static final String ACTION_PATH_STOP = "/stop";
    private static final String ACTION_PATH_TRIGGER = "/trigger-switch";
    private static final String ACTION_PATH_TRIGGER_THIRD_PARTY = "/trigger-third-party";
    private static final String TAG = "TTWiFiCellSwitchManager";
    private volatile State mCurrentState;
    private final Map<Observer, Handler> mObservers;

    public TTWiFiCellSwitcher() {
        this.mCurrentState = State.STOPPED;
        this.mObservers = new HashMap();
    }

    public void start() {
        TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_START, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void stop() {
        TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_STOP, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void triggerSwitchingToCellular() {
        TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_TRIGGER_THIRD_PARTY, null, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static TTWiFiCellSwitcher inst() {
        return SInstanceHolder.sInstance;
    }

    public State getCurrentState() {
        return this.mCurrentState;
    }

    public boolean notifySwitchToMultiNetwork(boolean r4) {
        HashMap r0 = new HashMap();     // Catch: Exception -> L9
        if (r4 == false) goto L5;
        String r5 = "1";
    L6:
        r0.put("enable", r5);     // Catch: Exception -> L9
        TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_NOTIFY_SWITCH, r0, null);     // Catch: Exception -> L9
        return true;
    L5:
        r5 = MiraMonitor.VALUE_DEFAULT;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void triggerSwitchingToNetwork(NetworkType r4) {
        HashMap r0 = new HashMap();     // Catch: Exception -> L4
        r0.put("network-type", Integer.toString(r4.code()));     // Catch: Exception -> L4
        TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_TRIGGER, r0, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void unregisterObserver(Observer r2) {
        if (r2 == null) goto L11;
        monitor-enter(this);
        this.mObservers.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L11:
        throw new NullPointerException("observer == null");
    }

    private void handleWiFiToCellState(int r5, int r6) {
        this.mCurrentState = State.convertToState(r6);
        monitor-enter(this);
        Iterator<Map.Entry<Observer, Handler>> r0 = this.mObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<Observer, Handler> r1 = r0.next();     // Catch: Throwable -> L12
        Observer r2 = r1.getKey();     // Catch: Throwable -> L12
        Handler r3 = r1.getValue();     // Catch: Throwable -> L12
        if (r3 == null) goto L6;
        r3.post(new 1(this, r2, r5, r6));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static void notifyWiFiToCellState(int r1, int r2) {
        inst().handleWiFiToCellState(r1, r2);
    }

    public void registerObserver(Observer r3, Handler r4) {
        if (r3 == null) goto L15;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.containsKey(r3) == true) goto L9;
        if (r4 != null) goto L8;
        this.mObservers.put(r3, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L11
        goto L9
    L8:
        this.mObservers.put(r3, r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L15:
        throw new NullPointerException("observer == null");
    }
}
