package kba;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f502301a;

    public final void a() {
        if (this.f502301a.f502296h == true) goto L5;
        return;
    L5:
        long r100 = SystemClock.uptimeMillis();
        c r101 = this.f502301a;
        int r102 = a.f502286a;
        r101.f502294f = a.b(r100 - r101.f502297i);
        c r103 = this.f502301a;
        r103.f502291c.invoke(Float.valueOf(r103.f502294f));
        c r104 = this.f502301a;
        float r105 = r104.f502294f;
        if ((r100 - r104.f502298j) < 1000) goto L9;
        r104.f502298j = r100;
        FLogger.f375446a.i("ListeningFakeAmplitudePlayer", "fake_amplitude_running: durationMs=" + (r100 - r104.f502297i) + " amplitude=" + r105 + " mode=" + r104.f502290b.invoke());
    L9:
        c r106 = this.f502301a;
        if (r106.f502296h == false) goto L13;
        r106.f502289a.postDelayed(this, 20);
        return;
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

    public d(c r100) {
        this.f502301a = r100;
    }
}
