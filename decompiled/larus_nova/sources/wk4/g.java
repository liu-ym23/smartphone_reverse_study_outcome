package wk4;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import com.bytedance.dora.wlan.direct.WifiDirectOwnerProxy;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import java.util.ArrayList;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements WifiP2pManager.GroupInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f560109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WifiDirectOwnerProxy f560110b;

    @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
    public final void onGroupInfoAvailable(WifiP2pGroup r210) {
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "requestGroupInfo -> onGroupInfoAvailable: " + r210);
        if (r210 == null) goto L5;
        WifiDirectOwnerProxy.k(this.f560110b, r210);
        return;
    L5:
        WifiDirectOwnerProxy r100 = this.f560110b;
        int r110 = this.f560109a;
        int r101 = WifiDirectOwnerProxy.f204669k;
        r100.getClass();
        if (Build.VERSION.SDK_INT < 29) goto L38;
        WifiManager r102 = (WifiManager) n.f529659c.getSystemService("wifi");
        ArrayList r103 = new ArrayList();
        Object[] r104 = new Object[0];
        f06.b r105 = new f06.b();
        g06.a r111 = ApiHookConfig.f245611b.get(102301);
        if (r111 == null) goto L10;
        f06.a[] r112 = r111.f479473i;
    L11:
        f06.a[] r113 = r112;
        int r114 = r113.length;
        int r115 = 0;
    L13:
        if (r115 >= r114) goto L20;
        f06.a r116 = r113[r115];
        int r211 = r115;
        int r212 = r114;
        f06.a[] r213 = r113;
        f06.d r117 = r116.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r102, r104, "android.net.wifi.WifiInfo", r105);     // Catch: Exception -> L44
        if (r117.f474982a == true) goto L22;
        r103.add(r116);     // Catch: Exception -> L44
    L22:
        if (r117.f474982a == false) goto L24;
        WifiInfo r106 = (WifiInfo) r117.f474983b;
    L25:
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "getGroupOperatingFrequency: connectionInfo=" + r106);
        if (r106 == null) goto L36;
        int r107 = r106.getFrequency();
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "getGroupOperatingFrequency: the current Wi-Fi connection freq=" + r107);
        if (r107 >= 4900) goto L31;
        Pair r108 = new Pair(Integer.valueOf(r107), 5745);
    L37:
        int r109 = ((Integer) r108.first).intValue();
        int r118 = ((Integer) r108.second).intValue();
        int r119 = r118;
        int r120 = r109;
        WifiP2pConfig r121 = new WifiP2pConfig.Builder().setNetworkName(n.n()).setPassphrase("CzxZ2LTx").enablePersistentMode(true).setGroupOperatingFrequency(r118).build();
    L39:
        r121.wps.setup = 0;
        d r122 = new d(r100, r120, r119, SystemClock.elapsedRealtime(), r110);
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "createGroup: start");
        if (Build.VERSION.SDK_INT < 29) goto L42;
        r100.f204670a.createGroup(r100.f204672c, r121, r122);
        return;
    L42:
        r100.f204670a.createGroup(r100.f204672c, r122);
        return;
    L31:
        if (r107 >= 5250) goto L33;
    L35:
        r108 = new Pair(Integer.valueOf(r107), Integer.valueOf(r107));
        goto L37
    L33:
        if (r107 > 5350) goto L35;
        r108 = new Pair(Integer.valueOf(r107), 5745);
        goto L37
    L36:
        r108 = new Pair(-1, 5745);
        goto L37
    L24:
        r106 = r102.getConnectionInfo();
    L19:
        r115 = r211 + 1;
        r114 = r212;
        r113 = r213;
        goto L13
    L20:
        r117 = new f06.d(false, null);
        goto L22
    L10:
        r112 = ApiHookConfig.f245613d;
        goto L11
    L38:
        r121 = new WifiP2pConfig();
        r120 = -1;
        r119 = -1;
        goto L39
    }

    public g(WifiDirectOwnerProxy r100, int r101) {
        this.f560110b = r100;
        this.f560109a = r101;
    }
}
