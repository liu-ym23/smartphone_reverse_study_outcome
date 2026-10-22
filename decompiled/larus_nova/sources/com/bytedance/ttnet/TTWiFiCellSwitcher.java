package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.sheet.fab.FabItem;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: loaded from: classes6.dex */
    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType CELL = null;
        public static final NetworkType WIFI = null;
        final int networkType;

        static {
            NetworkType r100 = new NetworkType("WIFI", 0, 0);
            WIFI = r100;
            NetworkType r101 = new NetworkType(FabItem.FabSheetItem.CellType.CELL, 1, 1);
            CELL = r101;
            $VALUES = new NetworkType[]{r100, r101};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public int code() {
            return this.networkType;
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) r27.a.a(NetworkType.class, r100);
        }

        private NetworkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.networkType = r102;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface Observer {
        void onStateChanged(State r100, State r101);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class SInstanceHolder {
        static final TTWiFiCellSwitcher sInstance = null;

        private SInstanceHolder() {
        }

        static {
            sInstance = new TTWiFiCellSwitcher();
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        private static final Map<Integer, State> BY_CODE = null;
        public static final State DEFAULT_CELLULAR = null;
        public static final State DEFAULT_WIFI_WITH_CELLULAR_DOWN = null;
        public static final State DEFAULT_WIFI_WITH_CELLULAR_UP = null;
        public static final State EVALUATE_CELLULAR = null;
        public static final State NO_NETWORK = null;
        public static final State STOPPED = null;
        public static final State UNKNOWN = null;
        public static final State WAIT_CELLULAR_ALWAYS_UP = null;
        public static final State WAIT_USER_ALLOW_TO_CELLULAR = null;
        public static final State WAIT_USER_ALLOW_TO_WIFI = null;
        public static final State WIFI_WITH_CELLULAR_TRANS_DATA = null;
        final int state;

        static {
            int r100 = 0;
            State r101 = new State("UNKNOWN", 0, Integer.MIN_VALUE);
            UNKNOWN = r101;
            State r102 = new State("STOPPED", 1, -1);
            STOPPED = r102;
            State r103 = new State("NO_NETWORK", 2, 0);
            NO_NETWORK = r103;
            State r104 = new State("DEFAULT_CELLULAR", 3, 1);
            DEFAULT_CELLULAR = r104;
            State r105 = new State("DEFAULT_WIFI_WITH_CELLULAR_DOWN", 4, 2);
            DEFAULT_WIFI_WITH_CELLULAR_DOWN = r105;
            State r106 = new State("DEFAULT_WIFI_WITH_CELLULAR_UP", 5, 3);
            DEFAULT_WIFI_WITH_CELLULAR_UP = r106;
            State r110 = new State("WAIT_CELLULAR_ALWAYS_UP", 6, 4);
            WAIT_CELLULAR_ALWAYS_UP = r110;
            State r111 = new State("WAIT_USER_ALLOW_TO_CELLULAR", 7, 5);
            WAIT_USER_ALLOW_TO_CELLULAR = r111;
            State r112 = new State("WIFI_WITH_CELLULAR_TRANS_DATA", 8, 6);
            WIFI_WITH_CELLULAR_TRANS_DATA = r112;
            State r113 = new State("EVALUATE_CELLULAR", 9, 7);
            EVALUATE_CELLULAR = r113;
            State r114 = new State("WAIT_USER_ALLOW_TO_WIFI", 10, 8);
            WAIT_USER_ALLOW_TO_WIFI = r114;
            $VALUES = new State[]{r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114};
            BY_CODE = new HashMap();
            State[] r107 = values();
            int r108 = r107.length;
        L3:
            if (r100 >= r108) goto L5;
            State r109 = r107[r100];
            BY_CODE.put(Integer.valueOf(r109.state), r109);
            r100 = r100 + 1;
            goto L3
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public int code() {
            return this.state;
        }

        public static State convertToState(int r100) {
            State r101 = BY_CODE.get(Integer.valueOf(r100));
            if (r101 == null) goto L6;
            return r101;
        L6:
            return UNKNOWN;
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        private State(String r100, int r101, int r102) {
            super(r100, r101);
            this.state = r102;
        }
    }

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

    public boolean notifySwitchToMultiNetwork(boolean r100) {
        HashMap r101 = new HashMap();     // Catch: Exception -> L9
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        r101.put("enable", r102);     // Catch: Exception -> L9
        TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_NOTIFY_SWITCH, r101, null);     // Catch: Exception -> L9
        return true;
    L5:
        r102 = "0";
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void triggerSwitchingToNetwork(NetworkType r100) {
        HashMap r101 = new HashMap();     // Catch: Exception -> L4
        r101.put("network-type", Integer.toString(r100.code()));     // Catch: Exception -> L4
        TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_TRIGGER, r101, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void unregisterObserver(Observer r100) {
        if (r100 == null) goto L11;
        monitor-enter(this);
        this.mObservers.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L11:
        throw new NullPointerException("observer == null");
    }

    private void handleWiFiToCellState(final int r100, final int r101) {
        this.mCurrentState = State.convertToState(r101);
        monitor-enter(this);
        Iterator<Map.Entry<Observer, Handler>> r102 = this.mObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Observer, Handler> r103 = r102.next();     // Catch: Throwable -> L12
        final Observer r104 = r103.getKey();     // Catch: Throwable -> L12
        Handler r105 = r103.getValue();     // Catch: Throwable -> L12
        if (r105 == null) goto L6;
        r105.post(new AnonymousClass1(this, r104, r100, r101));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static void notifyWiFiToCellState(int r100, int r101) {
        inst().handleWiFiToCellState(r100, r101);
    }

    public void registerObserver(Observer r100, Handler r101) {
        if (r100 == null) goto L15;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.containsKey(r100) == true) goto L9;
        if (r101 != null) goto L8;
        this.mObservers.put(r100, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L11
        goto L9
    L8:
        this.mObservers.put(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L15:
        throw new NullPointerException("observer == null");
    }
}
