package s87;

import com.lynx.rts.gen.CommonCallbackNG;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f540987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f540988b;

    public j(long r100) {
        int r101 = e.f540981a;
        this.f540987a = new i(r100);
    }

    public final void a(long r100) {
        int r101 = e.f540981a;
        i r102 = this.f540987a;
        Intrinsics.checkNotNullParameter(r102, "renderer");
        r102.a().b(r100);
    }

    public final long c(Function1<Object, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        int r101 = e.f540981a;
        i r102 = this.f540987a;
        Intrinsics.checkNotNullParameter(r102, "renderer");
        Intrinsics.checkNotNullParameter(r100, "callback");
        return r102.a().H(h.a(r100));
    }

    public final void b(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        int r103 = e.f540981a;
        i r104 = this.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r104.a().z(r100, r101, r102);
    }

    public final void d(String r110, Function1<Object, Unit> r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "callback");
        int r100 = e.f540981a;
        i r101 = this.f540987a;
        Intrinsics.checkNotNullParameter(r101, "renderer");
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "callback");
        h.b(r111);
        a r102 = a.f540972a;
        long r103 = r101.f540985a;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r110, "eventName");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r111, "callback");     // Catch: Throwable -> L11
        Map<k, CommonCallbackNG> r104 = a.f540974c;     // Catch: Throwable -> L11
        k r105 = new k(r103, r110, r111, r112);     // Catch: Throwable -> L11
        LinkedHashMap r106 = (LinkedHashMap) r104;     // Catch: Throwable -> L11
        Object r107 = r106.get(r105);     // Catch: Throwable -> L11
        if (r107 != null) goto L7;
        r107 = h.a(r111);     // Catch: Throwable -> L11
        r106.put(r105, r107);     // Catch: Throwable -> L11
    L7:
        CommonCallbackNG r108 = (CommonCallbackNG) r107;     // Catch: Throwable -> L11
        monitor-exit(r102);
        r101.a().J(r110, r108, r112);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e(String r110, Function1<Object, Unit> r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "callback");
        int r100 = e.f540981a;
        i r101 = this.f540987a;
        Intrinsics.checkNotNullParameter(r101, "renderer");
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "callback");
        h.b(r111);
        a r102 = a.f540972a;
        long r103 = r101.f540985a;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r110, "eventName");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r111, "callback");     // Catch: Throwable -> L10
        CommonCallbackNG r104 = a.f540974c.remove(new k(r103, r110, r111, r112));     // Catch: Throwable -> L10
        if (r104 != null) goto L7;
        r104 = h.a(r111);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r102);
        r101.a().K(r110, r104, r112);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
