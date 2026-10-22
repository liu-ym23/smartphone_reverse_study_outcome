package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/HttpRequestTimeoutException;", "Ljava/io/IOException;", "Lio/ktor/utils/io/errors/IOException;", "", "url", "", "timeoutMillis", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lio/ktor/client/request/c;", "(Lio/ktor/client/request/c;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class HttpRequestTimeoutException extends IOException {
    public HttpRequestTimeoutException(HttpRequestBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        String r101 = r100.f491758a.c();
        s.b r102 = s.f491744a;
        Intrinsics.checkNotNullParameter(r102, "key");
        Map r103 = (Map) r100.f491763f.b(io.ktor.client.engine.d.f491644a);
        Long r104 = null;
        if (r103 == null) goto L5;
        Object r105 = r103.get(r102);
    L6:
        s.a r106 = (s.a) r105;
        if (r106 == null) goto L9;
        r104 = r106.f491745a;
    L9:
        this(r101, r104);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public HttpRequestTimeoutException(io.ktor.client.request.c r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        String r101 = r100.f491770a.f491823h;
        s.b r102 = s.f491744a;
        Intrinsics.checkNotNullParameter(r102, "key");
        Map r103 = (Map) r100.f491775f.b(io.ktor.client.engine.d.f491644a);
        Long r104 = null;
        if (r103 == null) goto L5;
        Object r105 = r103.get(r102);
    L6:
        s.a r106 = (s.a) r105;
        if (r106 == null) goto L9;
        r104 = r106.f491745a;
    L9:
        this(r101, r104);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public HttpRequestTimeoutException(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        StringBuilder r102 = new StringBuilder("Request timeout has expired [url=");
        r102.append(r100);
        r102.append(", request_timeout=");
        Object r103 = r101;
        if (r101 != null) goto L5;
        r103 = "unknown";
    L5:
        r102.append(r103);
        r102.append(" ms]");
        super(r102.toString());
    }
}
