package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.network.NetConnectionTypeProvider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes25.dex */
public final class NetworkAwareRetrier {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long[] f294376m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f294377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f294378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f294379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineDispatcher f294380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f294381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f294382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<s, Continuation<? super RetryDecision>, Object> f294383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f294384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f294385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f294386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p f294387k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Channel<Unit> f294388l;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f294389a = null;

        static {
            int[] r100 = new int[RetryDecision.values().length];
            r100[RetryDecision.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[RetryDecision.TERMINAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[RetryDecision.RETRY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f294389a = r100;
        }
    }

    static {
        f294376m = new long[]{5000, 15000, 45000, 120000, 300000};
    }

    public final void b() {
        if (this.f294384h == false) goto L7;
        n1.d(this.f294378b, "skip execute, already succeeded");
        return;
    L7:
        if (this.f294385i == false) goto L10;
        n1.d(this.f294378b, "skip execute, already terminated");
        return;
    L10:
        Job r100 = this.f294386j;
        boolean r101 = false;
        if (r100 != null) goto L13;
    L15:
        if (r101 == false) goto L18;
        n1.d(this.f294378b, "skip execute, retry loop already running");
        return;
    L18:
        this.f294386j = BuildersKt.launch$default(this.f294377a, this.f294380d, null, new NetworkAwareRetrier$execute$1(this, null), 2, null);
        return;
    L13:
        if (r100.isActive() != true) goto L15;
        r101 = true;
        goto L15
    }

    public final void c() {
        p r100 = this.f294387k;
        if (r100 == null) goto L5;
        NetConnectionTypeProvider.f360087d.remove(r100);
    L5:
        this.f294387k = null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0131 -> B:14:0x0037). Please report as a decompilation issue!!! */
    public static final Object a(NetworkAwareRetrier r110, CoroutineScope r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof NetworkAwareRetrier$runLoop$1) == false) goto L7;
        NetworkAwareRetrier$runLoop$1 r100 = (NetworkAwareRetrier$runLoop$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L16;
        long r104 = r100.J$0;
        int r114 = r100.I$0;
        CoroutineScope r105 = (CoroutineScope) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L76
    L14:
        CoroutineScope r115 = r105;
        int r106 = r114;
        r111 = r115;
        if (r113 == null) goto L63;
        boolean r116 = true;
    L64:
        if (r116 == false) goto L66;
        RetryTrigger r117 = RetryTrigger.NETWORK_RECOVERY;     // Catch: Throwable -> L76
    L27:
        int r107 = 0;
    L29:
        if (CoroutineScopeKt.isActive(r111) == true) goto L31;
    L74:
        r110.c();
        return Unit.INSTANCE;
    L31:
        if (r110.f294384h == true) goto L74;
        if (r110.f294385i == true) goto L74;
        if (r110.f294381e.invoke().booleanValue() == true) goto L37;
        n1.d(r110.f294378b, "shouldRetry false, stop");     // Catch: Throwable -> L76
        goto L74
    L37:
        s r108 = new s(r106, r117, r107);     // Catch: Throwable -> L76
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L45
        Function2<s, Continuation<? super RetryDecision>, Object> r119 = r110.f294383g;     // Catch: Throwable -> L45
        r100.L$0 = r111;     // Catch: Throwable -> L45
        r100.I$0 = r106;     // Catch: Throwable -> L45
        r100.label = 1;     // Catch: Throwable -> L45
        r113 = r119.invoke(r108, r100);     // Catch: Throwable -> L45
        if (r113 == r102) goto L86;
        int r120 = r106;
        r105 = r111;
        int r121 = r120;
    L42:
        Object r122 = Result.m9449constructorimpl((RetryDecision) r113);     // Catch: Throwable -> L20
    L47:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r122);     // Catch: Throwable -> L76
        if (r109 == null) goto L50;
        n1.b(r110.f294378b, "retry action error: " + r109.getMessage());     // Catch: Throwable -> L76
    L50:
        RetryDecision r123 = RetryDecision.RETRY;     // Catch: Throwable -> L76
        if (Result.m9455isFailureimpl(r122) == false) goto L53;
        r122 = r123;
    L53:
        int r124 = b.f294389a[((RetryDecision) r122).ordinal()];     // Catch: Throwable -> L76
        if (r124 == 1) goto L71;
        if (r124 != 2) goto L57;
        r110.f294385i = true;     // Catch: Throwable -> L76
        n1.e(r110.f294378b, "retry action terminal error, stop retrying");     // Catch: Throwable -> L76
        Unit r125 = Unit.INSTANCE;     // Catch: Throwable -> L76
    L70:
        Unit r126 = r125;
        r110.c();
        return r126;
    L57:
        if (r124 != 3) goto L68;
        long[] r127 = r110.f294379c;     // Catch: Throwable -> L76
        r104 = r127[RangesKt.coerceAtMost(r121, ArraysKt.getLastIndex(r127))];     // Catch: Throwable -> L76
        r114 = r121 + 1;     // Catch: Throwable -> L76
        n1.d(r110.f294378b, "retry later, delayMs=" + r104);     // Catch: Throwable -> L76
        NetworkAwareRetrier$runLoop$wokenByNetwork$1 r128 = new NetworkAwareRetrier$runLoop$wokenByNetwork$1(r110, null);     // Catch: Throwable -> L76
        r100.L$0 = r105;     // Catch: Throwable -> L76
        r100.I$0 = r114;     // Catch: Throwable -> L76
        r100.J$0 = r104;     // Catch: Throwable -> L76
        r100.label = 2;     // Catch: Throwable -> L76
        r113 = TimeoutKt.c(r104, r128, r100);     // Catch: Throwable -> L76
        if (r113 != r102) goto L14;
        return r102;
    L68:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L76
    L71:
        r110.f294384h = true;     // Catch: Throwable -> L76
        n1.d(r110.f294378b, "retry action success");     // Catch: Throwable -> L76
        r110.f294382f.invoke();     // Catch: Throwable -> L76
        r125 = Unit.INSTANCE;     // Catch: Throwable -> L76
    L20:
        Throwable th10 = th;
        CoroutineScope r129 = r105;
        r106 = r121;
        r111 = r129;
    L46:
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L76
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th10));     // Catch: Throwable -> L76
        int r131 = r106;
        r105 = r111;
        r121 = r131;
        goto L47
    L86:
        return r102;
    L45:
        th10 = th;
        goto L46
    L66:
        r117 = RetryTrigger.BACKOFF;     // Catch: Throwable -> L76
        r107 = (int) (r104 / 1000);     // Catch: Throwable -> L76
        goto L29
    L63:
        r116 = false;
    L76:
        th = move-exception;
        r110.c();
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r121 = r100.I$0;
        r105 = (CoroutineScope) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L20
        goto L42
    L22:
        ResultKt.throwOnFailure(r113);
        if (r110.f294387k != null) goto L26;
        p r132 = new p(r110);
        r110.f294387k = r132;
        NetConnectionTypeProvider.f360087d.addIfAbsent(r132);
    L26:
        r117 = RetryTrigger.INITIAL;
        r106 = 0;
    L7:
        r100 = new NetworkAwareRetrier$runLoop$1(r110, r112);
        goto L8
    }

    public NetworkAwareRetrier(CoroutineScope r100, String r101, Function0 r102, d r103, Function2 r104, int r110) {
        if ((r110 & 4) == 0) goto L5;
        long[] r105 = f294376m;
    L7:
        if ((r110 & 8) == 0) goto L9;
        CoroutineDispatcher r106 = Dispatchers.getIO();
    L11:
        if ((r110 & 16) == 0) goto L13;
        r102 = new n();
    L13:
        Function0<Unit> r107 = r103;
        if ((r110 & 32) == 0) goto L16;
        r107 = new o();
    L16:
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r105, "backoffDelaysMs");
        Intrinsics.checkNotNullParameter(r106, "dispatcher");
        Intrinsics.checkNotNullParameter(r102, "shouldRetry");
        Intrinsics.checkNotNullParameter(r107, "onSuccess");
        Intrinsics.checkNotNullParameter(r104, "action");
        this.f294377a = r100;
        this.f294378b = r101;
        this.f294379c = r105;
        this.f294380d = r106;
        this.f294381e = r102;
        this.f294382f = r107;
        this.f294383g = r104;
        this.f294388l = ChannelKt.Channel$default(-1, null, null, 6, null);
        return;
    L9:
        r106 = null;
        goto L11
    L5:
        r105 = null;
        goto L7
    }
}
