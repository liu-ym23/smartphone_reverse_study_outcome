package lj4;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.os.Build;
import androidx.core.content.ContextCompat;
import pk4.j;
import pk4.n;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements BluetoothProfile.ServiceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothA2dp f509492a;

    /* JADX INFO: renamed from: lj4.a$a, reason: collision with other inner class name */
    public static class C6701a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f509493a = null;

        static {
            f509493a = new a();
        }
    }

    public a() {
        if (((BluetoothManager) n.f529659c.getSystemService("bluetooth")).getAdapter().getProfileProxy(n.f529659c, this, 2) == true) goto L6;
        j.b("DoraBluetoothAdapter", "getProfileProxy failed");
        return;
    }

    public static int a() {
        BluetoothAdapter r100 = BluetoothAdapter.getDefaultAdapter();
        if (Build.VERSION.SDK_INT < 31) goto L10;
        if (ContextCompat.checkSelfPermission(n.f529659c, "android.permission.BLUETOOTH_SCAN") == 0) goto L7;
    L19:
        boolean r101 = true;
    L21:
        if (r101 == false) goto L24;
        j.f("DoraBluetoothAdapter", "permission not applied");
        return 1;
    L24:
        if (r100 != null) goto L26;
    L29:
        j.f("DoraBluetoothAdapter", "bt is off");
        return 2;
    L26:
        if (r100.isEnabled() == false) goto L29;
        return 0;
    L7:
        if (ContextCompat.checkSelfPermission(n.f529659c, "android.permission.BLUETOOTH_CONNECT") != 0) goto L19;
    L18:
        r101 = false;
        goto L21
    L10:
        if (ContextCompat.checkSelfPermission(n.f529659c, "android.permission.BLUETOOTH") != 0) goto L19;
        if (ContextCompat.checkSelfPermission(n.f529659c, "android.permission.BLUETOOTH_ADMIN") != 0) goto L19;
        if (ContextCompat.checkSelfPermission(n.f529659c, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L19;
        if (ContextCompat.checkSelfPermission(n.f529659c, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L18;
        goto L18
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int r100) {
        this.f509492a = null;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceConnected(int r100, BluetoothProfile r101) {
        this.f509492a = (BluetoothA2dp) r101;
    }
}
