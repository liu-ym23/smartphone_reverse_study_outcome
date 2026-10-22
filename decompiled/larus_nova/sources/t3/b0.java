package t3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b0 extends ScanCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f544244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothAdapter f544245b;

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List<ScanResult> r100) {
        Intrinsics.checkNotNullParameter(r100, "results");
        y r101 = this.f544244a;
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.h((ScanResult) r102.next());
        goto L4
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanFailed(int r100) {
        this.f544244a.f544422i = null;
        this.f544244a.f544417d = false;
        this.f544244a.k(this.f544245b.isEnabled(), false, false);
    }

    public b0(y r100, BluetoothAdapter r101) {
        this.f544244a = r100;
        this.f544245b = r101;
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onScanResult(int r100, ScanResult r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f544244a.h(r101);
    }
}
