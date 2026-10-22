package com.bytedance.dpop;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f204782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f204783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f204784c;

    public static final class a {
    }

    static {
    }

    public e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "dpopJwtGenerator");
        this.f204782a = r100;
        this.f204783b = 5000;
        this.f204784c = 5000;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static String b(InputStream r100) {
        String r101 = null;
        if (r100 == null) goto L15;
        Reader r102 = new InputStreamReader(r100, Charsets.UTF_8);
        if ((r102 instanceof BufferedReader) == false) goto L7;
        BufferedReader r103 = (BufferedReader) r102;
    L18:
        String r104 = TextStreamsKt.readText(r103);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r103, null);
        r101 = r104;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L7:
        r103 = new BufferedReader(r102, 8192);
    L15:
        if (r101 != null) goto L22;
        return "";
    L22:
        return r101;
    }

    public final Object c(String r100, String r110) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L64
        boolean r102 = true;
        if ((!StringsKt.isBlank("https://accounts.feishu.cn")) == false) goto L63;
        if ((!StringsKt.isBlank(r100)) == false) goto L61;
        if ((!StringsKt.isBlank(r110)) == false) goto L59;
        String r103 = StringsKt.trimEnd("https://accounts.feishu.cn", new char[]{'/'}) + "/oauth/v1/ticket";     // Catch: Throwable -> L64
        URLConnection r111 = a(new URL(r103 + "?target_uri=" + URLEncoder.encode(r110, "UTF-8")));     // Catch: Throwable -> L64
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type java.net.HttpURLConnection");     // Catch: Throwable -> L64
        HttpURLConnection r112 = (HttpURLConnection) r111;     // Catch: Throwable -> L64
        r112.setRequestMethod("POST");     // Catch: Throwable -> L55
        r112.setConnectTimeout(this.f204783b);     // Catch: Throwable -> L55
        r112.setReadTimeout(this.f204784c);     // Catch: Throwable -> L55
        r112.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");     // Catch: Throwable -> L55
        r112.setRequestProperty("Authorization", r100);     // Catch: Throwable -> L55
        if (StringsKt.startsWith$default(r100, "DPoP ", false, 2, null) == false) goto L13;
        d r104 = this.f204782a.a();     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter("POST", "str");     // Catch: Throwable -> L55
        r104.f204781b.put("htm", "POST");     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter(r103, "str");     // Catch: Throwable -> L55
        r104.f204781b.put("htu", r103);     // Catch: Throwable -> L55
        Object r105 = r104.a();     // Catch: Throwable -> L55
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L55
        r112.setRequestProperty("DPoP", (String) r105);     // Catch: Throwable -> L55
    L13:
        int r106 = r112.getResponseCode();     // Catch: Throwable -> L55
        if (200 > r106) goto L17;
        if (r106 >= 300) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L20;
        String r108 = b(r112.getInputStream());     // Catch: Throwable -> L55
    L21:
        if (200 > r106) goto L24;
        if (r106 >= 300) goto L24;
    L25:
        if (r102 == false) goto L54;
        g r109 = (g) j.f204794a.fromJson(r108, g.class);     // Catch: Throwable -> L55
        if (r109 == null) goto L52;
        Integer r113 = r109.f204788a;     // Catch: Throwable -> L55
        if (r113 == null) goto L50;
        if (r113.intValue() != 0) goto L50;
        h r114 = r109.f204790c;     // Catch: Throwable -> L55
        if (r114 == null) goto L48;
        String r115 = r114.f204791a;     // Catch: Throwable -> L55
        if (r115 == null) goto L48;
        String r116 = this.f204782a.b(r115.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L55
        Long r117 = r109.f204790c.a();     // Catch: Throwable -> L55
        if (r117 == null) goto L46;
        long r118 = r117.longValue();     // Catch: Throwable -> L55
        String r119 = r109.f204790c.f204792b;     // Catch: Throwable -> L55
        if (r119 == null) goto L44;
        f r120 = new f(r115, r116, r118, r119);     // Catch: Throwable -> L55
        r112.disconnect();     // Catch: Throwable -> L64
        return Result.m9449constructorimpl(r120);
    L44:
        throw new DPoPTicketMissingFieldException("alg");     // Catch: Throwable -> L55
    L46:
        throw new DPoPTicketMissingFieldException("expires_in");     // Catch: Throwable -> L55
    L48:
        throw new DPoPTicketMissingFieldException("ticket");     // Catch: Throwable -> L55
    L50:
        throw new DPoPTicketApiException(r109.f204788a, r109.f204789b);     // Catch: Throwable -> L55
    L52:
        throw new DPoPTicketParseException(r108);     // Catch: Throwable -> L55
    L54:
        throw new DPoPTicketHttpException(r106, r108);     // Catch: Throwable -> L55
    L24:
        r102 = false;
        goto L25
    L20:
        r108 = b(r112.getErrorStream());     // Catch: Throwable -> L55
    L17:
        r107 = false;
    L55:
        th = move-exception;
        r112.disconnect();     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L59:
        throw new IllegalArgumentException("targetUri is blank".toString());     // Catch: Throwable -> L64
    L61:
        throw new IllegalArgumentException("authorization is blank".toString());     // Catch: Throwable -> L64
    L63:
        throw new IllegalArgumentException("baseUrl is blank".toString());     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
