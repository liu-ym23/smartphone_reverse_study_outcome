package l69;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import g49.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (Build.VERSION.SDK_INT < 31) goto L5;
        List r101 = CollectionsKt.listOf("android.permission.BLUETOOTH_CONNECT");
    L7:
        return b(r100, r101, "connect");
    L5:
        r101 = CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"});
        goto L7
    }

    public static final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (Build.VERSION.SDK_INT < 31) goto L5;
        List r101 = CollectionsKt.listOf("android.permission.BLUETOOTH_SCAN");
    L7:
        return b(r100, r101, "scan");
    L5:
        r101 = CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION"});
        goto L7
    }

    public static final Set<BluetoothDevice> d(BluetoothAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    L16:
        th = move-exception;
        d.c("DoraBtPermission", "safeBondedDevices: unexpected error", th);
        return SetsKt.emptySet();
    L4:
        if (Build.VERSION.SDK_INT >= 31) goto L6;
    L20:
        Set<BluetoothDevice> r101 = r100.getBondedDevices();     // Catch: Throwable -> L13
        if (r101 != null) goto L22;
    L23:
        return SetsKt.emptySet();
    L22:
        return r101;
    L13:
        th = move-exception;
        d.c("DoraBtPermission", "safeBondedDevices: error when accessing bondedDevices", th);     // Catch: Throwable -> L16
        return SetsKt.emptySet();
    L6:
        if (a("DoraBtPermission") == true) goto L20;
        d.e("DoraBtPermission", "safeBondedDevices: BLUETOOTH_CONNECT permission not granted, return empty set");     // Catch: Throwable -> L16
        return SetsKt.emptySet();
    }

    public static final boolean b(String r100, List<String> r101, String r102) {
        Application r103 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L17
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L17
        Iterator<T> r105 = r101.iterator();     // Catch: Throwable -> L17
    L4:
        boolean r106 = true;
        if (r105.hasNext() == false) goto L13;
        Object r107 = r105.next();     // Catch: Throwable -> L17
        if (ContextCompat.checkSelfPermission(r103, (String) r107) != 0) goto L10;
        r106 = false;
    L10:
        if (r106 == false) goto L4;
        r104.add(r107);     // Catch: Throwable -> L17
        goto L4
    L13:
        if ((!r104.isEmpty()) == false) goto L16;
        d.e(r100, "ensure" + r102 + " permission missing: " + r104);     // Catch: Throwable -> L17
        return false;
    L16:
        return true;
    L17:
        th = move-exception;
        d.c(r100, "ensure" + r102 + " permission error", th);
        return false;
    }
}
