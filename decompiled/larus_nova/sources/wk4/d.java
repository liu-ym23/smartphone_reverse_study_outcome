package wk4;

import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.dora.wlan.direct.WifiDirectOwnerProxy;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements WifiP2pManager.ActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f560099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f560100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f560101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f560102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ WifiDirectOwnerProxy f560103e;

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onSuccess() {
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "createGroup exec success");
        cl4.b.c(true, this.f560099a, this.f560100b, SystemClock.elapsedRealtime() - this.f560101c, false, this.f560102d, 0);
        WifiDirectOwnerProxy r100 = this.f560103e;
        r100.f204670a.requestGroupInfo(r100.f204672c, new c(this));
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onFailure(int r110) {
        pk4.j.b("WifiDirectOwnerProxy@8321b42", "createGroup exec failed: " + r110);
        cl4.b.c(false, this.f560099a, this.f560100b, SystemClock.elapsedRealtime() - this.f560101c, false, this.f560102d, r110);
        WifiDirectOwnerProxy r100 = this.f560103e;
        int r101 = this.f560102d;
        int r111 = this.f560099a;
        int r102 = WifiDirectOwnerProxy.f204669k;
        r100.getClass();
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 29) goto L5;
        WifiP2pConfig r104 = new WifiP2pConfig.Builder().setNetworkName(n.n()).setPassphrase("CzxZ2LTx").enablePersistentMode(true).setGroupOperatingFrequency(5745).build();
    L6:
        r104.wps.setup = 0;
        f r105 = new f(r100, r111, SystemClock.elapsedRealtime(), r101);
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "fallbackCreateGroup start");
        if (r103 < 29) goto L9;
        r100.f204670a.createGroup(r100.f204672c, r104, r105);
        return;
    L9:
        r100.f204670a.createGroup(r100.f204672c, r105);
        return;
    L5:
        r104 = new WifiP2pConfig();
        goto L6
    }

    public d(WifiDirectOwnerProxy r100, int r101, int r102, long r103, int r104) {
        this.f560103e = r100;
        this.f560099a = r101;
        this.f560100b = r102;
        this.f560101c = r103;
        this.f560102d = r104;
    }
}
