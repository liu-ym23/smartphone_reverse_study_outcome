package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTMultiNetwork {
    private static final String HEADER_ACTIVE_RESULT = "ActiveResult";
    private static final String HOST_MULTINET = "multinet";
    private static final String PATH_ACTIVATE_CELL = "/activatecell";
    private static final String TAG = "TTMultiNetwork";
    private static volatile ActiveResult sActiveResult;
    private static volatile State sCurrentState;
    private static Map<Observer, Handler> sObservers;

    /* JADX INFO: loaded from: classes3.dex */
    public static final enum ActiveResult extends Enum<ActiveResult> {
        private static final /* synthetic */ ActiveResult[] $VALUES = null;
        public static final ActiveResult ACTIVATION_IN_PROGRESS = null;
        private static final Map<Integer, ActiveResult> CODE_MAP = null;
        public static final ActiveResult DEFAULT = null;
        public static final ActiveResult DEFERRED_UNSUITABLE_NETWORK = null;
        public static final ActiveResult FAILED = null;
        public static final ActiveResult SUCCESS = null;
        public static final ActiveResult UNKNOWN = null;
        private final int code;

        static {
            int r100 = 0;
            ActiveResult r101 = new ActiveResult("UNKNOWN", 0, Integer.MIN_VALUE);
            UNKNOWN = r101;
            ActiveResult r102 = new ActiveResult("DEFAULT", 1, 0);
            DEFAULT = r102;
            ActiveResult r103 = new ActiveResult("SUCCESS", 2, 1);
            SUCCESS = r103;
            ActiveResult r104 = new ActiveResult("FAILED", 3, 2);
            FAILED = r104;
            ActiveResult r105 = new ActiveResult("DEFERRED_UNSUITABLE_NETWORK", 4, 3);
            DEFERRED_UNSUITABLE_NETWORK = r105;
            ActiveResult r106 = new ActiveResult("ACTIVATION_IN_PROGRESS", 5, 4);
            ACTIVATION_IN_PROGRESS = r106;
            $VALUES = new ActiveResult[]{r101, r102, r103, r104, r105, r106};
            CODE_MAP = new HashMap();
            ActiveResult[] r107 = values();
            int r108 = r107.length;
        L3:
            if (r100 >= r108) goto L5;
            ActiveResult r109 = r107[r100];
            CODE_MAP.put(Integer.valueOf(r109.code), r109);
            r100 = r100 + 1;
            goto L3
        }

        public static ActiveResult[] values() {
            return (ActiveResult[]) $VALUES.clone();
        }

        public int code() {
            return this.code;
        }

        public int getCode() {
            return this.code;
        }

        public static ActiveResult convertToResult(String r100) {
            int r101 = CastIntegerProtector.parseInt(r100);     // Catch: NumberFormatException -> L7
            ActiveResult r102 = CODE_MAP.get(Integer.valueOf(r101));     // Catch: NumberFormatException -> L7
            if (r102 != null) goto L11;
            return UNKNOWN;
        L11:
            return r102;
        L8:
            return UNKNOWN;
        }

        public static ActiveResult valueOf(String r100) {
            return (ActiveResult) r27.a.a(ActiveResult.class, r100);
        }

        private ActiveResult(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface Observer {
        void onMultiNetStateChanged(State r100, State r101, long r102);

        void onUserSpecifiedNetworkEnabled(boolean r100, long r101);
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        private static final Map<Integer, State> CODE_MAP = null;
        public static final State DEFAULT_CELLULAR_WITH_WIFI_DOWN = null;
        public static final State DEFAULT_CELLULAR_WITH_WIFI_UP = null;
        public static final State DEFAULT_VPN = null;
        public static final State DEFAULT_WIFI_WITH_CELLULAR_DOWN = null;
        public static final State DEFAULT_WIFI_WITH_CELLULAR_UP = null;
        public static final State INVALID = null;
        public static final State NO_NETWORK = null;
        public static final State STOPPED = null;
        public static final State UNKNOWN = null;
        public static final State WAIT_CELLULAR_ALWAYS_UP = null;
        final int state;

        static {
            int r100 = 0;
            State r101 = new State("UNKNOWN", 0, Integer.MIN_VALUE);
            UNKNOWN = r101;
            State r102 = new State("INVALID", 1, -2);
            INVALID = r102;
            State r103 = new State("STOPPED", 2, -1);
            STOPPED = r103;
            State r104 = new State("NO_NETWORK", 3, 0);
            NO_NETWORK = r104;
            State r105 = new State("DEFAULT_CELLULAR_WITH_WIFI_DOWN", 4, 1);
            DEFAULT_CELLULAR_WITH_WIFI_DOWN = r105;
            State r106 = new State("DEFAULT_WIFI_WITH_CELLULAR_DOWN", 5, 2);
            DEFAULT_WIFI_WITH_CELLULAR_DOWN = r106;
            State r110 = new State("DEFAULT_WIFI_WITH_CELLULAR_UP", 6, 3);
            DEFAULT_WIFI_WITH_CELLULAR_UP = r110;
            State r111 = new State("WAIT_CELLULAR_ALWAYS_UP", 7, 4);
            WAIT_CELLULAR_ALWAYS_UP = r111;
            State r112 = new State("DEFAULT_VPN", 8, 5);
            DEFAULT_VPN = r112;
            State r107 = new State("DEFAULT_CELLULAR_WITH_WIFI_UP", 9, 6);
            DEFAULT_CELLULAR_WITH_WIFI_UP = r107;
            $VALUES = new State[]{r101, r102, r103, r104, r105, r106, r110, r111, r112, r107};
            CODE_MAP = new HashMap();
            State[] r108 = values();
            int r109 = r108.length;
        L3:
            if (r100 >= r109) goto L5;
            State r113 = r108[r100];
            CODE_MAP.put(Integer.valueOf(r113.state), r113);
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
            State r101 = CODE_MAP.get(Integer.valueOf(r100));
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

    public TTMultiNetwork() {
    }

    static {
        sCurrentState = State.STOPPED;
        sActiveResult = ActiveResult.DEFAULT;
        sObservers = new HashMap();
    }

    public static void tryActivateAlternativeNet() {
        TTNetProtocolUtil.sendTTNetProtocolRequestAsync(HOST_MULTINET, PATH_ACTIVATE_CELL, null, null, new AnonymousClass1());     // Catch: Exception -> L4
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

    public static /* synthetic */ ActiveResult access$002(ActiveResult r100) {
        sActiveResult = r100;
        return r100;
    }

    public static /* synthetic */ void access$100(boolean r100) {
        notifyUserSpecifiedNetworkEnabled(r100);
    }

    private static void notifyUserSpecifiedNetworkEnabled(final boolean r100) {
        final long r101 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<Observer, Handler>> r102 = sObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Observer, Handler> r103 = r102.next();     // Catch: Throwable -> L12
        final Observer r104 = r103.getKey();     // Catch: Throwable -> L12
        Handler r105 = r103.getValue();     // Catch: Throwable -> L12
        if (r105 == null) goto L6;
        r105.post(new AnonymousClass3(r104, r100, r101));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void unregisterMultiNetObserver(Observer r100) {
        if (r100 == null) goto L12;
        monitor-enter(TTMultiNetwork.class);
        sObservers.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new NullPointerException("observer == null");
    }

    private static void notifyMultiNetworkState(final int r110, final int r111) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "notifyMultiNetworkState, prev: " + r110 + ", curr: " + r111);
    L5:
        sCurrentState = State.convertToState(r111);
        final long r100 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<Observer, Handler>> r101 = sObservers.entrySet().iterator();     // Catch: Throwable -> L15
    L9:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<Observer, Handler> r102 = r101.next();     // Catch: Throwable -> L15
        final Observer r103 = r102.getKey();     // Catch: Throwable -> L15
        Handler r112 = r102.getValue();     // Catch: Throwable -> L15
        if (r112 == null) goto L9;
        r112.post(new AnonymousClass2(r103, r110, r111, r100));     // Catch: Throwable -> L15
        goto L9
    L13:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static void registerMultiNetObserver(Observer r100, Handler r101) {
        if (r100 == null) goto L16;
        monitor-enter(TTMultiNetwork.class);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (sObservers.containsKey(r100) == true) goto L10;
        if (r101 != null) goto L9;
        sObservers.put(r100, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L12
        goto L10
    L9:
        sObservers.put(r100, r101);     // Catch: Throwable -> L12
    L10:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L12
        return;
    L16:
        throw new NullPointerException("observer == null");
    }
}
