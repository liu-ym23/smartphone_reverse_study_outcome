package t3;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i extends ScanCallback {
    public i() {
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List<ScanResult> r100) {
        Intrinsics.checkNotNullParameter(r100, "results");
        com.bytedance.ai.bridge.method.device.a r101 = com.bytedance.ai.bridge.method.device.a.f35438a;
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        com.bytedance.ai.bridge.method.device.a.a(r101, (ScanResult) r102.next());
        goto L4
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int r100) {
        com.bytedance.ai.bridge.method.device.a r101 = com.bytedance.ai.bridge.method.device.a.f35438a;
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int r100, ScanResult r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        com.bytedance.ai.bridge.method.device.a.a(com.bytedance.ai.bridge.method.device.a.f35438a, r101);
    }
}
