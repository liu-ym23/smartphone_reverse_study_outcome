package ymc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f568437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ConnectivityManager f568438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Network f568439c;

    public static class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            NetworkInfo r101 = d.access$000().getNetworkInfo(r100);
            if (r101 == null) goto L7;
            r101.toString();
        L7:
            NetworkCapabilities r102 = d.access$000().getNetworkCapabilities(r100);
            if (r102 != null) goto L10;
        L14:
            d.access$200();
            return;
        L10:
            if (r102.hasTransport(0) == false) goto L14;
            if (r102.hasCapability(12) == false) goto L14;
            d.access$100(r100);
            goto L14
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (d.access$000() != null) goto L6;
            return;
        L6:
            if (d.access$300() == null) goto L18;
            NetworkInfo r101 = d.access$000().getNetworkInfo(r100);
            if (r101 == null) goto L12;
            r101.toString();
        L12:
            if (d.access$400(r100) != d.access$400(d.access$300())) goto L14;
            d.access$100(null);
        L14:
            d.access$200();
            return;
        }
    }

    public d() {
    }

    public static boolean alwaysActiveCellularOn() {
    L16:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (preCheck() == true) goto L7;
        return false;
    L7:
        if (f568437a == false) goto L9;
        return true;
    L9:
        NetworkRequest r100 = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();     // Catch: Throwable -> L16
        f568438b.requestNetwork(r100, new a());     // Catch: Throwable -> L13
        f568437a = true;     // Catch: Throwable -> L16
        return true;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        return false;
    }

    private static boolean preCheck() {
    L12:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        return false;
    L8:
        if (f568438b != null) goto L10;
        return false;
    L10:
        return true;
    }

    public static long getCellularNetId() {
    L11:
        th = move-exception;
        th.printStackTrace();
        return -1;
    L4:
        if (preCheck() == true) goto L6;
        return -1;
    L6:
        Network r100 = f568439c;     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        return -1;
    L9:
        return getNetId(r100);
    }

    public static String getTransportType() {
    L23:
        th = move-exception;
        th.printStackTrace();
        return "none";
    L4:
        if (preCheck() == true) goto L7;
        return "invalid";
    L7:
        Network r100 = f568438b.getActiveNetwork();     // Catch: Throwable -> L23
        if (r100 == null) goto L28;
        NetworkCapabilities r101 = f568438b.getNetworkCapabilities(r100);     // Catch: Throwable -> L23
        if (r101 != null) goto L12;
        return "none";
    L12:
        if (r101.hasCapability(12) == true) goto L14;
        return "none";
    L14:
        if (r101.hasTransport(0) == false) goto L17;
        return OnekeyLoginConstants.NETWORK_TYPE_MOBILE_STR;
    L17:
        if (r101.hasTransport(1) == false) goto L21;
        return "wifi";
    L21:
        return "unknown";
    L28:
        return "none";
    }

    private static void printAllNetworks() {
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (preCheck() == true) goto L5;
        return;
    L5:
        Network[] r100 = f568438b.getAllNetworks();     // Catch: Throwable -> L12
        int r101 = r100.length;     // Catch: Throwable -> L12
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        Network r103 = r100[r102];     // Catch: Throwable -> L12
        NetworkInfo r104 = f568438b.getNetworkInfo(r103);     // Catch: Throwable -> L12
        if (r104 == null) goto L10;
        r104.toString();     // Catch: Throwable -> L12
    L10:
        r102 = r102 + 1;
        goto L6
    }

    public static /* synthetic */ ConnectivityManager access$000() {
        return f568438b;
    }

    public static /* synthetic */ void access$200() {
        printAllNetworks();
    }

    public static /* synthetic */ Network access$300() {
        return f568439c;
    }

    public static /* synthetic */ void access$100(Network r100) {
        setCellularNetwork(r100);
    }

    public static /* synthetic */ long access$400(Network r100) {
        return getNetId(r100);
    }

    private static long getNetId(Network r100) {
        if (r100 != null) goto L15;
        return 0;
    L15:
    L12:
        th = move-exception;
        th.printStackTrace();
        return 0;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L11;
        return r100.getNetworkHandle();
    L11:
        return CastIntegerProtector.parseInt(r100.toString());
    }

    public static int getNetType(Context r100) {
        NetworkInfo r101 = getNetworkInfo(r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        if (r101.isAvailable() == false) goto L9;
        return r101.getType();
    L9:
        return -1;
    }

    public static NetworkInfo getNetworkInfo(Context r100) {
        return ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();
    L4:
        return null;
    }

    public static boolean init(Context r100) {
        if (r100 != null) goto L20;
        return false;
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return false;
    L6:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_NETWORK_STATE") == 0) goto L9;
        return false;
    L9:
        if (Build.VERSION.SDK_INT >= 24) goto L13;
        return false;
    L13:
        if (f568438b != null) goto L21;
        f568438b = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L17
        return true;
    L21:
        return true;
    }

    private static void setCellularNetwork(Network r100) {
        monitor-enter(d.class);     // Catch: Throwable -> L10
        f568439c = r100;     // Catch: Throwable -> L7
        monitor-exit(d.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
    }
}
