package com.bytedance.bpea.entry.api.device.info;

import android.bluetooth.BluetoothAdapter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BluetoothEntry$Companion$startLeScanUnsafe$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ BluetoothAdapter.LeScanCallback $callback;
    final /* synthetic */ UUID[] $serviceUuids;
    final /* synthetic */ BluetoothAdapter $this_startLeScanUnsafe;

    public BluetoothEntry$Companion$startLeScanUnsafe$2(BluetoothAdapter r100, UUID[] r101, BluetoothAdapter.LeScanCallback r102) {
        this.$this_startLeScanUnsafe = r100;
        this.$serviceUuids = r101;
        this.$callback = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startLeScanUnsafe$2_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startLeScan(this.$this_startLeScanUnsafe, this.$serviceUuids, this.$callback);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startLeScanUnsafe$2_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startLeScan(BluetoothAdapter r100, UUID[] r101, BluetoothAdapter.LeScanCallback r102) {
        Intrinsics.checkNotNullParameter(r101, "serviceUuids");
        if (fna.g.d() == true) goto L6;
        Boolean r103 = Boolean.valueOf(r100.startLeScan(r101, r102));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Boolean");
        return r103.booleanValue();
    L6:
        Boolean r104 = Boolean.valueOf(r100.startLeScan(r101, r102));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r105 = r104.booleanValue();
        if (r102 == null) goto L9;
        int r106 = r102.hashCode();
    L10:
        ina.a.b(r106);
        return r105;
    L9:
        r106 = 0;
        goto L10
    }
}
