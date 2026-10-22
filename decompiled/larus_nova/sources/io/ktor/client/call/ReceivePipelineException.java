package io.ktor.client.call;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lio/ktor/client/call/ReceivePipelineException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "Lio/ktor/client/call/HttpClientCall;", "request", "Lio/ktor/client/call/HttpClientCall;", "getRequest", "()Lio/ktor/client/call/HttpClientCall;", "Lisc/a;", "info", "Lisc/a;", "getInfo", "()Lisc/a;", "", "cause", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lisc/a;Ljava/lang/Throwable;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0})
public final class ReceivePipelineException extends IllegalStateException {
    private final Throwable cause;
    private final isc.a info;
    private final HttpClientCall request;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public final isc.a getInfo() {
        return this.info;
    }

    public final HttpClientCall getRequest() {
        return this.request;
    }

    public ReceivePipelineException(HttpClientCall r100, isc.a r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "cause");
        super("Fail to run receive pipeline: " + r102);
        this.request = r100;
        this.info = r101;
        this.cause = r102;
    }
}
