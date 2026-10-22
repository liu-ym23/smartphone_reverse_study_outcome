package wk4;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements WifiP2pManager.DeviceInfoListener {
    public j() {
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.DeviceInfoListener
    public final void onDeviceInfoAvailable(WifiP2pDevice r100) {
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "onDeviceInfoAvailable: " + r100);
    }
}
