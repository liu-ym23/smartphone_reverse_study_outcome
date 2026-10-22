package com.larus.agents.impl.webfetch;

import androidx.camera.video.AudioStats;
import com.larus.agents.api.IWebPageFetchService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.SemaphoreImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class WebFetchCommandProcessor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f286802i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f286803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f286804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Double> f286805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f286806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f286807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f286808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<String, b> f286809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SemaphoreImpl f286810h;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f286811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f286812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Double f286813c;

        public b(i r100, double r101) {
            Intrinsics.checkNotNullParameter(r100, "command");
            this.f286811a = r100;
            this.f286812b = r101;
        }
    }

    static {
    }

    public static void c(i r100, String r101) {
        FLogger.f375446a.i("WebPageFetch", "command_id=" + k.a(r100.f286859a) + ' ' + r101);
    }

    public final Object b(i r100, Continuation<? super l> r110) {
        if ((r110 instanceof WebFetchCommandProcessor$fetch$1) == false) goto L7;
        WebFetchCommandProcessor$fetch$1 r101 = (WebFetchCommandProcessor$fetch$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        WebFetchCommandProcessor$fetch$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L25:
        k48.a r112 = (k48.a) r111;
        if ((r112 instanceof k48.a.b) == false) goto L29;
        k48.a.b r113 = (k48.a.b) r112;
        return new l(r113.f501766e, r113.f501764c, "HTML");
    L29:
        if ((r112 instanceof k48.a.C6507a) == false) goto L33;
        int r106 = l.f286866d;
        k48.a.C6507a r114 = (k48.a.C6507a) r112;
        return l.a.a(r114.f501760a, r114.f501761b);
    L33:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        String r115 = r100.f286862d;
        if (r115 != null) goto L18;
        int r107 = l.f286866d;
        return l.a.a("INVALID_REQUEST", 0);
    L18:
        IWebPageFetchService r108 = (IWebPageFetchService) ServiceManager.get().getService(IWebPageFetchService.class);
        if (r108 != null) goto L22;
        int r109 = l.f286866d;
        return l.a.a("SERVICE_UNAVAILABLE", 0);
    L22:
        int r116 = h.f286854e;
        int r117 = h.a.a().f286857c;
        String r118 = r100.f286859a;
        boolean r119 = r100.f286863e;
        int r120 = r100.f286864f;
        r103.label = 1;
        r111 = r108.a(r115, r118, r119, r117, r120, r103);
        if (r111 != r104) goto L25;
        return r104;
    L7:
        r101 = new WebFetchCommandProcessor$fetch$1(this, r110);
        goto L8
    }

    public WebFetchCommandProcessor(CoroutineScope r100, d r101, com.larus.agents.impl.webfetch.b r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "reporter");
        Intrinsics.checkNotNullParameter(r102, "nowSeconds");
        this.f286803a = r100;
        this.f286804b = r101;
        this.f286805c = r102;
        this.f286806d = 10;
        this.f286807e = 210;
        this.f286808f = new Object();
        this.f286809g = new LinkedHashMap();
        int r103 = kotlinx.coroutines.sync.d.f505140a;
        this.f286810h = new SemaphoreImpl(2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.larus.agents.impl.webfetch.WebFetchCommandProcessor$b] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.agents.impl.webfetch.WebFetchCommandProcessor$b] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.agents.impl.webfetch.WebFetchCommandProcessor$b] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.agents.impl.webfetch.WebFetchCommandProcessor, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.agents.impl.webfetch.WebFetchCommandProcessor$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v18, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r14v20, types: [com.larus.agents.impl.webfetch.WebFetchCommandProcessor$b] */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r14v27, types: [com.larus.agents.impl.webfetch.WebFetchCommandProcessor$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29, types: [com.larus.agents.impl.webfetch.WebFetchCommandProcessor$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v34 */
    /* JADX WARN: Type inference failed for: r14v35 */
    /* JADX WARN: Type inference failed for: r14v36 */
    /* JADX WARN: Type inference failed for: r14v7, types: [com.larus.agents.impl.webfetch.WebFetchCommandProcessor$b] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v22, types: [java.lang.Object, kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r15v23, types: [java.lang.Object, kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    public static final Object a(WebFetchCommandProcessor r110, b r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof WebFetchCommandProcessor$execute$1) == false) goto L7;
        WebFetchCommandProcessor$execute$1 r100 = (WebFetchCommandProcessor$execute$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r103 = r100.label;
        boolean r104 = true;
        if (r103 != 0) goto L111;
        ResultKt.throwOnFailure(r113);
        ?? r114 = new Ref.BooleanRef();
        c(r111.f286811a, "command_execute_start");
        long r105 = TimeUnit.SECONDS.toMillis(1);     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        WebFetchCommandProcessor$execute$outcome$1 r106 = new WebFetchCommandProcessor$execute$outcome$1(r110, r114, null);     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        r100.L$0 = r111;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        r100.L$1 = r114;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        r100.label = 1;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        ?? r115 = r111;
        ?? r116 = r114;
        if (TimeoutKt.c(r105, r106, r100) == r102) goto L112;
    L38:
        i r107 = r115.f286811a;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        if (r107.f286864f < 0) goto L49;
        String r108 = r107.f286862d;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        if (r108 != null) goto L43;
    L46:
        boolean r109 = true;
    L47:
        if (r109 == true) goto L49;
        boolean r117 = true;
    L50:
        if (r117 == true) goto L53;
        int r118 = l.f286866d;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        l r119 = l.a.a("INVALID_REQUEST", 0);     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        ?? r120 = r115;
        ?? r121 = r116;
    L62:
        i r122 = r120.f286811a;     // Catch: Throwable -> L82 CancellationException -> L84
        StringBuilder r123 = new StringBuilder("command_fetch_complete success=");     // Catch: Throwable -> L82 CancellationException -> L84
        if (r119.f286868b != null) goto L66;
        r104 = false;
    L66:
        r123.append(r104);     // Catch: Throwable -> L82 CancellationException -> L84
        r123.append(" reason=");     // Catch: Throwable -> L82 CancellationException -> L84
        r123.append(r119.f286869c);     // Catch: Throwable -> L82 CancellationException -> L84
        r123.append(" status=");     // Catch: Throwable -> L82 CancellationException -> L84
        r123.append(r119.f286867a);     // Catch: Throwable -> L82 CancellationException -> L84
        c(r122, r123.toString());     // Catch: Throwable -> L82 CancellationException -> L84
        r100.L$0 = r120;     // Catch: Throwable -> L82 CancellationException -> L84
        r100.L$1 = r121;     // Catch: Throwable -> L82 CancellationException -> L84
        r100.label = 3;     // Catch: Throwable -> L82 CancellationException -> L84
        if (r110.d(r120, r119, r100) == r102) goto L114;
        ?? r124 = r120;
        ?? r125 = r121;
    L71:
        if (r125.element == false) goto L73;
        r110.f286810h.release();
    L73:
        Object r126 = r110.f286808f;
        monitor-enter(r126);
        r124.f286813c = r110.f286805c.invoke();     // Catch: Throwable -> L79
        Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L79
        monitor-exit(r126);
        c(r124.f286811a, "command_complete elapsed_seconds=" + (r110.f286805c.invoke().doubleValue() - r124.f286812b));
        return Unit.INSTANCE;
    L79:
        th = move-exception;
        throw th;
    L114:
        return r102;
    L53:
        if (r116.element == true) goto L55;
        int r128 = l.f286866d;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        r119 = l.a.a("BUSY", 0);     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        r120 = r115;
        r121 = r116;
        goto L62
    L55:
        i r129 = r115.f286811a;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        r100.L$0 = r115;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        r100.L$1 = r116;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        r100.label = 2;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        Object r130 = r110.b(r129, r100);     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        ?? r131 = r115;
        ?? r132 = r116;
        if (r130 != r102) goto L59;
        return r102;
    L59:
        r119 = (l) r130;     // Catch: Exception -> L60 Throwable -> L82 CancellationException -> L86
        r120 = r131;
        r121 = r132;
        goto L62
    L43:
        if (StringsKt.isBlank(r108) == true) goto L46;
        r109 = false;
    L49:
        r117 = false;
        goto L50
    L112:
        return r102;
    L86:
        e = move-exception;
        throw e;     // Catch: Throwable -> L82 CancellationException -> L84
    L60:
        Exception e100 = e;
    L61:
        c(r111.f286811a, "command_execute_error exception_type=".concat(e100.getClass().getSimpleName()));     // Catch: Throwable -> L82 CancellationException -> L84
        int r133 = l.f286866d;     // Catch: Throwable -> L82 CancellationException -> L84
        r119 = l.a.a("EXECUTION_FAILED", 0);     // Catch: Throwable -> L82 CancellationException -> L84
        r120 = r111;
        r121 = r114;
        goto L62
    L111:
        if (r103 == 1) goto L25;
        if (r103 == 2) goto L22;
        if (r103 != 3) goto L21;
        r111 = (Ref.BooleanRef) r100.L$1;
        ?? r134 = (b) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L16 CancellationException -> L18
        r124 = r134;
        r125 = r111;
    L18:
        e = move-exception;
        r111 = r134;
        e = e;
    L88:
        c(r111.f286811a, "command_cancelled");     // Catch: Throwable -> L82
        throw e;     // Catch: Throwable -> L82
    L16:
        Throwable th10 = th;
    L92:
        if (r111.element == false) goto L94;
        r110.f286810h.release();
    L94:
        Object r135 = r110.f286808f;
        monitor-enter(r135);
        r134.f286813c = r110.f286805c.invoke();     // Catch: Throwable -> L100
        Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L100
        monitor-exit(r135);
        c(r134.f286811a, "command_complete elapsed_seconds=" + (r110.f286805c.invoke().doubleValue() - r134.f286812b));
        throw th10;
    L100:
        th = move-exception;
        throw th;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        Ref.BooleanRef r137 = (Ref.BooleanRef) r100.L$1;
        b r138 = (b) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L28 Exception -> L30 CancellationException -> L32
        r132 = r137;
        r131 = r138;
        r130 = r113;
        goto L59
    L25:
        Ref.BooleanRef r139 = (Ref.BooleanRef) r100.L$1;
        b r140 = (b) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L28 Exception -> L30 CancellationException -> L32
        r116 = r139;
        r115 = r140;
    L32:
        e = move-exception;
        throw e;     // Catch: Throwable -> L82 CancellationException -> L84
    L30:
        e = move-exception;
        r114 = r111;
        r111 = r103;
        e100 = e;
    L28:
        th10 = th;
        r134 = r103;
    L84:
        e = e;
    L82:
        th = move-exception;
        r134 = r111;
        r111 = r113;
        th10 = th;
    L7:
        r100 = new WebFetchCommandProcessor$execute$1(r110, r112);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x01a6 -> B:13:0x004e). Please report as a decompilation issue!!! */
    public final Object d(b r210, l r211, Continuation<? super Unit> r212) {
        if ((r212 instanceof WebFetchCommandProcessor$report$1) == false) goto L7;
        WebFetchCommandProcessor$report$1 r100 = (WebFetchCommandProcessor$report$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        WebFetchCommandProcessor r102 = this;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        long r106 = 1;
        String r107 = "result_report_attempt_failed attempt=";
        if (r105 == 0) goto L23;
        if (r105 == 1) goto L16;
        if (r105 != 2) goto L15;
        int r108 = r100.I$1;
        int r110 = r100.I$0;
        l r111 = (l) r100.L$1;
        b r112 = (b) r100.L$0;
        ResultKt.throwOnFailure(r103);
        WebFetchCommandProcessor$report$1 r109 = r100;
        WebFetchCommandProcessor r113 = r102;
        b r114 = r112;
        int r115 = 1;
        int r116 = r110;
        int r117 = r108;
        long r118 = 1;
        String r119 = "result_report_attempt_failed attempt=";
        Object r120 = r104;
        l r121 = r111;
    L13:
        String r122 = r119;
        r117 = r117 + r115;
        r106 = r118;
        WebFetchCommandProcessor$report$1 r123 = r109;
    L24:
        if (r117 >= r116) goto L63;
        JobKt.ensureActive(r123.getContext());
        c(r114.f286811a, "result_report_start attempt=" + (r117 + 1));
        double r124 = ((double) r113.f286807e) - (r113.f286805c.invoke().doubleValue() - r114.f286812b);
        if (r124 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
        c(r114.f286811a, "result_report_failed reason=expired");
        return Unit.INSTANCE;
    L29:
        long r125 = RangesKt.coerceAtLeast((long) (Math.min(r113.f286806d, r124) * TimeUnit.SECONDS.toMillis(r106)), r106);
        WebFetchCommandProcessor$report$2$ack$response$1 r126 = new WebFetchCommandProcessor$report$2$ack$response$1(r113, r114, r121, null);     // Catch: CancellationException -> L21 Exception -> L42
        r123.L$0 = r114;     // Catch: CancellationException -> L21 Exception -> L42
        r123.L$1 = r121;     // Catch: CancellationException -> L21 Exception -> L42
        r123.I$0 = r116;     // Catch: CancellationException -> L21 Exception -> L42
        r123.I$1 = r117;     // Catch: CancellationException -> L21 Exception -> L42
        r123.I$2 = r117;     // Catch: CancellationException -> L21 Exception -> L42
        r123.label = 1;     // Catch: CancellationException -> L21 Exception -> L42
        r103 = TimeoutKt.c(r125, r126, r123);     // Catch: CancellationException -> L21 Exception -> L42
        if (r103 != r120) goto L33;
        return r120;
    L33:
        WebFetchCommandProcessor r127 = r113;
        b r128 = r114;
        r100 = r123;
        int r129 = r117;
        int r130 = r116;
        l r131 = r121;
        r104 = r120;
        r107 = r122;
        int r132 = r130;
    L68:
        WebFetchReportAck r133 = (WebFetchReportAck) r103;     // Catch: CancellationException -> L21 Exception -> L40
        if (r133 != null) goto L37;
        c(r128.f286811a, r107 + (r129 + 1) + " reason=timeout");     // Catch: CancellationException -> L21 Exception -> L40
    L37:
        if (r133 != null) goto L45;
        r133 = WebFetchReportAck.RETRYABLE;     // Catch: CancellationException -> L21 Exception -> L40
    L45:
        i r134 = r128.f286811a;
        StringBuilder r135 = new StringBuilder("result_report_ack attempt=");
        int r136 = r129 + 1;
        r135.append(r136);
        r135.append(" ack=");
        r135.append(r133);
        c(r134, r135.toString());
        if (r133 != WebFetchReportAck.ACCEPTED) goto L50;
        return Unit.INSTANCE;
    L50:
        if (r133 != WebFetchReportAck.REJECTED) goto L52;
    L59:
        c(r128.f286811a, "result_report_failed ack=" + r133 + " attempts=" + r136);
        return Unit.INSTANCE;
    L52:
        if (r129 == 1) goto L59;
        r118 = 1;
        long r137 = (long) (TimeUnit.SECONDS.toMillis(1) * 0.25d);
        r100.L$0 = r128;
        r100.L$1 = r131;
        r100.I$0 = r132;
        r100.I$1 = r117;
        r100.label = 2;
        if (DelayKt.delay(r137, r100) != r104) goto L57;
        return r104;
    L57:
        r109 = r100;
        r114 = r128;
        r113 = r127;
        r115 = 1;
        r119 = r107;
        r120 = r104;
        r121 = r131;
        r116 = r132;
    L40:
        Exception e100 = e;
    L44:
        c(r128.f286811a, r107 + (r129 + 1) + " reason=exception exception_type=" + e100.getClass().getSimpleName());
        r133 = WebFetchReportAck.RETRYABLE;
        goto L45
    L21:
        e = move-exception;
        throw e;
    L42:
        e100 = e;
        r127 = r113;
        r128 = r114;
        r100 = r123;
        r129 = r117;
        int r138 = r116;
        r131 = r121;
        r104 = r120;
        r107 = r122;
        r132 = r138;
        goto L44
    L63:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r129 = r100.I$2;
        r117 = r100.I$1;
        r132 = r100.I$0;
        r131 = (l) r100.L$1;
        r128 = (b) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L19 CancellationException -> L21
        r127 = r102;
    L19:
        e100 = e;
        r127 = r102;
        goto L44
    L23:
        ResultKt.throwOnFailure(r103);
        r123 = r100;
        r113 = r102;
        r122 = "result_report_attempt_failed attempt=";
        r117 = 0;
        r116 = 2;
        r114 = r210;
        r120 = r104;
        r121 = r211;
    L7:
        r102 = this;
        r100 = new WebFetchCommandProcessor$report$1(r102, r212);
        goto L8
    }
}
