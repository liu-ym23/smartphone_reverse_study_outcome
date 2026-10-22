package com.bytedance.bpea.entry.api.device.info;

import android.telephony.NetworkScan;
import android.telephony.NetworkScanRequest;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyScanManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/telephony/NetworkScan;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TelephonyManagerEntry$Companion$requestNetworkScanUnsafe$1 extends Lambda implements Function0<NetworkScan> {
    final /* synthetic */ TelephonyScanManager.NetworkScanCallback $callback;
    final /* synthetic */ Executor $executor;
    final /* synthetic */ NetworkScanRequest $request;
    final /* synthetic */ TelephonyManager $this_requestNetworkScanUnsafe;

    public TelephonyManagerEntry$Companion$requestNetworkScanUnsafe$1(TelephonyManager r100, NetworkScanRequest r101, Executor r102, TelephonyScanManager.NetworkScanCallback r103) {
        this.$this_requestNetworkScanUnsafe = r100;
        this.$request = r101;
        this.$executor = r102;
        this.$callback = r103;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final NetworkScan invoke() {
        return this.$this_requestNetworkScanUnsafe.requestNetworkScan(this.$request, this.$executor, this.$callback);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ NetworkScan invoke() {
        return invoke();
    }
}
