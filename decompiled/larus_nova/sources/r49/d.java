package r49;

import com.larus.dora.impl.device.settings.lab.env.l;
import com.larus.dora.impl.device.settings.lab.env.m;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveOverrideChangeReason;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveWearState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f536102j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Long> f536103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r49.a f536104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Long> f536105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Long> f536106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<String, EnvObserveOverrideChangeReason, Unit> f536107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f536108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, b> f536109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, EnvObserveWearState> f536110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Long> f536111i;

    public static final class a {
        public static EnvObserveWearState a(Integer r100, Integer r101) {
            if (r100 != null) goto L6;
        L7:
            if (r101 != null) goto L10;
        L12:
            if (r100 == null) goto L25;
            if (r100.intValue() != 0) goto L25;
            if (r101 == null) goto L25;
            if (r101.intValue() != 0) goto L25;
            return EnvObserveWearState.UNWORN;
        L25:
            return EnvObserveWearState.UNKNOWN;
        L10:
            if (r101.intValue() != 1) goto L12;
        L23:
            return EnvObserveWearState.WORN;
        L6:
            if (r100.intValue() == 1) goto L23;
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f536112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f536113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f536114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f536115d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f536112a == r101.f536112a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f536113b, r101.f536113b) == true) goto L15;
            return false;
        L15:
            if (this.f536114c == r101.f536114c) goto L18;
            return false;
        L18:
            if (this.f536115d == r101.f536115d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f536112a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            Long r102 = this.f536113b;
            if (r102 != null) goto L5;
            int r103 = 0;
        L6:
            long r104 = this.f536114c;
            int r105 = (((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f536115d;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        L5:
            r103 = r102.hashCode();
            goto L6
        }

        public final String toString() {
            return "OverrideState(expiresAtMillis=" + this.f536112a + ", unwornSinceMillis=" + this.f536113b + ", unwornTimeoutMillis=" + this.f536114c + ", generation=" + this.f536115d + ')';
        }

        public b(long r100, Long r101, long r102, long r103) {
            this.f536112a = r100;
            this.f536113b = r101;
            this.f536114c = r102;
            this.f536115d = r103;
        }
    }

    static {
    }

    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mac");
        Object r101 = this.f536108f;
        monitor-enter(r101);
        b r102 = (b) ((LinkedHashMap) this.f536109g).get(r100);     // Catch: Throwable -> L15
        boolean r103 = false;
        if (r102 != null) goto L7;
        EnvObserveOverrideChangeReason r104 = null;
    L11:
        monitor-exit(r101);
        if (r104 == null) goto L14;
        this.f536107e.invoke(r100, r104);
    L14:
        return r103;
    L7:
        r104 = c(r102, this.f536103a.invoke().longValue());     // Catch: Throwable -> L15
        if (r104 != null) goto L10;
        r103 = true;
        goto L11
    L10:
        e(r100);     // Catch: Throwable -> L15
        this.f536109g.remove(r100);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final long e(String r100) {
        Long r101 = (Long) ((LinkedHashMap) this.f536111i).get(r100);
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        long r103 = r102 + 1;
        Long r104 = Long.valueOf(r103);
        this.f536111i.put(r100, r104);
        return r103;
    L5:
        r102 = 0;
        goto L6
    }

    public static EnvObserveOverrideChangeReason c(b r100, long r101) {
        if (r101 >= r100.f536112a) goto L5;
        Long r102 = r100.f536113b;
        if (r102 != null) goto L9;
        return null;
    L9:
        if ((r101 - r102.longValue()) >= r100.f536114c) goto L11;
        return null;
    L11:
        return EnvObserveOverrideChangeReason.UNWORN_TIMEOUT;
    L5:
        return EnvObserveOverrideChangeReason.EXPIRED;
    }

    public final void a(String r100, EnvObserveOverrideChangeReason r101) {
        Intrinsics.checkNotNullParameter(r100, "mac");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Object r102 = this.f536108f;
        monitor-enter(r102);
        e(r100);     // Catch: Throwable -> L12
        if (this.f536109g.remove(r100) == null) goto L7;
        boolean r103 = true;
    L8:
        monitor-exit(r102);
        if (r103 == false) goto L17;
        this.f536107e.invoke(r100, r101);
        return;
    L17:
        return;
    L7:
        r103 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public final void f(final String r100, final b r101) {
        r49.a r102 = this.f536104b;
        l r103 = (l) r102;
        r103.a(RangesKt.coerceAtLeast(r101.f536112a - this.f536103a.invoke().longValue(), 0), new r49.b(this, r100, r101));
        Long r104 = r101.f536113b;
        if (r104 == null) goto L6;
        long r105 = r104.longValue();
        r49.a r106 = this.f536104b;
        l r107 = (l) r106;
        r107.a(RangesKt.coerceAtLeast((r105 + r101.f536114c) - this.f536103a.invoke().longValue(), 0), new c(this, r100, r101));
        return;
    }

    public final void b(String r100, long r101, EnvObserveOverrideChangeReason r102) {
        Object r103 = this.f536108f;
        monitor-enter(r103);
        b r104 = (b) ((LinkedHashMap) this.f536109g).get(r100);     // Catch: Throwable -> L19
        if (r104 != null) goto L8;
    L13:
        boolean r105 = false;
    L14:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r103);
        if (r105 == false) goto L24;
        this.f536107e.invoke(r100, r102);
        return;
    L24:
        return;
    L8:
        if (r104.f536115d != r101) goto L13;
        if (c(r104, this.f536103a.invoke().longValue()) != r102) goto L13;
        e(r100);     // Catch: Throwable -> L19
        this.f536109g.remove(r100);     // Catch: Throwable -> L19
        r105 = true;
    L19:
        th = move-exception;
        throw th;
    }

    public d(Function0 r100, l r101, m r102, com.larus.dora.impl.device.settings.lab.env.b r103, com.larus.dora.impl.device.settings.lab.env.c r104) {
        Intrinsics.checkNotNullParameter(r100, "elapsedRealtime");
        Intrinsics.checkNotNullParameter(r101, "scheduler");
        Intrinsics.checkNotNullParameter(r102, "overrideDurationMillis");
        Intrinsics.checkNotNullParameter(r103, "unwornTimeoutMillis");
        Intrinsics.checkNotNullParameter(r104, "onChanged");
        this.f536103a = r100;
        this.f536104b = r101;
        this.f536105c = r102;
        this.f536106d = r103;
        this.f536107e = r104;
        this.f536108f = new Object();
        this.f536109g = new LinkedHashMap();
        this.f536110h = new LinkedHashMap();
        this.f536111i = new LinkedHashMap();
    }
}
