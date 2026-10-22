package ji3;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f499181a;

    public j(i r100) {
        this.f499181a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        Iterator<i.a> r101 = this.f499181a.f499179d.iterator();     // Catch: Throwable -> L12
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onTick();     // Catch: Throwable -> L12
        goto L4
    L6:
        long r102 = SystemClock.elapsedRealtime() - r100;     // Catch: Throwable -> L12
        i r103 = this.f499181a;     // Catch: Throwable -> L12
        long r104 = r103.f499180e;     // Catch: Throwable -> L12
        if (r102 > r104) goto L10;
        r104 = r104 - r102;     // Catch: Throwable -> L12
    L10:
        r103.a(r104);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }
}
