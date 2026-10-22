package wk4;

import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements WifiP2pManager.ConnectionInfoListener {
    public k() {
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
    public final void onConnectionInfoAvailable(WifiP2pInfo r100) {
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "onConnectionInfoAvailable: " + r100);
    }
}
