package com.larus.contextwindow.impl.membership;

import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes27.dex */
public final class MembershipQuotaRepository implements l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<MembershipQuotaRepository> f330347k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f330348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<d> f330349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Continuation<? super e>, Object> f330350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f330351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateFlowImpl f330352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1 f330353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f330354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f330355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f330356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f330357j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f330358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f330359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Deferred<e> f330360c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f330358a, r101.f330358a) == true) goto L12;
            return false;
        L12:
            if (this.f330359b == r101.f330359b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f330360c, r101.f330360c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f330358a.hashCode() * 31;
            long r101 = this.f330359b;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f330360c.hashCode();
        }

        public final String toString() {
            return "ActiveRequest(accountId=" + this.f330358a + ", generation=" + this.f330359b + ", deferred=" + this.f330360c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, long r101, Deferred<? extends e> r102) {
            Intrinsics.checkNotNullParameter(r100, "accountId");
            Intrinsics.checkNotNullParameter(r102, "deferred");
            this.f330358a = r100;
            this.f330359b = r101;
            this.f330360c = r102;
        }
    }

    public static final class b {
        public static MembershipQuotaRepository a() {
            return MembershipQuotaRepository.f330347k.getValue();
        }
    }

    static {
        f330347k = LazyKt.lazy(new g());
    }

    public final void b() {
        Object r100 = this.f330351d;
        monitor-enter(r100);
        c();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c() {
        this.f330354g++;
        this.f330355h = null;
        this.f330356i = null;
        a r100 = this.f330357j;
        if (r100 == null) goto L7;
        Deferred<e> r101 = r100.f330360c;
        if (r101 == null) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L7:
        this.f330357j = null;
        this.f330352e.setValue(new h(null, 3));
    }

    public final void d() {
        BuildersKt.launch$default(this.f330348a, null, null, new MembershipQuotaRepository$prefetchIfNeeded$1(this, null), 3, null);
    }

    @Override // com.larus.contextwindow.impl.membership.l
    public final b1 getState() {
        Object r100 = this.f330351d;
        monitor-enter(r100);
        d r101 = this.f330349b.invoke();     // Catch: Throwable -> L19
        String r102 = null;
        if ((r101 instanceof d.a) == false) goto L7;
        d.a r103 = (d.a) r101;     // Catch: Throwable -> L19
    L8:
        if (r103 == null) goto L10;
        r102 = r103.f330380a;     // Catch: Throwable -> L19
    L10:
        String r104 = this.f330355h;     // Catch: Throwable -> L19
        if (r104 != null) goto L13;
    L15:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r100);
        return this.f330353f;
    L13:
        if (Intrinsics.areEqual(r104, r102) == true) goto L15;
        c();     // Catch: Throwable -> L19
        goto L15
    L7:
        r103 = null;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.contextwindow.impl.membership.l
    public final Object a(Continuation<? super Unit> r100) {
        Object r101 = e(true, r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final Object e(boolean r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof MembershipQuotaRepository$requestMembershipQuota$1) == false) goto L7;
        MembershipQuotaRepository$requestMembershipQuota$1 r100 = (MembershipQuotaRepository$requestMembershipQuota$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        a r105 = (a) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: CancellationException -> L14
    L61:
        e r106 = (e) r102;     // Catch: CancellationException -> L14
        Object r107 = this.f330351d;
        monitor-enter(r107);
    L102:
        th = move-exception;
        throw th;
    L65:
        if (this.f330357j == r105) goto L69;
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L102
        monitor-exit(r107);
        return r108;
    L69:
        this.f330357j = null;     // Catch: Throwable -> L102
        d r109 = this.f330349b.invoke();     // Catch: Throwable -> L102
        if ((r109 instanceof d.a) == false) goto L72;
        d.a r112 = (d.a) r109;     // Catch: Throwable -> L102
    L74:
        if (r105.f330359b == this.f330354g) goto L76;
    L99:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L102
        monitor-exit(r107);
        return r113;
    L76:
        if (Intrinsics.areEqual(this.f330355h, r105.f330358a) == false) goto L99;
        if (r112 == null) goto L79;
        String r114 = r112.f330380a;     // Catch: Throwable -> L102
    L81:
        if (Intrinsics.areEqual(r114, r105.f330358a) == false) goto L99;
        StateFlowImpl r115 = this.f330352e;     // Catch: Throwable -> L102
        if ((r106 instanceof e.b) == false) goto L90;
        Set<Integer> r116 = c.f330371a;     // Catch: Throwable -> L102
        if (c.a(((e.b) r106).f330383a).f569815a.isEmpty() == false) goto L88;
        h r117 = new h(null, 3);     // Catch: Throwable -> L102
    L93:
        r115.setValue(r117);     // Catch: Throwable -> L102
        monitor-exit(r107);
        return Unit.INSTANCE;
    L88:
        h r118 = new h(((e.b) r106).f330383a, 2);     // Catch: Throwable -> L102
    L92:
        r117 = r118;
        goto L93
    L90:
        if (Intrinsics.areEqual(r106, e.a.f330382a) == false) goto L98;
        r118 = new h(((h) this.f330352e.getValue()).f330385a, false);     // Catch: Throwable -> L102
        goto L92
    L98:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L102
    L79:
        r114 = null;
        goto L81
    L72:
        r112 = null;
        goto L74
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        d r119 = this.f330349b.invoke();
        if ((r119 instanceof d.b) == false) goto L22;
        b();
        return Unit.INSTANCE;
    L22:
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type com.larus.contextwindow.impl.membership.MembershipQuotaEligibility.Eligible");
        String r120 = ((d.a) r119).f330380a;
        Object r121 = this.f330351d;
        monitor-enter(r121);
    L106:
        th = move-exception;
        throw th;
    L25:
        if (Intrinsics.areEqual(this.f330355h, r120) == true) goto L27;
        c();     // Catch: Throwable -> L106
        this.f330355h = r120;     // Catch: Throwable -> L106
    L27:
        if (r110 == false) goto L29;
    L36:
        if (r110 == true) goto L38;
        this.f330356i = r120;     // Catch: Throwable -> L106
    L38:
        a r122 = this.f330357j;     // Catch: Throwable -> L106
        if (r122 != null) goto L41;
    L48:
        r122 = null;
    L49:
        if (r122 != null) goto L51;
        r122 = new a(r120, this.f330354g, BuildersKt.async$default(this.f330348a, null, CoroutineStart.LAZY, new MembershipQuotaRepository$requestMembershipQuota$request$1$selected$1(this, null), 1, null));     // Catch: Throwable -> L106
        this.f330357j = r122;     // Catch: Throwable -> L106
    L51:
        StateFlowImpl r123 = this.f330352e;     // Catch: Throwable -> L106
        r123.setValue(new h(((h) r123.getValue()).f330385a, true));     // Catch: Throwable -> L106
    L52:
        monitor-exit(r121);
        if (r122 == null) goto L55;
        r122.f330360c.start();
        Deferred<e> r124 = r122.f330360c;     // Catch: CancellationException -> L14
        r100.L$0 = r122;     // Catch: CancellationException -> L14
        r100.label = 1;     // Catch: CancellationException -> L14
        r102 = r124.await(r100);     // Catch: CancellationException -> L14
        if (r102 != r103) goto L60;
        return r103;
    L60:
        r105 = r122;
        goto L61
    L55:
        return Unit.INSTANCE;
    L41:
        if (Intrinsics.areEqual(r122.f330358a, r120) == true) goto L43;
    L45:
        boolean r125 = false;
    L46:
        if (r125 == false) goto L48;
    L43:
        if (r122.f330359b != this.f330354g) goto L45;
        r125 = true;
        goto L46
    L29:
        if (Intrinsics.areEqual(this.f330356i, r120) == false) goto L31;
    L35:
        r122 = null;
        goto L52
    L31:
        if (((h) this.f330352e.getValue()).f330385a == null) goto L33;
        boolean r126 = true;
    L34:
        if (r126 == false) goto L36;
    L33:
        r126 = false;
    L14:
        e = move-exception;
        throw e;
    L7:
        r100 = new MembershipQuotaRepository$requestMembershipQuota$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MembershipQuotaRepository(CoroutineScope r100, Function0<? extends d> r101, Function1<? super Continuation<? super e>, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "eligibilityProvider");
        Intrinsics.checkNotNullParameter(r102, "fetcher");
        this.f330348a = r100;
        this.f330349b = r101;
        this.f330350c = r102;
        this.f330351d = new Object();
        StateFlowImpl r103 = j1.a(new h(null, 3));
        this.f330352e = r103;
        this.f330353f = kotlinx.coroutines.flow.e.b(r103);
    }
}
