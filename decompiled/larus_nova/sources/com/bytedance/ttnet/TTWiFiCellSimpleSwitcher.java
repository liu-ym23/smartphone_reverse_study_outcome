package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class TTWiFiCellSimpleSwitcher implements TTWiFiCellSwitcher.Observer {
    private final Map<Observer, Handler> mSimpleObservers;
    private volatile int mState;

    /* JADX INFO: renamed from: com.bytedance.ttnet.TTWiFiCellSimpleSwitcher$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State = null;

        static {
            int[] r100 = new int[TTWiFiCellSwitcher.State.values().length];
            $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State = r100;
            r100[TTWiFiCellSwitcher.State.DEFAULT_CELLULAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.WIFI_WITH_CELLULAR_TRANS_DATA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.DEFAULT_WIFI_WITH_CELLULAR_DOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.DEFAULT_WIFI_WITH_CELLULAR_UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.WAIT_CELLULAR_ALWAYS_UP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.WAIT_USER_ALLOW_TO_CELLULAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.WAIT_USER_ALLOW_TO_WIFI.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public interface Observer {
        void onStateChanged(int r100, int r101);
    }

    public static final class SInstanceHolder {
        static final TTWiFiCellSimpleSwitcher sInstance = null;

        private SInstanceHolder() {
        }

        static {
            sInstance = new TTWiFiCellSimpleSwitcher(null);
        }
    }

    public static class SOURCE {
        public static final int PLAYER = 1;
        public static final int TTNET = 0;

        public SOURCE() {
        }
    }

    public static class State {
        public static final int CELL = 2;
        public static final int READY_SWITCH_TO_CELL = 1;
        public static final int READY_SWITCH_TO_WIFI = 3;
        public static final int UNKNOWN = -1;
        public static final int WIFI = 0;

        public State() {
        }
    }

    public void onMessage(int r100, int r101, int r102, JSONObject r103) {
    }

    private TTWiFiCellSimpleSwitcher() {
        this.mState = -1;
        this.mSimpleObservers = new HashMap();
        TTWiFiCellSwitcher.inst().registerObserver(this, null);
    }

    public void start() {
        TTWiFiCellSwitcher.inst().start();
    }

    public void stop() {
        TTWiFiCellSwitcher.inst().stop();
    }

    public void switchToCell() {
        TTWiFiCellSwitcher.inst().start();
        TTWiFiCellSwitcher.inst().triggerSwitchingToNetwork(TTWiFiCellSwitcher.NetworkType.CELL);
    }

    public void switchToWiFi() {
        TTWiFiCellSwitcher.inst().start();
        TTWiFiCellSwitcher.inst().triggerSwitchingToNetwork(TTWiFiCellSwitcher.NetworkType.WIFI);
    }

    public static TTWiFiCellSimpleSwitcher inst() {
        return SInstanceHolder.sInstance;
    }

    public int getCurrentState() {
        return this.mState;
    }

    public /* synthetic */ TTWiFiCellSimpleSwitcher(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ int access$100(TTWiFiCellSimpleSwitcher r100) {
        return r100.mState;
    }

    public void unregisterObserver(Observer r100) {
        if (r100 == null) goto L11;
        monitor-enter(this);
        this.mSimpleObservers.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L11:
        throw new NullPointerException("observer == null");
    }

    @Override // com.bytedance.ttnet.TTWiFiCellSwitcher.Observer
    public void onStateChanged(TTWiFiCellSwitcher.State r100, TTWiFiCellSwitcher.State r101) {
        switch(AnonymousClass2.$SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[r101.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        final int r102 = -1;
    L10:
        if (this.mState == r102) goto L23;
        monitor-enter(this);
        Iterator<Map.Entry<Observer, Handler>> r103 = this.mSimpleObservers.entrySet().iterator();     // Catch: Throwable -> L20
    L14:
        if (r103.hasNext() == false) goto L18;
        Map.Entry<Observer, Handler> r104 = r103.next();     // Catch: Throwable -> L20
        final Observer r105 = r104.getKey();     // Catch: Throwable -> L20
        Handler r106 = r104.getValue();     // Catch: Throwable -> L20
        Runnable r107 = new AnonymousClass1(this, r102, r105);     // Catch: Throwable -> L20
        if (r106 == null) goto L14;
        r106.post(r107);     // Catch: Throwable -> L20
        goto L14
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        this.mState = r102;
        return;
    L20:
        th = move-exception;
        throw th;
    L23:
        return;
    L5:
        r102 = 3;
        goto L10
    L6:
        r102 = 1;
        goto L10
    L7:
        r102 = 0;
        goto L10
    L8:
        r102 = 2;
        goto L10
    }

    public void registerObserver(Observer r100, Handler r101) {
        if (r100 == null) goto L15;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mSimpleObservers.containsKey(r100) == true) goto L9;
        if (r101 != null) goto L8;
        this.mSimpleObservers.put(r100, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L11
        goto L9
    L8:
        this.mSimpleObservers.put(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L15:
        throw new NullPointerException("observer == null");
    }
}
