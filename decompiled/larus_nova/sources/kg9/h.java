package kg9;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f503391a;

    @Override // android.os.Handler
    public final void handleMessage(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        i r111 = this.f503391a;
        monitor-enter(r111);
        boolean r100 = r111.f503394c;     // Catch: Throwable -> L12
        if (r100 == true) goto L28;
        long r101 = r111.f503392a - r111.f503395d;     // Catch: Throwable -> L12
        long r102 = 0;
        if (r101 > 0) goto L14;
        if (r100 == true) goto L11;
        r111.b();     // Catch: Throwable -> L12
    L11:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L26:
        monitor-exit(r111);
        return;
    L14:
        long r104 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        r111.c();     // Catch: Throwable -> L12
        long r105 = SystemClock.elapsedRealtime() - r104;     // Catch: Throwable -> L12
        long r106 = r111.f503393b;     // Catch: Throwable -> L12
        if (r101 >= r106) goto L20;
        long r107 = r101 - r105;     // Catch: Throwable -> L12
        if (r107 < 0) goto L25;
        r102 = r107;
    L25:
        r111.f503395d += r105 + r102;     // Catch: Throwable -> L12
        sendMessageDelayed(obtainMessage(1), r102);     // Catch: Throwable -> L12
        goto L26
    L20:
        long r108 = r106 - r105;     // Catch: Throwable -> L12
    L22:
        if (r108 >= 0) goto L24;
        r108 = r108 + r111.f503393b;     // Catch: Throwable -> L12
        goto L22
    L24:
        r102 = r108;
        goto L25
    L28:
        monitor-exit(r111);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public h(i r100, Looper r101) {
        this.f503391a = r100;
        super(r101);
    }
}
