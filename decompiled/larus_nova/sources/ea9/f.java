package ea9;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f471723a;

    public final void a() {
        if (this.f471723a.f471695o == true) goto L5;
        return;
    L5:
        e r100 = this.f471723a;
        r100.getClass();
        long r101 = SystemClock.elapsedRealtime();
        long r102 = r100.G;
        if (r102 != 0) goto L8;
        r102 = r100.E;
    L8:
        long r103 = r101 - r102;
        if (r102 != 0) goto L11;
    L19:
        this.f471723a.f471705y.postDelayed(this, 2000);
        return;
    L11:
        if (r103 < 2000) goto L19;
        long r104 = r100.H;
        if (r104 != 0) goto L16;
    L18:
        r100.H = r101;
        ca9.c r105 = ca9.b.f22972a;
        ca9.b.f22972a.c("ScreenShareCaptureDiagnosticsAnomaly", "GlScreenCaptureSession", CollectionsKt.listOf(r100.f471682b), MapsKt.plus(MapsKt.mapOf(TuplesKt.to("callbackGapMs", Long.valueOf(r103))), MapsKt.mapOf(TuplesKt.to("type", "system_callback_stall"))));
        goto L19
    L16:
        if ((r101 - r104) >= 30000) goto L18;
        goto L18
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(e r100) {
        this.f471723a = r100;
    }
}
