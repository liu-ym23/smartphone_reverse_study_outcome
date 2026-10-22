package kf9;

import android.os.SystemClock;
import com.larus.im.internal.trace.manager.definition.AVCommonError;
import com.larus.im.internal.trace.manager.definition.AVSessionState;
import com.larus.im.internal.trace.stable.n;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f503265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f503266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kf9.a f503267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f503268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f503269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f503270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f503271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AVCommonError f503272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f503273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super AVSessionState, Unit> f503274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f503275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h f503276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AVSessionState f503277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f503278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AVSessionState f503279o;

    public static final class a {
    }

    static {
    }

    public e() {
        this(null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f503265a == r101.f503265a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503266b, r101.f503266b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f503267c, r101.f503267c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f503268d, r101.f503268d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f503269e, r101.f503269e) == true) goto L24;
        return false;
    L24:
        if (this.f503270f == r101.f503270f) goto L27;
        return false;
    L27:
        if (this.f503271g == r101.f503271g) goto L30;
        return false;
    L30:
        if (this.f503272h == r101.f503272h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f503273i, r101.f503273i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f503274j, r101.f503274j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f503275k, r101.f503275k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f503276l, r101.f503276l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f503265a;
        int r101 = ((((((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f503266b.hashCode()) * 31) + this.f503267c.hashCode()) * 31) + this.f503268d.hashCode()) * 31) + this.f503269e.hashCode()) * 31) + this.f503270f) * 31) + this.f503271g) * 31;
        AVCommonError r102 = this.f503272h;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        Function0<Unit> r106 = this.f503273i;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        Function1<? super AVSessionState, Unit> r109 = this.f503274j;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        Job r112 = this.f503275k;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        return ((r111 + r103) * 31) + this.f503276l.hashCode();
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "AVTraceContext(sessionCreateTime=" + this.f503265a + ", clockSync=" + this.f503266b + ", commonParams=" + this.f503267c + ", queryTraceData=" + this.f503268d + ", replyTraceData=" + this.f503269e + ", allQueryRound=" + this.f503270f + ", allReplyRound=" + this.f503271g + ", interruptError=" + this.f503272h + ", onResetReply=" + this.f503273i + ", onStateUpdate=" + this.f503274j + ", stateTimeoutJob=" + this.f503275k + ", isSessionExitReport=" + this.f503276l + ')';
    }

    public final void a(AVSessionState r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        AVSessionState r101 = this.f503279o;
        this.f503277m = r101;
        if (r101 == r100) goto L5;
        fe9.a.f476620a.e("AVTraceContext", "curState change from " + this.f503279o + " to " + r100);
    L5:
        this.f503279o = r100;
        this.f503278n = SystemClock.elapsedRealtime();
        Function1<? super AVSessionState, Unit> r102 = this.f503274j;
        if (r102 == null) goto L9;
        r102.invoke(r100);
        return;
    }

    public e(kf9.a r100, int r110) {
        if ((r110 & 1) == 0) goto L5;
        long r101 = SystemClock.elapsedRealtime();
    L7:
        if ((r110 & 2) == 0) goto L9;
        n r102 = new n();
    L11:
        if ((r110 & 4) == 0) goto L14;
        r100 = new kf9.a();
    L14:
        if ((r110 & 8) == 0) goto L16;
        c r103 = new c(0);
    L18:
        if ((r110 & 16) == 0) goto L20;
        d r104 = new d(null);
    L22:
        if ((r110 & 2048) == 0) goto L24;
        h r111 = new h();
    L25:
        Intrinsics.checkNotNullParameter(r102, "clockSync");
        Intrinsics.checkNotNullParameter(r100, "commonParams");
        Intrinsics.checkNotNullParameter(r103, "queryTraceData");
        Intrinsics.checkNotNullParameter(r104, "replyTraceData");
        Intrinsics.checkNotNullParameter(r111, "isSessionExitReport");
        this.f503265a = r101;
        this.f503266b = r102;
        this.f503267c = r100;
        this.f503268d = r103;
        this.f503269e = r104;
        this.f503270f = 0;
        this.f503271g = 0;
        this.f503272h = null;
        this.f503273i = null;
        this.f503274j = null;
        this.f503275k = null;
        this.f503276l = r111;
        this.f503278n = SystemClock.elapsedRealtime();
        this.f503279o = AVSessionState.Start;
        return;
    L24:
        r111 = null;
        goto L25
    L20:
        r104 = null;
        goto L22
    L16:
        r103 = null;
        goto L18
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = 0;
        goto L7
    }
}
