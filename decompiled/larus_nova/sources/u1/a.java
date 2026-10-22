package u1;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.bes.sdk.utils.DeviceProtocol;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f548212a = null;

    static {
        f548212a = new Object();
    }

    public static byte[] a(Context r100, DeviceProtocol r101, BluetoothDevice r102) {
        Object r103 = f548212a;
        monitor-enter(r103);
        byte[] r104 = null;
        if (r101 != DeviceProtocol.PROTOCOL_BLE) goto L7;
    L17:
        b r105 = b.n(r100, null);     // Catch: Throwable -> L23
        r105.getClass();     // Catch: Throwable -> L23
        if (((ArrayList) b.f548221m).size() < r105.j(r102)) goto L21;
        r104 = (byte[]) ListProtector.get(b.f548221m, r105.j(r102));     // Catch: Throwable -> L23
    L21:
        monitor-exit(r103);     // Catch: Throwable -> L23
        return r104;
    L7:
        if (r101 == DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L17;
        if (r101 != DeviceProtocol.PROTOCOL_SPP) goto L14;
        byte[] r106 = c.n(r100, null).l(r102);     // Catch: Throwable -> L23
        monitor-exit(r103);     // Catch: Throwable -> L23
        return r106;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L23
        return new byte[0];
    L23:
        th = move-exception;
        throw th;
    }

    public static void b(Context r100, DeviceProtocol r101, w1.b r102, BluetoothDevice r103) {
        Object r104 = f548212a;
        monitor-enter(r104);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r101 != DeviceProtocol.PROTOCOL_BLE) goto L7;
    L12:
        b r105 = b.n(r100, null);     // Catch: Throwable -> L15
        y1.a.a(b.f548220l, r102, r105.j(r103));     // Catch: Throwable -> L15
    L13:
        monitor-exit(r104);     // Catch: Throwable -> L15
        return;
    L7:
        if (r101 == DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L12;
        if (r101 != DeviceProtocol.PROTOCOL_SPP) goto L13;
        c.n(r100, null).q(r102, r103);     // Catch: Throwable -> L15
        goto L13
    }

    public static boolean c(Context r100, DeviceProtocol r101, byte[] r102, BluetoothDevice r103) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Object r104 = f548212a;
        monitor-enter(r104);
    L27:
        th = move-exception;
        throw th;
    L8:
        if (r101 != DeviceProtocol.PROTOCOL_BLE) goto L10;
    L24:
        boolean r105 = b.n(r100, null).q(r102, r103);     // Catch: Throwable -> L27
        monitor-exit(r104);     // Catch: Throwable -> L27
        return r105;
    L10:
        if (r101 == DeviceProtocol.PROTOCOL_GATT_BR_EDR) goto L24;
        if (r101 != DeviceProtocol.PROTOCOL_SPP) goto L18;
        boolean r106 = c.n(r100, null).t(r102, r103);     // Catch: Throwable -> L27
        monitor-exit(r104);     // Catch: Throwable -> L27
        return r106;
    L18:
        if (r101 != DeviceProtocol.PROTOCOL_USB) goto L22;
        boolean r107 = d.f(r100).g(r102);     // Catch: Throwable -> L27
        monitor-exit(r104);     // Catch: Throwable -> L27
        return r107;
    L22:
        monitor-exit(r104);     // Catch: Throwable -> L27
        return false;
    }
}
