package n8a;

import android.graphics.RenderNode;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.TraceEvent;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f518363a;

    public final void a() {
        TraceEvent.beginSection("BlurView.reBlur");
    L15:
        th = move-exception;
        TraceEvent.endSection("BlurView.reBlur");
        throw th;
    L4:
        if (this.f518363a.f518353u == true) goto L13;
        a r100 = this.f518363a;     // Catch: Throwable -> L15
        if (r100.f518357y == false) goto L13;
        r100.e();     // Catch: Throwable -> L15
        a r101 = this.f518363a;     // Catch: Throwable -> L15
        RenderNode r102 = r101.f518333a;     // Catch: Throwable -> L15
        if (r102 != null) goto L10;
    L12:
        a r103 = this.f518363a;     // Catch: Throwable -> L15
        r103.f518357y = false;     // Catch: Throwable -> L15
        r103.invalidate();     // Catch: Throwable -> L15
        goto L13
    L10:
        if (r101.f518338f == null) goto L12;
        r102.beginRecording().drawBitmap(this.f518363a.f518338f, 0.0f, 0.0f, null);     // Catch: Throwable -> L15
        this.f518363a.f518333a.endRecording();     // Catch: Throwable -> L15
    L13:
        TraceEvent.endSection("BlurView.reBlur");
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

    public b(a r100) {
        this.f518363a = r100;
    }
}
