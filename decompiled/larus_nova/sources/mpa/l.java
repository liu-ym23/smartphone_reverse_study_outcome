package mpa;

import com.lynx.rts.gen.CommonCallbackNG;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f514759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f514760b;

    public l() {
        this(0);
    }

    public l(long r100) {
        int r101 = e.f514751a;
        this.f514759a = new k(r100);
    }

    public final void a(long r100, long r101) {
        int r102 = e.f514751a;
        k r103 = this.f514759a;
        Intrinsics.checkNotNullParameter(r103, "renderer");
        r103.a().v(r100, r101);
    }

    public final void b(String r110, Function1<Object, Unit> r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "callback");
        int r100 = e.f514751a;
        k r101 = this.f514759a;
        Intrinsics.checkNotNullParameter(r101, "renderer");
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "callback");
        CommonCallbackNG r102 = j.b(r111);
        if (r102 != null) goto L16;
        a r103 = a.f514744a;
        long r104 = r101.f514757a;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r110, "eventName");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r111, "callback");     // Catch: Throwable -> L13
        CommonCallbackNG r105 = a.f514746c.remove(new m(r104, r110, r111, r112));     // Catch: Throwable -> L13
        if (r105 != null) goto L10;
        CommonCallbackNG r113 = j.a(r111);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r103);
        r102 = r113;
        goto L16
    L10:
        r113 = r105;
    L13:
        th = move-exception;
        throw th;
    L16:
        r101.a().K(r110, r102, r112);
    }
}
