package com.bytedance.dora.wlan.p2p;

import android.net.wifi.p2p.WifiP2pManager;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements WifiP2pManager.ActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f204716a;

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onSuccess() {
        pk4.j.d("DoraWifiP2p", "removeGroupIfNecessary: remove group success");
        this.f204716a.run();
    }

    public j(h r100) {
        this.f204716a = r100;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onFailure(int r100) {
        pk4.j.d("DoraWifiP2p", "removeGroupIfNecessary: remove group failed " + r100);
        this.f204716a.run();
    }
}
