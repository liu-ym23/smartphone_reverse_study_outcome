package com.larus.browsertakeover.transport;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.net.URI;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements BrowserTransport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f319676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BrowserTransport.EndpointMode f319677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f319678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OkHttpClient f319679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile WebSocket f319680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f319681f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final synchronized void release() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f319681f == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f319681f = true;     // Catch: Throwable -> L11
        disconnect();     // Catch: Throwable -> L11
        t0.a(new c(this));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final void disconnect() {
        this.f319678c.incrementAndGet();
        final WebSocket r100 = this.f319680e;
        this.f319680e = null;
        if (r100 == null) goto L6;
        t0.a(new b(r100));
        return;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final BrowserTransport.FrameSource a() {
        return BrowserTransport.FrameSource.CDP_SCREENCAST;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final BrowserTransport.EndpointMode c() {
        return this.f319677b;
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "endpoint");
        this.f319676a = r100;
        this.f319677b = BrowserTransport.EndpointMode.BROWSER;
        this.f319678c = new AtomicInteger();
        this.f319679d = new OkHttpClient.Builder().pingInterval(15, TimeUnit.SECONDS).readTimeout(0, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(false).followSslRedirects(false).build();
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final void b(com.larus.browsertakeover.cdp.a r110) {
        Intrinsics.checkNotNullParameter(r110, "listener");
        disconnect();
        if (this.f319681f == false) goto L6;
        r110.onError();
        return;
    L6:
        com.larus.browsertakeover.transport.a r100 = com.larus.browsertakeover.transport.a.f319669a;
        String r101 = this.f319676a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "rawEndpoint");
        String r102 = StringsKt.trim(r101).toString();
        boolean r103 = true;
        if (r102.length() != 0) goto L9;
        boolean r104 = true;
    L10:
        String r105 = null;
        if (r104 == true) goto L120;
        if (r102.length() > 8192) goto L120;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        Object r107 = Result.m9449constructorimpl(new URI(r102));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r107) == false) goto L22;
        r107 = null;
    L22:
        URI r108 = (URI) r107;
        if (r108 == null) goto L120;
        String r109 = r108.getHost();
        if (r109 != null) goto L28;
    L31:
        boolean r111 = true;
    L32:
        if (r111 == true) goto L120;
        String r112 = r108.getScheme();
        if (r112 == null) goto L37;
        String r113 = r112.toLowerCase(Locale.US);
    L39:
        if (Intrinsics.areEqual(r113, "wss") == true) goto L44;
        if (Intrinsics.areEqual(r113, "ws") == false) goto L120;
    L44:
        if (r108.getUserInfo() != null) goto L120;
        if (r108.getFragment() != null) goto L120;
        Object r114 = Result.m9449constructorimpl(UriProtector.parse(r102));     // Catch: Throwable -> L50
    L53:
        if (Result.m9455isFailureimpl(r114) == false) goto L55;
        r114 = null;
    L55:
        Uri r115 = (Uri) r114;
        if (r115 == null) goto L120;
        Object r116 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r115, "token"));     // Catch: Throwable -> L60
    L63:
        if (Result.m9455isFailureimpl(r116) == false) goto L65;
        r116 = null;
    L65:
        String r117 = (String) r116;
        if (r117 != null) goto L68;
    L75:
        r117 = null;
    L76:
        String r118 = r108.getPath();
        if (r118 != null) goto L80;
        r118 = "";
    L80:
        if (StringsKt.startsWith$default(r118, "/devtools/browser/", false, 2, null) == false) goto L89;
        int r119 = StringsKt.substringAfterLast$default(r118, '/', null, 2, null).length();
        if (1 <= r119) goto L84;
    L86:
        boolean r120 = false;
    L87:
        if (r120 == false) goto L89;
        boolean r121 = true;
    L90:
        if (r117 != null) goto L93;
        if (r121 == false) goto L120;
    L93:
        if (r117 == null) goto L110;
        int r122 = 0;
    L96:
        if (r122 >= r117.length()) goto L107;
        char r123 = r117.charAt(r122);
        if (r123 != '\r') goto L100;
    L103:
        boolean r124 = true;
    L104:
        if (r124 == true) goto L105;
        r122 = r122 + 1;
        goto L96
    L105:
        boolean r125 = true;
    L108:
        if (r125 != true) goto L110;
        boolean r126 = true;
    L111:
        if (r126 == true) goto L120;
        Uri.Builder r127 = r115.buildUpon().scheme("wss");
        gd9.l r128 = FlowRuntime.a();
        Intrinsics.checkNotNull(r127);
        com.larus.browsertakeover.transport.a.a(r115, r127, "aid", String.valueOf(r128.appId()));
        com.larus.browsertakeover.transport.a.a(r115, r127, "device_id", StringsKt.take(com.larus.platform.service.o.f365780a.getDeviceId(), 256));
        com.larus.browsertakeover.transport.a.a(r115, r127, "platform", "android");
        com.larus.browsertakeover.transport.a.a(r115, r127, "version", StringsKt.take(r128.m(), 256));
        com.larus.browsertakeover.transport.a.a(r115, r127, "use-olympus-account", "1");
        com.larus.browsertakeover.transport.a.a(r115, r127, "webTabId", UUID.randomUUID().toString());
        String r129 = r127.build().toString();
        if (r129.length() <= 8192) goto L117;
        r103 = false;
    L117:
        if (r103 == false) goto L120;
        r105 = r129;
        goto L120
    L100:
        if (r123 == '\n') goto L103;
        r124 = false;
        goto L104
    L107:
        r125 = false;
    L110:
        r126 = false;
        goto L111
    L84:
        if (r119 >= 1025) goto L86;
        r120 = true;
    L89:
        r121 = false;
        goto L90
    L68:
        if ((!StringsKt.isBlank(r117)) == true) goto L70;
    L72:
        boolean r130 = false;
    L73:
        if (r130 == false) goto L75;
    L70:
        if (r117.length() > 1024) goto L72;
        r130 = true;
    L60:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L50:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L53
    L37:
        r113 = null;
        goto L39
    L28:
        if (StringsKt.isBlank(r109) == true) goto L31;
        r111 = false;
    L17:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L120:
        if (r105 != null) goto L123;
        FLogger.f375446a.e("CloudWebSocketTransport", "Rejected invalid browser endpoint");
        r110.onError();
        return;
    L123:
        int r134 = this.f319678c.incrementAndGet();
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L130
        Request.Builder r136 = new Request.Builder().url(r105);     // Catch: Throwable -> L130
        com.larus.browsertakeover.transport.a.f319669a.getClass();     // Catch: Throwable -> L130
        Iterator r137 = com.larus.browsertakeover.transport.a.b().entrySet().iterator();     // Catch: Throwable -> L130
    L126:
        if (r137.hasNext() == false) goto L128;
        Map.Entry r138 = (Map.Entry) r137.next();     // Catch: Throwable -> L130
        r136.header((String) r138.getKey(), (String) r138.getValue());     // Catch: Throwable -> L130
        goto L126
    L128:
        Object r139 = Result.m9449constructorimpl(r136.build());     // Catch: Throwable -> L130
    L132:
        Throwable r140 = Result.m9452exceptionOrNullimpl(r139);
        if (r140 != null) goto L136;
        this.f319680e = this.f319679d.newWebSocket((Request) r139, new e(this, r134, r110));
        return;
    L136:
        FLogger.f375446a.e("CloudWebSocketTransport", "Could not create websocket request, type=".concat(r140.getClass().getSimpleName()));
        r110.onError();
        return;
    L130:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L132
    L9:
        r104 = false;
        goto L10
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport
    public final boolean send(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f319681f == true) goto L13;
        WebSocket r101 = this.f319680e;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r101.send(r100) != true) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }
}
