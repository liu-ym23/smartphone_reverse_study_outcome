package zk4;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import java.util.ArrayList;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class j extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f572641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f572642b;

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        pk4.j.f("DoraWifiSoftAp", "initNetworkCallback: onUnavailable");
        vk4.a.f555471a = null;
        dl4.a.a(new h(this));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r210) {
        super.onAvailable(r210);
        pk4.j.d("DoraWifiSoftAp", "initNetworkCallback: onAvailable " + r210);
        if (Build.VERSION.SDK_INT < 29) goto L5;
    L48:
        pk4.j.d("DoraWifiSoftAp", "initNetworkCallback: bindProcessToNetwork " + r210);
        vk4.a.f555471a = r210;
        dl4.a.a(new g(this));
        return;
    L5:
        if (this.f572641a == null) goto L48;
        WifiManager r100 = (WifiManager) n.f529659c.getApplicationContext().getSystemService("wifi");
        ArrayList r110 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
        if (r101 == null) goto L9;
        f06.a[] r102 = r101.f479473i;
    L10:
        f06.a[] r113 = r102;
        int r114 = r113.length;
        int r103 = 0;
    L12:
        if (r103 >= r114) goto L19;
        f06.a r104 = r113[r103];
        int r115 = r103;
        int r211 = r114;
        f06.a[] r212 = r113;
        f06.d r105 = r104.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r100, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L51
        if (r105.f474982a == true) goto L21;
        r110.add(r104);     // Catch: Exception -> L51
    L21:
        if (r105.f474982a == false) goto L23;
        WifiInfo r106 = (WifiInfo) r105.f474983b;
    L24:
        if (r106 == null) goto L43;
        ArrayList r107 = new ArrayList();
        Object[] r116 = new Object[0];
        f06.b r117 = new f06.b();
        g06.a r108 = ApiHookConfig.f245611b.get(101000);
        if (r108 == null) goto L28;
        f06.a[] r109 = r108.f479473i;
    L29:
        f06.a[] r118 = r109;
        int r119 = r118.length;
        int r120 = 0;
    L31:
        if (r120 >= r119) goto L38;
        f06.a r121 = r118[r120];
        int r122 = r120;
        int r213 = r119;
        f06.a[] r214 = r118;
        f06.d r123 = r121.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r106, r116, "java.lang.String", r117);     // Catch: Exception -> L50
        if (r123.f474982a == true) goto L40;
        r107.add(r121);     // Catch: Exception -> L50
    L40:
        if (r123.f474982a == false) goto L42;
        String r124 = (String) r123.f474983b;
    L44:
        String r125 = f.d(this.f572642b, this.f572641a);
        String r126 = f.d(this.f572642b, r124);
        pk4.j.d("DoraWifiSoftAp", "initNetworkCallback: check SSID, current=" + r124 + ", target=" + this.f572641a);
        if (TextUtils.equals(r125, r126) == true) goto L48;
        pk4.j.f("DoraWifiSoftAp", "initNetworkCallback: SSID mismatch, ignore. current=" + r126 + ", target=" + r125);
        return;
    L42:
        r124 = r106.getSSID();
    L37:
        r120 = r122 + 1;
        r119 = r213;
        r118 = r214;
        goto L31
    L38:
        r123 = new f06.d(false, null);
        goto L40
    L28:
        r109 = ApiHookConfig.f245613d;
        goto L29
    L43:
        r124 = "";
        goto L44
    L23:
        r106 = r100.getConnectionInfo();
    L18:
        r103 = r115 + 1;
        r114 = r211;
        r113 = r212;
        goto L12
    L19:
        r105 = new f06.d(false, null);
        goto L21
    L9:
        r102 = ApiHookConfig.f245613d;
        goto L10
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r100) {
        super.onLost(r100);
        pk4.j.d("DoraWifiSoftAp", "initNetworkCallback: onLost " + r100);
        vk4.a.f555471a = null;
        dl4.a.a(new i(this));
    }

    public j(f r100, String r101) {
        this.f572642b = r100;
        this.f572641a = r101;
    }
}
