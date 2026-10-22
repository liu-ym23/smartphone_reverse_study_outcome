package com.larus.agents.impl.webfetch;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes24.dex */
public final class WebPageFetcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f286817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Integer> f286818d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Regex f286819e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f286820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f286821b;

    public static final class a {
    }

    public WebPageFetcher() {
        this(0);
    }

    static {
        f286817c = SetsKt.setOf(new String[]{"invalid_max_redirect", "invalid_max_bytes", "invalid_url", "missing_location", "too_many_redirects", "invalid_redirect_url", "downgrade_redirect", "unsupported_charset", "fetch_timeout"});
        f286818d = SetsKt.setOf(new Integer[]{301, 302, 303, 307, 308});
        f286819e = new Regex("(?:^|;)\\s*charset\\s*=\\s*(?:\"([^\"]*)\"|([^;\\s]*))", RegexOption.IGNORE_CASE);
    }

    public WebPageFetcher(int r100) {
        f r101 = new f();
        Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_TRANSPORT);
        this.f286820a = r101;
        this.f286821b = 180;
    }

    public static final double c(long r100) {
        return (System.nanoTime() - r100) / TimeUnit.SECONDS.toNanos(1);
    }

    public static final void d(String r100, long r101, String r102) {
        FLogger.f375446a.i("WebPageFetch", "command_id=" + r100 + ' ' + r102 + " elapsed_seconds=" + c(r101));
    }

    public final Object b(String r210, String r211, boolean r310, int r311, int r312, Continuation<? super k48.a> r313) {
        if ((r313 instanceof WebPageFetcher$fetchWebPageHtml$1) == false) goto L7;
        WebPageFetcher$fetchWebPageHtml$1 r100 = (WebPageFetcher$fetchWebPageHtml$1) r313;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        WebPageFetcher$fetchWebPageHtml$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        long r104 = r110.J$0;
        String r105 = (String) r110.L$2;
        AtomicInteger r106 = (AtomicInteger) r110.L$1;
        AtomicReference r107 = (AtomicReference) r110.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: CancellationException -> L14
        String r212 = " status=";
    L78:
        Object r108 = (k48.a) r102;     // Catch: CancellationException -> L49
        if (r108 != null) goto L40;
        r108 = new k48.a.C6507a("fetch_timeout", r106.get());     // Catch: CancellationException -> L49
    L40:
        if ((r108 instanceof k48.a.b) == false) goto L43;
        StringBuilder r109 = new StringBuilder("outcome=html status=");
        k48.a.b r112 = (k48.a.b) r108;
        r109.append(r112.f501766e);
        r109.append(" redirects=");
        r109.append(r112.f501763b);
        r109.append(" limit_reached=");
        r109.append(r112.f501765d);
        String r113 = r109.toString();
    L45:
        d(r105, r104, "fetch_complete " + r113);
        return r108;
    L43:
        if ((r108 instanceof k48.a.C6507a) == false) goto L48;
        StringBuilder r114 = new StringBuilder("outcome=fail stage=");
        r114.append((String) r107.get());
        r114.append(" reason=");
        k48.a.C6507a r115 = (k48.a.C6507a) r108;
        r114.append(r115.f501760a);
        r114.append(r212);
        r114.append(r115.f501761b);
        r113 = r114.toString();
        goto L45
    L48:
        throw new NoWhenBranchMatchedException();
    L49:
        e = e;
        String r116 = r212;
    L66:
        d(r105, r104, "fetch_cancelled stage=" + ((String) r107.get()) + r116 + r106.get());
        throw e;
    L14:
        e = e;
        r116 = " status=";
        goto L66
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        long r117 = System.nanoTime();
        AtomicReference r118 = new AtomicReference("validate_input");
        AtomicInteger r119 = new AtomicInteger();
        String r120 = k.a(r211);
        d(r120, r117, "fetch_start send_cookie=" + r310 + " max_redirect=" + r311 + " max_bytes=" + r312 + " timeout_seconds=" + this.f286821b);
        long r121 = TimeUnit.SECONDS.toMillis(this.f286821b);     // Catch: CancellationException -> L63
        if (r310 == false) goto L22;
        boolean r122 = true;
    L23:
        r212 = " status=";
        WebPageFetcher$fetchWebPageHtml$result$1 r123 = new WebPageFetcher$fetchWebPageHtml$result$1(r118, r119, r120, r117, r311, r312, r210, this, r122, null);     // Catch: CancellationException -> L59
        AtomicReference r124 = r118;
        r110.L$0 = r124;     // Catch: CancellationException -> L57
        AtomicInteger r125 = r119;
        r110.L$1 = r125;     // Catch: CancellationException -> L55
        String r126 = r120;
        r110.L$2 = r126;     // Catch: CancellationException -> L53
        long r127 = r117;
        r110.J$0 = r127;     // Catch: CancellationException -> L51
        r110.label = 1;     // Catch: CancellationException -> L51
        Object r128 = TimeoutKt.c(r121, r123, r110);     // Catch: CancellationException -> L51
        if (r128 != r111) goto L35;
        return r111;
    L35:
        r107 = r124;
        r102 = r128;
        r106 = r125;
        r105 = r126;
        r104 = r127;
    L51:
        e = e;
    L62:
        r116 = r212;
    L65:
        r107 = r124;
        long r213 = r127;
        r106 = r125;
        r105 = r126;
        r104 = r213;
    L53:
        e = e;
    L61:
        r127 = r117;
    L55:
        e = e;
        r126 = r120;
    L57:
        e = e;
        r126 = r120;
        r125 = r119;
    L59:
        e = e;
        r126 = r120;
        r125 = r119;
        r124 = r118;
        goto L61
    L22:
        r122 = false;
    L63:
        e = e;
        r126 = r120;
        r125 = r119;
        r124 = r118;
        r127 = r117;
        r116 = " status=";
    L7:
        r100 = new WebPageFetcher$fetchWebPageHtml$1(this, r313);
        goto L8
    }

    public static final k48.a a(WebPageFetcher r210, v r211, String r212, int r213, int r214, Function0 r215, Function1 r216) {
        r210.getClass();
        int r100 = r211.getStatus();
        boolean r101 = true;
        if (200 <= r100) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L103;
        if (r211.getStatus() == 204) goto L103;
        if (r211.getStatus() == 205) goto L103;
        String r103 = r211.header("Content-Type");
        String r104 = "";
        if (r103 != null) goto L17;
        r103 = "";
    L17:
        String r105 = null;
        String r106 = StringsKt.trim(StringsKt.substringBefore$default(r103, ';', null, 2, null)).toString();
        if (StringsKt.equals(r106, "text/html", true) == false) goto L20;
    L28:
        MatchResult r107 = Regex.find$default(f286819e, r103, 0, 2, null);
        if (r107 != null) goto L31;
        Charset r108 = Charsets.UTF_8;
    L44:
        StringBuilder r109 = new StringBuilder("charset_selected charset=");
        r109.append(r108.name());
        r109.append(" source=");
        if (r107 != null) goto L47;
        String r110 = "default";
    L48:
        r109.append(r110);
        r216.invoke(r109.toString());
        InputStream r111 = r211.C4();
        if (r111 == null) goto L115;
        if (r214 != 0) goto L53;
        int r112 = 1048576;
    L54:
        ByteArrayOutputStream r113 = new ByteArrayOutputStream();
        byte[] r114 = new byte[8192];
    L56:
        if (r113.size() >= r112) goto L61;
        r215.invoke();
        int r115 = r111.read(r114, 0, Math.min(8192, r112 - r113.size()));
        if (r115 < 0) goto L61;
        if (r115 <= 0) goto L56;
        r113.write(r114, 0, r115);
    L61:
        r215.invoke();
        String r116 = r113.toString(r108.name());
        Intrinsics.checkNotNull(r116);
        Intrinsics.checkNotNullParameter(r116, "html");
        int r117 = 0;
        int r118 = 0;
    L63:
        if (r117 >= r116.length()) goto L85;
        int r119 = r116.codePointAt(r117);
        if (r119 > 127) goto L68;
    L77:
        int r120 = 1;
    L83:
        if (r120 > (r112 - r118)) goto L85;
        r118 = r118 + r120;
        r117 = r117 + Character.charCount(r119);
        goto L63
    L68:
        if (r119 > 2047) goto L71;
        r120 = 2;
        goto L83
    L71:
        if (55296 <= r119) goto L73;
    L75:
        boolean r121 = false;
    L76:
        if (r121 == true) goto L77;
        if (r119 > 65535) goto L81;
        r120 = 3;
        goto L83
    L81:
        r120 = 4;
        goto L83
    L73:
        if (r119 >= 57344) goto L75;
        r121 = true;
    L85:
        String r122 = r116.substring(0, r117);
        r215.invoke();
        if (r113.size() != r112) goto L88;
    L91:
        boolean r123 = true;
    L116:
        return new k48.a.b(r212, r213, r122, r123, r211.getStatus());
    L88:
        if (r122.length() < r116.length()) goto L91;
        r123 = false;
        goto L116
    L53:
        r112 = r214;
        goto L54
    L115:
        return new k48.a.C6507a("empty_body", r211.getStatus());
    L47:
        r110 = "http_header";
        goto L48
    L31:
        MatchGroup r124 = r107.getGroups().get(1);
        if (r124 == null) goto L37;
        String r125 = r124.getValue();
        if (r125 == null) goto L37;
        r104 = r125;
    L104:
        r108 = Charset.forName(r104);     // Catch: IllegalArgumentException -> L93
    L93:
        e = move-exception;
        String r126 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.take(r104, 64), '\r', '_', false, 4, null), '\n', '_', false, 4, null);
        if (r126.length() == 0) goto L98;
        r101 = false;
    L98:
        if (r101 == false) goto L100;
        r126 = "empty";
    L100:
        r216.invoke("charset_unsupported charset=" + r126 + " status=" + r211.getStatus());
        throw new IOException("unsupported_charset", e);
    L37:
        MatchGroup r127 = r107.getGroups().get(2);
        if (r127 == null) goto L40;
        r105 = r127.getValue();
    L40:
        if (r105 == null) goto L104;
        r104 = r105;
        goto L104
    L20:
        if (StringsKt.equals(r106, "application/xhtml+xml", true) == true) goto L28;
        String r128 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.take(r106, 128), '\r', '_', false, 4, null), '\n', '_', false, 4, null);
        if (r128.length() == 0) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        r128 = "missing";
    L27:
        r216.invoke("body_rejected reason=not_html media_type=" + r128 + " status=" + r211.getStatus());
        return new k48.a.C6507a("not_html", r211.getStatus());
    L103:
        return new k48.a.C6507a(BdpAppEventConstant.HTTP_STATUS, r211.getStatus());
    L5:
        if (r100 >= 300) goto L7;
        r102 = true;
        goto L8
    }
}
