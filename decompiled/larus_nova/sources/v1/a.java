package v1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;

/* JADX INFO: loaded from: classes39.dex */
public final class a {
    public static BluetoothAdapter a(Context r100) {
        return ((BluetoothManager) r100.getSystemService("bluetooth")).getAdapter();
    }
}
