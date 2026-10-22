package com.bytedance.bpea.entry.api.device.info;

import android.app.PendingIntent;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanSettings;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BluetoothEntry$Companion$startScanUnsafe$3 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PendingIntent $callbackIntent;
    final /* synthetic */ List $filters;
    final /* synthetic */ ScanSettings $settings;
    final /* synthetic */ BluetoothLeScanner $this_startScanUnsafe;

    public BluetoothEntry$Companion$startScanUnsafe$3(BluetoothLeScanner r100, List r101, ScanSettings r102, PendingIntent r103) {
        this.$this_startScanUnsafe = r100;
        this.$filters = r101;
        this.$settings = r102;
        this.$callbackIntent = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return this.$this_startScanUnsafe.startScan(this.$filters, this.$settings, this.$callbackIntent);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}
