package com.unicom.online.account.kernel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes41.dex */
public final class ag {
    public ag() {
    }

    public static boolean a(Context r100, String r101) {
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L34
        if (r102 != null) goto L6;
        return false;
    L6:
        NetworkInfo.State r103 = r102.getNetworkInfo(5).getState();     // Catch: Exception -> L34
        aj.a("TYPE_MOBILE_HIPRI network state: ".concat(String.valueOf(r103)));     // Catch: Exception -> L34
        if (r103.compareTo(NetworkInfo.State.CONNECTED) != 0) goto L9;
    L33:
        return true;
    L9:
        if (r103.compareTo(NetworkInfo.State.CONNECTING) == 0) goto L33;
        Method r104 = ConnectivityManager.class.getMethod("startUsingNetworkFeature", new Class[]{Integer.TYPE, String.class});     // Catch: Exception -> L34
        r104.setAccessible(true);     // Catch: Exception -> L34
        int r105 = ((Integer) r104.invoke(r102, new Object[]{0, "enableHIPRI"})).intValue();     // Catch: Exception -> L34
        aj.a("startUsingNetworkFeature for enableHIPRI result: ".concat(String.valueOf(r105)));     // Catch: Exception -> L34
        if ((-1) != r105) goto L15;
        aj.a("Wrong result of startUsingNetworkFeature, maybe problems");     // Catch: Exception -> L34
        return false;
    L15:
        if (r105 != 0) goto L18;
        aj.a("No need to perform additional network settings");     // Catch: Exception -> L34
        return true;
    L18:
        int r106 = al.d(r101);     // Catch: Exception -> L34
        if ((-1) != r106) goto L22;
        aj.a("Wrong host address transformation, result was -1");     // Catch: Exception -> L34
        return false;
    L22:
        int r107 = 0;
    L23:
        if (r107 >= 5) goto L31;
    L28:
        e = move-exception;
        aj.a(e);     // Catch: Exception -> L34
        return false;
    L25:
        if (r102.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) goto L31;
        Thread.sleep(500);     // Catch: InterruptedException -> L28 Exception -> L34
        r107 = r107 + 1;
        goto L23
    L31:
        Class r108 = Integer.TYPE;     // Catch: Exception -> L34
        Method r109 = ConnectivityManager.class.getMethod("requestRouteToHost", new Class[]{r108, r108});     // Catch: Exception -> L34
        r109.setAccessible(true);     // Catch: Exception -> L34
        boolean r110 = ((Boolean) r109.invoke(r102, new Object[]{5, Integer.valueOf(r106)})).booleanValue();     // Catch: Exception -> L34
        aj.a("requestRouteToHost result: ".concat(String.valueOf(r110)));     // Catch: Exception -> L34
        return r110;
    L34:
        e = move-exception;
        aj.a(e);
        return false;
    }
}
