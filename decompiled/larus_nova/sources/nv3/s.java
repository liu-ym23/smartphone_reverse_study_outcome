package nv3;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f520844a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f520845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static q f520846c;

    public static final class a extends b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f520847g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function2<String, String, Unit> f520848h;

        public a(String r100, t r110, String r111, nv3.b r112, nv3.c r113) {
            Intrinsics.checkNotNullParameter(r100, "operationId");
            Intrinsics.checkNotNullParameter(r110, "source");
            Intrinsics.checkNotNullParameter(r111, "originalState");
            Intrinsics.checkNotNullParameter(r112, "onSuccess");
            Intrinsics.checkNotNullParameter(r113, "onFailure");
            super(r100, r110, 300000, "Huawei health authorization timed out", r113);
            this.f520847g = r111;
            this.f520848h = r112;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f520849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t f520850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f520851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f520852d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function2<f3.a, String, Unit> f520853e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f520854f;

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, t r101, long r102, String r103, Function2<? super f3.a, ? super String, Unit> r104) {
            Intrinsics.checkNotNullParameter(r100, "operationId");
            Intrinsics.checkNotNullParameter(r101, "source");
            Intrinsics.checkNotNullParameter(r103, "timeoutMessage");
            Intrinsics.checkNotNullParameter(r104, "onFailure");
            this.f520849a = r100;
            this.f520850b = r101;
            this.f520851c = r102;
            this.f520852d = r103;
            this.f520853e = r104;
            this.f520854f = SystemClock.elapsedRealtime();
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function0<Unit> f520855g;

        public c(String r100, t r110, v r111, w r112) {
            Intrinsics.checkNotNullParameter(r100, "operationId");
            Intrinsics.checkNotNullParameter(r110, "source");
            Intrinsics.checkNotNullParameter(r111, "onSuccess");
            Intrinsics.checkNotNullParameter(r112, "onFailure");
            super(r100, r110, 20000, "Huawei health sync timed out", r112);
            this.f520855g = r111;
        }
    }

    static {
        f520844a = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Runnable, nv3.q] */
    public static boolean b(final b r100) {
        b r101 = f520845b;
        if (r101 != null) goto L5;
        b r102 = null;
    L16:
        f520845b = r100;
        ?? r103 = new q(r100);
        f520846c = r103;
        f520844a.postDelayed(r103, r100.f520851c);
        if (r102 == null) goto L21;
        Function2<f3.a, String, Unit> r104 = r102.f520853e;
        if (r104 == null) goto L21;
        r104.invoke(f3.a.f475274o, "Previous Huawei health authorization was replaced by a new request");
    L21:
        return true;
    L5:
        if ((r101 instanceof a) == true) goto L7;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L14;
        return false;
    L14:
        r102 = c(((a) r101).f520849a);
        goto L16
    L7:
        if ((r100 instanceof a) == false) goto L11;
        if ((SystemClock.elapsedRealtime() - ((a) r101).f520854f) < 1000) goto L11;
        r105 = true;
        goto L12
    }

    public static b c(String r100) {
        b r101 = f520845b;
        if (r101 != null) goto L5;
    L15:
        return null;
    L5:
        if (Intrinsics.areEqual(r101.f520849a, r100) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L15;
        f520845b = null;
        q r102 = f520846c;
        if (r102 == null) goto L13;
        f520844a.removeCallbacks(r102);
    L13:
        f520846c = null;
        return r101;
    }

    public static void a(String r100, f3.a r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "operationId");
        Intrinsics.checkNotNullParameter(r101, "error");
        Intrinsics.checkNotNullParameter(r102, "message");
        b r103 = c(r100);
        if (r103 == null) goto L8;
        Function2<f3.a, String, Unit> r104 = r103.f520853e;
        if (r104 == null) goto L9;
        r104.invoke(r101, r102);
        return;
    L9:
        return;
    }
}
