package com.bytedance.bpea.entry.api.device.info;

import android.bluetooth.BluetoothAdapter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BluetoothEntry$Companion$startDiscoveryUnsafe$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ BluetoothAdapter $this_startDiscoveryUnsafe;

    public BluetoothEntry$Companion$startDiscoveryUnsafe$1(BluetoothAdapter r100) {
        this.$this_startDiscoveryUnsafe = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startDiscoveryUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startDiscovery(this.$this_startDiscoveryUnsafe);
    }

    public static boolean INVOKEVIRTUAL_com_bytedance_bpea_entry_api_device_info_BluetoothEntry$Companion$startDiscoveryUnsafe$1_com_obric_performance_power_monitor_bluetooth_BluetoothLancet_startDiscovery(BluetoothAdapter r100) {
        if (fna.g.d() == true) goto L6;
        Boolean r101 = Boolean.valueOf(r100.startDiscovery());
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Boolean");
        return r101.booleanValue();
    L6:
        Boolean r102 = Boolean.valueOf(r100.startDiscovery());
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r103 = r102.booleanValue();
        ina.a.f490630c++;
        return r103;
    }
}
