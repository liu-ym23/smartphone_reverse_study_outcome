package nv3;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public static final Handler a = null;
    public static b b;
    public static q c;

    public static final class a extends b {
        public final String g;
        public final Function2<String, String, Unit> h;

        public a(String r9, t r10, String r11, nv3.b r12, nv3.c r13) {
            Intrinsics.checkNotNullParameter(r9, "operationId");
            Intrinsics.checkNotNullParameter(r10, "source");
            Intrinsics.checkNotNullParameter(r11, "originalState");
            Intrinsics.checkNotNullParameter(r12, "onSuccess");
            Intrinsics.checkNotNullParameter(r13, "onFailure");
            super(r9, r10, 300000, "Huawei health authorization timed out", r13);
            this.g = r11;
            this.h = r12;
        }
    }

    public static abstract class b {
        public final String a;
        public final t b;
        public final long c;
        public final String d;
        public final Function2<f3.a, String, Unit> e;
        public final long f;

        public b(String r2, t r3, long r4, String r6, Function2<? super f3.a, ? super String, Unit> r7) {
            Intrinsics.checkNotNullParameter(r2, "operationId");
            Intrinsics.checkNotNullParameter(r3, "source");
            Intrinsics.checkNotNullParameter(r6, "timeoutMessage");
            Intrinsics.checkNotNullParameter(r7, "onFailure");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
            this.f = SystemClock.elapsedRealtime();
        }
    }

    public static final class c extends b {
        public final Function0<Unit> g;

        public c(String r9, t r10, v r11, w r12) {
            Intrinsics.checkNotNullParameter(r9, "operationId");
            Intrinsics.checkNotNullParameter(r10, "source");
            Intrinsics.checkNotNullParameter(r11, "onSuccess");
            Intrinsics.checkNotNullParameter(r12, "onFailure");
            super(r9, r10, 20000, "Huawei health sync timed out", r12);
            this.g = r11;
        }
    }

    static {
        a = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Runnable, nv3.q] */
    public static boolean b(final b r8) {
        b r0 = b;
        if (r0 != null) goto L5;
        b r1 = null;
    L16:
        b = r8;
        ?? r2 = new q(r8);
        c = r2;
        a.postDelayed(r2, r8.c);
        if (r1 == null) goto L21;
        Function2<f3.a, String, Unit> r9 = r1.e;
        if (r9 == null) goto L21;
        r9.invoke(f3.a.o, "Previous Huawei health authorization was replaced by a new request");
    L21:
        return true;
    L5:
        if ((r0 instanceof a) == true) goto L7;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L14;
        return false;
    L14:
        r1 = c(((a) r0).a);
        goto L16
    L7:
        if ((r8 instanceof a) == false) goto L11;
        if ((SystemClock.elapsedRealtime() - ((a) r0).f) < 1000) goto L11;
        r3 = true;
        goto L12
    }

    public static b c(String r3) {
        b r0 = b;
        if (r0 != null) goto L5;
    L15:
        return null;
    L5:
        if (Intrinsics.areEqual(r0.a, r3) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L15;
        b = null;
        q r4 = c;
        if (r4 == null) goto L13;
        a.removeCallbacks(r4);
    L13:
        c = null;
        return r0;
    }

    public static void a(String r1, f3.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "operationId");
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r3, "message");
        b r4 = c(r1);
        if (r4 == null) goto L8;
        Function2<f3.a, String, Unit> r5 = r4.e;
        if (r5 == null) goto L9;
        r5.invoke(r2, r3);
        return;
    L9:
        return;
    }
}
