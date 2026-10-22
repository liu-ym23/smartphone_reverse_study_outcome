package com.bytedance.bpea.entry.api.device.info;

import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BluetoothEntry$Companion$startScanUnsafe$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ScanCallback $callback;
    final /* synthetic */ List $filters;
    final /* synthetic */ ScanSettings $settings;
    final /* synthetic */ BluetoothLeScanner $this_startScanUnsafe;

    public BluetoothEntry$Companion$startScanUnsafe$2(BluetoothLeScanner r100, List r101, ScanSettings r102, ScanCallback r103) {
        this.$this_startScanUnsafe = r100;
        this.$filters = r101;
        this.$settings = r102;
        this.$callback = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startScanUnsafe$2_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startScan(this.$this_startScanUnsafe, this.$filters, this.$settings, this.$callback);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startScanUnsafe$2_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startScan(BluetoothLeScanner r100, List r101, ScanSettings r102, ScanCallback r103) {
        if (fna.g.d() == true) goto L6;
        r100.startScan(r101, r102, r103);
        return;
    L6:
        r100.startScan(r101, r102, r103);
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L10:
        ina.a.b(r104);
        return;
    L9:
        r104 = 0;
        goto L10
    }
}
