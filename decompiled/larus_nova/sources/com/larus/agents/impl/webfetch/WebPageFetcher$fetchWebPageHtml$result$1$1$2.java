package com.larus.agents.impl.webfetch;

import androidx.camera.video.AudioStats;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
public final class WebPageFetcher$fetchWebPageHtml$result$1$1$2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f286822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f286823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f286824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WebPageFetcher f286825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReference<String> f286826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f286827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f286828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AtomicReference<t> f286829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f286830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<k48.a> f286831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f286832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f286833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f286834m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f286835n;

    public WebPageFetcher$fetchWebPageHtml$result$1$1$2(int r100, int r101, String r102, WebPageFetcher r103, AtomicReference r104, AtomicInteger r105, boolean r106, AtomicReference r107, CoroutineScope r108, kotlinx.coroutines.j r110, String r111, long r112, AtomicBoolean r113, AtomicBoolean r114) {
        this.f286822a = r100;
        this.f286823b = r101;
        this.f286824c = r102;
        this.f286825d = r103;
        this.f286826e = r104;
        this.f286827f = r105;
        this.f286828g = r106;
        this.f286829h = r107;
        this.f286830i = r108;
        this.f286831j = r110;
        this.f286832k = r111;
        this.f286833l = r112;
        this.f286834m = r113;
        this.f286835n = r114;
    }

    /* JADX WARN: Type inference failed for: r0v54, types: [T, com.larus.agents.impl.webfetch.e, com.larus.agents.impl.webfetch.v] */
    public final void a() {
        WebPageFetcher.d(this.f286832k, this.f286833l, "worker_start");     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        b(this.f286834m, this.f286825d, this.f286833l);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        if (this.f286822a < 0) goto L6;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L104;
        if (this.f286823b < 0) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L102;
        if ((!StringsKt.isBlank(this.f286824c)) == false) goto L100;
        String r102 = this.f286824c;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        int r110 = 0;
    L17:
        b(this.f286834m, this.f286825d, this.f286833l);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        double r103 = RangesKt.coerceAtLeast(((double) this.f286825d.f286821b) - WebPageFetcher.c(this.f286833l), AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        this.f286826e.set("create_call");     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        this.f286827f.set(0);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        WebPageFetcher.d(this.f286832k, this.f286833l, "request_create_start hop=" + r110 + " remaining_seconds=" + r103);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        g r111 = this.f286825d.f286820a.a(r102, this.f286828g, RangesKt.coerceAtMost(r103, 60.0d));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        this.f286829h.set(r111);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Ref.ObjectRef r112 = new Ref.ObjectRef();     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Unit r113 = null;
        b(this.f286834m, this.f286825d, this.f286833l);     // Catch: Throwable -> L84
        this.f286826e.set("execute_call");     // Catch: Throwable -> L84
        WebPageFetcher.d(this.f286832k, this.f286833l, "request_execute_start hop=" + r110);     // Catch: Throwable -> L84
        ?? r104 = r111.a();     // Catch: Throwable -> L84
        r112.element = r104;     // Catch: Throwable -> L84
        this.f286827f.set(r104.getStatus());     // Catch: Throwable -> L84
        WebPageFetcher.d(this.f286832k, this.f286833l, "response_received hop=" + r110 + " status=" + ((v) r112.element).getStatus());     // Catch: Throwable -> L84
        b(this.f286834m, this.f286825d, this.f286833l);     // Catch: Throwable -> L84
        if (WebPageFetcher.f286818d.contains(Integer.valueOf(((v) r112.element).getStatus())) == false) goto L69;
        this.f286826e.set("validate_redirect");     // Catch: Throwable -> L84
        String r105 = ((v) r112.element).header("Location");     // Catch: Throwable -> L84
        if (r105 == null) goto L68;
        if ((!StringsKt.isBlank(r105)) == true) goto L27;
        r105 = null;
    L27:
        if (r105 == null) goto L68;
        if (r110 >= this.f286822a) goto L66;
        URI r106 = new URI(r102);     // Catch: Exception -> L62 Throwable -> L84
        URI r107 = r106.resolve(r105);     // Catch: Exception -> L62 Throwable -> L84
        r102 = r107.toString();     // Catch: Throwable -> L84
        if ((!StringsKt.isBlank(r102)) == false) goto L61;
        if (StringsKt.equals(r106.getScheme(), "https", true) == true) goto L36;
    L40:
        r110 = r110 + 1;     // Catch: Throwable -> L84
        WebPageFetcher.d(this.f286832k, this.f286833l, "redirect_follow next_hop=" + r110);     // Catch: Throwable -> L84
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L46
        v r109 = (v) r112.element;     // Catch: Throwable -> L46
        if (r109 == null) goto L44;
        r109.close();     // Catch: Throwable -> L46
        r113 = Unit.INSTANCE;     // Catch: Throwable -> L46
    L44:
        Result.m9449constructorimpl(r113);     // Catch: Throwable -> L46
    L124:
        r111.cancel();     // Catch: Throwable -> L50
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L50
    L52:
        u.a(this.f286829h, r111);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L50:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L46:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        goto L124
    L36:
        if (StringsKt.equals(r107.getScheme(), "http", true) == false) goto L40;
        throw new IOException("downgrade_redirect");     // Catch: Throwable -> L84
    L61:
        throw new IllegalArgumentException("invalid_url".toString());     // Catch: Throwable -> L84
    L62:
        e = move-exception;
        throw new IOException("invalid_redirect_url", e);     // Catch: Throwable -> L84
    L66:
        throw new IOException("too_many_redirects");     // Catch: Throwable -> L84
    L68:
        throw new IOException("missing_location");     // Catch: Throwable -> L84
    L69:
        this.f286826e.set("read_body");     // Catch: Throwable -> L84
        WebPageFetcher.d(this.f286832k, this.f286833l, "body_read hop=" + r110);     // Catch: Throwable -> L84
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$finish(this.f286835n, this.f286831j, this.f286834m, this.f286829h, this.f286830i, WebPageFetcher.a(this.f286825d, (v) r112.element, r102, r110, this.f286823b, new WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$1(this.f286834m, this.f286825d, this.f286833l), new WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$2(this.f286832k, this.f286833l)));     // Catch: Throwable -> L84
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L75
        v r117 = (v) r112.element;     // Catch: Throwable -> L75
        if (r117 == null) goto L73;
        r117.close();     // Catch: Throwable -> L75
        r113 = Unit.INSTANCE;     // Catch: Throwable -> L75
    L73:
        Result.m9449constructorimpl(r113);     // Catch: Throwable -> L75
    L131:
        r111.cancel();     // Catch: Throwable -> L79
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L79
    L81:
        u.a(this.f286829h, r111);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$stop(this.f286834m, this.f286829h, this.f286830i);
        WebPageFetcher.d(this.f286832k, this.f286833l, "worker_exit stage=" + this.f286826e.get());
        return;
    L79:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L75:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L84:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L91
        v r121 = (v) r112.element;     // Catch: Throwable -> L91
        if (r121 == null) goto L89;
        r121.close();     // Catch: Throwable -> L91
        r113 = Unit.INSTANCE;     // Catch: Throwable -> L91
    L89:
        Result.m9449constructorimpl(r113);     // Catch: Throwable -> L91
    L127:
        r111.cancel();     // Catch: Throwable -> L95
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L95
    L97:
        u.a(this.f286829h, r111);     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        throw th;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L95:
        th = move-exception;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L91:
        th = move-exception;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
        goto L127
    L100:
        throw new IllegalArgumentException("invalid_url".toString());     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L102:
        throw new IllegalArgumentException("invalid_max_bytes".toString());     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L11:
        r101 = false;
        goto L12
    L104:
        throw new IllegalArgumentException("invalid_max_redirect".toString());     // Catch: Throwable -> L54 Exception -> L56 CancellationException -> L58
    L6:
        r100 = false;
    L54:
        th = move-exception;
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$stop(this.f286834m, this.f286829h, this.f286830i);
        WebPageFetcher.d(this.f286832k, this.f286833l, "worker_exit stage=" + this.f286826e.get());
        throw th;
    L58:
        e = move-exception;
        this.f286831j.cancel(e);     // Catch: Throwable -> L54
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$stop(this.f286834m, this.f286829h, this.f286830i);
        String r124 = this.f286832k;
        long r125 = this.f286833l;
        StringBuilder r126 = new StringBuilder("worker_exit stage=");
    L118:
        r126.append(this.f286826e.get());
        WebPageFetcher.d(r124, r125, r126.toString());
        return;
    L56:
        e = move-exception;
        if ((e instanceof SocketTimeoutException) == false) goto L109;
        String r127 = "fetch_timeout";
    L114:
        WebPageFetcher.d(this.f286832k, this.f286833l, "fetch_error stage=" + this.f286826e.get() + " reason=" + r127 + " exception_type=" + e.getClass().getSimpleName() + " status=" + this.f286827f.get());     // Catch: Throwable -> L54
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$finish(this.f286835n, this.f286831j, this.f286834m, this.f286829h, this.f286830i, new k48.a.C6507a(r127, this.f286827f.get()));     // Catch: Throwable -> L54
        WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$stop(this.f286834m, this.f286829h, this.f286830i);
        r124 = this.f286832k;
        r125 = this.f286833l;
        r126 = new StringBuilder("worker_exit stage=");
        goto L118
    L109:
        if (CollectionsKt.contains(WebPageFetcher.f286817c, e.getMessage()) == false) goto L113;
        r127 = e.getMessage();     // Catch: Throwable -> L54
        if (r127 != null) goto L114;
        r127 = "";
        goto L114
    L113:
        r127 = "unexpected_error";
        goto L114
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static final void b(AtomicBoolean r100, WebPageFetcher r101, long r102) {
        if (r100.get() == true) goto L10;
        if (WebPageFetcher.c(r102) >= r101.f286821b) goto L8;
        return;
    L8:
        throw new SocketTimeoutException("fetch_timeout");
    L10:
        throw new CancellationException("fetch_cancelled");
    }
}
