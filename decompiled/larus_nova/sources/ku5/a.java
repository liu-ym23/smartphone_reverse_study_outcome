package ku5;

import android.content.Context;
import com.bytedance.ee.util.deviceinfo.DeviceInfoDetector;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f506209a;

    public /* synthetic */ a(Context r100) {
        this.f506209a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f506209a;
        AtomicBoolean r101 = DeviceInfoDetector.f243125b;
        if (r101.get() == false) goto L5;
        return;
    L5:
        monitor-enter(DeviceInfoDetector.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (r101.get() == true) goto L9;
        DeviceInfoDetector.a(r100);     // Catch: Throwable -> L11
        r101.set(true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DeviceInfoDetector.class);     // Catch: Throwable -> L11
    }
}
