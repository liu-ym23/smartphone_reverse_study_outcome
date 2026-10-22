package com.larus.dora.impl.core;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {
    public static final Set<String> a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (l69.a.a("DoraBluetoothEx") == true) goto L6;
        g49.d.e("DoraBluetoothEx", "getBluetoothConnectedDevice: bluetooth connect permission not granted");
        return SetsKt.emptySet();
    L6:
        BluetoothAdapter r101 = null;
        BluetoothManager r102 = (BluetoothManager) ContextCompat.getSystemService(r100, BluetoothManager.class);     // Catch: Throwable -> L9
    L11:
        if (r102 == null) goto L17;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r101 = r102.getAdapter();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        g49.d.c("DoraBtPermission", "safeAdapter: failed to get adapter", th);
    L17:
        if (r101 != null) goto L52;
        g49.d.d("DoraBluetoothEx", "getBluetoothConnectedDevice: bluetoothAdapter is null");
        return SetsKt.emptySet();
    L52:
        Set<BluetoothDevice> r103 = l69.a.d(r101);     // Catch: Throwable -> L22
    L25:
        if (r103.isEmpty() == false) goto L50;
        g49.d.d("DoraBluetoothEx", "getBluetoothConnectedDevice: boundDevice is empty");
        return SetsKt.emptySet();
    L50:
        List r104 = CollectionsKt.filterNotNull(r103);     // Catch: Throwable -> L43
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L43
        Iterator r106 = r104.iterator();     // Catch: Throwable -> L43
    L30:
        if (r106.hasNext() == false) goto L34;
        Object r107 = r106.next();     // Catch: Throwable -> L43
        if (b((BluetoothDevice) r107) == false) goto L30;
        r105.add(r107);     // Catch: Throwable -> L43
        goto L30
    L34:
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));     // Catch: Throwable -> L43
        Iterator r109 = r105.iterator();     // Catch: Throwable -> L43
    L36:
        if (r109.hasNext() == false) goto L41;
        String r110 = ((BluetoothDevice) r109.next()).getAddress();     // Catch: Throwable -> L43
        if (r110 != null) goto L40;
        r110 = "";
    L40:
        r108.add(r110);     // Catch: Throwable -> L43
        goto L36
    L41:
        return CollectionsKt.toSet(r108);
    L43:
        th = move-exception;
        g49.d.c("DoraBluetoothEx", "getBluetoothConnectedDevice: error when filtering connected devices", th);
        return SetsKt.emptySet();
    L22:
        th = move-exception;
        g49.d.c("DoraBluetoothEx", "getBluetoothConnectedDevice: error when reading bondedDevices", th);
        r103 = SetsKt.emptySet();
    L9:
        th = move-exception;
        g49.d.c("DoraBluetoothEx", "getBluetoothConnectedDevice: failed to get BluetoothManager", th);
        r102 = null;
        goto L11
    }

    public static final boolean b(BluetoothDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "device");
        Object r101 = BluetoothDevice.class.getMethod("isConnected", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L5
        boolean r102 = ((Boolean) r101).booleanValue();     // Catch: Throwable -> L5
        g49.d.d("DoraBluetoothEx", "isDeviceConnected: " + com.larus.dora.impl.util.h.a(r100.getAddress()) + ' ' + r102);     // Catch: Throwable -> L5
        return r102;
    L5:
        th = move-exception;
        g49.d.c("DoraBluetoothEx", "isDeviceConnected: Exception", th);
        return false;
    }
}
