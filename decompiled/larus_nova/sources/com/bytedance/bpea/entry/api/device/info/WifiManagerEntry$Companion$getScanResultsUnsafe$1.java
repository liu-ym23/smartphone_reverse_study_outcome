package com.bytedance.bpea.entry.api.device.info;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/net/wifi/ScanResult;", "kotlin.jvm.PlatformType", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class WifiManagerEntry$Companion$getScanResultsUnsafe$1 extends Lambda implements Function0<List<ScanResult>> {
    final /* synthetic */ WifiManager $this_getScanResultsUnsafe;

    public WifiManagerEntry$Companion$getScanResultsUnsafe$1(WifiManager r100) {
        this.$this_getScanResultsUnsafe = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<ScanResult> invoke2() {
        WifiManager r100 = this.$this_getScanResultsUnsafe;
        f06.c r101 = new f06.c();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r101.b(102300, "android/net/wifi/WifiManager", "getScanResults", r100, r110, "java.util.List", r111);
        if (r112.f474982a == false) goto L5;
        r101.a(102300, "android/net/wifi/WifiManager", "getScanResults", r100, r110, null, r111, false);
        return (List) r112.f474983b;
    L5:
        List<ScanResult> r113 = r100.getScanResults();
        r101.a(102300, "android/net/wifi/WifiManager", "getScanResults", r100, r110, r113, r111, true);
        return r113;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<ScanResult> invoke() {
        return invoke2();
    }
}
