package com.bytedance.bpea.entry.api.device.info;

import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BluetoothEntry$Companion$startScanUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ScanCallback $callback;
    final /* synthetic */ BluetoothLeScanner $this_startScanUnsafe;

    public BluetoothEntry$Companion$startScanUnsafe$1(BluetoothLeScanner r100, ScanCallback r101) {
        this.$this_startScanUnsafe = r100;
        this.$callback = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startScanUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startScan(this.$this_startScanUnsafe, this.$callback);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startScanUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startScan(BluetoothLeScanner r100, ScanCallback r101) {
        if (fna.g.d() == true) goto L6;
        r100.startScan(r101);
        return;
    L6:
        r100.startScan(r101);
        if (r101 == null) goto L9;
        int r102 = r101.hashCode();
    L10:
        ina.a.b(r102);
        return;
    L9:
        r102 = 0;
        goto L10
    }
}
