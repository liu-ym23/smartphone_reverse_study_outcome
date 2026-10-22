package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.x;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0000H\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u000e"}, d2 = {"Lio/ktor/websocket/ProtocolViolationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlinx/coroutines/x;", "createCopy", "", "violation", "Ljava/lang/String;", "getViolation", "()Ljava/lang/String;", "getMessage", "message", "<init>", "(Ljava/lang/String;)V", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public final class ProtocolViolationException extends Exception implements x<ProtocolViolationException> {
    private final String violation;

    @Override // kotlinx.coroutines.x
    public ProtocolViolationException createCopy() {
        ProtocolViolationException r100 = new ProtocolViolationException(this.violation);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(this, "cause");
        r100.initCause(this);
        return r100;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Received illegal frame: " + this.violation;
    }

    public final String getViolation() {
        return this.violation;
    }

    @Override // kotlinx.coroutines.x
    public /* bridge */ /* synthetic */ Throwable createCopy() {
        return createCopy();
    }

    public ProtocolViolationException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "violation");
        this.violation = r100;
    }
}
