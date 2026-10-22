package com.ss.android.lark.audit.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.http.netstate.NetworkUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public class NetworkTypeDetector extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NetworkTypeDetector f409454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<lwa.a> f409455b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PthreadHandlerThreadV2 f409456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Handler f409457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static EasyNetworkState f409458e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<lwa.a> r100 = NetworkTypeDetector.f409455b.iterator();     // Catch: Throwable -> L9
        L4:
            if (r100.hasNext() == false) goto L21;
            lwa.a r101 = r100.next();     // Catch: Throwable -> L9
            if (r101 == null) goto L4;
            r101.a(NetworkTypeDetector.f409458e);     // Catch: Throwable -> L9
            goto L4
        L21:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    static {
        f409455b = new CopyOnWriteArrayList();
    }

    public static void d() {
        if (f409456c == null) goto L6;
    L13:
        f409457d.post(new a());
        return;
    L6:
        monitor-enter(NetworkTypeDetector.class);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (f409456c != null) goto L12;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("handler-nettype");     // Catch: Throwable -> L10
        f409456c = r100;     // Catch: Throwable -> L10
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L10
        f409457d = new Handler(f409456c.getLooper());     // Catch: Throwable -> L10
    L12:
        monitor-exit(NetworkTypeDetector.class);     // Catch: Throwable -> L10
        goto L13
    }

    public NetworkTypeDetector() {
    }

    public static EasyNetworkState a(Context r100) {
        Log.i("NetworkTypeDetector", "getCurrNetworkType: start");
        ConnectivityManager r101 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");
        EasyNetworkType r102 = EasyNetworkType.getBasicEasyType(NetworkUtils.a(r100));
        if (b(r101) == false) goto L6;
        r102 = EasyNetworkType.VPN;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        Network r103 = r101.getActiveNetwork();
        if (r103 == null) goto L10;
        String r104 = String.valueOf(r103.getNetworkHandle());
    L11:
        EasyNetworkState r105 = new EasyNetworkState(r102, r104);
        Log.i("NetworkTypeDetector", "getCurrNetworkType: end,easyNetworkType=" + r105.toString());
        return r105;
    L10:
        r104 = "";
        goto L11
    }

    public static boolean b(ConnectivityManager r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Network[] r101 = r100.getAllNetworks();
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L15;
        if (c(r100, r101[r103]) == true) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        return true;
    L15:
        return false;
    L5:
        return c(r100, r100.getActiveNetwork());
    }

    public static boolean e(EasyNetworkState r100) {
        Log.i("NetworkTypeDetector", "updateNetworkType: sCurrNetworkState  == " + f409458e.toString());
        Log.i("NetworkTypeDetector", "updateNetworkType: received networkState == " + r100.toString());
        if (f409458e.getEasyNetworkType().getNumber() == r100.getEasyNetworkType().getNumber()) goto L5;
    L8:
        f409458e = r100;
        return true;
    L5:
        if (TextUtils.equals(f409458e.getNetworkId(), r100.getNetworkId()) == false) goto L8;
        return false;
    }

    public static boolean c(ConnectivityManager r100, Network r101) {
        boolean r102 = false;
        if (r101 != null) goto L19;
        Log.w("NetworkTypeDetector", "hasVPN network==null no VPN");
        return false;
    L19:
        NetworkCapabilities r103 = r100.getNetworkCapabilities(r101);     // Catch: Exception -> L15
        if (r103 != null) goto L9;
    L11:
        if (r103 == null) goto L13;
        Log.i("NetworkTypeDetector", "hasVPN network capabilities has no VPN");     // Catch: Exception -> L15
    L18:
    L17:
        return r102;
    L13:
        Log.i("NetworkTypeDetector", "hasVPN network capabilities == null");     // Catch: Exception -> L15
        goto L18
    L9:
        if (r103.hasTransport(4) == false) goto L11;
        r102 = true;
        Log.i("NetworkTypeDetector", "hasVPN network capabilities has VPN");     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.e("NetworkTypeDetector", "has VPN() method crash, crashInfo:" + e.toString());
        goto L17
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r100 == null) goto L31;
        if (r101 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101.getAction()) == false) goto L10;
        return;
    L10:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == false) goto L32;
        NetworkUtils.NetworkType r102 = NetworkUtils.a(r100);     // Catch: Exception -> L27
        ConnectivityManager r103 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");     // Catch: Exception -> L27
        EasyNetworkType r104 = EasyNetworkType.getBasicEasyType(r102);     // Catch: Exception -> L27
        if (b(r103) == false) goto L15;
        r104 = EasyNetworkType.VPN;     // Catch: Exception -> L27
    L15:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        Network r105 = r103.getActiveNetwork();     // Catch: Exception -> L27
        if (r105 == null) goto L19;
        String r106 = String.valueOf(r105.getNetworkHandle());     // Catch: Exception -> L27
    L20:
        boolean r107 = e(new EasyNetworkState(r104, r106));     // Catch: Exception -> L27
        if (r104.equals(EasyNetworkType.VPN) == false) goto L23;
        Log.i("NetworkTypeDetector", "onReceive end: NetworkType is VPN，do notifyListeners()");     // Catch: Exception -> L27
        d();     // Catch: Exception -> L27
        return;
    L23:
        if (r107 == false) goto L25;
        Log.i("NetworkTypeDetector", "onReceive end: NetworkType changed，do notifyListeners()");     // Catch: Exception -> L27
        d();     // Catch: Exception -> L27
        return;
    L25:
        Log.i("NetworkTypeDetector", "onReceive end: NetworkType does not change");     // Catch: Exception -> L27
        return;
    L19:
        r106 = "";
    L27:
        e = move-exception;
        e.printStackTrace();
        Log.e("NetworkTypeDetector", "onReceive: exp on NetworkTypeChange", e);
        return;
    L32:
        return;
    }
}
