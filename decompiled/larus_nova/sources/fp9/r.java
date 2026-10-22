package fp9;

import android.os.Handler;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rv9.c f478343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f478344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v f478345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f478346d;

    public /* synthetic */ r(rv9.c r100, int r101, v r102, int r103) {
        this.f478343a = r100;
        this.f478344b = r101;
        this.f478345c = r102;
        this.f478346d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final rv9.c r100 = this.f478343a;
        int r101 = this.f478344b;
        v r102 = this.f478345c;
        final int r103 = this.f478346d;
        final long r104 = System.currentTimeMillis();
        FLogger r105 = FLogger.f375446a;     // Catch: Throwable -> L9
        String r106 = v.f478352f;     // Catch: Throwable -> L9
        r105.i(r106, new u(r103, r100));     // Catch: Throwable -> L9
        Thread.sleep(r100.a());     // Catch: Throwable -> L9
        r105.i(r106, new j(r103, r100, r104));     // Catch: Throwable -> L9
        if (r101 != 1) goto L6;
        r105.i(r106, new k(r100));     // Catch: Throwable -> L9
    L6:
        int r107 = r101 - 1;     // Catch: Throwable -> L9
        long r108 = r100.e();     // Catch: Throwable -> L9
        int r109 = r103 + 1;     // Catch: Throwable -> L9
        if (r107 > 0) goto L11;
        r102.getClass();     // Catch: Throwable -> L9
    L12:
        if (r101 != 1) goto L35;
    L16:
        r102.f();
        return;
    L35:
        return;
    L11:
        ((Handler) r102.f478355c.getValue()).postDelayed(new r(r100, r107, r102, r109), r108);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        FLogger.f375446a.d(v.f478352f, th, new l(r103, r100));     // Catch: Throwable -> L18
        r102.f();     // Catch: Throwable -> L18
        if (r101 == 1) goto L16;
        return;
    L18:
        th = move-exception;
        if (r101 == 1) goto L21;
    L29:
        throw th;
    L21:
        monitor-enter(r102.f478356d);
        r102.f478357e = false;     // Catch: Throwable -> L26
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }
}
