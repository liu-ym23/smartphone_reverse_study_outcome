package io.ktor.client.plugins;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lio/ktor/client/plugins/ClientRequestException;", "Lio/ktor/client/plugins/ResponseException;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Lio/ktor/client/statement/b;", "response", "cachedResponseText", "<init>", "(Lio/ktor/client/statement/b;Ljava/lang/String;)V", "(Lio/ktor/client/statement/b;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class ClientRequestException extends ResponseException {
    private final String message;

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please, provide response text in constructor")
    public ClientRequestException(io.ktor.client.statement.b r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        this(r100, "<no response text provided>");
    }

    public ClientRequestException(io.ktor.client.statement.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "cachedResponseText");
        super(r100, r101);
        this.message = "Client request(" + r100.a80().c().getMethod().f491908a + ' ' + r100.a80().c().getUrl() + ") invalid: " + r100.d() + ". Text: \"" + r101 + Typography.quote;
    }
}
