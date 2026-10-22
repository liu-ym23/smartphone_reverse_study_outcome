package com.larus.business.arc.api;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: classes26.dex */
public final class ArcCallLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f319838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f319839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final buc.a f319840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final buc.a f319841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f319842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f319843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long[] f319844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f319845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f319846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f319847j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArcStage f319848k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArcFrameworkFailure f319849l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f319850m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f319851n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LifecycleState f319852o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/arc/api/ArcCallLifecycle$LifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "FINISHED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LifecycleState extends Enum<LifecycleState> {
        public static final LifecycleState ACTIVE = null;
        public static final LifecycleState FINISHED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LifecycleState[] f319853a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f319854b = null;

        public static EnumEntries<LifecycleState> getEntries() {
            return f319854b;
        }

        static {
            LifecycleState r100 = new LifecycleState("ACTIVE", 0);
            ACTIVE = r100;
            LifecycleState r101 = new LifecycleState("FINISHED", 1);
            FINISHED = r101;
            LifecycleState[] r102 = {r100, r101};
            f319853a = r102;
            f319854b = EnumEntriesKt.enumEntries(r102);
        }

        public static LifecycleState[] values() {
            return (LifecycleState[]) f319853a.clone();
        }

        public static LifecycleState valueOf(String r100) {
            return (LifecycleState) r27.a.a(LifecycleState.class, r100);
        }

        public LifecycleState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f319855a = null;

        static {
            int[] r100 = new int[ArcStage.values().length];
            r100[ArcStage.PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ArcStage.EXECUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ArcStage.FINALIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f319855a = r100;
        }
    }

    static {
    }

    public ArcCallLifecycle() {
        this(0);
    }

    public final void c() {
        Object r100 = this.f319839b;
        monitor-enter(r100);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (l() == true) goto L28;
        ArcStage r101 = this.f319848k;     // Catch: Throwable -> L30
        if (r101 != null) goto L10;
        int r102 = -1;
    L11:
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L15;
        h(ArcStage.PREPARE, ArcFrameworkFailure.PREPARE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L15:
        if (r102 != 2) goto L17;
        h(ArcStage.EXECUTE, ArcFrameworkFailure.EXECUTE_CANCELLED);     // Catch: Throwable -> L30
        goto L28
    L17:
        if (r102 != 3) goto L20;
        h(ArcStage.FINALIZE, ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L20:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L30
    L24:
        if (this.f319844g[ArcStage.EXECUTE.ordinal()] < 0) goto L26;
        ArcFrameworkFailure r103 = ArcFrameworkFailure.EXECUTE_CANCELLED;     // Catch: Throwable -> L30
    L27:
        n(r103);     // Catch: Throwable -> L30
        goto L28
    L26:
        r103 = ArcFrameworkFailure.PREPARE_INTERNAL_ERROR;     // Catch: Throwable -> L30
        goto L27
    L10:
        r102 = b.f319855a[r101.ordinal()];     // Catch: Throwable -> L30
    L28:
        monitor-exit(r100);
    }

    public final long d() {
        ((d) this.f319838a).getClass();     // Catch: Throwable -> L4
        Long r100 = Long.valueOf(Duration.m10811getInWholeMillisecondsimpl(TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(e.f319885a)));     // Catch: Throwable -> L4
    L5:
        if (r100 == null) goto L13;
        long r101 = r100.longValue();
        Long r102 = this.f319842e;
        if (r102 == null) goto L9;
        long r103 = r102.longValue();
    L10:
        long r104 = RangesKt.coerceAtLeast(r101 - r103, this.f319843f);
        this.f319843f = r104;
        return r104;
    L9:
        this.f319842e = Long.valueOf(r101);
        r103 = r101;
        goto L10
    L13:
        return this.f319843f;
    L4:
        k();
        r100 = null;
        goto L5
    }

    public final void e() {
        Object r100 = this.f319839b;
        monitor-enter(r100);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (l() == true) goto L28;
        ArcStage r101 = this.f319848k;     // Catch: Throwable -> L30
        if (r101 != null) goto L10;
        int r102 = -1;
    L11:
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L15;
        h(ArcStage.PREPARE, ArcFrameworkFailure.PREPARE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L15:
        if (r102 != 2) goto L17;
        h(ArcStage.EXECUTE, ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L17:
        if (r102 != 3) goto L20;
        h(ArcStage.FINALIZE, ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L28
    L20:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L30
    L24:
        if (this.f319844g[ArcStage.EXECUTE.ordinal()] < 0) goto L26;
        ArcFrameworkFailure r103 = ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR;     // Catch: Throwable -> L30
    L27:
        n(r103);     // Catch: Throwable -> L30
        goto L28
    L26:
        r103 = ArcFrameworkFailure.PREPARE_INTERNAL_ERROR;     // Catch: Throwable -> L30
        goto L27
    L10:
        r102 = b.f319855a[r101.ordinal()];     // Catch: Throwable -> L30
    L28:
        monitor-exit(r100);
    }

    public final void f() {
        Object r100 = this.f319839b;
        monitor-enter(r100);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (l() == true) goto L27;
        ArcStage r101 = this.f319848k;     // Catch: Throwable -> L30
        if (r101 != null) goto L9;
        int r102 = -1;
    L10:
        if (r102 == (-1)) goto L23;
        if (r102 != 1) goto L14;
        h(ArcStage.PREPARE, ArcFrameworkFailure.PREPARE_RUNTIME_EMPTY_RESULT);     // Catch: Throwable -> L30
        goto L27
    L14:
        if (r102 != 2) goto L16;
        h(ArcStage.EXECUTE, ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L27
    L16:
        if (r102 != 3) goto L19;
        h(ArcStage.FINALIZE, ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L30
        goto L27
    L19:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L30
    L23:
        if (this.f319844g[ArcStage.EXECUTE.ordinal()] < 0) goto L25;
        ArcFrameworkFailure r103 = ArcFrameworkFailure.EXECUTE_INTERNAL_ERROR;     // Catch: Throwable -> L30
    L26:
        n(r103);     // Catch: Throwable -> L30
        goto L27
    L25:
        r103 = ArcFrameworkFailure.PREPARE_RUNTIME_EMPTY_RESULT;     // Catch: Throwable -> L30
        goto L26
    L9:
        r102 = b.f319855a[r101.ordinal()];     // Catch: Throwable -> L30
    L27:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r100);
    }

    public final g i() {
        Object r100 = this.f319839b;     // Catch: Throwable -> L31
        monitor-enter(r100);     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L6:
        if (this.f319840c.c() == false) goto L8;
        this.f319852o = LifecycleState.FINISHED;     // Catch: Throwable -> L28
    L16:
        g r101 = null;
    L26:
        monitor-exit(r100);     // Catch: Throwable -> L31
        return r101;
    L8:
        r101 = this.f319851n;     // Catch: Throwable -> L28
        if (r101 != null) goto L26;
        ArcStage r102 = this.f319848k;     // Catch: Throwable -> L28
        if (r102 == null) goto L14;
        n(e.a(r102));     // Catch: Throwable -> L28
    L14:
        long r103 = d();     // Catch: Throwable -> L28
        if (this.f319840c.c() == true) goto L16;
        String r104 = this.f319846i;     // Catch: Throwable -> L28
        String r105 = this.f319847j;     // Catch: Throwable -> L28
        if (this.f319844g[ArcStage.EXECUTE.ordinal()] < 0) goto L20;
        ArcBizStatus r106 = ArcBizStatus.UNKNOWN;     // Catch: Throwable -> L28
    L21:
        j r107 = new j(r106, this.f319849l, this.f319850m);     // Catch: Throwable -> L28
        ArcStage[] r108 = ArcStage.values();     // Catch: Throwable -> L28
        ArrayList r109 = new ArrayList(r108.length);     // Catch: Throwable -> L28
        int r110 = r108.length;     // Catch: Throwable -> L28
        int r111 = 0;
    L22:
        if (r111 >= r110) goto L24;
        ArcStage r112 = r108[r111];     // Catch: Throwable -> L28
        r109.add(new y(r112, this.f319844g[r112.ordinal()], this.f319845h[r112.ordinal()]));     // Catch: Throwable -> L28
        r111 = r111 + 1;     // Catch: Throwable -> L28
        goto L22
    L24:
        g r113 = new g(r104, r105, r107, new l(r103, r109));     // Catch: Throwable -> L28
        this.f319851n = r113;     // Catch: Throwable -> L28
        this.f319852o = LifecycleState.FINISHED;     // Catch: Throwable -> L28
        r101 = r113;
        goto L26
    L20:
        r106 = ArcBizStatus.NOT_STARTED;     // Catch: Throwable -> L28
    L31:
        k();
        return null;
    }

    public final void k() {
        this.f319840c.d(true);     // Catch: Throwable -> L4
        return;
    }

    public final boolean l() {
        if (this.f319852o != LifecycleState.FINISHED) goto L5;
    L8:
        return true;
    L5:
        if (this.f319840c.c() == true) goto L8;
        return false;
    }

    public ArcCallLifecycle(int r100) {
        d r101 = e.f319886b;
        Intrinsics.checkNotNullParameter(r101, "clock");
        this.f319838a = r101;
        this.f319839b = new Object();
        int r102 = 0;
        this.f319840c = buc.b.a(false);
        this.f319841d = buc.b.a(false);
        r101.getClass();     // Catch: Throwable -> L5
        Long r103 = Long.valueOf(Duration.m10811getInWholeMillisecondsimpl(TimeSource.Monotonic.ValueTimeMark.m10937elapsedNowUwyO8pc(e.f319885a)));     // Catch: Throwable -> L5
    L6:
        this.f319842e = r103;
        int r104 = ArcStage.values().length;
        long[] r105 = new long[r104];
        int r106 = 0;
    L8:
        if (r106 >= r104) goto L10;
        r105[r106] = -1;
        r106 = r106 + 1;
        goto L8
    L10:
        this.f319844g = r105;
        int r107 = ArcStage.values().length;
        long[] r108 = new long[r107];
    L11:
        if (r102 >= r107) goto L13;
        r108[r102] = -1;
        r102 = r102 + 1;
        goto L11
    L13:
        this.f319845h = r108;
        this.f319846i = "unknown";
        this.f319847j = "unknown";
        this.f319849l = ArcFrameworkFailure.NONE;
        this.f319850m = "0";
        this.f319852o = LifecycleState.ACTIVE;
        return;
    L5:
        k();
        r103 = null;
        goto L6
    }

    public final boolean a(ArcStage r100) {
        Object r101 = this.f319839b;
        monitor-enter(r101);
        boolean r102 = false;
        if (l() == false) goto L8;
    L12:
        monitor-exit(r101);
        return r102;
    L8:
        if (b(r100) == true) goto L10;
        n(e.a(r100));     // Catch: Throwable -> L14
        goto L12
    L10:
        this.f319844g[r100.ordinal()] = d();     // Catch: Throwable -> L14
        this.f319848k = r100;     // Catch: Throwable -> L14
        r102 = true;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean b(ArcStage r110) {
        if (this.f319848k == null) goto L5;
        return false;
    L5:
        if (this.f319844g[r110.ordinal()] >= 0) goto L45;
        int r111 = b.f319855a[r110.ordinal()];
        if (r111 != 1) goto L10;
        long[] r112 = this.f319844g;
        int r100 = r112.length;
        int r101 = 0;
    L28:
        if (r101 >= r100) goto L36;
        if (r112[r101] >= 0) goto L32;
        boolean r102 = true;
    L33:
        if (r102 == false) goto L46;
        r101 = r101 + 1;
        goto L28
    L46:
        return false;
    L32:
        r102 = false;
    L36:
        return true;
    L10:
        if (r111 == 2) goto L23;
        if (r111 != 3) goto L21;
        if (this.f319845h[ArcStage.PREPARE.ordinal()] < 0) goto L41;
        long[] r113 = this.f319845h;
        ArcStage r103 = ArcStage.EXECUTE;
        if (r113[r103.ordinal()] >= 0) goto L36;
        if (this.f319844g[r103.ordinal()] < 0) goto L36;
        return false;
    L41:
        return false;
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        if (this.f319845h[ArcStage.PREPARE.ordinal()] >= 0) goto L25;
        return false;
    L25:
        if (this.f319844g[ArcStage.FINALIZE.ordinal()] < 0) goto L36;
        return false;
    L45:
        return false;
    }

    public final void g(ArcFrameworkFailure r100) {
        Intrinsics.checkNotNullParameter(r100, "failure");
        ArcStage r101 = ArcStage.PREPARE;
        Object r102 = this.f319839b;
        monitor-enter(r102);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (l() == false) goto L8;
    L14:
        monitor-exit(r102);
        return;
    L8:
        if (r100 != ArcFrameworkFailure.NONE) goto L10;
    L13:
        n(e.a(r101));     // Catch: Throwable -> L16
        goto L14
    L10:
        if (r100.getStage() != r101) goto L13;
        h(r101, r100);     // Catch: Throwable -> L16
        goto L14
    }

    public final boolean j(ArcStage r100) {
        if (this.f319848k == r100) goto L5;
    L11:
        n(e.a(r100));
        return false;
    L5:
        if (this.f319844g[r100.ordinal()] < 0) goto L11;
        if (this.f319845h[r100.ordinal()] >= 0) goto L11;
        this.f319845h[r100.ordinal()] = RangesKt.coerceAtLeast(d(), this.f319844g[r100.ordinal()]);
        this.f319848k = null;
        return true;
    }

    public final void m(ArcFrameworkFailure r100) {
        Intrinsics.checkNotNullParameter(r100, "failure");
        Object r101 = this.f319839b;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (l() == false) goto L7;
    L12:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r101);
        return;
    L7:
        if (r100 != ArcFrameworkFailure.NONE) goto L9;
    L11:
        n(r100);     // Catch: Throwable -> L15
        goto L12
    L9:
        if (r100.getStage() == ArcStage.FINALIZE) goto L11;
        n(ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L15
        goto L12
    }

    public final void n(ArcFrameworkFailure r100) {
        ArcFrameworkFailure r101 = this.f319849l;
        ArcFrameworkFailure r102 = ArcFrameworkFailure.NONE;
        if (r101 != r102) goto L7;
        if (r100 == r102) goto L8;
        this.f319849l = r100;
        return;
    L8:
        return;
    }

    public final boolean h(ArcStage r100, ArcFrameworkFailure r101) {
        if (this.f319848k == r100) goto L5;
    L11:
        n(e.a(r100));
        return false;
    L5:
        if (this.f319844g[r100.ordinal()] < 0) goto L11;
        if (this.f319845h[r100.ordinal()] >= 0) goto L11;
        n(r101);
        this.f319845h[r100.ordinal()] = RangesKt.coerceAtLeast(d(), this.f319844g[r100.ordinal()]);
        this.f319848k = null;
        return true;
    }
}
