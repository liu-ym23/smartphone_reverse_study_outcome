package com.obric.cae.libs.wifi.basicInfo;

import android.net.NetworkInfo;
import com.obric.cae.libs.utils.LogUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes33.dex */
public class WifiState {
    public static final int STATE_CONNECTED = 5;
    public static final int STATE_CONNECTING = 4;
    public static final int STATE_DISCONNECTED = 7;
    public static final int STATE_DISCONNECTING = 6;
    public static final int STATE_OFF = 1;
    public static final int STATE_ON = 3;
    public static final int STATE_TURNING_OFF = 0;
    public static final int STATE_TURNING_ON = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f396027a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f396028a = null;

        static {
            int[] r100 = new int[NetworkInfo.DetailedState.values().length];
            f396028a = r100;
            r100[NetworkInfo.DetailedState.CONNECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f396028a[NetworkInfo.DetailedState.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f396028a[NetworkInfo.DetailedState.DISCONNECTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f396028a[NetworkInfo.DetailedState.DISCONNECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public int getState() {
        return this.f396027a.get();
    }

    public boolean isConnected() {
        if (this.f396027a.get() != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public WifiState() {
        this.f396027a = new AtomicInteger(-1);
    }

    public void handleConnectStateChanged(NetworkInfo.DetailedState r100) {
        int r101 = a.f396028a[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f396027a.set(4);
        return;
    L5:
        if (r101 != 2) goto L7;
        this.f396027a.set(5);
        return;
    L7:
        if (r101 == 3) goto L11;
        if (r101 == 4) goto L10;
        LogUtil.e("WifiState", "Set an invalid value for wifi connect state: " + r100);
        return;
    L10:
        this.f396027a.set(7);
        return;
    L11:
        this.f396027a.set(6);
    }

    public void handleWifiStateChanged(int r100) {
        if (r100 != 0) goto L4;
        this.f396027a.set(0);
        return;
    L4:
        if (r100 != 1) goto L6;
        this.f396027a.set(1);
        return;
    L6:
        if (r100 != 2) goto L8;
        this.f396027a.set(2);
        return;
    L8:
        if (r100 == 3) goto L10;
        LogUtil.e("WifiState", "Set an invalid value for wifi state: " + r100);
        return;
    L10:
        this.f396027a.set(3);
    }
}
