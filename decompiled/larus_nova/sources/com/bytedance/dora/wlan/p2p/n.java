package com.bytedance.dora.wlan.p2p;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.SystemClock;
import com.bytedance.dora.wlan.model.DoraWifiScene;

/* JADX INFO: loaded from: classes15.dex */
public final class n implements WifiP2pManager.ActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraWifiScene f204733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f204734b;

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onSuccess() {
        pk4.j.d("DoraWifiP2p", "removeGroup success");
        cl4.b.e(true, cl4.b.a(this.f204733a), 0, SystemClock.elapsedRealtime() - this.f204734b);
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onFailure(int r100) {
        pk4.j.d("DoraWifiP2p", "removeGroup failed: " + r100);
        cl4.b.e(false, cl4.b.a(this.f204733a), r100, SystemClock.elapsedRealtime() - this.f204734b);
    }

    public n(DoraWifiScene r100, long r101) {
        this.f204733a = r100;
        this.f204734b = r101;
    }
}
