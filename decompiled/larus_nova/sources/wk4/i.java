package wk4;

import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements WifiP2pManager.NetworkInfoListener {
    public i() {
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.NetworkInfoListener
    public final void onNetworkInfoAvailable(NetworkInfo r100) {
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "onNetworkInfoAvailable: " + r100);
    }
}
