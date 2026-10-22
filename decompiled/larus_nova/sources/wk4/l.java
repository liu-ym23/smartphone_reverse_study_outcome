package wk4;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements WifiP2pManager.ActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f560111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f560112b;

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onSuccess() {
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "disconnect success");
        cl4.b.e(true, this.f560111a, 0, SystemClock.elapsedRealtime() - this.f560112b);
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onFailure(int r100) {
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "disconnect failed: " + r100);
        cl4.b.e(false, this.f560111a, r100, SystemClock.elapsedRealtime() - this.f560112b);
    }

    public l(int r100, long r101) {
        this.f560111a = r100;
        this.f560112b = r101;
    }
}
