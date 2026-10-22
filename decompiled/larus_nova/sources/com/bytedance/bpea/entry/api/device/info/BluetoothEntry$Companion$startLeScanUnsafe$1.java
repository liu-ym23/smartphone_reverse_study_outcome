package com.bytedance.bpea.entry.api.device.info;

import android.bluetooth.BluetoothAdapter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BluetoothEntry$Companion$startLeScanUnsafe$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ BluetoothAdapter.LeScanCallback $callback;
    final /* synthetic */ BluetoothAdapter $this_startLeScanUnsafe;

    public BluetoothEntry$Companion$startLeScanUnsafe$1(BluetoothAdapter r100, BluetoothAdapter.LeScanCallback r101) {
        this.$this_startLeScanUnsafe = r100;
        this.$callback = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startLeScanUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startLeScan(this.$this_startLeScanUnsafe, this.$callback);
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startLeScanUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startLeScan(BluetoothAdapter r100, BluetoothAdapter.LeScanCallback r101) {
        if (fna.g.d() == true) goto L6;
        Boolean r102 = Boolean.valueOf(r100.startLeScan(r101));
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Boolean");
        return r102.booleanValue();
    L6:
        Boolean r103 = Boolean.valueOf(r100.startLeScan(r101));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r104 = r103.booleanValue();
        if (r101 == null) goto L9;
        int r105 = r101.hashCode();
    L10:
        ina.a.b(r105);
        return r104;
    L9:
        r105 = 0;
        goto L10
    }
}
