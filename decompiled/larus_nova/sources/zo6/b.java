package zo6;

import android.os.SystemClock;
import com.bytedance.locallife.common.utils.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f573133a;

    public final void a() {
        c r100 = this.f573133a;
        monitor-enter(r100);
        r100.f257139e = true;     // Catch: Throwable -> L8
        r100.f257141g = false;     // Catch: Throwable -> L8
        r100.f257142h = false;     // Catch: Throwable -> L8
        r100.f257143i.removeMessages(1);     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void b() {
        if (this.f573133a.c() == false) goto L5;
        return;
    L5:
        if (this.f573133a.b() == true) goto L19;
        c r100 = this.f573133a;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (r100.f257141g == false) goto L11;
        r100.f257142h = true;     // Catch: Throwable -> L13
        r100.f257143i.removeMessages(1);     // Catch: Throwable -> L13
        r100.f257138d = r100.f257137c - SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);
        return;
    }

    public final void c() {
        c r100 = this.f573133a;
        monitor-enter(r100);
        boolean r101 = r100.f257142h;     // Catch: Throwable -> L13
        monitor-exit(r100);
        if (r101 == true) goto L8;
        return;
    L8:
        if (this.f573133a.c() == false) goto L10;
        return;
    L10:
        if (this.f573133a.b() == true) goto L20;
        this.f573133a.d();
        return;
    L20:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public b(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "onTick");
        this.f573133a = new c(Long.MAX_VALUE, 1000, new a(r100));
    }
}
