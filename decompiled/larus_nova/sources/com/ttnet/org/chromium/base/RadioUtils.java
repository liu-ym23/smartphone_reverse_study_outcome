package com.ttnet.org.chromium.base;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Process;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
public class RadioUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    private RadioUtils() {
    }

    private static int getCellDataActivity() {
        TraceEvent r100 = TraceEvent.scoped("RadioUtils::getCellDataActivity");
    L12:
        th = move-exception;
        if (r100 != null) goto L21;
    L18:
        throw th;
    L21:
        r100.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L23:
        int r101 = ((TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone")).getDataActivity();     // Catch: SecurityException -> L8 Throwable -> L12
        if (r100 == null) goto L7;
        r100.close();
    L7:
        return r101;
    L8:
        if (r100 == null) goto L24;
        r100.close();
        return -1;
    L24:
        return -1;
    }

    private static int getCellSignalLevel() {
        TraceEvent r100 = TraceEvent.scoped("RadioUtils::getCellSignalLevel");
    L13:
        th = move-exception;
        if (r100 != null) goto L22;
    L19:
        throw th;
    L22:
        r100.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L4:
        int r101 = -1;
        SignalStrength r102 = ApiHelperForP.getSignalStrength((TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone"));     // Catch: SecurityException -> L9 Throwable -> L13
        if (r102 == null) goto L10;
        r101 = r102.getLevel();     // Catch: SecurityException -> L9 Throwable -> L13
        goto L10
    L10:
        if (r100 == null) goto L12;
        r100.close();
    L12:
        return r101;
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r100 = true;
    L8:
        sHaveAccessNetworkState = Boolean.valueOf(r100);
        goto L10
    L7:
        r100 = false;
    L10:
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState != null) goto L10;
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r100 = true;
    L8:
        sHaveAccessWifiState = Boolean.valueOf(r100);
        goto L10
    L7:
        r100 = false;
    L10:
        return sHaveAccessWifiState.booleanValue();
    }

    private static boolean isSupported() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
    L9:
        return false;
    L5:
        if (haveAccessNetworkState() == false) goto L9;
        if (haveAccessWifiState() == false) goto L9;
        return true;
    }

    private static boolean isWifiConnected() {
        TraceEvent r100 = TraceEvent.scoped("RadioUtils::isWifiConnected");
        ConnectivityManager r101 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L19
        Network r102 = ApiHelperForM.getActiveNetwork(r101);     // Catch: Throwable -> L19
        if (r102 != null) goto L9;
        if (r100 == null) goto L8;
        r100.close();
    L8:
        return false;
    L9:
        NetworkCapabilities r103 = r101.getNetworkCapabilities(r102);     // Catch: Throwable -> L19
        if (r103 != null) goto L15;
        if (r100 == null) goto L13;
        r100.close();
    L13:
        return false;
    L15:
        boolean r104 = r103.hasTransport(1);     // Catch: Throwable -> L19
        if (r100 == null) goto L18;
        r100.close();
    L18:
        return r104;
    L19:
        th = move-exception;
        if (r100 != null) goto L28;
    L25:
        throw th;
    L28:
        r100.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }

    static {
    }
}
