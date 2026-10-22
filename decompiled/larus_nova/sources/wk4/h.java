package wk4;

import android.net.wifi.p2p.WifiP2pManager;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements WifiP2pManager.P2pStateListener {
    public h() {
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.P2pStateListener
    public final void onP2pStateAvailable(int r100) {
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "onP2pStateAvailable: " + r100);
    }
}
